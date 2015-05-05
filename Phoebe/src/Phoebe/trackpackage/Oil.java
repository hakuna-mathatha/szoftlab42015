package Phoebe.trackpackage;

import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.RobotState;
import Phoebe.gamepackage.Displacement;
import Phoebe.painter.OilPainter;

public class Oil extends Barrier {

	private Timer timer;

	public Oil() {
		this.type = BaseType.oil;
		this.ray = 1;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.oil;
		this.timer = new Timer();
		//kell egy task, ami adott id� ut�n lefut
		TimerTask tTask = new OilTask();
		// 5 k�r ut�n t�nik el az olaj a p�ly�r�l
		this.timer.schedule(tTask, 1000000 * 1000);

		//Painter hozzáadása
		OilPainter oilPainter = new OilPainter(System.getProperty("user.dir") + "\\resources\\spill0_v1.png");
		attachObserver(oilPainter);
	}

	public Oil(Coordinate position, TrackPart trackPart) {

		this.position = position;
		this.trackPart = trackPart;
		
		this.type = BaseType.oil;
		this.ray = 1;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.oil;
		this.timer = new Timer();
		//kell egy task, ami adott id� ut�n lefut
		TimerTask tTask = new OilTask();
		// 5 k�r ut�n t�nik el az olaj a p�ly�r�l
		this.timer.schedule(tTask, 1000000 * 1000);

		//Painter hozzáadása
		OilPainter oilPainter = new OilPainter(System.getProperty("user.dir") + "\\resources\\spill0_v1.png");
		attachObserver(oilPainter);

//		System.out.println("\t\t\t\t" + getClass().getName() + ":Oil");
	}

	//ha olajba l�p�nk, nem v�ltoztathatjuk a robot sebess�g�t a k�vetkez� k�rig
	public void stepOn(Bot bot) {

//		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

		//csak a norm�l robotra hat
		if (bot.getType() == BaseType.normalRobot) {
			//�llapaota putty lesz
			bot.setState(RobotState.oil);
			//ir�nya v�ltoztathat�
			bot.setDirectionMod(true);
			//sebess�ge nem v�ltoztathat�
			bot.setVeloMod(false);
		}
	}

	
	public void cleaner(){
		this.clean();
	}
	
	private class OilTask extends TimerTask{

		@Override
		public void run() {
			//ha letelt az id�, akkor elt�ntetj�k a p�ly�r�l
			//timer le�ll�t�sa
//			timer.cancel();
//			timer.purge();
			cleaner();
			timer.cancel();
//			System.out.println("time is over");
//			clean();
//			System.out.println("removed from map");
		}
		
	}
}