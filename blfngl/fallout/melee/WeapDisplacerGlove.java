package blfngl.fallout.melee;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class WeapDisplacerGlove extends ItemSword
{
	public WeapDisplacerGlove(int itemID, EnumToolMaterial material)
	{
		super(itemID, material);
	}

	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    par1ItemStack.addEnchantment(Enchantment.knockback, 10);
    }

	public void func_94581_a(IconRegister iconRegister)
	{
		iconIndex = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}