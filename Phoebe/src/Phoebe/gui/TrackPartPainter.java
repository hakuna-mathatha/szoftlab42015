package Phoebe.gui;

import Phoebe.basepackage.Observable;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by Kövesdi on 2015.05.05..
 */
public class TrackPartPainter extends Painter {

    //hozzáadás a View-beli trackPartPainters listához
    public TrackPartPainter(String imageUrl) {
        super(imageUrl);
        View.trackPartPainters.add(this);
    }

    //konkrét rajzolásért felelõs metódus
    protected void onPaint() {
        //le kell kérni a trackPart koordinátáját és rajzolni
    }
}
