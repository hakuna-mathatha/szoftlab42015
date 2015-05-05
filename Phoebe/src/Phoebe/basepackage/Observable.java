package Phoebe.basepackage;

import Phoebe.painter.Observer;
import Phoebe.trackpackage.Coordinate;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class Observable {

    private Observer observer;

    public void attachObserver(Observer observer) {
        this.observer = observer;
    }

    public void detachObserver(Observer observer) {
        this.observer.detachObservable();
        this.observer = null;
    }

}
