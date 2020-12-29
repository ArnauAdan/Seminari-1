import java.util.LinkedList;

/**
 * Room. Classe encarregada de representar una habitació de l'hospital.
 * 
 * Una habitació estarà formada pels atributs identificador d'habitació i una
 * llista representant els llits que conté.
 * 
 * El seu objectiu és representar una habitació de l'hospital i dotar-la per
 * poder afegir-hi llits i comprovar la seva disponibilitat.
 */
public class Room{
	private LinkedList< Bed > beds;
	private int roomID;
	
    /**
     * Room(roomID). Constructor de Bed. 
     * @param roomID informa sobre el seu identificador.
     * (Ens permet crear instàncies de la classe inicialitzant els atributs 
     * amb valors concrets).
     */           
    public Room( int roomID ){
        this.roomID = roomID;
        beds = new LinkedList<>();
    }
    /**
     * addBed(). 
     * @param bedID instància de Bed.
     * (Afegeix el llit indicat pel paràmetre als llits disponibles de
     * l'habitació actual).
     */  	
    public void addBed( int bedID ){
        Bed bed = new Bed(bedID, this);
        beds.add(bed);
    }
    /**
     * getBed(). 
     * @param idx indicant l'índex en la llista de llits del llit desitjat.
     * @return Bed
     * (Retorna d'entre la llista de llits de l'habitació l'indicap pel 
     * paràmetre).
     */ 	
    public Bed getBed( int idx ){
        return beds.get(idx);   
    }
    /**
     * getAvaliableBed().
     * @return Bed
     * (S'encarrega d'observar si hi ha llits lliures a l'habitació. En cas
     * afirmatiu en retorna un, altrament retorna un valor nul).
     */ 	
    public Bed getAvailableBed(){
        Bed avbed = null;
        for (Bed bed : beds) {
            if(bed.isAvailable()){
                    avbed = bed;
                    break;
            }
        }            
        return avbed;
    }
    /**
     * isAvaliable().
     * @return boolean
     * (Determina si l'habitació és ocupada o no tot observant la disponibilitat
     * de cada llit en aquesta).
     */	
    public boolean isAvailable(){
        boolean check = true;
        for(Bed bed : beds){
            if(bed.isAvailable()){
                check = true;
                break;
            }
            else{
                check = false;                 
            }
        }
        return check;
    }
    /**
     * listBeds().
     * @return String
     * (Retorna un String sobre la informació de cada llit de la habitació).
     */		
    public String listBeds(){
        String listbeds = "";
        for(int i = 0; i < beds.size(); i++){
            listbeds += beds.get(i).toString() + "\n";
        }
        return listbeds;
    }
    /**
     * toString(). 
     * @return String
     * (S'encarrega de retornar en format d'String l'identificador de la 
     * habitació).
     */	    
    @Override
    public String toString(){ 
        return "Room " + roomID;
    }
}
