package blfngl.fallout.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BaseFalloutItem extends Item
{
	public BaseFalloutItem(int par1)
	{
		super(par1);
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}