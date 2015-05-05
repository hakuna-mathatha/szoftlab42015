package Phoebe.painter;

import Phoebe.basepackage.Observable;
import Phoebe.trackpackage.Coordinate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public abstract class Painter extends Observer {

    //kirajzolandó kép
    protected BufferedImage image;

    //csak a kép elérési útjára van szükség
    public Painter(String imageUrl) { openPicture(imageUrl); }

    //kép betöltése
    protected void openPicture(String imageUrl) {
        try {
            image = ImageIO.read(new File(imageUrl));
        }
        catch (IOException e) {
            System.out.println("Error at opening picture");
        }
    }

    //konkrét rajzolásért felelõs metódus, a leszármazottak valósítják meg
    public abstract void onPaint(Graphics g);
}
