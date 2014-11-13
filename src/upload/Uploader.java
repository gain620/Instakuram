package upload;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import client.Client;
import client.Data;

import com.rabbitmq.client.Channel;

public class Uploader {
	private Client client;
	private Channel channel;
	public static final String EXCHANGE = "instaKUram"; // exchange name
	public static final String EXCHANGE_TYPE = "fanout"; // exchange type

	public Uploader(Client client) throws IOException {
		this.client = client;
		this.channel = this.client.getChannel();
		this.channel.exchangeDeclare(EXCHANGE, EXCHANGE_TYPE);
	}
	
	public void upload() throws IOException {
		FileInputStream fis = null;
		FileDialog fileDialog = new FileDialog(new Frame(), "Select image file", FileDialog.LOAD);
		fileDialog.setDirectory("C:\\");
		fileDialog.setFilenameFilter(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".jpg"); // 추가 가능할듯
			}
		});
		fileDialog.setVisible(true);

		if(fileDialog.getFile() != null) {
			fis = new FileInputStream(fileDialog.getDirectory() + fileDialog.getFile());
			Data data = new Data(EXCHANGE, "", fis);
			System.out.println("ready to send.");
			channel.basicPublish(data.exchange(), data.routingKey(), null, data.body().getBytes());
			System.out.println(" [x] Sent " + data.toString());
		}
		else {
			System.out.println("Upload canceled");
		}
		
		//fis.close(); 하면 에러남
		//client.close(); 닫아줄 이유가 없음
	}
}