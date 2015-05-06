package Phoebe.gamepackage;

import java.sql.Timestamp;
import java.util.List;

import Phoebe.painter.CleanerPainter;
import Phoebe.trackpackage.*;
import Phoebe.basepackage.*;
import Phoebe.gamepackage.*;
import Phoebe.basepackage.*;

public class CleanerRobot extends Bot {
	private Barrier nearestBarrier;
	private boolean nearestBarrierExist;
	
	
	
	public CleanerRobot(Coordinate position1, Displacement disp1, Coordinate lastpos1) {
//		System.out.println("\t" + getClass().getName() + ":Robot");

		displacement = disp1;
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(2, 1);
		position = position1;
		lastPosition = lastpos1;
		type = BaseType.cleanerRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.ray = 30;

		//Painter hozzáadása
		CleanerPainter cleanerPainter = new CleanerPainter(System.getProperty("user.dir")+"\\resources\\cleaner1_v1.png");
		attachObserver(cleanerPainter);
	}
	
	public CleanerRobot() {
//		System.out.println("\t" + getClass().getName() + ":Robot");

		displacement = new Displacement((-1) * Math.PI/18, 50);
		state = RobotState.pure;
		// legyen a kiindulo ponttal azonos
		nextPosition = new Coordinate(300, 300);
		position = new Coordinate(305, 305);
		lastPosition = new Coordinate(310, 310);
		type = BaseType.cleanerRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.ray = 30;

		//Painter hozzáadása
		CleanerPainter cleanerPainter = new CleanerPainter(System.getProperty("user.dir")+"\\resources\\cleaner1_v1.png");
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
			System.out.println("Base ek"+ parts.getBases().size());
			for (Base base : parts.getBases()) {
				double tmp = Math.sqrt(Math.pow((position.getX() - base.getPosition().getX()), 2)
						+ Math.pow((position.getY() - base.getPosition().getY()), 2));

				if (tmp < distance && (base.getType().equals(BaseType.oil) || base.getType().equals(BaseType.putty))) {
					distance = tmp;
					nearestBarrierExist = true;
					barrier = (Barrier) base;
					System.out.println("Talaltam Barriert" + barrier.getType());
				}
			}
		}

		nearestBarrier = barrier;
	}

	public void stepOn(Bot aBot) {
//		System.out.println("Robot stepOn");

		if (aBot.getType().equals(BaseType.normalRobot)) {
			System.out.println("R'ml;ptek*************************************");
			aBot.setState(RobotState.active);
			this.trackPart.removeFromTrackPart(this);
			trackPart.addBase(new Oil(position,trackPart), position);
			this.state = RobotState.died;

			//Observer leválasztása
			detachObserver();

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
//		System.out.println("\t" + getClass().getName() + ":jump");
		
		calcNextPosition(aTrack);

		//setNextPosition(calcCoordinate(position, displacement));
		setLastPosition(position);
		setPosition(nextPosition);

		trackPart.removeFromTrackPart(this);
		TrackPart part = aTrack.findAPart(position);
		this.setTrackPart(part);
		Base b = giveMeTheBase(position, part);
		part.addBase(this, position);

		getTheEffectForRobot(b);

	}

	public void calcNextPosition(Track aTrack) {
		boolean IsCoordOk = false;
		// A robot pozicio es a Barrier kozotti egyenesen 10 egyseget lep a
		// robot a Barrier fele.
		selectNearestBarrier(aTrack);
		Coordinate dif = new Coordinate();
		Barrier b = this.nearestBarrier;
		if(b==null)
			return;
		
		Coordinate c = b.getPosition().difCoord(position);
		dif.dirNormal(position, this.nearestBarrier.getPosition());
		Coordinate dirNorm = dif;
		dif.multip(100);
		System.out.println("Nextkkkkkkkkkkkkkkkkkkk: "+nextPosition.getX()+" "+nextPosition.getY());
		//dif.multip(10);
		
		//setNextPosition(position.addCoord(dif));
		setNextPosition(position.addCoord(dif));
		
		
		
		
		while(!IsCoordOk){
			if(! (aTrack.findAPart(nextPosition).getBase(nextPosition).getType().equals(BaseType.edge))){
				IsCoordOk = true;
				this.displacement.setAngle(2);
				System.out.println("Jo lesz a koord");
			}else{
				System.out.println("Nem lesz jo a koord");
				this.displacement.setAngle(-2);
				Coordinate direction = new Coordinate();
				direction.setX(nextPosition.getX() - lastPosition.getX());
				direction.setY(nextPosition.getY() - lastPosition.getY());
				double leng = direction.legth();
				Coordinate rotation = new Coordinate();

				rotation.x = (direction.x * Math.cos(displacement.angle) - direction.y * Math.sin(displacement.angle));
				rotation.y = (direction.y * Math.cos(displacement.angle) + direction.x * Math.sin(displacement.angle));
				dirNorm = new Coordinate();
				dirNorm.normal(rotation);

				double velo = displacement.getVelocity();
				System.out.println("velo"+" "+velo);
				// Ha le van tiltva a sebesseg modositas, akkor a velo=1 legyen mert az
				// elozo elmozdulas-t nem modosithatja
//				if (veloMod == false)
//					velo = 1;
				leng = 50;
				System.out.println(leng);
				Coordinate coordinate = new Coordinate();
				coordinate.setX(nextPosition.x + leng * dirNorm.x );
				coordinate.setY(nextPosition.y + leng * dirNorm.y );
				
				nextPosition=coordinate;
				
				
				System.out.println("Next: "+nextPosition.getX()+" "+nextPosition.getY());
				
			}
		}
		
	}

}
