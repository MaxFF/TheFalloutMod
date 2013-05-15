package blfngl.fallout.handler;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import blfngl.fallout.FalloutMain;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ThrowingHandler extends FalloutMain
{
	public static void init()
	{
		LanguageRegistry.addName(bottleCapMine, "Bottle Cap Mine");
		GameRegistry.addRecipe(new ItemStack(bottleCapMine), new Object [] {" X ", "***", "&^&", 'X', lunchbox, '*', bottleCap, '&', cherrybomb, '^', sensorModule});
		LanguageRegistry.addName(grenadeFrag, "Frag Grenade");
		GameRegistry.addRecipe(new ItemStack(grenadeFrag), new Object [] {" * ", "X&X", "XXX", '*', chunkSilicon, 'X', ingotTungsten, '&', Block.tnt});

	}
}
