package Phoebe.gamepackage;

import java.util.*;
import java.util.stream.BaseStream;

import Phoebe.basepackage.BaseType;
import Phoebe.trackpackage.*;

public class Game {

	public List<Robot> robots;
	private List<CleanerRobot> cleaners;
	public Track track;
	public Control control;

	public Game() {
		System.out.println(getClass().getName() + ":Game");
		track = new Track();
		track.create();
		Robot r1 = new Robot();
		Robot r2 = new Robot();
		robots = new ArrayList<Robot>();
		cleaners = new ArrayList<CleanerRobot>();
		robots.add(r1);
		robots.add(r2);
		control = new Control();
	}

	// Lehet jobb lenne ket kulon listaban a robotokat meg a cleanereket, mert
	// nem egyszerre hivodnak meg. A kis robotokat gyorsabban kell leptetni.
	// Ki kell talalni hogy ugaraljank a tick-re figyelni kellene valami szamlalot hogy mikor ugorjon a nagy robot.
	// Majd a valtozasokat fel kell vazetni a diagramokra!!!
	public void start() {

		System.out.println(getClass().getName() + ":Start()");

		for (Robot rob : robots) {
			if(rob.state.equals(RobotState.died) == true){
				continue;
			}else{
				rob.setNextPosition(rob.calcCoordinate(rob.getPosition(), rob.getDisplacement()));
			}
			
		}

		Collections.sort(robots, new ComparRobots());
		
//		for(CleanerRobot cleaner : cleaners){
//			cleaner.jump(track);
//		}
		
		 for(Robot rob : robots){
			 if(rob.state.equals(RobotState.died) == true)
				 continue;
			 else{
				 rob.jump(track); 
			 }
		
		 }
		 
		 calcDistance();
	}

	private void calcDistance() {
		
		System.out.println(getClass().getName() + ":calcDistance()");

		for (Robot robot : robots) {
					Coordinate vector = robot.getLastPosition().difCoord(robot.getPosition());
					double length = vector.legth();
					double distance = length + robot.getDistance();
					robot.setDistance(distance);
		}
	}

	public Bot getWinner() {
		System.out.println("\t" + getClass().getName() + ":getWinner");

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

	// Kell hogy a robotok rendezesehez meg legyen az osszehasonlitasi alap
	private class ComparRobots implements Comparator<Bot> {

		@Override
		public int compare(Bot o1, Bot o2) {

			System.out.println(getClass().getName() + ":Compare robots velocity");
			
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