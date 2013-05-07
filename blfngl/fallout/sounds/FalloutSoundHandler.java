package blfngl.fallout.sounds;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import blfngl.fallout.common.FalloutMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FalloutSoundHandler
{
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		try 
		{
			event.manager.soundPoolSounds.addSound("blfngl/LaserFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/LaserFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/IncineratorShoot.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/IncineratorShoot.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/357Fire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/357Fire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/44Fire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/44Fire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/RCWFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/RCWFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/Silenced22Fire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/Silenced22Fire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/SniperFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/SniperFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/LaserPistolFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/LaserPistolFire.ogg"));

			event.manager.soundPoolSounds.addSound("blfngl/AntTalk.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AntTalk.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/AntTalk1.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AntTalk1.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/AntHurt.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AntHurt.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/AntHurt2.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AntHurt1.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/FGhoulTalk.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulTalk.ogg"));         
			event.manager.soundPoolSounds.addSound("blfngl/FGhoulTalk1.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulTalk1.ogg"));         
			event.manager.soundPoolSounds.addSound("blfngl/FGhoulTalk2.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulTalk2.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/FGhoulHurt.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulHurt.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/FGhoulHurt1.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulHurt1.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/FGhoulHurt2.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FGhoulHurt2.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/NightstalkerTalk.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/NightstalkerTalk.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/NightstalkerTalk1.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/NightstalkerTalk1.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/NightstalkerHurt.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/NightstalkerHurt.ogg"));

			//Version 1.7.1
			event.manager.soundPoolSounds.addSound("blfngl/RCWReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/RCWReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/ComplianceReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/ComplianceReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/44Reload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/44Reload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/357Reload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/357Reload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/SniperReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/SniperReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/10MMFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/10MMFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/10MMReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/10MMReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/ShotgunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/ShotgunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/ShotgunReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/ShotgunReload.ogg"));

		}

		catch (Exception e)
		{
			System.err.println("Failed to register one or more sounds.");
		}
	}
}