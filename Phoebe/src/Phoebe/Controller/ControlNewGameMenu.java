package Phoebe.Controller;

import Phoebe.gui.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNewGameMenu {
	Control control;

	public ControlNewGameMenu(Control control) {
		this.control = control;
	}

	public void addNewGameMenuListener() {
		JButton newGameButton = View.getNewGameMenu().getBtn_loadmap();
		newGameButton.addActionListener(new LoadNewGameListener(View.getNewGameMenu().getComboBox()));
		JButton exit = View.getNewGameMenu().getBtn_exit();
		exit.addActionListener(new ExitListener());
	}

	private class LoadNewGameListener implements ActionListener {

		JComboBox<String> comboBox;

		public LoadNewGameListener(JComboBox<String> comboBox) {
			this.comboBox = comboBox;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int index = comboBox.getSelectedIndex();
			control.startNewGame(index);
			View.PlayTheGame();
			View.getDrawPanel().repaint();
		}
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
