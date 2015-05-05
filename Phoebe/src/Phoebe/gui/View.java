package Phoebe.gui;

import Phoebe.painter.BarrierPainter;
import Phoebe.painter.BotPainter;
import Phoebe.painter.DrawPanel;
import Phoebe.painter.Painter;
import Phoebe.painter.TrackPartPainter;
import Phoebe.trackpackage.Track;

import java.awt.Graphics;
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

		menu = new Menu("FÅ‘menï¿½");
		newGameMenu = new NewGameMenu("ï¿½j jï¿½tï¿½k");
		score = new Score("Vï¿½geredmï¿½ny");
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
	public static void drawTrackParts(Graphics g) {
		for (Iterator<TrackPartPainter> iterator = trackPartPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint(g);
			}
		}
	}

	//Barriereket tartlamazó listán iterálás, karbantartás, rajzolás
	public static void drawBarriers(Graphics g) {
		for (Iterator<BarrierPainter> iterator = barrierPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint(g);
			}
		}
	}

	//Botokat tartlamazó listán iterálás, karbantartás, rajzolás
	public static void drawBots(Graphics g) {
		for (Iterator<BotPainter> iterator = botPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint(g);
			}
		}
	}

	//elemek kirajzolása, nincs kitakarás
	public static void drawImage(Graphics g) {
		drawTrackParts(g);
		drawBarriers(g);
		drawBots(g);
	}
}
