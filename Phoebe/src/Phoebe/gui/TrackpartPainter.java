package Phoebe.gui;

import Phoebe.basepackage.Observable;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class TrackpartPainter extends Painter {

    public TrackpartPainter(Observable observable, String imageUrl) {
        super(observable, 100, imageUrl);
        this.observable.attachObserver(this);
    }

}
