package Phoebe.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

/**
 * Created by Zsuuuzsu on 2015.04.30..
 */
public class PlayTheGame extends JFrame{

    //Ez lenne ahol megy a jatek
    public PlayTheGame(String title){
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setResizable(false);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        //Jatekter
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.BLACK);
        JPanel jPanel1 = new JPanel();

        jPanel1.setBorder(blackline);
        jPanel.add(jPanel1);

        //Vegeredmenygomb
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        JButton btn_score=new JButton("Végeredmény");
        btn_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_score.addActionListener(new ScoreListener());
        jPanel2.add(btn_score);
        //Kilepes gomb
        JButton btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn_exit.addActionListener(new ExitListener());
        jPanel2.add(btn_exit);

        jPanel.add(jPanel2);

        super.add(jPanel, CENTER);
    }
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {System.exit(0);}
    }

    private class ScoreListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {Main.scoreGame();}

    }





}


