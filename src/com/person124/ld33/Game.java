package com.person124.ld33;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.person124.ld33.graphics.Render;
import com.person124.ld33.level.Level;
import com.person124.ld33.level.Levels;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "A Monster Is You!";
	public static final Random RAND = new Random();

	public static Game instance;
	public static int width, height;
	private static int scale;
	private static Thread thread;
	private static boolean running = false;
	private static JFrame frame;
	public static BufferStrategy bs;
	private static BufferedImage image;
	public static int[] pixels;
	public static Input in;

	private int level;
	private Level l;

	public static boolean lost = false, win = false;

	public Game(int w, int h) {
		instance = this;
		width = w;
		height = h;

		in = new Input();
		addKeyListener(in);

		level = 0;
		l = Levels.getLevel(level);
	}

	public static void nextLevel() {
		Game.instance.level++;
	}
	public static void setLevel(int i) {
		Game.instance.level = i;
		Game.in.reset = true;
	}

	public void update() {
		if (in.left || in.right || in.up || in.down) {
			if (!lost && !win) {
				l.update();
				in.allFalse();
			}
		} else if (in.reset) {
			lost = false;
			win = false;
			l = Levels.getLevel(level);
			in.allFalse();
		}
	}

	public void render() {
		Render.clear();
		Graphics g = bs.getDrawGraphics();

		l.render();

		g.drawImage(image, 0, 0, getScaledWidth(), getScaledHeight(), null);
		g.dispose();
		bs.show();
	}

	public void run() {
		long lastTime = System.nanoTime(), now;
		double delta = 0;
		final double NS = 1000000000 / 60;
		long timer = System.currentTimeMillis();
		int fps = 0, ups = 0;

		requestFocus();
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / NS;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
				ups++;
			}
			render();
			fps++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + " | ups: " + ups + ", fps: " + fps);
				ups = 0;
				fps = 0;
			}
		}
		stop();
	}

	public static void resize(int s) {
		scale = s;

		if (frame != null) frame.dispose();
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(width * scale, height * scale));
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(instance);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		if (bs == null) {
			instance.createBufferStrategy(3);
			bs = instance.getBufferStrategy();
		}

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, TITLE.toLowerCase().replace(" ", "_") + "_thread");
		thread.run();
	}

	public synchronized void stop() {
		running = false;
		if (frame != null) frame.dispose();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int getScaledWidth() {
		return width * scale;
	}

	public static int getScaledHeight() {
		return height * scale;
	}
	
	public static void start(int w, int h, int s) {
		Game g = new Game(w, h);
		Game.resize(s);
		g.start();
	}

}
