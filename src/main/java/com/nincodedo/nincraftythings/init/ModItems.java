package com.nincodedo.nincraftythings.init;

import com.nincodedo.nincraftythings.armor.ItemArmorNincodium;
import com.nincodedo.nincraftythings.armor.ItemArmorNincrafty;
import com.nincodedo.nincraftythings.item.ItemNincodiumIngot;
import com.nincodedo.nincraftythings.item.ItemNincrafty;
import com.nincodedo.nincraftythings.item.ItemQuartz;
import com.nincodedo.nincraftythings.item.sword.ItemSwordJimmysSword;
import com.nincodedo.nincraftythings.item.sword.ItemSwordNincodiumSword;
import com.nincodedo.nincraftythings.item.tool.ItemNincodiumPickaxe;
import com.nincodedo.nincraftythings.item.tool.ItemPickaxeNincrafty;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Reference;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

	public static ItemNincrafty nincodiumIngot;
	public static ItemNincrafty quartz;
	public static ItemPickaxeNincrafty nincodiumPickaxe;
	public static ItemArmorNincrafty nincodiumHelmet;
	public static ItemArmorNincrafty nincodiumChestplate;
	public static ItemArmorNincrafty nincodiumLeggings;
	public static ItemArmorNincrafty nincodiumBoots;
	public static ItemSwordNincodiumSword nincodiumSword;
	public static ItemSwordJimmysSword jimmysSword;

	public static void init() {
		initItems();

		registerItems();
		registerFluidContainers();

		registerOreDictionaryEntries();
	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		nincodiumIngot.initModel();
		quartz.initModel();
		nincodiumPickaxe.initModel();
		nincodiumHelmet.initModel();
		nincodiumChestplate.initModel();
		nincodiumLeggings.initModel();
		nincodiumBoots.initModel();
		nincodiumSword.initModel();
		jimmysSword.initModel();
	}

	private static void registerOreDictionaryEntries() {
		OreDictionary.registerOre(Names.OreDictionary.NINCODIUM_INGOT, nincodiumIngot);
		OreDictionary.registerOre(Names.OreDictionary.QUARTZ_GEM, quartz);
	}

	private static void initItems() {
		nincodiumIngot = new ItemNincodiumIngot();
		quartz = new ItemQuartz();
		nincodiumPickaxe = new ItemNincodiumPickaxe();
		nincodiumHelmet = new ItemArmorNincodium(EntityEquipmentSlot.HEAD);
		nincodiumChestplate = new ItemArmorNincodium(EntityEquipmentSlot.CHEST);
		nincodiumLeggings = new ItemArmorNincodium(EntityEquipmentSlot.LEGS);
		nincodiumBoots = new ItemArmorNincodium(EntityEquipmentSlot.FEET);
		nincodiumSword = new ItemSwordNincodiumSword();
		jimmysSword = new ItemSwordJimmysSword();
	}

	private static void registerFluidContainers() {

	}

	private static void registerItems() {
		GameRegistry.registerItem(nincodiumIngot, Names.Items.NINCODIUM_INGOT);
		GameRegistry.registerItem(quartz, Names.Items.QUARTZ);
		GameRegistry.registerItem(nincodiumPickaxe, Names.Tools.NINCODIUM_PICKAXE);
		GameRegistry.registerItem(nincodiumSword, Names.Weapons.NINCODIUM_SWORD);
		GameRegistry.registerItem(jimmysSword, Names.Weapons.JIMMYS_SWORD);

		GameRegistry.registerItem(nincodiumHelmet, Names.Armor.NINCODIUM_HELMET);
		GameRegistry.registerItem(nincodiumChestplate, Names.Armor.NINCODIUM_CHESTPLATE);
		GameRegistry.registerItem(nincodiumLeggings, Names.Armor.NINCODIUM_LEGGINGS);
		GameRegistry.registerItem(nincodiumBoots, Names.Armor.NINCODIUM_BOOTS);
	}

}
