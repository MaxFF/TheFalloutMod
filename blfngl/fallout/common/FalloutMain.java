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
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
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
import blfngl.fallout.entity.EntityBrahmin;
import blfngl.fallout.entity.EntityFGhoul;
import blfngl.fallout.entity.EntityGlowingOne;
import blfngl.fallout.entity.EntityNightStalker;
import blfngl.fallout.food.BlockBananaYucca;
import blfngl.fallout.food.BlockBarrelCactus;
import blfngl.fallout.food.BlockBrocFlower;
import blfngl.fallout.food.BlockBuffaloGourd;
import blfngl.fallout.food.BlockCaveFungus;
import blfngl.fallout.food.BlockJalapeno;
import blfngl.fallout.food.BlockXanderRoot;
import blfngl.fallout.food.ItemNukaQuartz;
import blfngl.fallout.food.ItemNukaVictory;
import blfngl.fallout.food.ItemRocket;
import blfngl.fallout.food.ItemSlasher;
import blfngl.fallout.food.ItemSuperStimpak;
import blfngl.fallout.food.ItemWeaponBinding;
import blfngl.fallout.food.ItembCaveFungus;
import blfngl.fallout.food.ItembXanderRoot;
import blfngl.fallout.food.WorldGenBrocFlower;
import blfngl.fallout.gun.Gun22LR;
import blfngl.fallout.gun.Gun308;
import blfngl.fallout.gun.Gun357;
import blfngl.fallout.gun.Gun44;
import blfngl.fallout.gun.GunECell;
import blfngl.fallout.gun.GunIncinerator;
import blfngl.fallout.gun.GunMFCell;
import blfngl.fallout.items.BaseDrink;
import blfngl.fallout.items.BaseFood;
import blfngl.fallout.items.BaseItem;
import blfngl.fallout.items.ItemSyringe;
import blfngl.fallout.melee.BaseMelee;
import blfngl.fallout.melee.WeapBallisticFist;
import blfngl.fallout.melee.WeapBotE;
import blfngl.fallout.melee.WeapCosFire;
import blfngl.fallout.melee.WeapDisplacerGlove;
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
 * The following code, in any form, is the copyright of blfngl
 **/

@Mod(modid = "fallout", name = "The Fallout Mod", version = "1.5")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)//, channels={"falloutchannel"}, packetHandler = FalloutPacketHandler.class)

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
	public static EnumToolMaterial SCI = EnumHelper.addToolMaterial("SCI", 0, 316, 5.0F, 3, 6);
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
	public static final Item Incinerator = (new GunIncinerator(3100)).setUnlocalizedName("Incinerator").setCreativeTab(TabFalloutGuns);
	public static final Item LaserRCW = (new GunMFCell(3101, 2, 60, 1, 1, "blfngl.LaserFire", "blfngl.LaserFire")).setUnlocalizedName("LaserRCW").setCreativeTab(TabFalloutGuns);
	public static final Item Compliance = new GunECell(3102, 2, 12, 2, 3, "blfngl.LaserPistolFire", "blfngl.LaserPistolFire").setUnlocalizedName("Compliance").setCreativeTab(TabFalloutGuns);
    public static final Item LaserRifle = new GunMFCell(3103, 7, 30, 1, 4, "blfngl.LaserFire", "blfngl.LaserFire").setUnlocalizedName("LaserRifle").setCreativeTab(TabFalloutGuns);

	public static final Item g44Mag = (new Gun44(3104, 10, 6, 3, 5, "blfngl.44Fire", "blfngl.44Fire")).setUnlocalizedName("g44Mag").setCreativeTab(TabFalloutGuns);
	public static final Item g357Mag = (new Gun357(3105, 8, 6, 3, 5, "blfngl.357Fire", "blfngl.357Fire")).setUnlocalizedName("g357Mag").setCreativeTab(TabFalloutGuns);
	public static final Item Silenced22 = (new Gun22LR(3106, 12, 12, 2, 2, "blfngl.Silenced22Fire", "blfngl.Silenced22Fire")).setUnlocalizedName("Silenced22").setCreativeTab(TabFalloutGuns);
	public static final Item Sniper308 = (new Gun308(3107, 7, 7, 3, 4, "blfngl.SniperFire", "blfngl.SniperFire")).setUnlocalizedName("Sniper308").setCreativeTab(TabFalloutGuns);

	//========================================Melee Weapons=================================================

	public static final Item BotE = new WeapBotE(3005, BOTE).setUnlocalizedName("BotE").setCreativeTab(TabFalloutWeap);
	public static final Item BumperSword = new WeapBotE(3024, EnumToolMaterial.EMERALD).setUnlocalizedName("BumperSword").setCreativeTab(TabFalloutWeap);
	public static final Item Cleaver = new BaseMelee(3003, CLEAVE).setUnlocalizedName("Cleaver").setCreativeTab(TabFalloutWeap);
	public static final Item ComKnife = new BaseMelee(3004, COMKNIFE).setUnlocalizedName("ComKnife").setCreativeTab(TabFalloutWeap);
	public static final Item CosKnife = new BaseMelee(3006, COS).setUnlocalizedName("CosKnife").setCreativeTab(TabFalloutWeap);
	public static final Item CosClean = new BaseMelee(3007, COS).setUnlocalizedName("CosClean").setCreativeTab(TabFalloutWeap);
	public static final Item CosFire = (new WeapCosFire(3008)).setUnlocalizedName("CosFire").setCreativeTab(TabFalloutWeap);
	public static final Item FireAxe = new BaseMelee(3010, EnumToolMaterial.IRON).setUnlocalizedName("FireAxe").setCreativeTab(TabFalloutWeap);
	public static final Item Knife = new BaseMelee(3011, EnumToolMaterial.STONE).setUnlocalizedName("Knife").setCreativeTab(TabFalloutWeap);
	public static final Item Machete = new BaseMelee(3012, EnumToolMaterial.IRON).setUnlocalizedName("Machete").setCreativeTab(TabFalloutWeap);
	public static final Item Shishkebab = new WeapShishkebab(3013, EnumToolMaterial.IRON).setUnlocalizedName("Shishkebab").setCreativeTab(TabFalloutWeap);
	public static final Item StraightRazor = new BaseMelee(3014, EnumToolMaterial.STONE).setUnlocalizedName("StraightRazor").setCreativeTab(TabFalloutWeap);
	public static final Item Switchblade = new BaseMelee(3015, EnumToolMaterial.STONE).setUnlocalizedName("Switchblade").setCreativeTab(TabFalloutWeap);
	public static final Item PintSizedKnife = new BaseMelee(3009, PINT).setUnlocalizedName("PintSizedKnife").setCreativeTab(TabFalloutWeap);

	//========================================Unarmed Weapons===============================================
	
	public static final Item BallisticFist = new WeapBallisticFist(3016, EnumToolMaterial.IRON).setUnlocalizedName("BallisticFist").setCreativeTab(TabFalloutWeap);
	public static final Item BladedGauntlet = new BaseMelee(3017, EnumToolMaterial.IRON).setUnlocalizedName("BladedGauntlet").setCreativeTab(TabFalloutWeap);
	public static final Item BoxingGloves = new BaseMelee(3018, EnumToolMaterial.WOOD).setUnlocalizedName("BoxingGloves").setCreativeTab(TabFalloutWeap);
	//public static final Item BoxingTape = new WeapFalloutBaseMelee(3019, EnumToolMaterial.WOOD).setUnlocalizedName("BoxingTape").setCreativeTab(TabFalloutWeap);
	public static final Item BrassKnuckles = new BaseMelee(3020, EnumToolMaterial.STONE).setUnlocalizedName("BrassKnuckles").setCreativeTab(TabFalloutWeap);
	public static final Item DisplacerGlove = new WeapDisplacerGlove(3021, PFIST).setUnlocalizedName("DisplacerGlove").setCreativeTab(TabFalloutWeap);
	public static final Item GoldenGloves = new BaseMelee(3025, EnumToolMaterial.GOLD).setUnlocalizedName("GoldenGloves").setCreativeTab(TabFalloutWeap);
	public static final Item PowerFist = new WeapPowerFist(3001, EnumToolMaterial.EMERALD).setUnlocalizedName("PowerFist").setCreativeTab(TabFalloutWeap);
	public static final Item SatFist = new WeapPowerFist(3023, EnumToolMaterial.EMERALD).setUnlocalizedName("SatFist").setCreativeTab(TabFalloutWeap);
	public static final Item SatHeatFist = new WeapSatHeatFist(3000, PFIST).setUnlocalizedName("SatHeatFist").setCreativeTab(TabFalloutWeap);
	public static final Item SciGlove = new WeapSciGlove(3002, SCI).setUnlocalizedName("SciGlove").setCreativeTab(TabFalloutWeap);
	public static final Item ZapGlove = new WeapZapGlove(3022, EnumToolMaterial.IRON).setUnlocalizedName("ZapGlove").setCreativeTab(TabFalloutWeap);

	//============================================Items==========================================================

	public static final Item TungstenRod = (new BaseItem(901)).setUnlocalizedName("TungstenRod").setCreativeTab(TabFalloutMisc);
	public static final Item TungstenIngot = (new BaseItem(902)).setUnlocalizedName("TungstenIngot").setCreativeTab(TabFalloutMisc);
	public static final Item TechnetiumChunk = (new BaseItem(903)).setUnlocalizedName("TechnetiumChunk").setCreativeTab(TabFalloutMisc);
	public static final Item TechnetiumIngot = (new BaseItem(904)).setUnlocalizedName("TechnetiumIngot").setCreativeTab(TabFalloutMisc);
	public static final Item SiliconChunk = (new BaseItem(907)).setUnlocalizedName("SiliconChunk").setCreativeTab(TabFalloutMisc);
	public static final Item SiliconBar = (new BaseItem(908)).setUnlocalizedName("SiliconBar").setCreativeTab(TabFalloutMisc);
	public static final Item TungstenFilter = (new BaseItem(909)).setUnlocalizedName("TungstenFilter").setCreativeTab(TabFalloutMisc);
	public static final Item AsbestosChunk = (new BaseItem(910)).setUnlocalizedName("AsbestosChunk").setCreativeTab(TabFalloutMisc);
	public static final Item AsbestosBar = (new BaseItem(911)).setUnlocalizedName("AsbestosBar").setCreativeTab(TabFalloutMisc);
	public static final Item UraniumIngot = (new BaseItem(912)).setUnlocalizedName("UraniumIngot").setCreativeTab(TabFalloutMisc);
	public static final Item TungstenPlate = (new BaseItem(913)).setUnlocalizedName("TungstenPlate").setCreativeTab(TabFalloutMisc);
	public static final Item TechnetiumPlate = (new BaseItem(914)).setUnlocalizedName("TechnetiumPlate").setCreativeTab(TabFalloutMisc);
	public static final Item RAP = (new BaseItem(915)).setUnlocalizedName("RAP").setCreativeTab(CreativeTabs.tabMaterials).setCreativeTab(TabFalloutMisc);
	public static final Item MFCell = (new BaseItem(916)).setUnlocalizedName("MFCell").setCreativeTab(TabFalloutMisc);
	public static final Item MFPack = (new BaseItem(917)).setUnlocalizedName("MFPack").setCreativeTab(TabFalloutMisc);
	public static final Item Carbon = (new BaseItem(918)).setUnlocalizedName("Carbon").setCreativeTab(TabFalloutMisc);
	public static final Item Teflon = (new BaseItem(919)).setUnlocalizedName("Teflon").setCreativeTab(TabFalloutMisc);
	public static final Item Polyethylene = (new BaseItem(920)).setUnlocalizedName("Polyethylene").setCreativeTab(TabFalloutMisc);
	public static final Item BottleCap = (new BaseItem(921)).setUnlocalizedName("BottleCap").setCreativeTab(TabFalloutMisc);
	public static final Item Fan = (new BaseItem(922)).setUnlocalizedName("Fan").setCreativeTab(TabFalloutMisc);
	public static final Item Gear = (new BaseItem(923)).setUnlocalizedName("Gear").setCreativeTab(TabFalloutMisc);
	public static final Item Gyro = (new BaseItem(924)).setUnlocalizedName("Gyro").setCreativeTab(TabFalloutMisc);
	public static final Item MASM = (new BaseItem(925)).setUnlocalizedName("MASM").setCreativeTab(TabFalloutMisc);
	public static final Item TXMF = (new BaseItem(926)).setUnlocalizedName("TXMF").setCreativeTab(TabFalloutMisc);
	public static final Item Card = (new BaseItem(927)).setUnlocalizedName("Card").setCreativeTab(TabFalloutMisc);
	public static final Item Deck = (new BaseItem(928)).setUnlocalizedName("Deck").setCreativeTab(TabFalloutMisc);
	public static final Item Cardboard = (new BaseItem(929)).setUnlocalizedName("Cardboard").setCreativeTab(TabFalloutMisc);
	public static final Item TinCan = (new BaseItem(930)).setUnlocalizedName("TinCan").setCreativeTab(TabFalloutMisc);
	public static final Item SatRod = (new BaseItem(931)).setUnlocalizedName("SatRod").setCreativeTab(TabFalloutMisc);
	public static final Item SatIngot = (new BaseItem(932)).setUnlocalizedName("SatIngot").setCreativeTab(TabFalloutMisc);
	public static final Item SatAlloy = (new BaseItem(933)).setUnlocalizedName("SatAlloy").setCreativeTab(TabFalloutMisc);
	public static final Item SatAlloyPlate= (new BaseItem(934)).setUnlocalizedName("SatAlloyPlate").setCreativeTab(TabFalloutMisc);
	public static final Item EmptySyringe = (new ItemSyringe(935)).setUnlocalizedName("EmptySyringe").setCreativeTab(TabFalloutMisc);
	public static final Item BloodSyringe = (new BaseItem(936)).setUnlocalizedName("BloodSyringe").setCreativeTab(TabFalloutMisc);
	public static final Item PTorso  = (new BaseItem(2059)).setUnlocalizedName("PTorso").setCreativeTab(TabFalloutMisc);
	public static final Item PShoulders  = (new BaseItem(2058)).setUnlocalizedName("PShoulders").setCreativeTab(TabFalloutMisc);
	public static final Item PChest = (new BaseItem(2060)).setUnlocalizedName("PChest").setCreativeTab(TabFalloutMisc);
	public static final Item T45Upgrade = (new BaseItem(195)).setUnlocalizedName("T45Upgrade").setCreativeTab(TabFalloutMisc);
	public static final Item EnclaveUpgrade = (new BaseItem(196)).setUnlocalizedName("EnclaveUpgrade").setCreativeTab(TabFalloutMisc);	
	public static final Item T51Upgrade = (new BaseItem(197)).setUnlocalizedName("T51Upgrade").setCreativeTab(TabFalloutMisc);
	public static final Item HellfireUpgrade = (new BaseItem(198)).setUnlocalizedName("HellfireUpgrade").setCreativeTab(TabFalloutMisc);
	public static final Item WinterizedUpgrade = (new BaseItem(199)).setUnlocalizedName("WinterizedUpgrade").setCreativeTab(TabFalloutMisc);
	public static final Item NukaBottle = (new BaseItem(201)).setUnlocalizedName("NukaBottle").setCreativeTab(TabFalloutMisc);
	//public static final Item PipBoy = ItemPipBoy(202)).setUnlocalizedName("PipBoy").setCreativeTab(TabFalloutGuns);
	public static final Item Abraxo = (new BaseItem(207)).setUnlocalizedName("Abraxo").setCreativeTab(TabFalloutMisc);
	public static final Item a22LR = (new BaseItem(203)).setUnlocalizedName("a22LR").setCreativeTab(TabFalloutMisc);
	public static final Item a308 = (new BaseItem(204)).setUnlocalizedName("a308").setCreativeTab(TabFalloutMisc);
	public static final Item a357 = (new BaseItem(205)).setUnlocalizedName("a357").setCreativeTab(TabFalloutMisc);
	public static final Item a44 = (new BaseItem(206)).setUnlocalizedName("a44").setCreativeTab(TabFalloutMisc);
	public static final Item ScrapMetal = (new BaseItem(208)).setUnlocalizedName("ScrapMetal").setCreativeTab(TabFalloutMisc);
	public static final Item ECell = (new BaseItem(209)).setUnlocalizedName("ECell").setCreativeTab(TabFalloutMisc);
	public static final Item HomemadeFuel = (new BaseItem(210)).setUnlocalizedName("HomemadeFuel").setCreativeTab(TabFalloutMisc);
	public static final Item EPack = (new BaseItem(211)).setUnlocalizedName("EPack").setCreativeTab(TabFalloutMisc);
	public static final Item LeatherBelt = (new BaseItem(212)).setUnlocalizedName("LeatherBelt").setCreativeTab(TabFalloutMisc);
	public static final Item BottleCapMine = (new ItemBottleCapMine(213)).setUnlocalizedName("BottleCapMine").setCreativeTab(TabFalloutMisc);
	public static final Item FragGrenade = (new ItemFragGrenade(214)).setUnlocalizedName("FragGrenade").setCreativeTab(TabFalloutMisc);
	public static final Item Lunchbox = (new BaseItem(215)).setUnlocalizedName("Lunchbox").setCreativeTab(TabFalloutMisc);
	public static final Item SensorModule = (new BaseItem(216)).setUnlocalizedName("SensorModule").setCreativeTab(TabFalloutMisc);
	public static final Item Cherrybomb = (new BaseItem(217)).setUnlocalizedName("Cherrybomb").setCreativeTab(TabFalloutMisc);
	public static final Item NightstalkerBlood = (new BaseItem(219)).setUnlocalizedName("NightstalkerBlood").setCreativeTab(TabFalloutMisc);
	public static final Item JetInhaler = (new BaseItem(220)).setUnlocalizedName("JetInhaler").setCreativeTab(TabFalloutMisc);
	public static final Item Wonderglue = (new BaseItem(221)).setUnlocalizedName("Wonderglue").setCreativeTab(TabFalloutMisc);
	public static final Item Turpentine = (new BaseItem(222)).setUnlocalizedName("Turpentine").setCreativeTab(TabFalloutMisc);
	public static final Item GeckoHide = (new BaseItem(223)).setUnlocalizedName("GeckoHide").setCreativeTab(TabFalloutMisc);
	public static final Item Minecraft9 = (new BaseItem(224)).setUnlocalizedName("Minecraft9").setCreativeTab(TabFalloutMisc);

	//============================================Food and Chems==========================================================

	public static final Item Stimpak = new BaseFood(2500, 1, 0.3F, true).setPotionEffect(Potion.heal.id, 2, 0, 1F).setUnlocalizedName("Stimpak").setCreativeTab(TabFalloutFood);
	public static final Item SuperStimpak = new ItemSuperStimpak(2501, 1, true).setUnlocalizedName("SuperStimpak").setCreativeTab(TabFalloutFood);
	public static final Item BCMAC = new BaseFood(2502, 5, 0.3F, false).setUnlocalizedName("BCMAC").setCreativeTab(TabFalloutFood);
	public static final Item Cram = new BaseFood(2503, 5, 0.3F, false).setUnlocalizedName("Cram").setCreativeTab(TabFalloutFood);
	public static final Item Instamash = new BaseFood(2504, 5, 0.3F, false).setUnlocalizedName("Instamash").setCreativeTab(TabFalloutFood);
	public static final Item PorkBeans = new BaseFood(2505, 5, 0.3F, false).setUnlocalizedName("PorkBeans").setCreativeTab(TabFalloutFood);
	public static final Item Salisbury = new BaseFood(2506, 5, 0.3F, false).setUnlocalizedName("Salisbury").setCreativeTab(TabFalloutFood);
	public static final Item YumYum = new BaseFood(2507, 5, 0.3F, false).setUnlocalizedName("YumYum").setCreativeTab(TabFalloutFood);
	public static final Item Psycho = new BaseFood(2508, 1, 0.3F, false).setPotionEffect(Potion.damageBoost.id, 60, 0, 1F).setUnlocalizedName("Psycho").setCreativeTab(TabFalloutFood);
	public static final Item MedEx = new BaseFood(2509, 1, 0.3F, false).setPotionEffect(Potion.resistance.id, 60, 0, 1F).setUnlocalizedName("MedEx").setCreativeTab(TabFalloutFood);
	public static final Item Slasher = new ItemSlasher(2510, 1, false).setUnlocalizedName("Slasher").setCreativeTab(TabFalloutFood);
	public static final Item Hydra = new BaseDrink(2511, 1, 0.3F, false).setPotionEffect(Potion.regeneration.id, 60, 2, 2F).setUnlocalizedName("Hydra").setCreativeTab(TabFalloutFood);
	public static final Item NukaCola = new BaseFood(2512, 7, 0.3F, false).setUnlocalizedName("NukaCola").setCreativeTab(TabFalloutFood);
	public static final Item HealingPowder = new BaseFood(2513, 1, 0.3F, false).setPotionEffect(Potion.heal.id, 2, 0, 1F).setUnlocalizedName("HealingPowder").setCreativeTab(TabFalloutFood);
	public static final Item bBarrelCactus = new BaseFood(2514, 8, 0.3F, false).setUnlocalizedName("bBarrelCactus").setCreativeTab(TabFalloutFood);
	public static final Item bBrocFlower = new BaseFood(2515, 8, 0.3F, false).setUnlocalizedName("bBrocFlower").setCreativeTab(TabFalloutFood);
	public static final Item bXanderRoot = new ItembXanderRoot(2516, 8, 0.3F, false).setUnlocalizedName("bXanderRoot").setCreativeTab(TabFalloutFood);
	public static final Item AntEgg = new BaseFood(2517, 5, 0.3F, false).setUnlocalizedName("AntEgg").setCreativeTab(TabFalloutFood);
	public static final Item AntMeat = new BaseFood(2518, 6, 0.3F, true).setUnlocalizedName("AntMeat").setCreativeTab(TabFalloutFood);
	public static final Item BighornerSteak = new BaseFood(2519, 10, 0.3F, true).setUnlocalizedName("BighornerSteak").setCreativeTab(TabFalloutFood);
	public static final Item BloodSausage = new BaseFood(2520, 16, 0.3F, true).setUnlocalizedName("BloodSausage").setCreativeTab(TabFalloutFood);
	public static final Item BlackBloodSausage = new BaseFood(2521, 20, 0.3F, true).setUnlocalizedName("BlackBloodSausage").setCreativeTab(TabFalloutFood);
	public static final Item BighornerMeat = new BaseFood(2522, 4, 0.3F, true).setUnlocalizedName("BighornerMeat").setCreativeTab(TabFalloutFood);
	public static final Item BrahminMeat = new BaseFood(2523, 3, 0.3F, true).setUnlocalizedName("BrahminMeat").setCreativeTab(TabFalloutFood);
	public static final Item BrahminSteak = new BaseFood(2524, 8, 0.3F, true).setUnlocalizedName("BrahminSteak").setCreativeTab(TabFalloutFood);
	public static final Item BrahminWellington = new BaseFood(2525, 14, 0.3F, true).setUnlocalizedName("BrahminWellington").setCreativeTab(TabFalloutFood);
	public static final Item FireAntFricasse = new BaseFood(2526, 12, 0.3F, false).setPotionEffect(Potion.fireResistance.id, 60, 0, 1F).setUnlocalizedName("FireAntFricasse").setCreativeTab(TabFalloutFood);
	public static final Item CaravanLunch = new BaseFood(2527, 15, 0.3F, false).setUnlocalizedName("CaravanLunch").setCreativeTab(TabFalloutFood);
	public static final Item DandyApples = new BaseFood(2528, 5, 0.3F, false).setUnlocalizedName("DandyApples").setCreativeTab(TabFalloutFood);
	public static final Item NightstalkerTail = new BaseFood(2529, 6, 0.3F, false).setUnlocalizedName("NightstalkerTail").setCreativeTab(TabFalloutFood);
	public static final Item TrailMix = new BaseFood(2530, 12, 0.3F, false).setUnlocalizedName("TrailMix").setCreativeTab(TabFalloutFood);
	public static final Item SugarBombs = new BaseFood(2531, 8, 0.3F, false).setUnlocalizedName("SugarBombs").setCreativeTab(TabFalloutFood);
	public static final Item PotatoChips = new BaseFood(2532, 5, 0.3F, false).setUnlocalizedName("PotatoChips").setCreativeTab(TabFalloutFood);
	public static final Item SunsetSass = new BaseDrink(2533, 5, 0.3F, false).setUnlocalizedName("SunsetSass").setCreativeTab(TabFalloutFood);
	public static final Item bBananaYucca = new BaseFood(2534, 6, 0.3F, false).setUnlocalizedName("bBananaYucca").setCreativeTab(TabFalloutFood);
	public static final Item bCaveFungus = new ItembCaveFungus(2535, 6, 0.3F, false).setUnlocalizedName("bCaveFungus").setCreativeTab(TabFalloutFood);
	public static final Item bBuffaloGourd = new BaseFood(2536, 4, 0.3F, false).setUnlocalizedName("bBuffaloGourd").setCreativeTab(TabFalloutFood);
	public static final Item bJalapeno = new BaseFood(2537, 4, 0.3F, false).setUnlocalizedName("bJalapeno").setCreativeTab(TabFalloutFood);
	public static final Item Jet = new BaseDrink(2538, 1, 0.3F, false).setPotionEffect(Potion.digSpeed.id, 60, 0, 1F).setUnlocalizedName("Jet").setCreativeTab(TabFalloutFood);
	public static final Item Rocket = new ItemRocket(2539, 1, false).setUnlocalizedName("Rocket").setCreativeTab(TabFalloutFood);
	public static final Item NukaQuartz = new ItemNukaQuartz(2540, 1, false).setUnlocalizedName("NukaQuartz").setCreativeTab(TabFalloutFood);
	public static final Item NukaCold = new BaseDrink(2541, 1, 0.3F, false).setUnlocalizedName("NukaCold").setCreativeTab(TabFalloutFood);
	public static final Item NukaVictory = new ItemNukaVictory(2542, 1, false).setPotionEffect(Potion.digSpeed.id, 60, 0, 1F).setPotionEffect(Potion.moveSpeed.id, 60, 0, 1F).setUnlocalizedName("NukaVictory").setCreativeTab(TabFalloutFood);
	public static final Item WeaponBinding = new ItemWeaponBinding(2546, 1, false).setUnlocalizedName("WeaponBinding").setCreativeTab(TabFalloutFood);
	public static final Item Vodka = new BaseDrink(2543, 1, 0.3F, false).setPotionEffect(Potion.damageBoost.id, 60, 0, 1F).setPotionEffect(Potion.confusion.id, 60, 0, 1F).setPotionEffect(Potion.poison.id, 60, 0 , 1F).setUnlocalizedName("Vodka").setCreativeTab(TabFalloutFood);
	public static final Item StealthBoy = new BaseFood(2544, 5, 0.3F, false).setPotionEffect(Potion.invisibility.id, 60, 0, 1F).setUnlocalizedName("StealthBoy").setCreativeTab(TabFalloutFood);
	public static final Item Turbo = new BaseFood(2545, 5, 0.3F, false).setPotionEffect(Potion.digSpeed.id, 60, 0, 1F).setPotionEffect(Potion.moveSpeed.id, 60, 0, 1F).setUnlocalizedName("Turbo").setCreativeTab(TabFalloutFood);

	//============================================Armor==========================================================

	public static final Item T45Helm = (new ArmorBaseT45(5000, T45POWER, 1, 0)).setUnlocalizedName("T45Helm").setCreativeTab(TabFalloutArmor);
	public static final Item T45Chest = (new ArmorBaseT45(5001, T45POWER, 1, 1)).setUnlocalizedName("T45Chest").setCreativeTab(TabFalloutArmor);
	public static final Item T45Legs = (new ArmorBaseT45(5002, T45POWER, 1, 2)).setUnlocalizedName("T45Legs").setCreativeTab(TabFalloutArmor);
	public static final Item T45Boots = (new ArmorBaseT45(5003, T45POWER, 1, 3)).setUnlocalizedName("T45Boots").setCreativeTab(TabFalloutArmor);

	public static final Item T51Helm = (new ArmorBaseT51(5004, T51POWER, 2, 0)).setUnlocalizedName("T51Helm").setCreativeTab(TabFalloutArmor);
	public static final Item T51Chest = (new ArmorBaseT51(5005, T51POWER, 2, 1)).setUnlocalizedName("T51Chest").setCreativeTab(TabFalloutArmor);
	public static final Item T51Legs = (new ArmorBaseT51(5006, T51POWER, 2, 2)).setUnlocalizedName("T51Legs").setCreativeTab(TabFalloutArmor);
	public static final Item T51Boots = (new ArmorBaseT51(5007, T51POWER, 2, 3)).setUnlocalizedName("T51Boots").setCreativeTab(TabFalloutArmor);

	public static final Item G1Helm = (new ArmorBaseGecko1(5008, EnumArmorMaterial.CHAIN, 3, 0)).setUnlocalizedName("G1Helm").setCreativeTab(TabFalloutArmor);
	public static final Item G1Chest = (new ArmorBaseGecko1(5009, EnumArmorMaterial.CHAIN, 3, 1)).setUnlocalizedName("G1Chest").setCreativeTab(TabFalloutArmor);
	public static final Item G1Legs = (new ArmorBaseGecko1(5010, EnumArmorMaterial.CHAIN, 3, 2)).setUnlocalizedName("G1Legs").setCreativeTab(TabFalloutArmor);
	public static final Item G1Boots = (new ArmorBaseGecko1(5011, EnumArmorMaterial.CHAIN, 3, 3)).setUnlocalizedName("G1Boots").setCreativeTab(TabFalloutArmor);

	public static final Item HellHelm = (new ArmorBaseHellfire(5012, HELLFIRE, 4, 0)).setUnlocalizedName("HellHelm").setCreativeTab(TabFalloutArmor);
	public static final Item HellChest = (new ArmorBaseHellfire(5013, HELLFIRE, 4, 1)).setUnlocalizedName("HellChest").setCreativeTab(TabFalloutArmor);
	public static final Item HellLegs = (new ArmorBaseHellfire(5014, HELLFIRE, 4, 2)).setUnlocalizedName("HellLegs").setCreativeTab(TabFalloutArmor);
	public static final Item HellBoots = (new ArmorBaseHellfire(5015, HELLFIRE, 4, 3)).setUnlocalizedName("HellBoots").setCreativeTab(TabFalloutArmor);

	public static final Item WinterHelm = (new ArmorBaseWinter(5016, WINTER, 5, 0)).setUnlocalizedName("WinterHelm").setCreativeTab(TabFalloutArmor);
	public static final Item WinterChest = (new ArmorBaseWinter(5017, WINTER, 5, 1)).setUnlocalizedName("WinterChest").setCreativeTab(TabFalloutArmor);
	public static final Item WinterLegs = (new ArmorBaseWinter(5018, WINTER, 5, 2)).setUnlocalizedName("WinterLegs").setCreativeTab(TabFalloutArmor);
	public static final Item WinterBoots = (new ArmorBaseWinter(5019, WINTER, 5, 3)).setUnlocalizedName("WinterBoots").setCreativeTab(TabFalloutArmor);

	public static final Item EnclaveHelm = (new ArmorBaseEnclave(5020, ENCLAVE, 6, 0)).setUnlocalizedName("EnclaveHelm").setCreativeTab(TabFalloutArmor);
	public static final Item EnclaveChest = (new ArmorBaseEnclave(5021, ENCLAVE, 6, 1)).setUnlocalizedName("EnclaveChest").setCreativeTab(TabFalloutArmor);
	public static final Item EnclaveLegs = (new ArmorBaseEnclave(5022, ENCLAVE, 6, 2)).setUnlocalizedName("EnclaveLegs").setCreativeTab(TabFalloutArmor);
	public static final Item EnclaveBoots = (new ArmorBaseEnclave(5023, ENCLAVE, 6, 3)).setUnlocalizedName("EnclaveBoots").setCreativeTab(TabFalloutArmor);

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

	//============================================Pages===========================================================

	//public static AchievementPage FalloutPage = new AchievementPage("Fallout Achievements", ach1, ach2, ach3, ach4);
	//static final Achievement TimeAchieve = new Achievement(2001, "TimeAchieve", 1, -2, TimeMachine, AchievementLib.blazeRod).registerAchievement();

	//============================================Biomes==========================================================

	public static final BiomeGenBase Wasteland = (new BiomeWasteland(100)).setColor(16421912).setBiomeName("Wasteland").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);

	//Version 1.7
	public static final Item grip = new BaseItem(10000);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.registerSoundHandler();
		//MinecraftForge.EVENT_BUS.register(new FalloutSoundHandler());

		/**Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();
		config.save();

		int TungstenOre = config.getBlock("TungstenOre", 200).getInt();
		int TungstenIngot = config.getItem("TungstenIngot", 20000).getInt();**/
	}

	@Init
	public void init(FMLInitializationEvent event)
	{

		//============================================Guns==========================================================

		LanguageRegistry.addName(Incinerator, "Incinerator");
		GameRegistry.addRecipe(new ItemStack(Incinerator), new Object [] {"XXX", " *&", " &&", 'X', Block.netherrack, '*', Item.ingotIron, '&', TungstenIngot});

		LanguageRegistry.addName(LaserRCW, "Laser RCW");
		GameRegistry.addRecipe(new ItemStack(LaserRCW), new Object [] {"XXX", " *&", " &&", 'X', Block.anvil, '*', Item.ingotIron, '&', TungstenIngot});

		LanguageRegistry.addName(Compliance, "Compliance Regulator");
		GameRegistry.addRecipe(new ItemStack(Compliance), new Object [] {"*XX", " ^&", " &&", '&', SiliconBar, 'X', TungstenIngot, '^', Block.thinGlass, '*', TungstenFilter});

		LanguageRegistry.addName(LaserRifle, "AER7 Laser Rifle");
		GameRegistry.addRecipe(new ItemStack(LaserRifle), new Object [] {"*XX", "%^&", "&&", '&', SiliconBar, 'X', TechnetiumIngot, '^', Block.thinGlass, '*', TungstenFilter, '%', Item.redstone});

		LanguageRegistry.addName(g357Mag, ".357 Magnum");
		GameRegistry.addRecipe(new ItemStack(g357Mag), new Object [] {"*XX", " *&", " &&", '&', Item.ingotIron, '*', SiliconChunk, '*', TungstenRod, 'X', TungstenIngot});

		LanguageRegistry.addName(g44Mag, ".44 Magnum");
		GameRegistry.addRecipe(new ItemStack(g44Mag), new Object [] {"*XX", " *&", " &&", '&', Item.ingotIron, '*', SiliconChunk, '*', TungstenRod, 'X', TechnetiumIngot});

		LanguageRegistry.addName(Silenced22, "Silenced .22 Pistol");
		GameRegistry.addRecipe(new ItemStack(Silenced22), new Object [] {"*XX", " %&", " &&", 'X', Teflon, 'X', SiliconBar, '%', TungstenRod, '&', Item.ingotIron});

		LanguageRegistry.addName(Sniper308, "Sniper's Rifle");
		GameRegistry.addRecipe(new ItemStack(Sniper308), new Object [] {"XXX", " *&", " &&", 'X', TungstenPlate, '*', Item.ingotIron, '&', TechnetiumIngot});

		LanguageRegistry.addName(a22LR, ".22 Ammo");
		GameRegistry.addRecipe(new ItemStack(a22LR), new Object [] {"X", "*", 'X', SiliconChunk, '*', ScrapMetal});

		LanguageRegistry.addName(a357, ".357 Ammo");
		GameRegistry.addRecipe(new ItemStack(a357), new Object [] {"X", "*", 'X', ScrapMetal, '*', Item.ingotIron});

		LanguageRegistry.addName(a44, ".44 Ammo");
		GameRegistry.addRecipe(new ItemStack(a44), new Object [] {"X", "*", 'X', ScrapMetal, '*', Item.ingotGold});

		LanguageRegistry.addName(a308, ".308 Ammo");
		GameRegistry.addRecipe(new ItemStack(a308), new Object [] {"X", "X", "*", 'X', TungstenIngot, '*', ScrapMetal});

		LanguageRegistry.addName(HomemadeFuel, "Flamer Fuel");
		GameRegistry.addShapelessRecipe(new ItemStack(HomemadeFuel), new Object [] {Abraxo, Item.sugar, Item.wheat});

		//============================================Melee Weapons==========================================================

		LanguageRegistry.addName(Cleaver, "Cleaver");
		GameRegistry.addRecipe(new ItemStack(Cleaver), new Object [] {"XX", "XX", " *", 'X', net.minecraft.item.Item.ingotIron, '*', net.minecraft.item.Item.stick});
		LanguageRegistry.addName(ComKnife, "Combat Knife");
		GameRegistry.addRecipe(new ItemStack(ComKnife), new Object [] {"X", "*", 'X', TungstenIngot, '*', net.minecraft.item.Item.stick});
		LanguageRegistry.addName(BotE, "Blade of the East");
		GameRegistry.addRecipe(new ItemStack(BotE), new Object [] {" X ", "X*X", "X&X", 'X', TungstenPlate, '*', net.minecraft.item.ItemSword.swordDiamond, '&', TungstenRod});
		LanguageRegistry.addName(CosKnife, "Cosmic Knife");
		GameRegistry.addRecipe(new ItemStack(CosKnife, 1), new Object [] {"X", "X", "&", 'X', SatIngot, '&', net.minecraft.item.Item.ingotIron});
		LanguageRegistry.addName(CosClean, "Cosmic Knife (Clean)");
		GameRegistry.addShapelessRecipe(new ItemStack(CosClean, 1), new Object[] {CosKnife, Abraxo});
		LanguageRegistry.addName(CosFire, "Cosmic Knife (Super Heated)");
		GameRegistry.addShapelessRecipe(new ItemStack(CosFire, 1), new Object [] {CosClean, Item.bucketLava});
		LanguageRegistry.addName(PintSizedKnife, "Pint Sized Slasher's Knife");
	
		LanguageRegistry.addName(BumperSword, "Bumper Sword");
		
		LanguageRegistry.addName(FireAxe, "Fire Axe");
		
		LanguageRegistry.addName(Knife, "Knife");
		
		LanguageRegistry.addName(Machete, "Machete");
		
		LanguageRegistry.addName(Shishkebab, "Shishkebab");

		LanguageRegistry.addName(StraightRazor, "Straight Razor");

		LanguageRegistry.addName(Switchblade, "Switchblade");
		
		//========================================Unarmed Weapons===============================================

		LanguageRegistry.addName(BallisticFist, "Ballistic Fist");
		GameRegistry.addRecipe(new ItemStack(BallisticFist), new Object [] {"*X*", "X%X", "###", 'X', Block.pistonBase, '*', Block.tnt, '#', TungstenPlate, '%', Item.redstoneRepeater});
		
		LanguageRegistry.addName(BladedGauntlet, "Bladed Gauntlet");
		GameRegistry.addRecipe(new ItemStack(BladedGauntlet), new Object [] {" * ", "*X*", '*', Knife, 'X', BoxingGloves});
		
		LanguageRegistry.addName(BoxingGloves, "Boxing Gloves");
		GameRegistry.addRecipe(new ItemStack(BoxingGloves), new Object [] {" * ", "*X*", " * ", 'X', BrassKnuckles, '*', Item.leather});
		
		//LanguageRegistry.addName(BoxingTape, "Boxing Tape");
		
		LanguageRegistry.addName(BrassKnuckles, "Brass Knuckles");
		GameRegistry.addRecipe(new ItemStack(BrassKnuckles), new Object [] {"XXX", "* *", 'X', Item.ingotGold, '*', TungstenIngot});
		
		LanguageRegistry.addName(DisplacerGlove, "Displacer Glove");
		
		LanguageRegistry.addName(GoldenGloves, "Golden Gloves");
		GameRegistry.addRecipe(new ItemStack(GoldenGloves), new Object [] {"XXX", "X*X", "XXX", 'X', Item.goldNugget, '*', BoxingGloves});
		
		LanguageRegistry.addName(SatFist, "Saturnite Power Fist");
<<<<<<< HEAD
		GameRegistry.addRecipe(new ItemStack(SatFist), new Object [] {"XXX"});
=======
		//TODO GameRegistry.addRecipe(new ItemStack(SatFist), new Object [] {"XXX"});
>>>>>>> Gun mechanics overhaul, fixed delay time/clips/reloading
		
		LanguageRegistry.addName(SatHeatFist, "Saturnite Fist (Super Heated)");
		GameRegistry.addRecipe(new ItemStack(SatHeatFist), new Object [] {"^^^", "X*X", "& &", 'X', Block.furnaceIdle, '&', SatIngot, '*', Item.redstoneRepeater, '^', SatAlloy});
		
		LanguageRegistry.addName(PowerFist, "Power Fist");
		GameRegistry.addRecipe(new ItemStack(PowerFist), new Object [] {"X*X", "&*&", "&*&", 'X', Block.pistonBase, '&', TungstenIngot, '*', Item.redstone});
		
		LanguageRegistry.addName(SciGlove, "Scientist's Glove");
		GameRegistry.addRecipe(new ItemStack(SciGlove), new Object [] {"X*X", "X X", "X X", 'X', Polyethylene, '*', TungstenIngot});
		
		LanguageRegistry.addName(ZapGlove, "Zap Glove");
		GameRegistry.addRecipe(new ItemStack(ZapGlove), new Object [] {"XXX", "*&*", 'X', Block.blockRedstone, '*', TungstenPlate, '&', PowerFist});
		
		//==========================================Thrown Weapons===================================================
		
		LanguageRegistry.addName(BottleCapMine, "Bottle Cap Mine");
		GameRegistry.addRecipe(new ItemStack(BottleCapMine), new Object [] {" X ", "***", "&^&", 'X', Lunchbox, '*', BottleCap, '&', Cherrybomb, '^', SensorModule});
		
		LanguageRegistry.addName(FragGrenade, "Frag Grenade");
		GameRegistry.addRecipe(new ItemStack(FragGrenade), new Object [] {" * ", "X&X", "XXX", '*', SiliconChunk, 'X', TungstenIngot, '&', Block.tnt});

		//============================================Items==========================================================

		LanguageRegistry.addName(TungstenRod, "Tungsten Rod");

		LanguageRegistry.addName(TungstenIngot, "Tungsten Ingot");
		GameRegistry.addRecipe(new ItemStack(TungstenIngot), new Object [] {"XXX", "XXX", 'X', TungstenRod});

		LanguageRegistry.addName(TechnetiumChunk, "Technetium Chunk");

		LanguageRegistry.addName(TechnetiumIngot, "Technetium Ingot");
		GameRegistry.addSmelting(TechnetiumChunk.itemID, new ItemStack(TechnetiumIngot), 1.5F);
		GameRegistry.addRecipe(new ItemStack(TechnetiumIngot, 1), new Object [] {"###", "###", '#', TechnetiumChunk});

		LanguageRegistry.addName(SiliconChunk, "Silicon Chunk");

		LanguageRegistry.addName(SiliconBar, "Silicon Bar");
		GameRegistry.addRecipe(new ItemStack(SiliconBar, 1), new Object [] {"###", "###", Character.valueOf('#'), SiliconChunk});

		LanguageRegistry.addName(TungstenFilter, "Tungsten Filter");
		GameRegistry.addRecipe(new ItemStack(TungstenFilter, 1), new Object [] {"###", "###", "###", '#', TungstenRod});

		LanguageRegistry.addName(AsbestosChunk, "Asbestos Chunk");

		LanguageRegistry.addName(AsbestosBar, "Asbestos Bar");
		GameRegistry.addSmelting(AsbestosChunk.itemID, new ItemStack(AsbestosBar), 1.5F);
		GameRegistry.addRecipe(new ItemStack(AsbestosBar, 1), new Object [] {"XXX", "XXX", Character.valueOf('X'), AsbestosChunk});

		LanguageRegistry.addName(UraniumIngot, "Uranium Ingot");

		LanguageRegistry.addName(TungstenPlate, "Tungsten Plate");
		GameRegistry.addRecipe(new ItemStack(TungstenPlate), new Object [] {"X*X", "*X*", "X*X", 'X', TungstenIngot, '*', TungstenRod});

		GameRegistry.addRecipe(new ItemStack(TungstenPlate, 1), new Object [] {"XX", "XX", Character.valueOf('X'), TungstenIngot});

		LanguageRegistry.addName(TechnetiumPlate, "Technetium Plate");
		GameRegistry.addRecipe(new ItemStack(TechnetiumPlate, 1), new Object [] {"XX", "XX", Character.valueOf('X'), TechnetiumIngot});

		LanguageRegistry.addName(RAP, "Reinforced Alloy Plate");
		GameRegistry.addRecipe(new ItemStack(RAP, 2), new Object [] {"X*", "*X", Character.valueOf('X'), TungstenPlate, Character.valueOf('*'), TechnetiumPlate});

		LanguageRegistry.addName(MFCell, "MicroFusion Cell");
		GameRegistry.addRecipe(new ItemStack(MFCell, 2), new Object [] {" * ", "*&*", " * ", Character.valueOf('&'), UraniumIngot, Character.valueOf('*'), TungstenPlate});

		LanguageRegistry.addName(MFPack, "MicroFusion Pack");
		GameRegistry.addRecipe(new ItemStack(MFPack, 1),new Object [] {" X ", "&&&", " X ", 'X', RAP, '&', MFCell});

		LanguageRegistry.addName(Carbon, "Carbon");

		LanguageRegistry.addName(Teflon, "Teflon");
		GameRegistry.addRecipe(new ItemStack(Teflon, 2), new Object [] {"**", "##", "**", Character.valueOf('*'), Item.silk, Character.valueOf('#'), Carbon});

		LanguageRegistry.addName(Polyethylene, "Polyethylene");
		GameRegistry.addRecipe(new ItemStack(Polyethylene), new Object [] {"X*X", "*X*", 'X', Carbon, '*', Teflon});

		LanguageRegistry.addName(BottleCap, "Bottle Cap");

		LanguageRegistry.addName(Fan, "Fan");
		GameRegistry.addRecipe(new ItemStack(Fan), new Object [] {" * ", "*X*", " * ", '*', TungstenRod, 'X', Item.ingotIron});

		LanguageRegistry.addName(Gear, "Gear");
		GameRegistry.addRecipe(new ItemStack(Gear, 2), new Object [] {"***", "*#*", "***", '*', TungstenRod, '#', TungstenIngot});

		LanguageRegistry.addName(Gyro, "Gyroscope");
		GameRegistry.addRecipe(new ItemStack(Gyro), new Object [] {" X ", "X*X", " & ", 'X', Item.ingotGold, '*', SiliconBar, '&', Item.stick});

		LanguageRegistry.addName(MASM, "Motion-Assist Servo Motor");
		GameRegistry.addRecipe(new ItemStack(MASM), new Object [] {" XX", "*&X", " XX", 'X', SiliconBar, '*', Item.stick, '&', Gear});

		LanguageRegistry.addName(TXMF, "TX-28 MicroFusion Pack");
		GameRegistry.addRecipe(new ItemStack(TXMF, 1), new Object [] {" X ", "&&&", " X ", 'X', RAP, '&', MFPack});

		LanguageRegistry.addName(Card, "Caravan Card");
		ModLoader.addRecipe(new ItemStack(Card, 1), new Object [] {"XXX", "X*X", "XXX", Character.valueOf('X'), Item.paper, Character.valueOf('*'), Item.coal});

		LanguageRegistry.addName(Deck, "Caravan Deck");
		GameRegistry.addRecipe(new ItemStack(Deck, 1), new Object [] {"XXX", "XXX", "XXX", 'X', Card});

		LanguageRegistry.addName(Cardboard, "Cardboard");
		GameRegistry.addRecipe(new ItemStack(Cardboard, 4), new Object [] {"XXX", "X X", "XXX", 'X', Item.paper});

		LanguageRegistry.addName(TinCan, "Tin Can");

		LanguageRegistry.addName(SatRod, "Saturnite Rod");

		LanguageRegistry.addName(SatIngot, "Saturnite Ingot");
		GameRegistry.addRecipe(new ItemStack(SatIngot), new Object [] {"XXX", "XXX", 'X', SatRod});

		LanguageRegistry.addName(SatAlloy, "Saturnite Alloy");
		GameRegistry.addRecipe(new ItemStack(SatAlloy), new Object [] {"XX", "XX", 'X', SatIngot});

		LanguageRegistry.addName(SatAlloyPlate, "Saturnite Alloy Plate");
		GameRegistry.addRecipe(new ItemStack(SatAlloyPlate), new Object [] {"XX", "XX", 'X', SatAlloy});

		LanguageRegistry.addName(EmptySyringe, "Empty Syringe");
		GameRegistry.addRecipe(new ItemStack(EmptySyringe), new Object [] {"  &", " * ", "X  ", '*', SiliconChunk, 'X', Item.ingotIron, '&', TungstenRod});

		LanguageRegistry.addName(BloodSyringe, "Blood Syringe");

		LanguageRegistry.addName(PTorso, "Base Power Torso");
		GameRegistry.addRecipe(new ItemStack(PTorso, 1), new Object [] {"X X", "*&*", " $ ", 'X', RAP, '&', Fan, '*', RAP, '$', TXMF});

		LanguageRegistry.addName(PShoulders, "Base Power Shoulders");
		GameRegistry.addRecipe(new ItemStack(PShoulders, 1), new Object [] {"X X", "& &", 'X', RAP, '&', TungstenPlate});

		LanguageRegistry.addName(PChest, "Base Power Chest");
		GameRegistry.addRecipe(new ItemStack(PChest, 1),new Object [] {"X", "*", 'X', PShoulders, '*', PTorso});

		LanguageRegistry.addName(T45Upgrade, "Type 45-d Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(T45Upgrade, 1), new Object [] {" X ", "&*&", " X ", 'X', TungstenPlate, '&', TechnetiumPlate, '*', RAP});

		LanguageRegistry.addName(EnclaveUpgrade, "Enclave Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(EnclaveUpgrade, 1), new Object [] {" X ", "&*&", " X ", 'X', TungstenPlate, '&', TechnetiumPlate, '*', T45Upgrade});

		LanguageRegistry.addName(T51Upgrade, "Type 51-b Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(T51Upgrade, 1), new Object [] {" X ", "&*&", " X ", 'X', TungstenPlate, '&', TechnetiumPlate, '*', EnclaveUpgrade});

		LanguageRegistry.addName(HellfireUpgrade, "Enclave Hellfire Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(HellfireUpgrade, 1), new Object [] {" X ", "&*&", " X ", 'X', TungstenPlate, '&', TechnetiumPlate, '*', T51Upgrade});

		LanguageRegistry.addName(WinterizedUpgrade, "Winterized Type 51-b Power Armor Upgrade Plate");
		GameRegistry.addRecipe(new ItemStack(WinterizedUpgrade, 1), new Object [] {" X ", "&*&", " X ", 'X', TungstenPlate, '&', TechnetiumPlate, '*', HellfireUpgrade});

		LanguageRegistry.addName(NukaBottle, "Nuka Cola Bottle");
		GameRegistry.addRecipe(new ItemStack(NukaBottle), new Object [] {"X", "%*%", "&", 'X', BottleCap, '*', Item.sugar, '%', BarrelCactus, '&', Item.glassBottle});

		//TODO LanguageRegistry.addName(PipBoy, "Pip-Boy 3000");
		//TODO GameRegistry.addRecipe(new ItemStack(PipBoy), new Object [] {"X*X", "X&X", "X#X", 'X', TungstenIngot, '*', Block.glass, '&', Item.redstoneRepeater, '#', Item.redstone});

		LanguageRegistry.addName(Abraxo, "Abraxo Cleaner");
		GameRegistry.addRecipe(new ItemStack(Abraxo), new Object [] {" X ", "***", " X ", 'X', Cardboard, '*', Item.sugar});

		LanguageRegistry.addName(ScrapMetal, "Scrap Metal");
		GameRegistry.addShapelessRecipe(new ItemStack(ScrapMetal, 1), new Object[] {TungstenIngot, Item.ingotIron});

		LanguageRegistry.addName(Lunchbox, "Lunchbox");
		GameRegistry.addRecipe(new ItemStack(Lunchbox), new Object [] {" X ", "X X", "XXX", 'X', Item.ingotIron});

		LanguageRegistry.addName(SensorModule, "Sensor Module");
		GameRegistry.addRecipe(new ItemStack(SensorModule), new Object [] {" XX", "*&X", " XX", 'X', TungstenIngot, '*', Item.redstoneRepeater, '&', Item.redstone});

		LanguageRegistry.addName(Cherrybomb, "Cherry Bomb");
		GameRegistry.addRecipe(new ItemStack(Cherrybomb), new Object [] {"X", 'X', Block.tnt});

		LanguageRegistry.addName(NightstalkerBlood, "Nightstalker Blood");

		LanguageRegistry.addName(JetInhaler, "Jet Inhaler");
		GameRegistry.addRecipe(new ItemStack(JetInhaler), new Object [] {"X  ", "X  ", "X& ", 'X', SiliconBar, '&', Block.dispenser});

		LanguageRegistry.addName(Wonderglue, "Wonderglue");
		GameRegistry.addRecipe(new ItemStack(Wonderglue), new Object [] {"X*X", "X*X", " & ", 'X', SiliconBar, '*', Item.slimeBall, '&', EmptySyringe});

		LanguageRegistry.addName(Turpentine, "Turpentine");
		GameRegistry.addShapelessRecipe(new ItemStack(Turpentine), new Object [] {Item.coal, Item.coal, Item.coal, Item.coal, Block.wood});

		LanguageRegistry.addName(GeckoHide, "Gecko Hide");
		GameRegistry.addShapelessRecipe(new ItemStack(GeckoHide), new Object [] {Block.cactus, Item.leather});

		LanguageRegistry.addName(Minecraft9, "9Minecraft Can Die. Nobody Enjoys Getting Their Content Stolen.");
		GameRegistry.addShapelessRecipe(new ItemStack(Minecraft9), new Object [] {Block.cactus});
		
		LanguageRegistry.addName(LeatherBelt, "Leather Belt");
		GameRegistry.addRecipe(new ItemStack(LeatherBelt), new Object [] {"X*X", 'X', Item.leather, '*', Item.ingotIron});

		LanguageRegistry.addName(EPack, "Electron Charge Pack");

		LanguageRegistry.addName(ECell, "Energy Cell");

		//============================================Food and Chems==========================================================

		LanguageRegistry.addName(Psycho, "Psycho");
		GameRegistry.addRecipe(new ItemStack(Psycho, 3), new Object [] {"X*X", "%$%", "X*X", 'X', Item.slimeBall, '$', EmptySyringe, '%', Item.redstone, '*', Item.lightStoneDust});

		LanguageRegistry.addName(MedEx, "Med-X");
		GameRegistry.addRecipe(new ItemStack(MedEx, 3), new Object [] {"& &", " * ", "X X", 'X', Stimpak, '*', EmptySyringe, '&', bBananaYucca});

		LanguageRegistry.addName(Slasher, "Slasher");
		GameRegistry.addRecipe(new ItemStack(Slasher), new Object [] {"X*", 'X', Psycho, '*', MedEx});

		LanguageRegistry.addName(Stimpak, "Stimpak");
		GameRegistry.addRecipe(new ItemStack(Stimpak), new Object [] {" X ", " & ", " * ", 'X', bBrocFlower, '&', bXanderRoot, '*', EmptySyringe});

		LanguageRegistry.addName(SuperStimpak, "Super Stimpak");
		GameRegistry.addRecipe(new ItemStack(SuperStimpak), new Object [] {" * ", "XXX", " & ", '*', Stimpak, 'X', Item.leather, '&', NukaCola});

		LanguageRegistry.addName(BCMAC, "Blam Co. Mac and Cheese");
		GameRegistry.addRecipe(new ItemStack(BCMAC, 3), new Object [] {"#X#", "***", "#X#", 'X', Item.bucketMilk, '*', Item.wheat, '#', Cardboard});

		LanguageRegistry.addName(Cram, "Cram");
		GameRegistry.addRecipe(new ItemStack(Cram, 3), new Object [] {" # ", " * ", " X ", 'X', TinCan, '#', Item.beefCooked, '*', Item.porkCooked});

		LanguageRegistry.addName(Instamash, "Instamash");
		GameRegistry.addRecipe(new ItemStack(Instamash, 3), new Object [] {"X*X", "***", "X*X", 'X', Cardboard, '*', Item.potato});

		LanguageRegistry.addName(PorkBeans, "Pork 'n' Beans");
		GameRegistry.addRecipe(new ItemStack(PorkBeans, 3), new Object [] {" # ", " * ", " X ", 'X', TinCan, '#', Item.porkCooked, '*', new ItemStack(Item.dyePowder, 1, 3)});

		LanguageRegistry.addName(Salisbury, "Salisbury Steak");
		GameRegistry.addRecipe(new ItemStack(Salisbury, 3), new Object [] {"X*X", "#*#", "X*X", 'X', Cardboard, '#', Item.potato, '*', Item.beefCooked});

		LanguageRegistry.addName(YumYum, "Yum Yum Deviled Eggs");
		GameRegistry.addRecipe(new ItemStack(YumYum, 3), new Object [] {"X*X", "*#*", "X*X", 'X', Cardboard, '*', Item.egg, '#', Item.bucketMilk});

		LanguageRegistry.addName(Hydra, "Hydra");
		GameRegistry.addRecipe(new ItemStack(Hydra), new Object [] {"X*X", " & ", 'X', NightstalkerBlood, '*', bCaveFungus, '&', Item.spiderEye});

		LanguageRegistry.addName(NukaCola, "Nuka Cola");
		GameRegistry.addRecipe(new ItemStack(NukaCola), new Object [] {"X*%", " & ", 'X', Item.sugar, '*', Item.bucketWater, '&', NukaBottle, '%', UraniumIngot});

		LanguageRegistry.addName(HealingPowder, "Healing Powder");
		GameRegistry.addShapelessRecipe(new ItemStack(HealingPowder, 1), new Object[] {bXanderRoot, bBrocFlower});

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
		GameRegistry.addShapelessRecipe(new ItemStack(CaravanLunch), new Object [] {Cram, Instamash, PorkBeans, Cardboard});

		LanguageRegistry.addName(DandyApples, "Dandy Boy Apples");
		GameRegistry.addRecipe(new ItemStack(DandyApples, 3), new Object [] {"X*X", "*#*", "X*X", 'X', Cardboard, '*', Item.appleRed, '#', Item.sugar});

		LanguageRegistry.addName(NightstalkerTail, "Nightstalker Tail");

		LanguageRegistry.addName(TrailMix, "Trail Mix");
		GameRegistry.addShapelessRecipe(new ItemStack(TrailMix), new Object [] {SugarBombs, Item.appleRed, Item.blazePowder, Item.seeds});

		LanguageRegistry.addName(SugarBombs, "Sugar Bombs");
		GameRegistry.addRecipe(new ItemStack(SugarBombs, 3), new Object [] {"X*X", "*#*", "X*X", 'X', Cardboard, '*', Item.sugar, '#', Item.wheat});

		LanguageRegistry.addName(PotatoChips, "Potato Crisps");
		GameRegistry.addRecipe(new ItemStack(PotatoChips, 3), new Object [] {"X*X", "*#*", "X*X", 'X', Cardboard, '*', Item.potato, '#', Item.poisonousPotato});

		LanguageRegistry.addName(SunsetSass, "Sunset Sasparilla");
		GameRegistry.addRecipe(new ItemStack(SunsetSass), new Object [] {" * ", "X&X", " ^ ", '*', BottleCap, 'X', XanderRoot, '&', Item.glassBottle, '^', Item.appleRed});

		LanguageRegistry.addName(bBananaYucca, "Banna Yucca Fruit");

		LanguageRegistry.addName(bCaveFungus, "Cave Fungus");

		LanguageRegistry.addName(bBuffaloGourd, "Buffalo Gourd Seed");

		LanguageRegistry.addName(bJalapeno, "Jalapeno");

		LanguageRegistry.addName(Jet, "Jet");
		GameRegistry.addRecipe(new ItemStack(Jet), new Object [] {"*&*", " X ", 'X', JetInhaler, '*', Abraxo, '&', Item.sugar});

		LanguageRegistry.addName(Rocket, "Rocket");
		GameRegistry.addShapelessRecipe(new ItemStack(Rocket), new Object [] {Jet, Abraxo, NukaCola});

		LanguageRegistry.addName(NukaCold, "Ice Cold Nuka Cola");
		GameRegistry.addShapelessRecipe(new ItemStack(NukaCold), new Object [] {NukaCola, Block.ice});

		LanguageRegistry.addName(NukaQuartz, "Nuka Cola Quartz");
		GameRegistry.addRecipe(new ItemStack(NukaQuartz), new Object [] {"XXX", " * ", 'X', NukaCola, '*', new ItemStack(Item.dyePowder, 1, 12)});

		LanguageRegistry.addName(NukaVictory, "Nuka Cola Victory");
		GameRegistry.addRecipe(new ItemStack(NukaVictory), new Object [] {"XXX", " * ", 'X', NukaCola, '*', new ItemStack(Item.dyePowder, 1, 1)});

		LanguageRegistry.addName(WeaponBinding, "Weapon Binding Ritual");
		GameRegistry.addRecipe(new ItemStack(WeaponBinding), new Object [] {"*&^", " # ", '*', Cleaver, '^', LeatherBelt, '&', HealingPowder, '#', Wonderglue});

		LanguageRegistry.addName(Vodka, "Vodka");
		GameRegistry.addRecipe(new ItemStack(Vodka), new Object [] {"&^%", "$X#", '#', Block.mushroomBrown, '$', Block.mushroomRed, 'X', Item.glassBottle, '&', Item.sugar, '^', Item.bucketWater, '&', Item.wheat});

		LanguageRegistry.addName(StealthBoy, "Stealth Boy");

		LanguageRegistry.addName(Turbo, "Turbo");
		GameRegistry.addRecipe(new ItemStack(Turbo), new Object [] {"*&^", " X ", 'X', Jet, '*', BrocFlower, '&', Item.spiderEye, '^', Turpentine});

		//============================================Armor==========================================================

		LanguageRegistry.addName(T45Helm, "T-45d Power Helmet");
		GameRegistry.addRecipe(new ItemStack(T45Helm), new Object [] {"$*X", "X&X", " % ", 'X', TungstenPlate, '*', TechnetiumPlate, '&', BPGlass, '%', T45Upgrade, '$', Item.lightStoneDust});

		LanguageRegistry.addName(T45Chest, "T-45d Power Chestplate");
		GameRegistry.addRecipe(new ItemStack(T45Chest, 1), new Object [] {" * ", "*X*", " * ", '*', T45Upgrade, 'X', PChest});

		LanguageRegistry.addName(T45Legs, "T-45d Power Leggings");
		GameRegistry.addRecipe(new ItemStack(T45Legs), new Object [] {"X*X", "% %", "X X", 'X', TungstenPlate, '*', T45Upgrade, '%', MASM});

		LanguageRegistry.addName(T45Boots, "T-45d Power Boots");
		GameRegistry.addRecipe(new ItemStack(T45Boots), new Object [] {"X*X", "X X", 'X', TungstenPlate, '*', T45Upgrade});

		LanguageRegistry.addName(T51Helm, "T-51b Power Helmet");
		GameRegistry.addRecipe(new ItemStack(T51Helm, 1), new Object [] {" X ", "X*X", " X ", 'X', T51Upgrade, '*', T45Helm});

		LanguageRegistry.addName(T51Chest, "T-51b Power Chestplate");
		GameRegistry.addRecipe(new ItemStack(T51Chest, 1), new Object [] {" X ", "X*X", " X ", 'X', T51Upgrade, '*', T45Chest});

		LanguageRegistry.addName(T51Legs, "T-51b Power Leggings");
		GameRegistry.addRecipe(new ItemStack(T51Legs, 1), new Object [] {" X ", "X*X", " X ", 'X', T51Upgrade, '*', T45Legs});

		LanguageRegistry.addName(T51Boots, "T-51b Power Boots");
		GameRegistry.addRecipe(new ItemStack(T51Boots, 1), new Object [] {" X ", "X*X", " X ", 'X', T51Upgrade, '*', T45Boots});

		LanguageRegistry.addName(G1Helm, "Gecko Backed Leather Cap");
		GameRegistry.addRecipe(new ItemStack(G1Helm, 1), new Object [] {"XXX", "X*X", 'X', GeckoHide, '*', Item.helmetLeather});

		LanguageRegistry.addName(G1Chest, "Gecko Backed Leather Tunic");
		GameRegistry.addRecipe(new ItemStack(G1Chest, 1), new Object [] {"X X", "X*X", "XXX", 'X', GeckoHide, '*', Item.plateLeather});

		LanguageRegistry.addName(G1Legs, "Gecko Backed Leather Leggings");
		GameRegistry.addRecipe(new ItemStack(G1Legs, 1), new Object [] {"XXX", "X*X", "X X", 'X', GeckoHide, '*', Item.legsLeather});

		LanguageRegistry.addName(G1Boots, "Gecko Backed Leather Boots");
		GameRegistry.addRecipe(new ItemStack(G1Boots, 1), new Object [] {"X*X", "X X", 'X', GeckoHide, '*', Item.bootsLeather});

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
		
		//============================================Entities==========================================================

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

		/**EntityRegistry.registerGlobalEntityID(EntityGiantAnt.class, "GiantAnt", ModLoader.getUniqueEntityId(), 230, 78);
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

		EntityRegistry.registerGlobalEntityID(EntityGecko.class, "Gecko", ModLoader.getUniqueEntityId(), 230, 78);
		LanguageRegistry.instance().addStringLocalization("entity.Gecko.name", "en_US", "Young Gecko Hunter");**/

		//============================================Blocks==========================================================

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
		GameRegistry.addRecipe(new ItemStack(BPGlass), new Object [] {"***", "*X*", "***", 'X', net.minecraft.block.Block.glass, '*', TungstenPlate});

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

		//============================================Biomes=========================================================

		GameRegistry.addBiome(Wasteland);

		//============================================Generation=====================================================

		GameRegistry.registerWorldGenerator(new WorldGenTungstenOre());
		GameRegistry.registerWorldGenerator(new WorldGenTechOre());
		GameRegistry.registerWorldGenerator(new WorldGenSatOre());
		GameRegistry.registerWorldGenerator(new WorldGenUraniumOre());
		GameRegistry.registerWorldGenerator(new WorldGenBrocFlower());
		GameRegistry.registerWorldGenerator(new WorldGenSiliconDeposit());
		GameRegistry.registerWorldGenerator(new WorldGenAsbestosDeposit());
		GameRegistry.registerWorldGenerator(new WorldGenCarbonDeposit());

		//============================================Creative Tabs===================================================

		LanguageRegistry.instance().addStringLocalization("itemGroup.FalloutTab", "en_US", "The Fallout Tab");
		//AchievementPage.registerAchievementPage(FalloutPage);

		proxy.registerRenderers();
	}

	public static void oreRegistration()
	{
		OreDictionary.registerOre("TungstenRod", new ItemStack(TungstenRod));
		OreDictionary.registerOre("SiliconChunk", new ItemStack(SiliconChunk));
		OreDictionary.registerOre("UraniumIngot", new ItemStack(UraniumIngot));

	}

	public static void addOreRecipes()
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(TungstenIngot, true, new Object [] {"XXX", "XXX", 'X', TungstenRod}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(SiliconBar, true, new Object [] {"XXX", "XXX", 'X', SiliconChunk}));
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event)
	{

	}
}
