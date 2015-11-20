package com.nincodedo.nincraftythings.init;

import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {
	public static void init() {

		if (Settings.Blocks.enableNincodiumOreSmelting) {
			GameRegistry.addSmelting(ModBlocks.nincodiumOre, new ItemStack(ModItems.nincodiumIngot), 0.5F);
		}

		if (Settings.Items.enableNincodiumIngot) {

			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.nincodiumBlock), "iii", "iii", "iii", 'i',
					new ItemStack(ModItems.nincodiumIngot));
			GameRegistry.addRecipe(new ItemStack(ModItems.nincodiumIngot, 9), "b", 'b',
					new ItemStack(ModBlocks.nincodiumBlock));
		}

		if (Settings.Items.enableNincodiumTools) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.nincodiumPickaxe), "iii", " s ", " s ",
					's', "stickWood", 'i', new ItemStack(ModItems.nincodiumIngot)));
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.nincodiumSword), "i", "i", "s", 's',
					"stickWood", 'i', new ItemStack(ModItems.nincodiumIngot)));
		}

		if (Settings.Armor.enableNincodiumArmor) {
			GameRegistry.addRecipe(new ItemStack(ModItems.nincodiumBoots), "i i", "i i", 'i',
					new ItemStack(ModItems.nincodiumIngot));
			GameRegistry.addRecipe(new ItemStack(ModItems.nincodiumChestplate), "i i", "iii", "iii", 'i',
					new ItemStack(ModItems.nincodiumIngot));
			GameRegistry.addRecipe(new ItemStack(ModItems.nincodiumHelmet), "iii", "i i", 'i',
					new ItemStack(ModItems.nincodiumIngot));
			GameRegistry.addRecipe(new ItemStack(ModItems.nincodiumLeggings), "iii", "i i", "i i", 'i',
					new ItemStack(ModItems.nincodiumIngot));
		}

	}
}
