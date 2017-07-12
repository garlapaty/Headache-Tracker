import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class DetailedReport implements ReportGenerator{

	//HashMap<String, String> report = new HashMap<String,String>();
	DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
	int doseCount = 0;
	double timeEff = 0;
	String strName;
	String strClass;
	String report;
	String reportData = "";
	String strDose;
    private static String medicationName	;
	private static String medicationClass	;
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
		ArrayList<String> name = Medication.medicineName;
		ArrayList<String> details = Headache.medicalDetails;
		StringBuilder builder = new StringBuilder();
	/*	builder.append("Medication Name : ");
		builder.append(medicationName + "\n");
		builder.append("Medication Class : ");
		builder.append(medicationClass + "\n");
		builder.append("Dose : ");
		builder.append(dose + "\n");
		builder.append("Average time to effectivity : ");
		builder.append(averageTimeToEffectivity + "\n");
		builder.append("Total doses taken : ");
		builder.append(totalDosesTaken + "\n");*/
	    Collections.sort(details);
	    report = "************************************************\n";
    	report = report + "|*********** Detailed Report for Patient1*******|\n";
    	report = report + "|***********************************************|\n";
    	report = report + "| Name	| Class		| Dose	|Avg Time |DCount|\n";
    	report = report + "|************************************************|\n";
	    for(int i=0; i< name.size();i++){
	    	for(int j =0; j< details.size();j++){
			String str[] = details.get(j).split(",");
			if(str[0].equalsIgnoreCase(name.get(i))){
			strName = str[0];
			strClass = str[1];
			strDose = str[2];
			doseCount++;
			timeEff = timeEff +	LocalTime.parse(str[3],format).until(LocalTime.parse(str[4],format), MINUTES);//
			}
			}
	    	reportData = reportData+"| "+strName.trim() +" | "+ strClass.trim() +" | "+ strDose +" | "+timeEff/60+" hr"+"   | "+doseCount+"	 |\n";
	    	doseCount=0;
	    	timeEff = 0;
	    }
	    report =  report + reportData+"**************************************************";
		return report;
	}

}
