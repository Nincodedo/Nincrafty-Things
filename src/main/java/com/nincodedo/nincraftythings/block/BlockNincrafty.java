package com.nincodedo.nincraftythings.block;

import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNincrafty extends Block {

	public BlockNincrafty() {
		this(Material.rock);
		setCreativeTab(CreativeTabNincrafty.NINCRAFTY_TAB);
	}

	public BlockNincrafty(Material material) {
		super(material);
	}

	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
