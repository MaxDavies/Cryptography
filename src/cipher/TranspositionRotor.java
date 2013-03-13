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
    public void rotate(){
        rotate(getDirection(), getSteps());
    }
    
    public void rotate(RotationDirection direction, int steps){
        
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private RotationDirection direction;
    private int steps;
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
