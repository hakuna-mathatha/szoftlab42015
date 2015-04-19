package Phoebe.testhelper;

import Phoebe.basepackage.Base;
import Phoebe.gamepackage.*;
import Phoebe.trackpackage.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHelper {

    private static Robot r1;
    private static Scanner scanInTest;
    private static Barrier barrier;
    private static CleanerRobot cr1;
    private static Track track;
    private static Robot r2;
    private static CleanerRobot cr2;

    private enum Command {help, exit, newgame, placeBarrier, placeRobot, placeCleaner, start}
    private enum Type {putty, oil, edge, pure}

    public static boolean vege = false;
    private static Game g;


    //a valtozo eldonti hogy a parancsokat konzolon adjuk e be eppen vagy fajlbol olvastuk be
    public static boolean fajlbol;

    //a t�mb amibe a parancsokat a fajlbol beolvassuk
    public static List<String> Commands;

    //Base lista a felhasznalo altal beirt dolgokhoz
    public static List<Base> bases;

    //megk�ne adni szerintem minden objektumot el�re amit haszn�lhatunk tesztekn�l
    //...

    public static void initialize() {
        fajlbol = false;
        Commands = new ArrayList<String>();
        scanInTest = new Scanner(System.in);
        bases = new ArrayList<Base>();

        //itt p�ld�nyos�tani k�ne mindent, a p�ld�nyok attributumait a tesztek elej�n k�ne mindig �ll�tani megfelel�re
    }

    public static void kiertekel(String parancs) {
        String[] line = parancs.split(" ");
        Command comm = null;
        try {
            comm = Command.valueOf(line[0]);
        } catch (Exception e) {
            System.out.println("Incorrect Command");
        }
        // ide k�ne valami, ami a param�terezett parancsb�l leveszi a param�tereket az alapj�n be�ll�t n�h�ny seg�dv�ltoz�t
        //k�s�bb a seg�dv�ltoz�kkal �ll�tod az objektumok param�rtereit a switch case megfelel� �g�ban
        // miut�n a seg�dv�ltoz�k be�ll�t�sa megt�rt�nt a parancs legyen egyenl� a param�terez�s n�lk�li eredeti parancsal (ami megtal�lhat� a Command-ok k�z�tt)

        try {
            switch (comm) {
                case newgame:
                    g = new Game();
                    track = new Track();
                    track.create();
                    g.setTrack(track);
                    break;
                case placeRobot:
                    if(line.length==4){
                        createRobot(line[1],line[2],line[3]);
                    }else {
                        System.out.println("Give the all parameters of the Robot");
                    }
                    break;
                case placeBarrier:
                    if(line.length==3) {
                        createBarrier(line[1], line[2]);
                    }else {
                        System.out.println("Give the all parameters of the Barrier");
                    }
                    break;
                case placeCleaner:
                    if(line.length==4) {
                        createCleaner(line[1], line[2], line[3]);
                    }else {
                        System.out.println("Give the all parameters of the Cleaner");
                    }
                    break;
                case start:
                    logStartState();
                    g.start();
                    logEndState();
                    setToDefault();
                    break;
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
//  Todo: fájlba kiírni a vég állapotot a 8-as doksiban leírt formátumban
    private static void logEndState() {
        try {
            String filename = System.getProperty("user.dir")+"/result/result.txt";
            FileWriter fw = new FileWriter(filename, true);

            fw.write("\nElvárt eredmény, állapot :\n");
            for(int i= 0; i<bases.size(); i++){
                if(bases.contains(r1)){
                    fw.write("\tNormalRobot1:\n");
                    if(r1.getState().equals(RobotState.died)){
                        fw.write("state: "+r1.getState()+"\n");
                    }
                    else {
                        fw.write("\t\tposition: " + r1.getPosition() + "\n");
                        fw.write("\t\tdisplacement: " + r1.getDisplacement() + "\n");
                        fw.write("\t\tlastPostion: " + r1.getLastPosition() + "\n");
                        fw.write("\t\tstate: " + r1.getState() + "\n");
                        fw.write("\t\tveloMod: " + r1.getVelocityMod() + "\n");
                        fw.write("\t\tdirectionMod: " + r1.getDirectionMod() + "\n");
                        fw.write("\t\toilRepository: " + r1.getOilRepository() + "\n");
                        fw.write("\t\tputtyRepository: " + r1.getPuttyRepository() + "\n");
                    }
                }
                else if (bases.contains(r2)){
                    fw.write("\tNormalRobot2:\n");
                    if(r2.getState().equals(RobotState.died)){
                        fw.write("state: "+r2.getState()+"\n");
                    }
                    else{
                        fw.write("\t\tposition: " + r2.getPosition() + "\n");
                        fw.write("\t\tdisplacement: "+r2.getDisplacement()+"\n");
                        fw.write("\t\tlastPostion: "+r2.getLastPosition()+"\n");
                        fw.write("\t\tstate: " + r2.getState() +"\n");
                        fw.write("\t\tveloMod: "+ r2.getVelocityMod()+"\n");
                        fw.write("\t\tdirectionMod: "+ r2.getDirectionMod()+"\n");
                        fw.write("\t\toilRepository: "+ r2.getOilRepository()+"\n");
                        fw.write("\t\tputtyRepository: "+ r2.getPuttyRepository()+"\n");
                    }
                }
                else if(bases.contains(cr1)){
                    fw.write("\tCleanerRobot1:\n");
                    if(cr1.getState().equals(RobotState.died)){
                        fw.write("state: "+cr1.getState()+"\n");
                    }
                    else{
                        fw.write("\t\tposition: " + cr1.getPosition() + "\n");
                        fw.write("\t\tdisplacement: "+cr1.getDisplacement()+"\n");
                        fw.write("\t\tlastPostion: "+cr1.getLastPosition()+"\n");
                        fw.write("\t\tstate: " + cr1.getState() +"\n");
                    }
                }
                else if(bases.contains(cr2)){
                    fw.write("\tCleanerRobot2:\n");
                    if(cr2.getState().equals(RobotState.died)){
                        fw.write("state: "+cr2.getState()+"\n");
                    }
                    else {
                        fw.write("\t\tposition: " + cr2.getPosition() + "\n");
                        fw.write("\t\tdisplacement: " + cr2.getDisplacement() + "\n");
                        fw.write("\t\tlastPostion: " + cr2.getLastPosition() + "\n");
                        fw.write("\t\tstate: " + cr2.getState() + "\n");
                    }
                }
                else if(bases.contains(barrier)){
                    fw.write("\tBarrier:\n");
                    fw.write("\t\tType:" + barrier.getType());
                    fw.write("\t\tPosition:" + barrier.getPosition());
                }
                else{
                    fw.write("\tBase:\n");
                    fw.write("\t\tType: pure");
                }

            }
            fw.close();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //  Todo: fájlba kiírni a kezdeti állapotot a 8-as doksiban leírt formátumban
    private static void logStartState() {
        try{
            File file = new File(System.getProperty("user.dir")+"/results/result.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Start:\n");
            for(int i= 0; i<bases.size(); i++){
                if(bases.contains(r1)){
                    bw.write("\tNormalRobot1:\n");
                    bw.write("\t\tposition: " + r1.getPosition() + "\n");
                    bw.write("\t\tdisplacement: "+r1.getDisplacement()+"\n");
                    bw.write("\t\tlastPostion: "+r1.getLastPosition()+"\n");
                    bw.write("\t\tstate: " + r1.getState() +"\n");
                    bw.write("\t\tveloMod: "+ r1.getVelocityMod()+"\n");
                    bw.write("\t\tdirectionMod: "+ r1.getDirectionMod()+"\n");
                    bw.write("\t\toilRepository: "+ r1.getOilRepository()+"\n");
                    bw.write("\t\tputtyRepository: "+ r1.getPuttyRepository()+"\n");
                }
                else if (bases.contains(r2)){
                    bw.write("\tNormalRobot2:\n");
                    bw.write("\t\tposition: " + r2.getPosition() + "\n");
                    bw.write("\t\tdisplacement: "+r2.getDisplacement()+"\n");
                    bw.write("\t\tlastPostion: "+r2.getLastPosition()+"\n");
                    bw.write("\t\tstate: " + r2.getState() +"\n");
                    bw.write("\t\tveloMod: "+ r2.getVelocityMod()+"\n");
                    bw.write("\t\tdirectionMod: "+ r2.getDirectionMod()+"\n");
                    bw.write("\t\toilRepository: "+ r2.getOilRepository()+"\n");
                    bw.write("\t\tputtyRepository: "+ r2.getPuttyRepository()+"\n");
                }
                else if(bases.contains(cr1)){
                    bw.write("\tCleanerRobot1:\n");
                    bw.write("\t\tposition: " + cr1.getPosition() + "\n");
                    bw.write("\t\tdisplacement: "+cr1.getDisplacement()+"\n");
                    bw.write("\t\tlastPostion: "+cr1.getLastPosition()+"\n");
                    bw.write("\t\tstate: " + cr1.getState() +"\n");
                }
                else if(bases.contains(cr2)){
                    bw.write("\tCleanerRobot2:\n");
                    bw.write("\t\tposition: " + cr2.getPosition() + "\n");
                    bw.write("\t\tdisplacement: "+cr2.getDisplacement()+"\n");
                    bw.write("\t\tlastPostion: "+cr2.getLastPosition()+"\n");
                    bw.write("\t\tstate: " + cr2.getState() +"\n");
                }
                else if(bases.contains(barrier)){
                    bw.write("\tBarrier:\n");
                    bw.write("\t\tType:" + barrier.getType());
                    bw.write("\t\tPosition:" + barrier.getPosition());
                }
            }
            bw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void setToDefault() {
        r1=null;
        r2=null;
        barrier=null;
        cr1=null;
        cr2=null;
        bases=null;
    }

    //  Megfelelo Barrier letrehozasa, a felhasznalói adatok alapjan
    private static void createBarrier(String t, String pos) {
        Type type = null;
        try {
            type = Type.valueOf(t);
        } catch (Exception e) {
            System.out.println("Incorrect Command");
        }
        switch (type) {
            case putty:
                barrier = new Putty();
                break;
            case oil:
                barrier = new Oil();
                break;
            case pure:
                barrier = new Pure();
                break;
            case edge:
                barrier = new Edge();
                break;
        }
        String[] position = pos.split(";");
        Coordinate coordinate = new Coordinate(Integer.valueOf(position[0]), Integer.valueOf(position[1]));

        TrackPart trackPart = track.findAPart(coordinate);

        barrier.setPosition(coordinate);
        barrier.setTrackPart(trackPart);

        track.findAPart(coordinate).addBase(barrier,coordinate);
        bases.add(barrier);

    }

    //  Megfelelo Cleaner letrehozasa, a felhasznalói adatok alapjan
    private static void createCleaner(String actual_pos,String disp,String last_pos) {
        String[] pos_xy = actual_pos.split(";");
        Coordinate actual_coord = new Coordinate(Integer.valueOf(pos_xy[0]), Integer.valueOf(pos_xy[1]));

        String[] disp_xy = disp.split(";");
        Displacement displacement = new Displacement(Integer.valueOf(disp_xy[0]), Integer.valueOf(disp_xy[1]));

        String[] last_pos_xy = last_pos.split(";");
        Coordinate last_coord = new Coordinate(Integer.valueOf(last_pos_xy[0]), Integer.valueOf(last_pos_xy[1]));

        if(cr1==null){
            cr1 = new CleanerRobot(actual_coord, displacement, last_coord);
            bases.add(cr1);
            g.setCleanersList(cr1);
        }
        else {
            cr2 = new CleanerRobot(actual_coord, displacement, last_coord);
            bases.add(cr2);
            g.setCleanersList(cr2);
        }

    }

    //  Megfelelo Robot letrehozasa, a felhasznalói adatok alapjan
    private static void createRobot(String actual_pos,String disp,String last_pos) {
        String[] pos_xy = actual_pos.split(";");
        Coordinate actual_coord = new Coordinate(Integer.valueOf(pos_xy[0]), Integer.valueOf(pos_xy[1]));

        String[] disp_xy = disp.split(";");
        Displacement displacement = new Displacement(Integer.valueOf(disp_xy[0]), Integer.valueOf(disp_xy[1]));

        String[] last_pos_xy = last_pos.split(";");
        Coordinate last_coord = new Coordinate(Integer.valueOf(last_pos_xy[0]), Integer.valueOf(last_pos_xy[1]));
        if(r1==null){
            r1 = new Robot(actual_coord, displacement, last_coord);
            bases.add(r1);
            g.setRobotList(r1);
        }
        else{
            r2 = new Robot(actual_coord, displacement, last_coord);
            bases.add(r2);
            g.setRobotList(r2);
        }

       // System.out.println(g.getRobotList());
    }

    public static void main(String[] args) {

        String parancs;
        initialize();


//      Eldontes hogy fajlbol vagy consolerol
        System.out.print("From where do you want to run the test:\nconsole/file\n");
        parancs = scanInTest.nextLine();
        if (parancs.equals("console")) {
            fajlbol = false;


//            Ha fajlbol parancsok beolvasasa
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

//          Ha fajlbol, fajl sorainak Commandá alakitasa
            try {
                File f = new File(parancs);
                //ha tenyleg elerheto a fajl akkor itt beolvasni
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = br.readLine();
                while (line != null) {
                    Commands.add(line);
                    line = br.readLine();
                }

            } catch (Exception e) {
                System.out.println("Cannot access the file.\n ");
            }
            //utana sorban kiertekeles Todo: uj szintaxist belevenni ide is
            for (String c : Commands) {
                kiertekel(c);
            }
        } else {
            System.out.print("Incorrect command");
        }

        System.exit(0);
    }

}
