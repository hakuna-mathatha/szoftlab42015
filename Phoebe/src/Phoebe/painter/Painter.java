package Phoebe.painter;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Created by K�vesdi on 2015.05.01..
 */
public abstract class Painter extends Observer {

    protected BufferedImage image;  //kirajzolando kep

    public Painter(String imageUrl) {
    	openPicture(imageUrl); 
    }

    protected void openPicture(String imageUrl) {
        try {
            image = ImageIO.read(new File(imageUrl));
        }
        catch (IOException e) {
            System.out.println("Error at opening picture");
        }
    }

    public abstract void onPaint(Graphics g);  //kirajzolasert felelos metodus, leszarmazottban valositjuk meg
}
