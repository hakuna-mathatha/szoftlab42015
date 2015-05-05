package Phoebe.painter;

import Phoebe.basepackage.Observable;
import Phoebe.gamepackage.Robot;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.JumpablePart;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Kövesdi on 2015.05.05..
 */
public class TrackPartPainter extends Painter {

	// hozzáadás a View-beli trackPartPainters listához
	public TrackPartPainter(String imageUrl) {
		super(imageUrl);
		// this.observable = observable;
//		View.getTrackPartPainters().add(this);
	}

	// konkrét rajzolásért felelõs metódus
	public void onPaint(Graphics g) {

		System.out.println("pppppppppppppppppppppppppppppppp");
		JumpablePart j = (JumpablePart) observable;
		double x = j.getPosition().getX();
		double y = j.getPosition().getY();
		double hight = j.getHeight();
		double width = j.getWidth();

		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Rectangle2D.Double(x, y, width, hight));

	}
}
