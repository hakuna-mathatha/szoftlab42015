package Phoebe.gui;

/**
 * Created by K�vesdi on 2015.05.05..
 */
public class BarrierPainter extends BasePainter {

    //hozz�ad�s a View-beli barrierPainters list�hoz
    public BarrierPainter(String imageUrl) {
        super(imageUrl);
        View.barrierPainters.add(this);
    }
}
