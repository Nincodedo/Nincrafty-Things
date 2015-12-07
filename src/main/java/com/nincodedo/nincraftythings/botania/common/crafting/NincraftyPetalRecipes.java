package com.nincodedo.nincraftythings.botania.common.crafting;

import com.nincodedo.nincraftythings.reference.Names;
import com.nincodedo.nincraftythings.reference.Settings;

import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipePetals;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibOreDict;

public class NincraftyPetalRecipes {

	public static RecipePetals orechidMystica;
	public static RecipePetals orechidFinis;

	public static final String white = LibOreDict.PETAL[0], orange = LibOreDict.PETAL[1], magenta = LibOreDict.PETAL[2],
			lightBlue = LibOreDict.PETAL[3], yellow = LibOreDict.PETAL[4], lime = LibOreDict.PETAL[5],
			pink = LibOreDict.PETAL[6], gray = LibOreDict.PETAL[7], lightGray = LibOreDict.PETAL[8],
			cyan = LibOreDict.PETAL[9], purple = LibOreDict.PETAL[10], blue = LibOreDict.PETAL[11],
			brown = LibOreDict.PETAL[12], green = LibOreDict.PETAL[13], red = LibOreDict.PETAL[14],
			black = LibOreDict.PETAL[15];
	public static final String runeWater = LibOreDict.RUNE[0], runeFire = LibOreDict.RUNE[1],
			runeEarth = LibOreDict.RUNE[2], runeAir = LibOreDict.RUNE[3], runeSpring = LibOreDict.RUNE[4],
			runeSummer = LibOreDict.RUNE[5], runeAutumn = LibOreDict.RUNE[6], runeWinter = LibOreDict.RUNE[7],
			runeMana = LibOreDict.RUNE[8], runeLust = LibOreDict.RUNE[9], runeGluttony = LibOreDict.RUNE[10],
			runeGreed = LibOreDict.RUNE[11], runeSloth = LibOreDict.RUNE[12], runeWrath = LibOreDict.RUNE[13],
			runeEnvy = LibOreDict.RUNE[14], runePride = LibOreDict.RUNE[15];
	public static final String redstoneRoot = LibOreDict.REDSTONE_ROOT;
	public static final String pixieDust = LibOreDict.PIXIE_DUST;
	public static final String manaPowder = LibOreDict.MANA_POWDER;

	public static void init() {
		if (Settings.Botania.enableOrechids) {
			orechidMystica = BotaniaAPI.registerPetalRecipe(
					ItemBlockSpecialFlower.ofType(Names.Blocks.SUBTILE_ORECHID_MYSTICA), green, green, lightBlue,
					lightBlue, purple, manaPowder, runePride, runeGreed, redstoneRoot, pixieDust);
			orechidFinis = BotaniaAPI.registerPetalRecipe(
					ItemBlockSpecialFlower.ofType(Names.Blocks.SUBTILE_ORECHID_FINIS), purple, purple, black, black,
					white, manaPowder, runePride, runeGreed, redstoneRoot, pixieDust);
		}
	}

}
