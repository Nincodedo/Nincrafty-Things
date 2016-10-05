package com.nincodedo.nincraftythings.block;

import com.nincodedo.nincraftythings.reference.Names;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockNincodium extends BlockNincrafty {
	public BlockNincodium() {
		super(Material.IRON);
		setHardness(5.0F);
		setResistance(10.0F);
		setUnlocalizedName(Names.Blocks.NINCODIUM_BLOCK);
		setRegistryName(Names.Blocks.NINCODIUM_BLOCK);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return true;
	}
}
