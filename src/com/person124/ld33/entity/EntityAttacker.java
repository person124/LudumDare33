package com.person124.ld33.entity;

public class EntityAttacker extends Entity {

	public EntityAttacker(int x, int y, int c) {
		super(x, y, c);
	}
	
	public void update() {
		if (x == level.getPlayer().x && y == level.getPlayer().y) level.getPlayer().lose();
	}

}
