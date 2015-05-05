package Phoebe.gamepackage;

import Phoebe.Controller.Control;
import Phoebe.painter.RobotPainter;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.Track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import java.util.stream.BaseStream;

public class Game {

	private List<Robot> robots;
	private List<CleanerRobot> cleaners;
	private Track track;
	public Control control;

	

	public Game() {
//		System.out.println(getClass().getName() + ":Game");
		track = new Track();
		robots = new ArrayList<Robot>();
//		robots.add(new Robot(1));
//		robots.add(new Robot(new Displacement(-0.1, 1),2));
		cleaners = new ArrayList<CleanerRobot>();
		
	}
	
	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}
	
	public List<Robot> getRobotList(){
        return this.robots;
    }

    public void setRobotList (Robot robot){
        this.robots.add(robot);
    }

    public List<CleanerRobot> getCleanersList(){
        return this.cleaners;
    }

    public void setCleanersList (CleanerRobot cleanerRobot){
        this.cleaners.add(cleanerRobot);
    }
    
    public void addRobotToTheGame(Displacement disp, int id){
    	Robot robot = new Robot(disp);
    	robot.setTrackPart(track.findAPart(robot.getPosition()));
    	robots.add(robot);
    }

	// Lehet jobb lenne ket kulon listaban a robotokat meg a cleanereket, mert
	// nem egyszerre hivodnak meg. A kis robotokat gyorsabban kell leptetni.
	// Ki kell talalni hogy ugaraljank a tick-re figyelni kellene valami szamlalot hogy mikor ugorjon a nagy robot.
	// Majd a valtozasokat fel kell vazetni a diagramokra!!!
	public void start() {

//		System.out.println(getClass().getName() + ":Start()");

		for (Robot rob : robots) {
			if(rob.state.equals(RobotState.died) == true){
				continue;
			}else{
				rob.setNextPosition(rob.calcCoordinate(rob.getPosition(), rob.getDisplacement()));
			}
			
		}

		Collections.sort(robots, new CompareRobots());
		
		for(CleanerRobot cleaner : cleaners){
			cleaner.jump(track);
		}
		
		 for(Robot rob : robots){
			 System.out.println(rob.getId()+" "+rob.getState());
			 if(rob.state.equals(RobotState.died) == true)
				 continue;
			 else{
				 rob.jump(track); 
			 }
		
		 }
		 
		 calcDistance();
	}

	private void calcDistance() {
		
//		System.out.println(getClass().getName() + ":calcDistance()");

		for (Robot robot : robots) {
					Coordinate vector = robot.getLastPosition().difCoord(robot.getPosition());
					double length = vector.legth();
					double distance = length + robot.getDistance();
					robot.setDistance(distance);
		}
	}

	public Bot getWinner() {
//		System.out.println("\t" + getClass().getName() + ":getWinner");

		Robot winner = robots.get(0);
		double max = winner.getDistance();

		for (Robot robot : robots) {
				double tmp = robot.getDistance();
				if (tmp > max) {
					max = tmp;
					winner = robot;
				}
		}

		return winner;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	public Track getTrack() {
		return track;
	}
	// Kell hogy a robotok rendezesehez meg legyen az osszehasonlitasi alap
	private class CompareRobots implements Comparator<Bot> {

		@Override
		public int compare(Bot o1, Bot o2) {

//			System.out.println(getClass().getName() + ":Compare robots velocity");
			
			double d1 = o1.getPosition().difCoord(o1.getNextPosition()).legth();
			double d2 = o2.getPosition().difCoord(o2.getNextPosition()).legth();
			
			if(d1-d2>0){
				return 1;
			}else if(d1-d2<0){
				return -1;
			}else{
				return 0;
			}
		}
	}

    

}