package Phoebe.gamepackage;

import Phoebe.basepackage.Base;
import Phoebe.basepackage.BaseType;
import Phoebe.painter.CleanerPainter;
import Phoebe.trackpackage.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CleanerRobot extends Bot {
	private Barrier nearestBarrier;
	private boolean nearestBarrierExist;
	private Coordinate purpose;
	private static Object o = new Object();
	private Coordinate point;

	public CleanerRobot(Coordinate position1, Displacement disp1, Coordinate lastpos1) {
		displacement = disp1;
		state = RobotState.pure;
		nextPosition = new Coordinate(0, 1); // legyen a kiindulo ponttal azonos
		position = position1;
		lastPosition = lastpos1;
		type = BaseType.cleanerRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.ray = 30;
		// Painter hozzaadasa
		CleanerPainter cleanerPainter = new CleanerPainter(System.getProperty("user.dir")
				+ "\\resources\\cleaner1_v1.png");
		attachObserver(cleanerPainter);
	}

	public CleanerRobot() {
		displacement = new Displacement(2, 1);
		state = RobotState.pure;
		nextPosition = new Coordinate(480, 480); // legyen a kiindulo ponttal
													// azonos
		position = new Coordinate(420, 420);
		lastPosition = new Coordinate(310, 310);
		type = BaseType.cleanerRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.ray = 30;
		point = new Coordinate();
		point = position;
		// Painter hozzaadasa
		CleanerPainter cleanerPainter = new CleanerPainter(System.getProperty("user.dir")
				+ "\\resources\\cleaner1_v1.png");
		attachObserver(cleanerPainter);
	}

	public Barrier getNearestBarrier() {
		return nearestBarrier;
	}

	public void setNearestBarrier(Barrier nearestBarrier) {
		this.nearestBarrier = nearestBarrier;
	}

	public void selectNearestBarrier(Track aTrack) {
		List<JumpablePart> list = aTrack.getTrackParts();
		double distance = 10000;
		Barrier barrier = null;

		for (JumpablePart parts : list) {
			// System.out.println("Basek "+ parts.getBases().size()); //kivenni
			for (Base base : parts.getBases()) {
				double tmp = Math.sqrt(Math.pow((position.getX() - base.getPosition().getX()), 2)
						+ Math.pow((position.getY() - base.getPosition().getY()), 2));
				if (tmp < distance && (base.getType().equals(BaseType.oil) || base.getType().equals(BaseType.putty))) {
					distance = tmp;
					nearestBarrierExist = true;
					barrier = (Barrier) base;
				}
			}
		}
		nearestBarrier = barrier;
	}

	public void stepOn(Bot aBot) {
		if (aBot.getType().equals(BaseType.normalRobot)) {
			synchronized (o) {
				aBot.setState(RobotState.active);
				trackPart.addBase(new Oil(position, trackPart), position);
				this.state = RobotState.died;
				clean();
			}
		} else if (aBot.getType().equals(BaseType.cleanerRobot)) {
			Displacement disp = new Displacement();
			disp = aBot.getDisplacement();
			double velocity = aBot.getDisplacement().getVelocity();
			disp.setVelocity(velocity * (-1));
			aBot.setDisplacement(disp);
		}
	}

	public void jump(Track aTrack) {
		// System.out.println("Cleaner jump");
		synchronized (o) {
			setState(RobotState.jump);
			decideTheDirection(aTrack);
			setLastPosition(position);
			setPosition(nextPosition);
			trackPart.removeFromTrackPart(this);
			TrackPart part = aTrack.findAPart(position);
			this.setTrackPart(part);
			Base b = giveMeTheBase(position, part);
			part.addBase(this, position);
			getTheEffectForRobot(b);
		}
	}

	public boolean isItJumpable(Track aTrack, Coordinate coord) {
		if ((!(aTrack.findAPart(coord).getBase(coord).getType().equals(BaseType.edge)))) {

			// this.displacement.setAngle(2);
			// displacement.setVelocity(1);
			return true;

		}
		return false;
	}
	
	public Coordinate vectorRotation(Coordinate direction, double rot){

		this.displacement.setAngle(rot);

		double leng = direction.legth();
		Coordinate rotation = new Coordinate();

		rotation.x = (direction.x * Math.cos(displacement.angle) - direction.y
				* Math.sin(displacement.angle));
		rotation.y = (direction.y * Math.cos(displacement.angle) + direction.x
				* Math.sin(displacement.angle));
		Coordinate dirNorm = new Coordinate();
		dirNorm.normal(rotation);
		leng = 20;
		Coordinate coordinate1 = new Coordinate();
		coordinate1.setX(fakeposition.x + leng * dirNorm.x);
		coordinate1.setY(fakeposition.y + leng * dirNorm.y);

		Coordinate dirnorm1 = new Coordinate();
		dirnorm1.normal(coordinate1);
		return coordinate1;

	}

	public void findTheNewPoint(Track aTrack, int m) {
		synchronized (o) {

			boolean IsCoordOk = false;
			Barrier b = this.nearestBarrier;
			if (b == null)
				return;

			Coordinate direction = fakenextposition.difCoord(fakeposition);
			double i = -1;

			while (!IsCoordOk) {
				if (isItJumpable(aTrack, fakenextposition)) {
					IsCoordOk = true;
					this.displacement.setAngle(2);
					displacement.setVelocity(1);
				} else {
					i = i - 0.1;
					double rotationAnge = i*m;
					if (state.equals(RobotState.died))
						return;

					fakenextposition = vectorRotation(direction, rotationAnge);
				}
			}
		}
	}

	public void calcNextPosition(Track aTrack, int m) {
		synchronized (o) {

			Coordinate dif = new Coordinate();

			selectNearestBarrier(aTrack);

			Barrier b = this.nearestBarrier;
			if (b == null)
				return;
			Coordinate c = b.getPosition().difCoord(fakeposition);
			dif.dirNormal(fakeposition, this.nearestBarrier.getPosition());
			if (displacement.getVelocity() < 0)
				dif.dirNormal(this.nearestBarrier.getPosition(), fakeposition);

			dif.multip(20);

			if (c.legth() < 20)
				fakenextposition = fakeposition.addCoord(c);
			else
				fakenextposition = fakeposition.addCoord(dif);

			findTheNewPoint(aTrack, m);
		}

	}

	Coordinate fakeposition = new Coordinate();
	Coordinate fakenextposition = new Coordinate();

	public void decideTheDirection(Track track) {

		List<Coordinate> list1 = new ArrayList<Coordinate>();
		List<Coordinate> list2 = new ArrayList<Coordinate>();
		double d1 = 0;
		double d2 = 0;

		d1=calcThePath(track, list1, 1);
		d2=calcThePath(track, list2, -1);

		System.out.println("d1: " + d1 + " " + "d2: " + d2);

		if (d1 < d2)
			nextPosition = list1.get(0);
		else
			nextPosition = list2.get(0);
	}

	public double calcThePath(Track track, List<Coordinate> l, int i) {
		fakeposition = position;
		fakenextposition = position;
		Barrier b = this.nearestBarrier;
		Coordinate c = b.getPosition().difCoord(fakeposition);
		double howfar = c.legth();
		double distance = 0;

		while (howfar > 0) {

			calcNextPosition(track, i);
			l.add(fakenextposition);
			Coordinate vector = fakeposition.difCoord(fakenextposition);
			distance = distance + vector.legth();
			fakeposition = fakenextposition;
			b = this.nearestBarrier;
			c = b.getPosition().difCoord(fakeposition);
			howfar = c.legth();
		}
		return distance;
	}

	public Coordinate getPurpose() {
		return purpose;
	}

	public void setPurpose(Coordinate purpose) {
		this.purpose = purpose;
	}
}
