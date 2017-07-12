<<<<<<< HEAD

=======
>>>>>>> suppunew
import java.util.List;

public class Patient {
	
	private List<Headache> headaches;

	private List<ReportGenerator> reports;
	
	public void printAllReports() {
		for(ReportGenerator report : reports)
		{
<<<<<<< HEAD
			report.generateReport();
=======
			System.out.print(report.generateReport());
>>>>>>> suppunew
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
<<<<<<< HEAD

=======
>>>>>>> suppunew
