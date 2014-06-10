package me.rbrick.AdvancedPvPMod;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ButtonManager extends GuiMainMenu implements IGuiHandler {
	
	public ButtonManager() {
		// TODO Auto-generated constructor stub
	}
	
	
     @Override
    public void initGui() {
    	// TODO Auto-generated method stub
    	super.initGui();
    	
    	buttonList.add(new GuiButton(30, 30, 50, "Test"));
    }


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
