package Phoebe.helperpackage;

import java.util.Scanner;

import Phoebe.gamepackage.Bot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Game;
import Phoebe.gamepackage.Robot;
import Phoebe.trackpackage.*;


public class Helper {
	public static boolean vege = false;
	//Legyen statikus a Game peldany igy az egyes parancsoknal elerhetoek a Game ben peldanyositott objektumok. Ehhez azok a Game ban public-ok
	public static Game g;
	
	private enum Commands{
		exit, put_oil, put_putty, one_round, get_winner, next_position, help
	}

	public static void kiertekel(String parancs) {
		Commands comm = null;
		try{
			comm = Commands.valueOf(parancs);
		}catch(Exception e) {
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
			case next_position:
				g.bots.get(0).calcCoordinate(coord, disp);
				break;
            case help:
                 System.out.println("\tYou can choose from the following commands:");
                 System.out.println("\t\tput_oil: You can put oil to the track");
                 System.out.println("\t\tput_putty: You can put putty to the track");
                 System.out.println("\t\tone_round: You can move your robots");
                 System.out.println("\t\tget_winner: You can get the winner");
                 System.out.println("\t\tnext_position: You can get your robot next position");
                 System.out.println("\t\texit: Exit from the program");
                break;
			default:
				System.out.println("Incorrect command.");
				break;
			}
		}catch(Exception e){
			
		}
	}

	public static void main(String[] args) {
		// Inicializációs szakasz:
		g = new Game();
		g.start();


//JSON típusú fájlból beolvasási példa
		String baseURL = "C:/Users/Peti/Documents/SourceTree_projects/szoftlab4/Phoebe/data/";
 		Coordinate c = (Coordinate) JSONHandler.readStream(baseURL+"coordinate.dat",Coordinate.class);
		EdgeofTheTrack edgeofTheTrack1 = (EdgeofTheTrack) JSONHandler.readStream(baseURL+"edgeoftrack.dat",EdgeofTheTrack.class);
 		System.out.println(c.getX() + " " + c.getY());


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