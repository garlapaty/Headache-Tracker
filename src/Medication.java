import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Medication 
{
	static ArrayList<String> medicineName = new ArrayList<String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public   String name;
	public  String medClass;
	public   String dose;
	public   int doseCount;
	public  Date timeEffective;
	
public Medication(String name, String medClass, String dose, int doseCount, String timeEffective) throws ParseException
{	
	DateFormat df = new SimpleDateFormat("h:mm a");
	Date d=df.parse(timeEffective);
		this.name = name;
		this.medClass = medClass;
		this.dose = dose;
		this.doseCount = doseCount;
		this.timeEffective = d;
}
public String returnPatientData()
{
	if(medicineName.isEmpty()){
		medicineName.add(name);
	}
	else if(!medicineName.contains(name)){
		medicineName.add(name);
	}
	return name+","+medClass+","+dose;
}
public Medication(String name, String medClass, String dose) {
		//super();
		this.name = name;
		this.medClass = medClass;
		this.dose = dose;
	}
}