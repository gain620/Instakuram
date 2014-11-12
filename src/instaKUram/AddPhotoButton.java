package instaKUram;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class AddPhotoButton extends JButton {
	private static int BUTTON_WIDTH = 440;
	private static int BUTTON_HEIGHT = 120;
	
	public AddPhotoButton(String buttonName) {
		this.setName(buttonName);
		this.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		this.setBackground(Color.RED);
	}
	
	public void clicked() {
		
	}
}
