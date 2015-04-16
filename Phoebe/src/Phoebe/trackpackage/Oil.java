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

	public Oil() {
		this.type = BaseType.oil;
		this.ray = 10;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.oil;
		this.timer = new Timer();
		//kell egy task, ami adott idõ után lefut
		TimerTask tTask = new OilTask();
		// 5 kör után tûnik el az olaj a pályáról
		this.timer.schedule(tTask, 2 * 1000);
	}

	public Oil(Coordinate position, TrackPart trackPart) {

		this.position = position;
		this.trackPart = trackPart;
		
		this.type = BaseType.oil;
		this.ray = 10;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.oil;
		this.timer = new Timer();
		//kell egy task, ami adott idõ után lefut
		TimerTask tTask = new OilTask();
		// 5 kör után tûnik el az olaj a pályáról
		this.timer.schedule(tTask, 2 * 1000);

//		System.out.println("\t\t\t\t" + getClass().getName() + ":Oil");
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

	
	public void cleaner(){
		this.clean();
	}
	
	private class OilTask extends TimerTask{

		@Override
		public void run() {
			//ha letelt az idõ, akkor eltûntetjük a pályáról
			//timer leállítása
//			timer.cancel();
//			timer.purge();
			cleaner();
			timer.cancel();
			System.out.println("time is over");
//			clean();
			System.out.println("removed from map");
		}
		
	}
}