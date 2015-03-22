package Phoebe.gamepackage;

import java.util.*;
import Phoebe.trackpackage.*;

public class Game {

	public List<Robot> bots;
	public Track track;
	public Control control;

	public Game(){
		System.out.println(getClass().getName()+":Game");
		track = new Track();
		track.create();
		Robot r1 = new Robot();
		Robot r2 = new Robot();
		bots = new ArrayList<Robot>();
		bots.add(r1);
		bots.add(r2);
	}
	
	public void start() {

		System.out.println("Start");
	}

	private void calcDistance(Bot robot) {};

	public Bot getWinner() {
		System.out.println("\t"+getClass().getName()+":getWinner");
		
		for (Robot r : bots){
			r.getDistance();
		}

		return null;
	}

}