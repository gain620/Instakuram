package client;

import java.io.FileInputStream;

public class Data {
	private String exchange;
	private String routingKey;
	private FileInputStream dataStream;

	public Data(String routingKey, FileInputStream dataStream) {
		this.routingKey = routingKey;
		this.dataStream  = dataStream;
	}

	public Data(String exchange, String routingKey, FileInputStream dataStream) {
		this.exchange = exchange;
		this.routingKey = routingKey;
		this.dataStream = dataStream;
	}
	
	public String exchange() {
		return this.exchange;
	}
	
	public String routingKey() {
		return this.routingKey;
	}
	
	public String body() {
		return this.dataStream.toString();
	}

	public String toString() {
		if (exchange.length() > 0) {
			return String.format("Exchange='%s', Key='%s', '%s'", exchange,
					routingKey, dataStream);
		} else {
			return String.format("Key='%s', '%s'", routingKey, dataStream);
		}
	}
}