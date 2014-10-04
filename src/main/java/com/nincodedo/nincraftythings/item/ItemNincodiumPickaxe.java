package com.nincodedo.nincraftythings.item;

import net.minecraft.item.ItemStack;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;

public class ItemNincodiumPickaxe extends ItemPickaxeNincrafty {

	public ItemNincodiumPickaxe() {
		super(Material.Tools.NINCODIUM);
		this.setUnlocalizedName("nincodiumPickaxe");
		this.setRepairIngot(ModItems.nincodiumIngot);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2)
    {
        return getRepairIngot() == itemStack2.getItem() ? true : super.getIsRepairable(itemStack1, itemStack2);
    }
	
}
