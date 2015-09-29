package com.nincodedo.nincraftythings.block;

import net.minecraft.world.IBlockAccess;

import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.reference.Names;

public class BlockNincodium extends BlockNincrafty {
	public BlockNincodium() {
		setBlockName(Names.Blocks.NINCODIUM_BLOCK);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z,
			int beaconX, int beaconY, int beaconZ) {
		return true;
	}
}
