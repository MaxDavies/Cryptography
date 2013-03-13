/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 *
 * @author kevin.lawrence
 */
public interface Transposition {
    public char getOutput(char input);
    public char getInput(char output);
    
    public void setTranspositionMaps(char[] inputs, char[] outputs);
}
