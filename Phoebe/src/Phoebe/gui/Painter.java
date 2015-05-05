package Phoebe.gui;

import Phoebe.basepackage.Observable;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public abstract class Painter extends Observer {

    //kirajzolandó kép
    protected Image image;

    //csak a kép elérési útjára van szükség
    public Painter(String imageUrl) { openPicture(imageUrl); }

    //kép betöltése
    protected void openPicture(String imageUrl) {
        image = Toolkit.getDefaultToolkit().getImage(imageUrl);
    }

    //konkrét rajzolásért felelõs metódus, a leszármazottak valósítják meg
    protected abstract void onPaint();
}
