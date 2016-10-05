package com.nincodedo.nincraftythings.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material {
	public static final class Armor {
		public static final ItemArmor.ArmorMaterial NINCODIUM = EnumHelper.addArmorMaterial(Names.Materials.NINCODIUM,
				Names.Materials.NINCODIUM, Settings.Armor.nincodiumDurability,
				new int[] { Settings.Armor.nincodiumHelmetDamageReduction,
						Settings.Armor.nincodiumChestplateDamageReduction,
						Settings.Armor.nincodiumLeggingsDamageReduction, Settings.Armor.nincodiumBootsDamageReduction },
				Settings.Armor.nincodiumEnchantability, null, 5);
	}

	public static final class Tools {
		public static final Item.ToolMaterial NINCODIUM = EnumHelper.addToolMaterial(Names.Materials.NINCODIUM,
				Settings.Tools.nincodiumHarvestLevel, Settings.Tools.nincodiumDurability,
				Settings.Tools.nincodiumEfficiency, Settings.Tools.nincodiumDamage,
				Settings.Tools.nincodiumEnchantability);
		public static final Item.ToolMaterial JIMMYDRITE = EnumHelper.addToolMaterial(Names.Materials.JIMMYDRITE,
				Settings.Tools.jimmydriteHarvestLevel, Settings.Tools.jimmydriteDurability,
				Settings.Tools.jimmydriteEfficiency, Settings.Tools.jimmydriteDamage,
				Settings.Tools.jimmydriteEnchantability);
	}
}
