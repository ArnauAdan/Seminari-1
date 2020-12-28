
import java.util.Calendar;
import java.util.Locale;

public class Visit implements Comparable<Visit>{
	Calendar date;
	String summary;
	Doctor doctor;
	Patient patient;

	public Visit( Calendar d, String s, Doctor doc, Patient p ){
		date = d;
                summary = s;
                doctor = doc;
                patient = p;
	}
	
	public Calendar getDate(){
		return date;	
	}
	public String getSummary(){ 
		return summary;
	}
	public Doctor getDoctor(){ 
		return doctor;
	}
	public Patient getPatient(){ 
		return patient;	
	}
        
        @Override
        public int compareTo(Visit v){
           return v.date.compareTo(this.date); 
        }
	
        @Override
	public String toString(){ 
		return date.get(Calendar.DATE) + " " + date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + date.get(Calendar.YEAR) + "\n" + doctor.toString() + " " + patient.toString() + " " + "Summary: " + summary;
	}
}
