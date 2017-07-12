import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelfHelpReport implements ReportGenerator{

	private List<Headache> headaches;
	

	// This list contains both predefined values (from SelfHelpType), and user defined values
	private HashMap<SelfHelp, Integer> masterList = new HashMap<SelfHelp, Integer>();
	
	public SelfHelpReport(List<Headache> headaches) {
		this.headaches = headaches;
		addPredefinedTypes();
	}


	@Override
	public String generateReport() {
		for (Headache headache : headaches){
			// This type has already been predefined or added by the user
			List<SelfHelp> selfHelps = headache.getSelfHelp();
			
			//TODO this complexity is bad, and will need to be fixed. but it works for now
			for (SelfHelp selfHelp : selfHelps) {
				// Check to see if this is already in the master list
				if (masterList.containsKey(selfHelp)) {
					// Add 1 to the number of times it's been used
					masterList.put(selfHelp, masterList.get(selfHelp) + 1);
				}
				else {
					// This type hasn't been used yet so set the initial value to 1
					masterList.put(selfHelp, 1);
				}
			}
		}
		StringBuilder builder = new StringBuilder();


		for (Map.Entry<SelfHelp, Integer> entry : masterList.entrySet()){			
			// Checks every value in the master list, but only outputs ones that were used
			if (entry.getValue() > 0){

				builder.append("Self Help Name : ");
				builder.append(entry.getKey().getName() + "\n");
				builder.append("Number of Times Used : ");
				builder.append(entry.getValue().toString() + "\n");
				builder.append("Effectivity : ");
				builder.append(entry.getKey().getAvgEffectivity() + "\n\n");
			}
		}
		return builder.toString();
	}
	public List<Headache> getHeadaches() {
		return headaches;
	}

	public void setHeadaches(List<Headache> headaches) {
		this.headaches = headaches;
	}

	/**
	 * Adds the predefined types from the enum to the master list
	 */
	private void addPredefinedTypes() {
		for (SelfHelpType selfHelpType : SelfHelpType.values()){
			// set the name to the value from the enum, and set the effectivity to an empty string for now
			SelfHelp selfHelp = new SelfHelp(selfHelpType.toString(), "");
			// Add each of the values from the enum 
			masterList.put(selfHelp, 0);
		}
	}

}
