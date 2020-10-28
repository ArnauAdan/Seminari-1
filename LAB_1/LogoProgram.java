package logoprogram;

/**
 *
 * @author eleison
 */

public class LogoProgram {

    public static void main(String[] args) {
        // TODO code application logic here
        Program p = new Program("Square");
        p.addInstruction("REP", 4);
        p.addInstruction("FWD", 100);
        p.addInstruction("ROT", 90);
        p.addInstruction("END", 1);
        p.getNextInstruction();
        if(p.isCorrect()){
            p.restart();
            while(!p.hasFinished()){
                p.getNextInstruction();

            }
            
        }else{
            p.printErrors();
        }
    }   
}
