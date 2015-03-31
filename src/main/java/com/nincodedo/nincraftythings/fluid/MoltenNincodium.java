package com.nincodedo.nincraftythings.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraftforge.fluids.Fluid;

import com.nincodedo.nincraftythings.block.BlockFluidClassicNincrafty;
import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MoltenNincodium extends BlockFluidClassicNincrafty {

	public MoltenNincodium(Fluid fluid, Material material) {
		super(fluid, material);
		setCreativeTab(CreativeTabNincrafty.NINCRAFTY_TAB);
		setBlockName(Names.Blocks.MOLTEN_NINCODIUM_BLOCK);
	}

	public MoltenNincodium(Fluid moltenNincodium) {
		this(moltenNincodium, Material.lava);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon(Reference.MOD_ID + ":"
				+ Names.Blocks.MOLTEN_NINCODIUM);
		flowingIcon = register.registerIcon(Reference.MOD_ID + ":"
				+ Names.Blocks.MOLTEN_NINCODIUM_FLOWING);
		ModItems.moltenNincodium.setStillIcon(stillIcon);
		ModItems.moltenNincodium.setFlowingIcon(flowingIcon);
	}
}
