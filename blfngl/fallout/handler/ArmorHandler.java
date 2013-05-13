package blfngl.fallout.handler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import blfngl.fallout.common.FalloutMain;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ArmorHandler
{
	public static void init ()
	{
		LanguageRegistry.addName(FalloutMain.T45Helm, "T-45d Power Helmet");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T45Helm), new Object [] {"$*X", "X&X", " % ", 'X', FalloutMain.tungstenPlate, '*', FalloutMain.technetiumPlate, '&', FalloutMain.BPGlass, '%', FalloutMain.upgradeT45, '$', Item.lightStoneDust});
		LanguageRegistry.addName(FalloutMain.T45Chest, "T-45d Power Chestplate");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T45Chest, 1), new Object [] {" * ", "*X*", " * ", '*', FalloutMain.upgradeT45, 'X', FalloutMain.powerChest});
		LanguageRegistry.addName(FalloutMain.T45Legs, "T-45d Power Leggings");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T45Legs), new Object [] {"X*X", "% %", "X X", 'X', FalloutMain.tungstenPlate, '*', FalloutMain.upgradeT45, '%', FalloutMain.MASM});
		LanguageRegistry.addName(FalloutMain.T45Boots, "T-45d Power Boots");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T45Boots), new Object [] {"X*X", "X X", 'X', FalloutMain.tungstenPlate, '*', FalloutMain.upgradeT45});
		LanguageRegistry.addName(FalloutMain.T51Helm, "T-51b Power Helmet");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T51Helm, 1), new Object [] {" X ", "X*X", " X ", 'X', FalloutMain.upgradeT51, '*', FalloutMain.T45Helm});
		LanguageRegistry.addName(FalloutMain.T51Chest, "T-51b Power Chestplate");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T51Chest, 1), new Object [] {" X ", "X*X", " X ", 'X', FalloutMain.upgradeT51, '*', FalloutMain.T45Chest});
		LanguageRegistry.addName(FalloutMain.T51Legs, "T-51b Power Leggings");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T51Legs, 1), new Object [] {" X ", "X*X", " X ", 'X', FalloutMain.upgradeT51, '*', FalloutMain.T45Legs});
		LanguageRegistry.addName(FalloutMain.T51Boots, "T-51b Power Boots");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.T51Boots, 1), new Object [] {" X ", "X*X", " X ", 'X', FalloutMain.upgradeT51, '*', FalloutMain.T45Boots});
		LanguageRegistry.addName(FalloutMain.G1Helm, "Gecko Backed Leather Cap");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.G1Helm, 1), new Object [] {"XXX", "X*X", 'X', FalloutMain.geckoHide, '*', Item.helmetLeather});
		LanguageRegistry.addName(FalloutMain.G1Chest, "Gecko Backed Leather Tunic");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.G1Chest, 1), new Object [] {"X X", "X*X", "XXX", 'X', FalloutMain.geckoHide, '*', Item.plateLeather});
		LanguageRegistry.addName(FalloutMain.G1Legs, "Gecko Backed Leather Leggings");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.G1Legs, 1), new Object [] {"XXX", "X*X", "X X", 'X', FalloutMain.geckoHide, '*', Item.legsLeather});
		LanguageRegistry.addName(FalloutMain.G1Boots, "Gecko Backed Leather Boots");
		GameRegistry.addRecipe(new ItemStack(FalloutMain.G1Boots, 1), new Object [] {"X*X", "X X", 'X', FalloutMain.geckoHide, '*', Item.bootsLeather});
		LanguageRegistry.addName(FalloutMain.EnclaveHelm, "Enclave Powered Helmet");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.EnclaveHelm), new Object [] {});
		LanguageRegistry.addName(FalloutMain.EnclaveChest, "Enclave Powered Chestplate");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.EnclaveChest), new Object [] {});
		LanguageRegistry.addName(FalloutMain.EnclaveLegs, "Enclave Powered Leggings");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.EnclaveLegs), new Object [] {});
		LanguageRegistry.addName(FalloutMain.EnclaveBoots, "Enclave Powered Boots");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.EnclaveBoots), new Object [] {});
		LanguageRegistry.addName(FalloutMain.HellHelm, "Advanced Power Armor Helmet");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.HellHelm), new Object [] {});
		LanguageRegistry.addName(FalloutMain.HellChest, "Advanced Power Armor Chestplate");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.HellChest), new Object [] {});
		LanguageRegistry.addName(FalloutMain.HellLegs, "Advanced Power Armor Leggings");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.HellLegs), new Object [] {});
		LanguageRegistry.addName(FalloutMain.HellBoots, "Advanced Power Armor Boots");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.HellBoots), new Object [] {});
		LanguageRegistry.addName(FalloutMain.WinterHelm, "Winterized T-51b Helmet");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.WinterHelm), new Object [] {});
		LanguageRegistry.addName(FalloutMain.WinterChest, "Winterized T-51b Chestplate");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.WinterChest), new Object [] {});
		LanguageRegistry.addName(FalloutMain.WinterLegs, "Winterized T-51b Leggings");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.WinterLegs), new Object [] {});
		LanguageRegistry.addName(FalloutMain.WinterBoots, "Winterized T-51b Boots");
		//GameRegistry.addRecipe(new ItemStack(FalloutMain.WinterBoots), new Object [] {});

	}
}
