
public class SummaryReport implements ReportGenerator{
    
	@Override
	public String generateReport() {
		
		
		return null;
	}

	public String generateReportHeader() {
		
		return "Report Start Date|\t"
				+ "Report End Date|\t"
				+ "Headache Count|\t"
				+ "Average Severity|\t"
				+ "Average Duration"	;
	}

	
	
}
