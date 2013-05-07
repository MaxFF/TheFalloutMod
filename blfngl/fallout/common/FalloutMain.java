package blfngl.fallout.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import blfngl.fallout.armor.ArmorBaseEnclave;
import blfngl.fallout.armor.ArmorBaseGecko1;
import blfngl.fallout.armor.ArmorBaseHellfire;
import blfngl.fallout.armor.ArmorBaseT45;
import blfngl.fallout.armor.ArmorBaseT51;
import blfngl.fallout.armor.ArmorBaseWinter;
import blfngl.fallout.block.BlockAsbestosDeposit;
import blfngl.fallout.block.BlockBPGlass;
import blfngl.fallout.block.BlockCarbonDeposit;
import blfngl.fallout.block.BlockSaturniteOre;
import blfngl.fallout.block.BlockSiliconDeposit;
import blfngl.fallout.block.BlockTechnetiumOre;
import blfngl.fallout.block.BlockTungstenOre;
import blfngl.fallout.block.BlockUraniumOre;
import blfngl.fallout.block.WorldGenAsbestosDeposit;
import blfngl.fallout.block.WorldGenCarbonDeposit;
import blfngl.fallout.block.WorldGenSatOre;
import blfngl.fallout.block.WorldGenSiliconDeposit;
import blfngl.fallout.block.WorldGenTechOre;
import blfngl.fallout.block.WorldGenTungstenOre;
import blfngl.fallout.block.WorldGenUraniumOre;
import blfngl.fallout.client.FalloutClientProxy;
import blfngl.fallout.entity.EntityBOSPaladin;
import blfngl.fallout.entity.EntityBrahmin;
import blfngl.fallout.entity.EntityFGhoul;
import blfngl.fallout.entity.EntityGecko;
import blfngl.fallout.entity.EntityGiantAnt;
import blfngl.fallout.entity.EntityGlowingOne;
import blfngl.fallout.entity.EntityNightStalker;
import blfngl.fallout.entity.EntityRadroach;
import blfngl.fallout.food.BlockBananaYucca;
import blfngl.fallout.food.BlockBarrelCactus;
import blfngl.fallout.food.BlockBrocFlower;
import blfngl.fallout.food.BlockBuffaloGourd;
import blfngl.fallout.food.BlockCaveFungus;
import blfngl.fallout.food.BlockJalapeno;
import blfngl.fallout.food.BlockXanderRoot;
import blfngl.fallout.food.ItemHP;
import blfngl.fallout.food.ItemHydra;
import blfngl.fallout.food.ItemJet;
import blfngl.fallout.food.ItemMedEx;
import blfngl.fallout.food.ItemNukaQuartz;
import blfngl.fallout.food.ItemNukaVictory;
import blfngl.fallout.food.ItemPsycho;
import blfngl.fallout.food.ItemRocket;
import blfngl.fallout.food.ItemSlasher;
import blfngl.fallout.food.ItemStealthBoy;
import blfngl.fallout.food.ItemSuperStimpak;
import blfngl.fallout.food.ItemTurbo;
import blfngl.fallout.food.ItemWeaponBinding;
import blfngl.fallout.food.ItembCaveFungus;
import blfngl.fallout.food.ItembXanderRoot;
import blfngl.fallout.food.WorldGenBrocFlower;
import blfngl.fallout.gun.Gun10MM;
import blfngl.fallout.gun.Gun22LR;
import blfngl.fallout.gun.Gun308;
import blfngl.fallout.gun.Gun357;
import blfngl.fallout.gun.Gun44;
import blfngl.fallout.gun.GunECell;
import blfngl.fallout.gun.GunIncinerator;
import blfngl.fallout.gun.GunMFCell;
import blfngl.fallout.item.BaseDrink;
import blfngl.fallout.item.BaseFood;
import blfngl.fallout.item.BaseItem;
import blfngl.fallout.item.ItemSyringe;
import blfngl.fallout.melee.BaseMelee;
import blfngl.fallout.melee.WeapBallisticFist;
import blfngl.fallout.melee.WeapBotE;
import blfngl.fallout.melee.WeapCosFire;
import blfngl.fallout.melee.WeapDisplacerGlove;
import blfngl.fallout.melee.WeapFlamingShish;
import blfngl.fallout.melee.WeapPowerFist;
import blfngl.fallout.melee.WeapSatHeatFist;
import blfngl.fallout.melee.WeapSciGlove;
import blfngl.fallout.melee.WeapShishkebab;
import blfngl.fallout.melee.WeapZapGlove;
import blfngl.fallout.tabs.TabFalloutArmor;
import blfngl.fallout.tabs.TabFalloutFood;
import blfngl.fallout.tabs.TabFalloutGuns;
import blfngl.fallout.tabs.TabFalloutMisc;
import blfngl.fallout.tabs.TabFalloutWeap;
import blfngl.fallout.throwing.EntityFragGrenade;
import blfngl.fallout.throwing.ItemBottleCapMine;
import blfngl.fallout.throwing.ItemFragGrenade;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * The Fallout Mod
 * 
 * @Author blfngl
 * @License Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * The code in this repository, in any form, is the copyright of blfngl
 **/

@Mod(modid = "fallout", name = "The Fallout Mod", version = "MC1.5.1 - TFMv1.7")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class FalloutMain
{

	@Instance("fallout")
	public static FalloutMain instance;

	@SidedProxy(clientSide="blfngl.fallout.client.FalloutClientProxy", serverSide="blfngl.fallout.common.FalloutCommonProxy")
	public static FalloutCommonProxy proxy;
	public static FalloutClientProxy cproxy;

	public static CreativeTabs TabFalloutArmor = new TabFalloutArmor(CreativeTabs.getNextID(), "TabFalloutArmor");
	public static CreativeTabs TabFalloutGuns = new TabFalloutGuns(CreativeTabs.getNextID(), "TabFalloutGuns");
	public static CreativeTabs TabFalloutFood = new TabFalloutFood(CreativeTabs.getNextID(), "TabFalloutFood");
	public static CreativeTabs TabFalloutMisc = new TabFalloutMisc(CreativeTabs.getNextID(), "TabFalloutMisc");
	public static CreativeTabs TabFalloutWeap = new TabFalloutWeap(CreativeTabs.getNextID(), "TabFalloutWeap");

	//========================================Enums========================================================

	public static EnumToolMaterial SATHEAT = EnumHelper.addToolMaterial("SATHEAT", 0, 595, 10.0F, 8, 27);
	public static EnumToolMaterial PFIST = EnumHelper.addToolMaterial("PFIST", 0, 395, 10.0F, 7, 25);
	public static EnumToolMaterial SCI = EnumHelper.addToolMaterial("SCI", 0, 316, 5.0F, 1, 6);
	public static EnumToolMaterial SAT = EnumHelper.addToolMaterial("SAT", 0, 795, 10.0F, 8, 25);
	public static EnumToolMaterial CLEAVE = EnumHelper.addToolMaterial("CLEAVE", 0, 995, 10.0F, 3, 27);
	public static EnumToolMaterial COMKNIFE = EnumHelper.addToolMaterial("COMKNIFE", 0, 995, 5.0F, 4, 27);
	public static EnumToolMaterial BOTE = EnumHelper.addToolMaterial("BOTE", 0, 1024, 10.0F, 15, 27);
	public static EnumToolMaterial COS = EnumHelper.addToolMaterial("COS", 0, 995, 10.0F, 10, 27);
	public static EnumToolMaterial COSFIRE = EnumHelper.addToolMaterial("COSKNIFE", 0, 1024, 10.0F, 12, 27);
	public static EnumToolMaterial PINT = EnumHelper.addToolMaterial("PINT", 0, 100, 200.0F, 200, 10);

	public static EnumArmorMaterial T45POWER = EnumHelper.addArmorMaterial("T45POWER", 35, new int[]{2, 6, 5, 2}, 25);
	public static EnumArmorMaterial ENCLAVE = EnumHelper.addArmorMaterial("ENCLAVE", 37, new int[]{2, 6, 5, 2}, 28);
	public static EnumArmorMaterial T51POWER = EnumHelper.addArmorMaterial("T51POWER", 39, new int[]{2, 6, 5, 2}, 33);
	public static EnumArmorMaterial HELLFIRE = EnumHelper.addArmorMaterial("HELLFIRE", 41, new int []{2, 6, 5, 2}, 35);
	public static EnumArmorMaterial WINTER = EnumHelper.addArmorMaterial("WINTER", 42, new int []{2, 6, 5, 2}, 35);

	//========================================Guns==========================================================

	//KEY: ID, damage, usage size/clip, reload time, fire time, fire sound, reload sound
	public static final Item Incinerator = new GunIncinerator(509).setUnlocalizedName("Incinerator").setCreativeTab(TabFalloutGuns);
	public static final Item LaserRCW = new GunMFCell(510, 2, 60, 2, 1, "blfngl.LaserFire", "blfngl.RCWReload").setUnlocalizedName("LaserRCW").setCreativeTab(TabFalloutGuns);
	public static final Item Compliance = new GunECell(511, 2, 30, 2, 3, "blfngl.LaserPistolFire", "blfngl.ComplianceReload").setUnlocalizedName("Compliance").setCreativeTab(TabFalloutGuns);
	public static final Item LaserRifle = new GunMFCell(512, 7, 24, 3, 4, "blfngl.LaserFire", "blfngl.LaserReload").setUnlocalizedName("LaserRifle").setCreativeTab(TabFalloutGuns);
	public static final Item g44Mag = new Gun44(513, 10, 6, 3, 5, "blfngl.44Fire", "blfngl.44Reload").setUnlocalizedName("g44Mag").setCreativeTab(TabFalloutGuns);
	public static final Item g357Mag = new Gun357(514, 8, 6, 1, 5, "blfngl.357Fire", "blfngl.357Reload").setUnlocalizedName("g357Mag").setCreativeTab(TabFalloutGuns);
	public static final Item Silenced22 = new Gun22LR(515, 12, 12, 2, 2, "blfngl.Silenced22Fire", "blfngl.Silenced22Fire").setUnlocalizedName("Silenced22").setCreativeTab(TabFalloutGuns);
	public static final Item Sniper308 = new Gun308(516, 7, 5, 3, 2, "blfngl.SniperFire", "blfngl.SniperReload").setUnlocalizedName("Sniper308").setCreativeTab(TabFalloutGuns);

	//========================================Melee Weapons=================================================

	public static final Item BotE = new WeapBotE(517, BOTE).setUnlocalizedName("BotE").setCreativeTab(TabFalloutWeap);
	public static final Item BumperSword = new WeapBotE(518, EnumToolMaterial.EMERALD).setUnlocalizedName("BumperSword").setCreativeTab(TabFalloutWeap);
	public static final Item Cleaver = new BaseMelee(519, CLEAVE).setUnlocalizedName("Cleaver").setCreativeTab(TabFalloutWeap);
	public static final Item ComKnife = new BaseMelee(520, COMKNIFE).setUnlocalizedName("ComKnife").setCreativeTab(TabFalloutWeap);
	public static final Item CosKnife = new BaseMelee(521, COS).setUnlocalizedName("CosKnife").setCreativeTab(TabFalloutWeap);
	public static final Item CosClean = new BaseMelee(522, COS).setUnlocalizedName("CosClean").setCreativeTab(TabFalloutWeap);
	public static final Item CosFire = (new WeapCosFire(523)).setUnlocalizedName("CosFire").setCreativeTab(TabFalloutWeap);
	public static final Item FireAxe = new BaseMelee(524, EnumToolMaterial.IRON).setUnlocalizedName("FireAxe").setCreativeTab(TabFalloutWeap);
	public static final Item Knife = new BaseMelee(525, EnumToolMaterial.STONE).setUnlocalizedName("Knife").setCreativeTab(TabFalloutWeap);
	public static final Item Machete = new BaseMelee(526, EnumToolMaterial.IRON).setUnlocalizedName("Machete").setCreativeTab(TabFalloutWeap);
	public static final Item Shishkebab = new WeapShishkebab(527, EnumToolMaterial.IRON).setUnlocalizedName("Shishkebab").setCreativeTab(TabFalloutWeap);
	public static final Item StraightRazor = new BaseMelee(528, EnumToolMaterial.STONE).setUnlocalizedName("StraightRazor").setCreativeTab(TabFalloutWeap);
	public static final Item Switchblade = new BaseMelee(529, EnumToolMaterial.STONE).setUnlocalizedName("Switchblade").setCreativeTab(TabFalloutWeap);
	public static final Item PintSizedKnife = new BaseMelee(530, PINT).setUnlocalizedName("PintSizedKnife").setCreativeTab(TabFalloutWeap);

	//========================================Unarmed Weapons===============================================

	public static final Item BallisticFist = new WeapBallisticFist(531, EnumToolMaterial.IRON).setUnlocalizedName("BallisticFist").setCreativeTab(TabFalloutWeap);
	public static final Item BladedGauntlet = new BaseMelee(532, EnumToolMaterial.IRON).setUnlocalizedName("BladedGauntlet").setCreativeTab(TabFalloutWeap);
	public static final Item BoxingGloves = new BaseMelee(533, EnumToolMaterial.WOOD).setUnlocalizedName("BoxingGloves").setCreativeTab(TabFalloutWeap);
	public static final Item BrassKnuckles = new BaseMelee(534, EnumToolMaterial.STONE).setUnlocalizedName("BrassKnuckles").setCreativeTab(TabFalloutWeap);
	public static final Item DisplacerGlove = new WeapDisplacerGlove(535, PFIST).setUnlocalizedName("DisplacerGlove").setCreativeTab(TabFalloutWeap);
	public static final Item GoldenGloves = new BaseMelee(536, EnumToolMaterial.GOLD).setUnlocalizedName("GoldenGloves").setCreativeTab(TabFalloutWeap);
	public static final Item PowerFist = new WeapPowerFist(537, EnumToolMaterial.EMERALD).setUnlocalizedName("PowerFist").setCreativeTab(TabFalloutWeap);
	public static final Item SatFist = new WeapPowerFist(538, EnumToolMaterial.EMERALD).setUnlocalizedName("SatFist").setCreativeTab(TabFalloutWeap);
	public static final Item SatHeatFist = new WeapSatHeatFist(539, PFIST).setUnlocalizedName("SatHeatFist").setCreativeTab(TabFalloutWeap);
	public static final Item SciGlove = new WeapSciGlove(540, SCI).setUnlocalizedName("SciGlove").setCreativeTab(TabFalloutWeap);
	public static final Item ZapGlove = new WeapZapGlove(541, EnumToolMaterial.IRON).setUnlocalizedName("ZapGlove").setCreativeTab(TabFalloutWeap);

	//============================================Items==========================================================

	public static final Item chunkTungsten = (new BaseItem(400)).setUnlocalizedName("TungstenRod").setCreativeTab(TabFalloutMisc);
	public static final Item ingotTungsten = (new BaseItem(401)).setUnlocalizedName("TungstenIngot").setCreativeTab(TabFalloutMisc);
	public static final Item chunkTechnetium = (new BaseItem(402)).setUnlocalizedName("TechnetiumChunk").setCreativeTab(TabFalloutMisc);
	public static final Item ingotTechnetium = (new BaseItem(403)).setUnlocalizedName("TechnetiumIngot").setCreativeTab(TabFalloutMisc);
	public static final Item chunkSilicon = (new BaseItem(404)).setUnlocalizedName("SiliconChunk").setCreativeTab(TabFalloutMisc);
	public static final Item barSilicon = (new BaseItem(405)).setUnlocalizedName("SiliconBar").setCreativeTab(TabFalloutMisc);
	public static final Item tungstenFilter = (new BaseItem(406)).setUnlocalizedName("TungstenFilter").setCreativeTab(TabFalloutMisc);
	public static final Item chunkAsbestos = (new BaseItem(407)).setUnlocalizedName("AsbestosChunk").setCreativeTab(TabFalloutMisc);
	public static final Item barAsbestos = (new BaseItem(408)).setUnlocalizedName("AsbestosBar").setCreativeTab(TabFalloutMisc);
	public static final Item ingotUranium = (new BaseItem(409)).setUnlocalizedName("UraniumIngot").setCreativeTab(TabFalloutMisc);
	public static final Item tungstenPlate = (new BaseItem(410)).setUnlocalizedName("TungstenPlate").setCreativeTab(TabFalloutMisc);
	public static final Item technetiumPlate = (new BaseItem(411)).setUnlocalizedName("TechnetiumPlate").setCreativeTab(TabFalloutMisc);
	public static final Item RAP = (new BaseItem(412)).setUnlocalizedName("RAP").setCreativeTab(CreativeTabs.tabMaterials).setCreativeTab(TabFalloutMisc);
	public static final Item MFCell = (new BaseItem(413)).setUnlocalizedName("MFCell").setCreativeTab(TabFalloutMisc);
	public static final Item MFPack = (new BaseItem(414)).setUnlocalizedName("MFPack").setCreativeTab(TabFalloutMisc);
	public static final Item carbon = (new BaseItem(415)).setUnlocalizedName("Carbon").setCreativeTab(TabFalloutMisc);
	public static final Item teflon = (new BaseItem(416)).setUnlocalizedName("Teflon").setCreativeTab(TabFalloutMisc);
	public static final Item polyethylene = (new BaseItem(417)).setUnlocalizedName("Polyethylene").setCreativeTab(TabFalloutMisc);
	public static final Item bottleCap = (new BaseItem(418)).setUnlocalizedName("BottleCap").setCreativeTab(TabFalloutMisc);
	public static final Item fan = (new BaseItem(419)).setUnlocalizedName("Fan").setCreativeTab(TabFalloutMisc);
	public static final Item gear = (new BaseItem(420)).setUnlocalizedName("Gear").setCreativeTab(TabFalloutMisc);
	public static final Item gyro = (new BaseItem(421)).setUnlocalizedName("Gyro").setCreativeTab(TabFalloutMisc);
	public static final Item MASM = (new BaseItem(422)).setUnlocalizedName("MASM").setCreativeTab(TabFalloutMisc);
	public static final Item TXMF = (new BaseItem(423)).setUnlocalizedName("TXMF").setCreativeTab(TabFalloutMisc);
	public static final Item card = (new BaseItem(424)).setUnlocalizedName("Card").setCreativeTab(TabFalloutMisc);
	public static final Item deck = (new BaseItem(425)).setUnlocalizedName("Deck").setCreativeTab(TabFalloutMisc);
	public static final Item cardboard = (new BaseItem(426)).setUnlocalizedName("Cardboard").setCreativeTab(TabFalloutMisc);
	public static final Item tinCan = (new BaseItem(427)).setUnlocalizedName("TinCan").setCreativeTab(TabFalloutMisc);
	public static final Item chunkSaturnite = (new BaseItem(428)).setUnlocalizedName("SatRod").setCreativeTab(TabFalloutMisc);
	public static final Item ingotSaturnite = (new BaseItem(429)).setUnlocalizedName("SatIngot").setCreativeTab(TabFalloutMisc);
	public static final Item saturniteAlloy = (new BaseItem(430)).setUnlocalizedName("SatAlloy").setCreativeTab(TabFalloutMisc);
	public static final Item syringeEmpty = (new ItemSyringe(431)).setUnlocalizedName("EmptySyringe").setCreativeTab(TabFalloutMisc);
	public static final Item syringeBloody = (new BaseItem(432)).setUnlocalizedName("BloodSyringe").setCreativeTab(TabFalloutMisc);
	public static final Item powerTorso  = (new BaseItem(433)).setUnlocalizedName("PTorso").setCreativeTab(TabFalloutMisc);
	public static final Item powerShoulders  = (new BaseItem(434)).setUnlocalizedName("PShoulders").setCreativeTab(TabFalloutMisc);
	public static final Item powerChest = (new BaseItem(435)).setUnlocalizedName("PChest").setCreativeTab(TabFalloutMisc);
	public static final Item upgradeT45 = (new BaseItem(436)).setUnlocalizedName("T45Upgrade").setCreativeTab(TabFalloutMisc);
	public static final Item upgradeEnclave = (new BaseItem(437)).setUnlocalizedName("EnclaveUpgrade").setCreativeTab(TabFalloutMisc);	
	public static final Item upgradeT51 = (new BaseItem(438)).setUnlocalizedName("T51Upgrade").setCreativeTab(TabFalloutMisc);
	public static final Item upgradeHellfire = (new BaseItem(439)).setUnlocalizedName("HellfireUpgrade").setCreativeTab(TabFalloutMisc);
	public static final Item upgradeWinterized = (new BaseItem(440)).setUnlocalizedName("WinterizedUpgrade").setCreativeTab(TabFalloutMisc);
	public static final Item nukaBottle = (new BaseItem(441)).setUnlocalizedName("NukaBottle").setCreativeTab(TabFalloutMisc);
	public static final Item abraxo = (new BaseItem(442)).setUnlocalizedName("Abraxo").setCreativeTab(TabFalloutMisc);
	public static final Item a22LR = (new BaseItem(443)).setUnlocalizedName("a22LR").setCreativeTab(TabFalloutMisc);
	public static final Item a308 = (new BaseItem(444)).setUnlocalizedName("a308").setCreativeTab(TabFalloutMisc);
	public static final Item a357 = (new BaseItem(445)).setUnlocalizedName("a357").setCreativeTab(TabFalloutMisc);
	public static final Item a44 = (new BaseItem(446)).setUnlocalizedName("a44").setCreativeTab(TabFalloutMisc);
	public static final Item scrapMetal = (new BaseItem(447)).setUnlocalizedName("ScrapMetal").setCreativeTab(TabFalloutMisc);
	public static final Item ECell = (new BaseItem(448)).setUnlocalizedName("ECell").setCreativeTab(TabFalloutMisc);
	public static final Item homemadeFuel = (new BaseItem(449)).setUnlocalizedName("HomemadeFuel").setCreativeTab(TabFalloutMisc);
	public static final Item EPack = (new BaseItem(450)).setUnlocalizedName("EPack").setCreativeTab(TabFalloutMisc);
	public static final Item leatherBelt = (new BaseItem(451)).setUnlocalizedName("LeatherBelt").setCreativeTab(TabFalloutMisc);
	public static final Item bottleCapMine = (new ItemBottleCapMine(452)).setUnlocalizedName("BottleCapMine").setCreativeTab(TabFalloutMisc);
	public static final Item fragGrenade = (new ItemFragGrenade(453)).setUnlocalizedName("FragGrenade").setCreativeTab(TabFalloutMisc);
	public static final Item lunchbox = (new BaseItem(454)).setUnlocalizedName("Lunchbox").setCreativeTab(TabFalloutMisc);
	public static final Item sensorModule = (new BaseItem(455)).setUnlocalizedName("SensorModule").setCreativeTab(TabFalloutMisc);
	public static final Item cherrybomb = (new BaseItem(456)).setUnlocalizedName("Cherrybomb").setCreativeTab(TabFalloutMisc);
	public static final Item nightstalkerBlood = (new BaseItem(457)).setUnlocalizedName("NightstalkerBlood").setCreativeTab(TabFalloutMisc);
	public static final Item jetInhaler = (new BaseItem(458)).setUnlocalizedName("JetInhaler").setCreativeTab(TabFalloutMisc);
	public static final Item wonderglue = (new BaseItem(459)).setUnlocalizedName("Wonderglue").setCreativeTab(TabFalloutMisc);
	public static final Item turpentine = (new BaseItem(460)).setUnlocalizedName("Turpentine").setCreativeTab(TabFalloutMisc);
	public static final Item geckoHide = (new BaseItem(461)).setUnlocalizedName("GeckoHide").setCreativeTab(TabFalloutMisc);

	//============================================Food and Chems==========================================================

	public static final Item Stimpak = new BaseFood(462, 1, 0.3F, true).setPotionEffect(Potion.heal.id, 2, 0, 1F).setUnlocalizedName("Stimpak").setCreativeTab(TabFalloutFood);
	public static final Item SuperStimpak = new ItemSuperStimpak(463, 1, true).setUnlocalizedName("SuperStimpak").setCreativeTab(TabFalloutFood);
	public static final Item BCMAC = new BaseFood(464, 5, 0.3F, false).setUnlocalizedName("BCMAC").setCreativeTab(TabFalloutFood);
	public static final Item Cram = new BaseFood(465, 5, 0.3F, false).setUnlocalizedName("Cram").setCreativeTab(TabFalloutFood);
	public static final Item Instamash = new BaseFood(466, 5, 0.3F, false).setUnlocalizedName("Instamash").setCreativeTab(TabFalloutFood);
	public static final Item PorkBeans = new BaseFood(467, 5, 0.3F, false).setUnlocalizedName("PorkBeans").setCreativeTab(TabFalloutFood);
	public static final Item Salisbury = new BaseFood(468, 5, 0.3F, false).setUnlocalizedName("Salisbury").setCreativeTab(TabFalloutFood);
	public static final Item YumYum = new BaseFood(469, 5, 0.3F, false).setUnlocalizedName("YumYum").setCreativeTab(TabFalloutFood);
	public static final Item Psycho = new ItemPsycho(470).setUnlocalizedName("Psycho").setCreativeTab(TabFalloutFood);
	public static final Item MedEx = new ItemMedEx(471).setUnlocalizedName("MedEx").setCreativeTab(TabFalloutFood);
	public static final Item Slasher = new ItemSlasher(472, 1, false).setUnlocalizedName("Slasher").setCreativeTab(TabFalloutFood);
	public static final Item Hydra = new ItemHydra(473).setUnlocalizedName("Hydra").setCreativeTab(TabFalloutFood);
	public static final Item NukaCola = new BaseFood(474, 7, 0.3F, false).setUnlocalizedName("NukaCola").setCreativeTab(TabFalloutFood);
	public static final Item HealingPowder = new ItemHP(475).setUnlocalizedName("HealingPowder").setCreativeTab(TabFalloutFood);
	public static final Item bBarrelCactus = new BaseFood(476, 8, 0.3F, false).setUnlocalizedName("bBarrelCactus").setCreativeTab(TabFalloutFood);
	public static final Item bBrocFlower = new BaseFood(477, 8, 0.3F, false).setUnlocalizedName("bBrocFlower").setCreativeTab(TabFalloutFood);
	public static final Item bXanderRoot = new ItembXanderRoot(478, 8, 0.3F, false).setUnlocalizedName("bXanderRoot").setCreativeTab(TabFalloutFood);
	public static final Item AntEgg = new BaseFood(479, 5, 0.3F, false).setUnlocalizedName("AntEgg").setCreativeTab(TabFalloutFood);
	public static final Item AntMeat = new BaseFood(480, 6, 0.3F, true).setUnlocalizedName("AntMeat").setCreativeTab(TabFalloutFood);
	public static final Item BighornerSteak = new BaseFood(481, 10, 0.3F, true).setUnlocalizedName("BighornerSteak").setCreativeTab(TabFalloutFood);
	public static final Item BloodSausage = new BaseFood(482, 16, 0.3F, true).setUnlocalizedName("BloodSausage").setCreativeTab(TabFalloutFood);
	public static final Item BlackBloodSausage = new BaseFood(483, 20, 0.3F, true).setUnlocalizedName("BlackBloodSausage").setCreativeTab(TabFalloutFood);
	public static final Item BighornerMeat = new BaseFood(484, 4, 0.3F, true).setUnlocalizedName("BighornerMeat").setCreativeTab(TabFalloutFood);
	public static final Item BrahminMeat = new BaseFood(485, 3, 0.3F, true).setUnlocalizedName("BrahminMeat").setCreativeTab(TabFalloutFood);
	public static final Item BrahminSteak = new BaseFood(486, 8, 0.3F, true).setUnlocalizedName("BrahminSteak").setCreativeTab(TabFalloutFood);
	public static final Item BrahminWellington = new BaseFood(487, 14, 0.3F, true).setUnlocalizedName("BrahminWellington").setCreativeTab(TabFalloutFood);
	public static final Item FireAntFricasse = new BaseFood(488, 12, 0.3F, false).setPotionEffect(Potion.fireResistance.id, 60, 0, 1F).setUnlocalizedName("FireAntFricasse").setCreativeTab(TabFalloutFood);
	public static final Item CaravanLunch = new BaseFood(489, 20, 0.3F, false).setUnlocalizedName("CaravanLunch").setCreativeTab(TabFalloutFood);
	public static final Item DandyApples = new BaseFood(490, 5, 0.3F, false).setUnlocalizedName("DandyApples").setCreativeTab(TabFalloutFood);
	public static final Item NightstalkerTail = new BaseFood(491, 6, 0.3F, false).setUnlocalizedName("NightstalkerTail").setCreativeTab(TabFalloutFood);
	public static final Item TrailMix = new BaseFood(492, 12, 0.3F, false).setUnlocalizedName("TrailMix").setCreativeTab(TabFalloutFood);
	public static final Item SugarBombs = new BaseFood(493, 8, 0.3F, false).setUnlocalizedName("SugarBombs").setCreativeTab(TabFalloutFood);
	public static final Item PotatoChips = new BaseFood(494, 5, 0.3F, false).setUnlocalizedName("PotatoChips").setCreativeTab(TabFalloutFood);
	public static final Item SunsetSass = new BaseDrink(495, 5, 0.3F, false).setUnlocalizedName("SunsetSass").setCreativeTab(TabFalloutFood);
	public static final Item bBananaYucca = new BaseFood(496, 6, 0.3F, false).setUnlocalizedName("bBananaYucca").setCreativeTab(TabFalloutFood);
	public static final Item bCaveFungus = new ItembCaveFungus(497, 6, 0.3F, false).setUnlocalizedName("bCaveFungus").setCreativeTab(TabFalloutFood);
	public static final Item bBuffaloGourd = new BaseFood(498, 4, 0.3F, false).setUnlocalizedName("bBuffaloGourd").setCreativeTab(TabFalloutFood);
	public static final Item bJalapeno = new BaseFood(499, 4, 0.3F, false).setUnlocalizedName("bJalapeno").setCreativeTab(TabFalloutFood);
	public static final Item Jet = new ItemJet(500).setUnlocalizedName("Jet").setCreativeTab(TabFalloutFood);
	public static final Item Rocket = new ItemRocket(501, 1, false).setUnlocalizedName("Rocket").setCreativeTab(TabFalloutFood);
	public static final Item NukaQuartz = new ItemNukaQuartz(502, 1, false).setUnlocalizedName("NukaQuartz").setCreativeTab(TabFalloutFood);
	public static final Item NukaCold = new BaseDrink(503, 1, 0.3F, false).setUnlocalizedName("NukaCold").setCreativeTab(TabFalloutFood);
	public static final Item NukaVictory = new ItemNukaVictory(504, 1, false).setPotionEffect(Potion.digSpeed.id, 60, 0, 1F).setPotionEffect(Potion.moveSpeed.id, 60, 0, 1F).setUnlocalizedName("NukaVictory").setCreativeTab(TabFalloutFood);
	public static final Item WeaponBinding = new ItemWeaponBinding(505, 1, false).setUnlocalizedName("WeaponBinding").setCreativeTab(TabFalloutFood);
	public static final Item Vodka = new BaseDrink(506, 1, 0.3F, false).setPotionEffect(Potion.damageBoost.id, 60, 0, 1F).setPotionEffect(Potion.confusion.id, 60, 0, 1F).setPotionEffect(Potion.poison.id, 60, 0 , 1F).setUnlocalizedName("Vodka").setCreativeTab(TabFalloutFood);
	public static final Item StealthBoy = new ItemStealthBoy(507).setUnlocalizedName("StealthBoy").setCreativeTab(TabFalloutFood);
	public static final Item Turbo = new ItemTurbo(508).setUnlocalizedName("Turbo").setCreativeTab(TabFalloutFood);

	//============================================Armor==========================================================

	public static final Item T45Helm = (new ArmorBaseT45(542, T45POWER, 1, 0)).setUnlocalizedName("T45Helm").setCreativeTab(TabFalloutArmor);
	public static final Item T45Chest = (new ArmorBaseT45(543, T45POWER, 1, 1)).setUnlocalizedName("T45Chest").setCreativeTab(TabFalloutArmor);
	public static final Item T45Legs = (new ArmorBaseT45(544, T45POWER, 1, 2)).setUnlocalizedName("T45Legs").setCreativeTab(TabFalloutArmor);
	public static final Item T45Boots = (new ArmorBaseT45(545, T45POWER, 1, 3)).setUnlocalizedName("T45Boots").setCreativeTab(TabFalloutArmor);

	public static final Item T51Helm = (new ArmorBaseT51(546, T51POWER, 1, 0)).setUnlocalizedName("T51Helm").setCreativeTab(TabFalloutArmor);
	public static final Item T51Chest = (new ArmorBaseT51(547, T51POWER, 1, 1)).setUnlocalizedName("T51Chest").setCreativeTab(TabFalloutArmor);
	public static final Item T51Legs = (new ArmorBaseT51(548, T51POWER, 1, 2)).setUnlocalizedName("T51Legs").setCreativeTab(TabFalloutArmor);
	public static final Item T51Boots = (new ArmorBaseT51(549, T51POWER, 1, 3)).setUnlocalizedName("T51Boots").setCreativeTab(TabFalloutArmor);

	public static final Item G1Helm = (new ArmorBaseGecko1(550, EnumArmorMaterial.CHAIN, 1, 0)).setUnlocalizedName("G1Helm").setCreativeTab(TabFalloutArmor);
	public static final Item G1Chest = (new ArmorBaseGecko1(551, EnumArmorMaterial.CHAIN, 1, 1)).setUnlocalizedName("G1Chest").setCreativeTab(TabFalloutArmor);
	public static final Item G1Legs = (new ArmorBaseGecko1(552, EnumArmorMaterial.CHAIN, 1, 2)).setUnlocalizedName("G1Legs").setCreativeTab(TabFalloutArmor);
	public static final Item G1Boots = (new ArmorBaseGecko1(553, EnumArmorMaterial.CHAIN, 1, 3)).setUnlocalizedName("G1Boots").setCreativeTab(TabFalloutArmor);

	public static final Item HellHelm = (new ArmorBaseHellfire(554, HELLFIRE, 1, 0)).setUnlocalizedName("HellHelm").setCreativeTab(TabFalloutArmor);
	public static final Item HellChest = (new ArmorBaseHellfire(555, HELLFIRE, 1, 1)).setUnlocalizedName("HellChest").setCreativeTab(TabFalloutArmor);
	public static final Item HellLegs = (new ArmorBaseHellfire(556, HELLFIRE, 1, 2)).setUnlocalizedName("HellLegs").setCreativeTab(TabFalloutArmor);
	public static final Item HellBoots = (new ArmorBaseHellfire(557, HELLFIRE, 1, 3)).setUnlocalizedName("HellBoots").setCreativeTab(TabFalloutArmor);

	//Skins creds: BillSkins
	public static final Item WinterHelm = (new ArmorBaseWinter(558, WINTER, 1, 0)).setUnlocalizedName("WinterHelm").setCreativeTab(TabFalloutArmor);
	public static final Item WinterChest = (new ArmorBaseWinter(559, WINTER, 1, 1)).setUnlocalizedName("WinterChest").setCreativeTab(TabFalloutArmor);
	public static final Item WinterLegs = (new ArmorBaseWinter(560, WINTER, 1, 2)).setUnlocalizedName("WinterLegs").setCreativeTab(TabFalloutArmor);
	public static final Item WinterBoots = (new ArmorBaseWinter(561, WINTER, 1, 3)).setUnlocalizedName("WinterBoots").setCreativeTab(TabFalloutArmor);

	public static final Item EnclaveHelm = (new ArmorBaseEnclave(562, ENCLAVE, 1, 0)).setUnlocalizedName("EnclaveHelm").setCreativeTab(TabFalloutArmor);
	public static final Item EnclaveChest = (new ArmorBaseEnclave(563, ENCLAVE, 1, 1)).setUnlocalizedName("EnclaveChest").setCreativeTab(TabFalloutArmor);
	public static final Item EnclaveLegs = (new ArmorBaseEnclave(564, ENCLAVE, 1, 2)).setUnlocalizedName("EnclaveLegs").setCreativeTab(TabFalloutArmor);
	public static final Item EnclaveBoots = (new ArmorBaseEnclave(565, ENCLAVE, 1, 3)).setUnlocalizedName("EnclaveBoots").setCreativeTab(TabFalloutArmor);

	//============================================Blocks=========================================================

	public static final BlockOre TungstenOre = (new BlockTungstenOre(170, 0, Material.rock));
	public static final BlockOre TechnetiumOre = (new BlockTechnetiumOre(171, 1, Material.rock));
	public static final BlockOre SaturniteOre = (new BlockSaturniteOre(172, 2, Material.rock));
	public static final BlockFlower BrocFlower = (BlockFlower) new BlockBrocFlower(174, 3).setUnlocalizedName("BrocFlower");
	public static final BlockOre BPGlass = (new BlockBPGlass(173, 4, Material.rock));
	public static final BlockFlower XanderRoot = (BlockFlower) new BlockXanderRoot(175 ,5).setUnlocalizedName("XanderRoot");
	public static final BlockOre UraniumOre = (new BlockUraniumOre(176,7, Material.rock));
	public static final BlockOre SiliconDeposit = (new BlockSiliconDeposit(177, 6, Material.rock));
	public static final BlockOre CarbonDeposit = (new BlockCarbonDeposit(178, 9, Material.rock));
	public static final BlockOre AsbestosDeposit = (new BlockAsbestosDeposit(179, 10, Material.rock));
	public static final BlockFlower BarrelCactus = (BlockFlower) new BlockBarrelCactus(180, 11).setUnlocalizedName("BarrelCactus");
	public static final BlockFlower BananaYucca = (BlockFlower) new BlockBananaYucca(181, 15).setUnlocalizedName("BananaYucca");
	public static final BlockFlower CaveFungus = (BlockFlower) new BlockCaveFungus(182, 29).setUnlocalizedName("CaveFungus");
	public static final BlockFlower BuffaloGourd = (BlockFlower) new BlockBuffaloGourd(3000, 13).setUnlocalizedName("BuffaloGourd");
	public static final BlockFlower Jalapeno = (BlockFlower) new BlockJalapeno(3001, 14).setUnlocalizedName("Jalapeno");

	//============================================Biomes==========================================================

	public static final BiomeGenBase Wasteland = (new BiomeWasteland(100)).setColor(16421912).setBiomeName("Wasteland").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);

	//Version 1.7
	public static final Item grip = new BaseItem(566).setUnlocalizedName("Grip").setCreativeTab(TabFalloutGuns);
	public static final Item barrel = new BaseItem(567).setUnlocalizedName("Barrel").setCreativeTab(TabFalloutGuns);
	public static final Item stock = new BaseItem(568).setUnlocalizedName("Stock").setCreativeTab(TabFalloutGuns);
	public static final Item magnifier = new BaseItem(569).setUnlocalizedName("Magnifier").setCreativeTab(TabFalloutGuns);
	public static final Item hammer = new BaseItem(570).setUnlocalizedName("Hammer").setCreativeTab(TabFalloutGuns);
	public static final Item gasTank = new BaseItem(571).setUnlocalizedName("GasTank").setCreativeTab(TabFalloutMisc);

	//Version 1.7.1
	//KEY: ID, damage, usage size/clip, reload time, fire time, fire sound, reload sound
	public static final Item PlasmaRifle = new GunMFCell(572, 7, 24, 2, 2, "blfngl.PlasmaFire", "Blfngl.PlasmaReload").setUnlocalizedName("PlasmaRifle").setCreativeTab(TabFalloutGuns);
	public static final Item magRail = new BaseItem(573).setUnlocalizedName("MagRail").setCreativeTab(TabFalloutGuns);
	public static final Item gun10MM = new Gun10MM(574, 4, 12, 1, 1, "blfngl.10MMFire", "blfngl.10MMReload").setUnlocalizedName("10MM").setCreativeTab(TabFalloutGuns);
	public static final Item a10MM = new BaseItem(575).setUnlocalizedName("a10MM").setCreativeTab(TabFalloutGuns);
	public static final Item shiskebabFlaming = new WeapFlamingShish(576).setUnlocalizedName("Shishkebab").setCreativeTab(TabFalloutWeap);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.registerSoundHandler();
	}

	@Init
	public void init(FMLInitializationEvent event)
	{

		LanguageRegistry.addName(Incinerator, "Incinerator");
		GameRegistry.addRecipe(new ItemStack(Incinerator), new Object [] {"XXX", " *&", " &&", 'X', Block.netherrack, '*', Item.ingotIron, '&', ingotTungsten});
		LanguageRegistry.addName(LaserRCW, "Laser RCW");
		GameRegistry.addRecipe(new ItemStack(LaserRCW), new Object [] {"X*$", " &%", "%%%", 'X', barrel, '*', magnifier, '$', stock, '&', grip, '%', ingotTungsten});
		LanguageRegistry.addName(Compliance, "Compliance Regulator");
		GameRegistry.addRecipe(new ItemStack(Compliance), new Object [] {"X**", "&%*", " # ", 'X', barrel, '*', ingotTungsten, '#', grip, '&', MFCell, '%', Block.slowSand});
		LanguageRegistry.addName(LaserRifle, "AER7 Laser Rifle");
		GameRegistry.addRecipe(new ItemStack(LaserRifle), new Object [] {"*X#", "X%X", "  ^", 'X', ingotTungsten, '*', magRail, '#', stock, '^', grip, '%', Item.diamond});
		LanguageRegistry.addName(g357Mag, ".357 Magnum");
		GameRegistry.addRecipe(new ItemStack(g357Mag), new Object [] {"*X^", " *#", "  &", '#', Item.ingotIron, '*', barrel, 'X', ingotTungsten, '&', grip, '^', hammer});
		LanguageRegistry.addName(g44Mag, ".44 Magnum");
		GameRegistry.addRecipe(new ItemStack(g44Mag), new Object [] {"*X^", " *#", "  &", '#', Item.ingotIron, '*', barrel, 'X', ingotTechnetium, '&', grip, '^', hammer});
		LanguageRegistry.addName(Silenced22, "Silenced .22 Pistol");
		GameRegistry.addRecipe(new ItemStack(Silenced22), new Object [] {"*XX", " %X", "  &", '*', barrel, 'X', barSilicon, '%', chunkTungsten, '&', grip});
		LanguageRegistry.addName(Sniper308, "Sniper's Rifle");
		GameRegistry.addRecipe(new ItemStack(Sniper308), new Object [] {"XX*", " *&", " %&", 'X', barrel, '*', ingotTungsten, '&', ingotTechnetium, '%', grip});

		LanguageRegistry.addName(a22LR, ".22 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a22LR, 12), new Object [] {chunkSilicon, scrapMetal});
		LanguageRegistry.addName(a357, ".357 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a357, 3), new Object [] {scrapMetal, Item.ingotIron});
		LanguageRegistry.addName(a44, ".44 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a44, 3), new Object [] {scrapMetal, Item.ingotGold});
		LanguageRegistry.addName(a308, ".308 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a308, 2), new Object [] {ingotTungsten, scrapMetal});
		LanguageRegistry.addName(homemadeFuel, "Flamer Fuel");
		GameRegistry.addShapelessRecipe(new ItemStack(homemadeFuel), new Object [] {abraxo, Item.sugar, Item.wheat});

		LanguageRegistry.addName(Cleaver, "Cleaver");
		GameRegistry.addRecipe(new ItemStack(Cleaver), new Object [] {"XX", "XX", " *", 'X', Item.ingotIron, '*', Item.stick});
		LanguageRegistry.addName(ComKnife, "Combat Knife");
		GameRegistry.addRecipe(new ItemStack(ComKnife), new Object [] {"X", "*", 'X', ingotTungsten, '*', Item.stick});
		LanguageRegistry.addName(BotE, "Blade of the East");
		LanguageRegistry.addName(CosKnife, "Cosmic Knife");
		GameRegistry.addRecipe(new ItemStack(CosKnife), new Object [] {"X", "X", "&", 'X', ingotSaturnite, '&', Item.ingotIron});
		LanguageRegistry.addName(CosClean, "Cosmic Knife (Clean)");
		GameRegistry.addShapelessRecipe(new ItemStack(CosClean), new Object[] {CosKnife, abraxo});
		LanguageRegistry.addName(CosFire, "Cosmic Knife (Super Heated)");
		GameRegistry.addShapelessRecipe(new ItemStack(CosFire), new Object [] {CosClean, Item.bucketLava});
		LanguageRegistry.addName(PintSizedKnife, "Pint Sized Slasher's Knife");
		LanguageRegistry.addName(BumperSword, "Bumper Sword");
		GameRegistry.addRecipe(new ItemStack(BumperSword), new Object [] {" X ", "X*X", "X&X", 'X', tungstenPlate, '*', ItemSword.swordDiamond, '&', chunkTungsten});
		LanguageRegistry.addName(FireAxe, "Fire Axe");
		GameRegistry.addRecipe(new ItemStack(FireAxe), new Object [] {"*XX", "*^ ", " ^ ", 'X', ingotTungsten, '*', chunkTechnetium, '^', chunkTungsten});
		LanguageRegistry.addName(Knife, "Knife");
		GameRegistry.addRecipe(new ItemStack(Knife), new Object [] {"X*", 'X', ingotTungsten, '*', chunkTungsten});
		LanguageRegistry.addName(Machete, "Machete");
		GameRegistry.addRecipe(new ItemStack(Machete), new Object [] {"X", "X", "*", 'X', ingotTungsten, '*', chunkTungsten});
		LanguageRegistry.addName(Shishkebab, "Shishkebab");
		//GameRegistry.addRecipe(new ItemStack(Shishkebab), new Object [] {" X ", "X*X", "X&X", 'X', tungstenPlate, '*', ItemSword.swordDiamond, '&', chunkTungsten});
		LanguageRegistry.addName(StraightRazor, "Straight Razor");
		GameRegistry.addRecipe(new ItemStack(StraightRazor), new Object [] {"X  ", " X ", " * ", 'X', Item.ingotIron, '*', chunkSilicon});
		LanguageRegistry.addName(Switchblade, "Switchblade");
		GameRegistry.addRecipe(new ItemStack(Switchblade), new Object [] {"X*X", 'X', chunkSilicon, '*', Item.ingotIron});

		LanguageRegistry.addName(BallisticFist, "Ballistic Fist");
		GameRegistry.addRecipe(new ItemStack(BallisticFist), new Object [] {"*X*", "X%X", "###", 'X', Block.pistonBase, '*', Block.tnt, '#', tungstenPlate, '%', Item.redstoneRepeater});
		LanguageRegistry.addName(BladedGauntlet, "Bladed Gauntlet");
		GameRegistry.addRecipe(new ItemStack(BladedGauntlet), new Object [] {" * ", "*X*", '*', Knife, 'X', BoxingGloves});
		LanguageRegistry.addName(BoxingGloves, "Boxing Gloves");
		GameRegistry.addRecipe(new ItemStack(BoxingGloves), new Object [] {" * ", "*X*", " * ", 'X', BrassKnuckles, '*', Item.leather});
		LanguageRegistry.addName(BrassKnuckles, "Brass Knuckles");
		GameRegistry.addRecipe(new ItemStack(BrassKnuckles), new Object [] {"XXX", "* *", 'X', Item.ingotGold, '*', ingotTungsten});
		LanguageRegistry.addName(DisplacerGlove, "Displacer Glove");
		LanguageRegistry.addName(GoldenGloves, "Golden Gloves");
		GameRegistry.addRecipe(new ItemStack(GoldenGloves), new Object [] {"XXX", "X*X", "XXX", 'X', Item.goldNugget, '*', BoxingGloves});
		LanguageRegistry.addName(SatFist, "Saturnite Power Fist");
		GameRegistry.addRecipe(new ItemStack(SatFist), new Object [] {"XXX", "%*%", 'X', saturniteAlloy, '%', Block.pistonBase, '*', PowerFist});
		LanguageRegistry.addName(SatHeatFist, "Saturnite Fist (Super Heated)");
		GameRegistry.addRecipe(new ItemStack(SatHeatFist), new Object [] {"^^^", "X*X", "& &", 'X', Block.furnaceIdle, '&', ingotSaturnite, '*', SatFist, '^', saturniteAlloy});
		LanguageRegistry.addName(PowerFist, "Power Fist");
		GameRegistry.addRecipe(new ItemStack(PowerFist), new Object [] {"X*X", "&*&", "&*&", 'X', Block.pistonBase, '&', ingotTungsten, '*', Item.redstone});
		LanguageRegistry.addName(SciGlove, "Scientist's Glove");
		GameRegistry.addRecipe(new ItemStack(SciGlove), new Object [] {"X*X", "X X", "X X", 'X', polyethylene, '*', ingotTungsten});
		LanguageRegistry.addName(ZapGlove, "Zap Glove");
		GameRegistry.addRecipe(new ItemStack(ZapGlove), new Object [] {"XXX", "*&*", 'X', Block.blockRedstone, '*', tungstenPlate, '&', PowerFist});

		LanguageRegistry.addName(bottleCapMine, "Bottle Cap Mine");
		GameRegistry.addRecipe(new ItemStack(bottleCapMine), new Object [] {" X ", "***", "&^&", 'X', lunchbox, '*', bottleCap, '&', cherrybomb, '^', sensorModule});
		LanguageRegistry.addName(fragGrenade, "Frag Grenade");
		GameRegistry.addRecipe(new ItemStack(fragGrenade), new Object [] {" * ", "X&X", "XXX", '*', chunkSilicon, 'X', ingotTungsten, '&', Block.tnt});

		LanguageRegistry.addName(chunkTungsten, "Tungsten Rod");
		LanguageRegistry.addName(ingotTungsten, "Tungsten Ingot");
		GameRegistry.addRecipe(new ItemStack(ingotTungsten), new Object [] {"XXX", "XXX", 'X', chunkTungsten});
		LanguageRegistry.addName(chunkTechnetium, "Technetium Chunk");
		LanguageRegistry.addName(ingotTechnetium, "Technetium Ingot");
		GameRegistry.addRecipe(new ItemStack(ingotTechnetium), new Object [] {"###", "###", '#', chunkTechnetium});
		LanguageRegistry.addName(chunkSilicon, "Silicon Chunk");
		LanguageRegistry.addName(barSilicon, "Silicon Bar");
		GameRegistry.addRecipe(new ItemStack(barSilicon), new Object [] {"###", "###", '#', chunkSilicon});
		LanguageRegistry.addName(tungstenFilter, "Tungsten Filter");
		GameRegistry.addRecipe(new ItemStack(tungstenFilter), new Object [] {"###", "###", "###", '#', chunkTungsten});
		LanguageRegistry.addName(chunkAsbestos, "Asbestos Chunk");
		LanguageRegistry.addName(barAsbestos, "Asbestos Bar");
		GameRegistry.addSmelting(chunkAsbestos.itemID, new ItemStack(barAsbestos), 1.5F);
		GameRegistry.addRecipe(new ItemStack(barAsbestos), new Object [] {"XXX", "XXX", 'X', chunkAsbestos});
		LanguageRegistry.addName(ingotUranium, "Uranium Ingot");
		LanguageRegistry.addName(tungstenPlate, "Tungsten Plate");
		GameRegistry.addRecipe(new ItemStack(tungstenPlate), new Object [] {"XX", "XX", 'X', ingotTungsten});
		LanguageRegistry.addName(technetiumPlate, "Technetium Plate");
		GameRegistry.addRecipe(new ItemStack(technetiumPlate, 1), new Object [] {"XX", "XX", 'X', ingotTechnetium});
		LanguageRegistry.addName(RAP, "Reinforced Alloy Plate");
		GameRegistry.addRecipe(new ItemStack(RAP, 2), new Object [] {"X*", "*X", 'X', tungstenPlate, '*', technetiumPlate});
		LanguageRegistry.addName(MFCell, "MicroFusion Cell");
		GameRegistry.addRecipe(new ItemStack(MFCell, 6), new Object [] {" * ", "*&*", " * ", '&', ingotUranium, '*', tungstenPlate});
		LanguageRegistry.addName(MFPack, "MicroFusion Pack");
		GameRegistry.addRecipe(new ItemStack(MFPack),new Object [] {" X ", "&&&", " X ", 'X', RAP, '&', MFCell});
		LanguageRegistry.addName(carbon, "Carbon");
		LanguageRegistry.addName(teflon, "Teflon");
		GameRegistry.addRecipe(new ItemStack(teflon, 2), new Object [] {"**", "##", "**", '*', Item.silk, '#', carbon});
		LanguageRegistry.addName(polyethylene, "Polyethylene");
		GameRegistry.addRecipe(new ItemStack(polyethylene), new Object [] {"X*X", "*X*", 'X', carbon, '*', teflon});
		LanguageRegistry.addName(bottleCap, "Bottle Cap");
		LanguageRegistry.addName(fan, "Fan");
		GameRegistry.addRecipe(new ItemStack(fan), new Object [] {" * ", "*X*", " * ", '*', chunkTungsten, 'X', Item.ingotIron});
		LanguageRegistry.addName(gear, "Gear");
		GameRegistry.addRecipe(new ItemStack(gear, 2), new Object [] {"***", "*#*", "***", '*', chunkTungsten, '#', ingotTungsten});
		LanguageRegistry.addName(gyro, "Gyroscope");
		GameRegistry.addRecipe(new ItemStack(gyro), new Object [] {" X ", "X*X", " & ", 'X', Item.ingotGold, '*', barSilicon, '&', Item.stick});
		LanguageRegistry.addName(MASM, "Motion-Assist Servo Motor");
		GameRegistry.addRecipe(new ItemStack(MASM), new Object [] {" XX", "*&X", " XX", 'X', barSilicon, '*', Item.stick, '&', gear});
		LanguageRegistry.addName(TXMF, "TX-28 MicroFusion Pack");
		GameRegistry.addRecipe(new ItemStack(TXMF, 1), new Object [] {" X ", "&&&", " X ", 'X', RAP, '&', MFPack});
		LanguageRegistry.addName(card, "Caravan Card");
		ModLoader.addRecipe(new ItemStack(card, 1), new Object [] {"XXX", "X*X", "XXX", 'X', Item.paper, '*', Item.coal});
		LanguageRegistry.addName(deck, "Caravan Deck");
		GameRegistry.addRecipe(new ItemStack(deck, 1), new Object [] {"XXX", "XXX", "XXX", 'X', card});
		LanguageRegistry.addName(cardboard, "Cardboard");
		GameRegistry.addRecipe(new ItemStack(cardboard, 4), new Object [] {"XXX", "X X", "XXX", 'X', Item.paper});
		LanguageRegistry.addName(tinCan, "Tin Can");
		GameRegistry.addRecipe(new ItemStack(cardboard, 4), new Object [] {"X X", " X ", 'X', ingotTungsten});
		LanguageRegistry.addName(chunkSaturnite, "Saturnite Rod");
		LanguageRegistry.addName(ingotSaturnite, "Saturnite Ingot");
		GameRegistry.addRecipe(new ItemStack(ingotSaturnite), new Object [] {"XXX", "XXX", 'X', chunkSaturnite});
		LanguageRegistry.addName(saturniteAlloy, "Saturnite Alloy");
		GameRegistry.addRecipe(new ItemStack(saturniteAlloy), new Object [] {"XX", "XX", 'X', ingotSaturnite});
		LanguageRegistry.addName(syringeEmpty, "Empty Syringe");
		GameRegistry.addRecipe(new ItemStack(syringeEmpty), new Object [] {"  &", " * ", "X  ", '*', chunkSilicon, 'X', Item.ingotIron, '&', chunkTungsten});
		LanguageRegistry.addName(syringeBloody, "Blood Syringe");
		LanguageRegistry.addName(powerTorso, "Base Power Torso");
		GameRegistry.addRecipe(new ItemStack(powerTorso, 1), new Object [] {"X X", "*&*", " $ ", 'X', RAP, '&', fan, '*', RAP, '$', TXMF});
		LanguageRegistry.addName(powerShoulders, "Base Power Shoulders");
		GameRegistry.addRecipe(new ItemStack(powerShoulders, 1), new Object [] {"X X", "& &", 'X', RAP, '&', tungstenPlate});
		LanguageRegistry.addName(powerChest, "Base Power Chest");
		GameRegistry.addRecipe(new ItemStack(powerChest, 1),new Object [] {"X", "*", 'X', powerShoulders, '*', powerTorso});
		LanguageRegistry.addName(upgradeT45, "Type 45-d Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(upgradeT45, 1), new Object [] {" X ", "&*&", " X ", 'X', tungstenPlate, '&', technetiumPlate, '*', RAP});
		LanguageRegistry.addName(upgradeEnclave, "Enclave Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(upgradeEnclave, 1), new Object [] {" X ", "&*&", " X ", 'X', tungstenPlate, '&', technetiumPlate, '*', upgradeT45});
		LanguageRegistry.addName(upgradeT51, "Type 51-b Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(upgradeT51, 1), new Object [] {" X ", "&*&", " X ", 'X', tungstenPlate, '&', technetiumPlate, '*', upgradeEnclave});
		LanguageRegistry.addName(upgradeHellfire, "Enclave Hellfire Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(upgradeHellfire, 1), new Object [] {" X ", "&*&", " X ", 'X', tungstenPlate, '&', technetiumPlate, '*', upgradeT51});
		LanguageRegistry.addName(upgradeWinterized, "Winterized Type 51-b Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(upgradeWinterized, 1), new Object [] {" X ", "&*&", " X ", 'X', tungstenPlate, '&', technetiumPlate, '*', upgradeHellfire});
		LanguageRegistry.addName(nukaBottle, "Nuka Cola Bottle");
		GameRegistry.addShapelessRecipe(new ItemStack(nukaBottle), new Object [] {bottleCap, Item.glassBottle});
		LanguageRegistry.addName(abraxo, "Abraxo Cleaner");
		GameRegistry.addRecipe(new ItemStack(abraxo), new Object [] {" X ", "***", " X ", 'X', cardboard, '*', Item.sugar});
		LanguageRegistry.addName(scrapMetal, "Scrap Metal");
		GameRegistry.addShapelessRecipe(new ItemStack(scrapMetal, 1), new Object[] {ingotTungsten, Item.ingotIron});
		LanguageRegistry.addName(lunchbox, "Lunchbox");
		GameRegistry.addRecipe(new ItemStack(lunchbox), new Object [] {" X ", "X X", "XXX", 'X', Item.ingotIron});
		LanguageRegistry.addName(sensorModule, "Sensor Module");
		GameRegistry.addRecipe(new ItemStack(sensorModule), new Object [] {" XX", "*&X", " XX", 'X', ingotTungsten, '*', Item.redstoneRepeater, '&', Item.redstone});
		LanguageRegistry.addName(cherrybomb, "Cherry Bomb");
		GameRegistry.addRecipe(new ItemStack(cherrybomb, 3), new Object [] {"X", 'X', Block.tnt});
		LanguageRegistry.addName(nightstalkerBlood, "Nightstalker Blood");
		LanguageRegistry.addName(jetInhaler, "Jet Inhaler");
		GameRegistry.addRecipe(new ItemStack(jetInhaler), new Object [] {"X  ", "X  ", "X& ", 'X', barSilicon, '&', Block.dispenser});
		LanguageRegistry.addName(wonderglue, "Wonderglue");
		GameRegistry.addRecipe(new ItemStack(wonderglue), new Object [] {"X*X", "X*X", " & ", 'X', barSilicon, '*', Item.slimeBall, '&', syringeEmpty});
		LanguageRegistry.addName(turpentine, "Turpentine");
		GameRegistry.addShapelessRecipe(new ItemStack(turpentine), new Object [] {Item.coal, Item.coal, Item.coal, Item.coal, Block.wood});
		LanguageRegistry.addName(geckoHide, "Gecko Hide");
		GameRegistry.addShapelessRecipe(new ItemStack(geckoHide), new Object [] {Block.cactus, Item.leather});
		LanguageRegistry.addName(leatherBelt, "Leather Belt");
		GameRegistry.addRecipe(new ItemStack(leatherBelt), new Object [] {"X*X", 'X', Item.leather, '*', Item.ingotIron});
		LanguageRegistry.addName(EPack, "Electron Charge Pack");
		GameRegistry.addRecipe(new ItemStack(EPack), new Object [] {"XX", "**", "XX", 'X', tungstenPlate, '*', ingotUranium});
		LanguageRegistry.addName(ECell, "Energy Cell");
		GameRegistry.addRecipe(new ItemStack(ECell), new Object [] {"X*", "*X", '*', ingotUranium, 'X', ingotTechnetium});

		//TODO Shapeless recipes
		LanguageRegistry.addName(Psycho, "Psycho");
		GameRegistry.addShapelessRecipe(new ItemStack(Psycho, 2), new Object [] {Item.slimeBall, Item.slimeBall, Item.slimeBall, Item.slimeBall, Item.lightStoneDust, syringeEmpty, Item.redstone, Item.lightStoneDust});
		LanguageRegistry.addName(MedEx, "Med-X");
		GameRegistry.addShapelessRecipe(new ItemStack(MedEx, 2), new Object [] {Stimpak, syringeEmpty, bBananaYucca, bBananaYucca});
		LanguageRegistry.addName(Slasher, "Slasher");
		GameRegistry.addShapelessRecipe(new ItemStack(Slasher), new Object [] {Psycho, MedEx});
		LanguageRegistry.addName(Stimpak, "Stimpak");
		GameRegistry.addShapelessRecipe(new ItemStack(Stimpak), new Object [] {bBrocFlower, bXanderRoot, syringeEmpty});
		LanguageRegistry.addName(SuperStimpak, "Super Stimpak");
		GameRegistry.addShapelessRecipe(new ItemStack(SuperStimpak), new Object [] {Stimpak, leatherBelt, NukaCola});
		LanguageRegistry.addName(BCMAC, "Blam Co. Mac and Cheese");
		GameRegistry.addRecipe(new ItemStack(BCMAC, 3), new Object [] {"#X#", "***", "#X#", 'X', Item.bucketMilk, '*', Item.wheat, '#', cardboard});
		LanguageRegistry.addName(Cram, "Cram");
		GameRegistry.addRecipe(new ItemStack(Cram, 12), new Object [] {" # ", " * ", " X ", 'X', tinCan, '#', Item.beefCooked, '*', Item.porkCooked});
		LanguageRegistry.addName(Instamash, "Instamash");
		GameRegistry.addRecipe(new ItemStack(Instamash, 5), new Object [] {"X*X", "***", "X*X", 'X', cardboard, '*', Item.potato});
		LanguageRegistry.addName(PorkBeans, "Pork 'n' Beans");
		GameRegistry.addRecipe(new ItemStack(PorkBeans, 9), new Object [] {" # ", " * ", " X ", 'X', tinCan, '#', Item.porkCooked, '*', new ItemStack(Item.dyePowder, 1, 3)});
		LanguageRegistry.addName(Salisbury, "Salisbury Steak");
		GameRegistry.addRecipe(new ItemStack(Salisbury, 12), new Object [] {"X*X", "#*#", "X*X", 'X', cardboard, '#', Item.potato, '*', Item.beefCooked});
		LanguageRegistry.addName(YumYum, "Yum Yum Deviled Eggs");
		GameRegistry.addRecipe(new ItemStack(YumYum, 3), new Object [] {"X*X", "*#*", "X*X", 'X', cardboard, '*', Item.egg, '#', Item.bucketMilk});
		LanguageRegistry.addName(Hydra, "Hydra");
		GameRegistry.addShapelessRecipe(new ItemStack(Hydra), new Object [] {nightstalkerBlood, nightstalkerBlood, bCaveFungus, Item.spiderEye, Item.glassBottle});
		LanguageRegistry.addName(NukaCola, "Nuka Cola");
		//GameRegistry.addShapelessRecipe(new ItemStack(NukaCola), new Object [] {"X*%", " & ", 'X', Item.sugar, '*', Item.bucketWater, '&', nukaBottle, '%', ingotUranium});
		LanguageRegistry.addName(HealingPowder, "Healing Powder");
		GameRegistry.addShapelessRecipe(new ItemStack(HealingPowder), new Object[] {bXanderRoot, bBrocFlower});
		LanguageRegistry.addName(bBarrelCactus, "Barrel Cactus Fruit");
		LanguageRegistry.addName(bBrocFlower, "Broc Flower");
		LanguageRegistry.addName(bXanderRoot, "Xander Root");
		LanguageRegistry.addName(AntMeat, "Ant Meat");
		LanguageRegistry.addName(AntEgg, "Ant Egg");
		LanguageRegistry.addName(BloodSausage, "Blood Sausage");
		LanguageRegistry.addName(BlackBloodSausage, "Black Blood Sausage");
		LanguageRegistry.addName(BrahminMeat, "Brahmin Meat");
		LanguageRegistry.addName(BrahminSteak, "Brahmin Steak");
		GameRegistry.addSmelting(BrahminMeat.itemID, new ItemStack(BrahminSteak), 5);
		LanguageRegistry.addName(BighornerMeat, "Bighorner Meat");
		LanguageRegistry.addName(BighornerSteak, "Bighorner Steak");
		GameRegistry.addSmelting(BighornerMeat.itemID, new ItemStack(BighornerSteak), 5);
		LanguageRegistry.addName(BrahminWellington, "Brahmin Wellington");
		GameRegistry.addShapelessRecipe(new ItemStack(BrahminWellington), new Object [] {BrahminSteak, AntEgg, BCMAC});
		LanguageRegistry.addName(FireAntFricasse, "Fire Ant Fricasse");
		GameRegistry.addShapelessRecipe(new ItemStack(FireAntFricasse), new Object [] {Cram, AntMeat, Item.wheat});
		LanguageRegistry.addName(CaravanLunch, "Caravan Lunch");
		GameRegistry.addShapelessRecipe(new ItemStack(CaravanLunch), new Object [] {Cram, Instamash, PorkBeans, cardboard});
		LanguageRegistry.addName(DandyApples, "Dandy Boy Apples");
		GameRegistry.addRecipe(new ItemStack(DandyApples, 3), new Object [] {"X*X", "*#*", "X*X", 'X', cardboard, '*', Item.appleRed, '#', Item.sugar});
		LanguageRegistry.addName(NightstalkerTail, "Nightstalker Tail");
		LanguageRegistry.addName(TrailMix, "Trail Mix");
		GameRegistry.addShapelessRecipe(new ItemStack(TrailMix), new Object [] {SugarBombs, Item.appleRed, Item.blazePowder, Item.seeds});
		LanguageRegistry.addName(SugarBombs, "Sugar Bombs");
		GameRegistry.addRecipe(new ItemStack(SugarBombs, 3), new Object [] {"X*X", "*#*", "X*X", 'X', cardboard, '*', Item.sugar, '#', Item.wheat});
		LanguageRegistry.addName(PotatoChips, "Potato Crisps");
		GameRegistry.addRecipe(new ItemStack(PotatoChips, 3), new Object [] {"X*X", "*#*", "X*X", 'X', cardboard, '*', Item.potato, '#', Item.poisonousPotato});
		LanguageRegistry.addName(SunsetSass, "Sunset Sasparilla");
		GameRegistry.addShapelessRecipe(new ItemStack(SunsetSass), new Object [] {bottleCap, XanderRoot, XanderRoot, Item.glassBottle, Item.appleRed});
		LanguageRegistry.addName(bBananaYucca, "Banna Yucca Fruit");
		LanguageRegistry.addName(bCaveFungus, "Cave Fungus");
		LanguageRegistry.addName(bBuffaloGourd, "Buffalo Gourd Seed");
		LanguageRegistry.addName(bJalapeno, "Jalapeno");
		LanguageRegistry.addName(Jet, "Jet");
		GameRegistry.addShapelessRecipe(new ItemStack(Jet), new Object [] {jetInhaler, abraxo, abraxo, Item.sugar});
		LanguageRegistry.addName(Rocket, "Rocket");
		GameRegistry.addShapelessRecipe(new ItemStack(Rocket), new Object [] {Jet, abraxo, NukaCola});
		LanguageRegistry.addName(NukaCold, "Ice Cold Nuka Cola");
		GameRegistry.addShapelessRecipe(new ItemStack(NukaCold), new Object [] {NukaCola, Block.ice});
		LanguageRegistry.addName(NukaQuartz, "Nuka Cola Quartz");
		GameRegistry.addShapelessRecipe(new ItemStack(NukaQuartz), new Object [] {NukaCola, NukaCola, NukaCola, new ItemStack(Item.dyePowder, 1, 12)});
		LanguageRegistry.addName(NukaVictory, "Nuka Cola Victory");
		GameRegistry.addShapelessRecipe(new ItemStack(NukaVictory), new Object [] {NukaCola, NukaCola, NukaCola, new ItemStack(Item.dyePowder, 1, 1)});
		LanguageRegistry.addName(WeaponBinding, "Weapon Binding Ritual");
		GameRegistry.addShapelessRecipe(new ItemStack(WeaponBinding), new Object [] {Cleaver, leatherBelt, HealingPowder, wonderglue});
		LanguageRegistry.addName(Vodka, "Vodka");
		GameRegistry.addShapelessRecipe(new ItemStack(Vodka), new Object [] {Block.mushroomBrown, Block.mushroomRed, Item.glassBottle, Item.sugar, Item.bucketWater, Item.wheat});
		LanguageRegistry.addName(StealthBoy, "Stealth Boy");
		//TODO GameRegistry.addRecipe(new ItemStack(StealthBoy), new Object [] {});
		LanguageRegistry.addName(Turbo, "Turbo");
		GameRegistry.addShapelessRecipe(new ItemStack(Turbo), new Object [] {Jet, BrocFlower, Item.spiderEye, turpentine});

		LanguageRegistry.addName(T45Helm, "T-45d Power Helmet");
		GameRegistry.addRecipe(new ItemStack(T45Helm), new Object [] {"$*X", "X&X", " % ", 'X', tungstenPlate, '*', technetiumPlate, '&', BPGlass, '%', upgradeT45, '$', Item.lightStoneDust});
		LanguageRegistry.addName(T45Chest, "T-45d Power Chestplate");
		GameRegistry.addRecipe(new ItemStack(T45Chest, 1), new Object [] {" * ", "*X*", " * ", '*', upgradeT45, 'X', powerChest});
		LanguageRegistry.addName(T45Legs, "T-45d Power Leggings");
		GameRegistry.addRecipe(new ItemStack(T45Legs), new Object [] {"X*X", "% %", "X X", 'X', tungstenPlate, '*', upgradeT45, '%', MASM});
		LanguageRegistry.addName(T45Boots, "T-45d Power Boots");
		GameRegistry.addRecipe(new ItemStack(T45Boots), new Object [] {"X*X", "X X", 'X', tungstenPlate, '*', upgradeT45});
		LanguageRegistry.addName(T51Helm, "T-51b Power Helmet");
		GameRegistry.addRecipe(new ItemStack(T51Helm, 1), new Object [] {" X ", "X*X", " X ", 'X', upgradeT51, '*', T45Helm});
		LanguageRegistry.addName(T51Chest, "T-51b Power Chestplate");
		GameRegistry.addRecipe(new ItemStack(T51Chest, 1), new Object [] {" X ", "X*X", " X ", 'X', upgradeT51, '*', T45Chest});
		LanguageRegistry.addName(T51Legs, "T-51b Power Leggings");
		GameRegistry.addRecipe(new ItemStack(T51Legs, 1), new Object [] {" X ", "X*X", " X ", 'X', upgradeT51, '*', T45Legs});
		LanguageRegistry.addName(T51Boots, "T-51b Power Boots");
		GameRegistry.addRecipe(new ItemStack(T51Boots, 1), new Object [] {" X ", "X*X", " X ", 'X', upgradeT51, '*', T45Boots});
		LanguageRegistry.addName(G1Helm, "Gecko Backed Leather Cap");
		GameRegistry.addRecipe(new ItemStack(G1Helm, 1), new Object [] {"XXX", "X*X", 'X', geckoHide, '*', Item.helmetLeather});
		LanguageRegistry.addName(G1Chest, "Gecko Backed Leather Tunic");
		GameRegistry.addRecipe(new ItemStack(G1Chest, 1), new Object [] {"X X", "X*X", "XXX", 'X', geckoHide, '*', Item.plateLeather});
		LanguageRegistry.addName(G1Legs, "Gecko Backed Leather Leggings");
		GameRegistry.addRecipe(new ItemStack(G1Legs, 1), new Object [] {"XXX", "X*X", "X X", 'X', geckoHide, '*', Item.legsLeather});
		LanguageRegistry.addName(G1Boots, "Gecko Backed Leather Boots");
		GameRegistry.addRecipe(new ItemStack(G1Boots, 1), new Object [] {"X*X", "X X", 'X', geckoHide, '*', Item.bootsLeather});
		LanguageRegistry.addName(EnclaveHelm, "Enclave Powered Helmet");
		//GameRegistry.addRecipe(new ItemStack(EnclaveHelm), new Object [] {});
		LanguageRegistry.addName(EnclaveChest, "Enclave Powered Chestplate");
		//GameRegistry.addRecipe(new ItemStack(EnclaveChest), new Object [] {});
		LanguageRegistry.addName(EnclaveLegs, "Enclave Powered Leggings");
		//GameRegistry.addRecipe(new ItemStack(EnclaveLegs), new Object [] {});
		LanguageRegistry.addName(EnclaveBoots, "Enclave Powered Boots");
		//GameRegistry.addRecipe(new ItemStack(EnclaveBoots), new Object [] {});
		LanguageRegistry.addName(HellHelm, "Advanced Power Armor Helmet");
		//GameRegistry.addRecipe(new ItemStack(HellHelm), new Object [] {});
		LanguageRegistry.addName(HellChest, "Advanced Power Armor Chestplate");
		//GameRegistry.addRecipe(new ItemStack(HellChest), new Object [] {});
		LanguageRegistry.addName(HellLegs, "Advanced Power Armor Leggings");
		//GameRegistry.addRecipe(new ItemStack(HellLegs), new Object [] {});
		LanguageRegistry.addName(HellBoots, "Advanced Power Armor Boots");
		//GameRegistry.addRecipe(new ItemStack(HellBoots), new Object [] {});
		LanguageRegistry.addName(WinterHelm, "Winterized T-51b Helmet");
		//GameRegistry.addRecipe(new ItemStack(WinterHelm), new Object [] {});
		LanguageRegistry.addName(WinterChest, "Winterized T-51b Chestplate");
		//GameRegistry.addRecipe(new ItemStack(WinterChest), new Object [] {});
		LanguageRegistry.addName(WinterLegs, "Winterized T-51b Leggings");
		//GameRegistry.addRecipe(new ItemStack(WinterLegs), new Object [] {});
		LanguageRegistry.addName(WinterBoots, "Winterized T-51b Boots");
		//GameRegistry.addRecipe(new ItemStack(WinterBoots), new Object [] {});

		//Version 1.7
		LanguageRegistry.addName(grip, "Gun Grip");
		GameRegistry.addRecipe(new ItemStack(grip), new Object [] {"X*X", "X*X", " X*", 'X', Item.leather, '*', ingotTungsten});
		LanguageRegistry.addName(stock, "Stock");
		GameRegistry.addRecipe(new ItemStack(stock), new Object [] {"XXX", " XX", 'X', Block.planks});
		LanguageRegistry.addName(barrel, "Gun Barrel");
		GameRegistry.addRecipe(new ItemStack(barrel), new Object [] {"XXX", "   ", "XXX", 'X', Item.ingotIron});
		LanguageRegistry.addName(magnifier, "Laser Magnification Device");
		GameRegistry.addRecipe(new ItemStack(magnifier), new Object [] {"X X", " * ", "X X", 'X', ingotTechnetium, '*', Item.diamond});
		LanguageRegistry.addName(hammer, "Hammer");
		GameRegistry.addRecipe(new ItemStack(hammer), new Object [] {"  X", "XX ", " X ", 'X', Item.ingotIron});
		LanguageRegistry.addName(gasTank, "Motorcycle Gas Tank");
		GameRegistry.addRecipe(new ItemStack(gasTank), new Object [] {" X ", "X*X", "XXX", 'X', ingotTungsten, '*', homemadeFuel});

		//Version 1.7.1
		LanguageRegistry.addName(PlasmaRifle, "Plasma Rifle");
		
		EntityRegistry.registerGlobalEntityID(EntityFGhoul.class, "FGhoul", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.FGhoul.name", "en_US", "Feral Ghoul");
		EntityRegistry.addSpawn(EntityFGhoul.class, 5, 1, 2, EnumCreatureType.monster, Wasteland);

		EntityRegistry.registerGlobalEntityID(EntityGlowingOne.class, "GlowingOne", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.GlowingOne.name", "en_US", "Glowing One");
		EntityRegistry.addSpawn(EntityGlowingOne.class, 5, 1, 2, EnumCreatureType.creature, Wasteland);

		EntityRegistry.registerGlobalEntityID(EntityNightStalker.class, "Nightstalker", ModLoader.getUniqueEntityId(), 230, 78);
		ModLoader.addLocalization("entity.NightStalker.name", "en_US", "Nightstalker");
		EntityRegistry.addSpawn(EntityNightStalker.class, 5, 1, 2, EnumCreatureType.creature, Wasteland);

		EntityRegistry.registerGlobalEntityID(EntityBrahmin.class, "Brahmin", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.Brahmin.name", "en_US", "Brahmin");
		EntityRegistry.addSpawn(EntityBrahmin.class, 5, 1, 2, EnumCreatureType.creature, Wasteland);

		EntityRegistry.registerGlobalEntityID(EntityGiantAnt.class, "GiantAnt", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.GiantAnt.name", "en_US", "Giant Ant");
		EntityRegistry.addSpawn(EntityGiantAnt.class, 5, 1, 2, EnumCreatureType.creature, Wasteland);

		EntityRegistry.registerGlobalEntityID(EntityBOSPaladin.class, "BOSPaladin", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.BOSPaladin.name", "en_US", "Brotherhood of Steel Paladin");
		EntityRegistry.addSpawn(EntityBOSPaladin.class, 5, 1, 2, EnumCreatureType.creature, Wasteland);

		EntityRegistry.registerGlobalEntityID(EntityRadroach.class, "Radroach", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.Radroach.name", "en_US", "Radroach");
		EntityRegistry.addSpawn(EntityRadroach.class, 5, 1, 2, EnumCreatureType.creature, Wasteland);

		EntityRegistry.registerGlobalEntityID(EntityGecko.class, "Gecko", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.Gecko.name", "en_US", "Young Gecko");
		EntityRegistry.addSpawn(EntityRadroach.class, 5, 1, 2, EnumCreatureType.creature, Wasteland);
		
		EntityRegistry.registerGlobalEntityID(EntityFragGrenade.class, "FragGrenade", ModLoader.getUniqueEntityId());

		LanguageRegistry.addName(TungstenOre, "Tungsten Ore");
		MinecraftForge.setBlockHarvestLevel(TungstenOre, "pickaxe", 2);
		GameRegistry.registerBlock(TungstenOre);
		LanguageRegistry.addName(TechnetiumOre, "Technetium Ore");
		MinecraftForge.setBlockHarvestLevel(TechnetiumOre, "pickaxe", 3);
		GameRegistry.registerBlock(TechnetiumOre);
		LanguageRegistry.addName(SaturniteOre, "Saturnite Ore");
		MinecraftForge.setBlockHarvestLevel(SaturniteOre, "pickaxe", 3);
		GameRegistry.registerBlock(SaturniteOre);
		LanguageRegistry.addName(BrocFlower, "Broc Flower");
		GameRegistry.registerBlock(BrocFlower);
		LanguageRegistry.addName(XanderRoot, "Xander Root");
		GameRegistry.registerBlock(XanderRoot);
		LanguageRegistry.addName(BPGlass, "Bulletproof Glass");
		MinecraftForge.setBlockHarvestLevel(BPGlass, "pickaxe", 3);
		GameRegistry.registerBlock(BPGlass);
		GameRegistry.addRecipe(new ItemStack(BPGlass), new Object [] {"***", "*X*", "***", 'X', net.minecraft.block.Block.glass, '*', tungstenPlate});
		LanguageRegistry.addName(UraniumOre, "Uranium Ore");
		MinecraftForge.setBlockHarvestLevel(UraniumOre, "pickaxe", 2);
		GameRegistry.registerBlock(UraniumOre);
		LanguageRegistry.addName(SiliconDeposit, "Silicon Deposit");
		MinecraftForge.setBlockHarvestLevel(TungstenOre, "pickaxe", 2);
		GameRegistry.registerBlock(SiliconDeposit);
		LanguageRegistry.addName(CarbonDeposit, "Carbon Deposit");
		MinecraftForge.setBlockHarvestLevel(CarbonDeposit, "pickaxe", 1);
		GameRegistry.registerBlock(CarbonDeposit);
		LanguageRegistry.addName(AsbestosDeposit, "Asbestos Deposit");
		MinecraftForge.setBlockHarvestLevel(AsbestosDeposit, "pickaxe", 2);
		GameRegistry.registerBlock(AsbestosDeposit);
		LanguageRegistry.addName(BarrelCactus, "Barrel Cactus");
		GameRegistry.registerBlock(BarrelCactus);
		LanguageRegistry.addName(BananaYucca, "Banna Yucca Plant");
		GameRegistry.registerBlock(BananaYucca);
		LanguageRegistry.addName(CaveFungus, "Cave Fungus");
		GameRegistry.registerBlock(CaveFungus);
		LanguageRegistry.addName(BuffaloGourd, "Buffalo Gourd Plant");
		GameRegistry.registerBlock(BuffaloGourd);
		LanguageRegistry.addName(Jalapeno, "Jalapeno Plant");
		GameRegistry.registerBlock(Jalapeno);

		GameRegistry.addBiome(Wasteland);

		GameRegistry.registerWorldGenerator(new WorldGenTungstenOre());
		GameRegistry.registerWorldGenerator(new WorldGenTechOre());
		GameRegistry.registerWorldGenerator(new WorldGenSatOre());
		GameRegistry.registerWorldGenerator(new WorldGenUraniumOre());
		GameRegistry.registerWorldGenerator(new WorldGenBrocFlower());
		GameRegistry.registerWorldGenerator(new WorldGenSiliconDeposit());
		GameRegistry.registerWorldGenerator(new WorldGenAsbestosDeposit());
		GameRegistry.registerWorldGenerator(new WorldGenCarbonDeposit());

		proxy.registerRenderers();
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event)
	{

	}
}