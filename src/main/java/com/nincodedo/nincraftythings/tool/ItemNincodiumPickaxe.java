package com.nincodedo.nincraftythings.tool;

import net.minecraft.item.ItemStack;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;

public class ItemNincodiumPickaxe extends ItemPickaxeNincrafty {

	public ItemNincodiumPickaxe() {
		super(Material.Tools.NINCODIUM);
		this.setUnlocalizedName(Names.Tools.NINCODIUM_PICKAXE);
		this.setRepairIngot(ModItems.nincodiumIngot);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2)
    {
        return getRepairIngot() == itemStack2.getItem() ? true : super.getIsRepairable(itemStack1, itemStack2);
    }
	
}
