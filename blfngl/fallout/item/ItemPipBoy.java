package blfngl.fallout.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class ItemPipBoy extends Item
{
	public Minecraft mc;
	protected ItemPipBoy(int par1)
	{
		super(par1);
		this.setCreativeTab(CreativeTabs.tabFood);
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		Object var4 = null;
		//ModLoader.openGUI(entityplayer, new GuiPipBoy());
		return itemstack;
	}
	public void func_94581_a(IconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("blfngl:PipBoy");
	}
}