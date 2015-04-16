package com.nincodedo.nincraftythings.init;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.nincodedo.nincraftythings.armor.ItemArmorNincodium;
import com.nincodedo.nincraftythings.armor.ItemArmorNincrafty;
import com.nincodedo.nincraftythings.block.BlockNincodium;
import com.nincodedo.nincraftythings.block.BlockNincodiumOre;
import com.nincodedo.nincraftythings.fluid.MoltenLapis;
import com.nincodedo.nincraftythings.fluid.MoltenNincodium;
import com.nincodedo.nincraftythings.item.ItemNincodiumIngot;
import com.nincodedo.nincraftythings.item.ItemNincrafty;
import com.nincodedo.nincraftythings.item.bucket.ItemBucketNincrafty;
import com.nincodedo.nincraftythings.item.bucket.ItemMoltenLapisBucket;
import com.nincodedo.nincraftythings.item.bucket.ItemMoltenNincodiumBucket;
import com.nincodedo.nincraftythings.item.sword.ItemSwordJimmysSword;
import com.nincodedo.nincraftythings.item.sword.ItemSwordNincodiumSword;
import com.nincodedo.nincraftythings.item.tool.ItemNincodiumPickaxe;
import com.nincodedo.nincraftythings.item.tool.ItemPickaxeNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	public static ItemNincrafty nincodiumIngot;
	public static ItemPickaxeNincrafty nincodiumPickaxe;
	public static ItemArmorNincrafty nincodiumHelmet;
	public static ItemArmorNincrafty nincodiumChestplate;
	public static ItemArmorNincrafty nincodiumLeggings;
	public static ItemArmorNincrafty nincodiumBoots;
	public static Fluid moltenNincodium;
	public static Block moltenNincodiumBlock;
	public static ItemBucketNincrafty bucketNincodium;
	public static ItemSwordNincodiumSword nincodiumSword;
	public static BlockNincodium nincodiumBlock;
	public static BlockNincodiumOre nincodiumOre;
	public static Fluid moltenLapis;
	public static ItemBucketNincrafty bucketLapis;
	public static Block moltenLapisBlock;
	public static ItemSwordJimmysSword jimmysSword;

	public static void init() {
		nincodiumIngot = new ItemNincodiumIngot();
		nincodiumPickaxe = new ItemNincodiumPickaxe();
		nincodiumHelmet = new ItemArmorNincodium(0);
		nincodiumChestplate = new ItemArmorNincodium(1);
		nincodiumLeggings = new ItemArmorNincodium(2);
		nincodiumBoots = new ItemArmorNincodium(3);
		moltenNincodium = new Fluid("moltenNincodium");
		nincodiumSword = new ItemSwordNincodiumSword();
		nincodiumBlock = new BlockNincodium();
		nincodiumOre = new BlockNincodiumOre();
		jimmysSword = new ItemSwordJimmysSword();
		moltenLapis = new Fluid("moltenLapis");

		FluidRegistry.registerFluid(moltenNincodium);
		FluidRegistry.registerFluid(moltenLapis);
		moltenNincodiumBlock = new MoltenNincodium(moltenNincodium);
		bucketNincodium = new ItemMoltenNincodiumBucket(moltenNincodiumBlock);

		moltenLapisBlock = new MoltenLapis(moltenLapis);
		GameRegistry
				.registerBlock(moltenNincodiumBlock, "moltenNincodiumBlock");
		GameRegistry.registerBlock(moltenLapisBlock, "moltenLapisBlock");
		bucketNincodium = new ItemMoltenNincodiumBucket(moltenNincodiumBlock);
		bucketLapis = new ItemMoltenLapisBucket(moltenLapisBlock);
		FluidContainerRegistry.registerFluidContainer(moltenNincodium,
				new ItemStack(bucketNincodium), new ItemStack(Items.bucket));
		FluidContainerRegistry.registerFluidContainer(moltenLapis,
				new ItemStack(bucketLapis), new ItemStack(Items.bucket));

		GameRegistry.registerItem(nincodiumSword, "nincodiumSword");
		GameRegistry.registerItem(bucketNincodium, "bucketNincodium");
		GameRegistry.registerItem(bucketLapis, "bucketLapis");
		GameRegistry.registerItem(nincodiumIngot, "nincodiumIngot");
		OreDictionary.registerOre("ingotNincodium", nincodiumIngot);
		GameRegistry.registerBlock(nincodiumBlock, "nincodiumBlock");
		GameRegistry.registerBlock(nincodiumOre, "nincodiumOre");
		GameRegistry.registerItem(nincodiumPickaxe, "nincodiumPickaxe");
		GameRegistry.registerItem(nincodiumSword, "nincodiumSword");
		GameRegistry.registerItem(jimmysSword, "jimmysSword");
		GameRegistry.registerItem(bucketNincodium, "bucketNincodium");
		FluidContainerRegistry.registerFluidContainer(moltenNincodium,
				new ItemStack(bucketNincodium), new ItemStack(Items.bucket));

		GameRegistry.registerItem(nincodiumHelmet, "nincodiumHelmet");
		GameRegistry.registerItem(nincodiumChestplate, "nincodiumChestplate");
		GameRegistry.registerItem(nincodiumLeggings, "nincodiumLeggings");
		GameRegistry.registerItem(nincodiumBoots, "nincodiumBoots");
	}
}
