package com.nincodedo.nincraftythings.botania.block.subtile.functional;

import java.util.Map;

import com.nincodedo.nincraftythings.reference.Settings;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.block.subtile.functional.SubTileOrechid;
import vazkii.botania.common.lexicon.LexiconData;

public class SubTileOrechidMystic extends SubTileOrechid {

	private static final int COST = 20000;

	@Override
	public boolean canOperate() {
		return supertile.getWorldObj().provider.dimensionId == Settings.World.twilightForestDimId;
	}

	@Override
	public Map<String, Integer> getOreMap() {
		return Settings.Botania.orechidMystic;
	}

	@Override
	public Block getSourceBlock() {
		return Blocks.netherrack;
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
		return LexiconData.orechidIgnem;
	}
}
