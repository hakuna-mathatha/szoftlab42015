package Phoebe.gui;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class View {

	protected static ArrayList<Painter> painters;

	private static Menu menu;
	private static NewGameMenu newGameMenu;
	private static Score score;
	private static PlayTheGame playTheGame;

	public View() {
		painters = new ArrayList<Painter>();

		menu = new Menu("Fõmenü");
		newGameMenu = new NewGameMenu("Új játék");
		score = new Score("Végeredmény");
		menu.setVisible(true);
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

	protected static void addToList(Painter painter) {
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

	protected void drawImage() {
		for (Iterator<Painter> iterator = painters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint();
			}
		}
	}

}
