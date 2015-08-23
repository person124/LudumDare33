package com.person124.ld33;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class YouAreTheMonster extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JTextArea text;
	private JTextPane sizeOut;
	private JTextField sizeIn;
	private JButton start;
	
	private int defaultScreenSize = 4;
	
	private final int MESSAGE_WIDTH = 450, MESSAGE_HEIGHT = 150;
	private final int INPUT_HEIGHT = 45;
	private final int BUTTON_HEIGHT = 50;
	
	private void begin() {
		text.append("You are a monster, and your goal is to eat the children!\n\n");
		
		text.append("Use 'W' 'A' 'S' 'D' keys to move,and 'R' to restart a level.\n");
		text.append("'R' is also used to move on to the next level after the\ncurrent one is completed.\n\n");
		
		text.append("Thank you for playing, and remember: Have Fun!\nGame made by:\n");
		text.append("Person124, 2015, For Ludum Dare 33");
	}

	public YouAreTheMonster() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setTitle(Game.TITLE);
		setSize(MESSAGE_WIDTH + 10, 10 + MESSAGE_HEIGHT + 10 + INPUT_HEIGHT + 10 + BUTTON_HEIGHT + 10);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		
		text = new JTextArea();
		text.setBounds(5, 5, MESSAGE_WIDTH, MESSAGE_HEIGHT);
		text.setEditable(false);
		text.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Info"));
		panel.add(text);
		
		sizeIn = new JTextField(String.valueOf(defaultScreenSize));
		sizeIn.setBounds(5 + 53, MESSAGE_HEIGHT + 10, 75, INPUT_HEIGHT);
		sizeIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Scale:"));
		sizeIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!e.getActionCommand().isEmpty()) {
					defaultScreenSize = Integer.parseInt(sizeIn.getText());
					sizeOut.setText(getSize(sizeIn.getText()));
				}
			}
		});
		panel.add(sizeIn);
		
		sizeOut = new JTextPane();
		sizeOut.setBounds(90 + 53, MESSAGE_HEIGHT + 10, 200, INPUT_HEIGHT);
		sizeOut.setEditable(false);
		sizeOut.setText(getSize(sizeIn.getText()));
		sizeOut.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Window Size:"));
		panel.add(sizeOut);
		
		start = new JButton("Start Game");
		start.setBounds(100, MESSAGE_HEIGHT + 10 + INPUT_HEIGHT + 10, 200, BUTTON_HEIGHT);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				final int size = Integer.parseInt(sizeIn.getText()) * 16;
				new Thread(new Runnable() {
					public void run() {
						Game.start(15, 15, size);
					}
				}).start();
				setVisible(false);
				dispose();
			}
		});
		panel.add(start);
		
		begin();
	}
	
	private String getSize(String s) {
		int scale = Integer.parseInt(s) * 16;
		return (15 * scale) + "x" + (scale * 15);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				YouAreTheMonster m = new YouAreTheMonster();
				m.setVisible(true);
			}
		});
	}

}
