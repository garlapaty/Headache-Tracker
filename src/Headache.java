import java.util.Date;
public class Headache {
public enum HeadacheType {MIGRAINE,CLUSTER,ICEPICK,TENSION,SINUS,REBOUND,COMBINED};	
public HeadacheType headacheType[];
public Date duration;
public Medication medication;
public Date startTime;
public Date endTime;
public PainLocation location[];
public String[] concurrentSymptoms;
public String[] postdromeSymptoms;
public String[] prodromeSymptoms;
public enum PainLevel { _1, _2, _3, _4,_5,_6,_7,_8,_9,_10 };
public PainLevel level;
public enum SeverityLevelType { _1, _2, _3, _4,_5,_6,_7,_8,_9,_10 };
public SeverityLevelType severity;
public String[] trigger;
public String selfHelp;
}