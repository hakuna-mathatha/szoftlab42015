package Phoebe.painter;
import Phoebe.gui.View;

/**
 * Created by K�vesdi on 2015.05.05..
 */
public class BarrierPainter extends BasePainter {

    //hozzaadas a View-beli barrierPainters listahoz
    public BarrierPainter(String imageUrl) {
        super(imageUrl);
        View.addToBarrierPainters(this);
    }
}
