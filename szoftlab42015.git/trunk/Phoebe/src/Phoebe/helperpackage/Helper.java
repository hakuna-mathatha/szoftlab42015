package Phoebe.helperpackage;

import java.io.Console;
import java.util.Scanner;

import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Game;
import Phoebe.gamepackage.Robot;
import Phoebe.trackpackage.Barrier;
import Phoebe.trackpackage.Coordinate;
import Phoebe.trackpackage.JumpablePart;
import Phoebe.trackpackage.Oil;
import Phoebe.trackpackage.Putty;
import Phoebe.trackpackage.Track;

public class Helper {
	public static boolean vege = false;
	//Legyen statikus a Game peldany igy az egyes parancsoknal elerhetoek a Game ben peldanyositott objektumok. Ehhez azok a Game ban public-ok
	public static Game g;
	
	private enum Commands{
		exit, put_oil, put_putty, one_round, get_winner, next_position, die, explore
	}

	public static void kiertekel(String parancs) {
		
		Commands comm = Commands.valueOf(parancs);
		
		
		//Legyenek adottak, hogy a fuggveny hivasoknal eyek lehessenek a parameterek
		Coordinate coord = new Coordinate();
		Displacement disp = new Displacement();
		Putty putty = new Putty();
		Oil oil = new Oil();
		JumpablePart part1 = new JumpablePart();
		Robot r = g.bots.get(0);
		
		switch (comm) {
		case exit:
			vege = true;
			break;
		case put_oil:
			System.out.println("	Olaj lerakasa.");

			r.putTheBarrier(coord, oil, part1);
			r.reduceOilRepository();
			
			break;
		case put_putty:
			System.out.println("	Ragacs lerakasa.");
			
			r.putTheBarrier(coord, putty, part1);
			r.reducePuttyRepository();
			
			break;
		case one_round:
			System.out.println("	Robotok leptetese.");
			
			r.jump(g.track);
			
			break;
		case get_winner:
			System.out.println("	Gyoztes nevenek megadasa.");
			
			g.getWinner();
			
			break;
		case die:
			System.out.println("	Robot elhagyta a palyat, meghalt.");
//				Erre kicsit logikat is kene a fuggvenyekbe rakni hogy meg lehessen csinalni. Szerintem most erre nincs szukseg a kodot meost nem kell beadni.
//			A feladat leirasban az van, hogy a szekvenciakat kell vegig kovetni a szkeleton ban. 
			break;
		case explore:
			//Ez az ami a one round lenne csak jobban ki kene fejteni, ezert a kettot egyben csinalom meg. A szekvencian ket reszbe bontva egyszerubb de itt nem lehet,
			// vagy csak tok felesleges elagazasokkal szetbontani
			
			System.out.println("	Palyaelem hatasa a robotra.");
			break;
		case next_position:
			System.out.println("	Kovetkezo pozicio");
			g.bots.get(0).calcCoordinate(coord, disp);
			break;
		default:
			System.out.println("Helytelen parancs.");
			break;
		}
	}

	public static void main(String[] args) {
		// Inicializálós szakasz:
		g = new Game();
		g.start();

		// Parancsok lekezelése:
		while (Helper.vege != true) {
			System.out.print("-------------------uj parancs------------------------\n");
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