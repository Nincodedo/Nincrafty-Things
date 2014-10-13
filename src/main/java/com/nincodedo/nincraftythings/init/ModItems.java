package com.nincodedo.nincraftythings.init;

import com.nincodedo.nincraftythings.armor.ItemArmorNincodium;
import com.nincodedo.nincraftythings.armor.ItemArmorNincrafty;
import com.nincodedo.nincraftythings.item.ItemNincodiumIngot;
import com.nincodedo.nincraftythings.item.ItemNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;
import com.nincodedo.nincraftythings.tool.ItemNincodiumPickaxe;
import com.nincodedo.nincraftythings.tool.ItemPickaxeNincrafty;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static final ItemNincrafty nincodiumIngot = new ItemNincodiumIngot();
	public static final ItemPickaxeNincrafty nincodiumPickaxe = new ItemNincodiumPickaxe();
	public static final ItemArmorNincrafty nincodiumHelmet = new ItemArmorNincodium(
			0);
	public static final ItemArmorNincrafty nincodiumChestplate = new ItemArmorNincodium(
			1);
	public static final ItemArmorNincrafty nincodiumLeggings = new ItemArmorNincodium(
			2);
	public static final ItemArmorNincrafty nincodiumBoots = new ItemArmorNincodium(
			3);

	public static void init() {
		GameRegistry.registerItem(nincodiumIngot, "nincodiumIngot");
		GameRegistry.registerItem(nincodiumPickaxe, "nincodiumPickaxe");
		GameRegistry.registerItem(nincodiumHelmet, "nincodiumHelmet");
		GameRegistry.registerItem(nincodiumChestplate, "nincodiumChestplate");
		GameRegistry.registerItem(nincodiumLeggings, "nincodiumLeggings");
		GameRegistry.registerItem(nincodiumBoots, "nincodiumBoots");
	}
}
