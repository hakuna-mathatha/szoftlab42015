package Phoebe.trackpackage;

import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.RobotState;
import Phoebe.gamepackage.Displacement;

public class Oil extends Barrier {

	private Timer timer;
	private int countToRemove;

//	TimerTask deacreaseCount = new TimerTask() {
//		@Override
//		public void run() {
////			Oil.decreaseCountToRemove();
//		}
//	};

	public Oil() {
		type = BaseType.oil;
	}

//	public Oil(Coordinate position, BaseType type, TrackPart trackPart, double ray) {
////		super(position, type, trackPart, ray);
//		
//		System.out.println("Oil Constructor");
//		type = BaseType.oil;
//		TimerTask T = new timerer();
//		timer = new Timer();
//		this.timer.schedule(T, 5 * 1000);
//		//5 kör után tûnik el az olaj a pályáról
//		countToRemove = 1;
//	}
	
	
	public Oil(Coordinate position, TrackPart trackPart) {
		this.trackPart = trackPart;
		this.position = position;
		this.ray = 100;
		timeStamp = new Timestamp(System.currentTimeMillis());
		System.out.println("Oil Constructor");
		type = BaseType.oil;
		TimerTask T = new timerer();
		timer = new Timer();
		this.timer.schedule(T, 5 * 1000);
		// 5 kör után tûnik el az olaj a pályáról
		//T.cancel();
	}

	//ha olajba lépünk, nem változtathatjuk a robot sebességét a következõ körig
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//csak a normál robotra hat
		if (bot.getType() == BaseType.normalRobot) {
			//állapaota putty lesz
			bot.setState(RobotState.oil);
			//iránya változtatható
			bot.setDirectionMod(true);
			//sebessége nem változtatható
			bot.setVeloMod(false);
		}
		
	}

	void decreaseCountToRemove() {
		
		System.out.println("Decrese");
		this.clean();

	}
	
	private class timerer extends TimerTask{

		@Override
		public void run() {
			decreaseCountToRemove();
			
		}
		
	}
}