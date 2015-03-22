package Phoebe.helperpackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	// Legyen statikus a Game peldany igy az egyes parancsoknal elerhetoek a
	// Game ben peldanyositott objektumok. Ehhez azok a Game ban public-ok
	public static Game g;
	public static String parancs = null;
	public static JTextField text;
	private enum Commands {
		exit, put_oil, put_putty, one_round, get_winner, next_position, help
	}

	public static void kiertekel(String parancs) {
		Commands comm = null;
		try {
			comm = Commands.valueOf(parancs);
		} catch (Exception e) {
			System.out.println("Incorrect Command");
		}

		// Legyenek adottak, hogy a fuggveny hivasoknal ezek lehessenek a
		// parameterek
		Coordinate coord = new Coordinate();
		Displacement disp = new Displacement();
		Putty putty = new Putty();
		Oil oil = new Oil();
		JumpablePart part1 = new JumpablePart();
		Robot r = g.bots.get(0);
		try {
			switch (comm) {
			case exit:
				vege = true;
				System.exit(0);
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
				// g.bots.get(0).calcCoordinate(coord, disp);
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
		} catch (Exception e) {

		}
	}

	
	

	
	
	
	
	public static void main(String[] args) throws IOException {
		// Inicializálás szakasz:
		g = new Game();
		g.start();
		
		
		// Scanner scanIn = new Scanner(System.in);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// ----------------------------------------------------------------------------------------

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		JFrame frame = new JFrame("Demo");
	
		frame.setSize(800, 800);

//		frame.pack();
		// int s1 = frame.getWidth();
		// int s2 = frame.getHeight();
		// frame.setLocation(width / 2 - s1 / 2, height / 2 - s2 / 2);

		// frame.setResizable(false);`
		
		JTextArea textarea = new JTextArea();
		JPanel panel1 = new JPanel();
		panel1.add(textarea);
		JScrollPane scroll = new JScrollPane (textarea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton b = new JButton("Run");
		text = new JTextField(20);
		JLabel lable = new JLabel("Give me the command: ");
		panel1.add(lable, BorderLayout.WEST);
		panel1.add(text, BorderLayout.CENTER);
		JPanel panel2 = new JPanel(); 
		panel2.add(scroll, BorderLayout.NORTH);
		ActionListener act = new RunActLis();
		b.addActionListener(act);
		panel1.add(b, BorderLayout.EAST);
		
	
		
		frame.add(panel2, BorderLayout.NORTH);
		frame.add(panel1, BorderLayout.CENTER);
		CustomOutputStream c = new CustomOutputStream(textarea);
		PrintStream s = new PrintStream(c);
	

		System.setOut(s);

	
		frame.setVisible(true);
		
		

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g = new Game();
		g.start();
		
		// ----------------------------------------------------------------------------------------

		// Parancsok lekezelése:
//		while (Helper.vege != true) {
			System.out.print("-------------------new command------------------------\n");
			System.out.println("Give the command : ");

		

			// parancs = scanIn.nextLine();
//			parancs = in.readLine();
		
//			if (parancs != null)
//				Helper.kiertekel(parancs);
//
		}

		// scanIn.close();

//	}
	
	
	
	static class RunActLis implements ActionListener{

	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 parancs = text.getText();
			 System.out.println(parancs);
			 if (parancs != null)
					Helper.kiertekel(parancs);
			 System.out.print("-------------------new command------------------------\n");
				System.out.println("Give the command : ");

			
			
		}
		
	}

	
}