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
public class StepwiseSequentialRotorManager implements TranspositionRotorManager {
    public static final int ROTOR_START_POSITION = 0;

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<TranspositionRotor> rotors;
    private CipherOperation operation = CipherOperation.ENCIPHER;
    private int currentRotationRotorIndex = 0;
    
    public void setTranspositionRotors(ArrayList<TranspositionRotor> rotors) {
        this.rotors = rotors;
    }
    
    public ArrayList<TranspositionRotor> getTranspositionRotors() {
        return this.rotors;
    }
    
    public void setCipherOperation(CipherOperation operation) {
        this.operation = operation;
    }
    
    public CipherOperation getCipherOperation() {
        return this.operation;
    }

    /**
     * @return the currentTranspositionRotor
     */
    public TranspositionRotor getCurrentTranspositionRotor() {
        if (this.rotors != null){
            return rotors.get(currentRotationRotorIndex);
        }
        return null;
    }

    /**
     * @return the currentRotationRotorIndex
     */
    public int getCurrentRotationRotorIndex() {
        return currentRotationRotorIndex;
    }

    /**
     * @param currentRotationRotorIndex the currentRotationRotorIndex to set
     */
    public void setCurrentRotationRotorIndex(int currentRotationRotorIndex) {
        if (currentRotationRotorIndex < 0){
            this.currentRotationRotorIndex = currentRotationRotorIndex;
        } else if (currentRotationRotorIndex >= this.rotors.size()){
            this.currentRotationRotorIndex = this.rotors.size() - 1;
        } else {
            this.currentRotationRotorIndex = currentRotationRotorIndex;
        }
    }
    
    /**
     * @param currentRotationRotorIndex the currentRotationRotorIndex to set
     */
    public int incrementCurrentRotationRotorIndex() {
        return currentRotationRotorIndex = ++currentRotationRotorIndex % rotors.size();
    }
    
    //</editor-fold>
    
    public StepwiseSequentialRotorManager(ArrayList<TranspositionRotor> rotors){
        this.rotors = rotors;
    }

    //<editor-fold defaultstate="collapsed" desc="Rotor State Methods">
    public boolean resetRotors() {
        if (this.rotors != null){
            for(TranspositionRotor rotor : rotors){
                rotor.setPosition(ROTOR_START_POSITION);
            }
            return true;
        }
        return false;
    }
    
    public boolean setRotorState(int[] rotorPositions) {
        if (this.rotors != null){
            for (int i = 0; i < rotorPositions.length; i++) {
                rotors.get(i).setPosition(rotorPositions[i]);
            }
            return true;
        }
        return false;
    }
    
    public boolean setRotorState(CipherOperation operation, int textLength) {
        if (this.rotors != null){
            switch (operation){
                case DECIPHER:
                    //TODO custom logic to calculate rotor position for deciphering  
                    break;
                case ENCIPHER: 
                default:
                    resetRotors();
            }
            return true;
        }
        return false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Event Methods">
    public void beforeProcessCharacter() {
        //do nothing...
    }
    
    public void afterProcessCharacter() {
        //TODO: implement rotation logic
        
    }
    //</editor-fold>

}
