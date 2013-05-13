package blfngl.fallout.common;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class ScopeHandler extends KeyHandler
{
    private EnumSet tickTypes;

    public ScopeHandler(KeyBinding[] var1, boolean[] var2)
    {
        super(var1, var2);
        this.tickTypes = EnumSet.of(TickType.CLIENT);
    }

    public String getLabel()
    {
        return "Scope";
    }

    public void keyDown(EnumSet var1, KeyBinding var2, boolean var3, boolean var4)
    {
        FalloutMain.isScoped = true;
    }

    public void keyUp(EnumSet var1, KeyBinding var2, boolean var3)
    {
    	FalloutMain.isScoped = false;
    }

    public EnumSet ticks()
    {
        return this.tickTypes;
    }
}
