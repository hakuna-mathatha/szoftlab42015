package Phoebe.gui;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import static java.awt.BorderLayout.CENTER;

/**
 * Created by Zsuuuzsu on 2015.04.30..
 */
public class PlayTheGame extends JFrame{
	private JPanel jPanel;
	private JButton btn_score;
	private DrawPanel drawPanel;

	private JButton btn_exit;
    //Ez lenne ahol megy a jatek
    public PlayTheGame(String title){
        super(title);
     
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setResizable(false);

        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));

        //Jatekter
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.BLACK);
        drawPanel = new DrawPanel();
        

        drawPanel.setBorder(blackline);
        jPanel.add(drawPanel);

        //Vegeredmenygomb
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        btn_score=new JButton("Végeredmény");
        btn_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel2.add(btn_score);
        //Kilepes gomb
        btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel2.add(btn_exit);
        jPanel.add(jPanel2);
        
        super.add(jPanel, CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public void setDrawPanel(DrawPanel jPanel1) {
		this.drawPanel = jPanel1;
	}
    


    
    public JButton getBtn_score() {
		return btn_score;
	}



	public void setBtn_score(JButton btn_score) {
		this.btn_score = btn_score;
	}



	public JButton getBtn_exit() {
		return btn_exit;
	}



	public void setBtn_exit(JButton btn_exit) {
		this.btn_exit = btn_exit;
	}

    
    public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

}


