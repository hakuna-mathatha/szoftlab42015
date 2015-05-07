package Phoebe.Controller;
import Phoebe.gui.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlScore {
	
	public void addScoreListener(){
		JButton exit = View.getScore().getBtn_exit();
		exit.addActionListener(new ExitListener());
		JButton back = View.getScore().getBtn_back();
		back.addActionListener(new BackListener());
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class BackListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			View.backToMainMenu();
		}
	}
}
