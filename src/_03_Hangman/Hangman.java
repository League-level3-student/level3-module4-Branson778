package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();
	static JLabel label2 = new JLabel();
	static int lives = 10;
	static String plays = "";
	static int words;
	static ArrayDeque<String> list = new ArrayDeque<String>();
	static Utilities getter = new Utilities();
	static String current = "";
	static String display = "";

	public void setup() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		label2 = new JLabel();
		lives = 10;
		plays = "";
		list = new ArrayDeque<String>();
		getter = new Utilities();
		current = "";
		display = "";
		plays = JOptionPane.showInputDialog("How Many Words Would You Like To Guess?(1-100)");
		words = Integer.parseInt(plays);
		frame.add(panel);
		panel.add(label2);
		panel.add(label);
		frame.setVisible(true);
		frame.setTitle("Hangman Gauntlet");
		frame.addKeyListener(this);
		label2.setText("Lives Left: " + lives);
		for (int i = 0; i < words; i++) {
			String undupe = getter.readRandomLineFromFile("dictionary.txt");
			if (!list.contains(undupe)) {
				list.add(undupe);
			} else {
				i--;
			}
		}
		current = list.pop();
		for (int i = 0; i < current.length(); i++) {
			display += "_";
		}
		label.setText(display);
		frame.pack();
	}

	public static void main(String[] args) {
		Hangman runner = new Hangman();
		runner.setup();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (current.contains(e.getKeyChar() + "")) {
			if (!display.contains(e.getKeyChar() + "")) {
				StringBuilder setter = new StringBuilder(display);
				for (int i = 0; i < current.length(); i++) {
					if (current.charAt(i) == e.getKeyChar()) {
						setter.setCharAt(i, e.getKeyChar());
					}
				}
				display = setter.toString();
				label.setText(display);
				if (display.equals(current)) {
					if (list.size() - 1 > 0) {
						current = list.pop();
						for (int i = 0; i < current.length(); i++) {
							display += "_";
						}
						label.setText(display);
					} else {
						Hangman reset2 = new Hangman();
						JOptionPane.showMessageDialog(null, "You Win!");
						String retry = JOptionPane.showInputDialog("Would You Like To Play Again?(Yes/No)");
						if (retry.equalsIgnoreCase("Yes")) {
							reset2.setup();
						} else {
							System.exit(0);
						}
					}
				}
			}
		} else {
			lives--;
			Hangman reset = new Hangman();
			if (lives <= 0) {
				JOptionPane.showMessageDialog(null, "Game Over!");
				String retry = JOptionPane.showInputDialog("Would You Like To Play Again?(Yes/No)");
				if (retry.equalsIgnoreCase("Yes")) {
					reset.setup();
				} else {
					System.exit(0);
				}
			}
			label2.setText("Lives Left: " + lives);
		}
		frame.pack();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
