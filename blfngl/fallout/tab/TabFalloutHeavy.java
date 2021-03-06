package blfngl.fallout.tab;

import net.minecraft.creativetab.CreativeTabs;
import blfngl.fallout.FalloutMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabFalloutHeavy extends CreativeTabs
{
	public TabFalloutHeavy(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return FalloutMain.minigun.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Fallout - Heavy Weapons";
	}
}