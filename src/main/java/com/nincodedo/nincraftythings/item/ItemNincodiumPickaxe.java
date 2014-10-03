package com.nincodedo.nincraftythings.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.reference.Material;

public class ItemNincodiumPickaxe extends ItemPickaxeNincrafty {

	public ItemNincodiumPickaxe() {
		super(Material.Tools.NINCODIUM);
		this.setUnlocalizedName("nincodiumPickaxe");
	}
	
	@Override
	public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2)
    {
        return this.toolMaterial.func_150995_f() == itemStack2.getItem() ? true : super.getIsRepairable(itemStack1, itemStack2);
    }
	
}
