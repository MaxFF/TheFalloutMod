package blfngl.fallout.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraftforge.common.MinecraftForge;
import blfngl.fallout.common.FalloutCommonProxy;
import blfngl.fallout.entity.EntityBOSPaladin;
import blfngl.fallout.entity.EntityBrahmin;
import blfngl.fallout.entity.EntityFGhoul;
import blfngl.fallout.entity.EntityGecko;
import blfngl.fallout.entity.EntityGiantAnt;
import blfngl.fallout.entity.EntityGlowingOne;
import blfngl.fallout.entity.EntityNightStalker;
import blfngl.fallout.entity.EntityRadio;
import blfngl.fallout.entity.EntityRadroach;
import blfngl.fallout.entity.ModelBrahmin;
import blfngl.fallout.entity.ModelGecko;
import blfngl.fallout.entity.ModelGiantAnt;
import blfngl.fallout.entity.ModelNightStalker;
import blfngl.fallout.entity.ModelRadio;
import blfngl.fallout.entity.RenderBOSPaladin;
import blfngl.fallout.entity.RenderBrahmin;
import blfngl.fallout.entity.RenderFGhoul;
import blfngl.fallout.entity.RenderGecko;
import blfngl.fallout.entity.RenderGiantAnt;
import blfngl.fallout.entity.RenderGlowingOne;
import blfngl.fallout.entity.RenderNightStalker;
import blfngl.fallout.entity.RenderRadio;
import blfngl.fallout.entity.RenderRadroach;
import blfngl.fallout.gun.EntityBullet;
import blfngl.fallout.sounds.FalloutSoundHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FalloutClientProxy extends FalloutCommonProxy
{

	@Override
	public void registerRenderers()
	{
		//MinecraftForgeClient.preloadTexture(ITEMS_PNG);

		RenderingRegistry.registerEntityRenderingHandler(EntityFGhoul.class, new RenderFGhoul(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGlowingOne.class, new RenderGlowingOne(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrahmin.class, new RenderBrahmin(new ModelBrahmin(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantAnt.class, new RenderGiantAnt(new ModelGiantAnt(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNightStalker.class, new RenderNightStalker(new ModelNightStalker(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBOSPaladin.class, new RenderBOSPaladin(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRadroach.class, new RenderRadroach(new ModelSilverfish(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRadio.class, new RenderRadio(new ModelRadio(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGecko.class, new RenderGecko(new ModelGecko(), 0.5F));

		//TODO MinecraftForgeClient.registerItemRenderer(FalloutMain.LaserRifle.itemID, (IItemRenderer)new RenderLaserRifle());
		//TODO MinecraftForgeClient.registerItemRenderer(FalloutMain.g357Mag.itemID, (IItemRenderer)new RenderRevolver());
		//MinecraftForgeClient.registerItemRenderer(FalloutMain.g44Mag.itemID, (IItemRenderer)new RenderRevolver());
		//TODO MinecraftForgeClient.registerItemRenderer(FalloutMain.Incinerator.itemID, (IItemRenderer)new RenderIncinerator());
	}        

	public int addArmor(String Armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(Armor);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void registerSoundHandler()
	{
		MinecraftForge.EVENT_BUS.register(new FalloutSoundHandler());
    }
}