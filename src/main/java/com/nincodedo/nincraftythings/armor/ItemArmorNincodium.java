package com.nincodedo.nincraftythings.armor;

import com.nincodedo.nincraftythings.init.ModItems;
import com.nincodedo.nincraftythings.reference.Material;
import com.nincodedo.nincraftythings.reference.Names;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ItemArmorNincodium extends ItemArmorNincrafty {

	public ItemArmorNincodium(ArmorMaterial armorMaterial, int renderIndex, EntityEquipmentSlot armorType) {
		super(armorMaterial, 0, armorType);
		this.setRepairIngot(ModItems.nincodiumIngot);
	}

	public ItemArmorNincodium(EntityEquipmentSlot armorType) {
		this(Material.Armor.NINCODIUM, 0, armorType);

		switch (armorType) {
		case HEAD:
			this.setUnlocalizedName(Names.Armor.NINCODIUM_HELMET);
			break;
		case CHEST:
			this.setUnlocalizedName(Names.Armor.NINCODIUM_CHESTPLATE);
			break;
		case LEGS:
			this.setUnlocalizedName(Names.Armor.NINCODIUM_LEGGINGS);
			break;
		case FEET:
			this.setUnlocalizedName(Names.Armor.NINCODIUM_BOOTS);
			break;
		}
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return EntityEquipmentSlot.LEGS.equals(slot) ? "nincraftythings:textures/models/armor/nincodium_layer_2.png"
				: "nincraftythings:textures/models/armor/nincodium_layer_1.png";
	}

	@Override
	public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2) {
		return getRepairIngot() == itemStack2.getItem() ? true : super.getIsRepairable(itemStack1, itemStack2);
	}

	public static boolean hasArmorSetItem(EntityPlayer player, int i) {
		ItemStack stack = player.inventory.armorInventory[3 - i];
		if (stack == null) {
			return false;
		}

		switch (i) {
		case 0:
			return ModItems.nincodiumHelmet == stack.getItem();
		case 1:
			return ModItems.nincodiumChestplate == stack.getItem();
		case 2:
			return ModItems.nincodiumLeggings == stack.getItem();
		case 3:
			return ModItems.nincodiumBoots == stack.getItem();
		default:
			return false;
		}
	}
}
