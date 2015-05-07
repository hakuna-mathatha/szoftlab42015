package Phoebe.Controller;
import Phoebe.gui.View;
import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RegistrateControlListeners {
	private void addAccListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();

		KeyEvent acc = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
		KeyEvent acc2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc), "accelerate1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc2), "accelerate2");
		jPanel.getActionMap().put("accelerate1", Control.getControlPlayTheGame().new AccelerateListener1());
		jPanel.getActionMap().put("accelerate2", Control.getControlPlayTheGame().new AccelerateListener2());
	}

	private void addAccListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent acc = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_W, KeyEvent.CHAR_UNDEFINED);
		KeyEvent acc2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc), "acceleratedel1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(acc2), "acceleratedel2");
		jPanel.getActionMap().put("acceleratedel1", Control.getControlPlayTheGame().new AccelerateListenerDelet1());
		jPanel.getActionMap().put("acceleratedel2", Control.getControlPlayTheGame().new AccelerateListenerDelet2());
	}

	private void addSlowListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent slow = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_S, KeyEvent.CHAR_UNDEFINED);
		KeyEvent slow2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow), "slow1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow2), "slow2");
		jPanel.getActionMap().put("slow1", Control.getControlPlayTheGame().new SlowDownListener1());
		jPanel.getActionMap().put("slow2", Control.getControlPlayTheGame().new SlowDownListener2());

	}

	private void addSlowListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent slow = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_S, KeyEvent.CHAR_UNDEFINED);
		KeyEvent slow2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow), "slowdel1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(slow2), "slowdel2");
		jPanel.getActionMap().put("slowdel1", Control.getControlPlayTheGame().new SlowDownListenerDelet1());
		jPanel.getActionMap().put("slowdel2", Control.getControlPlayTheGame().new SlowDownListenerDelet2());

	}

	private void addTurnRightListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent right = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_D, KeyEvent.CHAR_UNDEFINED);
		KeyEvent right2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right), "right1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right2), "right2");
		jPanel.getActionMap().put("right1", Control.getControlPlayTheGame().new TurnRightListener1());
		jPanel.getActionMap().put("right2", Control.getControlPlayTheGame().new TurnRightListener2());
	}

	private void addTurnRightListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent right = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_D, KeyEvent.CHAR_UNDEFINED);
		KeyEvent right2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right), "rightdel1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(right2), "rightdel2");
		jPanel.getActionMap().put("rightdel1", Control.getControlPlayTheGame().new TurnRightListenerDelet1());
		jPanel.getActionMap().put("rightdel2", Control.getControlPlayTheGame().new TurnRightListenerDelet2());
	}

	private void addTurnLeftListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent left = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
		KeyEvent left2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left), "left1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left2), "left2");
		jPanel.getActionMap().put("left1", Control.getControlPlayTheGame().new TurnLeftListener1());
		jPanel.getActionMap().put("left2", Control.getControlPlayTheGame().new TurnLeftListener2());
	}

	private void addTurnLeftListenerDelet() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent left = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED);
		KeyEvent left2 = new KeyEvent(jPanel, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left), "leftdel1");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(left2), "leftdel2");
		jPanel.getActionMap().put("leftdel1", Control.getControlPlayTheGame().new TurnLeftListenerDelet1());
		jPanel.getActionMap().put("leftdel2", Control.getControlPlayTheGame().new TurnLeftListenerDelet2());
	}

	private void addPutOilListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent putOil = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_Q, KeyEvent.CHAR_UNDEFINED);
		KeyEvent putOil2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, InputEvent.SHIFT_DOWN_MASK, KeyEvent.VK_SHIFT,
				KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putOil), "putoil");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putOil2), "putoil");
		jPanel.getActionMap().put("putoil", Control.getControlPlayTheGame().new PutOilListener());
	}

	private void addPutPuttyListener() {
		JPanel jPanel = View.getPlayTheGame().getjPanel();
		KeyEvent putPutty = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_E, KeyEvent.CHAR_UNDEFINED);
		KeyEvent putPutty2 = new KeyEvent(jPanel, KeyEvent.KEY_PRESSED, 0, InputEvent.CTRL_DOWN_MASK, KeyEvent.VK_CONTROL,
				KeyEvent.CHAR_UNDEFINED);
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putPutty), "putputty");
		jPanel.getInputMap().put(KeyStroke.getKeyStrokeForEvent(putPutty2), "putputty");
		jPanel.getActionMap().put("putputty", Control.getControlPlayTheGame().new PutPuttyListener());
	}

	public void addAllTheListeners() {
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
