package Phoebe.painter;
import Phoebe.gui.View;
import Phoebe.trackpackage.JumpablePart;
import java.awt.*;
/**
 * Created by K�vesdi on 2015.05.05..
 */
public class TrackPartPainter extends Painter {

	// hozzaadas a View-beli trackPartPainters listahoz
	public TrackPartPainter(String imageUrl) {
		super(imageUrl);
		View.getTrackPartPainters().add(this);
	}

	// konkrer kirajzolasert felelos metodus
	public void onPaint(Graphics g) {
		JumpablePart j = (JumpablePart) observable;
		double x = j.getPosition().getX();
		double y = j.getPosition().getY();
		double height = j.getHeight();
		double width = j.getWidth();
        g.drawImage(image, (int)x, (int)y, (int)width,(int)height, null);
	}
}
