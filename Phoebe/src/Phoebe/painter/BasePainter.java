package Phoebe.painter;

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
        Coordinate result = new Coordinate(coordinate.getX() - View.scale * 50, coordinate.getY() + View.scale * 50);
        return result;
    }

    //konkrét rajzolásért felelõs metódus
    public void onPaint(Graphics g) {
        //le kell kérni a Base koordinátáját, számoltatni a calculatePicturePosition metódussal, majd rajzolni
    }
}
