package Phoebe.painter;

import Phoebe.gui.View;

/**
 * Created by Kövesdi on 2015.05.05..
 */
public class BotPainter extends BasePainter {

    //hozzáadás a View-beli BotPainters listához
    public BotPainter(String imageUrl) {
        super(imageUrl);
        View.getBotPainters().add(this);
    }
}
