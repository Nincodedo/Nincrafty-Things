package com.nincodedo.nincraftythings.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.nincodedo.nincraftythings.reference.ConfigurationNincrafty;
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

	private static void loadConfiguration() {

		loadGeneralConfigs();
		loadNincodiumArmorConfigs();
		loadSillyConfigs();

		if (configuration.hasChanged()) {
			configuration.save();
		}
	}

	private static void loadSillyConfigs() {
		Settings.Silly.thunderList = configuration.getStringList("thunderList",
				ConfigurationNincrafty.CATEGORY_SILLY, new String[] {
						"Nincodedo", "Undead_Zeratul" }, "Thundertastic");

	}

	private static void loadNincodiumArmorConfigs() {
		Settings.Armor.enableNincodiumArmor = configuration.getBoolean(
				"enableNincodiumArmor",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR, true,
				"Nincodium armor recipes");
		Settings.Armor.nincodiumArmorHealingPercentage = configuration
				.getFloat("nincodiumArmorHealingPercentage",
						ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR, 0.14F,
						0F, 1F,
						"Percent of damage dealt healing set bonus of Nincodium armor");
		Settings.Armor.nincodiumArmorHealingRadius = configuration.getFloat(
				"nincodiumArmorHealingRadius",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR, 5, 1, 10,
				"Radius of healing set bonus of Nincodium armor");
		Settings.Armor.nincodiumArmorHealingChance = configuration.getFloat(
				"nincodiumArmorHealingChance",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR, 0.25F, 0F, 1F,
				"Percent chance the armor set bonus has to heal you");
		Settings.Armor.nincodiumDurability = configuration.getInt(
				"nincodiumDurability",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR, 650, 1, 5000,
				"Nincodium armor durability");

		Settings.Armor.nincodiumEnchantability = configuration.getInt(
				"nincodiumEnchantability",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR, 12, 1, 25,
				"Enchantability of armor");

		Settings.Armor.canHealSelf = configuration
				.getBoolean("canHealSelf",
						ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR, false,
						"Armor set bonus can helf self, if false can only heal other players");

		Settings.Armor.nincodiumHelmetDamageReduction = configuration.getInt(
				"nincodiumHelmetDamageReduction",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR_REDUCTION, 3,
				1, 11, "");

		Settings.Armor.nincodiumChestplateDamageReduction = configuration
				.getInt("nincodiumChestplateDamageReduction",
						ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR_REDUCTION,
						8, 1, 16, "");

		Settings.Armor.nincodiumLeggingsDamageReduction = configuration.getInt(
				"nincodiumLeggingsDamageReduction",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR_REDUCTION, 6,
				1, 15, "");

		Settings.Armor.nincodiumBootsDamageReduction = configuration.getInt(
				"nincodiumBootsDamageReduction",
				ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR_REDUCTION, 3,
				1, 13, "");
	}

	private static void loadGeneralConfigs() {
		Settings.Items.enableNincodiumIngot = configuration.getBoolean(
				"enableNincodiumIngot", Configuration.CATEGORY_GENERAL, true,
				"Nincodium ingot recipe");
		Settings.Items.enableNincodiumTools = configuration.getBoolean(
				"enableNincodiumTools", Configuration.CATEGORY_GENERAL, true,
				"Nincodium tool recipes");
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(
			ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}

}
