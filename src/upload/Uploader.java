package upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import client.Client;
import client.Data;

import com.rabbitmq.client.Channel;

public class Uploader {
	public static String EXCHANGE = "instaKUram";// exchange name
	public static String EXCHANGE_TYPE = "fanout";// exchange type

	public void upload() throws IOException {
		Client client = new Client();
		Channel channel = client.getChannel();

		channel.exchangeDeclare(EXCHANGE, EXCHANGE_TYPE);

		// create messages.
		List<Data> data = new ArrayList<Data>();
		for (int i = 1; i < 11; i++) {
			data.add(new Data(EXCHANGE, "", "fanout" + i));
		}

		System.out.println("ready to send.");
		for (Data d : data) {
			channel.basicPublish(d.exchange, d.routingKey, null, d.body.getBytes());

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