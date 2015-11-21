package com.nincodedo.nincraftythings;

import com.nincodedo.nincraftythings.botania.common.crafting.NincraftyPetalRecipes;
import com.nincodedo.nincraftythings.botania.common.lexicon.NincraftLexiconData;
import com.nincodedo.nincraftythings.handler.BucketHandler;
import com.nincodedo.nincraftythings.handler.ChestGenHandler;
import com.nincodedo.nincraftythings.handler.ConfigurationHandler;
import com.nincodedo.nincraftythings.init.ModBlocks;
import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.init.Recipes;
import com.nincodedo.nincraftythings.proxy.IProxy;
import com.nincodedo.nincraftythings.reference.Reference;
import com.nincodedo.nincraftythings.reference.Settings;
import com.nincodedo.nincraftythings.tweaks.NincraftyEE3Tweaks;
import com.nincodedo.nincraftythings.tweaks.OreDictionaryRegister;
import com.nincodedo.nincraftythings.utility.LogHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class NincraftyThings {

	@Mod.Instance(Reference.MOD_ID)
	public static NincraftyThings instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		proxy.registerEventHandlers();
		ModBlocks.init();
		ModItems.init();
		NincraftyPetalRecipes.init();
		ChestGenHandler.init();
		BucketHandler.INSTANCE.buckets.put(ModBlocks.moltenNincodiumBlock, ModItems.bucketNincodium);
		BucketHandler.INSTANCE.buckets.put(ModBlocks.moltenLapisBlock, ModItems.bucketLapis);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		OreDictionaryRegister.init();
		NincraftLexiconData.init();

		LogHelper.info("Pre Init Complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		Recipes.init();
		LogHelper.info("Init Complete");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (Settings.Tweaks.enableEE3Tweaks) {
			NincraftyEE3Tweaks.init();
		}
		LogHelper.info("Post Init Complete");
	}
}
