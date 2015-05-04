package com.nincodedo.nincraftythings.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.nincodedo.nincraftythings.handler.ArmorSetBonusHandler;
import com.nincodedo.nincraftythings.handler.ConfigurationHandler;
import com.nincodedo.nincraftythings.handler.DamageModifierHandler;
import com.nincodedo.nincraftythings.handler.ProcHandler;
import com.nincodedo.nincraftythings.handler.ThunderJoinHandler;

import cpw.mods.fml.common.FMLCommonHandler;

public abstract class CommonProxy implements IProxy {

	public void registerEventHandlers() {
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		MinecraftForge.EVENT_BUS.register(new ArmorSetBonusHandler());
		MinecraftForge.EVENT_BUS.register(new ThunderJoinHandler());
		MinecraftForge.EVENT_BUS.register(new ProcHandler());
		MinecraftForge.EVENT_BUS.register(new DamageModifierHandler());
	}

}
