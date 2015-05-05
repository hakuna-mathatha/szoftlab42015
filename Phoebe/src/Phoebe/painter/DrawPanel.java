package Phoebe.painter;


import javax.imageio.ImageIO;
import javax.swing.*;

import Phoebe.gui.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

//		if(background == null) {
//			try {
//				background = ImageIO.read(new File(System.getProperty("user.dir") + "\\resources\\edge_v1.png"));
//			}
//			catch (IOException e) {
//			}
//		}
//		g.drawImage(background, 0, 0, 600, 600, null);

		view.drawImage(g);
    }
}
