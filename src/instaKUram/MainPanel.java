package instaKUram;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.io.IOException;

import subscribe.Receiver;

public class MainPanel extends JPanel {
	// 화면 사이즈 설정
	public static final int WIDTH = 440;
	public static final int HEIGHT = 680;
	
	
	Dimension dimension = new Dimension(WIDTH, HEIGHT);

	public MainPanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(dimension);
		this.setFocusable(true);
		this.requestFocus();
		this.add(photoPanel(), BorderLayout.CENTER);
		this.add(addButton(), BorderLayout.SOUTH);
	}
	
	public PhotoPanel photoPanel() {
		PhotoPanel photoPanel = new PhotoPanel();
		return photoPanel;
	}
	
	public JButton addButton() {
		JButton addButton = new JButton("Add Photo");	
		addButton.setSize(WIDTH, 200);
		addButton.setBackground(Color.RED);
		return addButton;
	}
	
	public void runReceiver() throws IOException {
		Receiver recv = new Receiver();
		recv.run();
	}

}