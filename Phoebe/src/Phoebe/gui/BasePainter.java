package Phoebe.gui;

import Phoebe.basepackage.Observable;
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
        Coordinate result = new Coordinate(coordinate.getX() - View.scale * 50, coordinate.getY() + View.scale * 50);
        return result;
    }

    //konkr�t rajzol�s�rt felel�s met�dus
    protected void onPaint() {
        //le kell k�rni a Base koordin�t�j�t, sz�moltatni a calculatePicturePosition met�dussal, majd rajzolni
    }
}
