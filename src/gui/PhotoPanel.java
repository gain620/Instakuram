package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PhotoPanel extends JPanel implements MouseListener {
	private int width = 440;
	private int height = 640;
	
	public PhotoPanel() {
		this.setLayout(new GridLayout());
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width, height));
		this.setVisible(true);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// 하이라이트 효과주면 좋을듯
		return;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// 하이라이트 해제효과
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
