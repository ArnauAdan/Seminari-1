package logoapp;
import java.util.LinkedList;

/**
 *
 * @author eleison
 */

/**
 * Progam. Classe encarregada de representar un programa de LogoProgram. 
 * Un programa estarà format per instruccions, comptadors per seguir la 
 * instrucció actual i el loop actual d'un bucle i el nom del mateix. 
 * 
 * Program ens permetrà que la tortuga segueixi un tret de comportaments
 * (instruccions), donant com a resultat un programa.
 */
public class Program {
    private LinkedList< Instruction > instructions = new LinkedList< Instruction >();
    private int currentLine;
    private int loopIteration;
    private String programName;
    
    /**
     * Program(). Constructor, crea instàncies de la classe
     * assignant-ne un paràmetre.
     * @param name atribut de Program, informa sobre
     * el nom del programa a instanciar.
     */    
    public Program(String name){
       programName = name;      
    }
    /**
     * getName(). Getter
     * @return String Retorna l'atribut programName
     * (el nom del programa).
     */
    public String getName(){
        return programName;
    }
    /**
     * addInstruction(). 
     * @return boolean Retorna cert després d'haver
     * afegit una nova instrucció a la llista d'instruccions
     * del programa.
     */    
    public boolean addInstruction(String c, double p){
        Instruction ins = new Instruction(c,p);
        instructions.add(ins);
        return true;
    }
    /**
     * restart().
     * Estableix el punt de partida pel programa, que serà la 
     * primera instrucció.
     */     
    public void restart(){
        currentLine = 0;
        loopIteration = -1;
    }
    /**
     * hasFinished().
     * @return boolean Retorna cert quan el programa ha finalitzat, és
     * a dir, s'han donat totes les iteracions desitjades del bucle
     * d'instruccions.
     */     
    public boolean hasFinished(){
       return (loopIteration == 0); 
    }
    /**
     * getNextInstruction(). 
     * @return Instruction Retorna la següent instrucció a seguir
     * del programa.
     * 
     * Al detectar com a següent instrucció END ens dirigrià cap
     * a la primera instrucció just després del REP previament
     * llegit respectant, d'aquesta manera, qualsevol bucle 
     * d'instruccions dins el programa.
     */     
    public Instruction getNextInstruction(){
        Instruction next = instructions.get(currentLine);
        
        if(next.isRepInstruction()){           
            if(next.getCode().equals("REP")){
            double reps = next.getParam();
            loopIteration = (int)reps;
            System.out.println("rep loop iter");            
            System.out.println(loopIteration);

            }   
            if(next.getCode().equals("END")){
                
                goToStartLoop();
                loopIteration -= 1;
                System.out.println("end loop iteration");//test
                System.out.println(loopIteration);//test
            }
        }
        else{
            System.out.println(next.info());
        }       
        currentLine += 1;
        return next;
    }
    /**
     * isCorrect().
     * @return boolean Retorna fals si qualsevol de les instruccions 
     * del programa té cap error, cert altrament. 
     */                          
    public boolean isCorrect(){ 
        boolean correct = true;
        for(int i = 0; i < instructions.size(); i++){
            if(!(instructions.get(i).isCorrect())){
                correct = false;
            }             
        }
        return correct;

    }
    /**
     * printErrors().
     * Estudia quins tipus d'errors apareixen en les instruccions
     * del programa i informa sobre aquests.
     */      
    public void printErrors(){
        
        LinkedList< Integer > error_n = new LinkedList<>();
        
        for( int i = 0; i < instructions.size(); i++){
            error_n.add(instructions.get(i).errorCode());
        }
                
        if(error_n.contains(1)){
            for(int i = 0; i < instructions.size(); i++){
                if(error_n.get(i) == 1){
                    int index = i + 1;
                    System.out.println("Instruction" + " "+ index +" "+ "ERROR: the code is not among the valid logo codes" );
                }
            }
        }        
        if(error_n.contains(2)){
            for(int i = 0; i < instructions.size(); i++){
                if(error_n.get(i) == 2){
                    int index = i + 1;
                    System.out.println("Instruction" + " "+ index +" "+ "ERROR: FWD code, the param is not in the interval (-1000,1000)" );
                }
            }
        }        
        if(error_n.contains(3)){
            for(int i = 0; i < instructions.size(); i++){
                if(error_n.get(i) == 3){
                    int index = i + 1;
                    System.out.println("Instruction" + " "+ index +" "+ "ERROR: PEN code has param dierent from 0 or 1");
                }
            }
        }        
        if(error_n.contains(4)){
            for(int i = 0; i < instructions.size(); i++){
                if(error_n.get(i) == 4){
                    int index = i + 1;
                    System.out.println("Instruction" + " "+ index +" "+ "ERROR: ROT code has param greater or equal 360, or less or equal -360");
                }
            }
        }         
        if(error_n.contains(5)){
            for(int i = 0; i < instructions.size(); i++){
                if(error_n.get(i) == 5){
                    int index = i + 1;
                    System.out.println("Instruction" + " "+ index +" "+ "ERROR: REP code has param less or equal 0 or greater or equal 1000" );
                }
            }
        }         
    }
    /**
     * goToStartLoop().
     * Troba la instrucció que segueix a REP i la estableix
     * com a següent instrucció.
     * Ens serveix per manegar loops, enviant-nos a la primera
     * instrucció del mateix un cop ha arribat a la ultima (END).
     */       
    private void goToStartLoop(){
        int rep_pos = 0;
        for(int i = 0; i < instructions.size(); i++) {
            
            if(instructions.get(i).getCode().equals("REP")) {
                rep_pos = i;
            }
        }
        System.out.println("rep_pos");
        System.out.println(rep_pos);
        currentLine = rep_pos;
    }
    
    public Instruction getCurrentInstruction() {
        return instructions.get(currentLine-1);
    }
}
