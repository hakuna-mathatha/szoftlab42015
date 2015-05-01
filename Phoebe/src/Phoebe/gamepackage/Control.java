package Phoebe.gamepackage;

import Phoebe.gui.View;

public class Control {
	
	protected View view;

	public Control(){
		view = new View();
	}

	public void turnLeft(Bot bot) {};

	public void turnRight(Bot bot) {};

	public void accelerate(Bot bot) {};

	public void slowDown(Bot bot) {};

	public void putOil(Bot bot) {};

	public void putPutty(Bot bot) {};

}