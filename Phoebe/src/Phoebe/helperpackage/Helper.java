package Phoebe.helperpackage;

import java.io.Console;
import java.util.Scanner;

import Phoebe.gamepackage.Game;
import Phoebe.trackpackage.Barrier;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.JumpablePart;
import Phoebe.trackpackage.Oil;
import Phoebe.trackpackage.Putty;

public class Helper {
	public static boolean vege = false;
	//Legyen statikus a Game peldany igy az egyes parancsoknal elerhetoek a Game ben peldanyositott objektumok. Ehhez azok a Game ban public-ok
	public static Game g;

	public static void kiertekel(String parancs) {
		// if (parancs.equals("exit")) {
		// vege = true;
		// } else if (parancs.equals("put oil")) {
		// System.out.println("	Olaj lerakasa.");
		// } else if (parancs.equals("put putty")) {
		// System.out.println("	Ragacs lerakasa.");
		// } else if (parancs.equals("one round")) {
		// System.out.println("	Robotok leptetese.");
		// } else {
		// System.out.println("Helytelen parancs.");
		// }
		
		//Legyenek adottak, hogy a fuggveny hivasoknal eyek lehessenek a parameterek
		Coordinate coord = new Coordinate();
		Putty putty = new Putty();
		Oil oil = new Oil();
		JumpablePart part1 = new JumpablePart();

		switch (parancs) {
		case "exit":
			vege = true;
			break;
		case "put oil":
			System.out.println("	Olaj lerakasa.");
			g.bots.get(0).putTheBarrier(coord, oil, part1);
			break;
		case "put putty":
			System.out.println("	Ragacs lerakasa.");
			break;
		case "one round":
			System.out.println("	Robotok leptetese.");
			break;
		case "get winner":
			System.out.println("	Gyoztes nevenek megadasa.");
			break;
		default:
			System.out.println("Helytelen parancs.");
			break;
		}
	}

	public static void main(String[] args) {
		// Inicializálós szakasz:
		g = new Game();

		// Parancsok lekezelése:
		while (Helper.vege != true) {

			System.out.println("Add meg a parancsot : ");

			String parancs;

			Scanner scanIn = new Scanner(System.in);
			parancs = scanIn.nextLine();

			if (parancs != null)
				Helper.kiertekel(parancs);

		}

		System.exit(0);
	}
}