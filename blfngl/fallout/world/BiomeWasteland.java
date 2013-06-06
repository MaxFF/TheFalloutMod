package blfngl.fallout.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenDesert;

public class BiomeWasteland extends BiomeGenDesert
{
	public BiomeWasteland(int id)
	{
		super(id);
		topBlock = (byte) Block.dirt.blockID;
		fillerBlock = (byte) Block.sand.blockID;
		//tobBlock = (byte) Block.sand.blockID;
	}
}