import java.text.DateFormat;
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
	private List<SelfHelp> selfHelps;

	private static int headacheCounter=0; // static counter
	private static int dosageCounter=0;
	private static int severity; // 
	private HashSet<Symptom> symptoms;
	private static List<Long> duration = new ArrayList<Long>();
	
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	DateFormat tf = new SimpleDateFormat("h:mm a");
	
	public Headache(){
	
	}
	
	public Headache(HeadacheType headacheType, Date painDate, Date painStartTime, Date painEndTime, 
					SeverityLevelType severityLevel,PainLocation painLocation,
					HashSet<Symptom> symptoms, Medication medication, Date medStartTime, Date medEffectiveTime,
					String[] trigger, List<SelfHelp> selfHelps) {
		
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
		this.selfHelps = selfHelps;
        setHeadacheCounter(getHeadacheCounter() + 1); 
        severity = severity+severityLevel.getSeverityLevelValue(); //adding all the severity
        duration.add(getPainDuration()); // adding durations in minutes to the static list
                             
	}
	
	public static int getSeverity() {
		return severity;
	}

	public static void setSeverity(int severity) {
		Headache.severity = severity;
	}

	public static List<Long> getDuration() {
		return duration;
	}

	public static void setDuration(List<Long> duration) {
		Headache.duration = duration;
	}

	public List<SelfHelp> getSelfHelp() {
		return selfHelps;
	}

	public void setSelfHelp(List<SelfHelp> selfHelps) {
		this.selfHelps = selfHelps;
	}
	
	public Medication getMedication(){
		return this.medication;
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
		builder.append(selfHelps.toString() + "\n");
		
		return builder.toString();
	}
	
	public long getPainDuration()  {
		long durationInMinutes = ((painEndTime.getTime() - painStartTime.getTime())/(1000*60));
		return durationInMinutes;
			
	}
	
	public long getMedAffectiveTime(){
		long durationInHours=(((medEffectiveTime.getTime()-medStartTime.getTime())/(1000*60))/60);
		return durationInHours;
	}
	
	public static long getaverageDuration(){
		long avgDurationInMinutes = 0;
		for(int i=0;i<duration.size();i++){
			avgDurationInMinutes = avgDurationInMinutes+duration.get(i);
		}
		return avgDurationInMinutes;
	}
		
	public static int getHeadacheCounter() {
		return headacheCounter;
	}

	public void setHeadacheCounter(int headacheCounter) {
		this.headacheCounter = headacheCounter;
	}
	
	
}
