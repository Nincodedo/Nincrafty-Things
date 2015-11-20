package com.nincodedo.nincraftythings.botania.block.subtile.functional;

import java.util.Map;

import com.nincodedo.nincraftythings.botania.common.lexicon.NincraftLexiconData;
import com.nincodedo.nincraftythings.reference.Settings;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.block.subtile.functional.SubTileOrechid;

public class SubTileOrechidFinis extends SubTileOrechid {

	private static final int COST = 20000;

	@Override
	public boolean canOperate() {
		return supertile.getWorldObj().provider.getDimensionName().equals("The End");
	}

	@Override
	public Map<String, Integer> getOreMap() {
		return Settings.Botania.orechidFinis;
	}

	@Override
	public int getCost() {
		return COST;
	}
	
	@Override
	public Block getSourceBlock() {
		return Blocks.end_stone;
	}

	@Override
	public int getColor() {
		return 0x6600cc;
	}

	@Override
	public LexiconEntry getEntry() {
		return NincraftLexiconData.orechidFinis;
	}
}
