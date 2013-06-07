package blfngl.fallout.gun;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
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
	private double reloadtick;
	private double reloadmax;
	private double firetick;
	private double firemax;
	private String firesound;
	private String reloadsound;
	public int clipSize;
	public Item ammoType;
	private int critChance;
	private int critDamage;
	public int rounds;
	public double CND;
	public String name;
	
    Random rand = new Random();
	
    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

	public ItemGun(int var1, int var2, int var3, double var4, double var5, String var6, String var7, EnumToolMaterial var8, Item var9)
	{
		super(var1);
		damage = var2;
		firemax = var5*10;
		firetick = firemax;
		reloadmax = 50;
		reloadtick = var4;
		firesound = var6;
		reloadsound = var7;
		setMaxStackSize(1);
		setMaxDamage(256);
		clipSize = var3;
		ammoType = var9;
		critChance = 5;
		critDamage = 4;
	}
	
	public ItemGun(int var1, int var2, int var3, int var4, int var5, String var6, String var7, EnumToolMaterial var8, Item var9, int var10, int var11, int var12)
	{
		super(var1);
		damage = var2;
		firemax = var5*10;
		firetick = firemax;
		reloadmax = 50;
		reloadtick = var4;
		firesound = var6;
		reloadsound = var7;
		setMaxStackSize(1);
		setMaxDamage(var12);
		clipSize = var3;
		ammoType = var9;
		critChance = var10;
		critDamage = var11;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
	{
		if (!var2.isRemote && rounds > 0)
		{
			if (firetick == firemax && firemax != 0)
			{
				if(rand.nextInt(100)+1 <= critChance)
				{
					var2.spawnEntityInWorld(new EntityBullet(var2, var3, damage+rand.nextInt(critDamage)+1, 1));
				}
				else
				{
					var2.spawnEntityInWorld(new EntityBullet(var2, var3, damage, 1));
				}
				var2.playSoundAtEntity(var3, firesound, 1.0F, 1.0F);
				var1.damageItem(1, var3);
				if(!var3.capabilities.isCreativeMode){rounds-=1;}
				firetick = 0;
			}
		}
		
		if (firetick == firemax && firemax != 0 && rounds > 0)
		{
			var3.cameraPitch -= 7.0F;
		}

		return var1;
	}

	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	
	/**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	name = par3EntityPlayer.username;
    }

	/*public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		CND = (var1.getMaxDamage()-var1.getItemDamage())/var1.getMaxDamage();
		var3.add("§cDAM: " + (double)damage/2/*((double)damage/2)*((double)0.54 + CND * (1-(double)0.54D))); //TODO After fixed condition appearance
		var3.add("§9Clip size: " + rounds + "/" + clipSize + " Ammo Loaded");
		var3.add("§9Ammo type: " + ammoType.getItemDisplayName(new ItemStack(ammoType)));
		var3.add("§9CND: "+CND*100+"%"); //TODO Fix condition appearance
		if(name!=null)
		{
			var3.add("§eCrafted by: " + name);
		}
		else
		{
			var3.add("§eNot crafted.");
		}
	}*/
	
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		CND = (var1.getMaxDamage()-var1.getItemDamage())/var1.getMaxDamage();
		var3.add("\u00A74DAM: " + ((double)damage/2)*((double)0.54 + CND * (1-(double)0.54D))); //TODO After fixed condition appearance
		var3.add("\u00A79Clip size: " + rounds + "/" + clipSize + " Ammo Loaded");
		var3.add("\u00A72Ammo type: " + ammoType.getItemDisplayName(new ItemStack(ammoType)));
		var3.add("\u00A76CND: "+Math.round(CND*100)+"%"); //TODO Fix condition appearance
		if(name !=null){var3.add("\u00A7eCrafted by: " + name);}
		else{var3.add("\u00A7eNot crafted.");}
	}
	
	/**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World var2, Entity par3Entity, int par4, boolean par5) 
    {
    	EntityPlayer var3 = (EntityPlayer)par3Entity;
    	CND = par1ItemStack.getItemDamage()/par1ItemStack.getMaxDamage();
		if (!var2.isRemote && var3.inventory.hasItem(ammoType.itemID) && rounds<clipSize && Keyboard.isKeyDown(Keyboard.KEY_R) && var3.getHeldItem()==par1ItemStack)
		{
			var2.playSoundAtEntity(var3, reloadsound, 1.0F, 1.0F);
			reloadtick=0;
			while (rounds<clipSize && var3.inventory.hasItem(ammoType.itemID))
			{
				if(reloadtick>=reloadmax)
				{
					var3.inventory.consumeInventoryItem(ammoType.itemID);
					rounds += 1;
				}
				if(rounds>=clipSize){break;}
			}
		}
    	if(reloadtick<reloadmax)
    	{
    		reloadtick+=1;
    	}
    	if(firetick<firemax)
    	{
    		firetick+=1;
    	}
    }
}
