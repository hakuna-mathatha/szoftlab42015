package Phoebe.painter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import Phoebe.basepackage.Observable;
import Phoebe.gamepackage.Robot;

/**
 * Created by Kövesdi on 2015.05.01.. COULD BE USED FOR ALL ROBOT TYPES
 */
public class RobotPainter extends BotPainter {

	public RobotPainter(String imageUrl) {
		super(imageUrl);
		this.observable = observable;
//		this.observable.attachObserver(this);
		
	}
	
	
	public void onPaint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
		// g2.draw(new Line2D.Double(0,0,100,100));
		Robot robot = (Robot)observable;

		g2.draw(new Line2D.Double(robot.getPosition().getX(), robot.getPosition().getY(), robot.getNextPosition()
				.getX(), robot.getNextPosition().getY()));
		
//		Toolkit.getDefaultToolkit().sync();
		
		g2.setColor(Color.BLUE);
		g2.draw(new Ellipse2D.Double(robot.getPosition().getX()-5,robot.getPosition().getY()-5, 10, 10));
		g2.setColor(Color.RED);
		g2.draw(new Ellipse2D.Double(robot.getNextPosition().getX()-5, robot.getNextPosition().getY()-5, 10, 10));
	}
}
