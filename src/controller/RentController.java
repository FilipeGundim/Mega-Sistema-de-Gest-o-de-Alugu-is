package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;

import list.List;
import models.Rent;
import models.Theme;

public class RentController {
	private List<Rent> rentList = new List<Rent>();
	private static String SEPARATOR = ";";

	public RentController() throws IOException, ParseException {
		this.readAndStore();
	}

	public void addNew() {
		Rent rent = new Rent();
		rent.setDate(JOptionPane.showInputDialog("Informe a data"));

		// TODO
		// filtrar os valores atuais da lista com a data informada

		Theme theme = new Theme();
		theme.setName(JOptionPane.showInputDialog("Informe o tema"));

		// TODO
		// filtrar os valores atuais da lista com a data informada

		// SE os vallores de temas filtrados .lenght for maior que 0 retornar erro
		// SE NÃO prosseguir com o aluguel
		rent.setAddress(JOptionPane.showInputDialog("Informe o endereço"));

		// TODO
		// receber codigo do cliente associado ao aluguel

		rent.setTheme(null);
		rentList.addAtBeginning(rent);
	}

	public void remove() {
		int position = Integer.parseInt(JOptionPane
				.showInputDialog(rentList.showListValues() + "\n Digite a posição do cliente que deseja remover"));
		rentList.removeInAnyPosition(position);
	}

	public void createLocalFiles() throws IOException {
		BufferedWriter fwRent = new BufferedWriter(new FileWriter("rent.csv"));

		fwRent.write(rentList.showListValues());
		fwRent.newLine();
		fwRent.close();
	}

	private void readAndStore() throws IOException {
		BufferedReader brRent = new BufferedReader(new FileReader("rent.csv"));

		String line;

		while ((line = brRent.readLine()) != null) {

			Rent rent = new Rent();
			Theme theme = new Theme();
			String[] values = line.split(SEPARATOR);

			theme.setName(values[0]);
			rent.setTheme(theme);
		//	rent.setAddress(values[2]);
			rent.setDate(values[0]);
			this.rentList.addAtEnd(rent);
		}

		brRent.close();
	}
}
