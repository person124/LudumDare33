package com.person124.ld33.level.tile;

import com.person124.ld33.entity.Colors;
import com.person124.ld33.graphics.Render;

public enum Tile {
	
	NULL(Colors.NULL, true, ' '), FLOOR(Colors.FLOOR, false, '0'), WALL(Colors.WALL, true, '#'), CARPET(Colors.CARPET, false, '1');
	
	private boolean solid;
	private int color;
	private char name;
	
	private Tile(int c, boolean s, char n) {
		color = c;
		solid = s;
		name = n;
	}
	
	public boolean isSolid() {
		return solid;
	}
	
	public char getName() {
		return name;
	}
	
	public static Tile parse(char s) {
		for (Tile t : values()) {
			if (t.name == s) return t;
		}
		return FLOOR;
	}
	
	public void render(int x, int y) {
		Render.draw(x, y, color);
	}
	
}
