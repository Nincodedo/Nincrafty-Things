package com.nincodedo.nincraftythings.block;

import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.reference.Names;

public class BlockNincodiumOre extends BlockNincrafty {
	public BlockNincodiumOre() {
		setHardness(3.0F);
		setResistance(5.0F);
		setBlockName(Names.Blocks.NINCODIUM_ORE);
		setHarvestLevel("pickaxe", 3);
		setCreativeTab(CreativeTabNincrafty.NINCRAFTY_TAB);
	}
}