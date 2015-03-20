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
	Coordinate coord = null;
	Displacement disp = null;
	Putty putty = null;
	Oil oil = null;
	JumpablePart part1 = null;
	Robot r = null;
	private static Helper instance = null;

	public Helper(){}

	public static Helper getInstance(){
		return instance==null ? instance = new Helper() : instance;
	}

	private enum Commands{
		exit, put_oil, put_putty, one_round, get_winner, next_position, help, init
	}

	public void kiertekel(String parancs) {
		Commands comm = null;
		try{
			comm = Commands.valueOf(parancs);
		}catch(Exception e){
			System.out.println("Incorrect Command");
		}
		
		
		//Legyenek adottak, hogy a fuggveny hivasoknal ezek lehessenek a parameterek

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
                g.bots.get(0).calcCoordinate(coord, disp);
				break;
			case get_winner:
				g.getWinner();
				break;
			case next_position:
				g.bots.get(0).calcCoordinate(coord, disp);
				break;
            case help:
				if(coord == null){
					System.out.println("\t\tinit: First, you need to initialize the Game");
				}
				else{
					System.out.println("\tYou can choose from the following commands:");
					System.out.println("\t\tput_oil: You can put oil to the track");
					System.out.println("\t\tput_putty: You can put putty to the track");
					System.out.println("\t\tone_round: You can move your robots");
					System.out.println("\t\tget_winner: You can get the winner");
					System.out.println("\t\tnext_position: You can get your robot next position");
					System.out.println("\t\texit: Exit from the program");
				}
                break;
			case init:
				g = new Game();
				g.start();
				coord = new Coordinate();
				disp = new Displacement();
				putty = new Putty();
				oil = new Oil();
				part1 =  new JumpablePart();
				r = g.bots.get(0);
				System.out.println("Initialization done!");
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


		// Parancsok lekezelése:
		while (Helper.vege != true) {
			System.out.print("-------------------new command------------------------\n");
			System.out.println("Give the command : ");

			String parancs;

			Scanner scanIn = new Scanner(System.in);
			parancs = scanIn.nextLine();

			if (parancs != null)
				Helper.getInstance().kiertekel(parancs);

		}

		System.exit(0);
	}
}