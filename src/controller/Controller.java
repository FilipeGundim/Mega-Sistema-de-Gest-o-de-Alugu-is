package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import list.List;
import models.Client;
import models.Rent;
import models.Theme;

public class Controller {
	private static List<Client> clientList = new List<Client>();
	private static List<Rent> rentList = new List<Rent>();
	private static List<Theme> themeList = new List<Theme>();

	public Controller() throws IOException, ParseException {
		this.readAndStoreClients();
		this.readAndStoreRents();
		this.readAndStoreThemes();
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

	private void readAndStoreClients() throws IOException, ParseException {
		BufferedReader brClient = new BufferedReader(new FileReader("clients.csv"));

		String SEPARATOR = ";";
		String line;

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		while ((line = brClient.readLine()) != null) {
			Client client = new Client();
			String[] values = line.split(SEPARATOR);
			
			client.setName(values[1]);
			client.setTel(values[2]);
			client.setRegisteredAt(formatter.parse(values[3]));
		}

		brClient.close();
	}

	private void readAndStoreRents() throws IOException {
		BufferedReader brRent = new BufferedReader(new FileReader("rent.csv"));

		String SEPARATOR = ";";
		String line;

		while ((line = brRent.readLine()) != null) {
			Rent rent = new Rent();
			Theme theme = new Theme();
			
			String[] values = line.split(SEPARATOR);
			theme.setName(values[1]);
			rent.setTheme(theme);
			rent.setAddress(values[2]);
			rent.setDate(values[0]);
		}

		brRent.close();
	}

	private void readAndStoreThemes() throws IOException {
		BufferedReader brTheme = new BufferedReader(new FileReader("theme.csv"));

		String SEPARATOR = ";";
		String line;

		while ((line = brTheme.readLine()) != null) {
			Theme theme = new Theme();
			String[] values = line.split(SEPARATOR);
			
			theme.setName(values[0]);
		}

		brTheme.close();
	}
}
