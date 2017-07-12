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
<<<<<<< HEAD
		
		// Create the self help treatment
		List<SelfHelp> selfHelps1 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp1 = new SelfHelp("none", "");
		selfHelps1.add(selfHelp1);
		
=======
		String[] reasons ={"scent-fumes from construction", "lighting-sun glare"};
		String[] slhp={"none"};
>>>>>>> suppunew
		Headache headache1 = new Headache(HeadacheType.MIGRAINE, getDateFormat("05/01/2017"),
				getTimeFormat("7:30 AM"), getTimeFormat("11:00 AM"), 
				SeverityLevelType.SEVEN, "stabbing",
				new PainLocation(PainLocation.Side.LEFTSIDE,PainLocation.Loc.OCULAR),
				symptoms1,//this is the hashset
<<<<<<< HEAD
				//temporary medication",
				m1,
				getTimeFormat("9:00 AM"), getTimeFormat("11:00 AM"),
				new String[]{"scent-fumes from construction", "lighting-sun glare"}, 
				selfHelps1);
		
=======

				//add medication here & remove null",
				m.returnPatientData(),
				getTimeFormat("9:00 AM"), getTimeFormat("11:00 AM"),reasons,
				slhp);
		System.out.println(headache1.getHeadache()); //testing purpose only

				//temporary medication",
				
>>>>>>> suppunew
		//End of headache 1

		//Headache 2	
		HashSet<Symptom> symptoms2 = new HashSet<Symptom>();
		symptoms2.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain"}));
<<<<<<< HEAD

		// Create the self help treatment
		List<SelfHelp> selfHelps2 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp2 = new SelfHelp(SelfHelpType.PHYSICAL_THERAPY.toString(), "helped a lot");
		selfHelps2.add(selfHelp2);
		
=======
		String[] slhp1={"physical therapy -> helped a lot"};
		Medication m11=new Medication("Anaprox \t","NSAID class \t","550mg \t",2,"9:15 PM");
>>>>>>> suppunew
		Headache headache2 = new Headache(HeadacheType.TENSION, getDateFormat("05/06/2017"),
				getTimeFormat("6:00 PM"), getTimeFormat("9:15 PM"),
				SeverityLevelType.FIVE,"dull",
				new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.SUBOCCIPITAL),
<<<<<<< HEAD
				symptoms2,
				//temporary medication",
				m2,
				getTimeFormat("7:00 PM"), getTimeFormat("9:15 PM"),
				new String[]{"missed meal"}, 
				selfHelps2);

=======

				symptoms2,//add medication here & remove null",
				m11.returnPatientData(),

				getTimeFormat("7:00 PM"), getTimeFormat("9:15 PM"),
				new String[]{"missed meal"}, 
				slhp1);
		System.out.println(headache2.getHeadache()); //testing purpose only
>>>>>>> suppunew
		//End of headache2
		
		// Headache 3
		HashSet<Symptom> symptoms3 = new HashSet<Symptom>();
		symptoms3.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain", "sinus congestion"}));
<<<<<<< HEAD
		
		// Create the self help treatment
		List<SelfHelp> selfHelps3 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp3a = new SelfHelp(SelfHelpType.PHYSICAL_THERAPY.toString(), "helped a lot");
		SelfHelp selfHelp3b = new SelfHelp(SelfHelpType.BIOFEEDBACK.toString(), "didn't help"); 
		selfHelps3.add(selfHelp3a);
		selfHelps3.add(selfHelp3b);
		
=======
		String[] reasons2 ={"stress"};
		String[] slhp2={"biofeedback -> didn't help", "physical therapy -> helped a lot"};
		Medication m21=new Medication("Anaprox \t","NSAID class \t","550mg",2,"7:00 PM");
>>>>>>> suppunew
		Headache headache3 = new Headache(HeadacheType.TENSION, getDateFormat("05/10/2017"),
				getTimeFormat("4:00 PM"), getTimeFormat("9:00 PM"),
				SeverityLevelType.SIX,"dull",
				//TODO WE NEED TO BE ABLE TO ADD ANOTHER PAINLOCATION HERE
				new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.FRONTAL),
				symptoms3,
<<<<<<< HEAD
				//temporary medication,
				m2,
				getTimeFormat("5:00 PM"), getTimeFormat("7:00 PM"),
				new String[]{"stress"},
				selfHelps3);

		// end of headache3
		
=======

				//add medication here & remove null,
				m21.returnPatientData(),
				getTimeFormat("5:00 PM"), getTimeFormat("7:00 PM"),reasons2,
				 
				slhp2);
		System.out.println(headache3.getHeadache()); //testing purpose only

		//end of headache3
		String[] reasons3 ={"sleep change - lack of sleep"};
		String[] slhp3={"biofeedback -> didn't help", "physical therapy -> helped a lot"};
>>>>>>> suppunew
		//Headache4
		HashSet<Symptom> symptoms4 = new HashSet<Symptom>();
		Medication m3=new  Medication("maxalt \t","triptan class \t","5 mg",2,"7:30 AM");
		symptoms4.add(new Symptom(SymptomType.POSTDROME, new String[]{"nausea","tearing"}));
		symptoms4.add(new Symptom(SymptomType.CONCURRENT, new String[]{"vision disturbance"}));
		
		List<SelfHelp> selfHelps4 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp4 = new SelfHelp(SelfHelpType.REST_SLEEP.toString(), "helped a little");
		selfHelps4.add(selfHelp4);
		
		Headache headache4 = new Headache(HeadacheType.MIGRAINE, getDateFormat("05/17/2017"),
				getTimeFormat("6:00 AM"), getTimeFormat("9:00 AM"),
				SeverityLevelType.SEVEN,"pulsating",
				new PainLocation(PainLocation.Side.LEFTSIDE, PainLocation.Loc.OCULAR),
<<<<<<< HEAD
				symptoms4,
				//temporary medication,
				m1,
				getTimeFormat("6:15 AM"), getTimeFormat("7:30 AM"),
				new String[]{"sleep change - lack of sleep"}, 
				selfHelps4);
=======
				symptoms4,
				//add medication here & remove null,
				m3.returnPatientData(),

				getTimeFormat("6:15 AM"), getTimeFormat("7:30 AM"),
			reasons3, 
				slhp3);
		System.out.println(headache4.getHeadache()); ////testing purpose only
>>>>>>> suppunew
		
		//End of headache4
		
		patient1Headaches.add(headache1);
		patient1Headaches.add(headache2);
		patient1Headaches.add(headache3);
		patient1Headaches.add(headache4);
		patient1.setHeadaches(patient1Headaches);
		
		//Print all the headaches for patient 1
		System.out.println("Headaches for patient 1");
		System.out.println("********************************");
		for(Headache headache:patient1Headaches)
		{
			System.out.println(headache.getHeadache());
			System.out.println("-------------------------------");
		}
		
		// Create the reports
		// Programmed to an interface so we can later use polymorphism while printing out the reports.
		List<ReportGenerator> patient1Reports = new ArrayList<ReportGenerator>();
		ReportGenerator detailedReport = new DetailedReport();
<<<<<<< HEAD

	    //removed the conflicting objects creation with empty constructors - priya
		
		ReportGenerator summaryReport = new SummaryReport(getDateFormat("05/01/2017"), getDateFormat("05/20/2017"));
		ReportGenerator selfHelpReport = new SelfHelpReport(patient1.getHeadaches());

=======

		ReportGenerator summaryReport = new SummaryReport(getDateFormat("05/01/2017"),getDateFormat("05/10/2017"));

		ReportGenerator selfHelpReport = new SelfHelpReport();
>>>>>>> suppunew
		
		//print Summary report
		System.out.println("Summary Report for patient 1");
		System.out.println("********************************");
		System.out.println(summaryReport.generateReport());
		//Print self help
		System.out.println(System.lineSeparator());
		System.out.println("Self Help Report for patient 1");
		System.out.println("********************************");
		System.out.println(selfHelpReport.generateReport());
		
	//	System.out.println("Detailed Report for patient 1");
	//	System.out.println("********************************");
	//	System.out.println(detailedReport.generateReport());
		
		patient1Reports.add(detailedReport);
		patient1Reports.add(summaryReport);
		patient1Reports.add(selfHelpReport);

		patient1.setReports(patient1Reports);
		// This will print out all of the reports to the screen
		//patient1.printAllReports();
<<<<<<< HEAD
				
=======
		DetailedReport dR= new DetailedReport();
		String generatedReport = dR.generateReport();
		System.out.println(generatedReport);
>>>>>>> suppunew
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
