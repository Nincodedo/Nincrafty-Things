package com.nincodedo.nincraftythings.init;

import com.nincodedo.nincraftythings.item.ItemNincodiumIngot;
import com.nincodedo.nincraftythings.item.ItemNincodiumPickaxe;
import com.nincodedo.nincraftythings.item.ItemNincrafty;
import com.nincodedo.nincraftythings.item.ItemToolNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static final ItemNincrafty nincodiumIngot = new ItemNincodiumIngot();
	public static final ItemToolNincrafty nincodiumPickaxe = new ItemNincodiumPickaxe();

	public static void init() {
		GameRegistry.registerItem(nincodiumIngot, "nincodiumIngot");
		GameRegistry.registerItem(nincodiumPickaxe, "nincodiumPickaxe");
	}
}
