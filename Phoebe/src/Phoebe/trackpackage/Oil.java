package Phoebe.trackpackage;

import java.util.Timer;
import java.util.TimerTask;

import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.RobotState;
import Phoebe.gamepackage.Displacement;

public class Oil extends Barrier {

	private Timer timer;
	private int countToRemove;

	TimerTask deacreaseCount = new TimerTask() {
		@Override
		public void run() {
//			Oil.decreaseCountToRemove();
		}
	};

	public Oil() {}

	public Oil(Coordinate position, BaseType type, TrackPart trackPart, double ray) {

		super(position, type, trackPart, ray);
		type = BaseType.pure;
		timer = new Timer();
		this.timer.schedule(deacreaseCount, 5 * 1000);
		//5 kör után tûnik el az olaj a pályáról
		countToRemove = 5;
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

		//ha letelt az idõ, akkor eltávolítjuk a pályáról az olajfoltot
		if (countToRemove == 0) {
			trackPart.removeFromTrackPart(this);
			return;
		}
		//ha még nem járt le az idõ, akkor csökkentjük
		else {
			countToRemove--;
		}
	}
}