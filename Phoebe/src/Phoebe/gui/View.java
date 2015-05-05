package Phoebe.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

import Phoebe.painter.Painter;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class View {

	protected static ArrayList<Painter> painters;

	private static Menu menu;
	private static NewGameMenu newGameMenu;
	private static Score score;
	private static PlayTheGame playTheGame;
	private static DrawPanel drawPanel = null;

	public View() {
		painters = new ArrayList<Painter>();

		menu = new Menu("Főmen�");
		newGameMenu = new NewGameMenu("�j j�t�k");
		score = new Score("V�geredm�ny");
		menu.setVisible(true);
	}
	
	public static DrawPanel getDrawPanel() {
		return drawPanel;
	}

	public static void setDrawPanel(DrawPanel drawPanel) {
		View.drawPanel = drawPanel;
	}
	
	public static Menu getMenu() {
		return menu;
	}


	public static void setMenu(Menu menu) {
		View.menu = menu;
	}


	public static Score getScore() {
		return score;
	}


	public static void setScore(Score score) {
		View.score = score;
	}
	
	
	public static NewGameMenu getNewGameMenu() {
		return newGameMenu;
	}

	public static void setNewGameMenu(NewGameMenu newGameMenu) {
		View.newGameMenu = newGameMenu;
	}

	public static void addToList(Painter painter) {
		painters.add(painter);
	}
	
	
	public static void newGame(){
        menu.setVisible(false);
        newGameMenu.setVisible(true);
    }

    public static void backToMainMenu(){
        score.setVisible(false);
        menu.setVisible(true);
    }

    public static void PlayTheGame(){
        newGameMenu.setVisible(false);
        playTheGame.setVisible(true);
    }
    public static void scoreGame(){
        playTheGame.setVisible(false);
        score.setVisible(true);
    }

	public static PlayTheGame getPlayTheGame() {
		return playTheGame;
	}

	public static void setPlayTheGame(PlayTheGame playTheGame) {
		View.playTheGame = playTheGame;
	}
	
	
	


	public void drawImage(Graphics g) {
		for (Iterator<Painter> iterator = painters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint(g);
			}
		}
		
		

	}
}
