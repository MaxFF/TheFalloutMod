package blfngl.fallout.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import blfngl.fallout.FalloutMain;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemHandler extends FalloutMain
{
	public static void init()
	{
		LanguageRegistry.addName(a22LR, ".22 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a22LR, 12), new Object [] {powderPistol, powderPistol, powderPistol, primerPistol});
		LanguageRegistry.addName(a357, ".357 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a357, 3), new Object [] {powderPistol, powderPistol, powderPistol, powderPistol, powderPistol, powderPistol, powderPistol, primerPistol});
		LanguageRegistry.addName(a44, ".44 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a44, 3), new Object [] {powderPistol, powderPistol, powderPistol, powderPistol, powderPistol, powderPistol, powderPistol, powderPistol, primerPistol});
		LanguageRegistry.addName(a308, ".308 Ammo");
		GameRegistry.addShapelessRecipe(new ItemStack(a308, 2), new Object [] {powderRifle, primerRifle, powderRifle, powderRifle, powderRifle, powderRifle, lead, lead});
		LanguageRegistry.addName(homemadeFuel, "Flamer Fuel");
		GameRegistry.addShapelessRecipe(new ItemStack(homemadeFuel), new Object [] {abraxo, Item.sugar, Item.wheat});
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
		LanguageRegistry.addName(cellMF, "MicroFusion Cell");
		GameRegistry.addRecipe(new ItemStack(cellMF, 6), new Object [] {" * ", "*&*", " * ", '&', ingotUranium, '*', tungstenPlate});
		LanguageRegistry.addName(MFPack, "MicroFusion Pack");
		GameRegistry.addRecipe(new ItemStack(MFPack),new Object [] {" X ", "&&&", " X ", 'X', RAP, '&', cellMF});
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
		LanguageRegistry.addName(cellElectron, "Electron Charge Pack");
		GameRegistry.addRecipe(new ItemStack(cellElectron), new Object [] {"XX", "**", "XX", 'X', tungstenPlate, '*', ingotUranium});
		LanguageRegistry.addName(cellEnergy, "Energy Cell");
		GameRegistry.addRecipe(new ItemStack(cellEnergy), new Object [] {"X*", "*X", '*', ingotUranium, 'X', ingotTechnetium});

		//TODO Version 1.7
		LanguageRegistry.addName(grip, "Gun Grip");
		GameRegistry.addRecipe(new ItemStack(grip), new Object [] {"X*X", "X*X", " X*", 'X', Item.leather, '*', ingotTungsten});
		LanguageRegistry.addName(stockWood, "Stock");
		GameRegistry.addRecipe(new ItemStack(stockWood), new Object [] {"XXX", " XX", 'X', Block.planks});
		LanguageRegistry.addName(barrel, "Gun Barrel");
		GameRegistry.addRecipe(new ItemStack(barrel), new Object [] {"XXX", "   ", "XXX", 'X', Item.ingotIron});
		LanguageRegistry.addName(magnifier, "Crystal Array");
		GameRegistry.addRecipe(new ItemStack(magnifier), new Object [] {"X X", " * ", "X X", 'X', ingotTechnetium, '*', Item.diamond});
		LanguageRegistry.addName(hammer, "Hammer");
		GameRegistry.addRecipe(new ItemStack(hammer), new Object [] {"  X", "XX ", " X ", 'X', Item.ingotIron});
		LanguageRegistry.addName(gasTank, "Motorcycle Gas Tank");
		GameRegistry.addRecipe(new ItemStack(gasTank), new Object [] {" X ", "X*X", "XXX", 'X', ingotTungsten, '*', homemadeFuel});

		LanguageRegistry.addName(magRail, "Magnifier Rail");
		GameRegistry.addRecipe(new ItemStack(magRail), new Object [] {"XXX", 'X', magnifier});
		LanguageRegistry.addName(powderRifle, "Powder - Rifle");
		GameRegistry.addShapelessRecipe(new ItemStack(powderRifle, 5), new Object [] {Item.gunpowder, Item.gunpowder});
		LanguageRegistry.addName(primerRifle, "Primer - Rifle");
		GameRegistry.addShapelessRecipe(new ItemStack(primerRifle, 3), new Object [] {powderRifle, powderRifle, ingotTungsten});
		LanguageRegistry.addName(lead, "Lead");
		GameRegistry.addShapelessRecipe(new ItemStack(lead, 2), new Object [] {scrapMetal, ingotTungsten});
		LanguageRegistry.addName(powderPistol, "Powder - Pistol");
		GameRegistry.addShapelessRecipe(new ItemStack(primerRifle, 3), new Object [] {powderRifle, powderRifle, ingotTungsten});
		LanguageRegistry.addName(primerPistol, "Primer - Pistol");
		GameRegistry.addShapelessRecipe(new ItemStack(primerPistol, 3), new Object [] {powderPistol, powderPistol, ingotTungsten});

		
	}
}
