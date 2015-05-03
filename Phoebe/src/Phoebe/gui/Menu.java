package Phoebe.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peti on 2015.04.25..
 */
public class Menu extends JFrame {
    public Menu(String title) {
//      Megjelenés
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        setResizable(false);

        JPanel panel = new JPanel();
//      Új játék gomb
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton btn_newgame= new JButton("Új játék");
        btn_newgame.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn_newgame);
//      Kilépés gomb
        JButton btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn_exit);
        EmptyBorder border = new EmptyBorder(80, 0, 0, 0);
        panel.setBorder(border);

        super.add(panel, BorderLayout.CENTER);

//      Gomb listenerek
        btn_exit.addActionListener(new ExitListener());
        btn_newgame.addActionListener(new NewGameListener());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
//            Main.newGame();
        	View.newGame();
        }
    }
}
