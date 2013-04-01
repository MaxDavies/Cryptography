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
    
//    <editor-fold defaultstate="collapsed" desc="Common Transposition Maps">
    public static final char[] INPUT_BASE_ALPHANUMERIC = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    public static final char[] INPUT_BASE_ALPHA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] INPUT_BASE_NUMERIC = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static final char[] TEST_BASE_ALPHA = {'D', 'M', 'T', 'W', 'S', 'I', 'L', 'R', 'U', 'Y', 'Q', 'N', 'K', 'F', 'E', 'J', 'C', 'A', 'Z', 'B', 'P', 'G', 'X', 'O', 'H', 'V'};
    
//    </editor-fold>
    
//    <editor-fold defaultstate="collapsed" desc="Methods">
    
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
            setPosition( direction == RotationDirection.FORWARD ? ++position : --position);
        }
        return this.position;
    } 
//    </editor-fold>
        
//    <editor-fold defaultstate="collapsed" desc="Transposition Interface">
    
    /*
     *  1) Entry "signal" into rotor will be at a "machine level connection":
     *     think of this as an "absolute" position with respect to the machine, 
     *     i.e. position "0' will always be the "top" or "first" postion for all
     *     rotors.
     * 
     *     The "input" rotor will never move, with respect to its connections,
     *     so we will always assume that there is no positional change. 
     *     For example, if we are using a "pure" alphabetic transposition, such
     *     as the INPUT_BASE_ALPHANUMERIC transposition map, if the input is 'A'
     *     then the input connector will be '0', if 'B', then '1'.
     *     
     *  2) For each transposition rotor, the input connection value will be on
     *     the "external" position, and will therefore, for the purposes of 
     *     transposition to the next rotor, need to be adjusted based on the 
     *     rotors position. Note that the interpretaton of the "position" is 
     *     that incrementing the position will move the transposition map 
     *     elements forward one "external" position, as shown below:
     * 
     *                               Internal
     *                                   External 
     *     Rotor position = 0    A   0   0
     *                           B   1   1
     *                           C   2   2
     *                           ...
     *                           Z  25  25
     *                           
     *     Rotor position = 1    Z  25   0   
     *                           A   0   1
     *                           B   1   2
     *                           ...
     *                           Y  24  25
     * 
     *     Rotor position = 2    Y  24   0
     *                           Z  25   1
     *                           A   0   2
     *                           ...
     *                           X  23  25
     *                           
     *     This means that when the input "absolute" connection is provided, it 
     *     must be corrected by the position, as follows:
     *        Connection(internal) = Connection(absolute) - position
     * 
     *     And, this, of course, means that the result must be corrected to make 
     *     sure that the corrected value stays within the internal structure.
     *     
     *  3) When we have the internal (corrected) index, get the related input 
     *     value, compute the related transposition value. We then get its index
     *     and correct it for position in order to get the external (absolute)
     *     connection to the next rotor.
     *     And, so on...
     * 
     * 
     */
    
    
    /**
     * @return the internal connection corrected for the position (rotation) of 
     * the rotor.
     * 
     * @param externalConnection this is the connection to the rotor as seen  
     * externally, i.e. by the transposition machine. External connection points
     * are effectively "constant", and identical across all rotors: they are the 
     * connection between rotors. They are "constant" in that the interface
     * points between rotors do not change when any of the rotors rotate:
     * connection "0" will always be at the top/first position of the machine.
     * 
     * This "externalConnection" must be corrected/adjusted for the position 
     * (rotation) of the rotor, in order to figure out which "input" character
     * will be used to compute a transposition to the "output" character. From
     * this "internal output" character, we can derive an internal output 
     * connection; in order to connect to the next transposition rotor, the
     * internal value is again corrected to an external value using the 
     * getExternalConnection method.
     */
    public int getInternalConnection(int externalConnection){
        return ((externalConnection - position) + this.inputValues.size()) % this.inputValues.size();
    }
    
    /**
     * @return the external connection corrected for the position (rotation) of 
     * the rotor.
     * 
     * @param internalConnection this is the connection from the rotor as seen  
     * internally. In order to connect to the next transposition rotor, the
     * internal value are corrected to an external value.
     */
    public int getExternalConnection(int internalConnection){
        return (internalConnection + position) % inputValues.size();
    }
    
    
    public int transpose(int externalConnection, TranspositionDirection direction) {
        int internalInputConnection, internalOutputConnection;
        
        //correct absolute connection for current position
        internalInputConnection = getInternalConnection(externalConnection);
        
       /*
        *  We know the connection index, so get the "transposition" char from
        *  the output values, and then use that character to get the outbound
        *  connection (unadjusted) from the index of the transposition char 
        *  in the input index.
        * 
        */
        if (direction == TranspositionDirection.INPUT){
            /*  Since have [1] internal input connection (points to the position
             *  of the input transposition character), the associated output
             *  character [2] will be located in the outputValues structure in
             *  the same position.
             *  In order to get the internal output connection [3], we go back
             *  to the inputValues structure, and find the position of the 
             *  output character.  If we did not do this, i.e. if we relied on
             *  the position of the output character in the outputValues 
             *  strucutre, we would essentially get a direct (no connection
             *  position change) for every transposition, as the input value and 
             *  output (transposed) values are located in hte same position in 
             *  the inputValues and outputValues data structures.
             */
            
//                                                         [2] transposition character (output) 
//                                                                          [1] input connection
            internalOutputConnection = inputValues.indexOf(outputValues.get(internalInputConnection));
        } else {
            char f = outputValues.get(internalInputConnection);
            internalOutputConnection = inputValues.indexOf(inputValues.get(internalInputConnection));
        }
        
        // correct the result for the position
        return getExternalConnection(internalOutputConnection);
    }

    public TranspositionData transposeConnection(int connection, TranspositionDirection direction) {
        char connectionChar;
        System.out.println("Here");
        if (direction == TranspositionDirection.INPUT){
            connectionChar = this.inputValues.get( (connection - position) % this.inputValues.size());
        } else {
            connectionChar = this.inputValues.get( (connection - position) % this.inputValues.size());
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
//    </editor-fold>
    
//    <editor-fold defaultstate="collapsed" desc="Constructors">
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
//    </editor-fold>
 
//    <editor-fold defaultstate="collapsed" desc="Properties">
    private RotationDirection direction;
    private int steps;
    private int position;
    private boolean reflector;
    private HashMap inputMap, outputMap;
    private ArrayList<Character> inputValues, outputValues;
    
    /**
     * @return the size of the rotor
     */
    public int getSize() {
        if (this.inputMap != null){
            return inputMap.size();
        } else {
            return 0;
        }
    }
    
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
//            this.position = ((inputMap.size() + position) % inputMap.size());
            while (position < 0){
                position += inputMap.size();
            }
            this.position = position % inputMap.size();
        }        
    }
//    </editor-fold>

}
