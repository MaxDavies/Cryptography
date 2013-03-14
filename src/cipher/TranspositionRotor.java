/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

import java.util.HashMap;

/**
 *
 * @author kevin.lawrence
 */
public class TranspositionRotor implements Transposition {
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        this.setDirection(RotationDirection.FORWARD);
        this.setSteps(1);
        inputMap = new HashMap();
    }
    
    public TranspositionRotor(){ }
    
    public TranspositionRotor(RotationDirection direction, int steps){
        this.direction = direction;
        this.steps = steps;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    /*
     * Rotate the rotor in the direction define by the Direction property 
     * (RotationDirection.FORWARD will increment the rotor position positively, 
     * while RotationDirection.BACKWARD will decrement the the rotor position in
     * the negative direction) and to the number of steps defined by the Steps 
     * property.
     */
    public void rotate(){
        rotate(getDirection(), getSteps());
    }
    
    /*
     * Rotate the rotor in the direction define by the Direction property 
     * (RotationDirection.FORWARD will increment the rotor position positively, 
     * while RotationDirection.BACKWARD will decrement the the rotor position in
     * the negative direction) and to the number of steps defined by the Steps 
     * property.
     * @param direction the direction to rotate the rotor
     * @param steps the number of steps to rotate the rotor
     */
    public void rotate(RotationDirection direction, int steps){
        for (int i = 0; i < steps; i++) {
            setPosition( direction == RotationDirection.FORWARD ? position++ : position--);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private RotationDirection direction;
    private int steps;
    private int position;
    private boolean reflector;
    private HashMap inputMap, outputMap;
    
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

    //<editor-fold defaultstate="collapsed" desc="Transposition Interface">
    public char getOutput(char input) {
        return (Character) inputMap.get(input);
    }
    
    public char getInput(char output) {
        return (Character) outputMap.get(output);
    }
    
    public void setTranspositionMaps(char[] inputs, char[] outputs) {
        inputMap.clear();
        outputMap.clear();
        
        for (int i = 0; i < inputs.length; i++) {
            inputMap.put(inputs[i], outputs[i]);
            outputMap.put(outputs[i], inputs[i]);  
        }
    }
    //</editor-fold>

}
