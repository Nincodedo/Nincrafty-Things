package com.nincodedo.nincraftythings.atg;

import java.util.Random;

import com.nincodedo.nincraftythings.reference.Settings;

import net.minecraft.world.World;
import ttftcuts.atg.api.IGenMod;

public class GenModFlatlands implements IGenMod {

	@Override
	public int modify(World world, int height, Random random, double rawHeight, int x, int z) {
		if (height > Settings.Flatlands.maxHeight) {
			return Settings.Flatlands.maxHeight - random.nextInt(Settings.Flatlands.heightRange);
		} else {
			return height;
		}
	}

	@Override
	public double noiseFactor() {
		return Settings.Flatlands.noiseFactor;
	}

}
