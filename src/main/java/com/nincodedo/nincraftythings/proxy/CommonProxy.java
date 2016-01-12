package com.nincodedo.nincraftythings.proxy;

import com.nincodedo.nincraftythings.handler.ArmorSetBonusHandler;
import com.nincodedo.nincraftythings.handler.ConfigurationHandler;
import com.nincodedo.nincraftythings.init.ModBlocks;
import com.nincodedo.nincraftythings.init.ModItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

public abstract class CommonProxy implements IProxy {

	@Override
	public void registerEventHandlers() {
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
		MinecraftForge.EVENT_BUS.register(new ArmorSetBonusHandler());
		ModBlocks.init();
		ModItems.init();
	}

}
