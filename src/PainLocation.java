public class PainLocation {

	
public enum Loc {	FRONTAL	, TEMPORAL, OCCIPITAL, SUBOCCIPITAL, OCULAR}

public enum Side { RIGHTSIDE, LEFTSIDE, BILATERAL }


private Loc location;
private Side side;


public PainLocation ( Side side,Loc location){
	
	this.location = location;
	this.side = side;
	
}

public String toString(){
	
	return side + "/" + location;
}




}
