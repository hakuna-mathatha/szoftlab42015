package Phoebe.Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Game;
import Phoebe.gamepackage.Robot;
import Phoebe.gui.View;
import Phoebe.trackpackage.Oil;
import Phoebe.trackpackage.Putty;

public class ControlPlayTheGame {

	private Game game = null;
	
	private Set<IControlKeys> controlKeys;
	

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
		Oil oil = new Oil(bot.getPosition(), bot.getTrackPart());
		bot.putTheBarrier(oil);
//		System.out.println("oil" + " " + bot.getOilRepository());
	};

	public void putPutty(Robot bot) {
		Putty putty = new Putty(bot.getPosition(), bot.getTrackPart());
		bot.putTheBarrier(putty);
//		System.out.println("putty" + " " + bot.getPuttyRepository());
	};



	public Robot chooseRobot(ActionEvent e) {
		Robot bot;
		String s = e.getActionCommand();
		System.out.println(s);
		if (s == null) {
			System.out.println("1.");
			if(game.getRobotList().get(1).getId() == 1)
				bot = game.getRobotList().get(1);
			else
				bot = game.getRobotList().get(0);
		} else {
			System.out.println("2.");
			if(game.getRobotList().get(1).getId() == 2)
				bot = game.getRobotList().get(1);
			else
				bot = game.getRobotList().get(0);
		}

		return bot;
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
			View.scoreGame();
			
		}

	}

	protected class AccelerateListener extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Robot bot = chooseRobot(arg0);
			IControlKeys acc;
			if(bot.getId()==1){
				acc = Accelerate.getInstance();
			}else{
				acc = Accelerate2.getInstance();
			}
			acc.setBot(bot);
			
			controlKeys.add(acc);
			
			for(IControlKeys i : controlKeys){
				i.modifier();
			}
			
			View.getDrawPanel().repaint();

		}
	}
	
	protected class AccelerateListenerDelet extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Robot bot = chooseRobot(arg0);
			IControlKeys acc;
			if(bot.getId()==1){
				acc = Accelerate.getInstance();
			}else{
				acc = Accelerate2.getInstance();
			}
			
			controlKeys.remove(acc);
			
		}
	}

	protected class SlowDownListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			Robot bot = chooseRobot(arg0);
			IControlKeys slow;
			if(bot.getId()==1){
				slow = SlowDown.getInstance();
			}else{
				slow = SlowDown2.getInstance();
			}
			slow.setBot(bot);
			
			controlKeys.add(slow);
			
			for(IControlKeys i : controlKeys){
				i.modifier();
			}
			
			View.getDrawPanel().repaint();

		}
	}
	
	
	protected class SlowDownListenerDelet extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			Robot bot = chooseRobot(arg0);
			IControlKeys slow;
			if(bot.getId()==1){
				slow = SlowDown.getInstance();
			}else{
				slow = SlowDown2.getInstance();
			}
			
			controlKeys.remove(slow);
			
		

		}
	}

	protected class TurnRightListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnright;
			if(bot.getId()==1){
				turnright = TurnRight.getInstance();
			}else{
				turnright = TurnRight2.getInstance();
			}
			turnright.setBot(bot);
			
			controlKeys.add(turnright);
			
			for(IControlKeys i : controlKeys){
				i.modifier();
			}
			
			View.getDrawPanel().repaint();
			
		}
	}
	
	
	
	protected class TurnRightListenerDelet extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnright;
			if(bot.getId()==1){
				turnright = TurnRight.getInstance();
			}else{
				turnright = TurnRight2.getInstance();
			}
			
			controlKeys.remove(turnright);
			
		}
	}
	
	
	
	

	protected class TurnLeftListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnleft;
			if(bot.getId()==1){
				turnleft = TurnLeft.getInstance();
			}else{
				turnleft = TurnLeft2.getInstance();
			}
			turnleft.setBot(bot);
			
			controlKeys.add(turnleft);
			
			for(IControlKeys i : controlKeys){
				i.modifier();
			}
			
			View.getDrawPanel().repaint();
			
		}
	}
	
	protected class TurnLeftListenerDelet extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			IControlKeys turnleft;
			if(bot.getId()==1){
				turnleft = TurnLeft.getInstance();
			}else{
				turnleft = TurnLeft2.getInstance();
			}
			
			controlKeys.remove(turnleft);
			
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
