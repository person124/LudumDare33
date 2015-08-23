package com.person124.ld33.level;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.person124.ld33.entity.Entity;
import com.person124.ld33.entity.EntityPlayer;
import com.person124.ld33.level.tile.Tile;

public class Level {

	public final int WIDTH, HEIGHT;
	public final Tile[] TILES;

	private List<Entity> entities = new ArrayList<Entity>();
	private EntityPlayer player;

	public Level(int w, int h, EntityPlayer p) {
		WIDTH = w;
		HEIGHT = h;
		TILES = new Tile[WIDTH * HEIGHT];
		player = p;
		player.init(this);
	}

	public Level(int w, int h, Tile[] t, EntityPlayer p, List<Entity> e) {
		WIDTH = w;
		HEIGHT = h;
		TILES = t;
		player = p;
		player.init(this);
		for (Entity en : e) {
			en.init(this);
		}
	}

	public void update() {
		player.update();
		for (Entity e : entities) {
			e.update();
		}
	}

	public void render() {
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				TILES[x + y * WIDTH].render(x, y);
			}
		}

		player.render();
		for (Entity e : entities) {
			e.render();
		}
	}

	public void loadTiles(String path) {
		try {
			DataInputStream in = new DataInputStream(Level.class.getResourceAsStream("/" + path + ".txt"));
			byte[] b = new byte[in.available()];
			in.readFully(b);
			String sss = new String(b);
			String[] str = sss.split("\n");
			for (int y = 0; y < HEIGHT; y++) {
				char[] s = str[y].toCharArray();
				for (int x = 0; x < WIDTH; x++) {
					TILES[x + y * WIDTH] = Tile.parse(s[x]);
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public EntityPlayer getPlayer() {
		return player;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	private boolean check(int x, int y) {
		if (x < 0 || y < 0) return false;
		if (x >= WIDTH || y >= HEIGHT) return false;
		return true;
	}

	public boolean isSolid(int x, int y) {
		if (!check(x, y)) return true;
		return TILES[x + y * WIDTH].isSolid();
	}

}
