package Phoebe.Controller;

import Phoebe.gamepackage.*;
import Phoebe.gui.PlayTheGame;
import Phoebe.gui.View;
import Phoebe.painter.DrawPanel;
import Phoebe.trackpackage.Coordinate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Control {

	protected View view;
	private Game game = null;
	private static ControlPlayTheGame controlPlayTheGame;
	private static ControlMenu controlMenu;
	private static ControlScore controlScore;
	private static ControlNewGameMenu controlNewGameMenu;
	private static Timer timer;
	private static Timer timerCleaner;
	private Timer time;
	private int gametime;

	public Control() {
		controlPlayTheGame = new ControlPlayTheGame(game);
		controlMenu = new ControlMenu();
		controlScore = new ControlScore();
		controlNewGameMenu = new ControlNewGameMenu(this);
		addTheControlLogic();
	}

	public static Timer getTimerCleaner() {
		return timerCleaner;
	}

	public static ControlPlayTheGame getControlPlayTheGame() {
		return controlPlayTheGame;
	}

	public static void setControlPlayTheGame(ControlPlayTheGame controlPlayTheGame) {
		Control.controlPlayTheGame = controlPlayTheGame;
	}

	public static Timer getTimer() {
		return timer;
	}

	public ControlPlayTheGame getControlPlayGame() {
		return controlPlayTheGame;
	}

	public void setControlPlayGame(ControlPlayTheGame controlPlayGame) {
		this.controlPlayTheGame = controlPlayGame;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	private void addTheControlLogic() {
		controlMenu.addMenuListener();
		controlNewGameMenu.addNewGameMenuListener();
		controlScore.addScoreListener();
	}

	public void startNewGame(int index) {
		view.reStart();
		inicializeGame(index);
		PlayTheGame playTheGame = new PlayTheGame("Phoebe");
		view.setDrawPanel(playTheGame.getDrawPanel());
		DrawPanel.setView(view);
		View.setPlayTheGame(playTheGame);
		controlPlayTheGame.addPlayTheGameListener();
		
		startTimerForRounds();
		startTimerForRoundsCleaner();
		startTheTime();
	}

	public void inicializeGame(int index) {
		this.game = new Game();
		this.game.setControl(this);
		controlPlayTheGame.setGame(game);
		game.getTrack().create(index);
		game.addRobotToTheGame(new Coordinate(110, 15), new Displacement(0.1, 1), 1);
		game.addRobotToTheGame(new Coordinate(20, 70), new Displacement(0.1, 1), 2);
		CleanerRobot clean = new CleanerRobot();
		clean.setTrackPart(game.getTrack().findAPart(clean.getPosition()));
		clean.selectNearestBarrier(game.getTrack());
		game.getCleanersList().add(clean);
	}

	public void startTimerForRounds() {
		TimerTask roundTimer = new TimerForTheRounds();
		this.timer = new Timer();
		this.timer.schedule(roundTimer, 1 * 1000, 5000);
	}

	public void whenToStopTheTimer() {
		boolean died = true;
		List<Robot> robots = game.getRobotList();
		for (int i = 0; i < robots.size(); i++) {
			if (!robots.get(i).getState().equals(RobotState.died)) {
				died = false;
			}
		}
		if (died && game.getCleanersList().size() == 0) {
			timer.cancel();
			time.cancel();
			View.getPlayTheGame().getTime().setText("GAME OVER");
			// View.scoreGame();

		}
	}

	private class TimerForTheRounds extends TimerTask {

		@Override
		public void run() {
			game.start();
			View.getDrawPanel().repaint();
			whenToStopTheTimer();
		}
	}

	public void startTimerForRoundsCleaner() {
		TimerTask roundTimer = new TimerForTheRoundsCleaner();
		this.timerCleaner = new Timer();
		this.timerCleaner.schedule(roundTimer, 1 * 1000, 200);
	}

	public boolean whenToStopTheTimerCleaner() {
		if (game.getCleanersList().size() == 0) {
			timerCleaner.cancel();
			return true;
		}
		return false;
	}

	private class TimerForTheRoundsCleaner extends TimerTask {

		@Override
		public void run() {
			if (!whenToStopTheTimerCleaner()) {
				game.startTheCleaners();
				View.getDrawPanel().repaint();
			}
		}
	}
	
	public void startTheTime() {
		gametime = 0;
		GameTime gameTime = new GameTime();
		this.time = new Timer();
		time.schedule(gameTime, 0,1000);
		
	}
	
	
	private class GameTime extends TimerTask{

		@Override
		public void run() {
			gametime++;
			View.getPlayTheGame().getTime().setText(gametime+"");
			
		}
		
	}
}