package com.nincodedo.nincraftythings.handler;

import java.util.List;

import com.google.common.collect.Lists;
import com.nincodedo.nincraftythings.armor.ItemArmorNincodium;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Settings;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ArmorSetBonusHandler {

	@SubscribeEvent
	public void entityAttacked(LivingAttackEvent event) {
		if (event.getSource().getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.getSource().getEntity();
			if (!player.isEntityEqual(event.getEntity()) && isWearingNincodiumArmorSet(player)
					&& isHealingChanceSuccessful(player)) {
				EntityPlayer closestPlayer = getClosestPlayerToEntityWithLeastHealth(player,
						Settings.Armor.nincodiumArmorHealingRadius);

				if (closestPlayer != null && event.getEntityLiving().getHealth() > 0
						&& closestPlayer.getHealth() < closestPlayer.getMaxHealth()) {
					float healed = event.getAmount() * Settings.Armor.nincodiumArmorHealingPercentage;
					closestPlayer.setHealth(closestPlayer.getHealth() + (healed));
					if (!closestPlayer.worldObj.isRemote) {
						closestPlayer.playSound(new SoundEvent(new ResourceLocation("entity.wither.hurt")), 1F, 1F);
					}
				}
			}
		}
	}

	private boolean isHealingChanceSuccessful(EntityPlayerMP player) {
		return player.getRNG().nextFloat() < Settings.Armor.nincodiumArmorHealingChance;
	}

	private EntityPlayer getClosestPlayerToEntityWithLeastHealth(EntityPlayerMP player, double healRadius2) {
		return getClosestPlayerWithLeastHealth(player, player.posX, player.posY, player.posZ, healRadius2);
	}

	private EntityPlayer getClosestPlayerWithLeastHealth(EntityPlayerMP player, double posX, double posY, double posZ,
			double radius) {
		double d4 = -1.0D;
		EntityPlayer entityplayer = null;
		List<EntityPlayer> playersNear = Lists.newArrayList();
		List<EntityPlayer> playersInDimension = null;
		WorldServer[] worlds = player.getServer().worldServers;

		for (WorldServer world : worlds) {
			if (world.provider.getDimension() == player.dimension) {
				playersInDimension = world.playerEntities;
				break;
			}
		}

		for (EntityPlayer playerInDimension : playersInDimension) {
			double d5 = playerInDimension.getDistanceSq(posX, posY, posZ);
			if ((radius < 0.0D || d5 < radius * radius) && (d4 == -1.0D || d5 < d4)) {
				d4 = d5;
				playersNear.add(playerInDimension);
			}
		}

		if (!Settings.Armor.canHealSelf && playersNear.contains(player)) {
			playersNear.remove(player);
		}
		entityplayer = getLowestHPOfEntities(playersNear);

		return entityplayer;
	}

	private EntityPlayer getLowestHPOfEntities(List<EntityPlayer> playersNear) {
		float lowestHP = Float.MAX_VALUE;

		EntityPlayer lowestPlayer = null;
		for (EntityPlayer player : playersNear) {
			if (player.getHealth() < lowestHP) {
				lowestPlayer = player;
				lowestHP = player.getHealth();
			}
		}
		return lowestPlayer;
	}

	private boolean isWearingNincodiumArmorSet(EntityPlayerMP player) {
		for (int i = 0; i < 4; i++) {
			if (!ItemArmorNincodium.hasArmorSetItem(player, i)) {
				return false;
			}
		}
		return true;
	}
}
