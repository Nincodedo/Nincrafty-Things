package com.nincodedo.nincraftythings.tweaks;

import com.nincodedo.nincraftythings.atg.GenModFlatlands;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Reference;

import cpw.mods.fml.common.Loader;
import ttftcuts.atg.api.ATGAPI;
import ttftcuts.atg.api.ATGBiomes;

public class NincraftyATGTweaks {
	public static void init() {
		if (Loader.isModLoaded(Names.Mods.atgModId)) {
			ATGBiomes.addGenMod(ATGBiomes.getBiome("Woodland"), new GenModFlatlands());
		}
	}
}
