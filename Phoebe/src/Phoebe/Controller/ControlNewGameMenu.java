package Phoebe.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import Phoebe.gamepackage.Game;
import Phoebe.gui.PlayTheGame;
import Phoebe.gui.View;

public class ControlNewGameMenu {
	
	
	Control control;
	
	public ControlNewGameMenu(Control control) {
		this.control = control;
	}

	public void addNewGameMenuListener(){
		JButton newGameButton = View.getNewGameMenu().getBtn_loadmap();
		newGameButton.addActionListener(new LoadNewGameListener(View.getNewGameMenu().getComboBox()));
		JButton exit = View.getNewGameMenu().getBtn_exit();
		exit.addActionListener(new ExitListener());
	}
	

	   private class LoadNewGameListener implements ActionListener {

	        JComboBox<String> comboBox;
	        public LoadNewGameListener(JComboBox<String> comboBox) {
	            this.comboBox=comboBox;
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	// Azt majd meg kene csinalni hogy tobb palya kozul is lehessen valasztani, kezdetnek az is jo 
	        	// ha mar egyre mukodik.
	            String map = (String)comboBox.getSelectedItem();
	            
	            control.startNewGame();
	
	            View.PlayTheGame();
	        }
	    }
	   
	   private class ExitListener implements ActionListener{
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);
	        }
	    }
}
