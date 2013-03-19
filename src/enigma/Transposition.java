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
    
    public TranspositionData transpose(int connection, TranspositionDirection direction);
    public TranspositionData transpose(String value, TranspositionDirection direction);
    
    public void setTranspositionMaps(char[] inputs, char[] outputs);
}
