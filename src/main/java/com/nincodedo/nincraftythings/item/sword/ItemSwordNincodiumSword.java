package com.nincodedo.nincraftythings.item.sword;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
