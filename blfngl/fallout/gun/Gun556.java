package blfngl.fallout.gun;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import blfngl.fallout.FalloutMain;
import blfngl.fallout.model.EntityBullet;
import blfngl.fallout.render.RenderChineseAssaultRifle;
import blfngl.fallout.render.RenderChineseAssaultRifleScoped;
import blfngl.fallout.render.RenderBozar;
import blfngl.fallout.render.RenderBozarScope;
import blfngl.fallout.render.RenderRatslayer;
import blfngl.fallout.render.RenderRatslayerScoped;

public class Gun556 extends ItemSword
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
	public float scopeDist;

	public Gun556(int var1, int var2, int var3, int var4, int var5, String var6, String var7, EnumToolMaterial var8, float var9)
	{
		super(var1, var8);
		damage = var2;
		fireTotal = var5;
		fireTime = fireTotal;
		reloadTotal = 5;
		reloadTime = var4;
		ammo = var3;
		clipid = var4;
		firesound = var6;
		reloadsound = var7;
		setMaxStackSize(1);
		setMaxDamage(var3);
		clipSize = var3;
		scopeDist = var9;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		//var2.playSoundAtEntity(var3, firesound, 1.0F, 1.0F);

		if (!var2.isRemote && var1.getItemDamage() < ammo)
		{
			if (fireTime == fireTotal && fireTotal != 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, damage, 1));
				var2.playSoundAtEntity(var3, firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
				fireTime = 0;
			}
			else
			{
				++fireTime;
			}

			if (fireTotal == 0)
			{
				var2.spawnEntityInWorld(new EntityBullet(var2, var3, damage, 1));
				var2.playSoundAtEntity(var3, firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
			}
		}
		else if (!var2.isRemote && var3.inventory.hasItem(FalloutMain.a556.itemID) && var1.getItemDamage() == ammo)
		{
			if (reloadTime == reloadTotal)
			{
				reloadTime = 0;
				var2.playSoundAtEntity(var3, reloadsound, 1.0F, 1.0F);
				var3.inventory.consumeInventoryItem(FalloutMain.a556.itemID);
				count += 1;
				var1.setItemDamage(0);
				count = 0;
			}
			else
			{
				++reloadTime;
			}
		}

		return var1;
	}

	/**
	 * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	 */
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
	{
		fireTime = fireTotal;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
	}

	/**public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5)
	{		
		if (FalloutMain.isScoped)
		{
			ModLoader.getMinecraftInstance().gameSettings.fovSetting = scopeDist;
			MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleChineseAssault.itemID, new RenderChineseAssaultRifleScoped());
			MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleRatslayer.itemID, new RenderRatslayerScoped());
			MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleBozar.itemID, new RenderBozarScope());

		}
		else
		{
			ModLoader.getMinecraftInstance().gameSettings.fovSetting = 0.0F;
			MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleChineseAssault.itemID, new RenderChineseAssaultRifle());
			MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleRatslayer.itemID, new RenderRatslayer());
			MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleBozar.itemID, new RenderBozar());
		}
	}**/

	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		var3.add("DAM: " + (double) damage/2);
		var3.add("Clip size: " + clipSize);
		var3.add("Ammo type: 5.56mm Rounds");
	}
}