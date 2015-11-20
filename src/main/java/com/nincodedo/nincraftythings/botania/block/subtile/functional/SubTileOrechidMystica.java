package com.nincodedo.nincraftythings.botania.block.subtile.functional;

import java.util.Map;

import com.nincodedo.nincraftythings.botania.common.lexicon.NincraftLexiconData;
import com.nincodedo.nincraftythings.reference.Settings;

import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.block.subtile.functional.SubTileOrechid;

public class SubTileOrechidMystica extends SubTileOrechid {

	private static final int COST = 20000;

	@Override
	public boolean canOperate() {
		return supertile.getWorldObj().provider.dimensionId == Settings.World.twilightForestDimId;
	}

	@Override
	public Map<String, Integer> getOreMap() {
		return Settings.Botania.orechidMystica;
	}

	@Override
	public int getCost() {
		return COST;
	}

	@Override
	public int getColor() {
		return 0x009933;
	}

	@Override
	public LexiconEntry getEntry() {
		return NincraftLexiconData.orechidMystica;
	}
}
