package me.rbrick.AdvancedPvPMod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid="AdvancedPvP Mod", name="AdvancedPvP Mod", version="1.0.0")
public class Main {
	   // The instance of your mod that Forge uses.
	
	
    @Instance("AdvancedPvP Mod")
    public static Main instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="me.rbrick.AdvancedPvPMod.ClientProxy", serverSide="me.rbrick.AdvancedPvPMod.CommonProxy")
    public static CommonProxy proxy;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
            
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
//            proxy.registerRenderers();
    }
    
    
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
     MinecraftForge.EVENT_BUS.register(new TextRenderManager(Minecraft.getMinecraft()));
     NetworkRegistry.INSTANCE.registerGuiHandler(this, new ButtonManager());
    }
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
