package com.nincodedo.nincraftythings.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ProcHandler {

	@SubscribeEvent
	public void procOnDeath(LivingDeathEvent event) {
		if (Settings.Abilities.canProc
				&& event.source.getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.source.getEntity();
			if (!player.isEntityEqual(event.entity)
					&& isUsingJimmysSword(player) && !player.worldObj.isRemote) {
				player.worldObj.playSoundEffect(player.posX, player.posY,
						player.posZ, "mob.wither.hurt", 1, 1);
				player.addPotionEffect(new PotionEffect(5, 100, 9));
				player.addPotionEffect(new PotionEffect(1, 100, 2));
			}
		}
	}
	
	@SubscribeEvent
	public void jimmysSwordPvP(LivingAttackEvent event){
		if(event.source.getEntity() instanceof EntityPlayerMP && event.entity instanceof EntityPlayerMP
		&& isUsingJimmysSword(event.source.getEntity()) && !Settings.Abilities.canJimmyPvP){
			event.setCanceled(true);
			//TODO chat message to the player?
		}
	}

	private boolean isUsingJimmysSword(EntityPlayer player) {
		return ModItems.jimmysSword.equals(player.getCurrentEquippedItem()
				.getItem());
	}
}
