package blfngl.fallout.gun;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import blfngl.fallout.common.FalloutMain;

public class Gun22lr extends ItemSword
{
	private int damage;
	private int reloadtick;
	private int reloadmax;
	private int clipid;
	private int ammo;
	private int firetick;
	private int firemax;
	private String firesound;
	private String reloadsound;
	public int count = 0;
	public int clipSize;

	public Gun22lr(int var1, int var2, int var3, int var4, int var5, String var6, String var7, EnumToolMaterial var8)
	{
		super(var1, var8);
		this.damage = var2;
		this.firemax = var5;
		this.firetick = this.firemax;
		this.reloadmax = 5;
		this.reloadtick = var4;
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
			if (this.firetick == this.firemax && this.firemax != 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, this.damage, 1));
				var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
				this.firetick = 0;
			}
			else
			{
				++this.firetick;
			}

			if (this.firemax == 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, this.damage, 1));
				var2.playSoundAtEntity(var3, this.firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
			}
		}
		else if (!var2.isRemote && var3.inventory.hasItem(FalloutMain.a22LR.itemID) && var1.getItemDamage() == this.ammo)
		{
			if (this.reloadtick == this.reloadmax)
			{
				this.reloadtick = 0;
				var2.playSoundAtEntity(var3, this.reloadsound, 1.0F, 1.0F);
				while (count < clipSize)
				{
					var3.inventory.consumeInventoryItem(FalloutMain.cellEnergy.itemID);
					count += 1;
				}                
				var1.setItemDamage(0);
				count = 0;

			}
			else
			{
				++this.reloadtick;
			}
		}

		return var1;
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
	{
		this.firetick = this.firemax;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
