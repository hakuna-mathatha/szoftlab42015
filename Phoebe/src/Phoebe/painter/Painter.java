package Phoebe.painter;

import Phoebe.basepackage.Observable;
import Phoebe.trackpackage.Coordinate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public abstract class Painter extends Observer {

    //kirajzoland� k�p
    protected BufferedImage image;

    //csak a k�p el�r�si �tj�ra van sz�ks�g
    public Painter(String imageUrl) { openPicture(imageUrl); }

    //k�p bet�lt�se
    protected void openPicture(String imageUrl) {
        try {
            image = ImageIO.read(new File(imageUrl));
        }
        catch (IOException e) {
        }
    }

    //konkr�t rajzol�s�rt felel�s met�dus, a lesz�rmazottak val�s�tj�k meg
    public abstract void onPaint(Graphics g);
}
