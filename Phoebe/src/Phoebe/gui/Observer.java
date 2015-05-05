package Phoebe.gui;

import Phoebe.basepackage.Observable;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class Observer {

    //megfigyelt elem
    protected Observable observable;

    //itt még nem tartozik hozzá megfigyelt elem
    public Observer() { this.observable = null; }

    //hozzákapcsoljuk a paraméterként kapott elemet
    public void attachObservable(Observable observable) {
        this.observable = observable;
    }

    //leválasztjuk a megfigyelt elemet
    public void detachObservable() {
        observable = null;
    }

    //ha van megfigyelt eleme true-val tér vissza
    protected boolean hasObservable() {
        return (this.observable == null) ? false : true;
    }

    //megfigyelt elem lekérdezése
    protected Observable getObservable() {
        return this.observable;
    }

}
