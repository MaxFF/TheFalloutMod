package blfngl.fallout.food;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemWeaponBinding extends ItemFood
{
	public ItemWeaponBinding(int i, int j, boolean B)
	{
		super(i, j, B);
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}
	
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		entityPlayer.getFoodStats().addStats(this);
		world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
		itemStack.stackSize--;

		entityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1 * 120, 0));
		entityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 1 * 10, 0));
		entityPlayer.addPotionEffect(new PotionEffect(Potion.poison.id, 1 * 120, 0));

		return new ItemStack(Item.glassBottle);
	}
	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}