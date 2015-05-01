package Phoebe.gui;

import Phoebe.basepackage.Observable;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public abstract class Observer {

    protected Observable observable;

    public Observer(Observable observable) {
        this.observable = observable;
    }

    protected boolean hasObservable() {
        return (this.observable == null) ? false : true;
    }

    protected Observable getObservable() {
        return this.observable;
    }

    public void detachObservable() {
        observable = null;
    }

}
