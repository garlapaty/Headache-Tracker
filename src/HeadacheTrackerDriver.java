import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import com.sun.xml.internal.bind.v2.runtime.Location;

public class HeadacheTrackerDriver {

	public static void main(String[] args) throws ParseException {

		//Testing with medications
		Medication m1 = new Medication("MaxAlt","triptan class","5mg");
		Medication m2 = new Medication("Anaprox","NSAID class","550mg");
		Medication m3 = new Medication("Anaprox","NSAID class","550mg");
		Medication m4 = new Medication("MaxAlt","triptan class","5mg");
		   
		// Create a Patient from the driver class
		Patient patient1 = new Patient();

		// Create the Headaches
		List<Headache> patient1Headaches = new ArrayList<Headache>();
		
		//type
		HeadacheComponent ht1= new SingleHeadache("Migraine");
		HeadacheComponent ht2 = new SingleHeadache("Tension");
		HeadacheComponent ht3 = new CompositeHeadache("Combined"); // an example for presentation
		ht3.addType(ht1);
		ht3.addType(ht2);
		
		//painLoc
		ArrayList<PainLocation> location1 = new ArrayList<PainLocation>();
		PainLocation pl1 = new PainLocation(PainLocation.Side.LEFTSIDE,PainLocation.Loc.OCULAR);
		location1.add(pl1);
		
		//storing symptoms into hashset
		//Headache1
		HashSet<Symptom> symptoms1 = new HashSet<Symptom>();

		symptoms1.add(new Symptom(SymptomType.PRODROME,new String[]{"Nausea"}));
		symptoms1.add(new Symptom(SymptomType.CONCURRENT,new String[]{"Light sensitivity"}));
		symptoms1.add(new Symptom(SymptomType.POSTDROME,new String[]{"Fatigue"}));

		// Create the self help treatment
		List<SelfHelp> selfHelps1 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp1 = new SelfHelp("none", "");
		selfHelps1.add(selfHelp1);
		
		Headache headache1 = new Headache(ht1, getDateFormat("05/01/2017"),
				getTimeFormat("7:30 AM"), getTimeFormat("11:00 AM"), 
				SeverityLevelType.SEVEN, "stabbing",
				location1,
				symptoms1,
				m1.returnPatientData(),
				getTimeFormat("9:00 AM"), getTimeFormat("11:00 AM"),
				new String[]{"scent-fumes from construction", "lighting-sun glare"}, 
				selfHelps1);
		
		//End of headache 1

		//Headache 2	
		HashSet<Symptom> symptoms2 = new HashSet<Symptom>();
		symptoms2.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain"}));

		// Create the self help treatment
		List<SelfHelp> selfHelps2 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp2 = new SelfHelp(SelfHelpType.PHYSICAL_THERAPY.toString(), "helped a lot");
		selfHelps2.add(selfHelp2);	

		//pain location
		ArrayList<PainLocation> location2 = new ArrayList<PainLocation>();
		PainLocation pl2 = new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.SUBOCCIPITAL);
		location2.add(pl2);
		
		Headache headache2 = new Headache(ht3, getDateFormat("05/06/2017"),
				getTimeFormat("6:00 PM"), getTimeFormat("9:15 PM"),
				SeverityLevelType.FIVE,"dull",
				location2,symptoms2,
				m2.returnPatientData(),
				getTimeFormat("7:00 PM"), getTimeFormat("9:15 PM"),
				new String[]{"missed meal"}, 
				selfHelps2);

		//End of headache2
		
		// Headache 3
		HashSet<Symptom> symptoms3 = new HashSet<Symptom>();
		symptoms3.add(new Symptom(SymptomType.CONCURRENT,new String[]{"neck pain", "sinus congestion"}));

		// Create the self help treatment
		List<SelfHelp> selfHelps3 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp3a = new SelfHelp(SelfHelpType.PHYSICAL_THERAPY.toString(), "helped a lot");
		SelfHelp selfHelp3b = new SelfHelp(SelfHelpType.BIOFEEDBACK.toString(), "didn't help"); 
		selfHelps3.add(selfHelp3a);
		selfHelps3.add(selfHelp3b);
		
		ArrayList<PainLocation> location3 = new ArrayList<PainLocation>();
		PainLocation pl3 = new PainLocation(PainLocation.Side.BILATERAL, PainLocation.Loc.FRONTAL);
		PainLocation pl4 = new PainLocation(PainLocation.Side.RIGHTSIDE, PainLocation.Loc.TEMPORAL);
	    location3.add(pl3); location3.add(pl4);
	    
		Headache headache3 = new Headache(ht2, getDateFormat("05/10/2017"),
				getTimeFormat("4:00 PM"), getTimeFormat("9:00 PM"),
				SeverityLevelType.SIX,"dull",
				location3, symptoms3,
				m3.returnPatientData(),
				getTimeFormat("5:00 PM"), getTimeFormat("7:00 PM"),
				new String[]{"stress"},
				selfHelps3);

		// End of headache3

		//Headache4
		HashSet<Symptom> symptoms4 = new HashSet<Symptom>();
		symptoms4.add(new Symptom(SymptomType.POSTDROME, new String[]{"nausea","tearing"}));
		symptoms4.add(new Symptom(SymptomType.CONCURRENT, new String[]{"vision disturbance"}));
		
		List<SelfHelp> selfHelps4 = new ArrayList<SelfHelp>();
		SelfHelp selfHelp4 = new SelfHelp(SelfHelpType.REST_SLEEP.toString(), "helped a little");
		selfHelps4.add(selfHelp4);
		
		ArrayList<PainLocation> location4 = new ArrayList<PainLocation>();
		PainLocation pl5 = new PainLocation(PainLocation.Side.LEFTSIDE, PainLocation.Loc.OCULAR);
		location4.add(pl5);
		Headache headache4 = new Headache(ht1, getDateFormat("05/17/2017"),
				getTimeFormat("6:00 AM"), getTimeFormat("9:00 AM"),
				SeverityLevelType.SEVEN,"pulsating",
				location4,
				symptoms4,
				m4.returnPatientData(),
				getTimeFormat("6:15 AM"), getTimeFormat("7:30 AM"),
				new String[]{"sleep change - lack of sleep"}, 
				selfHelps4);

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
		
		ReportGenerator summaryReport = new SummaryReport(getDateFormat("05/01/2017"), getDateFormat("05/20/2017"));
		ReportGenerator selfHelpReport = new SelfHelpReport(patient1.getHeadaches());
		DetailedReport detailedReport= new DetailedReport();

		patient1Reports.add(summaryReport);
		patient1Reports.add(detailedReport);
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
