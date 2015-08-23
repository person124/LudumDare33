package com.person124.ld33.graphics;

import com.person124.ld33.Game;
import com.person124.ld33.entity.Colors;

public class Render {

	private static int xOff, yOff;

	public static void offset(int x, int y) {
		xOff = x;
		yOff = y;
	}

	public static void clear() {
		for (int i = 0; i < Game.pixels.length; i++) {
			Game.pixels[i] = Colors.NULL;
		}
	}

	public static void draw(int x, int y, int color) {
		x += xOff;
		y += yOff;

		if (check(x, y)) {
			if (Game.win) {
				if (color == 0xe0ac69) Game.pixels[x + y * Game.width] = 0xff0000;
				else Game.pixels[x + y * Game.width] = Game.RAND.nextInt(0x0000ff);
			} else Game.pixels[x + y * Game.width] = Game.lost ? getGray(color) : color;
		}
	}

	private static boolean check(int x, int y) {
		if (x < 0 || y < 0) return false;
		if (x >= Game.width || y >= Game.height) return false;
		return true;
	}

	public static int getGray(int color) {
		if (color == 0) return 0;
		String s = Integer.toHexString(color);

		int r = getInt(s, 0);

		int g = 0;
		if (s.length() > 2) g = getInt(s, 2);

		int b = 0;
		if (s.length() == 6) b = getInt(s, 4);

		return (int) (0.299 * r + 0.587 * g + 0.114 * b);
	}

	private static int getInt(String color, int s) {
		return Integer.parseInt(color.substring(s, s + 2), 16);
	}

}
