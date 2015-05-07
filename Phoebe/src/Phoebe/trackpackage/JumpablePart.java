package Phoebe.trackpackage;
import Phoebe.basepackage.Base;
import Phoebe.painter.TrackPartPainter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JumpablePart extends TrackPart {

	private List<Base> bases;

	public List<Base> getBases() {
		return bases;
	}

	public void setBases(List<Base> bases) {
		this.bases = bases;
	}

	public JumpablePart() {
		position = new Coordinate();
		width = 0;
		height = 0;
		this.bases = new ArrayList<Base>();
		//Painter hozzaadasa
		TrackPartPainter trackPartPainter = new TrackPartPainter(System.getProperty("user.dir") + "\\resources\\track_v2.png");
		attachObserver(trackPartPainter);
	}

	public JumpablePart(Coordinate position, double width, double height){
		this.position = position;
		this.width = width;
		this.height = height;
		this.bases = new ArrayList<Base>();
		//Painter hozzaadasa
		TrackPartPainter trackPartPainter = new TrackPartPainter(System.getProperty("user.dir") + "\\resources\\track_v2.png");
		attachObserver(trackPartPainter);
	}

	public Base getBase(Coordinate coord) {

		//kereses az elemek kozott
		Timestamp timestamp = new Timestamp(0);
		Base base = new Pure();
		for(Base b : bases){
			if(b.isCoordNear(coord) && b.getTimeStamp().compareTo(timestamp)>0)  //ha valamelyik hatokorben van, akkor azt visszaadja
			 base =  b;
		}
		return base;            //ha nem esik semmilyen elem hatosugaraba, akkor tiszta elemet ad vissza
	}

	public void addBase(Base base, Coordinate coord) {
		base.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		bases.add(base);
	}

	public void removeFromTrackPart(Base base) {
		//remove true-val ter vissza, ha sikeresen toroltt a listabol, false-al, ha nem. ha sikertelen a torles, hiba van
		if (!(bases.remove(base))) {
			//itt az elem nem volt a listaban, hibakezeles kell
		}
	}
}