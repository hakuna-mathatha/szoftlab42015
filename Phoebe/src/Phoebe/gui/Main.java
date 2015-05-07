package Phoebe.gui;
import Phoebe.Controller.Control;

/**
 * Created by Peti on 2015.04.25..
 */
public class Main {

    public static void main(String[] args){
    	View view = new View();
    	Control control = new Control();
    	control.setView(view);
    }
}
