import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Medication 
{
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
	return name+medClass+dose;
}



}






