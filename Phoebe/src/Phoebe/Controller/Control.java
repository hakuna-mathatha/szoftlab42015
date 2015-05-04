package Phoebe.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private static Game game = null;
	private static ControlPlayTheGame controlPlayGame;
	private ControlMenu controlMenu;
	private ControlScore controlScore;
	private ControlNewGameMenu controlNewGameMenu;
	
	public Control() {
		controlPlayGame = new ControlPlayTheGame(game);
		controlMenu = new ControlMenu();
		controlScore =  new ControlScore();
		controlNewGameMenu = new ControlNewGameMenu(this);
		addTheControlLogic();
	}
	
	public static ControlPlayTheGame getControlPlayGame() {
		return controlPlayGame;
	}

	public static void setControlPlayGame(ControlPlayTheGame controlPlayGame) {
		Control.controlPlayGame = controlPlayGame;
	}

	
	public static Game getGame() {
		return Control.game;
	}

	public static void setGame(Game game) {
		Control.game = game;
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
	
}