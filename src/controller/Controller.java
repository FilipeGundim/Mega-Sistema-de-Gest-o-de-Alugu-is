package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JOptionPane;

import list.List;
import models.Client;
import models.Rent;
import models.Theme;

public class Controller {
	private static List<Client> clientList = new List<Client>();
	private static List<Rent> rentList = new List<Rent>();
	private static List<Theme> themeList = new List<Theme>();

	public Controller() {
		// TODO 
		// read files in constructor and push data in list
	}

	public void addNewClient() {
		Client client = new Client();
		client.setName(JOptionPane.showInputDialog("Informe o nome do cliente"));
		client.setTel(JOptionPane.showInputDialog("Informe o telefone do cliente"));
		client.setRegisteredAt(new Date());
		clientList.addAtBeginning(client);
	}

	public void removeClient() {
		int position = Integer.parseInt(JOptionPane
				.showInputDialog(clientList.showListValues() + "\n Digite o código do cliente que deseja remover"));
		clientList.removeInAnyPosition(position);
	}

	public void addNewTheme() {
		Theme theme = new Theme();
		theme.setName(JOptionPane.showInputDialog("Informe o nome do tema"));
		themeList.addAtBeginning(theme);
	}

	public void removeTheme() {
		int position = Integer.parseInt(JOptionPane
				.showInputDialog(themeList.showListValues() + "\n Digite a posição do tema que deseja remover"));
		themeList.removeInAnyPosition(position);
	}

	public void addNewRent() {
		Rent rent = new Rent();
		rent.setDate(JOptionPane.showInputDialog("Informe a data"));
		rent.setAddress(JOptionPane.showInputDialog("Informe o endereço"));
		rent.setTheme(null);
		rentList.addAtBeginning(rent);
	}

	public void removeRent() {
		int position = Integer.parseInt(JOptionPane
				.showInputDialog(rentList.showListValues() + "\n Digite a posição do cliente que deseja remover"));
		rentList.removeInAnyPosition(position);
	}

	public void createLocalFiles() throws IOException {
		BufferedWriter fwClient = new BufferedWriter(new FileWriter("clients.csv"));
		BufferedWriter fwTheme = new BufferedWriter(new FileWriter("themes.csv"));
		BufferedWriter fwRent = new BufferedWriter(new FileWriter("rent.csv"));

		fwClient.write(clientList.showListValues());
		fwClient.newLine();
		fwClient.close();

		fwTheme.write(themeList.showListValues());
		fwTheme.newLine();
		fwTheme.close();

		fwRent.write(rentList.showListValues());
		fwRent.newLine();
		fwRent.close();
	}
}
