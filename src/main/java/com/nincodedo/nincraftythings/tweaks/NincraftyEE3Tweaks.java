package com.nincodedo.nincraftythings.tweaks;

import static com.pahimar.ee3.init.ModItems.alchemicalTome;

import java.util.List;

import com.nincodedo.nincraftythings.reference.Settings;
import com.pahimar.ee3.item.crafting.RecipeAludel;
import com.pahimar.ee3.recipe.AludelRecipeManager;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class NincraftyEE3Tweaks {
	public static void init() {
		if (Settings.Tweaks.enableEE3Tweaks) {
			try {
				List<RecipeAludel> aludelRecipeList = ReflectionHelper.getPrivateValue(AludelRecipeManager.class,
						AludelRecipeManager.getInstance(), "aludelRecipes");

				for (RecipeAludel recipe : aludelRecipeList) {
					if (recipe.getRecipeOutput().getItem().equals(alchemicalTome)) {
						aludelRecipeList.remove(recipe);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
