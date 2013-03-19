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
    
    public TranspositionData(char value, int connection){
        this.value = value;
        this.connection = connection;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private char value;
    private int connection;
    
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
     * @return the connection
     */
    public int getConnection() {
        return connection;
    }
    
    /**
     * @param connection the connection to set
     */
    public void setConnection(int connection) {
        this.connection = connection;
    }
    //</editor-fold>
    
}
