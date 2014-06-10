package me.rbrick.AdvancedPvPMod;

import java.text.DecimalFormat;
import java.util.Collection;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TextRenderManager extends Gui {
	
	private Minecraft mc;
	
	public TextRenderManager(Minecraft mc) {
	     this.mc = mc;
	    
	}
	
	
	public void renderText(String textToRender, int xPos, int yPos, TextColor color) {
		FontRenderer fr = this.mc.fontRenderer;

		fr.drawString(textToRender,xPos ,yPos, color.getColor(), true);
	} 
	
//	  private static final int BUFF_ICON_SIZE = 18;
//	  private static final int BUFF_ICON_SPACING = BUFF_ICON_SIZE + 2; // 2 pixels between buff icons
//	  private static final int BUFF_ICON_BASE_U_OFFSET = 0;
//	  private static final int BUFF_ICON_BASE_V_OFFSET = 198;
//	  private static final int BUFF_ICONS_PER_ROW = 8;
//	  
	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public void onOverlayRender(RenderGameOverlayEvent e) {
	    if(e.isCancelable() || e.type != ElementType.EXPERIENCE)
	    {      
	      return;
	    }
	    ScaledResolution sclRes = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
		int factor = sclRes.getScaledWidth();
	    FontRenderer fr = this.mc.fontRenderer;
	    this.renderText("AdvancedPvP Mod v0.1",0,0, TextColor.PURPLE);
	    String ip = mc.getNetHandler().getNetworkManager().getSocketAddress().toString().split("/")[0];
	    if(ip.contains("local:")) {
	    	ip = "localhost";
	    }
	    this.renderText("[IP] " + ip, factor - fr.getStringWidth(("[IP] " + ip)), 0, TextColor.MARINE);
	    Collection<PotionEffect> pots =  mc.thePlayer.getActivePotionEffects();
	    
	    if(!pots.isEmpty()) {
	    
	    int x = 0;
	    for(PotionEffect pot : pots) {
	     
         Potion pott = Potion.potionTypes[pot.getPotionID()];
         this.renderText(StatCollector.translateToLocal(pott.getName()) + " " +Potion.getDurationString(pot)  , factor - fr.getStringWidth((StatCollector.translateToLocal(pott.getName()) + " " +Potion.getDurationString(pot) ))-2  , 20 + (10*x), TextColor.MARINE);
         x++;
         
	     }
	    }
	    DecimalFormat format = new DecimalFormat("#.##");
	    DecimalFormat formatY = new DecimalFormat("#");
	    
	    this.renderText("[FPS] " + mc.debug.split(",")[0].replace("fps", "") , 0, 20, TextColor.MARINE);
	    this.renderText("[X] " + format.format(mc.thePlayer.posX),0 ,30, TextColor.MARINE);
	    this.renderText("[Y] " + formatY.format(mc.thePlayer.posY),0 ,40, TextColor.MARINE);
	    this.renderText("[Z] " + format.format(mc.thePlayer.posZ),0 ,50, TextColor.MARINE);
	    
	    
	}

}