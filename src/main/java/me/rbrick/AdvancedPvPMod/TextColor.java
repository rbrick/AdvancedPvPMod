package me.rbrick.AdvancedPvPMod;


public enum TextColor {
	
	WHITE(0xffffff),
	GOLD(0xFFD700),
	PINKISH(0xFE8080),
	PURPLE(0x660099),
	MARINE(0x0099FF);
	
	int color;
	
	private TextColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
}
