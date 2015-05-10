package Phoebe.gui;
import Phoebe.painter.DrawPanel;
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
	private JLabel time;
    private JLabel oilRepo1;
    private JLabel oilRepo2;
    private JLabel puttyRepo1;
    private JLabel puttyRepo2;

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
        drawPanel.setBackground(new Color(0,153,0));
        drawPanel.setBorder(blackline);
        jPanel.add(drawPanel);

        //Repositorik
        JLabel player1 = new JLabel("Player1\n");
        player1.setAlignmentX(Component.CENTER_ALIGNMENT);
        oilRepo1 = new JLabel("Oil repository: 5");
        oilRepo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        puttyRepo1 = new JLabel("Putty repository: 5");
        puttyRepo1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel player2 = new JLabel("Player2");
        player2.setAlignmentX(Component.CENTER_ALIGNMENT);
        oilRepo2 = new JLabel("Oil repository: 5");
        oilRepo2.setAlignmentX(Component.CENTER_ALIGNMENT);
        puttyRepo2 = new JLabel("Putty repository: 5");
        puttyRepo2.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Time
        time = new JLabel("00:00");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        time.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Vegeredmenygomb
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        jPanel2.add(player1);
        jPanel2.add(oilRepo1);
        jPanel2.add(puttyRepo1);
        jPanel2.add(Box.createRigidArea(new Dimension(0,40)));
        jPanel2.add(player2);
        jPanel2.add(oilRepo2);
        jPanel2.add(puttyRepo2);
        jPanel2.add(Box.createRigidArea(new Dimension(0,100)));
        btn_score=new JButton("Végeredmény");
        btn_score.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel2.add(btn_score);

        //Kilepes gomb
        btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel2.add(btn_exit);
        jPanel2.add(time);
        jPanel.add(jPanel2);
        super.add(jPanel, CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public DrawPanel getDrawPanel() {
		return drawPanel;
	}
    
    public JLabel getTime() {
		return time;
	}

    public JLabel getOilRepo1() {return oilRepo1;}

    public JLabel getOilRepo2() {return oilRepo2;}

    public JLabel getPuttyRepo1() {return puttyRepo1;}

    public JLabel getPuttyRepo2() {return puttyRepo2;}

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


