package Phoebe.gui;

/**
 * Created by K�vesdi on 2015.05.05..
 */
public class BotPainter extends BasePainter {

    //hozz�ad�s a View-beli BotPainters list�hoz
    public BotPainter(String imageUrl) {
        super(imageUrl);
        View.botPainters.add(this);
    }
}
