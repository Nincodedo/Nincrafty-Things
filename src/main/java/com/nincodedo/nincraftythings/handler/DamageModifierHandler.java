package com.nincodedo.nincraftythings.handler;

import com.nincodedo.nincraftythings.api.item.IMoonDamage;
import com.nincodedo.nincraftythings.reference.Settings;
import com.nincodedo.nincraftythings.utility.MoonModifierDamageSource;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

public class DamageModifierHandler {

	@SubscribeEvent
	public void attackedEntity(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayerMP && event.source.damageType.equals("player")
				&& Settings.Silly.moonPhasesOPPlzNerf) {
			EntityPlayerMP player = (EntityPlayerMP) event.source.getEntity();
			if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof IMoonDamage
					&& event.entityLiving.getHealth() > 0) {
				event.setCanceled(true);
				event.entity.attackEntityFrom(new MoonModifierDamageSource("moonModifier", player),
						getMoonDamage(player.worldObj.getMoonPhase(), event.ammount));
				int itemDamage = player.getHeldItem().getItemDamage() + 1;
				player.getHeldItem().getItem().setDamage(player.getHeldItem(), itemDamage);
			}
		}
	}

	/**
	 * Returns the new damage amount after going through this formula (assuming
	 * default configs) http://i.imgur.com/VjDFzQG.png This formula essentially
	 * makes moon phases 0 and 7 equal to the minumum config value, and phases 3
	 * and 4 equal to the maxinum config value. The values inbetween
	 * increase/decrease linearly. This means if you wanted moon phases 0 and 7
	 * to actually be the highest and 3 and 4 the lowest, just swap the min and
	 * max in the configs.
	 **/
	private float getMoonDamage(int moonPhase, float damage) {
		return (float) (damage * (((Math.abs(Math.abs(moonPhase - 3.5) - 3.5))
				* ((Settings.Silly.maxMoonDamage - Settings.Silly.minMoonDamage) / 3)) + Settings.Silly.minMoonDamage));
	}

}
