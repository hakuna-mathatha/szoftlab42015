package Phoebe.gamepackage;

import java.util.*;
import Phoebe.*;
import Phoebe.trackpackage.*;

public class Game {

	Collection<Bot> bots;
	Track track;
	Control control;

	/**
	 * 
	 * @return 
	 */
	public Game(){
		System.out.println("Game peldanyositasa.");
		Track t = new Track();
		t.create();
		Robot r1 = new Robot();
		Robot r2 = new Robot();
		bots.add(r1);
		bots.add(r2);
	}
	
	public void start() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param robot
	 * @return 
	 */
	private void calcDistance(Bot robot) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	private Bot getWinner() {
		throw new UnsupportedOperationException();
	}

}