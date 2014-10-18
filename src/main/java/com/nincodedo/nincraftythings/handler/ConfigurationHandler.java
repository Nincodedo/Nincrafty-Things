package com.nincodedo.nincraftythings.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.nincodedo.nincraftythings.reference.NincraftyConfiguration;
import com.nincodedo.nincraftythings.reference.Reference;
import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
	public static Configuration configuration;

	public static void init(File configFile) {
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(
			ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}

	private static void loadConfiguration() {

		// General
		Settings.Items.enableNincodiumIngot = configuration.getBoolean(
				"enableNincodiumIngot", Configuration.CATEGORY_GENERAL, true,
				"Nincodium ingot recipe");
		Settings.Items.enableNincodiumTools = configuration.getBoolean(
				"enableNincodiumTools", Configuration.CATEGORY_GENERAL, true,
				"Nincodium tool recipes");

		
		// Nincodium Armor
		Settings.Armor.enableNincodiumArmor = configuration.getBoolean(
				"enableNincodiumArmor", NincraftyConfiguration.CATEGORY_NINCODIUM_ARMOR, true,
				"Nincodium armor recipes");
		Settings.Armor.nincodiumArmorHealingPercentage = configuration.getFloat(
				"nincodiumArmorHealingPercentage", NincraftyConfiguration.CATEGORY_NINCODIUM_ARMOR,
				0.14F, 0F, 1F,
				"Attack divided to get healing set bonus of Nincodium armor");
		Settings.Armor.nincodiumArmorHealingRadius = configuration.getFloat(
				"nincodiumArmorHealingRadius", NincraftyConfiguration.CATEGORY_NINCODIUM_ARMOR,
				5, 1, 10, "Radius of healing set bonus of Nincodium armor");
		
		
		if (configuration.hasChanged()) {
			configuration.save();
		}
	}

}
