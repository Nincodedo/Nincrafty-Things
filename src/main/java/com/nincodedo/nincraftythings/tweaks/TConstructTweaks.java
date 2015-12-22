package com.nincodedo.nincraftythings.tweaks;

import static com.nincraft.nincraftlib.handler.TConstructHandler.setMeltingTemp;
import static com.nincraft.nincraftlib.handler.TConstructHandler.setToolPartCost;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.nincodedo.nincraftythings.reference.Settings;

import net.minecraftforge.fluids.FluidRegistry;
import tconstruct.library.TConstructRegistry;
import tconstruct.tools.items.Pattern;

public class TConstructTweaks {

	private static final List<String> patternNames = Lists.newArrayList(
		"rod",
		"pickaxe",
		"shovel",
		"axe",
		"swordblade",
		"largeguard",
		"mediumguard",
		"crossbar",
		"binding",
		"frypan",
		"sign",
		"knifeblade",
		"chisel",
		"largerod",
		"toughbinding",
		"largeplate",
		"broadaxe",
		"scythe",
		"excavator",
		"largeblade",
		"hammerhead",
		"fullguard",
		"bowstring",
		"fletching",
		"arrowhead"
	);

	public static void init() {
		if (Settings.TConstruct.enableTiCTweaks) {
			if (Settings.TConstruct.adjustMeltingTemps) {
				adjustMeltingTemps();
			}
			
			if (Settings.TConstruct.adjustToolPartCosts) {
				adjustToolPartcosts();
			}
		}
	}

	private static void adjustMeltingTemps() {
		for (String fluidName : buildFluidDictEntries(Settings.TConstruct.meltingTemps.keySet())) {
			setMeltingTemp(fluidName, Settings.TConstruct.meltingTemps.get(fluidName));
		}
	}

	private static Set<String> buildFluidDictEntries(Set<String> fluidNames) {
		Set<String> entryList = Sets.newHashSet();

		for (String fluidName : fluidNames) {
			String fluidEntry = getFluidDictionaryEntry(fluidName);

			if (fluidEntry != null) {
				entryList.add(fluidEntry);
			}
		}

		return entryList;
	}

	private static String getFluidDictionaryEntry(String fluidName) {
		for (String registeredFluidName : FluidRegistry.getRegisteredFluids().keySet()) {
			if (registeredFluidName.equalsIgnoreCase(fluidName)) {
				return registeredFluidName;
			}
		}

		return null;
	}

	private static void adjustToolPartcosts() {
		for (Integer toolPartIndex : buildToolPartEntries(Settings.TConstruct.toolPartCosts.keySet())) {
			setToolPartCost(toolPartIndex, Settings.TConstruct.toolPartCosts.get(patternNames.get(toolPartIndex)));
		}
	}

	private static Set<Integer> buildToolPartEntries(Set<String> toolParts) {
		Set<Integer> entryList = Sets.newHashSet();

		for (String toolPart : toolParts) {
			Integer partIndex = getToolPartEntry(toolPart);

			if (partIndex != null) {
				entryList.add(partIndex);
			}
		}

		return entryList;
	}

	private static Integer getToolPartEntry(String toolPart) {
		for (Integer partIndex : Pattern.getPatternCosts().keySet()) {
			if (patternNames.indexOf(toolPart) == partIndex) {
				return partIndex;
			}
		}

		return null;
	}

}
