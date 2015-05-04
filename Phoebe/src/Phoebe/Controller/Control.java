package Phoebe.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class Control {

	protected View view;
	private Game game = null;
	private ControlPlayTheGame controlPlayGame;
	private ControlMenu controlMenu;
	private ControlScore controlScore;
	private ControlNewGameMenu controlNewGameMenu;
	private Timer timer;

	public Control() {
		controlPlayGame = new ControlPlayTheGame(game);
		controlMenu = new ControlMenu();
		controlScore = new ControlScore();
		controlNewGameMenu = new ControlNewGameMenu(this);
		addTheControlLogic();
	}

	public ControlPlayTheGame getControlPlayGame() {
		return controlPlayGame;
	}

	public void setControlPlayGame(ControlPlayTheGame controlPlayGame) {
		this.controlPlayGame = controlPlayGame;
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
		this.game = new Game();
		this.game.setControl(this);
		controlPlayGame.setGame(game);
		game.getTrack().create();

		PlayTheGame playTheGame = new PlayTheGame("Phoebe");

		View.setPlayTheGame(playTheGame);
		controlPlayGame.addPlayTheGameListener();
		
		TimerTask roundTimer = new TimerForTheRounds();
		this.timer = new Timer();
		this.timer.schedule(roundTimer, 2 * 1000, 5*1000);
	}
	
	private class TimerForTheRounds extends TimerTask{

		@Override
		public void run() {
			game.start();
		}
		
	}

}