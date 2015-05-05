package Phoebe.painter;


import javax.swing.*;

import Phoebe.gui.View;

import java.awt.*;

/**
 * Created by Zsuuuzsu on 2015.05.04..
 */
public class DrawPanel extends JPanel {

	private static View view;
	
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
