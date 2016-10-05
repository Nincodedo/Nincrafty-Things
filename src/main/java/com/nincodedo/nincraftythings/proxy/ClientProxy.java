package com.nincodedo.nincraftythings.proxy;

import com.nincodedo.nincraftythings.init.ModBlocks;
import com.nincodedo.nincraftythings.init.ModItems;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public ClientProxy getClientProxy() {
		return this;
	}

	@Override
	public void registerEventHandlers() {
		super.registerEventHandlers();
		ModItems.initModels();
		ModBlocks.initModels();
	}

	@Override
	public void spawnParticle(String particleName, double xCoord, double yCoord, double zCoord, double xVelocity,
			double yVelocity, double zVelocity) {
		FMLClientHandler.instance().getWorldClient().spawnParticle(EnumParticleTypes.valueOf(particleName), xCoord,
				yCoord, zCoord, xVelocity, yVelocity, zVelocity);
	}

}
