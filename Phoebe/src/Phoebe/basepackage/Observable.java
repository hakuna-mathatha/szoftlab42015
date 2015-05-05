package Phoebe.basepackage;

import Phoebe.painter.Observer;
import Phoebe.trackpackage.Coordinate;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class Observable {

    //megfigyelõ
    private Observer observer;

    //itt még nem tartozik hozzá megfigyelõ
    public Observable() { this.observer = null; }

    //paraméterként kapott emgfigyelõvel való összekapcsolás
    public void attachObserver(Observer observer) {
        this.observer = observer;
        this.observer.attachObservable(this);
    }

    //megfigyelõ leválasztása
    public void detachObserver() {
        this.observer.detachObservable();
        this.observer = null;
    }

}
