package com.nincodedo.nincraftythings.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Reference;

public class CreativeTabNincrafty {
	public static final CreativeTabs NINCRAFTY_TAB = new CreativeTabs(
			Reference.MOD_ID.toLowerCase()) {

		@Override
		public Item getTabIconItem() {
			return ModItems.nincodiumIngot;
		}
	};

}
