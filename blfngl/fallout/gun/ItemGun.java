package blfngl.fallout.gun;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import blfngl.fallout.FalloutMain;
import blfngl.fallout.model.EntityBullet;

public class ItemGun extends Item
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
	public Item ammoType;

	public boolean isFull3D()
	{
		return true;
	}

	public ItemGun(int var1, int var2, int var3, int var4, int var5, String var6, String var7, Item var9)
	{
		super(var1);
		damage = var2;
		firemax = var5;
		firetick = firemax;
		reloadmax = 5;
		reloadtick = var4;
		ammo = var3;
		clipid = var4;
		firesound = var6;
		reloadsound = var7;
		setMaxStackSize(1);
		setMaxDamage(var3);
		clipSize = var3;
		ammoType = var9;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		//var2.playSoundAtEntity(var3, firesound, 1.0F, 1.0F);

		if (!var2.isRemote && var1.getItemDamage() < ammo)
		{
			if (firetick == firemax && firemax != 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, damage, 1));
				var2.playSoundAtEntity(var3, firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
				firetick = 0;
			}
			else
			{
				++firetick;
			}

			if (firemax == 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, damage, 1));
				var2.playSoundAtEntity(var3, firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
			}
		}
		else if (!var2.isRemote && var3.inventory.hasItem(ammoType.itemID) && var1.getItemDamage() == ammo)
		{
			if (reloadtick == reloadmax)
			{
				reloadtick = 0;
				var2.playSoundAtEntity(var3, reloadsound, 1.0F, 1.0F);
				while (count < clipSize)
				{
					var3.inventory.consumeInventoryItem(ammoType.itemID);
					count += 1;
				}                
				var1.setItemDamage(0);
				count = 0;

			}
			else
			{
				++reloadtick;
			}
		}

		return var1;
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
	{
		firetick = firemax;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		var3.add("DAM: " + (double) damage/2);
		var3.add("Clip size: " + clipSize);
		var3.add("Ammo type: " + ammoType.getItemDisplayName(new ItemStack(ammoType)));
		//		if (this.ammo == FalloutMain.a10mm.itemID)
		//		{
		//			var3.add("Ammo type: 10mm Rounds");
		//		}
	}
}
