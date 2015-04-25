package Phoebe.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peti on 2015.04.25..
 */
public class NewGameMenu extends JFrame {
    public NewGameMenu(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        Pálya betöltése
        JButton btn_loadmap= new JButton("Pálya betöltése");
        btn_loadmap.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn_loadmap);
        //      Kilépés gomb
        JButton btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn_exit);
        EmptyBorder border = new EmptyBorder(80, 0, 0, 0);
        panel.setBorder(border);

        super.add(panel, BorderLayout.CENTER);

        btn_loadmap.addActionListener(new NewGameListener());
        btn_exit.addActionListener(new ExitListener());

    }
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class NewGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.startGame();
        }
    }
}
