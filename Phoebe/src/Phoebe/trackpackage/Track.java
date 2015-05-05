package Phoebe.trackpackage;

import Phoebe.helperpackage.JSONHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Track {

    private EdgeofTheTrack edge;
    private List<JumpablePart> trackParts;

    public List<JumpablePart> getTrackParts() {

        return trackParts;
    }

    public void setTrackParts(List<JumpablePart> trackParts) {

        this.trackParts = trackParts;
    }

    public Track() {

//		System.out.println("\t"+getClass().getName()+":Track");
        edge = new EdgeofTheTrack();
        trackParts = new ArrayList<JumpablePart>();
    }

    public void create() {

        //Csinaltam egy alap palyat. negyzet alaku. csak hogy ha akar valaki akkor lehessen tesztet kitalalni
//		System.out.println("\t"+getClass().getName()+":create");
//		fromJson();
        fromRawData();
    }

    private void fromRawData() {
        String baseURL = System.getProperty("user.dir") + "/data/raw/";
        
        JumpablePart jumpablePart1 = (JumpablePart) readFromFile(baseURL + "jumpablePart1.dat", new JumpablePart());
        JumpablePart jumpablePart2 = (JumpablePart) readFromFile(baseURL + "jumpablePart2.dat", new JumpablePart());
        JumpablePart jumpablePart3 = (JumpablePart) readFromFile(baseURL + "jumpablePart3.dat", new JumpablePart());
        JumpablePart jumpablePart4 = (JumpablePart) readFromFile(baseURL + "jumpablePart4.dat", new JumpablePart());

        trackParts.add(jumpablePart1);
        trackParts.add(jumpablePart2);
        trackParts.add(jumpablePart3);
        trackParts.add(jumpablePart4);

        edge = new EdgeofTheTrack();
    }

    private Object readFromFile(String s, Object type) {
        Coordinate coord = new Coordinate();
        double width=0;
        double height=0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            String line = br.readLine();
            int line_num=0;
            while (line != null) {
//              Set position
                if(line_num==0){
                    String[] coordinates = line.split(",");
                    coord.setX(Double.parseDouble(coordinates[0]));
                    coord.setY(Double.parseDouble(coordinates[1]));
                }
//              Set width
                if(line_num==1){
                    width=Double.parseDouble(line);
                }
//              Set height
                if(line_num==2){
                    height=Double.parseDouble(line);
                }
                line_num++;
                line=br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (type.getClass()==JumpablePart.class){
            ((JumpablePart)type).setPosition(coord);
            ((JumpablePart)type).setHeight(height);
            ((JumpablePart)type).setWidth(width);
            return type;
        }
        else return null;
    }

    private void fromJson() {
        String baseURL = System.getProperty("user.dir") + "/data/JSONs/";
//		System.out.println(baseURL);
        try {
            JumpablePart jumpablePart1 = (JumpablePart) JSONHandler.readStream(baseURL + "jumpablePart1.dat", JumpablePart.class);
            JumpablePart jumpablePart2 = (JumpablePart) JSONHandler.readStream(baseURL + "jumpablePart2.dat", JumpablePart.class);
            JumpablePart jumpablePart3 = (JumpablePart) JSONHandler.readStream(baseURL + "jumpablePart3.dat", JumpablePart.class);
            JumpablePart jumpablePart4 = (JumpablePart) JSONHandler.readStream(baseURL + "jumpablePart4.dat", JumpablePart.class);

            trackParts.add(jumpablePart1);
            trackParts.add(jumpablePart2);
            trackParts.add(jumpablePart3);
            trackParts.add(jumpablePart4);

        } catch (Exception e) {
            e.printStackTrace();
        }


        edge = new EdgeofTheTrack();
    }

    public TrackPart findAPart(Coordinate coord) {

		System.out.println("\t\t"+getClass().getName()+":findAPart");

        //keres�s az elemek k�z�tt
        for (JumpablePart p : trackParts) {

            //ha valamelyiken rajta van, akkor azt visszaadja
            if (p.containCoord(coord)){
            	System.out.println("Talalt");
                return p;
            }
        }

        //ha egyiken sem volt rajta, akkor let�rt a p�ly�r�l
    	System.out.println("Szakadek");

        return edge;

        //return  trackParts.get(0);
    }

}