package Phoebe.gui;

import Phoebe.painter.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by K�vesdi on 2015.05.01..
 */
public class View {
	public static int scale = 1; // annak nyilvantartasa, hogy mennyivel kell
									// valtoztatni a kep meretet a BasePainter
									// hasznalja

	// listak az azonos tipusu Paintereknek
	private static ArrayList<TrackPartPainter> trackPartPainters;
	private static ArrayList<BarrierPainter> barrierPainters;
	private static ArrayList<BotPainter> botPainters;
	private static Menu menu;
	private static NewGameMenu newGameMenu;
	private static Score score;
	private static PlayTheGame playTheGame;
	private static DrawPanel drawPanel;

	public View() {
		trackPartPainters = new ArrayList<TrackPartPainter>();
		barrierPainters = new ArrayList<BarrierPainter>();
		botPainters = new ArrayList<BotPainter>();
		menu = new Menu("Fomenu");
		newGameMenu = new NewGameMenu("Uj jatek");
		score = new Score("Vegeredmeny");
		menu.setVisible(true);
	}

	public static ArrayList<TrackPartPainter> getTrackPartPainters() {
		return trackPartPainters;
	}

	public static void setTrackPartPainters(ArrayList<TrackPartPainter> trackPartPainters) {
		View.trackPartPainters = trackPartPainters;
	}

	public static ArrayList<BarrierPainter> getBarrierPainters() {
		return barrierPainters;
	}

	public static void setBarrierPainters(ArrayList<BarrierPainter> barrierPainters) {
		View.barrierPainters = barrierPainters;
	}

	public static ArrayList<BotPainter> getBotPainters() {
		return botPainters;
	}

	public static void setBotPainters(ArrayList<BotPainter> botPainters) {
		View.botPainters = botPainters;
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

	// Painter hozzaadasa TrackPartPainterek listajahoz
	protected static void addToTrackPartPainters(TrackPartPainter trackPartPainter) {
		synchronized (trackPartPainters) {
			trackPartPainters.add(trackPartPainter);

		}
	}

	// Painter hozzadasa a BarrierPainter listajahoz
	public static void addToBarrierPainters(BarrierPainter barrierPainter) {
		synchronized (barrierPainters) {
			barrierPainters.add(barrierPainter);

		}
	}

	// Painter hozzaadasa a BotPainterek listajahoz
	public static void addToBotPainters(BotPainter botPainter) {
		synchronized (botPainters) {
			botPainters.add(botPainter);
		}
	}

	public static void newGame() {
		menu.setVisible(false);
		newGameMenu.setVisible(true);
	}

	public static void backToMainMenu() {
		score.setVisible(false);
		menu.setVisible(true);
	}

	public static void PlayTheGame() {
		newGameMenu.setVisible(false);
		playTheGame.setVisible(true);
	}

	public static void scoreGame() {
		playTheGame.setVisible(false);
		score.setVisible(true);
	}

	public static PlayTheGame getPlayTheGame() {
		return playTheGame;
	}

	public static void setPlayTheGame(PlayTheGame playTheGame) {
		View.playTheGame = playTheGame;
	}

	public void reStart() {
		trackPartPainters = new ArrayList<TrackPartPainter>();
		barrierPainters = new ArrayList<BarrierPainter>();
		botPainters = new ArrayList<BotPainter>();
	}

	// TrackPartokat tartlamazo listan iteralas, karbantartas, rajzolas
	public static void drawTrackParts(Graphics g) {
		synchronized (trackPartPainters) {
			for (Iterator<TrackPartPainter> iterator = trackPartPainters.iterator(); iterator.hasNext();) {
				Painter painter = iterator.next();
				if (!painter.hasObservable()) {
					iterator.remove();
				} else {
					painter.onPaint(g);
				}
			}
		}
		
	}

	// Barriereket tartlamazo listan iteralas, karbantartas, rajzolas
	public static void drawBarriers(Graphics g) {
		synchronized (barrierPainters) {
			for (Iterator<BarrierPainter> iterator = barrierPainters.iterator(); iterator.hasNext();) {
				Painter painter = iterator.next();
				if (!painter.hasObservable()) {
					iterator.remove();
				} else {
					painter.onPaint(g);
				}
			}
		}
	}

	// Botokat tartlamazo listan iteralas, karbantartas, rajzolas
	public static void drawBots(Graphics g) {
		synchronized (botPainters) {
			for (Iterator<BotPainter> iterator = botPainters.iterator(); iterator.hasNext();) {
				Painter painter = iterator.next();
				if (!painter.hasObservable()) {
					iterator.remove();
				} else {
					painter.onPaint(g);
				}
			}
		}
	
	}


	// elemek kirajzolasa, nincs kitakaras
	public static void drawImage(Graphics g) {
		drawTrackParts(g);
		drawBarriers(g);
		drawBots(g);
	}

}
