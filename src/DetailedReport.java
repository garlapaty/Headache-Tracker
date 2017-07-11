import java.util.Date;
import java.util.*;

public class DetailedReport implements ReportGenerator{
	
    private String medicationName	;
	private String medicationClass	;
	private String dose;	
	private Date averageTimeToEffectivity ;
	private int totalDosesTaken;
	private List<Headache> headaches;

	
	public DetailedReport(List<Headache> headaches){
		this.headaches=headaches;
		
	}
	
	public DetailedReport(String medicationName	,String medicationClass,
	String dose, Date averageTimeToEffectivity, int totalDosesTaken){
		this.medicationName = medicationName;
		this.medicationClass=medicationClass;
		this.dose = dose;
		this.averageTimeToEffectivity = averageTimeToEffectivity;
		this.totalDosesTaken = totalDosesTaken;
}
	
	//@Override
	/*public String generateReport() {
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
	}*/
	public String generateReport(){
		List<Medication> medications = new ArrayList<Medication>();
		List<Medication> uniqueMedications = new ArrayList<Medication>();
 		for (Headache headache : headaches)
		{
			 medications.add(headache.getMedication());				 
		}
 		for (int i=0;i<medications.size();i++)
 		{
 			if(medications.get(i).getName()!=medications.get(++i).getName())
 			uniqueMedications.add(medications.get(i));	
 			
 		}
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<uniqueMedications.size();i++)
		{
			builder.append("Medication Name : ");
			builder.append(uniqueMedications.get(i).getName() + "\n");
			builder.append("Medication Class: ");
			builder.append(uniqueMedications.get(i).getMedClass() +"\n");
			builder.append("Dose:");
			builder.append(uniqueMedications.get(i).getDose() + "\n");
			
		}
		
		
		
		 	
		return builder.toString();
	}
}
