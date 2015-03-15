package Phoebe.trackpackage;

import Phoebe.gamepackage.Bot;

public class Oil extends Barrier {

	@Override
	public void modifyDisplacement(Bot bot) {
		// TODO Auto-generated method stub
		System.out.println("Modositom a robot sebesseget");
		
	}

	@Override
	public void setState(Bot bot) {
		// TODO Auto-generated method stub
		System.out.println("Modositom a robot allapotat");
	}
}