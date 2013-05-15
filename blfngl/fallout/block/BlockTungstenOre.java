package blfngl.fallout.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import blfngl.fallout.FalloutMain;

public class BlockTungstenOre extends BlockOre {
        public BlockTungstenOre(int id, int texture, Material material) {
                super(id);
                setHardness(4.0F);
                setStepSound(Block.soundStoneFootstep);
                setUnlocalizedName("TungstenOre");
                setCreativeTab(CreativeTabs.tabBlock);
        }
        
        public void func_94332_a(IconRegister iconRegister)
    	{
    		blockIcon = iconRegister.registerIcon("blfngl" + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    	}
        
        public int idDropped(int par1, Random random, int par2) {
                return FalloutMain.chunkTungsten.itemID;
        }
}