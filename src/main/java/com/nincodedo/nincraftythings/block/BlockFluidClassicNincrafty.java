package com.nincodedo.nincraftythings.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidClassicNincrafty extends BlockFluidClassic {

	public BlockFluidClassicNincrafty(Fluid fluid, Material material) {
		super(fluid, material);
	}

	public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		if (world.getBlockState(pos).getBlock().getMaterial().isLiquid())
			return false;
		return super.canDisplace(world, pos);
	}

	@Override
	public boolean displaceIfPossible(World world, BlockPos pos) {
		if (world.getBlockState(pos).getBlock().getMaterial().isLiquid())
			return false;
		return super.displaceIfPossible(world, pos);
	}

}
