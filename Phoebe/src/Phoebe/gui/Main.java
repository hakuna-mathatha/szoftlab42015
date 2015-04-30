package Phoebe.gui;

/**
 * Created by Peti on 2015.04.25..
 */
public class Main {

    private static Menu menu;
    private static NewGameMenu newGameMenu;
    private static Score score;
    private static PlayTheGame playTheGame;

    public static void main(String[] args){
        menu = new Menu("Főmenü");
        newGameMenu = new NewGameMenu("Új játék");
        score = new Score("Végeredmény");
        playTheGame = new PlayTheGame("Phoebe");
        menu.setVisible(true);
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

}
