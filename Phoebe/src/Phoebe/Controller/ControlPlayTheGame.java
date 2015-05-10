package Phoebe.Controller;
import Phoebe.gamepackage.Game;
import Phoebe.gamepackage.Robot;
import Phoebe.gamepackage.RobotState;
import Phoebe.gui.View;
import Phoebe.trackpackage.Oil;
import Phoebe.trackpackage.Putty;

import javax.jws.Oneway;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class ControlPlayTheGame {

	private Game game = null;

	private static Set<IControlKeys> controlKeys;

	public Set<IControlKeys> getControlKeys() {
		return controlKeys;
	}

	public ControlPlayTheGame(Game game) {
		this.game = game;
		controlKeys = new HashSet<IControlKeys>();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void putOil(Robot bot) {
            if(bot.getState() != RobotState.died && bot.getOilRepository()>0){
                    Oil oil = new Oil(bot.getPosition(), bot.getTrackPart());
                    bot.putTheBarrier(oil);
                }
	};

	public void putPutty(Robot bot) {
            if(bot.getState() != RobotState.died && bot.getPuttyRepository()>0){
                    Putty putty = new Putty(bot.getPosition(), bot.getTrackPart());
                    bot.putTheBarrier(putty);
            }
	};

	public Robot chooseRobot(ActionEvent e) {
		Robot bot = null;
		String s = e.getActionCommand();
		if (s == null) {
			for (Robot b : game.getRobotList()) {
				if (b.getId() == 1) {
					bot = b;
				}
			}
		} else {
			for (Robot b : game.getRobotList()) {
				if (b.getId() == 2) {
					bot = b;
				}
			}
		}
		return bot;
	}

	public void callConrtrolModifier(Robot bot, IControlKeys c) {
		c.setBot(bot);
		controlKeys.add(c);
	}

	protected static boolean t = false;

	public static synchronized void controlListCycle() {
		new Thread() {
			public void run() {
				while (controlKeys.size() > 0) {
					for (IControlKeys i : controlKeys) {
						i.modifier();
					}

					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					View.getDrawPanel().repaint();
				}
			}
		}.start();
	}

	public void addPlayTheGameListener() {
		RegistrateControlListeners registrate = new RegistrateControlListeners();
		registrate.addAllTheListeners();
		JButton exit = View.getPlayTheGame().getBtn_exit();
		exit.addActionListener(new ExitListener());
		JButton score = View.getPlayTheGame().getBtn_score();
		score.addActionListener(new ScoreListener());
	}

	private class ScoreListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Control.getTimer().cancel();
			Control.getTimerCleaner().cancel();
			Control.getTime().cancel();
            double res1 = game.getRobotList().get(0).getDistance();
            double res2 = game.getRobotList().get(1).getDistance();
            DecimalFormat df = new DecimalFormat("#.00");
            View.getScore().getPlayer1_score().setText(String.valueOf(df.format(res1)));
            View.getScore().getPlayer2_score().setText(String.valueOf(df.format(res2)));
			View.scoreGame();
			
		}
	}

	protected class AccelerateListener1 extends AbstractAction {
		IControlKeys acc = Accelerate.getInstance();

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys acc = Accelerate.getInstance();

			callConrtrolModifier(bot, acc);
			controlListCycle();
			View.getDrawPanel().repaint();
		}
	}

	protected class AccelerateListener2 extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys acc = Accelerate2.getInstance();
			callConrtrolModifier(bot, acc);
			controlListCycle();
			View.getDrawPanel().repaint();

		}
	}

	protected class AccelerateListenerDelet1 extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = Accelerate.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class AccelerateListenerDelet2 extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = Accelerate2.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class SlowDownListener1 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys slow = SlowDown.getInstance();
			callConrtrolModifier(bot, slow);
			controlListCycle();
			View.getDrawPanel().repaint();
		}
	}

	protected class SlowDownListener2 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys slow = SlowDown2.getInstance();
			callConrtrolModifier(bot, slow);
			controlListCycle();
			View.getDrawPanel().repaint();
		}
	}

	protected class SlowDownListenerDelet1 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = SlowDown.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class SlowDownListenerDelet2 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = SlowDown2.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class TurnRightListener1 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnright = TurnRight.getInstance();
			callConrtrolModifier(bot, turnright);
			controlListCycle();
			View.getDrawPanel().repaint();
		}
	}

	protected class TurnRightListener2 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnright = TurnRight2.getInstance();
			callConrtrolModifier(bot, turnright);
			controlListCycle();
			View.getDrawPanel().repaint();
		}
	}

	protected class TurnRightListenerDelet1 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = TurnRight.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class TurnRightListenerDelet2 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = TurnRight2.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class TurnLeftListener1 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnright = TurnLeft.getInstance();
			callConrtrolModifier(bot, turnright);
			controlListCycle();
			View.getDrawPanel().repaint();
		}
	}

	protected class TurnLeftListener2 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnright = TurnLeft2.getInstance();
			callConrtrolModifier(bot, turnright);
			controlListCycle();
			View.getDrawPanel().repaint();
		}
	}

	protected class TurnLeftListenerDelet1 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = TurnLeft.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class TurnLeftListenerDelet2 extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			IControlKeys acc;
			acc = TurnLeft2.getInstance();
			controlKeys.remove(acc);
		}
	}

	protected class PutOilListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			putOil(bot);
			View.getDrawPanel().repaint();
		}
	}

	protected class PutPuttyListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			putPutty(bot);
			View.getDrawPanel().repaint();
		}
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
