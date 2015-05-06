package Phoebe.painter;

import Phoebe.gui.View;
import Phoebe.trackpackage.JumpablePart;

import java.awt.*;

/**
 * Created by K�vesdi on 2015.05.05..
 */
public class TrackPartPainter extends Painter {

	// hozz�ad�s a View-beli trackPartPainters list�hoz
	public TrackPartPainter(String imageUrl) {
		super(imageUrl);
//		 this.observable = observable;
		View.getTrackPartPainters().add(this);
	}

	// konkr�t rajzol�s�rt felel�s met�dus
	public void onPaint(Graphics g) {
		JumpablePart j = (JumpablePart) observable;
		double x = j.getPosition().getX();
		double y = j.getPosition().getY();
		double height = j.getHeight();
		double width = j.getWidth();

        g.drawImage(image, (int)x, (int)y, (int)width,(int)height, null);

		//Graphics2D g2 = (Graphics2D) g;
		//g2.draw(new Rectangle2D.Double(x, y, width, height));

	}
}
