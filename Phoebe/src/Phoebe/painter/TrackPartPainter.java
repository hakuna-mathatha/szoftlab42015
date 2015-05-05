package Phoebe.painter;

import Phoebe.basepackage.Observable;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.TrackPart;

import java.awt.*;

/**
 * Created by Kövesdi on 2015.05.05..
 */
public class TrackPartPainter extends Painter {

    //hozzáadás a View-beli trackPartPainters listához
    public TrackPartPainter(String imageUrl) {
        super(imageUrl);
        View.addToTrackPartPainters(this);
    }

    //konkrét rajzolásért felelõs metódus
    public void onPaint(Graphics g) {
        TrackPart trackPart = (TrackPart)observable;
        g.drawImage(image, (int)trackPart.getPosition().getX(), (int)trackPart.getPosition().getY(), (int)trackPart.getWidth(), (int)trackPart.getHeight(), null);
    }
}
