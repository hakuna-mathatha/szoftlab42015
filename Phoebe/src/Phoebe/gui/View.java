package Phoebe.gui;

import Phoebe.trackpackage.Track;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class View {

	//itt tartjuk nyilv�n, hogy mennyivel kell v�ltoztatni a k�pek m�ret�t,
	//BasePainter haszn�lja
	public static int scale = 1;

	//list�k az azonos t�pus� Paintereknek
	protected static ArrayList<TrackPartPainter> trackPartPainters;
	protected static ArrayList<BarrierPainter> barrierPainters;
	protected static ArrayList<BotPainter> botPainters;

	private static Menu menu;
	private static NewGameMenu newGameMenu;
	private static Score score;
	private static PlayTheGame playTheGame;

	public View() {
		trackPartPainters = new ArrayList<TrackPartPainter>();
		barrierPainters = new ArrayList<BarrierPainter>();
		botPainters = new ArrayList<BotPainter>();

		menu = new Menu("Főmen�");
		newGameMenu = new NewGameMenu("�j j�t�k");
		score = new Score("V�geredm�ny");
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

	//Painter hozz�ad�sa a TrackPartPainterek list�j�hoz
	protected static void addToTrackPartPainters(TrackPartPainter trackPartPainter) {
		trackPartPainters.add(trackPartPainter);
	}

	//Painter hozz�ad�sa a BarrierPainter list�j�hoz
	protected static void addToBarrierPainters(BarrierPainter barrierPainter) {
		barrierPainters.add(barrierPainter);
	}

	//Painter hozz�ad�sa a BotPainterek list�j�hoz
	protected static void addToBotPainters(BotPainter botPainter) {
		botPainters.add(botPainter);
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

	//TrackPartokat tartlamaz� list�n iter�l�s, karbantart�s, rajzol�s
	public static void drawTrackParts() {
		for (Iterator<TrackPartPainter> iterator = trackPartPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint();
			}
		}
	}

	//Barriereket tartlamaz� list�n iter�l�s, karbantart�s, rajzol�s
	public static void drawBarriers() {
		for (Iterator<BarrierPainter> iterator = barrierPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint();
			}
		}
	}

	//Botokat tartlamaz� list�n iter�l�s, karbantart�s, rajzol�s
	public static void drawBots() {
		for (Iterator<BotPainter> iterator = botPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint();
			}
		}
	}

	//elemek kirajzol�sa, nincs kitakar�s
	public static void drawImage() {
		drawTrackParts();
		drawBarriers();
		drawBots();
	}
}
