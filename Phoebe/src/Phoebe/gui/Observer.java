package Phoebe.gui;

import Phoebe.basepackage.Observable;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class Observer {

    //megfigyelt elem
    protected Observable observable;

    //itt m�g nem tartozik hozz� megfigyelt elem
    public Observer() { this.observable = null; }

    //hozz�kapcsoljuk a param�terk�nt kapott elemet
    public void attachObservable(Observable observable) {
        this.observable = observable;
    }

    //lev�lasztjuk a megfigyelt elemet
    public void detachObservable() {
        observable = null;
    }

    //ha van megfigyelt eleme true-val t�r vissza
    protected boolean hasObservable() {
        return (this.observable == null) ? false : true;
    }

    //megfigyelt elem lek�rdez�se
    protected Observable getObservable() {
        return this.observable;
    }

}
