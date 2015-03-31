package com.nincodedo.nincraftythings.handler;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ThunderJoinHandler {

	private boolean isPlayerThundertastic(EntityPlayerMP player) {

		boolean thundery = false;

		for (int i = 0; i < Settings.Silly.thunderList.length; i++) {
			if (Settings.Silly.thunderList[i].equals(player.getDisplayName())) {
				thundery = true;
			}
		}
		return thundery;
	}

	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.entity;
			if (isPlayerThundertastic(player)) {
				event.world.spawnEntityInWorld(new EntityLightningBolt(
						event.world, player.posX, 257, player.posZ));
			}
		}
	}

}
