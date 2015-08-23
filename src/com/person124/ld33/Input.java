package com.person124.ld33;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

	public boolean left, right, up, down, reset;
	private int leftKey = KeyEvent.VK_A, rightKey = KeyEvent.VK_D, upKey = KeyEvent.VK_W, downKey = KeyEvent.VK_S, resetKey = KeyEvent.VK_R;

	public void keyPressed(KeyEvent e) {
		parseKey(e.getKeyCode(), true);
	}

	public void keyReleased(KeyEvent e) {
		parseKey(e.getKeyCode(), false);
	}

	public void keyTyped(KeyEvent e) {
		
	}

	private void parseKey(int code, boolean b) {
		if (leftKey == code) left = b;
		else if (rightKey == code) right = b;
		else if (upKey == code) up = b;
		else if (downKey == code) down = b;
		else if (resetKey == code) reset = b;
	}
	
	public void allFalse() {
		left = false;
		right = false;
		up = false;
		down = false;
		reset = false;
	}

}
