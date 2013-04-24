package blfngl.fallout.common;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public final class TabFalloutTab extends CreativeTabs
{
	public TabFalloutTab(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return FalloutMain.T45Helm.itemID;
	}

	public String getTranslatedTabLabel()
	{
		return "The Fallout Tab";
	}
}