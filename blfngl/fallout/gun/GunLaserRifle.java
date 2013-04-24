package blfngl.fallout.gun;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import blfngl.fallout.common.FalloutMain;

public class GunLaserRifle extends Item
{
	float CoolDown;

	public GunLaserRifle(int var1)
	{
		super(var1);
		this.maxStackSize = 1;
		this.setMaxDamage(620);
	}

	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	public boolean isFull3D()
	{
		return true;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack var1)
	{
		return EnumAction.block;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		if (var3.inventory.hasItem(FalloutMain.MFCell.itemID) && CoolDown == 0);
		{

			var2.playSoundAtEntity(var3, "blfngl.LaserFire", 2.0F, 1.0F);
			EntityLaserLR var4 = new EntityLaserLR(var2, var3, 20.0F, true);
			//var4.setDamage(1.0D);
			var4.canBePickedUp = 0;
			var4.setRandom(15.0F);
			var2.spawnEntityInWorld(var4);

			if (var3.capabilities.isCreativeMode)
			{
				var4.canBePickedUp = 2;
			}
			else
			{
				var3.inventory.consumeInventoryItem(FalloutMain.MFCell.itemID);
				//var3.inventory.addItemStackToInventory(new ItemStack(FalloutMain.DrainedMFCell.itemID));
			}
		}
		
		CoolDown = CoolDown + 6;
		return var1;
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if(par3Entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)par3Entity;
			if(CoolDown > 0)
			{
				CoolDown = CoolDown - 1;
			}
		}
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
