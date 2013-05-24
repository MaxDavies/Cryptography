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
            System.out.printf("  PT: %s (%d) XCNX: %d\n", cipherChar, i, externalConnection);
            
            
            
            int rotorNumber = 0;
            // "Inbound" transposition
            for (EnigmaTranspositionRotor rotor : rotors) {
                System.out.printf("  IN: Transposition Rotor #%d Type: %s Posn: %d\n", rotorNumber, rotor.getEnigmaRotor().getRotorType(), rotor.getPosition());
                System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
                System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
                rotorNumber++;
            }
            
            // "Outbound" transposition
            EnigmaTranspositionRotor rotor;
            for (rotorNumber--; rotorNumber >= 0 ; rotorNumber--) {
                rotor = rotors.get(rotorNumber);
                System.out.printf("  OUT: Transposition Rotor #%d Type: %s Posn: %d\n", rotorNumber, rotor.getEnigmaRotor().getRotorType(), rotor.getPosition());
                System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
                System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
            }
            
//            externalConnection = fixedInterfaceRotor.getExternalConnection( fixedInterfaceRotor.transposeCharacter(cipherChar, TranspositionDirection.OUTPUT).getInternalConnection());
            
            cipherChar= fixedInterfaceRotor.getCharacter(externalConnection);
            cipherText += cipherChar;
            System.out.println("CC = " + cipherChar);
            System.out.println("CT = " + cipherText);
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

    /**
     *
     */
    public EnigmaMachine() { }

    /**
     *
     * @param rotors
     */
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
