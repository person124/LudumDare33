package com.person124.ld33.entity;

public class EntityChaser extends EntityAttacker {

	private boolean inversed;

	public EntityChaser(int x, int y, boolean inversed) {
		super(x, y, inversed ? Colors.CHASER_INVERSED : Colors.CHASER);
		this.inversed = inversed;
	}
	
	public EntityChaser(int x, int y) {
		this(x, y, false);
	}

	public void update() {
		if (!inversed) {
			if (x > level.getPlayer().x) move(-1, 0);
			else if (x < level.getPlayer().x) move(1, 0);
			else if (y > level.getPlayer().y) move(0, -1);
			else if (y < level.getPlayer().y) move(0, 1);
		} else {
			if (y > level.getPlayer().y) move(0, -1);
			else if (y < level.getPlayer().y) move(0, 1);
			else if (x > level.getPlayer().x) move(-1, 0);
			else if (x < level.getPlayer().x) move(1, 0);
		}
		super.update();
	}

}
