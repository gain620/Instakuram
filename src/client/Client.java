package client;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Client {
	private static String HOST = "54.64.140.164";
	private static String USER = "teamCriminals";
	private static String PASS = "teamCriminals";
	private static String VHOST = "/";
	
	private static Connection connection = null;
	private static Channel channel = null;

	public Client() {
		System.out.println("Client init start...");
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername(USER);
		factory.setPassword(PASS);
		factory.setVirtualHost(VHOST);
		System.out.println("Client init success...");
		
		try {
			System.out.println("Try to connect server...");
			this.connection = factory.newConnection();
			System.out.println("Connection succeed");
			System.out.println("Try to open channel...");
			this.channel = connection.createChannel();
			System.out.println("Channel opened...");
		} catch (IOException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public Channel getChannel() throws IOException {
		return this.channel;
	}

	public void close() throws IOException {
		this.channel.close();
		this.connection.close();
	}
}
