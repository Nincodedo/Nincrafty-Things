package com.nincodedo.nincraftythings.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

import com.nincodedo.nincraftythings.armor.ItemArmorNincodium;
import com.nincodedo.nincraftythings.armor.ItemArmorNincrafty;
import com.nincodedo.nincraftythings.block.BlockFluidClassicNincrafty;
import com.nincodedo.nincraftythings.block.BlockNincrafty;
import com.nincodedo.nincraftythings.fluid.MoltenNincodium;
import com.nincodedo.nincraftythings.item.ItemBucketNincrafty;
import com.nincodedo.nincraftythings.item.ItemMoltenNincodiumBucket;
import com.nincodedo.nincraftythings.item.ItemNincodiumIngot;
import com.nincodedo.nincraftythings.item.ItemNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;
import com.nincodedo.nincraftythings.tool.ItemNincodiumPickaxe;
import com.nincodedo.nincraftythings.tool.ItemPickaxeNincrafty;

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

	public static void init() {
		nincodiumIngot = new ItemNincodiumIngot();
		nincodiumPickaxe = new ItemNincodiumPickaxe();
		nincodiumHelmet = new ItemArmorNincodium(0);
		nincodiumChestplate = new ItemArmorNincodium(1);
		nincodiumLeggings = new ItemArmorNincodium(2);
		nincodiumBoots = new ItemArmorNincodium(3);
		moltenNincodium = new Fluid("moltenNincodium");
		
		
		
		FluidRegistry.registerFluid(moltenNincodium);
		moltenNincodiumBlock = new MoltenNincodium(moltenNincodium);
		GameRegistry.registerBlock(moltenNincodiumBlock, "moltenNincodiumBlock");
		bucketNincodium = new ItemMoltenNincodiumBucket(moltenNincodiumBlock);
		FluidContainerRegistry.registerFluidContainer(moltenNincodium, new ItemStack(bucketNincodium), new ItemStack(Items.bucket));
		
		GameRegistry.registerItem(bucketNincodium, "bucketNincodium");
		GameRegistry.registerItem(nincodiumIngot, "nincodiumIngot");
		GameRegistry.registerItem(nincodiumPickaxe, "nincodiumPickaxe");
		GameRegistry.registerItem(nincodiumHelmet, "nincodiumHelmet");
		GameRegistry.registerItem(nincodiumChestplate, "nincodiumChestplate");
		GameRegistry.registerItem(nincodiumLeggings, "nincodiumLeggings");
		GameRegistry.registerItem(nincodiumBoots, "nincodiumBoots");
	}
}
