package com.person124.ld33.entity;

public class EntityDoor extends EntityAttacker {

	private boolean opened = false;

	public EntityDoor(int x, int y) {
		super(x, y, Colors.DOOR);
	}

	public void update() {
		if (!opened) {
			boolean b = true;
			for (Entity e : level.getEntities()) {
				if (e instanceof EntityKey) {
					if (!((EntityKey) e).isCollected()) b = false;
				}
			}
			opened = b;
			if (!opened) super.update();
		}
	}

	public void render() {
		if (!opened) super.render();
	}

}
