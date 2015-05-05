package Phoebe.painter;

import Phoebe.basepackage.Base;
import Phoebe.basepackage.Observable;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class BasePainter extends Painter {

    public BasePainter(String imageUrl) { super(imageUrl); }

    //elemeknek a középpontját tartjuk nyilván, ezért a képet el kell tolni balra és fel
    //képek egyforma méretûek, ezért lehet egységesen kezelni õket
    protected Coordinate calculatePicturePosition(Coordinate coordinate) {
//        Coordinate result = new Coordinate(coordinate.getX() - View.scale * 50, coordinate.getY() - View.scale * 50);
    	Coordinate result = new Coordinate(coordinate.getX() - image.getWidth() * View.scale*0.5/2, coordinate.getY() - image.getHeight() * View.scale*0.5/2);
        return result;
       
    }

    //konkrét rajzolásért felelõs metódus
    public void onPaint(Graphics g) {
        //le kell kérni a Base koordinátáját, számoltatni a calculatePicturePosition metódussal, majd rajzolni
    	Base b = (Base)observable;
    	Coordinate coord = calculatePicturePosition(b.getPosition());
    	
		g.drawImage(image, (int)coord.getX(), (int)coord.getY(), (int)(image.getWidth() * View.scale*0.5), (int)(image.getHeight() * View.scale*0.5), null);
    	
    }
}
