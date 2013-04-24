package blfngl.fallout.common;

import blfngl.fallout.gun.EntityLaserRCW;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSyringe extends Item
{
	public ItemSyringe(int par1)
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}