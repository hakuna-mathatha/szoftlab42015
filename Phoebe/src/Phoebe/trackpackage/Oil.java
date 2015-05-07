package Phoebe.trackpackage;
import Phoebe.basepackage.BaseType;
import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.RobotState;
import Phoebe.painter.OilPainter;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

public class Oil extends Barrier {

	private Timer timer;

	public Oil() {
		this.type = BaseType.oil;
		this.ray = 1;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.oil;
		this.timer = new Timer();
		TimerTask tTask = new OilTask();   //task, ami adott ido utan lefut
		this.timer.schedule(tTask, 30 * 1000);   //5 kor utan eltunik az olaj a palyarol

		//Painter hozzaadasa
		OilPainter oilPainter = new OilPainter(System.getProperty("user.dir") + "\\resources\\spill0_v1.png");
		attachObserver(oilPainter);
	}

	public Oil(Coordinate position, TrackPart trackPart) {
		this.position = position;
		this.trackPart = trackPart;
		this.type = BaseType.oil;
		this.ray = 50.5;
		this.timeStamp = new Timestamp(System.currentTimeMillis());
		this.type = BaseType.oil;
		this.timer = new Timer();
		TimerTask tTask = new OilTask();          //task, ami adott ido utan lefut
		this.timer.schedule(tTask, 30 * 1000);    //5 kor utan eltunik az olaj a palyarol

		//Painter hozzaadasa
		OilPainter oilPainter = new OilPainter(System.getProperty("user.dir") + "\\resources\\spill0_v1.png");
		attachObserver(oilPainter);
	}

	//ha olajba lepunk, nem valtoztathatjuk a robot sebesseget a kovetkezo korig
	public void stepOn(Bot bot) {
		//csak a normal robotra hat
		if (bot.getType() == BaseType.normalRobot) {
			//�llapaota putty lesz
			bot.setState(RobotState.oil);
			bot.setDirectionMod(true);      //iranya valtoztathato
			bot.setVeloMod(false);          //sebessege nem valtoztathato
		}else if(bot.getType() == BaseType.cleanerRobot){
			clean();
		}
	}
	
	public void cleaner(){
		this.clean();
	}
	
	private class OilTask extends TimerTask{

		@Override
		public void run() {
			cleaner();            //ha letelt az ido az olaj eltunik a palyarol
			timer.cancel();       //timer leallitasa
		}
	}
	
	public synchronized void clean() {
		timer.cancel();
		detachObserver();   //observer levalasztas
		trackPart.removeFromTrackPart(this);
	}
}