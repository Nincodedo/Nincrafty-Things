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
					&& isUsingJimmysSword(player)) {
				if (!player.worldObj.isRemote) {
					player.worldObj.playSoundEffect(player.posX, player.posY,
							player.posZ, "mob.wither.hurt", 1, 1);
					player.addPotionEffect(new PotionEffect(5, 100, 9));
					player.addPotionEffect(new PotionEffect(1, 100, 2));
				}
			}
		}
	}

	private boolean isUsingJimmysSword(EntityPlayer player) {
		return player.getCurrentEquippedItem().getItem()
				.equals(ModItems.jimmysSword);
	}
}
