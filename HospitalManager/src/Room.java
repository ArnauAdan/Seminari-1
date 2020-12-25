
import java.util.LinkedList;

public class Room{
	private LinkedList< Bed > beds;
	private int roomID;
	
	public Room( int roomID ){
            this.roomID = roomID;
            beds = new LinkedList<>();
	}
	
	public void addBed( int bedID ){
            Bed bed = new Bed(bedID, this);
            beds.add(bed);
	}
	
	public Bed getBed( int idx ){
            return beds.get(idx);
	}
	
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
	
	public String listBeds(){
            String listbeds = null;
            for(int i = 0; i < beds.size(); i++){
                listbeds += beds.get(i).toString() + "%n";
            }
            return listbeds;
	}

        @Override
	public String toString(){ 
		return "Room " + roomID;
	}
}
