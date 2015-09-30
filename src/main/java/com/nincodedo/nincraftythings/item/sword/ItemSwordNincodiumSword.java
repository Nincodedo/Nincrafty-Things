package com.nincodedo.nincraftythings.item.sword;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincraft.nincraftlib.api.item.IMoonDamage;

import net.minecraft.item.ItemStack;

public class ItemSwordNincodiumSword extends ItemSwordNincrafty implements IMoonDamage {

	public ItemSwordNincodiumSword() {
		super(Material.Tools.NINCODIUM);
		setUnlocalizedName(Names.Weapons.NINCODIUM_SWORD);
		setRepairIngot(ModItems.nincodiumIngot);
	}

	@Override
	public boolean isDamageMoonModified(ItemStack stack) {
		return true;
	}
}
