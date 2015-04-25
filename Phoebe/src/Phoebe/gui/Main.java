package Phoebe.gui;

/**
 * Created by Peti on 2015.04.25..
 */
public class Main {

    private static Menu menu;
    private static NewGameMenu newGameMenu;
    private static Score score;

    public static void main(String[] args){
        menu = new Menu("Főmenü");
        newGameMenu = new NewGameMenu("Új játék");
        score = new Score("Végeredmény");
//        menu.pack();
        menu.setVisible(true);
    }
    public static void newGame(){
        menu.setVisible(false);
        newGameMenu.setVisible(true);
    }
    public static void startGame(){
        newGameMenu.setVisible(false);
        score.setVisible(true);
    }
    public static void backToMainMenu(){
        score.setVisible(false);
        menu.setVisible(true);
    }
}
