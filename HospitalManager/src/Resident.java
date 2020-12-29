/**
 * Resident. Classe filla de Patient, encarregada de representar el tipus 
 * de pacient resident. El seu objectiu és establir com vindrà definit un 
 * resident de l'hospital i dotar-lo per duur a terme operacions sobre ell
 * com ara assignar-li una habitació, llit o doctor.
 * 
 * Un resident estarà format pels atributs identificador, nom i edat
 * de les classes pare donada la relació d'herència amb elles i l'habitació
 * i llit on s'estableix.
 */
public class Resident extends Patient
{
	private Room room;
	private Bed bed;

    /**
     * Resident(id, name, age). Constructor de Resident. 
     * @param id atribut de Person, informa sobre l'identificador de la persona.
     * @param name atribut de Person, informa sobre el nom de la persona.
     * @param age atribut de Patient, informa sobre l'edat del pacient.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */             
    public Resident ( int id, String name, int age ){
        super(id, name, age);
    }
    /**
     * assignRoom(). Setter
     * @param r instància de la classe Room.
     * (S'encarrega d'establir l'habitació que ocuparà el resident).
     */		
    public void assignRoom( Room r ){
        room = r;         
    }
    /**
     * assignBed(). Setter
     * @param b instància de la classe Bed.
     * (S'encarrega d'establir el llit que ocuparà el resident).
     */		
    public void assignBed( Bed b ){
        bed = b;
        b.assignResident(this); 
    }
    /**
     * getDoctor(). Getter
     * @return Doctor
     * (Retorna el doctor assignat al pacient. Li assignarem aquell que hagi
     * duut a terme la primera visita).
     */		
    public Doctor getDoctor(){
        // si ha estat visitat per algun doctor
        if(visits.size() > 0){
            return visits.get(0).getDoctor();
        }
        else{
            return null; 
        }         
    }
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String el nom, identificador i edat
     * de la instància actual de resident).
     */		
    @Override
    public String toString(){
        return "Resident " + name + " ( ID " + id + ", age " + age + " )";
    }
}
