/**
 * Visitor. Classe filla de Patient, encarregada de representar el tipus 
 * de pacient visitant. El seu objectiu és establir com vindrà definit un 
 * visitant de l'hospital.
 * 
 * Un visitant estarà format pels atributs identificador, nom i edat
 * de les classes pare donada la relació d'herència amb elles.
 */
public class Visitor extends Patient
{   
    /**
     * Visitor(id, name, age). Constructor de Visitor. 
     * @param id atribut de Person, informa sobre l'identificador de la persona.
     * @param name atribut de Person, informa sobre el nom de la persona.
     * @param age atribut de Patient, informa sobre l'edat del pacient.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */    
    public Visitor( int id, String name, int age ){
        super(id, name, age);
    }
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String el nom, identificador i edat
     * de la instància actual de visitant).
     */		
    @Override
    public String toString(){ 
        return "Visitor " + name + " ( ID " + id + ", age " + age + " )";
    }
}
