package com.person124.ld33.entity;

public class EntityKey extends Entity {
	
	private boolean collected = false;
	
	public EntityKey(int x, int y) {
		super(x, y, Colors.KEY);
	}
	
	public void update() {
		if (level.getPlayer().x == x && level.getPlayer().y == y) collected = true;
	}
	
	public void render() {
		if (!collected) super.render();
	}
	
	public boolean isCollected() {
		return collected;
	}

}
