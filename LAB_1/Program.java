/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logoprogram;
import java.util.LinkedList;

/**
 *
 * @author eleison
 */
public class Program {
    private LinkedList< Instruction > instructions = new LinkedList< Instruction >();
    private int currentLine;
    private int loopIteration;
    private String programName;
    
    public Program(String name){
       programName = name;
       
    }

    public String getName(){
        return programName;
    }
    
    public boolean addInstruction(String c, double p){
        Instruction ins = new Instruction(c,p);
        instructions.add(ins);
        return true;
    }
    
    public void restart(){
        currentLine = 0;

    }
    
    public boolean hasFinished(){
       return (loopIteration == 0); 
    }
    
    public Instruction getNextInstruction(){
        Instruction next = instructions.get(currentLine);
        
        if(next.isRepInstruction()){
            
            if(next.getCode().equals("REP")){
            double reps = next.getParam();
            loopIteration = (int)reps;
            }   
            if(next.getCode().equals("END")){
                
                goToStartLoop();
                loopIteration -= 1;
            }
        }
        else{
            System.out.println(next.info());
        }
        
        currentLine += 1;
        return next;
    }
                         
    public boolean isCorrect(){ 
        boolean correct = true;
        for(int i = 0; i < instructions.size(); i++){
            if(!(instructions.get(i).isCorrect())){
                correct = false;
            }             
        }
        return correct;

    }
    
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
    
    private void goToStartLoop(){
        int rep_pos = instructions.indexOf("REP");
        currentLine = rep_pos + 1;
    }
}
