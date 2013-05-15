package blfngl.fallout.food;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import blfngl.fallout.FalloutMain;

public class BlockBrocFlower extends BlockFlower
{
	public BlockBrocFlower(int id, int iconindex)
	{
		super(id);
	}

	public int idDropped(int i, Random random, int j)
	{
		return FalloutMain.bBrocFlower.itemID;
	}

	public void func_94332_a(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

}