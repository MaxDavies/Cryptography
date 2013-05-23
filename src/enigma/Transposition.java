/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author kevin.lawrence
 */
public interface Transposition {
    public char getOutput(char input);
    public char getInput(char output);
    
    public int transposeToExternalConnection(int externalConnection, TranspositionDirection direction);
//    public TranspositionData transposeCharacter(Character value, TranspositionDirection direction);
//  TODO: Add back later if required
//    public TranspositionData transposeConnection(int connection, TranspositionDirection direction);
    
    public void setTranspositionMaps(char[] inputs, char[] outputs);
}
