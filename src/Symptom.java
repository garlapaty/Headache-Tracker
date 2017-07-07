import java.util.Arrays;

public class Symptom {
	
	private SymptomType symptomType;
	private String[] symptoms;
	
    	
	public Symptom(SymptomType type, String[] symptoms){
		this.symptomType = type;
		this.symptoms = symptoms;
		
	}
	
	public String getSymptoms(){
		
		
		return symptomType + "-" + Arrays.toString(symptoms);
		
		
	}
	
}
