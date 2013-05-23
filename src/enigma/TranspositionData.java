/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author kevin.lawrence
 */
public class TranspositionData {
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public TranspositionData(){ }
    
    public TranspositionData(char value, int internalConnection){
        this.value = value;
        this.internalConnection = internalConnection;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private char value;
    private int internalConnection;
    
    /**
     * @return the value
     */
    public char getValue() {
        return value;
    }
    
    /**
     * @param value the result to set
     */
    public void setValue(char value) {
        this.value = value;
    }
    
    /**
     * @return the internal connection, i.e. not corrected for the position of 
     * the rotor
     */
    public int getInternalConnection() {
        return internalConnection;
    }
    
    /**
     * @param connection the internal connection to set, i.e. the connection has
     * not been corrected for the position of the rotor
     */
    public void setInternalConnection(int internalConnection) {
        this.internalConnection = internalConnection;
    }
    //</editor-fold>
    
}
