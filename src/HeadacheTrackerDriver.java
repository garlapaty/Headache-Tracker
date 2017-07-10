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
		
		
		
		//Testing with medications
		Medication m1 = new Medication("MaxAlt","triptan class","5mg");
		Medication m2 = new Medication("Anaprox","NSAID class","550mg");
		
		
		
		// Create a Patient from the driver class
		Patient patient1 = new Patient();
		
		
		
		
		// Create the Headaches
		
		
		List<Headache> patient1Headaches = new ArrayList<Headache>();
		
		//storing symptoms into hashset
		//Headache1
		HashSet<Symptom> symptoms1 = new HashSet<Symptom>();
		
		symptoms1.add(new Symptom(SymptomType.PRODROME,new String[]{"Nausea"}));
		symptoms1.add(new Symptom(SymptomType.CONCURRENT,new String[]{"Light sensitivity"}));
		symptoms1.add(new Symptom(SymptomType.POSTDROME,new String[]{"Fatigue"}));
						
		Headache headache1 = new Headache(HeadacheType.MIGRAINE, getDateFormat("05/01/2017"),
				getTimeFormat("7:30 AM"), getTimeFormat("11:00 AM"), 
				SeverityLevelType.SEVEN,
				new PainLocation(PainLocation.Side.LEFTSIDE,PainLocation.Loc.OCULAR),
				symptoms1,//this is the hashset
				//temporary medication",
				m1,
				getTimeFormat("9:00 AM"), getTimeFormat("11:00 AM"),
				new String[]{"scent-fumes from construction", "lighting-sun glare"}, 
				new String[]{"none"});
		//System.out.println(headache1.getHeadache()); //testing purpose only
        //End of headache 1
		
		//Headache headache2 = new Headache();
		//Headache headache3 = new Headache();
		//Headache headache4 = new Headache();

		//HEAdache 2	
		HashSet<Symptom> symptoms2 = new HashSet<Symptom>();
		symptoms2.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain"}));

		
		Headache headache2 = new Headache(HeadacheType.TENSION, getDateFormat("05/06/2017"),
				getTimeFormat("6:00 PM"), getTimeFormat("9:15 PM"),
				SeverityLevelType.FIVE,
				new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.SUBOCCIPITAL),
				symptoms2,
				//temporary medication",
				m2,
				getTimeFormat("7:00 PM"), getTimeFormat("9:15 PM"),
				new String[]{"missed meal"}, 
				new String[]{"physical therapy -> helped a lot"});
		//System.out.println(headache2.getHeadache()); //testing purpose only
		//End of headache2
		//Headache 3
		HashSet<Symptom> symptoms3 = new HashSet<Symptom>();
		symptoms3.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain", "sinus congestion"}));
		
		Headache headache3 = new Headache(HeadacheType.TENSION, getDateFormat("05/10/2017"),
				getTimeFormat("4:00 PM"), getTimeFormat("9:00 PM"),
				SeverityLevelType.SIX,
				//TODO WE NEED TO BE ABLE TO ADD ANOTHER PAINLOCATION HERE
				new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.FRONTAL),
				symptoms3,
				//temporary medication,
				m2,
				getTimeFormat("5:00 PM"), getTimeFormat("7:00 PM"),
				new String[]{"stress"}, 
				new String[]{"biofeedback -> didn't help", "physical therapy -> helped a lot"});
		//System.out.println(headache3.getHeadache()); //testing purpose only
		//end of headache3
		
		//Headache4
		HashSet<Symptom> symptoms4 = new HashSet<Symptom>();
		symptoms4.add(new Symptom(SymptomType.POSTDROME, new String[]{"nausea","tearing"}));
		symptoms4.add(new Symptom(SymptomType.CONCURRENT, new String[]{"vision disturbance"}));
		Headache headache4 = new Headache(HeadacheType.MIGRAINE, getDateFormat("05/17/2017"),
				getTimeFormat("6:00 AM"), getTimeFormat("9:00 AM"),
				SeverityLevelType.SEVEN,
				new PainLocation(PainLocation.Side.LEFTSIDE, PainLocation.Loc.OCULAR),
				symptoms4,
				//temporary medication,
				m1,
				getTimeFormat("6:15 AM"), getTimeFormat("7:30 AM"),
				new String[]{"sleep change - lack of sleep"}, 
				new String[]{"rest/sleep -> helped a little"});
		//System.out.println(headache4.getHeadache()); ////testing purpose only
		
		//End of headache4
		
		patient1Headaches.add(headache1);
		patient1Headaches.add(headache2);
		patient1Headaches.add(headache3);
		patient1Headaches.add(headache4);
		patient1.setHeadaches(patient1Headaches);
		
		// Create the reports
		// Programmed to an interface so we can later use polymorphism while printing out the reports.
		List<ReportGenerator> patient1Reports = new ArrayList<ReportGenerator>();
		ReportGenerator detailedReport = new DetailedReport();
		//counters for summaryreport
	    //int totalHeadacheCountforPatient1 = headache1.getHeadacheCounter()+headache2.getHeadacheCounter()+headache3.getHeadacheCounter()+headache4.getHeadacheCounter();
		//float averageSeverityforPatient1 = headache1.getSeverity()+headache2.getSeverity()+headache3.getSeverity()+headache4.getSeverity();
	    ReportGenerator summaryReport = new SummaryReport();
		ReportGenerator selfHelpReport = new SelfHelpReport();
		
		System.out.println(summaryReport.generateReport());
		
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
