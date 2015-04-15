package com.nincodedo.nincraftythings.item.sword;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;

public class ItemSwordNincodiumSword extends ItemSwordNincrafty implements IMoonDamage {

	public ItemSwordNincodiumSword() {
		super(Material.Tools.NINCODIUM);
		setUnlocalizedName(Names.Items.NINCODIUM_SWORD);
		setRepairIngot(ModItems.nincodiumIngot);
	}
	
	public boolean isDamageMoonModified(ItemStack stack){
		return true;
	}
}
