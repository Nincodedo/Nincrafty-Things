package com.nincodedo.nincraftythings.tweaks;

import java.util.Arrays;
import java.util.List;

import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegister {

	public static void init() {
		List<String> oreDic = Arrays.asList(Settings.Tweaks.oreDictionaryAdditions);
		if (!oreDic.isEmpty()) {
			String oreDicModId, oreDicItemName, oreDicName;
			Item oreDicItem;
			for (String entry : oreDic) {
				oreDicModId = entry.split("|")[0];
				oreDicItemName = entry.split("|")[1];
				oreDicName = entry.split("|")[2];
				oreDicItem = GameRegistry.findItem(oreDicModId, oreDicItemName);
				if (oreDicItem != null) {
					OreDictionary.registerOre(oreDicName, oreDicItem);
				}
			}
		}
	}

}
