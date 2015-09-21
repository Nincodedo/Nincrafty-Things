package com.nincodedo.nincraftythings.tweaks;

import java.util.List;

import com.nincodedo.nincraftythings.utility.LogHelper;
import com.pahimar.ee3.item.crafting.RecipeAludel;
import com.pahimar.ee3.recipe.AludelRecipeManager;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class NincraftyEE3Tweaks {
	public static void init() {
		if (Loader.isModLoaded("EE3")) {
			try {
				List<RecipeAludel> aludelRecipeList = ReflectionHelper.getPrivateValue(AludelRecipeManager.class,
						AludelRecipeManager.getInstance(), "aludelRecipes");
				for (int i = 0; i < aludelRecipeList.size(); i++) {
					if (aludelRecipeList.get(i).getRecipeOutput().getItem().equals(com.pahimar.ee3.init.ModItems.alchemicalTome)) {
						aludelRecipeList.remove(i);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
