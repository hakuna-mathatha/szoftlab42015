package Phoebe.helperpackage;

import Phoebe.gamepackage.Game;

public class Helper {
	public static boolean vege = false;
	
	public static void kiertekel(String parancs){
		if(parancs == "exit"){			
			vege = true;
		}
		else if(parancs == "put oil"){
			System.out.println("	Olaj lerakasa.");
		}
		else if(parancs == "put putty"){
			System.out.println("	Ragacs lerakasa.");
		}
		else if(parancs == "one round"){
			System.out.println("	Robotok leptetese.");
		}
		else{
			System.out.println("Helytelen parancs.");			
		}			
	}
	
	
	public static void main(String[] args){
		//Inicializ�l�s szakasz:
		Game g = new Game(); 
		
		//Parancsok lekezel�se:
		while(Helper.vege != true){ 
			String parancs = System.console().readLine();
			Helper.kiertekel(parancs);	
		}	
		
		//J�t�k v�g�n�l:
		System.out.println("	Gyoztes nevenek megadasa.");
		System.exit(0);
	}
}