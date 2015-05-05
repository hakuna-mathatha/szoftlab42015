package Phoebe.gui;

import Phoebe.trackpackage.Track;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class View {

	//itt tartjuk nyilván, hogy mennyivel kell változtatni a képek méretét,
	//BasePainter használja
	public static int scale = 1;

	//listák az azonos típusú Paintereknek
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

		menu = new Menu("FÅ‘menï¿½");
		newGameMenu = new NewGameMenu("ï¿½j jï¿½tï¿½k");
		score = new Score("Vï¿½geredmï¿½ny");
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

	//Painter hozzáadása a TrackPartPainterek listájához
	protected static void addToTrackPartPainters(TrackPartPainter trackPartPainter) {
		trackPartPainters.add(trackPartPainter);
	}

	//Painter hozzáadása a BarrierPainter listájához
	protected static void addToBarrierPainters(BarrierPainter barrierPainter) {
		barrierPainters.add(barrierPainter);
	}

	//Painter hozzáadása a BotPainterek listájához
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

	//TrackPartokat tartlamazó listán iterálás, karbantartás, rajzolás
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

	//Barriereket tartlamazó listán iterálás, karbantartás, rajzolás
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

	//Botokat tartlamazó listán iterálás, karbantartás, rajzolás
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

	//elemek kirajzolása, nincs kitakarás
	public static void drawImage() {
		drawTrackParts();
		drawBarriers();
		drawBots();
	}
}
