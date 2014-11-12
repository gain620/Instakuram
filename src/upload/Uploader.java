package upload;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import client.Client;
import client.Data;

import com.rabbitmq.client.Channel;

public class Uploader {
	private Client client;
	private Channel channel;
	public static String EXCHANGE = "instaKUram";// exchange name
	public static String EXCHANGE_TYPE = "fanout";// exchange type

	public Uploader(Client client) throws IOException {
		this.client = client;
		this.channel = this.client.getChannel();
		this.channel.exchangeDeclare(EXCHANGE, EXCHANGE_TYPE);
	}
	
	public void upload() throws IOException {
		Frame frame = new Frame();
		FileDialog dialog = new FileDialog(frame, "Select Image");
		dialog.setDirectory("C:\\");
		dialog.setVisible(true);
		
		List<Data> data = new ArrayList<Data>();
		for (int i = 1; i < 11; i++) {
			data.add(new Data(EXCHANGE, "", "fanout" + i));
		}

		System.out.println("ready to send.");
		for (Data d : data) {
			channel.basicPublish(d.exchange(), d.routingKey(), null, d.body().getBytes());

			System.out.println(" [x] Sent " + d.toString());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		client.close();
	}
}