package com.person124.ld33.level;

import javax.swing.JOptionPane;

import com.person124.ld33.Game;
import com.person124.ld33.entity.EntityBackAndForth;
import com.person124.ld33.entity.EntityChaser;
import com.person124.ld33.entity.EntityDoor;
import com.person124.ld33.entity.EntityGoal;
import com.person124.ld33.entity.EntityKey;
import com.person124.ld33.entity.EntityPlayer;

public class Levels {

	public static Level getLevel(int i) {
		Level l;
		switch (i) {
			case 0:
				l = new Level(5, 5, new EntityPlayer(2, 1));
				l.loadTiles("5x5");
				new EntityGoal(2, 3).init(l);
				return l;
			case 1:
				l = new Level(7, 7, new EntityPlayer(3, 1));
				l.loadTiles("7x7");
				new EntityGoal(3, 5).init(l);
				new EntityBackAndForth(3, 3, false).init(l);
				return l;
			case 2:
				l = new Level(7, 7, new EntityPlayer(3, 1));
				l.loadTiles("2");
				new EntityGoal(3, 5).init(l);
				new EntityBackAndForth(4, 3, false, true).init(l);
				new EntityBackAndForth(2, 3, false, false).init(l);
				return l;
			case 3:
				l = new Level(15, 15, new EntityPlayer(7, 1));
				l.loadTiles("3");
				new EntityGoal(1, 13).init(l);
				new EntityBackAndForth(1, 3, false).init(l);
				new EntityBackAndForth(2, 4, false).init(l);
				new EntityBackAndForth(3, 5, false).init(l);
				new EntityBackAndForth(4, 6, false).init(l);
				new EntityBackAndForth(5, 7, false).init(l);
				new EntityBackAndForth(6, 8, false).init(l);
				new EntityBackAndForth(7, 9, false).init(l);
				new EntityBackAndForth(8, 10, false).init(l);
				return l;
			case 4:
				l = new Level(9, 9, new EntityPlayer(2, 2));
				l.loadTiles("4");
				new EntityGoal(6, 2).init(l);
				new EntityBackAndForth(2, 4, false).init(l);
				new EntityBackAndForth(4, 6, true).init(l);
				new EntityBackAndForth(6, 4, false, false).init(l);
				return l;
			case 5:
				l = new Level(15, 15, new EntityPlayer(1, 1));
				l.loadTiles("15x15");
				new EntityBackAndForth(1, 2, false).init(l);
				new EntityBackAndForth(2, 1, true).init(l);
				new EntityBackAndForth(13, 12, false).init(l);
				new EntityBackAndForth(12, 13, true).init(l);
				new EntityChaser(13, 13, true).init(l);
				new EntityGoal(7, 7).init(l);
				return l;
			case 6:
				l = new Level(7, 7, new EntityPlayer(1, 1));
				l.loadTiles("6");
				new EntityGoal(5, 5).init(l);
				new EntityChaser(5, 5, true).init(l);
				return l;
			case 7:
				l = new Level(12, 12, new EntityPlayer(1, 1));
				l.loadTiles("7");
				new EntityChaser(10, 10, false).init(l);
				new EntityChaser(1, 10, true).init(l);
				new EntityGoal(1, 10).init(l);
				return l;
			case 8:
				l = new Level(15, 15, new EntityPlayer(1, 1));
				l.loadTiles("8");
				new EntityGoal(7, 7).init(l);
				new EntityChaser(6, 7, false).init(l);
				new EntityChaser(7, 6, true).init(l);
				return l;
			case 9:
				l = new Level(5, 5, new EntityPlayer(1, 1));
				l.loadTiles("5x5");
				new EntityGoal(1, 3).init(l);
				new EntityKey(3, 1).init(l);
				new EntityDoor(1, 2).init(l);
				new EntityDoor(2, 3).init(l);
				return l;
			case 10:
				l = new Level(5, 5, new EntityPlayer(2, 1));
				l.loadTiles("5x5");
				new EntityGoal(1, 3).init(l);
				new EntityKey(1, 1).init(l);
				new EntityKey(3, 1).init(l);
				new EntityKey(3, 3).init(l);
				new EntityDoor(1, 2).init(l);
				new EntityDoor(2, 3).init(l);
				return l;
			case 11:
				l = new Level(15, 17, new EntityPlayer(1, 1));
				l.loadTiles("11");
				new EntityGoal(7, 15).init(l);
				for (int j = 0; j < 6; j++) {
					new EntityBackAndForth(1, 2 + j * 2, false, true).init(l);
					new EntityBackAndForth(13, 1 + j * 2, false, false).init(l);
				}
				new EntityBackAndForth(13, 13, false, false).init(l);
				new EntityKey(13, 1).init(l);
				new EntityKey(7, 7).init(l);
				new EntityKey(1, 13).init(l);
				new EntityDoor(7, 14).init(l);
				return l;
			case 12:
				l = new Level(9, 19, new EntityPlayer(4, 1));
				l.loadTiles("final");
				new EntityGoal(4, 17).init(l);
				new EntityChaser(7, 1, true).init(l);
				new EntityChaser(1, 1, true).init(l);
				for (int j = 0; j < 12; j++) {
					new EntityBackAndForth(3 + j % 3, 3 + j, true, false).init(l);
				}
				new EntityKey(3, 11).init(l);
				new EntityDoor(3, 16).init(l);
				return l;
			case 13:
				JOptionPane.showMessageDialog(null, "A Winner Is You!", Game.TITLE, JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "If you can't tell, this is where my work ethic died.", Game.TITLE, JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, "I do hope you had fun though.", Game.TITLE, JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			default:
				return null;
		}
	}

}
