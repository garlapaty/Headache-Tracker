import java.util.Date;

public class SummaryReport implements ReportGenerator{
    private Date startDate;
    private Date endDate;
    private int headacheCount;
    private float averageSeverity;
    private float averageDuration;
    Headache headache = new Headache();
    
    
    public SummaryReport(){
    	
    }
    
    public SummaryReport(Date startDate, Date endDate, 
    		int headacheCount, float averageSeverity, float averageDuration){
    	
    	this.startDate = startDate;
    	this.endDate = endDate;
    	this.headacheCount = headacheCount;
    	this.averageSeverity = averageSeverity;
    	this.averageDuration = averageDuration;
    	
	}
	
	@Override
	public String generateReport() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Report Start Date : ");
		builder.append(startDate + "\n");
		builder.append("Report End Date : ");
		builder.append(endDate + "\n");
		builder.append("Headache Count : ");
		builder.append(headache.getHeadacheCounter() + "\n");
		builder.append("Average Severity : ");
		builder.append(averageSeverity + "\n");
		builder.append("Average Duration : ");
		builder.append(calculateAvgDuration() + "\n");
				
		return builder.toString();
	}

	public double calculateAvgDuration(){
		//System.out.println(headache.getSeverity()/4.0);
		float hc= headache.getHeadacheCounter();
		return headache.getSeverity()/(hc);
	}
	
	
}
