package Phoebe.gui;


import javax.swing.*;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * Created by Zsuuuzsu on 2015.05.04..
 */
public class DrawPanel extends JPanel {
	private static int x = 10;
	private static int y = 10;
	private static View view;

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    	View.getDrawPanel().setDoubleBuffered(true);
//        csak kiprobaltam
//        g.setColor(Color.CYAN);
//        g.fillRect(x, y, 100, 200);
      
        
//        g.drawLine(10, 10, x, y);
//        
//        x+=5;
//        y+=5;
        

//        for(int i = 0; i<View.painters.size(); i++){
//            View.drawImage();
//        }
    	
    	view.drawImage(g);
    }
    
    
    
    public void update(Graphics g) {
    	
    	   paintComponent(g);
    }
    
	
    public static View getView() {
		return view;
	}



	public static void setView(View view) {
		DrawPanel.view = view;
	}



}
