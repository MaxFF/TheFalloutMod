package blfngl.fallout.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import blfngl.fallout.common.FalloutMain;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler
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

			//Version 1.7.2
			event.manager.soundPoolSounds.addSound("blfngl/45Fire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/45Fire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MinigunReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MinigunReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MultiplasFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MultiplasFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MysteriousMagnumThrown.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MysteriousMagnumThrown.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/Pistol556Fire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/Pistol556Fire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/Pistol556Reload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/Pistol556Reload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/PlasmaCasterFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/PlasmaCasterFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/PlasmaRifleFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/PlasmaRifleFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/PlasmaRifleReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/PlasmaRifleReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/TriBeamFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/TriBeamFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/TriBeamReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/TriBeamReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/HoloFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/HoloFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MinigunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MinigunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/GaussFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/GaussFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/GaussReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/GaussReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/9mmFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/9mmFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/9mmReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/9mmReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/DefenderFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/DefenderFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/HuntingFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/HuntingFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/HuntingReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/HuntingReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/PlasmaPistolFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/PlasmaPistolFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/PlasmaPistolReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/PlasmaPistolReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/RechargerFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/RechargerFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/TeslaFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/TeslaFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/TeslaReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/TeslaReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/RedGlareFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/RedGlareFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/RedGlareReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/RedGlareReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MissileFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MissileFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MissileReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MissileReload.ogg"));
			
			event.manager.soundPoolSounds.addSound("blfngl/AutomaticRifleFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AutomaticRifleFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/BattleRifleFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/BattleRifleFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/BattleRifleReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/BattleRifleReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/BrushGunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/BrushGunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/CowboyRepeaterFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/CowboyRepeaterFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/HuntingRifleFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/HuntingRifleFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/HuntingRifleReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/HuntingRifleReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/RepeaterReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/RepeaterReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/HuntingShotgunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/HuntingShotgunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/HuntingShotgunReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/HuntingShotgunReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/AlienBlasterFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AlienBlasterFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/AlienBlasterReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AlienBlasterReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/PulseFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/PulseFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/LaserPistolReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/LaserPistolReload.ogg"));

			//TODO Version 1.7.3
			event.manager.soundPoolSounds.addSound("blfngl/AssaultFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AssaultFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/AssaultReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/AssaultReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/ChristineFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/ChristineFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/ChristineReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/ChristineReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/LMGFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/LMGFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/LMGReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/LMGReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/RatslayerFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/RatslayerFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/TrailCarbineFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/TrailCarbineFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/VarmintRifleFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/VarmintRifleFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MaterielFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MaterielFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MaterialReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MaterialReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MarksmanFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MarksmanFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/MarksmanReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/MarksmanReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/127SmgReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/127SmgReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/NailgunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/NailgunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/SleepytymeFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/SleepytymeFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/CaravanShotgunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/CaravanShotgunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/CaravanShotgunReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/CaravanShotgunReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/LeverShotgunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/LeverShotgunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/LeverShotgunReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/LeverShotgunReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/SingleShotgunReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/SingleShotgunReload.ogg"));
			
			event.manager.soundPoolSounds.addSound("blfngl/ChineseAssaultFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/ChineseAssaultFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/ChineseAssaultReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/ChineseAssaultReload.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/FlareGunFire.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FlareGunFire.ogg"));
			event.manager.soundPoolSounds.addSound("blfngl/FlareGunReload.ogg", FalloutMain.class.getResource("/blfngl/fallout/sounds/FlareGunReload.ogg"));

		}

		catch (Exception e)
		{
			System.err.println("Failed to register one or more sounds.");
		}
	}
}