package Phoebe.painter;

import Phoebe.basepackage.Base;
import Phoebe.gamepackage.Robot;
import Phoebe.gui.View;
import Phoebe.trackpackage.Coordinate;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Created by K�vesdi on 2015.05.01.. COULD BE USED FOR ALL ROBOT TYPES
 */
public class RobotPainter extends BotPainter {

	public RobotPainter(String imageUrl) {
		super(imageUrl);
	}

	public void onPaint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		Robot robot = (Robot) observable;
		g2.draw(new Line2D.Double(robot.getPosition().getX(), robot.getPosition().getY(), robot.getNextPosition()
				.getX(), robot.getNextPosition().getY()));

		Ellipse2D ellipse = new Ellipse2D.Double(robot.getNextPosition().getX() - 5,
				robot.getNextPosition().getY() - 5, 10, 10);
		g2.setColor(Color.RED);
		g2.fill(ellipse);
		Base b = (Base) observable;
		Coordinate coord = calculatePicturePosition(b.getPosition());
		g.drawImage(image, (int) coord.getX(), (int) coord.getY(), (int) (image.getWidth() * View.scale * 0.5),
				(int) (image.getHeight() * View.scale * 0.5), null);

	}
}
