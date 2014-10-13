package com.nincodedo.nincraftythings.events;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ArmorSetBonusHook {

	private int healDivider = 7;
	private double healRadius = 5;

	@SubscribeEvent
	public void entityAttacked(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayerMP) {
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if (isWearingNincodiumArmorSet(player)) {
				ChunkCoordinates ob = player.playerLocation;
				List players = Minecraft.getMinecraft().theWorld.playerEntities;
				EntityPlayer closestPlayer = getClosestPlayerToEntityWithLeastHealth(
						player, healRadius);
				if (closestPlayer != null) {
					float healed = event.ammount / healDivider;
					closestPlayer.setHealth(closestPlayer.getHealth()
							+ (healed));
				}
			}
		}
	}

	private EntityPlayer getClosestPlayerToEntityWithLeastHealth(
			EntityPlayer player, double healRadius2) {
		return getClosestPlayerWithLeastHealth(player.posX, player.posY,
				player.posZ, healRadius2);
	}

	private EntityPlayer getClosestPlayerWithLeastHealth(double p_72977_1_,
			double p_72977_3_, double p_72977_5_, double p_72977_7_) {
		double d4 = -1.0D;
		EntityPlayer entityplayer = null;
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

		entityplayer = getLowestHPOfEntities(playersNear);

		return entityplayer;
	}

	private EntityPlayer getLowestHPOfEntities(List<EntityPlayer> playersNear) {
		float lowestHP = 21;
		EntityPlayer lowestPlayer = null;
		for (EntityPlayer player : playersNear) {
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