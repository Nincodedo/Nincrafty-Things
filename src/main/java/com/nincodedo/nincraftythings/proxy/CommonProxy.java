package com.nincodedo.nincraftythings.proxy;

import com.nincodedo.nincraftythings.handler.ArmorSetBonusHandler;
import com.nincodedo.nincraftythings.handler.ConfigurationHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy {

	@Override
	public void registerEventHandlers() {
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		MinecraftForge.EVENT_BUS.register(new ArmorSetBonusHandler());
	}

}
