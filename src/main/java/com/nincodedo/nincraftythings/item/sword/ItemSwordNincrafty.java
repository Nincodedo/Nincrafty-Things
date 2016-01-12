package com.nincodedo.nincraftythings.item.sword;

import com.nincodedo.nincraftythings.creativetab.CreativeTabNincrafty;
import com.nincodedo.nincraftythings.reference.Reference;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSwordNincrafty extends ItemSword {

	private Item repairIngot;

	public ItemSwordNincrafty(ToolMaterial material) {
		super(material);
		setCreativeTab(CreativeTabNincrafty.NINCRAFTY_TAB);
		this.setNoRepair();
		this.maxStackSize = 1;
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2) {
		return getRepairIngot() == itemStack2.getItem() ? true : super.getIsRepairable(itemStack1, itemStack2);
	}

	public Item getRepairIngot() {
		return repairIngot;
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

	public void setRepairIngot(Item repairIngot) {
		this.repairIngot = repairIngot;
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
