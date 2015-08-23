package com.person124.ld33.entity;

public class EntityBackAndForth extends EntityAttacker {
	
	private boolean up;
	private boolean reversed;

	public EntityBackAndForth(int x, int y, boolean up, boolean forward) {
		super(x, y, Colors.BACK_AND_FORTH);
		this.up = up;
		reversed = !forward;
	}
	
	public EntityBackAndForth(int x, int y, boolean up) {
		this(x, y, up, true);
	}
	
	public void update() {
		if (up) {
			if (!reversed) {
				if (level.isSolid(x, y + 1)) reversed = !reversed;
				else y += 1;
			} else {
				if (level.isSolid(x, y - 1)) reversed = !reversed;
				else y -= 1;
			}
		} else {
			if (!reversed) {
				if (level.isSolid(x + 1, y)) reversed = !reversed;
				else x += 1;
			} else {
				if (level.isSolid(x - 1, y)) reversed = !reversed;
				else x -= 1;
			}
		}
		
		super.update();
	}
	
}
