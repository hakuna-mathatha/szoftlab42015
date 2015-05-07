package Phoebe.painter;
import Phoebe.basepackage.Base;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;
import java.awt.*;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class BasePainter extends Painter {

    public BasePainter(String imageUrl) { super(imageUrl); }

    //elemeknek a kozeppontjat tartjuk nyilvan, ezert a kepet el kell tolni balra es fel
    //kepek egyforma meretuek, ezert lehet egysegesen kezelni oket
    protected Coordinate calculatePicturePosition(Coordinate coordinate) {
    	Coordinate result = new Coordinate(coordinate.getX() - image.getWidth() * View.scale*0.5/2, coordinate.getY() - image.getHeight() * View.scale*0.5/2);
        return result;
    }

    //konkret kirajzolasert felelos metodus
    public void onPaint(Graphics g) {
    	Base b = (Base)observable;
    	Coordinate coord = calculatePicturePosition(b.getPosition());
		g.drawImage(image, (int)coord.getX(), (int)coord.getY(), (int)(image.getWidth() * View.scale*0.5), (int)(image.getHeight() * View.scale*0.5), null);
    }
}
