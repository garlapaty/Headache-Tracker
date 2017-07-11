
public class Medication {
	private String name;
	private String medClass;
	private String dose;
	
	public Medication(String name, String medClass, String dose) {
		//super();
		this.name = name;
		this.medClass = medClass;
		this.dose = dose;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMedClass() {
		return medClass;
	}

	public void setMedClass(String medClass) {
		this.medClass = medClass;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
	
}
