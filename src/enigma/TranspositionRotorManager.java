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
public interface TranspositionRotorManager {
    public void setTranspositionRotors(ArrayList<TranspositionRotor> rotors);
    public ArrayList<TranspositionRotor> getTranspositionRotors();

    public void setCipherOperation(CipherOperation operation);
    public CipherOperation getCipherOperation();
    
    public boolean resetRotors();
    public boolean setRotorState(int[] rotorPositions);
    public boolean setRotorState(CipherOperation operation, int textLength);

    public void beforeProcessCharacter();
    public void afterProcessCharacter();
}
