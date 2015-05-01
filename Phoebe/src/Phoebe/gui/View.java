package Phoebe.gui;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Kövesdi on 2015.05.01..
 */
public class View {

    protected static ArrayList<Painter> painters;

    public View() {
        painters = new ArrayList<Painter>();
    }

    protected static void addToList(Painter painter) {
        painters.add(painter);
    }

    protected void drawImage() {
        for (Iterator<Painter> iterator = painters.iterator(); iterator.hasNext();) {
            Painter painter = iterator.next();
            if (!painter.hasObservable()) {
                iterator.remove();
            }
            else {
                painter.onPaint();
            }
        }
    }

}
