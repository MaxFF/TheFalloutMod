package blfngl.fallout.tabs;

import net.minecraft.creativetab.CreativeTabs;
import blfngl.fallout.common.FalloutMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabFalloutMisc extends CreativeTabs
{
	public TabFalloutMisc(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return FalloutMain.ScrapMetal.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Fallout - Miscellaneous";
	}
}