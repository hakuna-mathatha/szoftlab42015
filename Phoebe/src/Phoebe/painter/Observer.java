package Phoebe.painter;
import Phoebe.basepackage.Observable;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class Observer {

    //megfigyelt elem
    protected Observable observable;

    //itt meg nem tartozik hozza megfigyelt elem
    public Observer() { this.observable = null; }

    //hozzakapcsoljuk a parameterkent kapott elemet
    public void attachObservable(Observable observable) {
        this.observable = observable;
    }

    //levalasztjuk a megfigyelt elemet
    public void detachObservable() {
        observable = null;
    }

    //ha van megfigyelt eleme true-val ter vissza
    public boolean hasObservable() {
        return (this.observable == null) ? false : true;
    }

    //megfigyelt elem lekerdezese
    protected Observable getObservable() {
        return this.observable;
    }

}
