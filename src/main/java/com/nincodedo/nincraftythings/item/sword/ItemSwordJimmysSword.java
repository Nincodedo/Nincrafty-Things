package com.nincodedo.nincraftythings.item.sword;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;

public class ItemSwordJimmysSword extends ItemSwordNincrafty {

	public ItemSwordJimmysSword(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Names.Items.JIMMYS_SWORD);
	}

	public ItemSwordJimmysSword() {
		this(Material.Tools.JIMMYDRITE);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.rare;
	}
}
