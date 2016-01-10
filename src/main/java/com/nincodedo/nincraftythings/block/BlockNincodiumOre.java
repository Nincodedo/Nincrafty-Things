package com.nincodedo.nincraftythings.block;

import com.nincodedo.nincraftythings.reference.Names;

public class BlockNincodiumOre extends BlockOreNincrafty {
	public BlockNincodiumOre() {
		setHardness(3.0F);
		setResistance(5.0F);
		setUnlocalizedName(Names.Blocks.NINCODIUM_ORE);
		setRegistryName(Names.Blocks.NINCODIUM_ORE);
		setHarvestLevel("pickaxe", 3);
	}
}
