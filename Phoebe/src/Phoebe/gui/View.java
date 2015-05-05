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
 * Created by K�vesdi on 2015.05.01..
 */
public class View {

	//itt tartjuk nyilv�n, hogy mennyivel kell v�ltoztatni a k�pek m�ret�t,
	//BasePainter haszn�lja
	public static int scale = 1;

	//list�k az azonos t�pus� Paintereknek
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

		menu = new Menu("Főmen�");
		newGameMenu = new NewGameMenu("�j j�t�k");
		score = new Score("V�geredm�ny");
		menu.setVisible(true);
	}
	
	public static ArrayList<TrackPartPainter> getTrackPartPainters() {
		System.out.println("adom");
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
	
	public void reStart(){
		trackPartPainters = new ArrayList<TrackPartPainter>();
		barrierPainters = new ArrayList<BarrierPainter>();
		botPainters = new ArrayList<BotPainter>();
	}

	//TrackPartokat tartlamaz� list�n iter�l�s, karbantart�s, rajzol�s
	public static void drawTrackParts(Graphics g) {
		System.out.println("trackPart lista meret");
		System.out.println(trackPartPainters.size());
		for (Iterator<TrackPartPainter> iterator = trackPartPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()){
				iterator.remove();
			} else{
				painter.onPaint(g);
//				System.out.println("neeeemaaaaaa");
			}
		}
	}

	//Barriereket tartlamaz� list�n iter�l�s, karbantart�s, rajzol�s
	public static void drawBarriers(Graphics g) {
//		System.out.println("fffffffffffffffffffffffffff");
//		System.out.println(barrierPainters.size());
		for (Iterator<BarrierPainter> iterator = barrierPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint(g);
//				System.out.println("neeeemaaaaaa");

			}
		}
	}

	//Botokat tartlamaz� list�n iter�l�s, karbantart�s, rajzol�s
	public static void drawBots(Graphics g) {
		System.out.println("bot lista meret");
		System.out.println(botPainters.size());
		for (Iterator<BotPainter> iterator = botPainters.iterator(); iterator.hasNext();) {
			Painter painter = iterator.next();
			if (!painter.hasObservable()) {
				iterator.remove();
			} else {
				painter.onPaint(g);

			}
		}
	}

	//elemek kirajzol�sa, nincs kitakar�s
	public static void drawImage(Graphics g) {
		drawTrackParts(g);
		drawBarriers(g);
		drawBots(g);
	}
}
