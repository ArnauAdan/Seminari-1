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
    private Double param;
    
    public Instruction(String c, Double p){
        code = c;
        param = p;
    }
    
    public String getCode(){
        return code;
    }
    
    public Double getParam(){
        return param;
    }
    
    public Boolean isRepInstruction(){
        return code.equals("REP") || code.equals("END");
        
    }
    
    public Boolean isCorrect(){
        Boolean error = false;
        if (errorCode() != 0){
            error = true;
        }
        return error;
    }
    
    public Integer errorCode(){
        int error_case = 0;

        String[] codes = {"REP", "FWD", "ROT", "END", "PEN"};
        Boolean trigger = true;
        
        // Case 1
        for(int i = 0; i < codes.length; i++){
            if (codes[i].equals(code)){
                trigger = false;
                break;
            }  
        } if (trigger){
            error_case = 1;
        }
        
        // Case 2
        if (code.equals("FWD")){
            if (!(param > -1000 && 1000 > param)){
                error_case = 2;
            }
        }
        
        // Case 3
        if (code.equals("PEN")){
            if (param != 0 || param != 1){
                error_case = 3;
            }
        }
        
        // Case 4
        if (code.equals("ROT")){
            if(!(param >= -360 && 360 >= param)){
                error_case = 4;
            }
        }
        
        // Case 5
        if (code.equals("REP")){
            if(param <= 0 || 1000 >= param){
                error_case = 5;
            }
        } 
        return error_case;
    }
    
    public String info(){
        return null;
    }
}
