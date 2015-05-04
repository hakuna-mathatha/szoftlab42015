package Phoebe.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peti on 2015.04.25..
 */
public class Score extends JFrame {
	private JButton btn_back;
	private JButton btn_exit;
    
	public Score(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel panel11 = new JPanel();
        panel11.setLayout(new FlowLayout());
        JLabel player1 = new JLabel("Player1");
        JLabel player1_score = new JLabel("125");
        panel11.add(player1);
        panel11.add(player1_score);

        JPanel panel12 = new JPanel();
        panel12.setLayout(new FlowLayout());
        JLabel player2 = new JLabel("Player2");
        JLabel player2_score = new JLabel("200");
        panel12.add(player2);
        panel12.add(player2_score);

        JPanel panel13 = new JPanel();
        panel13.setLayout(new FlowLayout());
        btn_back= new JButton("Vissza a főmenübe");
        btn_back.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel13.add(btn_back);
        // Kilépés gomb
        btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel13.add(btn_exit);

        panel.add(panel11);
        panel.add(panel12);
        panel.add(panel13);

        EmptyBorder border = new EmptyBorder(40, 0, 0, 0);
        panel.setBorder(border);

        super.add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	public JButton getBtn_back() {
		return btn_back;
	}
	public void setBtn_back(JButton btn_back) {
		this.btn_back = btn_back;
	}
	public JButton getBtn_exit() {
		return btn_exit;
	}
	public void setBtn_exit(JButton btn_exit) {
		this.btn_exit = btn_exit;
	}



}
