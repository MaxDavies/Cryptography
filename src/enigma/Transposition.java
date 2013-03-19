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
    
    public TranspositionData transposeConnection(int connection, TranspositionDirection direction);
    public TranspositionData transposeCharacter(Character value, TranspositionDirection direction);
//    public TranspositionData transpose(String value, TranspositionDirection direction);
    
    public void setTranspositionMaps(char[] inputs, char[] outputs);
}
