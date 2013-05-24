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
    
    //<editor-fold defaultstate="collapsed" desc="Source / Sink">
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
    //</editor-fold>

    public void encipher(String plainText) {
        String cipherText = "";
        char cipherChar;
        int externalConnection;
        String text = (plainText.replaceAll(" ", "")).toUpperCase();       
        
        System.out.println("Plain Text = \n" + plainText);
        
        for (int i = 0; i < plainText.length(); i++) {
            cipherChar = text.charAt(i);
            
            //get interface connection position
//            externalConnection = fixedInterfaceRotor.getExternalConnection( fixedInterfaceRotor.transposeCharacter(cipherChar, TranspositionDirection.INPUT).getInternalConnection());
            externalConnection = fixedInterfaceRotor.getExternalConnection(cipherChar);
            System.out.println("External Interface Rotor");
            System.out.printf("  POSN = %d PT = %s CNX = %d\n", i, cipherChar, externalConnection);
            
//            for (int input = 0; input < rotors.size(); input++) {
//                externalConnection = rotors.get(input).transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
//            }
//            
//            for (int output = rotors.size() - 1; output >= 0; output++) {
//                externalConnection = rotors.get(output).transposeToExternalConnection(externalConnection, TranspositionDirection.OUTPUT);
//            }
//            
//            externalConnection = fixedInterfaceRotor.getExternalConnection( fixedInterfaceRotor.transposeCharacter(cipherChar, TranspositionDirection.OUTPUT).getInternalConnection());
            
            
            cipherText += cipherChar;
            System.out.println("CT = " + cipherChar);
        }
        
        if (getCts() != null) {
            getCts().send(cipherText);
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">

    {
        rotors = new ArrayList<EnigmaTranspositionRotor>();
        fixedInterfaceRotor = InterfaceRotor.getEnigmaInterfaceRotor();
        
        this.setCts(new CipherTextSink());
        this.setPts(new PlainTextSource());
    }

    public EnigmaMachine() { }

    public EnigmaMachine(ArrayList<EnigmaTranspositionRotor> rotors) {
        this.rotors = rotors;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<EnigmaTranspositionRotor> rotors;
    private InterfaceRotor fixedInterfaceRotor;
    

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
     * @return the CipherTextSink
     */
    public CipherTextSink getCts() {
        return cts;
    }

    /**
     * @param cts the CipherTextSink to set
     */
    public void setCts(CipherTextSink cts) {
        this.cts = cts;
    }

    /**
     * @return the PlainTextSource
     */
    public PlainTextSource getPts() {
        return pts;
    }

    /**
     * @param pts the PlainTextSource to set
     */
    public void setPts(PlainTextSource pts) {
        this.pts = pts;
    }
    //</editor-fold>
}
