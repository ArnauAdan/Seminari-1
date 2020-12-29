import java.util.Calendar;
import java.util.LinkedList;

/**
 * Patient. Classe filla de Person, encarregada de representar el tipus 
 * de persona pacient. El seu objectiu és establir com vindrà definit un 
 * pacient de l'hospital i dotar-lo per a que pugui emmagatzemar informació
 * sobre les accions que se li apliquen.
 * 
 * Un pacient estarà format pels atributs nom, identificador de la classe pare 
 * donada la relació d'herència amb ella i la seva data d'entrada a l'hospital,
 * l'edat i les visites que ha fet.
 */
public abstract class Patient extends Person implements Comparable<Patient>
{
    protected Calendar admissionDate;
    protected Integer age;
    protected LinkedList< Visit > visits;

    /**
     * Patient(id, name, age). Constructor de Patient. 
     * @param id atribut de Person, informa sobre l'identificador de la persona.
     * @param name atribut de Person, informa sobre el nom de la persona.
     * @param age atribut de Patient, informa sobre l'edat del pacient.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */     
    public Patient( int id, String name, int age ){
        super(id, name);
        this.age = age;
        visits = new LinkedList<>();
    }
    /**
     * addVisit().
     * @param v instància de la classe Visit.
     * (S'encarrega d'afegir una visita al registre de visites fetes pel 
     * pacient).
     */	
    public void addVisit( Visit v ){
	visits.add(v);
    }
    /**
     * setAdmissionDate(). Setter
     * @param d data indicada per la classe Calendar
     * (S'encarrega destablir la data d'admissió del pacient).
     */			
    public void setAdmissionDate( Calendar d ){
        this.admissionDate = d;
    }
    /**
     * getAdmissionDate(). Getter
     * @return Calendar
     * (Retorna la data d'admissió del pacient).
     */		
    public Calendar getAdmissionDate(){
        return admissionDate;
    }
    /**
     * setAge(). Setter
     * @param age edat del pacient
     * (S'encarrega destablir l'edat del pacient).
     */	
    public void setAge( Integer age ){
        this.age = age;	
    }
    /**
     * getAge(). Getter
     * @return Integer
     * (Retorna l'edat del pacient).
     */            
    public Integer getAge(){
        return age;	
    }
    /**
     * compareTo()
     * @param p Instància de pacient a comparar amb la instància actual.
     * @return Integer
     * (S'encarrega de comparar dos pacients tot fixant-se en la seva edat. 
     * Retornarà un enter positiu si l'edat de la instància actual és major que 
     * la de la indicada pel paràmetre, un negatiu pel cas contrari i 0 si són 
     * iguals. Sobreescrivim el mètode de la interfície Comparable per més tard
     * usar-lo com a guia per ordenar llistes de pacients).
     */      
    @Override
    public int compareTo( Patient p ){
        return this.age - p.age;
    }
    /**
     * toString(). 
     * @return String
     * (S'encarregarà de retornar en format d'String la informació desitjada 
     * sobre el pacient segons el seu tipus).
     */	
    @Override
    public abstract String toString();
}
