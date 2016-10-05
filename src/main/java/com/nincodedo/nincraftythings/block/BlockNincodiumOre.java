package com.nincodedo.nincraftythings.block;

import com.nincodedo.nincraftythings.reference.Names;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockNincodiumOre extends BlockOreNincrafty {
	public BlockNincodiumOre() {
		setHardness(3.0F);
		setResistance(5.0F);
		setUnlocalizedName(Names.Blocks.NINCODIUM_ORE);
		setRegistryName(Names.Blocks.NINCODIUM_ORE);
		setHarvestLevel("pickaxe", 3);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
	}
}
