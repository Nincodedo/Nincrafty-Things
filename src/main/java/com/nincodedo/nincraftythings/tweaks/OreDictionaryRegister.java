package com.nincodedo.nincraftythings.tweaks;

import static net.minecraftforge.oredict.OreDictionary.getOres;
import static net.minecraftforge.oredict.OreDictionary.registerOre;
import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

import com.google.common.collect.Lists;
import com.nincodedo.nincraftythings.reference.Settings;
import com.nincodedo.nincraftythings.utility.LogHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

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

		switch (entryData.length) {
		case 2:
			// OreDictFrom|oreDictTo
			LogHelper.info("Registering all items under " + entryData[0] + " as " + entryData[1]);

			for (final ItemStack ore : getOres(entryData[0])) {
				registerOre(entryData[1], ore);
			}
			break;
		case 3:
			// ModId|ItemName|OreDict
			LogHelper.info("Registering item " + entryData[0] + ":" + entryData[1] + " as " + entryData[2]);

			registerEntry(entryData[0] + ":" + entryData[1], WILDCARD_VALUE, entryData[2]);
			break;
		case 4:
			// ModId|ItemName|Metadata|OreDict
			LogHelper.info("Registering item " + entryData[0] + ":" + entryData[1] + ":" + entryData[2] + " as "
					+ entryData[3]);

			registerEntry(entryData[0] + ":" + entryData[1], parseMetadata(entryData[2]), entryData[3]);
			break;
		default:
			// lolidk wut u did.
			LogHelper.warn("Unknown Config Value: " + String.join("|", entryData));
			break;
		}
	}

	private static void registerEntry(String itemName, int metadata, String oreDictEntry) {
		registerOre(oreDictEntry, GameRegistry.makeItemStack(itemName, metadata, 0, ""));
	}

	private static int parseMetadata(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return WILDCARD_VALUE;
		}
	}

}
