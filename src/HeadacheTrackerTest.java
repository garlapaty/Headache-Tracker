
public class HeadacheTrackerTest {

	public static void main(String[] args) {
		
		Severity severity = new Severity(3, "Stabbing");
		Symptom sym = new Symptom(SymptomType.CONCURRENT, new String[]{"Nausea", "Neck pain"});
		
		ReportTest summaryReport = new SummaryReportTest();
		System.out.println(summaryReport.generateReportHeader());
		System.out.println(severity.getSeverityLevel() + "\t" + severity.getSeverityDesc());
		System.out.println(sym.getSymptoms());

	}

}
