package com.nincodedo.nincraftythings.init;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.nincodedo.nincraftythings.block.BlockNincodium;
import com.nincodedo.nincraftythings.block.BlockNincodiumOre;
import com.nincodedo.nincraftythings.block.BlockQuartzOre;
import com.nincodedo.nincraftythings.fluid.MoltenLapis;
import com.nincodedo.nincraftythings.fluid.MoltenNincodium;
import com.nincodedo.nincraftythings.reference.Reference;
import com.nincodedo.nincraftythings.reference.Names;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static Fluid moltenNincodium;
	public static Block moltenNincodiumBlock;
	public static BlockNincodium nincodiumBlock;
	public static BlockNincodiumOre nincodiumOre;
	public static Fluid moltenLapis;
	public static Block moltenLapisBlock;
	public static Block quartzOre;

	public static void init() {
		moltenNincodium = new Fluid("moltenNincodium");
		nincodiumBlock = new BlockNincodium();
		nincodiumOre = new BlockNincodiumOre();
		quartzOre = new BlockQuartzOre();
		moltenLapis = new Fluid("moltenLapis");
		FluidRegistry.registerFluid(moltenNincodium);
		FluidRegistry.registerFluid(moltenLapis);
		moltenNincodiumBlock = new MoltenNincodium(moltenNincodium);
		moltenLapisBlock = new MoltenLapis(moltenLapis);
		
		GameRegistry
				.registerBlock(moltenNincodiumBlock, "moltenNincodiumBlock");
		GameRegistry.registerBlock(moltenLapisBlock, "moltenLapisBlock");
		GameRegistry.registerBlock(nincodiumBlock, "nincodiumBlock");
		GameRegistry.registerBlock(nincodiumOre, "nincodiumOre");
		GameRegistry.registerBlock(quartzOre, "quartzOre");
		
		OreDictionary.registerOre(Names.OreDictionary.QUARTZ_ORE, quartzOre);
		OreDictionary.registerOre(Names.OreDictionary.NINCODIUM_ORE,
				nincodiumOre);
	}

}
