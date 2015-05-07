package Phoebe.Controller;
import Phoebe.gamepackage.Robot;

public abstract class IControlKeys {
	protected Robot bot;
	public abstract void modifier();
	protected void setBot(Robot bot) {
		this.bot = bot;
	}
}
