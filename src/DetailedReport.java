import java.util.Date;

public class DetailedReport implements ReportGenerator{
    private String medicationName	;
	private String medicationClass	;
	private String dose;	
	private Date averageTimeToEffectivity ;
	private int totalDosesTaken;

	
	public DetailedReport(){
		
	}
	
	public DetailedReport(String medicationName	,String medicationClass,
	String dose, Date averageTimeToEffectivity, int totalDosesTaken){
		this.medicationName = medicationName;
		this.medicationClass=medicationClass;
		this.dose = dose;
		this.averageTimeToEffectivity = averageTimeToEffectivity;
		this.totalDosesTaken = totalDosesTaken;
}
	
	@Override
	public String generateReport() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medication Name : ");
		builder.append(medicationName + "\n");
		builder.append("Medication Class : ");
		builder.append(medicationClass + "\n");
		builder.append("Dose : ");
		builder.append(dose + "\n");
		builder.append("Average time to effectivity : ");
		builder.append(averageTimeToEffectivity + "\n");
		builder.append("Total doses taken : ");
		builder.append(totalDosesTaken + "\n");
				
		return builder.toString();
	}

}
