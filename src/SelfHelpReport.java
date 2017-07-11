import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelfHelpReport implements ReportGenerator{

	private int noOfTimesUsed;
	private List<Headache> headaches;
	private HashMap<String, Integer> masterList = new HashMap<String, Integer>();
	
	public SelfHelpReport(List<Headache> headaches) {
		// TODO Auto-generated constructor stub
		this.headaches = headaches;
		addPredefinedTypes();
	}

	@Override
	public String generateReport() {
		for (Headache headache : headaches){
			// This type has already been predefined or added by the user
			String key = headache.getSelfHelp().getName();
			if (masterList.containsKey(key)) {
				masterList.put(key, masterList.get(key) + 1);
			}
			else {
				// This type hasn't been used yet so set the initial value to 1
				masterList.put(key, 1);
			}
		}
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : masterList.entrySet()){
			if (entry.getValue() > 0){

				builder.append("Self Help Name : ");
				builder.append(entry.getKey() + "\n");
				builder.append("Number of Times Used : ");
				builder.append(entry.getValue().toString() + "\n");
//				builder.append("Effectivity : ");
//				builder.append(effectivity + "\n");
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
			masterList.put(selfHelpType.toString(), 0);
		}
	}
}
