package Phoebe.painter;

import Phoebe.basepackage.Observable;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by Kövesdi on 2015.05.05..
 */
public class TrackPartPainter extends Painter {

    //hozzáadás a View-beli trackPartPainters listához
    public TrackPartPainter(String imageUrl) {
        super(imageUrl);
        View.getTrackPartPainters().add(this);
    }

    //konkrét rajzolásért felelõs metódus
    public void onPaint(Graphics g) {
        //le kell kérni a trackPart koordinátáját és rajzolni
    }
}
