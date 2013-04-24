package blfngl.fallout.entity;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import blfngl.fallout.common.FalloutMain;

public class SoundFGhoulLive
{
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try 
		{
			event.manager.soundPoolSounds.addSound("fallout/FGhoulTalk.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulTalk.ogg"));            
			event.manager.soundPoolSounds.addSound("fallout/FGhoulTalk1.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulTalk1.ogg"));            
			event.manager.soundPoolSounds.addSound("fallout/FGhoulTalk2.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulTalk2.ogg"));            
		} 
		catch (Exception e)
		{
			System.err.println("Failed to register one or more sounds.");
		}
	}
}
