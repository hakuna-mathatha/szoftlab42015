package Phoebe.gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Peti on 2015.04.25..
 */
public class Menu extends JFrame {
	JButton btn_newgame;
	JButton btn_exit;
    public Menu(String title) {
//      Megjelenés
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 250);
        setResizable(false);
        JPanel panel = new JPanel();
//      Új játék gomb
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        btn_newgame= new JButton("Új játék");
        btn_newgame.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn_newgame);
//      Kilépés gomb
        btn_exit=new JButton("Kilépés");
        btn_exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btn_exit);
        EmptyBorder border = new EmptyBorder(80, 0, 0, 0);
        panel.setBorder(border);
        super.add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
	public JButton getBtn_newgame() {
		return btn_newgame;
	}
	public void setBtn_newgame(JButton btn_newgame) {
		this.btn_newgame = btn_newgame;
	}
	public JButton getBtn_exit() {
		return btn_exit;
	}
	public void setBtn_exit(JButton btn_exit) {
		this.btn_exit = btn_exit;
	}
}
