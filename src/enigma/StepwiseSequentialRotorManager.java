/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import cryptography.CipherOperation;
import static cryptography.CipherOperation.ENCIPHER;
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
        if (this.rotors != null) {
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
     * Note that the only validation that is performed is that the index is
     * constrained to a valid valid from 0 (first RotationRotor) to the last
     * RotationRotor
     */
    public int setCurrentRotationRotorIndex(int currentRotationRotorIndex) {
        if (currentRotationRotorIndex < FIRST_ROTATION_ROTOR_INDEX) {
            this.currentRotationRotorIndex = FIRST_ROTATION_ROTOR_INDEX;
        } else if (currentRotationRotorIndex >= this.rotors.size()) {
            this.currentRotationRotorIndex = this.rotors.size() - 1;
        } else {
            this.currentRotationRotorIndex = currentRotationRotorIndex;
        }
        return this.currentRotationRotorIndex;
    }
    private final int FIRST_ROTATION_ROTOR_INDEX = 0;

    /**
     * move to the next rotor in the set; if we reach past the last rotor,
     * return to the first rotor
     */
    public int incrementCurrentRotationRotorIndex() {
        int rotationRotorIndex = currentRotationRotorIndex + 1;

//      if we are beyond the last rotor - reset to the first rotor
        if (rotationRotorIndex >= this.rotors.size()) {
            rotationRotorIndex = FIRST_ROTATION_ROTOR_INDEX;
        }
        
        return setCurrentRotationRotorIndex(rotationRotorIndex);
    }

    /**
     * move to the next rotor in the set; if we reach past the last rotor,
     * return to the first rotor
     */
    public int decrementCurrentRotationRotorIndex() {
        int rotationRotorIndex = currentRotationRotorIndex - 1;

//      if we are beyond the first rotor - reset to the last rotor
        if (rotationRotorIndex < FIRST_ROTATION_ROTOR_INDEX) {
            rotationRotorIndex = this.rotors.size() - 1;
        } 
        
        return setCurrentRotationRotorIndex(rotationRotorIndex);
    }
    private static final int ROTOR_INCREMENT_POSITION = 0;
    private static final int ROTATION_STEP_SIZE = 1;

    /**
     * increment the rotation position of the current rotor; if the rotor has
     * done a complete "turn" - indicated by the rotor position returning to the
     * ROTOR_INCREMENT_POSITION - then move on to the next rotor
     */
    public void incrementCurrentRotorPosition() {
        TranspositionRotor rotor = getCurrentTranspositionRotor();
        if (rotor != null) {
            rotor.rotate();
            if (rotor.getPosition() == ROTOR_INCREMENT_POSITION) {
                incrementCurrentRotationRotorIndex();
            }
        }
    }

    /**
     * increment the rotation position of the current rotor; if the rotor has
     * done a complete "turn" - indicated by the rotor position returning to the
     * ROTOR_INCREMENT_POSITION - then move on to the next rotor
     */
    private void decrementCurrentRotorPosition() {
        TranspositionRotor rotor = getCurrentTranspositionRotor();
        if (rotor != null) {
            rotor.rotate(RotationDirection.BACKWARD, ROTATION_STEP_SIZE);
            if (rotor.getPosition() == ROTOR_INCREMENT_POSITION) {
                decrementCurrentRotationRotorIndex();
            }
        }
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Event Methods">
    public void beforeProcessCharacter() {
        //do nothing...
    }

    public void afterProcessCharacter() {
        if (this.operation == CipherOperation.ENCIPHER) {
            incrementCurrentRotorPosition();
        } else {
            decrementCurrentRotorPosition();
        }
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Rotor State Methods">
    public boolean resetRotors() {
        if (this.rotors != null) {
            for (TranspositionRotor rotor : rotors) {
                rotor.setPosition(ROTOR_START_POSITION);
            }
            return true;
        }
        return false;
    }

    public boolean setRotorState(int[] rotorPositions) {
        if (this.rotors != null) {
            for (int i = 0; i < rotorPositions.length; i++) {
                rotors.get(i).setPosition(rotorPositions[i]);
            }
            return true;
        }
        return false;
    }

    public boolean setRotorState(CipherOperation operation, int textLength) {
        if (this.rotors != null) {
            switch (operation) {
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

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public StepwiseSequentialRotorManager(ArrayList<TranspositionRotor> rotors) {
        this.rotors = rotors;
    }
    //</editor-fold>
}
