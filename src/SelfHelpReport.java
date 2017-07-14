import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelfHelpReport implements ReportGenerator{

	private int noOfTimesUsed;
	private List<Headache> headaches;
	private HashMap<SelfHelp, Integer> masterList = new HashMap<SelfHelp, Integer>();
	
	public SelfHelpReport(List<Headache> headaches) {
		this.headaches = headaches;
		addPredefinedTypes();
	}

	@Override
	public String generateReport() {
		for (Headache headache : headaches){
			// This type has already been predefined or added by the user
			//String key = headache.getSelfHelp().getName();
			SelfHelp selfHelp = headache.getSelfHelp();
			
			if (masterList.containsKey(selfHelp)) {
				masterList.put(selfHelp, masterList.get(selfHelp) + 1);
			}
			else {
				// This type hasn't been used yet so set the initial value to 1
				masterList.put(selfHelp, 1);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<SelfHelp, Integer> entry : masterList.entrySet()){
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

	private void addPredefinedTypes() {
		for (SelfHelpType selfHelpType : SelfHelpType.values()){
			// set the name to the value from the enum, and set the effectivity to an empty string for now
			SelfHelp selfHelp = new SelfHelp(selfHelpType.toString(), "");
			// Add each of the values from the enum 
			masterList.put(selfHelp, 0);
		}
	}
}
