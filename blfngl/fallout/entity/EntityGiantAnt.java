package blfngl.fallout.entity;

import javax.swing.text.html.parser.Entity;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import blfngl.fallout.FalloutMain;

public class EntityGiantAnt extends EntityMob
{
	public EntityGiantAnt(World par1World)
	{
		super(par1World);
		this.texture = "/blfngl/fallout/textures/FGhoul.png";
		this.moveSpeed = 0.7f;
		isImmuneToFire = false;

		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 25.0F, 0, true));

	}

	public int func_82193_c(Entity par1Entity)
	{
		return 12;
	}

	protected void fall(float par1) {}
	public int getMaxHealth()
	{
		return 30;
	}

	protected String getLivingSound()
	{
		return "blfngl.AntTalk";
	}

	protected String getHurtSound()
	{
		return "blfngl.AntHurt";
	}

	protected String getDeathSound()
	{
		return "blfngl.AntHurt";
	}

	protected int getDropItemId()
	{
		return FalloutMain.AntMeat.itemID;
	}

	protected void dropRareDrop(int par1)
	{
		switch (this.rand.nextInt(3))
		{
		case 0:
			this.dropItem(FalloutMain.AntEgg.itemID, 1);
			break;

		case 1:
			return;
			
		case 2:
			return;
		}
	}

	protected boolean canDespawn()
	{
		return true;
	}

	protected boolean isAIEnabled()
	{
		return true;
	}
}