import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
	private static String medication;
	private Date medStartTime;
	private Date medEffectiveTime;
	private String[] trigger;
	private String[] selfHelp;
	private static int headacheCounter=0; // static counter
	private static int severity; // 
	private HashSet<Symptom> symptoms;
	private static List<Long> duration = new ArrayList<Long>();
    static ArrayList<String> medicalDetails = new ArrayList<String>();
    static ArrayList<String>medicineName = new ArrayList<String>();
	String[] parser;
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	DateFormat tf = new SimpleDateFormat("h:mm a");
	
	public Headache(){
	
	}
	
	public Headache(HeadacheType headacheType, Date painDate, Date painStartTime, Date painEndTime, 
					SeverityLevelType severityLevel,PainLocation painLocation,
					HashSet<Symptom> symptoms,String medication, Date medStartTime, Date medEffectiveTime,
					String[] trigger, String[] selfHelp) {
		
		this.headacheType = headacheType;
		this.painDate = painDate;
		this.painStartTime = painStartTime;
		this.painEndTime = painEndTime;
		this.severityLevel = severityLevel;
		this.painLocation = painLocation;
		this.symptoms = symptoms;
		Headache.medication = medication;
		this.medStartTime = medStartTime;
		this.medEffectiveTime = medEffectiveTime;
		this.trigger = trigger;
		this.selfHelp = selfHelp;
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
	public String returnTriggers()
	{
		String tg = "";
		
			for (int i = 0; i < trigger.length; i++) 
			{
				tg = tg + trigger[i] + " ";
			}
		String t=Arrays.toString(trigger); 
		return t;
	}
	public String returnSelfHelp()
	{
		String sh = "";
		
			for (int i = 0; i < selfHelp.length; i++) 
			{
				sh = sh + selfHelp[i] + " ";
			}
		String t=Arrays.toString(selfHelp); 
		return t;
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
	//	Headache.setMedicalDetailReport(medication);
		builder.append("Med Start : ");
		builder.append(tf.format(medStartTime) + "\n");
		builder.append("Med Effective : ");
		builder.append(tf.format(medEffectiveTime) + "\n");
		builder.append("Triggers : ");
		builder.append(returnTriggers() + "\n");
		builder.append("Self-Help : ");
		builder.append(returnSelfHelp() + "\n");
		
		return builder.toString();
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
		Headache.headacheCounter = headacheCounter;
	}

		

}

