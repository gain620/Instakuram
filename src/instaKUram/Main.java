package instaKUram;

import java.io.IOException;
import javax.swing.JFrame;

import client.Client;

class Main {
	private static Client client = new Client();
	
	public static void main(String[] args) throws IOException {
		JFrame frame =  new JFrame("instaKUram");
		frame.setContentPane(new MainPanel(client));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
