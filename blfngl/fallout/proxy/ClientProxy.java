package blfngl.fallout.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import blfngl.fallout.FalloutMain;
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
import blfngl.fallout.handler.ScopeHandler;
import blfngl.fallout.handler.SoundHandler;
import blfngl.fallout.render.RenderBozar;
import blfngl.fallout.render.RenderRatslayer;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityFGhoul.class, new RenderFGhoul(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGlowingOne.class, new RenderGlowingOne(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrahmin.class, new RenderBrahmin(new ModelBrahmin(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantAnt.class, new RenderGiantAnt(new ModelGiantAnt(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNightStalker.class, new RenderNightStalker(new ModelNightStalker(), 1.0F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBOSPaladin.class, new RenderBOSPaladin(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRadroach.class, new RenderRadroach(new ModelSilverfish(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRadio.class, new RenderRadio(new ModelRadio(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGecko.class, new RenderGecko(new ModelGecko(), 0.5F));
		//RenderingRegistry.registerEntityRenderingHandler(EntityFragGrenade.class, new RenderFragGrenade(new ModelBiped(), 0.5F));

		MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleBozar.itemID, (IItemRenderer)new RenderBozar());
		MinecraftForgeClient.registerItemRenderer(FalloutMain.rifleRatslayer.itemID, (IItemRenderer)new RenderRatslayer());

		KeyBinding[] var1 = new KeyBinding[] {new KeyBinding("Scope", 33)};
		boolean[] var2 = new boolean[] {false};
		KeyBindingRegistry.registerKeyBinding(new ScopeHandler(var1, var2));
	}        

	public int addArmor(String Armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(Armor);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerSoundHandler()
	{
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
}