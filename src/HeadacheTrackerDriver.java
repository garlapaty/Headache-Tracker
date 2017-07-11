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
		Medication m=new Medication("maxalt \t","triptan class \t","5 mg",2,"11:00 AM");
		symptoms1.add(new Symptom(SymptomType.PRODROME,new String[]{"Nausea"}));
		symptoms1.add(new Symptom(SymptomType.CONCURRENT,new String[]{"Light sensitivity"}));
		symptoms1.add(new Symptom(SymptomType.POSTDROME,new String[]{"Fatigue"}));
		String[] reasons ={"scent-fumes from construction", "lighting-sun glare"};
		String[] slhp={"none"};
		Headache headache1 = new Headache(HeadacheType.MIGRAINE, getDateFormat("05/01/2017"),
				getTimeFormat("7:30 AM"), getTimeFormat("11:00 AM"), 
				SeverityLevelType.SEVEN,
				new PainLocation(PainLocation.Side.LEFTSIDE,PainLocation.Loc.OCULAR),
				symptoms1,//this is the hashset

				//add medication here & remove null",
				m.returnPatientData(),
				getTimeFormat("9:00 AM"), getTimeFormat("11:00 AM"),reasons,
				slhp);
		System.out.println(headache1.getHeadache()); //testing purpose only

				//temporary medication",
				
		//End of headache 1

		//HEAdache 2	
		HashSet<Symptom> symptoms2 = new HashSet<Symptom>();
		symptoms2.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain"}));
		String[] slhp1={"physical therapy -> helped a lot"};
		Medication m11=new Medication("Anaprox \t","NSAID class \t","550mg \t",2,"9:15 PM");
		Headache headache2 = new Headache(HeadacheType.TENSION, getDateFormat("05/06/2017"),
				getTimeFormat("6:00 PM"), getTimeFormat("9:15 PM"),
				SeverityLevelType.FIVE,
				new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.SUBOCCIPITAL),

				symptoms2,//add medication here & remove null",
				m11.returnPatientData(),

				getTimeFormat("7:00 PM"), getTimeFormat("9:15 PM"),
				new String[]{"missed meal"}, 
				slhp1);
		System.out.println(headache2.getHeadache()); //testing purpose only
		//End of headache2
		//Headache 3
		HashSet<Symptom> symptoms3 = new HashSet<Symptom>();
		symptoms3.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain", "sinus congestion"}));
		String[] reasons2 ={"stress"};
		String[] slhp2={"biofeedback -> didn't help", "physical therapy -> helped a lot"};
		Medication m21=new Medication("Anaprox \t","NSAID class \t","550mg",2,"7:00 PM");
		Headache headache3 = new Headache(HeadacheType.TENSION, getDateFormat("05/10/2017"),
				getTimeFormat("4:00 PM"), getTimeFormat("9:00 PM"),
				SeverityLevelType.SIX,
				//TODO WE NEED TO BE ABLE TO ADD ANOTHER PAINLOCATION HERE
				new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.FRONTAL),
				symptoms3,

				//add medication here & remove null,
				m21.returnPatientData(),
				getTimeFormat("5:00 PM"), getTimeFormat("7:00 PM"),reasons2,
				 
				slhp2);
		System.out.println(headache3.getHeadache()); //testing purpose only

		//end of headache3
		String[] reasons3 ={"sleep change - lack of sleep"};
		String[] slhp3={"biofeedback -> didn't help", "physical therapy -> helped a lot"};
		//Headache4
		HashSet<Symptom> symptoms4 = new HashSet<Symptom>();
		Medication m3=new  Medication("maxalt \t","triptan class \t","5 mg",2,"7:30 AM");
		symptoms4.add(new Symptom(SymptomType.POSTDROME, new String[]{"nausea","tearing"}));
		symptoms4.add(new Symptom(SymptomType.CONCURRENT, new String[]{"vision disturbance"}));
		Headache headache4 = new Headache(HeadacheType.MIGRAINE, getDateFormat("05/17/2017"),
				getTimeFormat("6:00 AM"), getTimeFormat("9:00 AM"),
				SeverityLevelType.SEVEN,
				new PainLocation(PainLocation.Side.LEFTSIDE, PainLocation.Loc.OCULAR),
				symptoms4,
				//add medication here & remove null,
				m3.returnPatientData(),

				getTimeFormat("6:15 AM"), getTimeFormat("7:30 AM"),
			reasons3, 
				slhp3);
		System.out.println(headache4.getHeadache()); ////testing purpose only
		
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

		ReportGenerator summaryReport = new SummaryReport(getDateFormat("05/01/2017"),getDateFormat("05/10/2017"));

		ReportGenerator selfHelpReport = new SelfHelpReport();
		
		//print Summary report
		System.out.println("Summary Report for patient 1");
		System.out.println("********************************");
		System.out.println(summaryReport.generateReport());
		
	//	System.out.println("Detailed Report for patient 1");
	//	System.out.println("********************************");
	//	System.out.println(detailedReport.generateReport());
		
		patient1Reports.add(detailedReport);
		patient1Reports.add(summaryReport);
		patient1Reports.add(selfHelpReport);

		patient1.setReports(patient1Reports);
		// This will print out all of the reports to the screen
		//patient1.printAllReports();
		DetailedReport dR= new DetailedReport();
		String generatedReport = dR.generateReport();
		System.out.println(generatedReport);
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
