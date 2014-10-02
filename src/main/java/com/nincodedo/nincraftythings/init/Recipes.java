package com.nincodedo.nincraftythings.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				ModItems.nincodiumPickaxe),
					"iii",
					" s ",
					" s ", 's', "stickWood", 'i', new ItemStack(ModItems.nincodiumIngot)));
	}
}
