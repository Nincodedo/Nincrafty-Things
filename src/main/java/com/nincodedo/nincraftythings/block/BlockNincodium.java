package com.nincodedo.nincraftythings.block;

import com.nincodedo.nincraftythings.reference.Names;

import net.minecraft.world.IBlockAccess;

public class BlockNincodium extends BlockNincrafty {
	public BlockNincodium() {
		setBlockName(Names.Blocks.NINCODIUM_BLOCK);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}
}
