import java.util.List;

public class Patient {
	
	private List<Headache> headaches;

	private List<ReportGenerator> reports;
	
	public void printAllReports() {
		for(ReportGenerator report : reports)
		{

			report.generateReport();

		}
	}
	public List<Headache> getHeadaches() {
		return headaches;
	}
	public void setHeadaches(List<Headache> headaches) {
		this.headaches = headaches;
	}

	public List<ReportGenerator> getReports() {
		return reports;
	}

	public void setReports(List<ReportGenerator> reports) {
		this.reports = reports;
	}

}
