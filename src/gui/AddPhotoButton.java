package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;

import client.Client;
import upload.Uploader;

public class AddPhotoButton extends JButton implements MouseListener {
	private int width = 440;
	private int height = 40;
	
	public AddPhotoButton() {
		this.setPreferredSize(new Dimension(width, height));
		this.setText("Add Button");
		this.setBackground(Color.RED);
		this.setVisible(true);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		try {
			Uploader uploader;
			uploader = new Uploader();
			uploader.upload();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		return;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		return;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		return;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		return;
	}
}
