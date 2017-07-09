import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class HeadacheTrackerDriver {

	public static void main(String[] args) throws ParseException {
		
		// Create a Patient from the driver class
		Patient patient1 = new Patient();
		// Create the Headaches
		// I didn't create a createHeadache() method in the Patient class since I wasn't sure what it 
		// would do besides say "new Headache()". So I just created all the headaches here
		List<Headache> patient1Headaches = new ArrayList<Headache>();
		
		//storing symptoms into hashset
				HashSet<Symptom> symptoms = new HashSet<Symptom>();
				
				symptoms.add(new Symptom(SymptomType.PRODROME,new String[]{"Nausea"}));
				symptoms.add(new Symptom(SymptomType.CONCURRENT,new String[]{"Light sensitivity"}));
				symptoms.add(new Symptom(SymptomType.POSTDROME,new String[]{"Fatigue"}));
				
				
		//Headache headache1 = new Headache(); //Changing the constructor
		Headache headache1 = new Headache(HeadacheType.MIGRAINE, getDateFormat("05/01/2017"),
				getTimeFormat("7:30 AM"), getTimeFormat("11:00 AM"), 
				SeverityLevelType.SEVEN,
				new PainLocation(PainLocation.Side.LEFTSIDE,PainLocation.Loc.OCULAR),
				symptoms,//this is the hashset
				//add medication here & remove null",
				null,
				getTimeFormat("9:00 AM"), getTimeFormat("11:00 AM"),
				new String[]{"scent-fumes from construction", "lighting-sun glare"}, new String[]{"none"});
		
		
		Headache headache2 = new Headache();
		Headache headache3 = new Headache();
		Headache headache4 = new Headache();
		
		patient1Headaches.add(headache1);
		patient1Headaches.add(headache2);
		patient1Headaches.add(headache3);
		patient1Headaches.add(headache4);
		patient1.setHeadaches(patient1Headaches);
		
		// Create the reports
		// Programmed to an interface so we can later use polymorphism while printing out the reports.
		List<ReportGenerator> patient1Reports = new ArrayList<ReportGenerator>();
		ReportGenerator detailedReport = new DetailedReport();
		ReportGenerator summaryReport = new SummaryReport();
		ReportGenerator selfHelpReport = new SelfHelpReport();
		
		patient1Reports.add(detailedReport);
		patient1Reports.add(summaryReport);
		patient1Reports.add(selfHelpReport);

		patient1.setReports(patient1Reports);
		
		// This will print out all of the reports to the screen
		patient1.printAllReports();
				
	}
	
public static Date getDateFormat(String date) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH); 
		return  df.parse(date);
	    
		
}

public static Date getTimeFormat(String date) throws ParseException{
	
	DateFormat tf = new SimpleDateFormat("h:mm a", Locale.ENGLISH); 
	
    return  tf.parse(date);
    
	
}




}
