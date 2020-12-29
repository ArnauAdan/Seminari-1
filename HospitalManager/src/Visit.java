import java.util.Calendar;
import java.util.Locale;

/**
 * Visit. Classe encarregada de representar una visita d'hospital. 
 * El seu objectiu és establir com vindrà definida una visita d'hospital.
 * 
 * Una visita estarà formada per la data, el resum, el doctor i el pactient
 * de la mateixa.
 */
public class Visit implements Comparable<Visit>{
	Calendar date;
	String summary;
	Doctor doctor;
	Patient patient;

    /**
     * Visit(d, s, doc, p). Constructor de Patient. 
     * @param d informa sobre la data de la visita.
     * @param s informa sobre el resum de la visita.
     * @param doc informa sobre el doctor de la visita.
     * @param p informa sobre el pacient de la visita.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */          
    public Visit( Calendar d, String s, Doctor doc, Patient p ){
        date = d;
        summary = s;
        doctor = doc;
        patient = p;
    }
    /**
     * getDate(). Getter
     * @return Calendar
     * (Retorna la data de la visita).
     */		
    public Calendar getDate(){
        return date;	
    }
    /**
     * getSumarry(). Getter
     * @return String
     * (Retorna el resum de la visita).
     */		    
    public String getSummary(){ 
        return summary;
    }
    /**
     * getDoctor(). Getter
     * @return Doctor
     * (Retorna el doctor de la visita).
     */		    
    public Doctor getDoctor(){ 
        return doctor;
    }
    /**
     * getPatient(). Getter
     * @return Patient
     * (Retorna el pacient de la visita).
     */	    
    public Patient getPatient(){ 
        return patient;	
    }
    /**
     * compareTo()
     * @param v Instància de visita a comparar amb la instància actual.
     * @return Integer
     * (S'encarrega de comparar dues visites tot fixant-se en la seva data. 
     * Retornarà un enter positiu si la data de la instància actual és major que 
     * la de la indicada pel paràmetre, un negatiu pel cas contrari i 0 si són 
     * iguals. Sobreescrivim el mètode de la interfície Comparable per més tard
     * usar-lo com a guia per ordenar llistes de visites).
     */        
    @Override
    public int compareTo(Visit v){
        return v.date.compareTo(this.date); 
    }
    /**
     * toString(). 
     * @return String
     * (S'encarregarà de retornar en format d'String la informació sobre la 
     * visita).
     */		
    @Override
    public String toString(){ 
        return date.get(Calendar.DATE) + " " + date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + date.get(Calendar.YEAR) + "\n" + doctor.toString() + " " + patient.toString() + " " + "Summary: " + summary;
    }
}
