/**
 * Bed. Classe encarregada de representar un llit de l'hospital.
 * 
 * Un llit estarà format pels atributs identificador de llit, habitació a la
 * qual pertany i el Resident que l'ocupa.
 */
public class Bed{
    private int bedID;
    private Room room;
    private Resident resident;
		
    /**
     * Bed(id, r). Constructor de Bed. 
     * @param id atribut de Bed, informa sobre el seu identificador.
     * @param r atribut de Bed, informa sobre l'habitació on és situat.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */         
    public Bed( int id, Room r ){
        bedID = id;
        room = r;
    }
    /**
     * assignRoom(). Setter
     * @param r habitació a assignar pel llit.
     * (Estableix la habitació a la qual pertany el llit).
     */  	
    public void assignRoom( Room r ){
        room = r;
    }
    /**
     * assignResident(). Setter
     * @param r resident a assignar pel llit.
     * (Estableix el resident que ocuparà el llit).
     */  	
    public void assignResident( Resident r ){
        resident = r;
    }
    /**
     * release(). 
     * (Estableix que el llit actual ha quedat lliure deixant buit
     * l'atribut indicant el resident que l'ocupa).
     */ 	
    public void release(){
        resident = null;
    }
    /**
     * getBedID(). Getter
     * @return int
     * (Retorna l'identificador del llit).
     */	
    public int getBedID(){
        return bedID;
    }
    /**
     * isAvaliable(). 
     * @return boolean
     * (Indica mitjançant un booleà si el llit és lliure (cert) o no (fals)).
     */	
    public boolean isAvailable(){
        return (this.resident == null);
    }	
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String l'identificador del llit).
     */		
    @Override
    public String toString(){
        return "Bed " + bedID;	
    }
}
