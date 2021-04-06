package main;

import javax.swing.JOptionPane;

import list.List;
import models.Client;
import models.Rent;
import models.Theme;

public final class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Client> clietList = new List<Client>();
		List<Theme> themeList = new List<Theme>();
		List<Rent> rentList = new List<Rent>();

		clietList.addAtBeginning(null);
		themeList.addAtBeginning(null);
		rentList.addAtBeginning(null);

		int option = Integer.parseInt(JOptionPane.showInputDialog("1 - adicionar cliente \n 9 - Sair"));

		do {
			switch (option) {
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor inválido");

			}
		} while (option != 9);

	}

}
