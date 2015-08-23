package com.person124.ld33.entity;

import com.person124.ld33.Game;
import com.person124.ld33.graphics.Render;
import com.person124.ld33.level.Level;

public class EntityPlayer extends Entity {
	
	private final int OFFSET;

	public EntityPlayer(int x, int y) {
		super(x, y, Colors.PLAYER);
		OFFSET = Game.width / 2;
		Render.offset(OFFSET - x, OFFSET - y);
	}

	public void update() {
		int xp = 0;
		int yp = 0;

		if (Game.in.left) xp -= 1;
		if (Game.in.right) xp += 1;

		if (Game.in.up) yp -= 1;
		if (Game.in.down) yp += 1;

		move(xp, yp);
		
		Render.offset(OFFSET - x, OFFSET - y);
	}
	
	public void lose() {
		Game.lost = true;
	}
	
	public void win() {
		Game.win = true;
		Game.nextLevel();
	}
	
	public void init(Level l) {
		level = l;
	}

}
