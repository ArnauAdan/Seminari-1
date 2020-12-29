import java.util.LinkedList;

/**
 * Doctor. Classe filla de Person, encarregada de representar el tipus 
 * de persona doctor. El seu objectiu és representar un doctor qualsevol de
 * l'hospital, assignant-li les seves especialitats i visites realitzades.
 * 
 * Un doctor estarà format pels atributs identificador i nom 
 * de la classe pare donada la relació d'herència amb ella i els seus
 * camps d'especialització i visites realitzades.
 */
public class Doctor extends Person
{
    private LinkedList< String > specialities;
    private LinkedList< Visit > visits;

    /**
     * Doctor(id, name). Constructor de Doctor. 
     * @param id atribut de Person, informa sobre l'identificador de la persona.
     * @param name atribut de Person, informa sobre el nom de la persona.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */            
    public Doctor( int id, String name ){
        super(id, name);
                
        specialities = new LinkedList<>();
        visits = new LinkedList<>();
    }
    /**
     * addSpeciality().
     * @param s String indicant el camp d'especialització del doctor.
     * (S'encarrega d'afegir un camp d'especialització pel doctor).
     */ 	
    public void addSpeciality( String s ){
        specialities.add(s);
    }
    /**
     * addVisit().
     * @param v instància de la classe Visit.
     * (S'encarrega d'afegir una visita al registre de visites del doctor).
     */ 	
    public void addVisit( Visit v ){
        visits.add(v);	
    }
    /**
     * listSpecialities().
     * (S'encarrega d'informar per pantalla sobre els camps d'especialització 
     * del doctor actual).
     */ 	
    public void listSpecialities(){
        System.out.println(toString() + " has specialities: ");
        for(int i = 0; i < specialities.size(); i++){
            System.out.println(specialities.get(i));
        }
    }
    /**
     * listVisits().
     * (S'encarrega d'informar per pantalla sobre les visites duutes a terme pel
     * doctor).
     */ 	
    public void listVisits(){
        System.out.println(toString() + " has the following visits: ");
        for(int i = 0; i < visits.size(); i++){             
            System.out.println(visits.get(i).toString());
        }
    }
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String l'identificador i nom del 
     * doctor).
     */		
    @Override
    public String toString(){             
        return "Doctor " + name + " ( ID " + id + " )";
    }
}
