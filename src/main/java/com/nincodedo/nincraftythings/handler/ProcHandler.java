package com.nincodedo.nincraftythings.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.nincodedo.nincraftythings.NincraftyThings;
import com.nincodedo.nincraftythings.api.item.IProcBuff;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ProcHandler {

	@SubscribeEvent
	public void procOnDeath(LivingDeathEvent event) {
		if (Settings.Abilities.canProc
				&& event.source.getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.source.getEntity();
			if (!player.isEntityEqual(event.entity) && isUsingProcSword(player)) {
				NincraftyThings.proxy.spawnParticle(Names.Particles.greenSparkles,
						player.posX, player.posY + 1.4, player.posZ, 1.3, 1.3,
						1.3);
				NincraftyThings.proxy.spawnParticle(Names.Particles.greenSparkles,
						player.posX, player.posY + 1.4, player.posZ, 0.3, 0.3,
						0.3);
				if (!player.worldObj.isRemote) {
					player.worldObj.playSoundEffect(player.posX, player.posY,
							player.posZ, Names.Sounds.procAttack, 1, 1);
					player.addPotionEffect(new PotionEffect(5, 100, 9));
					player.addPotionEffect(new PotionEffect(1, 100, 2));
				}
			}

		}
	}

	@SubscribeEvent
	public void jimmysSwordPvP(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayerMP
				&& event.entity instanceof EntityPlayerMP
				&& isUsingProcSword((EntityPlayerMP) event.source.getEntity())
				&& !Settings.Abilities.canJimmyPvP) {
			event.setCanceled(true);
		}
	}

	private boolean isUsingProcSword(EntityPlayer player) {
		if (player.getCurrentEquippedItem() != null
				&& player.getCurrentEquippedItem().getItem() != null)
			return player.getCurrentEquippedItem().getItem() instanceof IProcBuff;
		return false;
	}
}
