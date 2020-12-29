/**
 * Person. Classe encarregada de representar una persona a l'hospital. 
 * El seu objectiu és establir com vindrà definida.
 * 
 * Una persona estarà formada pels atributs identificador i nom.
 */
public class Person{
	public int id;
	public String name;
	
    /**
     * Person(id, name). Constructor de Person. 
     * @param id informa sobre l'identificador de la persona.
     * @param name informa sobre el nom de la persona.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */           
    public Person( int id, String name ){
        this.id = id;
        this.name = name;
    }
    /**
     * getID(). Getter
     * @return Integer
     * (Retorna l'identificador de la persona).
     */			
    public int getID(){		
        return id;
    }
    /**
     * getName(). Getter
     * @return String
     * (Retorna el nom de la persona).
     */	    
    public String getName(){
        return name;	
    }
    /**
     * setID(). Setter
     * @param id
     * (Estableix l'identificador de la persona).
     */    
    public void setID( int id ){
        this.id = id;
    }
    /**
     * setName(). Setter
     * @param name
     * (Estableix el nom de la persona).
     */     
    public void setName( String name ){
        this.name = name;
    }
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String el nom i identificador de la
     * instància actual de persona).
     */    
    @Override
    public String toString(){
        return name + " ( ID" + " " + id + ")";
    }
}
