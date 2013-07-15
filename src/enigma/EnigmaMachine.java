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
    public class TextSink {     
        public void send(String text) {
            System.out.printf("Output = %s\n", text);
        }
    }
    
    public class TextSource {      
        public void receive(String text) {
            System.out.printf("Input = %s", text);
        }
    }
    //</editor-fold>

    public String encipher(String plainText) {
        String cipherText = "";
        char cipherChar;
        int externalConnection;
        String text = (plainText.replaceAll(" ", "")).toUpperCase();       
        
        System.out.println("Plain Text = \n" + plainText);
        
        for (int i = 0; i < text.length(); i++) {
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
//                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
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
        return cipherText;
    }
    
    public String decipher(String cipherText) {
        String plaintText = "";
        char plainChar;
        int externalConnection;
        String text = (cipherText.replaceAll(" ", "")).toUpperCase();       
        System.out.println("-------------------------------------------------");
        System.out.println("Cipher Text = \n" + cipherText);
        
//        for (int i = 0; i < cipherText.length(); i++) {
        for (int i = 0; i < text.length(); i++) {
            plainChar = text.charAt(i);
            
            //get interface connection position
            externalConnection = fixedInterfaceRotor.getExternalConnection(plainChar);
            System.out.println("External Interface Rotor");
            System.out.printf("  CT: %s (%d) XCNX: %d\n", plainChar, i, externalConnection);
            
            int rotorNumber = 0;
            // "Inbound" transposition
            for (EnigmaTranspositionRotor rotor : rotors) {
                System.out.printf("  IN: Transposition Rotor #%d Type: %s Posn: %d\n", rotorNumber, rotor.getEnigmaRotor().getRotorType(), rotor.getPosition());
                System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.OUTPUT);
                System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
                rotorNumber++;
            }
            
            // "Outbound" transposition
            EnigmaTranspositionRotor rotor;
            for (rotorNumber--; rotorNumber >= 0 ; rotorNumber--) {
                rotor = rotors.get(rotorNumber);
                System.out.printf("  OUT: Transposition Rotor #%d Type: %s Posn: %d\n", rotorNumber, rotor.getEnigmaRotor().getRotorType(), rotor.getPosition());
                System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.OUTPUT);
                System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
            }
            
            plainChar= fixedInterfaceRotor.getCharacter(externalConnection);
            plaintText += plainChar;
            System.out.println("PC = " + plainChar);
            System.out.println("PT = " + plaintText);
        }
        
        if (getCts() != null) {
            getCts().send(plaintText);
        }
        
        return plaintText;
    }  
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        rotors = new ArrayList<EnigmaTranspositionRotor>();
        fixedInterfaceRotor = InterfaceRotor.getEnigmaInterfaceRotor();
        
        this.setCts(new TextSink());
        this.setPts(new TextSource());
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
    private TextSink cts;
    private TextSource pts;
    private TranspositionRotorManager rotorManager;
    
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
//        if (this.rotorManager != null){
//            this.rotorManager.setTranspositionRotors(this.rotors);
//        }
    }

    /**
     * @param rotor the rotors to set
     */
    public void addRotor(EnigmaTranspositionRotor rotor) {
        this.rotors.add(rotor);
    }
    
        /**
     * @return the rotorManager
     */
    public TranspositionRotorManager getRotorManager() {
        return rotorManager;
    }

    /**
     * @param rotorManager the rotorManager to set
     */
    public void setRotorManager(TranspositionRotorManager rotorManager) {
        this.rotorManager = rotorManager;
    }
    
    /**
     * @return the TextSink
     */
    public TextSink getCts() {
        return cts;
    }

    /**
     * @param cts the TextSink to set
     */
    public void setCts(TextSink cts) {
        this.cts = cts;
    }

    /**
     * @return the TextSource
     */
    public TextSource getPts() {
        return pts;
    }

    /**
     * @param pts the TextSource to set
     */
    public void setPts(TextSource pts) {
        this.pts = pts;
    }
    //</editor-fold>
}
