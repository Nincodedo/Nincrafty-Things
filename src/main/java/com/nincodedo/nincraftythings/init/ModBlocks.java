package com.nincodedo.nincraftythings.init;

import com.nincodedo.nincraftythings.block.BlockNincodium;
import com.nincodedo.nincraftythings.block.BlockNincodiumOre;
import com.nincodedo.nincraftythings.block.BlockQuartzOre;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Reference;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static Fluid moltenNincodium;
	public static BlockNincodium nincodiumBlock;
	public static BlockNincodiumOre nincodiumOre;
	public static Fluid moltenLapis;
	public static BlockQuartzOre quartzOre;

	public static void init() {
		initFluids();
		registerFluids();

		initBlocks();
		registerBlocks();
		registerOreDictionaryEntries();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		nincodiumBlock.initModel();
		nincodiumOre.initModel();
		quartzOre.initModel();
	}

	private static void initFluids() {
		moltenNincodium = new Fluid("moltenNincodium", null, null);
		moltenLapis = new Fluid("moltenLapis", null, null);
	}

	private static void initBlocks() {
		nincodiumBlock = new BlockNincodium();
		nincodiumOre = new BlockNincodiumOre();
		quartzOre = new BlockQuartzOre();
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(nincodiumBlock, "nincodiumBlock");
		GameRegistry.registerBlock(nincodiumOre, "nincodiumOre");
		GameRegistry.registerBlock(quartzOre, "quartzOre");
	}

	private static void registerFluids() {
		FluidRegistry.registerFluid(moltenNincodium);
		FluidRegistry.registerFluid(moltenLapis);
	}

	private static void registerOreDictionaryEntries() {
		OreDictionary.registerOre(Names.OreDictionary.QUARTZ_ORE, quartzOre);
		OreDictionary.registerOre(Names.OreDictionary.NINCODIUM_ORE, nincodiumOre);
	}

}
