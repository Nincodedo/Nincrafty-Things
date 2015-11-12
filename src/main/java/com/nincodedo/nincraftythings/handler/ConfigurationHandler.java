package com.nincodedo.nincraftythings.handler;

import java.io.File;

import com.nincodedo.nincraftythings.reference.ConfigurationNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;
import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

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
		loadNincodiumToolsConfigs(ConfigurationNincrafty.CATEGORY_NINCODIUM_TOOLS);
		loadJimmydriteToolsConfigs(ConfigurationNincrafty.CATEGORY_JIMMYDRITE_TOOLS);
		loadAbilityConfigs(ConfigurationNincrafty.CATEGORY_ABILITIES);
		loadSillyConfigs(ConfigurationNincrafty.CATEGORY_SILLY);
		loadTweakConfigs(ConfigurationNincrafty.CATEGORY_TWEAKS);

		if (configuration.hasChanged()) {
			configuration.save();
		}
	}

	private static void loadNincodiumToolsConfigs(String categoryNincodiumTools) {
		Settings.Tools.nincodiumHarvestLevel = configuration.getInt("nincodiumHarvestLevel", categoryNincodiumTools, 5,
				1, 10, "");
		Settings.Tools.nincodiumDurability = configuration.getInt("nincodiumDurability", categoryNincodiumTools, 1989,
				1, 2000, "");
		Settings.Tools.nincodiumEfficiency = configuration.getFloat("nincodiumEfficiency", categoryNincodiumTools, 12,
				1, 15, "");
		Settings.Tools.nincodiumDamage = configuration.getFloat("nincodiumDamage", categoryNincodiumTools, 3, 1, 10,
				"");
		Settings.Tools.nincodiumEnchantability = configuration.getInt("nincodiumEnchantability", categoryNincodiumTools,
				10, 1, 10, "");
	}

	private static void loadJimmydriteToolsConfigs(String categoryJimmydriteTools) {
		Settings.Tools.jimmydriteHarvestLevel = configuration.getInt("jimmydriteHarvestLevel", categoryJimmydriteTools,
				5, 1, 10, "");
		Settings.Tools.jimmydriteDurability = configuration.getInt("jimmydriteDurability", categoryJimmydriteTools,
				1989, 1, 2000, "");
		Settings.Tools.jimmydriteEfficiency = configuration.getFloat("jimmydriteEfficiency", categoryJimmydriteTools,
				12, 1, 15, "");
		Settings.Tools.jimmydriteDamage = configuration.getFloat("jimmydriteDamage", categoryJimmydriteTools, 3, 1, 10,
				"");
		Settings.Tools.jimmydriteEnchantability = configuration.getInt("jimmydriteEnchantability",
				categoryJimmydriteTools, 10, 1, 10, "");
	}

	private static void loadTweakConfigs(String category) {
		Settings.Tweaks.enableEE3Tweaks = configuration.getBoolean("enableEE3Tweaks", category, true, "");
		Settings.Tweaks.oreDictionaryAdditions = configuration.getStringList("oreDictionaryAdditions", category,
				new String[] {}, "Add items to the ore dictionary formatted as modID|itemName|oreDictionaryName");
	}

	private static void loadNincodiumArmorReductionConfigs(String category) {
		Settings.Armor.nincodiumHelmetDamageReduction = configuration.getInt("nincodiumHelmetDamageReduction", category,
				3, 1, 11, "");

		Settings.Armor.nincodiumChestplateDamageReduction = configuration.getInt("nincodiumChestplateDamageReduction",
				category, 8, 1, 16, "");

		Settings.Armor.nincodiumLeggingsDamageReduction = configuration.getInt("nincodiumLeggingsDamageReduction",
				category, 6, 1, 15, "");

		Settings.Armor.nincodiumBootsDamageReduction = configuration.getInt("nincodiumBootsDamageReduction", category,
				3, 1, 13, "");
	}

	private static void loadAbilityConfigs(String category) {
		Settings.Abilities.canProc = configuration.getBoolean("canProc", category, true,
				"Using Jimmy's Sword will proc. (All credit for the proc and idea goes to Rob Moran creator of Dwarves VS Zombies)");
		Settings.Abilities.canJimmyPvP = configuration.getBoolean("canJimmyPvP", category, false,
				"Allows Jimmy's Sword to attack other players");
	}

	private static void loadSillyConfigs(String category) {
		Settings.Silly.thunderList = configuration.getStringList("thunderList", category,
				new String[] { "Nincodedo", "Undead_Zeratul" }, "Thundertastic");
		Settings.Silly.moonPhasesOPPlzNerf = configuration.getBoolean("moonPhasesOPPlzNerf", category, true,
				"Moon phases cause shenanigans");
		Settings.Silly.minMoonDamage = configuration.getFloat("minMoonDamage", category, 0.7F, 0F, 10F,
				"Minimum moon damage multiplier");
		Settings.Silly.maxMoonDamage = configuration.getFloat("maxMoonDamage", category, 1.15F, 0F, 10F,
				"Maximum moon damage multiplier");
	}

	private static void loadNincodiumArmorConfigs(String category) {
		Settings.Armor.enableNincodiumArmor = configuration.getBoolean("enableNincodiumArmor", category, true,
				"Nincodium armor recipes");
		Settings.Armor.nincodiumArmorHealingPercentage = configuration.getFloat("nincodiumArmorHealingPercentage",
				category, 0.14F, 0F, 1F, "Percent of damage dealt healing set bonus of Nincodium armor");
		Settings.Armor.nincodiumArmorHealingRadius = configuration.getFloat("nincodiumArmorHealingRadius", category, 5,
				1, 10, "Radius of healing set bonus of Nincodium armor");
		Settings.Armor.nincodiumArmorHealingChance = configuration.getFloat("nincodiumArmorHealingChance", category,
				0.25F, 0F, 1F, "Percent chance the armor set bonus has to heal you");
		Settings.Armor.nincodiumDurability = configuration.getInt("nincodiumDurability", category, 650, 1, 5000,
				"Nincodium armor durability");

		Settings.Armor.nincodiumEnchantability = configuration.getInt("nincodiumEnchantability", category, 12, 1, 25,
				"Enchantability of armor");

		Settings.Armor.canHealSelf = configuration.getBoolean("canHealSelf", category, false,
				"Armor set bonus can helf self, if false can only heal other players");
	}

	private static void loadGeneralConfigs(String category) {
		Settings.Blocks.enableNincodiumOreSmelting = configuration.getBoolean("enableNincodiumOreSmelting", category,
				true, "Smelting recipe for Nincodium Ore to ingots");
		Settings.Items.enableNincodiumIngot = configuration.getBoolean("enableNincodiumIngot", category, true,
				"Nincodium ingot recipe");
		Settings.Items.enableNincodiumTools = configuration.getBoolean("enableNincodiumTools", category, true,
				"Nincodium tool recipes");
		Settings.Items.enableJimmysSword = configuration.getBoolean("enableJimmysSword", category, true,
				"Jimmy's Sword can be found in chests");
		Settings.Items.jimmysSwordChestRarity = configuration.getInt("jimmysSwordChestRarity", category, 3, 1, 100,
				"Dungeon chest rarity of Jimmy's Sword");
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}

}
