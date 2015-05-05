package Phoebe.painter;

import Phoebe.gui.View;

/**
 * Created by Kövesdi on 2015.05.05..
 */
public class BarrierPainter extends BasePainter {

    //hozzáadás a View-beli barrierPainters listához
    public BarrierPainter(String imageUrl) {
        super(imageUrl);
        View.getBarrierPainters().add(this);
    }
}
