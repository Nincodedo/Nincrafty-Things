package com.nincodedo.nincraftythings.botania.common.lexicon;

import com.nincodedo.nincraftythings.botania.common.crafting.NincraftyPetalRecipes;
import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Settings;

import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.lexicon.LexiconEntry;
import vazkii.botania.common.lexicon.ALexiconEntry;
import vazkii.botania.common.lexicon.page.PagePetalRecipe;
import vazkii.botania.common.lexicon.page.PageText;

public class NincraftLexiconData {

	public static LexiconEntry orechidMystica;
	public static LexiconEntry orechidFinis;

	public static void init() {
		if (Settings.Botania.enableOrechids) {
			orechidMystica = new ALexiconEntry(Names.Blocks.SUBTILE_ORECHID_MYSTICA,
					BotaniaAPI.categoryFunctionalFlowers);
			orechidMystica.setLexiconPages(new PageText("0"),
					new PagePetalRecipe("1", NincraftyPetalRecipes.orechidMystica));

			orechidFinis = new ALexiconEntry(Names.Blocks.SUBTILE_ORECHID_FINIS, BotaniaAPI.categoryFunctionalFlowers);
			orechidFinis.setLexiconPages(new PageText("0"),
					new PagePetalRecipe("1", NincraftyPetalRecipes.orechidFinis));
		}
	}
}
