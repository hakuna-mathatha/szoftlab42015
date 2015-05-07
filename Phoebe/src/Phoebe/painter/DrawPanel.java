package Phoebe.painter;
import Phoebe.gui.View;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Created by Zsuuuzsu on 2015.05.04..
 */
public class DrawPanel extends JPanel {
	private static View view;
	private BufferedImage background = null;

	 public static View getView() {
			return view;
		}

	public static void setView(View view) {
			DrawPanel.view = view;
		}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		view.drawImage(g);
    }
}
