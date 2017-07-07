public class PainLocation {
	
	
public enum Loc {	frontal, temporal, occipital, suboccipital, ocular}

public enum Side { rightside, leftside, bilateral }


private Loc location;
private Side side;


public PainLocation ( Loc location, Side side){
	
	this.location = location;
	this.side = side;
	
}

public String toString(){
	
	return location + "/" + side;
}




}
