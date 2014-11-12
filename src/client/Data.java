package client;

public class Data {
	private String exchange;
	private String routingKey;
	private String body;

	public Data(String routingKey, String body) {
		this.routingKey = routingKey;
		this.body = body;
	}

	public Data(String exchange, String routingKey, String body) {
		this.exchange = exchange;
		this.routingKey = routingKey;
		this.body = body;
	}
	
	public String exchange() {
		return this.exchange;
	}
	
	public String routingKey() {
		return this.routingKey;
	}
	
	public String body() {
		return this.body;
	}

	public String toString() {
		if (exchange.length() > 0) {
			return String.format("Exchange='%s', Key='%s', '%s'", exchange,
					routingKey, body);
		} else {
			return String.format("Key='%s', '%s'", routingKey, body);
		}
	}
}