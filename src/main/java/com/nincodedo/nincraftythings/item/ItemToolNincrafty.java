package com.nincodedo.nincraftythings.item;

import java.util.Set;

import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemToolNincrafty extends ItemTool {

	protected ItemToolNincrafty(float damageVsEntity, ToolMaterial toolMaterial,
			Set blocksEffectiveAgainst) {
		super(damageVsEntity, toolMaterial, blocksEffectiveAgainst);
		this.setCreativeTab(CreativeTabNincrafty.NINCRAFTY_TAB);
		this.setNoRepair();
		this.maxStackSize = 1;
	}
	
	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName()
				.substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
