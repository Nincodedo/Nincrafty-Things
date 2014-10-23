package com.nincodedo.nincraftythings.handler;

import com.nincodedo.nincraftythings.reference.Settings;
import com.nincodedo.nincraftythings.utility.LogHelper;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ThunderJoinHandler {

	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) event.entity;
			World world = event.world;
			if (isPlayerThundertastic(player)) {
				world.spawnEntityInWorld(new EntityLightningBolt(world,
						player.posX, player.posY + 1, player.posZ));
			}
		}
	}

	private boolean isPlayerThundertastic(EntityPlayerMP player) {

		boolean thundery = false;

		for (int i = 0; i < Settings.Silly.thunderList.length; i++) {
			if (Settings.Silly.thunderList[i].equals(player.getDisplayName())) {
				thundery = true;
			}
		}
		return thundery;
	}

}
