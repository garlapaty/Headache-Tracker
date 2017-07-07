
public class SummaryReportTest implements ReportTest{
    
	@Override
	public String generateReport() {
		
		
		return null;
	}

	@Override
	public String generateReportHeader() {
		
		return "Report Start Date|\t"
				+ "Report End Date|\t"
				+ "Headache Count|\t"
				+ "Average Severity|\t"
				+ "Average Duration"	;
	}

	
	
}
