/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.ArrayList;

/**
 *
 * @author kevin.lawrence
 */
public class EnigmaMachine {
    
    public class CipherTextSink{
        public void send(String cipherText){
            System.out.printf("Enciphered = %s\n", cipherText);
        }
    }
    
    public class PlainTextSource{
        public void receive(String plainText){
            System.out.printf("Plain text = %s\n",plainText);
            
            if (getCts() != null){
                getCts().send(plainText);
            }
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        rotors =  new ArrayList<EnigmaTranspositionRotor>();
        this.setCts(new CipherTextSink());
        this.setPts(new PlainTextSource());
    }
    
    public EnigmaMachine(){
        
    }
    
    public EnigmaMachine(ArrayList<EnigmaTranspositionRotor> rotors){
        this.rotors = rotors;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<EnigmaTranspositionRotor> rotors;
    
    /**
     * @return the rotors
     */
    public ArrayList<EnigmaTranspositionRotor> getRotors() {
        return rotors;
    }
    
    /**
     * @param rotors the rotors to set
     */
    public void setRotors(ArrayList<EnigmaTranspositionRotor> rotors) {
        this.rotors = rotors;
    }
    
    /**
     * @param rotor the rotors to set
     */
    public void addRotor(EnigmaTranspositionRotor rotor) {
        this.rotors.add(rotor);
    }
    
        private CipherTextSink cts;
    private PlainTextSource pts;
    
    /**
     * @return the cts
     */
    public CipherTextSink getCts() {
        return cts;
    }
    
    /**
     * @param cts the cts to set
     */
    public void setCts(CipherTextSink cts) {
        this.cts = cts;
    }
    
    /**
     * @return the pts
     */
    public PlainTextSource getPts() {
        return pts;
    }
    
    /**
     * @param pts the pts to set
     */
    public void setPts(PlainTextSource pts) {
        this.pts = pts;
    }
    //</editor-fold>
}
