package _00_IntroToStacks;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

public class _02_TextUndoRedo implements ActionListener, KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
     JFrame frame = new JFrame();
     JPanel panel = new JPanel();
     JLabel label = new JLabel();
     Stack<Character> under = new Stack<Character>();
     void setup() {
    	 frame.add(panel);
    	 panel.add(label);
 		frame.setVisible(true);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.addKeyListener(this);
 		frame.setTitle("Notefad");
 		label.setVisible(true);
     }
     public static void main(String[] args) {
		_02_TextUndoRedo runner = new _02_TextUndoRedo();
		runner.setup();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Character temp = e.getKeyChar();
		if(e.getKeyCode()==KeyEvent.VK_DELETE) {
		String temp2 = label.getText();
		under.add(temp2.charAt(temp2.length()-1));
		temp2 = temp2.substring(0, temp2.length()-1);
		label.setText(temp2);
		}
		else if(e.getKeyCode()==KeyEvent.VK_END) {
			label.setText(label.getText()+under.pop());
		}
		else if(temp<32||temp>126) {
			
		}
		else {
		//System.out.println(temp);
		label.setText(label.getText()+temp);
		frame.pack();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
