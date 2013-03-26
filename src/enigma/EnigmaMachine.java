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

    public class CipherTextSink {

        public void send(String cipherText) {
            System.out.printf("Enciphered = %s\n", cipherText);
        }
    }

    public class PlainTextSource {

        public void receive(String plainText) {
            System.out.printf("Plain text = %s\n", plainText);

            encipher(plainText);

        }
    }

    private void encipher(String plainText) {
        String cipherText = "";
        char cipherChar;
        
        for (int i = 0; i < plainText.length(); i++) {
            cipherChar = plainText.charAt(i);
            
            for (int input = 0; input < rotors.size(); input++) {
                cipherChar = rotors.get(input).getOutput(cipherChar);
                rotors.get(input).rotate();
            }
            
            for (int output = rotors.size() - 1; output >= 0; output++) {
                rotors.get(output).rotate();
                cipherChar = rotors.get(output).getInput(cipherChar);
            }
        
            cipherText += cipherChar;
        }
        
        
        if (getCts() != null) {
            getCts().send(cipherText);
        }
    }
    //<editor-fold defaultstate="collapsed" desc="Constructors">

    {
        rotors = new ArrayList<EnigmaTranspositionRotor>();
        this.setCts(new CipherTextSink());
        this.setPts(new PlainTextSource());
    }

    public EnigmaMachine() {
    }

    public EnigmaMachine(ArrayList<EnigmaTranspositionRotor> rotors) {
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
