package blfngl.fallout.melee;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WeapFlamingShish extends Item
{

	public WeapFlamingShish(int par1)
	{
		super(par1);
	}

	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
	{
		itemstack.damageItem(1, entityliving1);
		entityliving.setFire(4);
		return true;
	}
}
