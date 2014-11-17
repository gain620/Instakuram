package instaKUram;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import client.Client;
import subscribe.Receiver;
import gui.AddPhotoButton;
import gui.PhotoPanel;

public class MainPanel extends JPanel {
	private final int WIDTH = 440;
	private final int HEIGHT = 680;
	
	public MainPanel(Client client) {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	
		this.add(photoPanel(), BorderLayout.CENTER);
		this.add(addButton(), BorderLayout.SOUTH);
	}
	
	private PhotoPanel photoPanel() {
		PhotoPanel photoPanel = new PhotoPanel();
		return photoPanel;
	}
	
	private AddPhotoButton addButton() {
		AddPhotoButton addButton = new AddPhotoButton();	
		return addButton;
	}
	
	public void runReceiver() throws IOException {
		Receiver recv = new Receiver();
		recv.run();
	}
}