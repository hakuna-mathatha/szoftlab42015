package Phoebe.Controller;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Game;
import Phoebe.gamepackage.Robot;
import Phoebe.gui.PlayTheGame;
import Phoebe.gui.View;
import Phoebe.painter.DrawPanel;
import Phoebe.painter.RobotPainter;
import Phoebe.trackpackage.Coordinate;

public class Control {

	protected View view;
	private Game game = null;
	private static ControlPlayTheGame controlPlayTheGame;
	private static ControlMenu controlMenu;
	private static ControlScore controlScore;
	private static ControlNewGameMenu controlNewGameMenu;
	private static Timer timer;

	public Control() {
		controlPlayTheGame = new ControlPlayTheGame(game); 
		controlMenu = new ControlMenu();
		controlScore = new ControlScore();
		controlNewGameMenu = new ControlNewGameMenu(this);
		addTheControlLogic();
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

	public void startNewGame() {
		view.reStart();
		inicializeGame();

		PlayTheGame playTheGame = new PlayTheGame("Phoebe");
		
		view.setDrawPanel(playTheGame.getDrawPanel());
		
		DrawPanel.setView(view);
		
		View.setPlayTheGame(playTheGame);

		controlPlayTheGame.addPlayTheGameListener();
		startTimerForRounds();
	}
	
	public void inicializeGame(){
		this.game = new Game();
		this.game.setControl(this);
		controlPlayTheGame.setGame(game);
		game.getTrack().create();
		
		game.addRobotToTheGame(new Coordinate(100,5),new Displacement(0.1, 1), 1);
		game.addRobotToTheGame(new Coordinate(5,100),new Displacement(-0.1, 1), 2);

	}
	
	public void startTimerForRounds(){
		TimerTask roundTimer = new TimerForTheRounds();
		this.timer = new Timer();
		this.timer.schedule(roundTimer, 1 * 1000, 7*1000);
	}
	
	

	
	private class TimerForTheRounds extends TimerTask{

		@Override
		public void run() {
			game.start();	
			View.getDrawPanel().repaint();
			
		}
		
	}

}