import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SummaryReport implements ReportGenerator{
    private Date startDate;
    private Date endDate;
    private double averageSeverity;
    private long averageDuration; // for later when we clean up the code
    
    DateFormat df =new SimpleDateFormat("MM/dd/yyyy");

    public SummaryReport()
    {
    	
    }
     
	public SummaryReport(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		
	}

	@Override
	public String generateReport() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append("Summary Report for patient");
		builder.append(System.lineSeparator());
		builder.append("********************************");
		builder.append(System.lineSeparator());
		builder.append("Report Start Date : ");
		builder.append(System.lineSeparator());
		builder.append(df.format(startDate) + "\n");
		builder.append("Report End Date : ");
		builder.append(df.format(endDate) + "\n");
		builder.append("Headache Count : ");
		builder.append(Headache.getHeadacheCounter() + "\n");
		builder.append("Average Severity : ");
		builder.append(calculateAvgSeverity() + "\n");
		builder.append("Average Duration : ");
		builder.append(painDuration());
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		return builder.toString();
	}
	public double calculateAvgDuration(){
		//System.out.println(headache.getSeverity()/4.0);
		float hc= Headache.getHeadacheCounter();
		return Headache.getSeverity()/(hc);
	}
	public double calculateAvgSeverity(){ 
		
		averageSeverity = (double)Headache.getSeverity()/Headache.getHeadacheCounter();
		return averageSeverity;
	}
	public double painDuration(){
		//average duration is in minutes, so divide by 60
		return ((double)Headache.getaverageDuration()/Headache.getHeadacheCounter())/60;
	}
}