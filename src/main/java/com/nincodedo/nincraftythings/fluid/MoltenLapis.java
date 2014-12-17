package com.nincodedo.nincraftythings.fluid;

import com.nincodedo.nincraftythings.NincraftyThings;
import com.nincodedo.nincraftythings.block.BlockFluidClassicNincrafty;
import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MoltenLapis extends BlockFluidClassicNincrafty {

	public MoltenLapis(Fluid fluid, Material material) {
		super(fluid, material);
		setCreativeTab(CreativeTabNincrafty.NINCRAFTY_TAB);
		setBlockName(Names.Blocks.MOLTEN_LAPIS_BLOCK);
	}

	public MoltenLapis(Fluid moltenLapis) {
		this(moltenLapis, Material.lava);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon(Reference.MOD_ID
				+ ":"+Names.Blocks.MOLTEN_LAPIS);
		flowingIcon = register.registerIcon(Reference.MOD_ID
				+ ":"+Names.Blocks.MOLTEN_LAPIS_FLOWING);
		ModItems.moltenLapis.setStillIcon(stillIcon);
		ModItems.moltenLapis.setFlowingIcon(flowingIcon);
	}
}
