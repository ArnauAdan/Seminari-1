package logoprogram;

/**
 *
 * @author eleison
 */

/**
 * Instruction. Classe encarregada de representar l'objecte 
 * d'una instrucció del programa LogoProgram. Una instrucció estarà formada
 * per un codi i un paràmetre. 
 * 
 * Instruction permet que la tortuga es comporti tal com la instrucció indiqui.
 */

public class Instruction {
    private String code;
    private double param;
    
    /**
     * Instruction(). Constructor, crea instàncies de la classe
     * assignant-ne els seus paràmetres.
     * @param c és el primer atribut d'Instruction, informa
     * sobre el codi de la instrucció a instanciar.
     * @param p és el segon atribut d'Instruction, informa sobre
     * el paràmetre de la instruccio a instanciar.
     */
    public Instruction(String c, double p){
        code = c;
        param = p;
    }
    /**
     * getCode(). Getter
     * @return String Retorna l'atribut code
     * (el codi de la instrucció).
     */
    public String getCode(){
        return code;
    }
    /**
     * getParam(). Getter
     * @return double Retorna l'atribut param
     * (el paràmetre de la instrucció).
     */
    public double getParam(){
        return param;
    }
    /**
     * isRepInstruction()
     * @return boolean Retorna cert quan la instrucció actual és
     * REP o END i fals pel cas contrari.
     */
    public boolean isRepInstruction(){
        return code.equals("REP") || code.equals("END");
        
    }
    /**
     * isCorrect()
     * @return boolean Retorna cert quan no es
     * troba cap error per la instrucció actual.
     * Retornarà fals en cas contrari.
     */    
    public boolean isCorrect(){
        boolean correct = true;
        if (errorCode() != 0){
            correct = false;
        }
        return correct;
    }
    /**
     * errorCode()
     * @return int Retorna un enter representant el tipus
     * d'error que figura en la instrucció. Quan no n'apareix 
     * cap retorna un 0 i, si en troba algun, estudia el cas i 
     * brinda l'enter que el representa.
     */      
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
    /**
     * info()
     * @return String Retorna els atributs code i
     * param de la instrucció actual en forma 
     * d'String (informació sobre la instrucció actual).
     */      
    public String info(){
        return (code + "" + param);
    }
}



