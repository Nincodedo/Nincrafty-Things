package com.nincodedo.nincraftythings.handler;

import com.nincodedo.nincraftythings.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ChestGenHandler {
	public static void init() {
		String c = ChestGenHooks.DUNGEON_CHEST;
		ChestGenHooks.addItem(c, new WeightedRandomChestContent(new ItemStack(
				ModItems.jimmysSword), 1, 1, 3));
	}
}
