import java.util.ArrayList;
import java.util.Iterator;

public class CompositeHeadache extends HeadacheComponent{

	String name;
	private ArrayList<HeadacheComponent> allTypes;
	
	public CompositeHeadache(String name){
		this.name = name;
		allTypes = new ArrayList<HeadacheComponent>();
	}
	
		
	
	@Override
	public void addType(HeadacheComponent h) {
		allTypes.add(h);
	}

	@Override
	public void removeType(HeadacheComponent h) {
		allTypes.remove(h);
		
	}
	
	@Override
	public String getType(){
		
		String types = "";
		for(HeadacheComponent h:allTypes){
			types = types + " " + h.getType();
		}
		return name + " -->" + types;
	}
}

	
	
