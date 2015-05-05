package Phoebe.Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Game;
import Phoebe.gamepackage.Robot;
import Phoebe.gui.DrawLine;
import Phoebe.gui.View;
import Phoebe.trackpackage.Oil;
import Phoebe.trackpackage.Putty;

public class ControlPlayTheGame {

	private Game game = null;

	public ControlPlayTheGame(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void turnLeft(Robot bot) {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle() - 0.1);
		bot.setDisplacement(d);
		bot.calcNextPosition();

		System.out.println("left" + " " + bot.getDisplacement().getAngle());
	};

	public void turnRight(Robot bot) {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle() + 0.1);
		bot.setDisplacement(d);
		bot.calcNextPosition();

		System.out.println("right" + " " + bot.getDisplacement().getAngle());
	};

	public void accelerate(Robot bot) {
		if (bot.getVeloMod()) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() + 5);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}

		System.out.println("acc" + " " + bot.getDisplacement().getVelocity());
	};

	public void slowDown(Robot bot) {
		if (bot.getVeloMod()) {
			Displacement d = bot.getDisplacement();
			d.setVelocity(d.getVelocity() - 5);
			bot.setDisplacement(d);
			bot.calcNextPosition();
		}

		System.out.println("slow" + " " + bot.getDisplacement().getVelocity());
	};

	public void putOil(Robot bot) {
		Oil oil = new Oil();
		bot.putTheBarrier(oil);
		System.out.println("oil" + " " + bot.getOilRepository());
	};

	public void putPutty(Robot bot) {
		Putty putty = new Putty();
		bot.putTheBarrier(putty);
		System.out.println("putty" + " " + bot.getPuttyRepository());
	};

	private void addAccListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();

		KeyEvent acc = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
		KeyEvent acc2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc), "accelerate");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc2), "accelerate");

		jPanel.getActionMap().put("accelerate", new AccelerateListener());
	}

	private void addSlowListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent slow = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_S, KeyEvent.CHAR_UNDEFINED);
		KeyEvent slow2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow), "slow");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow2), "slow");

		jPanel.getActionMap().put("slow", new SlowDownListener());

	}

	private void addTurnRightListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent right = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_D, KeyEvent.CHAR_UNDEFINED);
		KeyEvent right2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right), "right");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right2), "right");

		jPanel.getActionMap().put("right", new TurnRightListener());
	}

	private void addTurnLeftListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent left = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
		KeyEvent left2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left), "left");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left2), "left");

		jPanel.getActionMap().put("left", new TurnLeftListener());
	}

	private void addPutOilListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent putOil = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_Q, KeyEvent.CHAR_UNDEFINED);
		KeyEvent putOil2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_END, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putOil), "putoil");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putOil2), "putoil");

		jPanel.getActionMap().put("putoil", new PutOilListener());
	}

	private void addPutPuttyListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent putPutty = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_E, KeyEvent.CHAR_UNDEFINED);
		KeyEvent putPutty2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_PAGE_DOWN,
				KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putPutty), "putputty");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putPutty2), "putputty");

		jPanel.getActionMap().put("putputty", new PutPuttyListener());
	}

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
		addAccListener();
		addSlowListener();
		addTurnRightListener();
		addTurnLeftListener();
		addPutOilListener();
		addPutPuttyListener();

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

	private class AccelerateListener extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Robot bot = chooseRobot(arg0);
			accelerate(bot);
			View.getDrawPanel().repaint();

		}
	}

	private class SlowDownListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			slowDown(bot);
			View.getDrawPanel().repaint();
			
		}
	}

	private class TurnRightListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			turnRight(bot);
			View.getDrawPanel().repaint();
			
		}
	}

	private class TurnLeftListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			turnLeft(bot);
			View.getDrawPanel().repaint();
			
		}
	}

	private class PutOilListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			putOil(bot);
		}
	}

	private class PutPuttyListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			putPutty(bot);
		}
	}

	private class ExitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	

}
