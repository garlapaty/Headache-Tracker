
public class SingleHeadache extends HeadacheComponent{
	
	
	private String typeName;
		
	public SingleHeadache(String typeName){
		this.typeName = typeName;
			}
	
	@Override
	public void addType(HeadacheComponent h) {
				
	}

	@Override
	public void removeType(HeadacheComponent h) {
	
	}

	@Override
	public String getType() {
	   return typeName;
		
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	

}
