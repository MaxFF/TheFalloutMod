package blfngl.fallout.tabs;

import net.minecraft.creativetab.CreativeTabs;
import blfngl.fallout.common.FalloutMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabFalloutGuns extends CreativeTabs
{
	public TabFalloutGuns(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return FalloutMain.rifleLaser.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "Fallout - Guns";
	}
}