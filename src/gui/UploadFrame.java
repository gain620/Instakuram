package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.rabbitmq.client.Channel;

import instaKUram.Main;
import client.Data;

public class UploadFrame extends JFrame implements MouseListener {
	public static final String EXCHANGE = "instaKUram";
	public static final String EXCHANGE_TYPE = "fanout";
	
	private Channel channel;
	private Image img;
	
	public UploadFrame(Image img) throws IOException {
		this.channel = Main.CLIENT.getChannel();
		this.channel.exchangeDeclare(EXCHANGE, EXCHANGE_TYPE);
		this.img = img;
		this.addMouseListener(this);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	public void upload() throws IOException {
		Data data = new Data(EXCHANGE, "", img);
		channel.basicPublish(data.exchange(), data.routingKey(), null, data.body().getBytes());
		System.out.println(" [x] Sent " + data);
	}
	
	public void paint(Graphics g) {
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);    
		g.drawImage(img, 0, 0, panel);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// 필터효과 주고 버튼을 누르면 upload()호출
		return;
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
