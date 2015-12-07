package com.nincodedo.nincraftythings.reference;

import java.util.Map;

public class Settings {
	public static class Armor {
		public static float nincodiumArmorHealingRadius;
		public static float nincodiumArmorHealingPercentage;
		public static boolean enableNincodiumArmor;
		public static int nincodiumDurability;
		public static int nincodiumEnchantability;
		public static int nincodiumBootsDamageReduction;
		public static int nincodiumLeggingsDamageReduction;
		public static int nincodiumChestplateDamageReduction;
		public static int nincodiumHelmetDamageReduction;
		public static float nincodiumArmorHealingChance;
		public static boolean canHealSelf;
	}

	public static class Blocks {
		public static boolean enableNincodiumOreSmelting;
	}

	public static class Botania {
		public static boolean enableOrechids;
		public static Map<String, Integer> orechidMystica;
		public static Map<String, Integer> orechidFinis;
	}

	public static class Items {
		public static boolean enableNincodiumTools;
		public static boolean enableNincodiumIngot;
		public static boolean enableJimmysSword;
		public static int jimmysSwordChestRarity;
	}

	public static class Tweaks {
		public static boolean enableEE3Tweaks;
		public static String[] oreDictionaryAdditions;
	}

	public static class Tools {
		public static int nincodiumHarvestLevel;
		public static int nincodiumDurability;
		public static float nincodiumEfficiency;
		public static float nincodiumDamage;
		public static int nincodiumEnchantability;
		public static int jimmydriteHarvestLevel;
		public static int jimmydriteDurability;
		public static float jimmydriteEfficiency;
		public static float jimmydriteDamage;
		public static int jimmydriteEnchantability;
	}

	public static class World {
		public static int twilightForestDimId;
	}
	
	public static final class Mods {
		public static String botaniaModId = "Botania";
		public static String ee3ModId = "EE3";
	}
}
