package Phoebe.gamepackage;
import Phoebe.Controller.Control;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.Putty;
import Phoebe.trackpackage.Track;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {
	private List<Robot> robots;
	private List<CleanerRobot> cleaners;
	private Track track;
	public Control control;

	public Game() {
		track = new Track();
		robots = new ArrayList<Robot>();
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
    
    public void addRobotToTheGame(Coordinate position,Displacement disp, int id){
    	Robot robot = new Robot(position,disp,id);
    	robot.setTrackPart(track.findAPart(robot.getPosition()));
    	robots.add(robot);
//    	robot.putTheBarrier(new Putty(robot.getPosition(), robot.getTrackPart()));
    }

	public synchronized void start() {
		setRobotsNextPosition();
		Collections.sort(robots, new CompareRobots());
		startTheRobots();
		calcDistance();
	}
	
	public synchronized void startTheCleaners(){
		for(int i=0; i<cleaners.size();i++){
			CleanerRobot cleaner = cleaners.get(i);
			cleaner.selectNearestBarrier(track);
			if(cleaner.getNearestBarrier() == null ){
				cleaner.clean();
				cleaners.remove(i);
				continue;
			}
			if(cleaner.getState().equals(RobotState.died)){
				cleaners.remove(i);
			}else{
				cleaner.jump(track);
			}
			
		}
	}
	
	public void setRobotsNextPosition(){
		for (Robot rob : robots) {
			if(rob.state.equals(RobotState.died) == true){
				continue;
			}else{
				rob.setNextPosition(rob.calcCoordinate(rob.getPosition(), rob.getDisplacement()));
			}
		}
	}
	
	public void startTheRobots(){
		for(Robot rob : robots){
			 if(rob.state.equals(RobotState.died) == true)
				 continue;
			 else{
				 rob.jump(track); 
			 }
		 }
	}

	private void calcDistance() {
		for (Robot robot : robots) {
			if(!robot.getState().equals(RobotState.died)){
					Coordinate vector = robot.getLastPosition().difCoord(robot.getPosition());
					double length = vector.legth();
					double distance = length + robot.getDistance();
					robot.setDistance(distance);
			}
		}
	}

	public Robot getWinner() {
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