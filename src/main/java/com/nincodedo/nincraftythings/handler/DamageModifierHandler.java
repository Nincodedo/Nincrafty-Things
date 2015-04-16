package com.nincodedo.nincraftythings.handler;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Settings;
import com.nincodedo.nincraftythings.utility.MoonModifierDamageSource;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DamageModifierHandler {
	
	float minMoonDamage = Settings.Silly.minMoonDamage;
	float maxMoonDamage = Settings.Silly.maxMoonDamage;

	@SubscribeEvent
	public void attackedEntity(LivingAttackEvent event) {
		if (event.source.getEntity() instanceof EntityPlayerMP
				&& event.source.damageType.equals("player")
				&& Settings.Silly.moonPhasesOPPlzNerf) {
			EntityPlayerMP player = (EntityPlayerMP) event.source.getEntity();
			if (ModItems.nincodiumSword.equals(player.getHeldItem().getItem())
					&& event.entityLiving.getHealth() > 0) {
				event.setCanceled(true);
				event.entity.attackEntityFrom(
						new MoonModifierDamageSource("moonModifier", player),
						getMoonDamage(player.worldObj.getMoonPhase(),
								event.ammount));
				int itemDamage = player.getHeldItem().getItemDamage() + 1;
				player.getHeldItem().getItem()
						.setDamage(player.getHeldItem(), itemDamage);
			}
		}
	}

	private float getMoonDamage(int moonPhase, float damage) {
		return damage * (Math.abs(Math.abs(moonPhase - 3.5)-3.5)*((maxMoonDamage-minMoonDamage)/3.0F)+minMoonDamage);
	}

}
