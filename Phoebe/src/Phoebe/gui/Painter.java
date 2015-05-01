package Phoebe.gui;

import Phoebe.basepackage.Observable;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class Painter extends Observer {

    protected Image image;
    protected int scale;

    public Painter(Observable observable, int scale, String imageUrl) {
        super(observable);
        this.scale = scale;
        openPicture(imageUrl);
        View.addToList(this);
    }

    protected void openPicture(String imageUrl) {
        image = Toolkit.getDefaultToolkit().getImage(imageUrl);
    }

    protected Coordinate calculatePicturePosition(Coordinate coordinate) {
        Coordinate result = new Coordinate(coordinate.getX() - scale * 50, coordinate.getY() + scale * 50);
        return result;
    }

    protected void onPaint() {}

}
