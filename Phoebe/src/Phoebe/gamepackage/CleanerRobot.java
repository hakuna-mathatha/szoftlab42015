package Phoebe.gamepackage;
import Phoebe.basepackage.Base;
import Phoebe.basepackage.BaseType;
import Phoebe.painter.CleanerPainter;
import Phoebe.trackpackage.*;
import java.sql.Timestamp;
import java.util.List;

public class CleanerRobot extends Bot {
	private Barrier nearestBarrier;
	private boolean nearestBarrierExist;
	private Coordinate purpose;

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
		//Painter hozzaadasa
		CleanerPainter cleanerPainter = new CleanerPainter(System.getProperty("user.dir")+"\\resources\\cleaner1_v1.png");
		attachObserver(cleanerPainter);
	}
	
	public CleanerRobot() {
		displacement = new Displacement(2, 1);
		state = RobotState.pure;
		nextPosition = new Coordinate(300, 300);	// legyen a kiindulo ponttal azonos
		position = new Coordinate(305, 305);
		lastPosition = new Coordinate(310, 310);
		type = BaseType.cleanerRobot;
		trackPart = new JumpablePart();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		veloMod = true;
		directionMod = true;
		this.ray = 30;
		//Painter hozzaadasa
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
			System.out.println("Basek "+ parts.getBases().size());     //kivenni
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
		if (aBot.getType().equals(BaseType.normalRobot)) {
			System.out.println("R'ml;ptek*************************************"); //kivenni
			aBot.setState(RobotState.active);
			this.trackPart.removeFromTrackPart(this);
			trackPart.addBase(new Oil(position,trackPart), position);
			this.state = RobotState.died;
			//Observer levalasztasa
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
		calcNextPosition(aTrack);
		setLastPosition(position);
		setPosition(nextPosition);
		trackPart.removeFromTrackPart(this);
		TrackPart part = aTrack.findAPart(position);
		this.setTrackPart(part);
		Base b = giveMeTheBase(position, part);
		part.addBase(this, position);
		getTheEffectForRobot(b);
	}
	
	public void findTheNewPoint(Track aTrack){
		boolean IsCoordOk = false;
		Barrier b = this.nearestBarrier;
		if(b==null)
			return;

		Coordinate direction = b.getPosition().difCoord(position);
		
		while(!IsCoordOk){
			if((!(aTrack.findAPart(nextPosition).getBase(nextPosition).getType().equals(BaseType.edge)))){
				IsCoordOk = true;
				this.displacement.setAngle(2);
				System.out.println("Jo lesz a koord");  //kivenni
			}else{
				System.out.println("Nem lesz jo a koord");  //kivenni
				this.displacement.setAngle(-1.1);
//				Coordinate direction = new Coordinate();
//				direction.setX(nextPosition.getX() - lastPosition.getX());
//				direction.setY(nextPosition.getY() - lastPosition.getY());
				double leng = direction.legth();
				Coordinate rotation = new Coordinate();

				rotation.x = (direction.x * Math.cos(displacement.angle) - direction.y * Math.sin(displacement.angle));
				rotation.y = (direction.y * Math.cos(displacement.angle) + direction.x * Math.sin(displacement.angle));
				Coordinate dirNorm = new Coordinate();
				dirNorm.normal(rotation);

				double velo = displacement.getVelocity();
				System.out.println("velo"+" "+velo);         //kivenni
				// Ha le van tiltva a sebesseg modositas, akkor a velo=1 legyen mert az elozo elmozdulas-t nem modosithatja
				leng = 50;
				System.out.println(leng);
				Coordinate coordinate = new Coordinate();
				coordinate.setX(nextPosition.x + leng * dirNorm.x );
				coordinate.setY(nextPosition.y + leng * dirNorm.y );
				nextPosition=coordinate;
				
				
				
			}
		}
	}

	public void calcNextPosition(Track aTrack) {
		boolean IsCoordOk = false;
		// A robot pozicio es a Barrier kozotti egyenesen 10 egyseget lep a robot a Barrier fele.
		selectNearestBarrier(aTrack);
		Coordinate dif = new Coordinate();
		Barrier b = this.nearestBarrier;
		if(b==null)
			return;
		Coordinate c = b.getPosition().difCoord(position);
	
		dif.dirNormal(position, this.nearestBarrier.getPosition());
		Coordinate dirNorm = dif;
		dif.multip(5);
//		if(c.legth()<100)
//			setNextPosition(position.addCoord(c));
//		else
			setNextPosition(position.addCoord(dif));
		
		System.out.println("Nextkkkkkkkkkkkkkkkkkkk: "+nextPosition.getX()+" "+nextPosition.getY());   //kivenni
		findTheNewPoint(aTrack);


	}

	public Coordinate getPurpose() {
		return purpose;
	}

	public void setPurpose(Coordinate purpose) {
		this.purpose = purpose;
	}
}
