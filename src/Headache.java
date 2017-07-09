import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;

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
	private int headacheCounter=0;
	private long painDuration;
	private HashSet<Symptom> symptoms;
	
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
	
	public String getPainDuration() throws ParseException {
		long duration = ((painEndTime.getTime() - painStartTime.getTime())/(1000*60));
		String timeDiff = (duration/60) + " hours " + (duration%60) + "min";
		
		return timeDiff;
		
		
	}

	public int getHeadacheCounter() {
		return headacheCounter;
	}

	public void setHeadacheCounter(int headacheCounter) {
		this.headacheCounter = headacheCounter;
	}
	
	
	
	
	

}
