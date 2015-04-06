package Phoebe.gamepackage;

import java.util.List;

import Phoebe.trackpackage.*;
import Phoebe.basepackage.*;
import Phoebe.gamepackage.*;
import Phoebe.basepackage.*;

public class CleanerRobot extends Bot {
	private Track track;
	private Barrier nearestBarrier;
	private boolean nearestBarrierExist;
	
	
	
	public CleanerRobot() {
		System.out.println("\t" + getClass().getName() + ":Robot");


		displacement = new Displacement((-1) * Math.PI, 1);
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(1, 1);
		position = new Coordinate(1, 1);
		lastPosition = new Coordinate(0.5, 0.5);
		type = BaseType.cleanerRobot;
		trackPart = new JumpablePart();

		veloMod = true;
		directionMod = true;

	}

	public void selectNearestBarrier() {
		List<JumpablePart> list = track.getTrackParts();
		double distance = 10000;
		Barrier barrier = null;

		for (JumpablePart parts : list) {
			for (Base base : parts.getBases()) {
				double tmp = Math.sqrt(Math.pow((position.getX() - base.getPosition().getX()), 2)
						+ Math.pow((position.getY() - base.getPosition().getY()), 2));

				if (tmp < distance && (base.getType().equals(BaseType.oil) || base.getType().equals(BaseType.oil))) {
					distance = tmp;
					nearestBarrierExist = true;
					barrier = (Barrier) base;
				}
			}
		}

		nearestBarrier = barrier;
	}

	public void stepOn(Bot aBot) {
		System.out.println("Robot stepOn");

		if (aBot.getType().equals(BaseType.normalRobot)) {

			this.trackPart.removeFromTrackPart(this);
			trackPart.addBase(new Oil(), position);
			this.state = RobotState.died;

		} else if (aBot.getType().equals(BaseType.cleanerRobot)) {
			Displacement disp = new Displacement();
			disp = aBot.getDisplacement();
			double velocity = aBot.getDisplacement().getVelocity();
			disp.setVelocity(velocity * (-1));

			aBot.setDisplacement(disp);

		}

	}

	public void jump(Track aTrack) {
		setState(RobotState.jump);
		System.out.println("\t" + getClass().getName() + ":jump");
		
		calcNextPosition();

		//setNextPosition(calcCoordinate(position, displacement));
		setLastPosition(position);
		setPosition(nextPosition);

		trackPart.removeFromTrackPart(this);
		TrackPart part = track.findAPart(position);
		this.setTrackPart(part);
		Base b = giveMeTheBase(position, part);
		part.addBase(this, position);

		getTheEffectForRobot(b);

	}

	public void calcNextPosition() {
		boolean IsCoordOk = false;
		// A robot pozicio es a Barrier kozotti egyenesen 10 egyseget lep a
		// robot a Barrier fele.
		Coordinate dif = new Coordinate();
		dif.dirNormal(position, this.nearestBarrier.getPosition());
		dif.multip(10);
		setNextPosition(position.addCoord(dif));
		
		while(!IsCoordOk){
			if(! (track.findAPart(nextPosition).getBase(nextPosition).getType().equals(BaseType.edge))){
				IsCoordOk = true;
			}else{
				nextPosition.setX((nextPosition.getX() * Math.cos(Math.PI/18) - nextPosition.getY() * Math.sin(Math.PI/18))
						+ position.getX());
				nextPosition.setY((nextPosition.getY() * Math.cos(Math.PI/18) + nextPosition.getX() * Math.sin(Math.PI/18))
						+ position.getY());
				
			}
		}
		
	}

}
