package com.person124.ld33.entity;

public class EntityGoal extends Entity {
	
	public EntityGoal(int x, int y) {
		super(x, y, Colors.GOAL);
	}
	
	public void update() {
		if (x == level.getPlayer().x && y == level.getPlayer().y) level.getPlayer().win();
	}

}
