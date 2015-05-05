package Phoebe.gui;

import Phoebe.basepackage.Observable;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public abstract class Painter extends Observer {

    //kirajzoland� k�p
    protected Image image;

    //csak a k�p el�r�si �tj�ra van sz�ks�g
    public Painter(String imageUrl) { openPicture(imageUrl); }

    //k�p bet�lt�se
    protected void openPicture(String imageUrl) {
        image = Toolkit.getDefaultToolkit().getImage(imageUrl);
    }

    //konkr�t rajzol�s�rt felel�s met�dus, a lesz�rmazottak val�s�tj�k meg
    protected abstract void onPaint();
}
