package blfngl.fallout.handler;

import blfngl.fallout.block.WorldGenAsbestosDeposit;
import blfngl.fallout.block.WorldGenCarbonDeposit;
import blfngl.fallout.block.WorldGenSatOre;
import blfngl.fallout.block.WorldGenSiliconDeposit;
import blfngl.fallout.block.WorldGenTechOre;
import blfngl.fallout.block.WorldGenTungstenOre;
import blfngl.fallout.block.WorldGenUraniumOre;
import blfngl.fallout.common.FalloutMain;
import blfngl.fallout.food.WorldGenBrocFlower;
import cpw.mods.fml.common.registry.GameRegistry;

public class BiomeHandler
{
	public static void init()
	{
		GameRegistry.addBiome(FalloutMain.Wasteland);
		GameRegistry.registerWorldGenerator(new WorldGenTungstenOre());
		GameRegistry.registerWorldGenerator(new WorldGenTechOre());
		GameRegistry.registerWorldGenerator(new WorldGenSatOre());
		GameRegistry.registerWorldGenerator(new WorldGenUraniumOre());
		GameRegistry.registerWorldGenerator(new WorldGenBrocFlower());
		GameRegistry.registerWorldGenerator(new WorldGenSiliconDeposit());
		GameRegistry.registerWorldGenerator(new WorldGenAsbestosDeposit());
		GameRegistry.registerWorldGenerator(new WorldGenCarbonDeposit());
	}
}
