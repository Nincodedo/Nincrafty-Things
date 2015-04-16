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

		loadGeneralConfigs(Configuration.CATEGORY_GENERAL);
		loadNincodiumArmorConfigs(ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR);
		loadNincodiumArmorReductionConfigs(ConfigurationNincrafty.CATEGORY_NINCODIUM_ARMOR_REDUCTION);
		loadAbilityConfigs(ConfigurationNincrafty.CATEGORY_ABILITIES);
		loadSillyConfigs(ConfigurationNincrafty.CATEGORY_SILLY);

		if (configuration.hasChanged()) {
			configuration.save();
		}
	}

	private static void loadNincodiumArmorReductionConfigs(String category) {
		Settings.Armor.nincodiumHelmetDamageReduction = configuration.getInt(
				"nincodiumHelmetDamageReduction", category, 3, 1, 11, "");

		Settings.Armor.nincodiumChestplateDamageReduction = configuration
				.getInt("nincodiumChestplateDamageReduction", category, 8, 1,
						16, "");

		Settings.Armor.nincodiumLeggingsDamageReduction = configuration.getInt(
				"nincodiumLeggingsDamageReduction", category, 6, 1, 15, "");

		Settings.Armor.nincodiumBootsDamageReduction = configuration.getInt(
				"nincodiumBootsDamageReduction", category, 3, 1, 13, "");
	}

	private static void loadAbilityConfigs(String category) {
		Settings.Abilities.canProc = configuration
				.getBoolean(
						"canProc",
						category,
						true,
						"Using Jimmy's Sword will proc. (All credit for the proc and idea goes to Rob Moran creator of Dwarves VS Zombies)");
		Settings.Abilities.canJimmyPvP = configuration.getBoolean(
				"canJimmyPvP", category, false,
				"Allows Jimmy's Sword to attack other players");
	}

	private static void loadSillyConfigs(String category) {
		Settings.Silly.thunderList = configuration.getStringList("thunderList",
				category, new String[] { "Nincodedo", "Undead_Zeratul" },
				"Thundertastic");
		Settings.Silly.moonPhasesOPPlzNerf = configuration.getBoolean(
				"moonPhasesOPPlzNerf", category, true,
				"Moon phases cause shenanigans");
		Settings.Silly.minMoonDamage = configuration.getFloat("minMoonDamage",
				category, 0.7F, 0F, 10F, "Minimum moon damage modifier");
		Settings.Silly.maxMoonDamage = configuration.getFloat("maxMoonDamage",
				category, 1.15F, 0F, 10F, "Maximum moon damage modifier");
	}

	private static void loadNincodiumArmorConfigs(String category) {
		Settings.Armor.enableNincodiumArmor = configuration.getBoolean(
				"enableNincodiumArmor", category, true,
				"Nincodium armor recipes");
		Settings.Armor.nincodiumArmorHealingPercentage = configuration
				.getFloat("nincodiumArmorHealingPercentage", category, 0.14F,
						0F, 1F,
						"Percent of damage dealt healing set bonus of Nincodium armor");
		Settings.Armor.nincodiumArmorHealingRadius = configuration.getFloat(
				"nincodiumArmorHealingRadius", category, 5, 1, 10,
				"Radius of healing set bonus of Nincodium armor");
		Settings.Armor.nincodiumArmorHealingChance = configuration.getFloat(
				"nincodiumArmorHealingChance", category, 0.25F, 0F, 1F,
				"Percent chance the armor set bonus has to heal you");
		Settings.Armor.nincodiumDurability = configuration.getInt(
				"nincodiumDurability", category, 650, 1, 5000,
				"Nincodium armor durability");

		Settings.Armor.nincodiumEnchantability = configuration.getInt(
				"nincodiumEnchantability", category, 12, 1, 25,
				"Enchantability of armor");

		Settings.Armor.canHealSelf = configuration
				.getBoolean("canHealSelf", category, false,
						"Armor set bonus can helf self, if false can only heal other players");
	}

	private static void loadGeneralConfigs(String category) {
		Settings.Items.enableNincodiumIngot = configuration.getBoolean(
				"enableNincodiumIngot", category, true,
				"Nincodium ingot recipe");
		Settings.Items.enableNincodiumTools = configuration.getBoolean(
				"enableNincodiumTools", category, true,
				"Nincodium tool recipes");
		Settings.Items.enableJimmysSword = configuration.getBoolean(
				"enableJimmysSword", category, true,
				"Jimmy's Sword can be found in chests");
		Settings.Items.jimmysSwordChestRarity = configuration.getInt(
				"jimmysSwordChestRarity", category, 3, 1, 100,
				"Dungeon chest rarity of Jimmy's Sword");
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(
			ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}

}
