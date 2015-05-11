package Phoebe.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * Created by Peti on 2015.04.25..
 */
public class NewGameMenu extends JFrame {

	private String[] maps = { "Pálya_1", "Pálya_2" };
	JButton btn_loadmap;
	JComboBox<String> comboBox;
	JButton btn_exit;

	public NewGameMenu(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 250);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// Pálya betöltése
		JPanel panel11 = new JPanel();
		panel11.setLayout(new FlowLayout());
		comboBox = new JComboBox<String>(maps);
		btn_loadmap = new JButton("Load Map");
		btn_loadmap.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel11.add(comboBox);
		panel11.add(btn_loadmap);
		panel.add(panel11);

		// Kilépés gomb
		btn_exit = new JButton("Exit");
		btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btn_exit);
		EmptyBorder border = new EmptyBorder(80, 0, 0, 0);
		panel.setBorder(border);
		super.add(panel, BorderLayout.CENTER);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton getBtn_exit() {
		return btn_exit;
	}

	public void setBtn_exit(JButton btn_exit) {
		this.btn_exit = btn_exit;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getBtn_loadmap() {
		return btn_loadmap;
	}

	public void setBtn_loadmap(JButton btn_loadmap) {
		this.btn_loadmap = btn_loadmap;
	}

}
