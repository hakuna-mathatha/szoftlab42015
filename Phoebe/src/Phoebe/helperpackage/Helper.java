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
		exit, put_oil, put_putty, one_round, get_winner, next_position, die, explore, help
	}

	public static void kiertekel(String parancs) {
		Commands comm = null;
		try{
			comm = Commands.valueOf(parancs);
		}catch(Exception e){
			System.out.println("Incorrect Command");
		}
		
		
		//Legyenek adottak, hogy a fuggveny hivasoknal ezek lehessenek a parameterek
		Coordinate coord = new Coordinate();
		Displacement disp = new Displacement();
		Putty putty = new Putty();
		Oil oil = new Oil();
		JumpablePart part1 = new JumpablePart();
		Robot r = g.bots.get(0);
		try{
			switch (comm) {
			case exit:
				vege = true;
				break;
			case put_oil:
				r.putTheBarrier(coord, oil, part1);
				r.reduceOilRepository();
				break;
			case put_putty:
				r.putTheBarrier(coord, putty, part1);
				r.reducePuttyRepository();
				break;
                case one_round:
				r.jump(g.track);
				break;
			case get_winner:
				g.getWinner();
				break;
			case die:
				System.out.println("	Robot elhagyta a palyat, meghalt.");
//					Erre kicsit logikat is kene a fuggvenyekbe rakni hogy meg lehessen csinalni. Szerintem most erre nincs szukseg a kodot most nem kell beadni.
//				A feladat leirasban az van, hogy a szekvenciakat kell vegig kovetni a szkeleton ban. 
				break;
			case explore:
				//Ez az ami a one round lenne csak jobban ki kene fejteni, ezert a kettot egyben csinalom meg. A szekvencian ket reszbe bontva egyszerubb de itt nem lehet,
				// vagy csak tok felesleges elagazasokkal szetbontani
				
				System.out.println("	Palyaelem hatasa a robotra.");
				break;
			case next_position:

				g.bots.get(0).calcCoordinate(coord, disp);
				break;
            case help:
                 System.out.println("You can choose from the following commands:");
                 System.out.println("   put_oil: You can put oil to the track");
                 System.out.println("   put_putty: You can put putty to the track");
                 System.out.println("   one_round: You can move your robots");
                 System.out.println("   get_winner: You can get the winner");
                 System.out.println("   next_position: You can get your robot next position");
                 System.out.println("   explore: You can see what is the effect of the track to your robot");
                 System.out.println("   die: Your robot left the track and died");
                 System.out.println("   exit: Exit from the program");
                break;
			default:
				System.out.println("Incorrect command.");
				break;
			}
		}catch(Exception e){
			
		}
	}

	public static void main(String[] args) {
		// Inicializálás szakasz:
		g = new Game();
		g.start();

		// Parancsok lekezelése:
		while (Helper.vege != true) {
			System.out.print("-------------------new command------------------------\n");
			System.out.println("Give the command : ");

			String parancs;

			Scanner scanIn = new Scanner(System.in);
			parancs = scanIn.nextLine();

			if (parancs != null)
				Helper.kiertekel(parancs);

		}

		System.exit(0);
	}
}