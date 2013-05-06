package blfngl.fallout.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemHP extends Item
{

	public ItemHP(int par1)
	{
		super(par1);
		setMaxDamage(1);
	}

	public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3) //, PotionID pot, PotionLevel potl, PotionDuration potd)
	{
		par3.addPotionEffect(new PotionEffect(Potion.heal.getId(), 1200, 0));
		par1.damageItem(2, par3);
		return par1;
	}
}
