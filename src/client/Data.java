package client;

import java.awt.Image;

public class Data {
	private String exchange;
	private String routingKey;
	private Image img;

	public Data(String routingKey, Image img) {
		this.routingKey = routingKey;
		this.img = img;
	}

	public Data(String exchange, String routingKey, Image img) {
		this.exchange = exchange;
		this.routingKey = routingKey;
		this.img = img;
	}
	
	public String exchange() {
		return this.exchange;
	}
	
	public String routingKey() {
		return this.routingKey;
	}
	
	public String body() {
		return this.img.toString();
	}

	public String toString() {
		if (exchange.length() > 0) {
			return String.format("Exchange='%s', Key='%s', '%s'", exchange, routingKey, img);
		} else {
			return String.format("Key='%s', '%s'", routingKey, img);
		}
	}
}