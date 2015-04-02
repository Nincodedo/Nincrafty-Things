package com.nincodedo.nincraftythings.handler;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.item.sword.ItemSwordNincodiumSword;
import com.nincodedo.nincraftythings.reference.Settings;
import com.nincodedo.nincraftythings.utility.MoonModifierDamageSource;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DamageModifierHandler {

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
		switch (moonPhase) {
		case 0:
		case 1:
			damage = damage * 0.7F;
			break;
		case 2:
		case 3:
			damage = damage * 0.85F;
			break;
		case 4:
		case 5:
			// no change in damage
			break;
		case 6:
		case 7:
			damage = damage * 1.15F;
			break;
		}
		return damage;
	}

}
