package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import list.List;
import models.Theme;

public class ThemeController {
	private List<Theme> themeList = new List<Theme>();
	private static String SEPARATOR = ";";

	public ThemeController() throws IOException, ParseException {
		this.readAndStore();
	}

	public void addNew() {
		Theme theme = new Theme();
		theme.setName(JOptionPane.showInputDialog("Informe o nome do tema"));
		themeList.addAtBeginning(theme);
	}

	public void remove() {
		int position = Integer.parseInt(JOptionPane
				.showInputDialog(themeList.showListValues() + "\n Digite a posição do tema que deseja remover"));
		themeList.removeInAnyPosition(position);
	}


	public void createLocalFiles() throws IOException {
		BufferedWriter fwTheme = new BufferedWriter(new FileWriter("themes.csv"));

		fwTheme.write(themeList.showListValues());
		fwTheme.newLine();
		fwTheme.close();
	}


	private void readAndStore() throws IOException {
		BufferedReader brTheme = new BufferedReader(new FileReader("themes.csv"));
		
		String line;

		while ((line = brTheme.readLine()) != null) {
			Theme theme = new Theme();
			String[] values = line.split(SEPARATOR);

			theme.setName(values[0]);
			this.themeList.addAtEnd(theme);
		}

		brTheme.close();
	}
}
