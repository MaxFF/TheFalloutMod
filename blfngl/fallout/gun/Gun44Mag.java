package blfngl.fallout.gun;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import blfngl.fallout.common.FalloutMain;

public class Gun44Mag extends Item
{
	public Gun44Mag(int var1)
	{
		super(var1);
		this.maxStackSize = 1;
		this.setMaxDamage(200);
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

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer)
	{
		if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(FalloutMain.a44.itemID))
		{
			par2World.playSoundAtEntity(par3EntityPlayer, "blfngl.44Fire", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer));
			}
		}
		return par1ItemStack;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}