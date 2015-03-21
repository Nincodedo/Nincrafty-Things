package com.nincodedo.nincraftythings.item.sword;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;

public class ItemSwordNincodiumSword extends ItemSwordNincrafty {

	public ItemSwordNincodiumSword(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Names.Items.NINCODIUM_SWORD);
		setRepairIngot(ModItems.nincodiumIngot);
	}

	public ItemSwordNincodiumSword() {
		this(Material.Tools.NINCODIUM);
	}

}
