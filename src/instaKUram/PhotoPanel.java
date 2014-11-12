package instaKUram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PhotoPanel extends JPanel {
	private int width = 440;
	private int height = 480;
	
	public PhotoPanel() {
		this.setLayout(new GridLayout());
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, height));
		this.setFocusable(true);
		this.requestFocus();
	}
}
