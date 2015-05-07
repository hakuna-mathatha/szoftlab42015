package Phoebe.basepackage;

import Phoebe.painter.Observer;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class Observable {
    private Observer observer;  //megfigyelo

    //itt meg nem tartozik hozza megfigyelo
    public Observable() { this.observer = null; }

    //parameterkent kapott megfigyelovel valo osszekapcsolas
    public void attachObserver(Observer observer) {
        this.observer = observer;
        this.observer.attachObservable(this);
    }

    //megfigyelo levalasztasa
    public void detachObserver() {
    	System.out.println("Detach call*************************************************************"); //majd kivenni ha nem kell
        this.observer.detachObservable();
        this.observer = null;
    }

}
