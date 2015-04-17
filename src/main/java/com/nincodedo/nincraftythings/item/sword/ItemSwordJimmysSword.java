package com.nincodedo.nincraftythings.item.sword;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import com.nincodedo.nincraftythings.api.item.IProcBuff;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;

public class ItemSwordJimmysSword extends ItemSwordNincrafty implements
		IProcBuff {

	public ItemSwordJimmysSword() {
		super(Material.Tools.JIMMYDRITE);
		setUnlocalizedName(Names.Items.JIMMYS_SWORD);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.rare;
	}

	public boolean canProc(ItemStack stack) {
		return true;
	}
}
