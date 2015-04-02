package com.nincodedo.nincraftythings.handler;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.nincodedo.nincraftythings.init.ModItems;

public class ChestGenHandler {
	public static void init() {
		String c = ChestGenHooks.DUNGEON_CHEST;
		if(Settings.Items.enableJimmysSword){
		ChestGenHooks.addItem(c, new WeightedRandomChestContent(new ItemStack(
				ModItems.jimmysSword), 1, 1, Settings.Items.jimmysSwordChestRarity));
		}
	}
}
