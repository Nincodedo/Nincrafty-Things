package com.nincodedo.nincraftythings.block;

import com.nincodedo.nincraftythings.reference.Names;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNincodium extends BlockNincrafty {
	public BlockNincodium() {
		super(Material.iron);
		setUnlocalizedName(Names.Blocks.NINCODIUM_BLOCK);
		setRegistryName(Names.Blocks.NINCODIUM_BLOCK);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
