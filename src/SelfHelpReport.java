public class SelfHelpReport implements ReportGenerator{

	private String selfHelpName;
	private int noOfTimesUsed;
	private String effectivity;
	
	@Override
	public String generateReport() {
		StringBuilder builder = new StringBuilder();
		builder.append("Self Help Name : ");
		builder.append(selfHelpName + "\n");
		builder.append("Number of Times Used : ");
		builder.append(noOfTimesUsed + "\n");
		builder.append("Effectivity : ");
		builder.append(effectivity + "\n");

		return builder.toString();
	}
}
