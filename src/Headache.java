import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Headache {
	
	private HeadacheComponent hType;
	private Date painDate;
	private Date painStartTime;
	private Date painEndTime;
	private SeverityLevelType severityLevel;
	private String painDesc;
	private ArrayList<PainLocation> painLocation;
	private static String medication;
	private Date medStartTime;
	private Date medEffectiveTime;
	private String[] trigger;
	private List<SelfHelp> selfHelps;
	private static int headacheCounter=0; // static counter
	private static int severity; // 
	private HashSet<Symptom> symptoms;
	private static List<Long> duration = new ArrayList<Long>();
	static ArrayList<String> medicalDetails = new ArrayList<String>();
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	DateFormat tf = new SimpleDateFormat("h:mm a");
	
	
	
	public Headache(HeadacheComponent hType, Date painDate, Date painStartTime, Date painEndTime, 
					SeverityLevelType severityLevel, String painDesc, ArrayList<PainLocation> painLocation,
					HashSet<Symptom> symptoms, String medication, Date medStartTime, Date medEffectiveTime,
					String[] trigger, List<SelfHelp> selfHelps) {
				
		this.hType = hType;
		this.painDate = painDate;
		this.painStartTime = painStartTime;
		this.painEndTime = painEndTime;
		this.severityLevel = severityLevel;
		this.painDesc = painDesc;
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
               medicalDetails.add(medication+","+tf.format(medStartTime).toString()+","+tf.format(medEffectiveTime).toString());               
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

	public String getHeadache(){
		
		StringBuilder builder = new StringBuilder();
		builder.append("Date : ");
		builder.append(df.format(painDate) + "\n");
		builder.append("Start Time : ");
		builder.append(tf.format(painStartTime) + "\n");
		builder.append("End Time : ");
		builder.append(tf.format(painEndTime) + "\n");
		builder.append("Type : ");
		builder.append(hType.getType() + "\n");
		builder.append("Severity: ");
		builder.append(severityLevel.getSeverityLevelValue() + "\n");
		builder.append("Pain Description : ");
		builder.append(painDesc + "\n");
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
		builder.append(Arrays.toString(trigger)+ "\n"); 
		builder.append("Self-Help : ");
		builder.append(displaySelfHelps() + "\n");
		
		return builder.toString();
	}
	
	

	//to display the self help list
	public String displaySelfHelps(){
		String selfHelp= "";
		for(SelfHelp e:selfHelps){
			selfHelp = selfHelp + " " + e.getName();
		}
		return selfHelp;
	}
	
	public long getPainDuration()  {
		long durationInMinutes = ((painEndTime.getTime() - painStartTime.getTime())/(1000*60));
		return durationInMinutes;
			
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

