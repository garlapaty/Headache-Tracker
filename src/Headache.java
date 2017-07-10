
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Headache {
	
	private HeadacheType headacheType;
	private Date painDate;
	private Date painStartTime;
	private Date painEndTime;
	private SeverityLevelType severityLevel;
	private PainLocation painLocation;
	private Medication medication;
	private Date medStartTime;
	private Date medEffectiveTime;
	private String[] trigger;
	private String[] selfHelp;
	private static int headacheCounter=0;
	private static int severity;
	private HashSet<Symptom> symptoms;
	private static List<Double> duration = new ArrayList<Double>();
	
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	DateFormat tf = new SimpleDateFormat("h:mm a");
	
	public Headache(){
	
	}
	
	public Headache(HeadacheType headacheType, Date painDate, Date painStartTime, Date painEndTime, 
					SeverityLevelType severityLevel,PainLocation painLocation,
					HashSet<Symptom> symptoms, Medication medication, Date medStartTime, Date medEffectiveTime,
					String[] trigger, String[] selfHelp) {
		
		this.headacheType = headacheType;
		this.painDate = painDate;
		this.painStartTime = painStartTime;
		this.painEndTime = painEndTime;
		this.severityLevel = severityLevel;
		this.painLocation = painLocation;
		this.symptoms = symptoms;
		this.medication = medication;
		this.medStartTime = medStartTime;
		this.medEffectiveTime = medEffectiveTime;
		this.trigger = trigger;
		this.selfHelp = selfHelp;
        setHeadacheCounter(getHeadacheCounter() + 1); 
        severity = severity+severityLevel.getSeverityLevelValue(); //may change
                             
	}
	
	public static int getSeverity() {
		return severity;
	}

	public static void setSeverity(int severity) {
		Headache.severity = severity;
	}

	public static List<Double> getDuration() {
		return duration;
	}

	public static void setDuration(List<Double> duration) {
		Headache.duration = duration;
	}

	//This is not used at this time. 
	//if we have to display data like the patient data from the provided excel, we could use this
	public String getHeadache(){
		
		StringBuilder builder = new StringBuilder();
		builder.append("Date : ");
		builder.append(df.format(painDate) + "\n");
		builder.append("Start Time : ");
		builder.append(tf.format(painStartTime) + "\n");
		builder.append("End Time : ");
		builder.append(tf.format(painEndTime) + "\n");
		builder.append("Type : ");
		builder.append(headacheType + "\n");
		builder.append("Severity: ");
		builder.append(severityLevel.getSeverityLevelValue() + "\n");
		builder.append("Pain Description : ");
		builder.append(painLocation + "\n");
		builder.append("Location : ");
		builder.append(painLocation + "\n");
		builder.append("Symptoms : ");
		builder.append(symptoms + "\n");
		builder.append("Medication : ");
		builder.append(medication + "\n");
		builder.append("Med Start : ");
		builder.append(tf.format(medStartTime) + "\n");
		builder.append("Med Effective : ");
		builder.append(tf.format(medEffectiveTime) + "\n");
		builder.append("Triggers : ");
		builder.append(trigger.toString() + "\n");
		builder.append("Self-Help : ");
		builder.append(selfHelp.toString() + "\n");

		return builder.toString();
	}
	
	public long getPainDuration()  {
		long durationInMinutes = ((painEndTime.getTime() - painStartTime.getTime())/(1000*60));
		duration.add((double) durationInMinutes);
		String painDuration = (durationInMinutes/60) + " hours " + (durationInMinutes%60) + "min";
		return durationInMinutes;
		
		
	}
	
	
	public int getHeadacheCounter() {
		return headacheCounter;
	}

	public void setHeadacheCounter(int headacheCounter) {
		this.headacheCounter = headacheCounter;
	}
	
	
	
	
	

}
