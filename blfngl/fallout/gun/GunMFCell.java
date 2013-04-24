package blfngl.fallout.gun;

import blfngl.fallout.common.FalloutMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GunMFCell extends Item
{
	private int damage;
	private int reloadTime;
	private int reloadTotal;
	private int clipid;
	private int ammo;
	private int fireTime;
	private int fireTotal;
	private String firesound;
	private String reloadsound;
	public int count = 0;
	public int clipSize;

	public GunMFCell(int var1, int var2, int var3, int var4, int var5, String var6, String var7)
	{
		super(var1);
		this.damage = var2;
		this.fireTotal = var5;
		this.fireTime = this.fireTotal;
		this.reloadTotal = 5;
		this.reloadTime = var4;
		this.ammo = var3;
		this.clipid = var4;
		this.firesound = var6;
		this.reloadsound = var7;
		this.setMaxStackSize(1);
		this.setMaxDamage(var3);
		clipSize = var3;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		//var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);

		if (!var2.isRemote && var1.getItemDamage() < this.ammo)
		{
			if (this.fireTime == this.fireTotal && this.fireTotal != 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, this.damage, 1));
				var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
				this.fireTime = 0;
			}
			else
			{
				++this.fireTime;
			}

			if (this.fireTotal == 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, this.damage, 1));
				var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
			}
		}
		else if (!var2.isRemote && var3.inventory.hasItem(FalloutMain.MFCell.itemID) && var1.getItemDamage() == this.ammo)
		{
			if (this.reloadTime == this.reloadTotal)
			{
				this.reloadTime = 0;
				var2.playSoundAtEntity(var3, this.reloadsound, 1.0F, 1.0F);
				while (count < clipSize)
				{
					var3.inventory.consumeInventoryItem(FalloutMain.MFCell.itemID);
					count += 1;
					var1.setItemDamage(count);
				}
				//var3.inventory.consumeInventoryItem(FalloutMain.MFCell.itemID);
				var1.setItemDamage(0);
			}
			else
			{
				++this.reloadTime;
			}
		}

		return var1;
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
	{
		this.fireTime = this.fireTotal;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
