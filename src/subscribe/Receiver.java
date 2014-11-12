package subscribe;

import java.io.IOException;

import client.Client;
import upload.Uploader;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class Receiver extends Thread {
	public Client client;
	public Channel channel;
	public QueueingConsumer consumer;
	public QueueingConsumer.Delivery delivery;
	
	public Receiver() throws IOException {
		client = new Client();
		channel = client.getChannel();

		// bind exchange to random queue.
		channel.exchangeDeclare(Uploader.EXCHANGE, Uploader.EXCHANGE_TYPE);
		String queue = channel.queueDeclare().getQueue();
		channel.queueBind(queue, Uploader.EXCHANGE, "");

		consumer = new QueueingConsumer(channel);

		boolean autoAck = false; // for redelivering when consuming failed.
		channel.basicConsume(queue, autoAck, consumer);

		System.out.println("ready to receive.");
	}
	
	public void run() {
		System.out.println("Receiver start");
		
		try {
			delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		} catch (ShutdownSignalException | ConsumerCancelledException
				| InterruptedException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Receiver terminated");
	}
}