import java.text.ParseException;
import java.util.Date;

public class DetailedReport implements ReportGenerator{
    private static String medicationName;
	private static String medicationClass;
	private static String dose;	
	private static Date averageTimeToEffectivity ;
	private static int totalDosesTaken;

	
	public DetailedReport(){
		
	}
	
	public DetailedReport(String medicationName	,String medicationClass,
	String dose, Date averageTimeToEffectivity, int totalDosesTaken){
		DetailedReport.medicationName = medicationName;
		DetailedReport.medicationClass=medicationClass;
		DetailedReport.dose = dose;
		DetailedReport.averageTimeToEffectivity = averageTimeToEffectivity;
		DetailedReport.totalDosesTaken = totalDosesTaken;
}
	/*public int returnDosesTaken() throws ParseException
	{
		Medication m=new Medication("maxalt \t","triptan class \t","5 mg",2,"01/01/2017");	
	if(m.getName()=="maxAlt")	
	{
		int count=0;
		for(count=0;count<4;count++)
		{
			count++;
		}
		return count;
	}
	else
	{
		return 0;
	}
	}
	*/
	
	public String generateReport() {
		//Medication med = new Medication();
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
