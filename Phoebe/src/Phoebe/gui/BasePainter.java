package Phoebe.gui;

import Phoebe.basepackage.Observable;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class BasePainter extends Painter {

    public BasePainter(Observable observable, String imageUrl) {
        super(observable, 100, imageUrl);
        this.observable.attachObserver(this);
    }

}
