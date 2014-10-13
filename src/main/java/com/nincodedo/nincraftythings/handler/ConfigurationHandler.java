package com.nincodedo.nincraftythings.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

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

		// Create configs here
		Settings.Items.enableNincodiumIngot = configuration.getBoolean(
				"enableNincodiumIngot", Configuration.CATEGORY_GENERAL, true,
				"Nincodium ingot recipe");
		Settings.Items.enableNincodiumArmor = configuration.getBoolean(
				"enableNincodiumArmor", Configuration.CATEGORY_GENERAL, true,
				"Nincodium armor recipes");
		Settings.Items.enableNincodiumTools = configuration.getBoolean(
				"enableNincodiumTools", Configuration.CATEGORY_GENERAL, true,
				"Nincodium tool recipes");
		Settings.Items.nincodiumArmorHealingDivisor = configuration.getInt(
				"nincodiumArmorHealingDivisor", Configuration.CATEGORY_GENERAL,
				7, 1, 20,
				"Attack divided to get healing set bonus of Nincodium armor");
		Settings.Items.nincodiumArmorHealingRadius = configuration.getFloat(
				"nincodiumArmorHealingRadius", Configuration.CATEGORY_GENERAL,
				5, 1, 10, "Radius of healing set bonus of Nincodium armor");
		if (configuration.hasChanged()) {
			configuration.save();
		}
	}

}
