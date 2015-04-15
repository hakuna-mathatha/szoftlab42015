package Phoebe.testhelper;

import java.util.Scanner;

public class TestHelper {
	private enum Command{parancs1, help, exit}
	public static boolean vege = false;
	private static Scanner scanInTest;
	//megkéne adni szerintem minden objektumot elõre amit használhatunk teszteknél
	
	public static void initialize(){
		//itt példányosítani kéne mindent, a példányok attributumait a tesztek elején kéne mindig állítani megfelelõre	
	}
	
	public static void kiertekel(String parancs) {
		Command comm = null;
		try{
			comm = Command.valueOf(parancs);
		}catch(Exception e) {
            System.out.println("Incorrect Command");
        }
		
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
		while (TestHelper.vege != true) {
			System.out.print("-------------------new command------------------------\n");
			System.out.println("Give the command : ");

			String parancs;

			scanInTest = new Scanner(System.in);
			parancs = scanInTest.nextLine();

			if (parancs != null)
				TestHelper.kiertekel(parancs);
		}

		System.exit(0);
	}
	
}
