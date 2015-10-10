package com.nincodedo.nincraftythings.item.tool;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;

import net.minecraft.item.ItemStack;

public class ItemNincodiumPickaxe extends ItemPickaxeNincrafty {

	public ItemNincodiumPickaxe() {
		super(Material.Tools.NINCODIUM);
		setUnlocalizedName(Names.Tools.NINCODIUM_PICKAXE);
		setRepairIngot(ModItems.nincodiumIngot);
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2) {
		return getRepairIngot() == itemStack2.getItem() ? true : super.getIsRepairable(itemStack1, itemStack2);
	}

}
