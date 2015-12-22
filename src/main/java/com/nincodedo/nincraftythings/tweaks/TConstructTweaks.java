package com.nincodedo.nincraftythings.tweaks;

import static com.nincraft.nincraftlib.handler.TConstructHandler.setMeltingTemp;

import java.util.Set;

import com.google.common.collect.Sets;
import com.nincodedo.nincraftythings.reference.Settings;

import net.minecraftforge.fluids.FluidRegistry;
import tconstruct.library.crafting.Smeltery;

public class TConstructTweaks {

	private static Set<String> fluidDictEntries = Sets.newHashSet();

	public static void init() {
		if (Settings.TConstruct.enableTiCTweaks) {
			fluidDictEntries.addAll(buildFluidDictEntries(Settings.TConstruct.meltingTemps.keySet()));

			if (fluidDictEntries.isEmpty()) {
				return;
			}

			for (String fluidName : fluidDictEntries) {
				setMeltingTemp(fluidName, Settings.TConstruct.meltingTemps.get(fluidName).intValue());
			}
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

}
