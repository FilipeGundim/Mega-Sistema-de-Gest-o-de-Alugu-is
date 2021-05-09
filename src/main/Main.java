package main;

import java.io.IOException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import controller.ClientController;
import controller.RentController;
import controller.ThemeController;

public final class Main {

	public static void main(String[] args) throws IOException, ParseException {
		ClientController clientController = new ClientController();
		RentController rentController = new RentController();
		ThemeController themeController = new ThemeController();

		String userOptions = "1 - Adicionar cliente \n2 - Excluir cliente \n4 - Adicionar tema \n5 - Excluir tema \n7 - Adicionar aluguel \n8 - Excluir aluguel \n10 - Salvar dados \n11 - Sair";
		int option = Integer.parseInt(JOptionPane.showInputDialog(userOptions));

		while (option != 11) {
			switch (option) {
			case 1:
				clientController.addNew();
				break;
			case 2:
				clientController.remove();
				break;
			case 3:
				// alterar
				break;
			case 4:
				themeController.addNew();
				break;
			case 5:
				themeController.remove();
				break;
			case 6:
				// alterar
				break;
			case 7:
				rentController.addNew();
				break;
			case 8:
				rentController.remove();
				break;
			case 10:
				rentController.createLocalFiles();
				break;
			case 11:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor inválido");
			}
			option = Integer.parseInt(JOptionPane.showInputDialog(userOptions));
		}
	}
}
