package com.nincodedo.nincraftythings.block;

import java.util.Random;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Names;

import net.minecraft.item.Item;

public class BlockQuartzOre extends BlockOreNincrafty {
	public BlockQuartzOre() {
		setHardness(3.0F);
		setResistance(5.0F);
		setBlockName(Names.Blocks.QUARTZ_ORE);
	}

	@Override
	public Item getItemDropped(int int1, Random rand, int int2) {
		return ModItems.quartz;
	}
}
