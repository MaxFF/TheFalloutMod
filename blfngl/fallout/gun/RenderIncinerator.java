package blfngl.fallout.gun;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderIncinerator implements IItemRenderer
{
	
	protected ModelIncinerator incineratorModel;
	
	public RenderIncinerator()
	{
		incineratorModel = new ModelIncinerator();
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
				Minecraft.getMinecraft().renderEngine.bindTexture("/mob/cow.png");
				incineratorModel.render((Entity)data[1], 0.05F, 0.05F, 0.05F, 0.05F, 0.05F, 0.0625F);
				GL11.glPopMatrix();
			}
			default:
				break;
		}
	}
}
