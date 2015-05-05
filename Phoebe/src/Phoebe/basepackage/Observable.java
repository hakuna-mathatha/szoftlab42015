package Phoebe.basepackage;

import Phoebe.trackpackage.Coordinate;
import Phoebe.gui.Observer;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class Observable {

    //megfigyel�
    private Observer observer;

    //itt m�g nem tartozik hozz� megfigyel�
    public Observable() { this.observer = null; }

    //param�terk�nt kapott emgfigyel�vel val� �sszekapcsol�s
    public void attachObserver(Observer observer) {
        this.observer = observer;
        this.observer.attachObservable(this);
    }

    //megfigyel� lev�laszt�sa
    public void detachObserver() {
        this.observer.detachObservable();
        this.observer = null;
    }

}
