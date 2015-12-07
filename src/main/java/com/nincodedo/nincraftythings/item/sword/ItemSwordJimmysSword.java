package com.nincodedo.nincraftythings.item.sword;

import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincraft.nincraftlib.api.item.IProcBuff;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemSwordJimmysSword extends ItemSwordNincrafty implements IProcBuff {

	public ItemSwordJimmysSword() {
		super(Material.Tools.JIMMYDRITE);
		setUnlocalizedName(Names.Weapons.JIMMYS_SWORD);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.rare;
	}

	@Override
	public boolean canProc(ItemStack stack) {
		return true;
	}
}
