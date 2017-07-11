import java.util.Arrays;

public class Symptom {
	
	private SymptomType symptomType;
	private String[] symptom;
	
	
	public Symptom(SymptomType type, String[] symptom) {
			
			this.symptomType = type;
			this.symptom  = symptom;
	}
	
	public String getSymptom() {
		return Arrays.toString(symptom);
	}
	
	//We have to change the format of this array later. Not priority right now as we are not displaying
	public String toString() {
		return symptomType + "-" + Arrays.toString(symptom);
	}
	
}