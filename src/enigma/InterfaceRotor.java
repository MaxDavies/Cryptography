/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.ArrayList;

/**
 *
 * @author kevin.lawrence
 */
public class InterfaceRotor {
    
//    TODO - Consider allowing rotation
//    TODO - Consider if this functionality can/should be integrated into the
//           TranspositionRotor
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public int getExternalConnection(Character value){
        return values.indexOf(value);
    }
    
    public Character getCharacter(int externalConnection){
        return values.get(externalConnection);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        this.values = new ArrayList<Character>();
    }
    
    public InterfaceRotor(char[] values){
        for (int i = 0; i < values.length; i++) {
            this.values.add(values[i]);
        }
    }
    
    public static InterfaceRotor getEnigmaInterfaceRotor(){
        return new InterfaceRotor(EnigmaTranspositionRotor.INPUT_BASE);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private ArrayList<Character> values;
    
    /**
     * @return the values
     */
    public ArrayList<Character> getValues() {
        return values;
    }
    
    /**
     * @param values the values to set
     */
    public void setValues(ArrayList<Character> values) {
        this.values = values;
    }
    //</editor-fold>
}
