package com.nincodedo.nincraftythings.block;

import java.util.Random;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Names;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockQuartzOre extends BlockOreNincrafty {
	public BlockQuartzOre() {
		setHardness(3.0F);
		setResistance(5.0F);
		setUnlocalizedName(Names.Blocks.QUARTZ_ORE);
		setRegistryName(Names.Blocks.QUARTZ_ORE);
		setHarvestLevel("pickaxe", 2);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.quartz;
	}
}
