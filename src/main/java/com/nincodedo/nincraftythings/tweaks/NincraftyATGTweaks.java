package com.nincodedo.nincraftythings.tweaks;

import net.minecraft.world.biome.BiomeGenBase;
import ttftcuts.atg.api.ATGBiomes;

import com.nincodedo.nincraftythings.atg.GenModFlatlands;
import com.nincodedo.nincraftythings.reference.Names;

import cpw.mods.fml.common.Loader;

public class NincraftyATGTweaks {
	public static void init() {
		if (Loader.isModLoaded(Names.Mods.atgModId)) {
			ATGBiomes.addGenMod(BiomeGenBase.plains, new GenModFlatlands());
		}
	}
}
