package Phoebe.gui;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Zsuuuzsu on 2015.05.04..
 */
public class DrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //csak kiprobaltam
        g.setColor(Color.CYAN);
        g.fillRect(10, 10, 100, 200);

        for(int i = 0; i<View.botPainters.size(); i++){
            View.drawImage();
        }
    }
}
