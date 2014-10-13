package com.nincodedo.nincraftythings.events;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Settings;
import com.nincodedo.nincraftythings.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ArmorSetBonusHook {

	private int healDivisor = Settings.Items.nincodiumArmorHealingDivisor;
	private float healRadius = Settings.Items.nincodiumArmorHealingRadius;

	@SubscribeEvent
	public void entityAttacked(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayerMP) {
			LogHelper.info("Event fired");
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if (isWearingNincodiumArmorSet(player)) {
				List players = Minecraft.getMinecraft().theWorld.playerEntities;
				EntityClientPlayerMP closestPlayer = getClosestPlayerToEntityWithLeastHealth(
						player, healRadius);
				if (closestPlayer != null && event.entityLiving.getHealth() > 0) {
					float healed = event.ammount / healDivisor;
					closestPlayer.setHealth(closestPlayer.getHealth()
							+ (healed));
					closestPlayer.playSound("random.levelup", 1, 2);
				}
			}
		}
	}

	private EntityClientPlayerMP getClosestPlayerToEntityWithLeastHealth(
			EntityPlayer player, double healRadius2) {
		return getClosestPlayerWithLeastHealth(player.posX, player.posY,
				player.posZ, healRadius2);
	}

	private EntityClientPlayerMP getClosestPlayerWithLeastHealth(double p_72977_1_,
			double p_72977_3_, double p_72977_5_, double p_72977_7_) {
		double d4 = -1.0D;
		EntityClientPlayerMP entityplayer = null;
		List playersNear = new ArrayList();

		for (int i = 0; i < Minecraft.getMinecraft().theWorld.playerEntities
				.size(); ++i) {
			EntityPlayer entityplayer1 = (EntityPlayer) Minecraft
					.getMinecraft().theWorld.playerEntities.get(i);
			double d5 = entityplayer1.getDistanceSq(p_72977_1_, p_72977_3_,
					p_72977_5_);
			if ((p_72977_7_ < 0.0D || d5 < p_72977_7_ * p_72977_7_)
					&& (d4 == -1.0D || d5 < d4)) {
				d4 = d5;
				playersNear.add(entityplayer1);
			}
		}
		LogHelper.info(playersNear);
		entityplayer = getLowestHPOfEntities(playersNear);

		return entityplayer;
	}

	private EntityClientPlayerMP getLowestHPOfEntities(List<EntityClientPlayerMP> playersNear) {
		float lowestHP = 21;
		EntityClientPlayerMP lowestPlayer = null;
		for (EntityClientPlayerMP player : playersNear) {
			if (player.getHealth() < lowestHP) {
				lowestPlayer = player;
				lowestHP = player.getHealth();
			}
		}
		return lowestPlayer;
	}

	private boolean isWearingNincodiumArmorSet(EntityPlayer player) {
		boolean armor = true;
		ArrayList<ItemStack> armorSet = new ArrayList();
		armorSet.add(new ItemStack(ModItems.nincodiumBoots));
		armorSet.add(new ItemStack(ModItems.nincodiumLeggings));
		armorSet.add(new ItemStack(ModItems.nincodiumChestplate));
		armorSet.add(new ItemStack(ModItems.nincodiumHelmet));
		for (int i = 1; i <= 4; i++) {
			try {
				if (!player.getEquipmentInSlot(i).getItem()
						.equals(armorSet.get(i - 1).getItem())) {
					armor = false;
				}
			} catch (Exception e) {
				armor = false;
			}

		}
		return armor;
	}
}
