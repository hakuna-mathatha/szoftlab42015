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
	private Game game; 

	

	public Control() {
		
		addTheControlLogic();

	}
	
	public Game getGame() {
		return game;
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

	public void turnLeft(Robot bot) {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle()+1);
		bot.setDisplacement(d);
	
		System.out.println("left"+ " "+bot.getDisplacement().getAngle());
	};

	public void turnRight(Robot bot) {
		Displacement d = bot.getDisplacement();
		d.setAngle(d.getAngle()-1);
		bot.setDisplacement(d);
	
		System.out.println("right"+ " "+bot.getDisplacement().getAngle());
	};

	public void accelerate(Robot bot) {
		Displacement d = bot.getDisplacement();
		d.setVelocity(d.getVelocity()+1);
		bot.setDisplacement(d);
	
		System.out.println("acc"+ " "+bot.getDisplacement().getVelocity());
	};

	public void slowDown(Robot bot) {
		Displacement d = bot.getDisplacement();
		d.setVelocity(d.getVelocity()-1);
		bot.setDisplacement(d);
	
		System.out.println("slow"+ " "+bot.getDisplacement().getVelocity());
	};

	public void putOil(Robot bot) {

	};

	public void putPutty(Robot bot) {

	};

	private void addTheControlLogic() {
		
		addNewGameListener();
	}
	
	private void addAccListener(){
		JPanel jPanel = View.getPlayTheGame().getjPanel();

		KeyEvent acc = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
		KeyEvent acc2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc), "accelerate");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc2), "accelerate");

		jPanel.getActionMap().put("accelerate", new AccelerateListener());
	}
	
	private void addSlowListener(){
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent slow = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_S, KeyEvent.CHAR_UNDEFINED);
		KeyEvent slow2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow), "slow");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow2), "slow");

		jPanel.getActionMap().put("slow", new SlowDownListener());

	}
	
	private void addTurnRightListener(){
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent right = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_D, KeyEvent.CHAR_UNDEFINED);
		KeyEvent right2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right), "right");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right2), "right");

		jPanel.getActionMap().put("right", new TurnRightListener());
	}
	
	private void addTurnLeftListener(){
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent left = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
		KeyEvent left2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left), "left");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left2), "left");

		jPanel.getActionMap().put("left", new TurnLeftListener());
	}
	
	private void addNewGameListener(){
		JButton newGameButton = View.getNewGameMenu().getBtn_loadmap();
		newGameButton.addActionListener(new NewGameListener(View.getNewGameMenu().getComboBox()));
	}
	
	public Robot chooseRobot(ActionEvent e){
		Robot bot;
		String s = e.getActionCommand();
		if(s==null){
			System.out.println("2.");
			bot = game.getRobotList().get(1);
		}
		else{
			System.out.println("1.");
			bot = game.getRobotList().get(0);
		}
		
		return bot;
	}
	
	private void startNewGame() {
		game = new Game();
        game.setControl(Control.this);
        
        PlayTheGame game = new PlayTheGame("Phoebe");
        
        View.setPlayTheGame(game);
        
        addAccListener();
		addSlowListener();
		addTurnRightListener();
		addTurnLeftListener();
	}

	private class AccelerateListener extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {

			Robot bot = chooseRobot(arg0);
			accelerate(bot);
		}

	}
	

	private class SlowDownListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			slowDown(bot);
		
		}

	}
	
	private class TurnRightListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			turnRight(bot);

		}

	}
	
	private class TurnLeftListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Robot bot = chooseRobot(arg0);
			turnLeft(bot);

		}

	}
	
	   private class NewGameListener implements ActionListener {

	        JComboBox<String> comboBox;
	        public NewGameListener(JComboBox<String> comboBox) {
	            this.comboBox=comboBox;
	        }

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	            String map = (String)comboBox.getSelectedItem();
	            
	    		startNewGame();
	    		
	            View.PlayTheGame();
	        }
	    }

}