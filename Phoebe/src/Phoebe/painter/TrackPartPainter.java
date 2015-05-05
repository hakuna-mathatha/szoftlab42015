package Phoebe.painter;

import Phoebe.basepackage.Observable;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;

import java.awt.*;

/**
 * Created by K�vesdi on 2015.05.05..
 */
public class TrackPartPainter extends Painter {

    //hozz�ad�s a View-beli trackPartPainters list�hoz
    public TrackPartPainter(String imageUrl) {
        super(imageUrl);
        View.getTrackPartPainters().add(this);
    }

    //konkr�t rajzol�s�rt felel�s met�dus
    public void onPaint(Graphics g) {
        //le kell k�rni a trackPart koordin�t�j�t �s rajzolni
    }
}
