package Phoebe.painter;
import Phoebe.gui.View;
/**
 * Created by K�vesdi on 2015.05.05..
 */
public class BotPainter extends BasePainter {

    //hozzaadas a View-beli BotPainters listahoz
    public BotPainter(String imageUrl) {
        super(imageUrl);
        View.addToBotPainters(this);
    }
}
