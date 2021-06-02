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
import node.Node;

public class ClientController {
	private List<Client> clientList = new List<Client>();
	private static String SEPARATOR = ";";
	private static String FORMAT = "dd/MM/yyyy";
	private String FILE = "clients.csv";

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

	public void edit() {
		int position = Integer.parseInt(JOptionPane
				.showInputDialog(clientList.showListValues() + "\n Digite a posição do cliente que deseja editar"));
		Client client = new Client();
		client.setName(JOptionPane.showInputDialog("Informe o novo nome do cliente"));
		client.setTel(JOptionPane.showInputDialog("Informe o novo telefone do cliente"));
		clientList.removeInAnyPosition(position);
		clientList.addInAnyPosition(client, position);
	}

	public void createLocalFiles() throws IOException {
		BufferedWriter fwClient = new BufferedWriter(new FileWriter(this.FILE));

		fwClient.write(clientList.showListValues());
		fwClient.newLine();
		fwClient.close();
	}

	private void readAndStore() throws IOException, ParseException {
		BufferedReader brClient = new BufferedReader(new FileReader(this.FILE));

		String line;
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);

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

	public void orderData() {
		Node<Client>[] clients = clientList.getValues();
		int left = 0;
		int right = clients.length - 1;
		this.quickSort(clients, left, right);
	}

	private void quickSort(Node<Client>[] clients, int ini, int end) {
		int divisao;
		if (ini < end) {
			divisao = particao(clients, ini, end);
			quickSort(clients, ini, divisao - 1);
			quickSort(clients, divisao + 1, end);
		}else {
			for(Node<Client> client : clients) {
				System.out.println(client.current.getName());
			}
		}
	}

	private int particao(Node<Client>[] clients, int ini, int end) {
		Node<Client> pivo = clients[ini];
		int i = ini + 1, f = end;
		Node<Client> aux;
		while (i <= f) {
			while (i <= end && clients[i].current.getName().compareTo(pivo.current.getName()) < 0)
				++i;
			while (pivo.current.getName().compareTo(clients[f].current.getName()) < 0)
				--f;
			if (i < f) {
				aux = clients[i];
				clients[i] = clients[f];
				clients[f] = aux;
				++i;
				--f;
			}
		}
		if (ini != f) {
			clients[ini] = clients[f];
			clients[f] = pivo;
		}
		return f;
	}
}
