package com.nincodedo.nincraftythings.tweaks;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Lists;
import com.nincodedo.nincraftythings.reference.Settings;

import cpw.mods.fml.common.registry.GameRegistry;

public class OreDictionaryRegister {

	private static final String DELIMITER = "[|]";

	public static void init() {
		parseOreDictEntries();
	}

	private static void parseOreDictEntries() {
		for (String entry : Lists.newArrayList(Settings.Tweaks.oreDictionaryAdditions)) {
			parseOreDictEntry(entry);
		}
	}

	private static void parseOreDictEntry(String entry) {
		String[] entryData = entry.split(DELIMITER);

		if (entryData.length < 3) {
			// If we have less than 3 parts, back out now.
			return;
		} else if (entryData.length < 4) {
			// If we have 3 parts, default to wildcard metadata
			registerOre(entryData[0] + ":" + entryData[1], OreDictionary.WILDCARD_VALUE, entryData[2]);
		} else {
			// Otherwise, we have all 4 parts: mod id, item name, metadata, and oredict entry.
			registerOre(entryData[0] + ":" + entryData[1], getIntSafely(entryData[2]), entryData[3]);
		}
	}

	private static void registerOre(String itemName, int metadata, String oreDictEntry) {
		OreDictionary.registerOre(oreDictEntry, GameRegistry.makeItemStack(itemName, metadata, 0, ""));
		
		System.out.println(itemName + ":" + (metadata == OreDictionary.WILDCARD_VALUE ? "*" : metadata) + " was registered to Ore Dictionary Entry " + oreDictEntry);
	}

	private static int getIntSafely(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return 0;
		}
	}

}
