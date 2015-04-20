package com.nincodedo.nincraftythings.handler;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.nincodedo.nincraftythings.armor.ItemArmorNincodium;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ArmorSetBonusHandler {

	private float healPercentage = Settings.Armor.nincodiumArmorHealingPercentage;
	private float healRadius = Settings.Armor.nincodiumArmorHealingRadius;
	private float healingChance = Settings.Armor.nincodiumArmorHealingChance;
	private boolean canHealSelf = Settings.Armor.canHealSelf;

	@SubscribeEvent
	public void entityAttacked(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.source.getEntity();
			if (!player.isEntityEqual(event.entity)
					&& isWearingNincodiumArmorSet(player)
					&& isHealingChanceSuccessful(player)) {
				EntityPlayerMP closestPlayer = getClosestPlayerToEntityWithLeastHealth(
						player, healRadius);

				if (closestPlayer != null
						&& event.entityLiving.getHealth() > 0
						&& closestPlayer.getHealth() < closestPlayer
								.getMaxHealth()) {
					float healed = event.ammount * healPercentage;
					closestPlayer.setHealth(closestPlayer.getHealth()
							+ (healed));
					if (!closestPlayer.worldObj.isRemote) {
						closestPlayer.worldObj.playSoundEffect(
								closestPlayer.posX, closestPlayer.posY,
								closestPlayer.posZ, Names.Sounds.HEALING, 1, 2);
					}
				}
			}
		}
	}

	private boolean isHealingChanceSuccessful(EntityPlayerMP player) {
		return player.getRNG().nextFloat() < healingChance;
	}

	private EntityPlayerMP getClosestPlayerToEntityWithLeastHealth(
			EntityPlayerMP player, double healRadius2) {
		return getClosestPlayerWithLeastHealth(player, player.posX,
				player.posY, player.posZ, healRadius2);
	}

	private EntityPlayerMP getClosestPlayerWithLeastHealth(
			EntityPlayerMP player, double posX, double posY, double posZ,
			double radius) {
		double d4 = -1.0D;
		EntityPlayerMP entityplayer = null;
		List playersNear = new ArrayList();
		List playersInDimension = null;
		WorldServer[] worlds = MinecraftServer.getServer().worldServers;

		for (int i = 0; i < worlds.length; i++) {
			if (worlds[i].provider.dimensionId == player.dimension) {
				playersInDimension = worlds[i].playerEntities;
			}
		}

		for (int i = 0; i < playersInDimension.size(); ++i) {
			EntityPlayerMP entityplayer1 = (EntityPlayerMP) playersInDimension
					.get(i);
			double d5 = entityplayer1.getDistanceSq(posX, posY, posZ);
			if ((radius < 0.0D || d5 < radius * radius)
					&& (d4 == -1.0D || d5 < d4)) {
				d4 = d5;
				playersNear.add(entityplayer1);
			}
		}

		if (!canHealSelf && playersNear.contains(player)) {
			playersNear.remove(player);
		}
		entityplayer = getLowestHPOfEntities(playersNear);

		return entityplayer;
	}

	private EntityPlayerMP getLowestHPOfEntities(
			List<EntityPlayerMP> playersNear) {
		float lowestHP = Float.MAX_VALUE;

		EntityPlayerMP lowestPlayer = null;
		for (EntityPlayerMP player : playersNear) {
			if (player.getHealth() < lowestHP) {
				lowestPlayer = player;
				lowestHP = player.getHealth();
			}
		}
		return lowestPlayer;
	}

	private boolean isWearingNincodiumArmorSet(EntityPlayerMP player) {
		boolean hasArmorSet = true;
		for (int i = 0; i < 4; i++) {
			if (!ItemArmorNincodium.hasArmorSetItem(player, i)) {
				hasArmorSet = false;
				break;
			}
		}
		return hasArmorSet;
	}
}
