package logoprogram;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eleison
 */
public class Instruction {
    private String code;
    private double param;
    
    public Instruction(String c, double p){
        code = c;
        param = p;
    }
    
    public String getCode(){
        return code;
    }
    
    public double getParam(){
        return param;
    }
    
    public boolean isRepInstruction(){
        return code.equals("REP") || code.equals("END");
        
    }
    
    public boolean isCorrect(){
        boolean correct = true;
        if (errorCode() != 0){
            correct = false;
        }
        return correct;
    }
    
    public int errorCode(){
        int error_case = 0;

        String[] codes = {"REP", "FWD", "ROT", "END", "PEN"};
        boolean trigger = true;
        
        // Case 1: the code is not among the valid logo codes
        for(int i = 0; i < codes.length; i++){
            if (codes[i].equals(code)){
                trigger = false;
                break;
            }  
        } if (trigger){
            error_case = 1;
        }
        
        // Case 2: "FWD" code, the param is not in the interval (-1000,1000)
        if (code.equals("FWD")){
            if (!(param > -1000 && 1000 > param)){
                error_case = 2;
            }
        }
        
        // Case 3: "PEN" code has param dierent from 0 or 1
        if (code.equals("PEN")){
            if (param != 0 && param != 1){
                error_case = 3;
            }
        }
        
        // Case 4: "ROT" code has param greater or equal 360, or less or equal -360
        if (code.equals("ROT")){
            if(!(param > -360 && 360 > param)){
                error_case = 4;
            }
        }
        
        // Case 5: "REP" code has param less or equal 0 or greater or equal 1000
        if (code.equals("REP")){
            if(param <= 0 || 1000 <= param){
                error_case = 5;
            }
        } 
        return error_case;
    }
    
    public String info(){

        return (code + "" + param);
    }
}



