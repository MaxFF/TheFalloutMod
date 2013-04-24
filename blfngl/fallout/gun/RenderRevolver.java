package blfngl.fallout.gun;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderRevolver implements IItemRenderer
{
	
	protected ModelRevolver mag357Model;
	
	public RenderRevolver()
	{
		mag357Model = new ModelRevolver();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED: return true;
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch(type)
		{
			case EQUIPPED:
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture("/blfngl/fallout/textures/models/Revolver.png");
				mag357Model.render((Entity)data[1], 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.0625F);
				GL11.glPopMatrix();
			}
			default:
				break;
		}
	}
}
