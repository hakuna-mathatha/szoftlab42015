package Phoebe.testhelper;

import Phoebe.gamepackage.CleanerRobot;
import Phoebe.gamepackage.Displacement;
import Phoebe.gamepackage.Game;
import Phoebe.gamepackage.Robot;
import Phoebe.trackpackage.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHelper {

    private static Robot r1;
    private static Scanner scanInTest;
    private static Barrier barrier;
    private static CleanerRobot cr1;

    private enum Command {help, exit, newgame, placeBarrier, placeRobot, placeCleaner, start}

    public static boolean vege = false;
    private static Game g;

    //a valtozo eldonti hogy a parancsokat konzolon adjuk e be eppen vagy fajlbol olvastuk be
    public static boolean fajlbol;

    //a t�mb amibe a parancsokat a fajlbol beolvassuk
    public static List<String> Commands;

    //megk�ne adni szerintem minden objektumot el�re amit haszn�lhatunk tesztekn�l
    //...

    public static void initialize() {
        fajlbol = false;
        Commands = new ArrayList<String>();
        //itt p�ld�nyos�tani k�ne mindent, a p�ld�nyok attributumait a tesztek elej�n k�ne mindig �ll�tani megfelel�re
    }

    public static void kiertekel(String parancs) {
        Command comm = null;
        try{
            comm = Command.valueOf(parancs);
        }catch(Exception e) {
            System.out.println("Incorrect Command");
        }
        // ide k�ne valami, ami a param�terezett parancsb�l leveszi a param�tereket az alapj�n be�ll�t n�h�ny seg�dv�ltoz�t
        //k�s�bb a seg�dv�ltoz�kkal �ll�tod az objektumok param�rtereit a switch case megfelel� �g�ban
        // miut�n a seg�dv�ltoz�k be�ll�t�sa megt�rt�nt a parancs legyen egyenl� a param�terez�s n�lk�li eredeti parancsal (ami megtal�lhat� a Command-ok k�z�tt)

        try {
            switch (comm) {
                case newgame:
                   g = new Game();
                    break;
                case placeRobot:
                    createRobot();
                    System.out.println();
                    break;
                case placeBarrier:
                    createBarrier();
                    break;
                case placeCleaner:
                    createCleaner();
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
        } catch (Exception e) {
            System.out.println("Exception in switch case.");
            e.printStackTrace();
        }
    }

    private static void createCleaner() {
        System.out.println("Give the actual position (form: x;y): ");
        String[] actual_pos = scanInTest.nextLine().split(";");
        Coordinate actual_coord = new Coordinate(Integer.valueOf(actual_pos[0]),Integer.valueOf(actual_pos[1]));
        System.out.println("Give the displacement (form: x;y): ");
        String[] disp = scanInTest.nextLine().split(";");
        Displacement displacement = new Displacement(Integer.valueOf(disp[0]),Integer.valueOf(disp[1]));
        System.out.println("Give the last position (form: x;y): ");
        String[] last_pos = scanInTest.nextLine().split(";");
        Coordinate last_coord = new Coordinate(Integer.valueOf(last_pos[0]),Integer.valueOf(last_pos[1]));

        cr1 = new CleanerRobot(actual_coord,displacement,last_coord);
    }

    private static void createBarrier() {
        System.out.println("Give the number of the type (1:putty 2:oil 3:pure 4:edge)");
        int type = Integer.valueOf(scanInTest.nextLine());
        switch (type){
            case 1:
                barrier = new Putty();
                break;
            case 2:
                barrier = new Oil();
                break;
            case 3:
                barrier = new Pure();
                break;
            case 4:
                barrier = new Edge();
                break;
        }
        System.out.println("Give the position of the barrier (form: x;y):");
        String[] position = scanInTest.nextLine().split(";");
        Coordinate coordinate = new Coordinate(Integer.valueOf(position[0]),Integer.valueOf(position[1]));
        barrier.setPosition(coordinate);
        System.out.println("Give the start position(x,y), width and height of the trackpart (form: x;y;w;h):");
        String[] trackpart = scanInTest.nextLine().split(";");
        TrackPart trackPart = new JumpablePart(new Coordinate(Integer.valueOf(trackpart[0]),Integer.valueOf(trackpart[1])),Double.valueOf(trackpart[2]),Double.valueOf(trackpart[3]));
        barrier.setPosition(coordinate);
        barrier.setTrackPart(trackPart);
    }

    private static void createRobot() {
        System.out.println("Give the actual position (form: x;y): ");
        String[] actual_pos = scanInTest.nextLine().split(";");
        Coordinate actual_coord = new Coordinate(Integer.valueOf(actual_pos[0]),Integer.valueOf(actual_pos[1]));
        System.out.println("Give the displacement (form: x;y): ");
        String[] disp = scanInTest.nextLine().split(";");
        Displacement displacement = new Displacement(Integer.valueOf(disp[0]),Integer.valueOf(disp[1]));
        System.out.println("Give the last position (form: x;y): ");
        String[] last_pos = scanInTest.nextLine().split(";");
        Coordinate last_coord = new Coordinate(Integer.valueOf(last_pos[0]),Integer.valueOf(last_pos[1]));

        r1 = new Robot(actual_coord,displacement,last_coord);
    }

    public static void main(String[] args) {

        String parancs;

        initialize();
        scanInTest = new Scanner(System.in);


        System.out.print("From where do you want to run the test:\nconsole/file\n");
        parancs = scanInTest.nextLine();
        if (parancs.equals("console")) {
            fajlbol = false;
            while (TestHelper.vege != true) {
                System.out.print("-------------------new command------------------------\n");
                System.out.println("Give the command : ");
                parancs = scanInTest.nextLine();
                if (parancs != null)
                    TestHelper.kiertekel(parancs);
            }
        } else if (parancs.equals("file")) {
            fajlbol = true;
            System.out.println("Give the file full path: ");
            parancs = scanInTest.nextLine();
            try {
                File f = new File(parancs);
                //ha tenyleg elerheto a fajl akkor itt beolvasni
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();
                while (line != null) {
                    Commands.add(line);
                    br.readLine();
                }

            } catch (Exception e) {
                System.out.println("Cannot access the file.\n ");
            }
            //utana sorban kiertekeles
            for (String c : Commands) {
                kiertekel(c);
            }
        } else {
            System.out.print("Incorrect command");
        }


        System.exit(0);
    }

}
