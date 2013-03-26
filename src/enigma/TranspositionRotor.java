/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kevin.lawrence
 */
public class TranspositionRotor implements Transposition {
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    
//    TODO: Consider defining as interface or abstract class, so that the 
//    rotation funcitonality can be injected (inversion of control)
    
    /*
     * Rotate the rotor in the direction define by the Direction property 
     * (RotationDirection.FORWARD will increment the rotor position positively, 
     * while RotationDirection.BACKWARD will decrement the the rotor position in
     * the negative direction) and to the number of steps defined by the Steps 
     * property.
     *
     * @return the position of the rotor, after the rotation has been applied.
     */
    public int rotate(){
        return rotate(getDirection(), getSteps());
    }
    
    /*
     * Rotate the rotor in the direction define by the Direction property 
     * (RotationDirection.FORWARD will increment the rotor position positively, 
     * while RotationDirection.BACKWARD will decrement the the rotor position in
     * the negative direction) and to the number of steps defined by the Steps 
     * property.
     * @param direction the direction to rotate the rotor
     * @param steps the number of steps to rotate the rotor
     * @return the position of the rotor, after the rotation has been applied.
     */
    public int rotate(RotationDirection direction, int steps){
        for (int i = 0; i < steps; i++) {
            setPosition( direction == RotationDirection.FORWARD ? position++ : position--);
        }
        return this.position;
    }
    
    //</editor-fold>
        
    //<editor-fold defaultstate="collapsed" desc="Transposition Interface">
    public TranspositionData transposeConnection(int connection, TranspositionDirection direction) {
        char connectionChar;
        System.out.println("Here");
        if (direction == TranspositionDirection.INPUT){
            connectionChar = this.inputValues.get( (position + connection) % this.inputValues.size());
        } else {
            connectionChar = this.inputValues.get( (position + connection) % this.inputValues.size());
        }
        
        return transposeCharacter(connectionChar, direction);
    }

    public TranspositionData transposeCharacter(Character value, TranspositionDirection direction) {
        char result;
        int connector; 
    
        if (direction == TranspositionDirection.INPUT){
            result = (Character)inputMap.get(value);
//            System.out.printf("Transpose %s = [%s], position [%d]\n", value, result, position);
            connector = (this.inputValues.indexOf(value) + position) % this.inputValues.size();
            
        } else {
            result = (Character)outputMap.get(value);
            connector = (this.outputValues.indexOf(value) + position) % this.outputValues.size();
        }
        
        return new TranspositionData(result, connector);
    }

    public char getOutput(char input) {
        try {
            return (Character) inputMap.get(input);
        } catch (java.lang.IndexOutOfBoundsException e){
            return 'A';
        }
    }
    
    public char getInput(char output) {
        try {
            return (Character) outputMap.get(output);
        } catch (java.lang.IndexOutOfBoundsException e){
            return 'Z';
        }
    }
    
    public void setTranspositionMaps(char[] inputs, char[] outputs) {
        inputMap.clear();
        outputMap.clear();
        inputValues.clear();
        outputValues.clear();
        
        for (int i = 0; i < inputs.length; i++) {
            inputMap.put(inputs[i], outputs[i]);
            outputMap.put(outputs[i], inputs[i]);
            
            inputValues.add(inputs[i]);
            outputValues.add(outputs[i]);
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        this.setDirection(RotationDirection.FORWARD);
        this.setSteps(1);
        
        inputMap = new HashMap();
        outputMap = new HashMap();
        inputValues = new ArrayList<Character>();
        outputValues = new ArrayList<Character>();
    }
    
    public TranspositionRotor(){ }
    
    public TranspositionRotor(RotationDirection direction, int steps){
        this.direction = direction;
        this.steps = steps;
    }
    //</editor-fold>
 
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private RotationDirection direction;
    private int steps;
    private int position;
    private boolean reflector;
    private HashMap inputMap, outputMap;
    private ArrayList<Character> inputValues, outputValues;
    
    /**
     * @return the direction
     */
    public RotationDirection getDirection() {
        return direction;
    }
    
    /**
     * @param direction the direction to set
     */
    public void setDirection(RotationDirection direction) {
        this.direction = direction;
    }
    
    /**
     * @return the steps
     */
    public int getSteps() {
        return steps;
    }
    
    /**
     * @param steps the steps to set
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }
    /**
     * @return the reflector
     */
    public boolean isReflector() {
        return reflector;
    }

    /**
     * @param reflector the reflector to set
     */
    public void setReflector(boolean reflector) {
        this.reflector = reflector;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        if (position >= 0){
            this.position = position % inputMap.size();
        } else {
            this.position = inputMap.size() - (position % inputMap.size());
        }        
    }
    //</editor-fold>

}