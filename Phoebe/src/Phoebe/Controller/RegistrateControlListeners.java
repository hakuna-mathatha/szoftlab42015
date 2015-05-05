package Phoebe.Controller;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.KeyStroke;



import Phoebe.gui.View;

public class RegistrateControlListeners {
	private void addAccListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();

		KeyEvent acc = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
		KeyEvent acc2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc), "accelerate");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc2), "accelerate");

		jPanel.getActionMap().put("accelerate", Control.getControlPlayTheGame().new AccelerateListener());
	}
	
	private void addAccListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();

		KeyEvent acc = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
		KeyEvent acc2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc), "acceleratedel");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc2), "acceleratedel");

		jPanel.getActionMap().put("acceleratedel", Control.getControlPlayTheGame().new AccelerateListenerDelet());
	}

	private void addSlowListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent slow = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_S, KeyEvent.CHAR_UNDEFINED);
		KeyEvent slow2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow), "slow");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow2), "slow");

		jPanel.getActionMap().put("slow", Control.getControlPlayTheGame().new SlowDownListener());

	}
	
	private void addSlowListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent slow = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_S, KeyEvent.CHAR_UNDEFINED);
		KeyEvent slow2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow), "slowdel");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow2), "slowdel");

		jPanel.getActionMap().put("slowdel", Control.getControlPlayTheGame().new SlowDownListenerDelet());

	}

	private void addTurnRightListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent right = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_D, KeyEvent.CHAR_UNDEFINED);
		KeyEvent right2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right), "right");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right2), "right");

		jPanel.getActionMap().put("right", Control.getControlPlayTheGame().new TurnRightListener());
	}
	
	private void addTurnRightListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent right = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_D, KeyEvent.CHAR_UNDEFINED);
		KeyEvent right2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right), "rightdel");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right2), "rightdel");

		jPanel.getActionMap().put("rightdel", Control.getControlPlayTheGame().new TurnRightListenerDelet());
	}

	private void addTurnLeftListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent left = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
		KeyEvent left2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left), "left");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left2), "left");

		jPanel.getActionMap().put("left",Control.getControlPlayTheGame().new TurnLeftListener());
	}
	
	private void addTurnLeftListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent left = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
		KeyEvent left2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left), "leftdel");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left2), "leftdel");

		jPanel.getActionMap().put("leftdel", Control.getControlPlayTheGame().new TurnLeftListenerDelet());
	}

	private void addPutOilListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent putOil = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_Q, KeyEvent.CHAR_UNDEFINED);
		KeyEvent putOil2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_END, KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putOil), "putoil");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putOil2), "putoil");

		jPanel.getActionMap().put("putoil", Control.getControlPlayTheGame().new PutOilListener());
	}

	private void addPutPuttyListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent putPutty = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_E, KeyEvent.CHAR_UNDEFINED);
		KeyEvent putPutty2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_PAGE_DOWN,
				KeyEvent.CHAR_UNDEFINED);

		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putPutty), "putputty");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putPutty2), "putputty");

		jPanel.getActionMap().put("putputty", Control.getControlPlayTheGame().new PutPuttyListener());
	}
	
	
	public void addAllTheListeners(){
		addAccListener();
		addSlowListener();
		addTurnRightListener();
		addTurnLeftListener();
		addPutOilListener();
		addPutPuttyListener();
		addAccListenerDelet();
		addSlowListenerDelet();
		addTurnRightListenerDelet();
		addTurnLeftListenerDelet();
	}
}
