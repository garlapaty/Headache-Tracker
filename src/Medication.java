import java.util.Date;

public class Medication {
public static  String name;
public static  String medClass;
public static  String dose;
public static  int doseCount;
public static Date timeEffective;
public  String getName() {
	return name;
}
public static void setName(String name) {
	Medication.name = name;
}
public  String getMedClass() {
	return medClass;
}
public  void setMedClass(String medClass) {
	Medication.medClass = medClass;
}
public  String getDose() {
	return dose;
}
public static void setDose(String dose) {
	Medication.dose = dose;
}
public static int getDoseCount() {
	return doseCount;
}
public static void setDoseCount(int doseCount) {
	Medication.doseCount = doseCount;
}
public static Date getTimeEffective() {
	return timeEffective;
}
public static void setTimeEffective(Date timeEffective) {
	Medication.timeEffective = timeEffective;
}
}






