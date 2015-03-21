package com.nincodedo.nincraftythings.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material {
	public static final class Armor {
		public static final ItemArmor.ArmorMaterial NINCODIUM = EnumHelper
				.addArmorMaterial(
						Names.Materials.NINCODIUM,
						Settings.Armor.nincodiumDurability,
						new int[] {
								Settings.Armor.nincodiumHelmetDamageReduction,
								Settings.Armor.nincodiumChestplateDamageReduction,
								Settings.Armor.nincodiumLeggingsDamageReduction,
								Settings.Armor.nincodiumBootsDamageReduction },
						Settings.Armor.nincodiumEnchantability);
	}

	public static final class Tools {
		public static final Item.ToolMaterial NINCODIUM = EnumHelper
				.addToolMaterial(Names.Materials.NINCODIUM, 5, 1989, 12, 3, 10);
		public static final Item.ToolMaterial JIMMYDRITE = EnumHelper
				.addToolMaterial(Names.Materials.JIMMYDRITE, 5, 200, 7, 3, 7);
	}
}
