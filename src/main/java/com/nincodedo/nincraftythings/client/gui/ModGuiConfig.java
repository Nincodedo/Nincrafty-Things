package com.nincodedo.nincraftythings.client.gui;

import com.nincodedo.nincraftythings.handler.ConfigurationHandler;
import com.nincodedo.nincraftythings.reference.Reference;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig {

	public ModGuiConfig(GuiScreen parentScreen) {
		super(parentScreen,
				new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL))
						.getChildElements(),
				Reference.MOD_ID, false, false,
				GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
	}

}