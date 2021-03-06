/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import cryptography.CipherOperation;
import java.util.ArrayList;

/**
 *
 * @author kevin.lawrence
 */
public class TranspositionCipherMachine {

//    <editor-fold defaultstate="collapsed" desc="Encipher and Decipher Methods">
    public String encipher(String plainText) {
        if (verbose){
            return verboseEncipher(plainText);
        }
        
        String cipherText = "";
        int externalConnection;

        for (int i = 0; i < plainText.length(); i++) {

            if (rotorManager != null) {
                rotorManager.beforeProcessCharacter();
            }

            //get interface connection position
            externalConnection = fixedInterfaceRotor.getExternalConnection(plainText.charAt(i));

            int rotorNumber = 0;
            // "Inbound" transposition
            for (TranspositionRotor rotor : rotors) {
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
                rotorNumber++;
            }

            // "Outbound" transposition
            for (rotorNumber--; rotorNumber >= 0; rotorNumber--) {
                externalConnection = rotors.get(rotorNumber).transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
            }

            cipherText += fixedInterfaceRotor.getCharacter(externalConnection);

            if (rotorManager != null) {
                rotorManager.afterProcessCharacter();
            }
        }

        if (getCts() != null) {
            getCts().send(cipherText);
        }

        return cipherText;
    }

    public String decipher(String cipherText) {
        if (verbose){
            return verboseDecipher(cipherText);
        }
        
        String plainText = "";
        int externalConnection;

        //set up rotor
        if (rotorManager != null) {
            rotorManager.resetRotors();
            rotorManager.setCipherOperation(CipherOperation.DECIPHER);
        }

        for (int i = 0; i < cipherText.length(); i++) {

            if (rotorManager != null) {
                rotorManager.beforeProcessCharacter();
            }

            //get interface connection position
            externalConnection = fixedInterfaceRotor.getExternalConnection(cipherText.charAt(i));

            int rotorNumber = 0;
            // "Inbound" transposition
            for (TranspositionRotor rotor : rotors) {
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.OUTPUT);
                rotorNumber++;
            }

            // "Outbound" transposition
            for (rotorNumber--; rotorNumber >= 0; rotorNumber--) {
                externalConnection = rotors.get(rotorNumber).transposeToExternalConnection(externalConnection, TranspositionDirection.OUTPUT);
            }

            plainText += fixedInterfaceRotor.getCharacter(externalConnection);

            if (rotorManager != null) {
                rotorManager.afterProcessCharacter();
            }
        }

        if (getCts() != null) {
            getCts().send(plainText);
        }

        return plainText;
    }

    public String verboseEncipher(String plainText) {
        String cipherText = "";
        char cipherChar;
        int externalConnection;
        String text = plainText;

        if (verbose) {
            System.out.println("Plain Text = \n" + plainText);
        }

        for (int i = 0; i < text.length(); i++) {
            cipherChar = text.charAt(i);

            if (rotorManager != null) {
                rotorManager.beforeProcessCharacter();
            }

            //get interface connection position
            externalConnection = fixedInterfaceRotor.getExternalConnection(cipherChar);

            if (verbose) {
                System.out.println("External Interface Rotor");
                System.out.printf("  PT: %s (%d) XCNX: %d\n", cipherChar, i, externalConnection);
            }
            
            int rotorNumber = 0;
            // "Inbound" transposition
            for (TranspositionRotor rotor : rotors) {
                if (verbose) {
                    System.out.printf("  IN: Transposition Rotor #%d Posn: %d\n", rotorNumber, rotor.getPosition());
                    System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                }
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
                if (verbose) {
                    System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
                }
                rotorNumber++;
            }

            // "Outbound" transposition
            TranspositionRotor rotor;
            for (rotorNumber--; rotorNumber >= 0; rotorNumber--) {
                rotor = rotors.get(rotorNumber);
                if (verbose) {
                    System.out.printf("  OUT: Transposition Rotor #%d Posn: %d\n", rotorNumber, rotor.getPosition());
                    System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                }
                
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.INPUT);
                
                if (verbose) {
                    System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
                }
            }

            //            externalConnection = fixedInterfaceRotor.getExternalConnection( fixedInterfaceRotor.transposeCharacter(cipherChar, TranspositionDirection.OUTPUT).getInternalConnection());

            cipherChar = fixedInterfaceRotor.getCharacter(externalConnection);
            cipherText += cipherChar;
            
            if (verbose) {
                System.out.println("CC = " + cipherChar);
                System.out.println("CT = " + cipherText);
            }

            if (rotorManager != null) {
                rotorManager.afterProcessCharacter();
            }
        }

        if (getCts() != null) {
            getCts().send(cipherText);
        }
        return cipherText;
    }    
    
    public String verboseDecipher(String cipherText) {
        String plainText = "";
        char plainChar;
        int externalConnection;

        if (verbose) {
            System.out.println("-------------------------------------------------");
            System.out.println("Cipher Text = \n" + cipherText);
        }

//      set up rotor
        if (rotorManager != null) {
            rotorManager.resetRotors();
            rotorManager.setCipherOperation(CipherOperation.DECIPHER);
        }

        for (int i = 0; i < cipherText.length(); i++) {
            plainChar = cipherText.charAt(i);

            if (rotorManager != null) {
                rotorManager.beforeProcessCharacter();
            }

            //get interface connection position
            externalConnection = fixedInterfaceRotor.getExternalConnection(plainChar);
            if (verbose) {
                System.out.println("External Interface Rotor");
                System.out.printf("  CT: %s (%d) XCNX: %d\n", plainChar, i, externalConnection);
            }

            int rotorNumber = 0;
            // "Inbound" transposition
            for (TranspositionRotor rotor : rotors) {
                if (verbose) {
                    System.out.printf("  IN: Transposition Rotor #%d Posn: %d\n", rotorNumber, rotor.getPosition());
                    System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                }
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.OUTPUT);
                if (verbose) {
                    System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
                }
                rotorNumber++;
            }

            // "Outbound" transposition
            TranspositionRotor rotor;
            for (rotorNumber--; rotorNumber >= 0; rotorNumber--) {
                rotor = rotors.get(rotorNumber);
                if (verbose) {
                    System.out.printf("  OUT: Transposition Rotor #%d Posn: %d\n", rotorNumber, rotor.getPosition());
                    System.out.printf("    XCNX_IN: %d  \n", externalConnection);
                }
                externalConnection = rotor.transposeToExternalConnection(externalConnection, TranspositionDirection.OUTPUT);
                if (verbose) {
                    System.out.printf("    XCNX_OUT: %d \n\n", externalConnection);
                }
            }

            plainChar = fixedInterfaceRotor.getCharacter(externalConnection);
            plainText += plainChar;

            if (verbose) {
                System.out.println("PC = " + plainChar);
                System.out.println("PT = " + plainText);
            }

            if (rotorManager != null) {
                rotorManager.afterProcessCharacter();
            }
        }

        if (getCts() != null) {
            getCts().send(plainText);
        }

        return plainText;
    }
    
//    </editor-fold>
    
//    <editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<TranspositionRotor> rotors;
    private TranspositionRotorManager rotorManager;
    private InterfaceRotor fixedInterfaceRotor;
    private TextSink cts;
    private TextSource pts;
    private boolean verbose = false;

    /**
     * @return the rotors
     */
    public ArrayList<TranspositionRotor> getRotors() {
        return rotors;
    }

    /**
     * @param rotors the rotors to set
     */
    public void setRotors(ArrayList<TranspositionRotor> rotors) {
        this.rotors = rotors;
        connectRotorManager();
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
        connectRotorManager();
    }

    /**
     * make sure the rotorManager is properly configured with the rotors;
     */
    private void connectRotorManager() {
        if ((rotors != null) && (rotorManager != null)) {
            rotorManager.setTranspositionRotors(this.rotors);
        }
    }

    /**
     * @return the fixedInterfaceRotor
     */
    public InterfaceRotor getFixedInterfaceRotor() {
        return fixedInterfaceRotor;
    }

    /**
     * @param fixedInterfaceRotor the fixedInterfaceRotor to set
     */
    public void setFixedInterfaceRotor(InterfaceRotor fixedInterfaceRotor) {
        this.fixedInterfaceRotor = fixedInterfaceRotor;
    }

    /**
     * @return the cts
     */
    public TextSink getCts() {
        return cts;
    }

    /**
     * @param cts the cts to set
     */
    public void setCts(TextSink cts) {
        this.cts = cts;
    }

    /**
     * @return the pts
     */
    public TextSource getPts() {
        return pts;
    }

    /**
     * @param pts the pts to set
     */
    public void setPts(TextSource pts) {
        this.pts = pts;
    }

    /**
     * @return the verbose
     */
    public boolean isVerbose() {
        return verbose;
    }

    /**
     * @param verbose the verbose to set
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }
//    </editor-fold>

//        <editor-fold defaultstate="collapsed" desc="Source / Sink">
    public class TextSink {

        public void send(String text) {
            if (verbose) {
                System.out.printf("Output = %s\n", text);
            }
        }
    }

    public class TextSource {

        public void receive(String text) {
            if (verbose) {
                System.out.printf("Input = %s", text);
            }
        }
    }
//    </editor-fold>

//    <editor-fold defaultstate="collapsed" desc="Constructors">
    {
        rotors = new ArrayList<TranspositionRotor>();
        fixedInterfaceRotor = InterfaceRotor.getEnigmaInterfaceRotor();

        this.setCts(new TextSink());
        this.setPts(new TextSource());
    }

    /**
     *
     */
    public TranspositionCipherMachine() {
    }

    /**
     *
     * @param rotors
     */
//    public TranspositionCipherMachine(TranspositionRotorManager rotorManager, ArrayList<TranspositionRotor> rotors) {
    public TranspositionCipherMachine(TranspositionRotorManager rotorManager, InterfaceRotor fixedInterfaceRotor, ArrayList<TranspositionRotor> rotors) {
        this.fixedInterfaceRotor = fixedInterfaceRotor;
        this.rotorManager = rotorManager;
        this.rotors = rotors;
        connectRotorManager();
    }
//    </editor-fold>
}
