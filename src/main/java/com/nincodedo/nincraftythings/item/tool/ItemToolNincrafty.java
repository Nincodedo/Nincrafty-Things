package com.nincodedo.nincraftythings.item.tool;

import java.util.Set;

import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemToolNincrafty extends ItemTool {

	protected ItemToolNincrafty(float damageVsEntity, ToolMaterial toolMaterial, Set blocksEffectiveAgainst) {
		super(damageVsEntity, toolMaterial, blocksEffectiveAgainst);
		setCreativeTab(CreativeTabNincrafty.NINCRAFTY_TAB);
		setNoRepair();
		maxStackSize = 1;
	}

	@Override
	public String getUnlocalizedName() {
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
				getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return getUnlocalizedName();
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

}
