package main;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.Controller;

public final class Main {

	public static void main(String[] args) throws IOException {

		Controller controller = new Controller();

		String userOptions = "1 - Adicionar cliente \n2 - Excluir cliente \n4 - Adicionar tema \n5 - Excluir tema \n7 - Adicionar aluguel \n8 - Excluir aluguel \n10 - Salvar dados \n11 - Sair";
		int option = Integer.parseInt(JOptionPane.showInputDialog(userOptions));

		while (option != 11) {
			switch (option) {
			case 1:
				controller.addNewClient();
				break;
			case 2:
				controller.removeClient();
				break;
			case 3:
				// alterar
				break;
			case 4:
				controller.addNewTheme();
				break;
			case 5:
				controller.removeTheme();
				break;
			case 6:
				// alterar
				break;
			case 7:
				controller.addNewRent();
				break;
			case 8:
				controller.removeRent();
				break;
			case 10:
				controller.createLocalFiles();
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
