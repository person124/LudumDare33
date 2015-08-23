package com.person124.ld33.entity;

import com.person124.ld33.graphics.Render;
import com.person124.ld33.level.Level;

public class Entity {

	public int x, y;
	public int color;
	protected Level level;

	public Entity(int x, int y, int c) {
		this.x = x;
		this.y = y;
		color = c;
	}

	public void update() {

	}

	public void render() {
		Render.draw(x, y, color);
	}

	public void move(int xp, int yp) {
		if (xp == 0 && yp == 0) return;
		if (xp != 0 && yp != 0) {
			move(xp, 0);
			move(0, yp);
			return;
		}

		if (!level.isSolid(x + xp, y + yp)) {
			x += xp;
			y += yp;
		}
	}

	public void init(Level l) {
		level = l;
		level.add(this);
	}

}
