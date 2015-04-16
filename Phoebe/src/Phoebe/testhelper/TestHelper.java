package Phoebe.testhelper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHelper {
	private enum Command{help, exit, newgame, placeBarrier, placeRobot, placeCleaner, start}
	public static boolean vege = false;
	private static Scanner scanInTest;
	public static String parancs;
	
	//a valtozo eldonti hogy a parancsokat konzolon adjuk e be eppen vagy fajlbol olvastuk be
	public static boolean fajlbol;
	
	//a t�mb amibe a parancsokat a fajlbol beolvassuk
	public static List<String> Commands;
	
	//megk�ne adni szerintem minden objektumot el�re amit haszn�lhatunk tesztekn�l
	//...
	
	public static void initialize(){
		fajlbol = false;
		Commands = new ArrayList<String>();
		//itt p�ld�nyos�tani k�ne mindent, a p�ld�nyok attributumait a tesztek elej�n k�ne mindig �ll�tani megfelel�re	
	}
	
	public static void kiertekel(String parancs) {
		Command comm = null;
		// ide k�ne valami, ami a param�terezett parancsb�l leveszi a param�tereket az alapj�n be�ll�t n�h�ny seg�dv�ltoz�t
		//k�s�bb a seg�dv�ltoz�kkal �ll�tod az objektumok param�rtereit a switch case megfelel� �g�ban
		// miut�n a seg�dv�ltoz�k be�ll�t�sa megt�rt�nt a parancs legyen egyenl� a param�terez�s n�lk�li eredeti parancsal (ami megtal�lhat� a Command-ok k�z�tt)
		
		try{
			switch (comm) {
			case exit:
				vege = true;
				break;
			case help:
                System.out.println("\tYou can choose from the following commands:");
                System.out.println("\t\texit: Exit from the program");
                break;
			default:
				System.out.println("Incorrect command.");
				break;
			}
		}catch(Exception e){
			System.out.println("Exception in switch case.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		initialize();
		scanInTest = new Scanner(System.in);
		parancs = scanInTest.nextLine();
		
		while (TestHelper.vege != true) {
			System.out.print("-------------------console/file path:------------------------\n");
			if(parancs.equals("command")){
				fajlbol = false;
				while (TestHelper.vege != true) {
					System.out.print("-------------------new command------------------------\n");
					System.out.println("Give the command : ");
					parancs = scanInTest.nextLine();
					if (parancs != null)
						TestHelper.kiertekel(parancs);
				}		
			}
			else if(!parancs.equals(null)){
				fajlbol = true;
				try{
					File f = new File(parancs); 
					//ha tenyleg elerheto a fajl akkor itt beolvasni
					
					//utana sorban kiertekeles
					for(int i = 0; i < Commands.size(); i++){
						String c = Commands.get(i);
						kiertekel(c);						
					}
						
				}
				catch(Exception e){
					System.out.println("Cannot acces the file.\n ");
				}
			}
		}
		
		System.exit(0);
	}
	
}
