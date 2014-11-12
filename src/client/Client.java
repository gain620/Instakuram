package client;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Client {
	public static String HOST = "54.64.140.164"; // RabbitMQ Server.
	private static String USER = "teamCriminals";
	private static String PASS = "teamCriminals";
	private static String VHOST = "/";
	
	private Connection connection = null;
	private Channel channel = null;

	public Channel getChannel() throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername(USER);
		factory.setPassword(PASS);
		factory.setVirtualHost(VHOST);
		
		this.connection = factory.newConnection();
		this.channel = connection.createChannel();

		return this.channel;
	}

	public void close() throws IOException {
		this.channel.close();
		this.connection.close();
	}
}
