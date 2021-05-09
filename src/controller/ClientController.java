package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import list.List;
import models.Client;

public class ClientController {
	private List<Client> clientList = new List<Client>();
	private static String SEPARATOR = ";";

	public ClientController() throws IOException, ParseException {
		this.readAndStore();
	}

	public void addNew() {
		Client client = new Client();

		client.setName(JOptionPane.showInputDialog("Informe o nome do cliente"));
		client.setTel(JOptionPane.showInputDialog("Informe o telefone do cliente"));
		client.setRegisteredAt(new Date());
		clientList.addAtBeginning(client);
	}

	public void remove() {
		int position = Integer.parseInt(JOptionPane
				.showInputDialog(clientList.showListValues() + "\n Digite o código do cliente que deseja remover"));
		clientList.removeInAnyPosition(position);
	}

	public void createLocalFiles() throws IOException {
		BufferedWriter fwClient = new BufferedWriter(new FileWriter("clients.csv"));

		fwClient.write(clientList.showListValues());
		fwClient.newLine();
		fwClient.close();

	}

	private void readAndStore() throws IOException, ParseException {
		BufferedReader brClient = new BufferedReader(new FileReader("clients.csv"));

		String line;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		while ((line = brClient.readLine()) != null) {

			Client client = new Client();
			String[] values = line.split(SEPARATOR);

			client.setName(values[1]);
			client.setTel(values[2]);

			client.setRegisteredAt(formatter.parse(values[3]));
			this.clientList.addAtEnd(client);
		}

		brClient.close();
	}
}
