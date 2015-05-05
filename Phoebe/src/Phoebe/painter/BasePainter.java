package Phoebe.painter;

import Phoebe.basepackage.Base;
import Phoebe.basepackage.Observable;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class BasePainter extends Painter {

    public BasePainter(String imageUrl) { super(imageUrl); }

    //elemeknek a k�z�ppontj�t tartjuk nyilv�n, ez�rt a k�pet el kell tolni balra �s fel
    //k�pek egyforma m�ret�ek, ez�rt lehet egys�gesen kezelni �ket
    protected Coordinate calculatePicturePosition(Coordinate coordinate) {
//        Coordinate result = new Coordinate(coordinate.getX() - View.scale * 50, coordinate.getY() - View.scale * 50);
    	Coordinate result = new Coordinate(coordinate.getX() - image.getWidth() * View.scale*0.5/2, coordinate.getY() - image.getHeight() * View.scale*0.5/2);
        return result;
       
    }

    //konkr�t rajzol�s�rt felel�s met�dus
    public void onPaint(Graphics g) {
        //le kell k�rni a Base koordin�t�j�t, sz�moltatni a calculatePicturePosition met�dussal, majd rajzolni
    	Base b = (Base)observable;
    	Coordinate coord = calculatePicturePosition(b.getPosition());
    	
		g.drawImage(image, (int)coord.getX(), (int)coord.getY(), (int)(image.getWidth() * View.scale*0.5), (int)(image.getHeight() * View.scale*0.5), null);
    	
    }
}
