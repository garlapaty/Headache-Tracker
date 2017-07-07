import java.util.ArrayList;
import java.util.List;

public class HeadacheTrackerDriver {

	public static void main(String[] args) {
		
		// Create a Patient from the driver class
		Patient patient1 = new Patient();
		
		// Create the Headaches
		// I didn't create a createHeadache() method in the Patient class since I wasn't sure what it 
		// would do besides say "new Headache()". So I just created all the headaches here
		List<Headache> patient1Headaches = new ArrayList<Headache>();
		Headache headache1 = new Headache();
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
		
		//System.out.println(summaryReport.generateReport());
		//Symptom sym = new Symptom(SymptomType.CONCURRENT, new String[]{"Nausea", "Neck pain"});
		//System.out.println(sym.getSymptoms());
	}

}
