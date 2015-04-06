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
		//5 k�r ut�n t�nik el az olaj a p�ly�r�l
		countToRemove = 5;
	}

	//ha olajba l�p�nk, nem v�ltoztathatjuk a robot sebess�g�t a k�vetkez� k�rig
	public void stepOn(Bot bot) {

		System.out.println("\t\t\t\t" + getClass().getName() + ":stepOn");

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

	void decreaseCountToRemove() {

		//ha letelt az id�, akkor elt�vol�tjuk a p�ly�r�l az olajfoltot
		if (countToRemove == 0) {
			trackPart.removeFromTrackPart(this);
			return;
		}
		//ha m�g nem j�rt le az id�, akkor cs�kkentj�k
		else {
			countToRemove--;
		}
	}
}