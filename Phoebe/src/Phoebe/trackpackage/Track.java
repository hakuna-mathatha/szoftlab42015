package Phoebe.trackpackage;

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
        edge = new EdgeofTheTrack();
        trackParts = new ArrayList<JumpablePart>();
    }

    public void create(int index) {
        fromRawData(index);
    }

    private void fromRawData(int index) {
        if (index == 0) {
            createMap_1();
        } else {
            createMap_2();
        }
    }

    private void createMap_1() {
        String baseURL = System.getProperty("user.dir") + "/data/raw/map1/";

//      Pályaelemek beolvasása
        JumpablePart jumpablePart1 = (JumpablePart) readFromFile(baseURL + "jumpablePart1.dat", new JumpablePart());
        JumpablePart jumpablePart2 = (JumpablePart) readFromFile(baseURL + "jumpablePart2.dat", new JumpablePart());
        JumpablePart jumpablePart3 = (JumpablePart) readFromFile(baseURL + "jumpablePart3.dat", new JumpablePart());
        JumpablePart jumpablePart4 = (JumpablePart) readFromFile(baseURL + "jumpablePart4.dat", new JumpablePart());

        trackParts.add(jumpablePart1);
        trackParts.add(jumpablePart2);
        trackParts.add(jumpablePart3);
        trackParts.add(jumpablePart4);

//      Olaj és ragacsfoltok beolvasása, pályaelemhez hozzáadása
        Oil oil = (Oil) readFromFile(baseURL + "Oil1.dat", new Oil());
        findAPart(oil.getPosition()).addBase(oil, oil.getPosition());
        Oil oil2 = (Oil) readFromFile(baseURL + "Oil2.dat", new Oil());
        findAPart(oil2.getPosition()).addBase(oil2, oil2.getPosition());
        Putty putty = (Putty) readFromFile(baseURL + "Putty1.dat", new Putty());
        findAPart(putty.getPosition()).addBase(putty,putty.getPosition());
        Putty putty2 = (Putty) readFromFile(baseURL + "Putty2.dat", new Putty());
        findAPart(putty2.getPosition()).addBase(putty2,putty2.getPosition());
        Putty putty3 = (Putty) readFromFile(baseURL + "Putty3.dat", new Putty());
        findAPart(putty3.getPosition()).addBase(putty3,putty3.getPosition());

        edge = new EdgeofTheTrack();
    }

    private void createMap_2() {
        String baseURL = System.getProperty("user.dir") + "/data/raw/map2/";

        JumpablePart jumpablePart1 = (JumpablePart) readFromFile(baseURL + "jumpablePart1.dat", new JumpablePart());
        JumpablePart jumpablePart2 = (JumpablePart) readFromFile(baseURL + "jumpablePart2.dat", new JumpablePart());
        JumpablePart jumpablePart3 = (JumpablePart) readFromFile(baseURL + "jumpablePart3.dat", new JumpablePart());
        JumpablePart jumpablePart4 = (JumpablePart) readFromFile(baseURL + "jumpablePart4.dat", new JumpablePart());
        JumpablePart jumpablePart5 = (JumpablePart) readFromFile(baseURL + "jumpablePart5.dat", new JumpablePart());
        JumpablePart jumpablePart6 = (JumpablePart) readFromFile(baseURL + "jumpablePart6.dat", new JumpablePart());
        JumpablePart jumpablePart7 = (JumpablePart) readFromFile(baseURL + "jumpablePart7.dat", new JumpablePart());

        trackParts.add(jumpablePart1);
        trackParts.add(jumpablePart2);
        trackParts.add(jumpablePart3);
        trackParts.add(jumpablePart4);
        trackParts.add(jumpablePart5);
        trackParts.add(jumpablePart6);
        trackParts.add(jumpablePart7);

        edge = new EdgeofTheTrack();
    }

    private Object readFromFile(String s, Object type) {
        Coordinate coord = new Coordinate();
        double width = 0;
        double height = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(s));
            String line = br.readLine();
            int line_num = 0;
            while (line != null) {
//              Set position
                if (line_num == 0) {
                    String[] coordinates = line.split(",");
                    coord.setX(Double.parseDouble(coordinates[0]));
                    coord.setY(Double.parseDouble(coordinates[1]));
                }
//              Set width
                if (line_num == 1) {
                    width = Double.parseDouble(line);
                }
//              Set height
                if (line_num == 2) {
                    height = Double.parseDouble(line);
                }
                line_num++;
                line = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(type.getClass()==JumpablePart.class){
            ((JumpablePart) type).setPosition(coord);
            ((JumpablePart) type).setHeight(height);
            ((JumpablePart) type).setWidth(width);
        }else if (type.getClass()==Oil.class){
            ((Oil)type).setPosition(coord);
            ((Oil)type).setTrackPart(findAPart(coord));
            
        }else{
            ((Putty)type).setPosition(coord);
            ((Putty)type).setTrackPart(findAPart(coord));
        }
        return type;
    }

    

    public TrackPart findAPart(Coordinate coord) {
        //kereses az elemek kozott
        for (JumpablePart p : trackParts) {
            //ha valamelyiken rajta van, akkor azt visszaadja
            if (p.containCoord(coord)) {
                return p;
            }
        }
        //ha egyiken sem volt rajta, akkor letert a palyarol
        return edge;
    }
}