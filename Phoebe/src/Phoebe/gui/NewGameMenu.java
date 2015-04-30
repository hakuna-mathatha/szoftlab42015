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

    private String[] maps ={"Pálya_1","Pálya_2","Pálya_3","Pálya_4","Pálya_5"};

    public NewGameMenu(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//        Pálya betöltése
        JPanel panel11 = new JPanel();
        panel11.setLayout(new FlowLayout());
        JComboBox comboBox = new JComboBox(maps);
        JButton btn_loadmap= new JButton("Betöltés");
        btn_loadmap.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel11.add(comboBox);
        panel11.add(btn_loadmap);
        panel.add(panel11);

        //      Kilépés gomb
        JButton btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn_exit);
        EmptyBorder border = new EmptyBorder(80, 0, 0, 0);
        panel.setBorder(border);

        super.add(panel, BorderLayout.CENTER);

        btn_loadmap.addActionListener(new NewGameListener(comboBox));
        btn_exit.addActionListener(new ExitListener());

    }
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class NewGameListener implements ActionListener {

        JComboBox comboBox;
        public NewGameListener(JComboBox comboBox) {
            this.comboBox=comboBox;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Main.PlayTheGame();
            String map = (String)comboBox.getSelectedItem();
        }
    }
}
