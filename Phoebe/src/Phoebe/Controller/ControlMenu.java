package Phoebe.Controller;
import Phoebe.gui.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu {
	
	public void addMenuListener(){
		JButton exit = View.getMenu().getBtn_exit();
		exit.addActionListener(new ExitListener());
		JButton newGame = View.getMenu().getBtn_newgame();
		newGame.addActionListener(new NewGameListener());
	}

	private class ExitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class NewGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	View.newGame();
        }
    }
}
