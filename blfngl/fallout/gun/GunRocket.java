package blfngl.fallout.gun;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import blfngl.fallout.FalloutMain;
import blfngl.fallout.model.EntityRocket;

public class GunRocket extends ItemSword
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

	public GunRocket(int par1, int var2, int var3, int var4, int var5, String var6, String var7, EnumToolMaterial var8)
	{
		super(par1, var8);
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

	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		if (var3.inventory.hasItem(FalloutMain.aRocket.itemID))
		{
			var2.playSoundAtEntity(var3, this.firesound, 2.0F, 1.0F);
			EntityRocket var4 = new EntityRocket(var2, var3);
			var2.spawnEntityInWorld(var4);
			var3.inventory.consumeInventoryItem(FalloutMain.aRocket.itemID);
			return var1;
		}
		return var1;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		var3.add("DAM: " + (double) damage/2);
		var3.add("Clip size: " + clipSize);
		var3.add("Ammo type: Rockets");
	}
}

