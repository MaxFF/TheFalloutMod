package blfngl.fallout.gun;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import blfngl.fallout.common.FalloutMain;

public class GunCompliance extends Item
{
	public GunCompliance(int var1)
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

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		if (var3.inventory.hasItem(FalloutMain.ECell.itemID));
		{
			var2.playSoundAtEntity(var3, "blfngl.LaserPistolFire", 2.0F, 1.0F);
			EntityLaserLR var4 = new EntityLaserLR(var2, var3, 4.0F, true);
			//var4.setDamage(1.0D);
			var4.canBePickedUp = 0;
			var4.setRandom(15.0F);
			var2.spawnEntityInWorld(var4);
		}

		return var1;
	}
	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
