package routecipher;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevinlawrence
 */
public class RouteCipherData {

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public RouteCipherData(char character){
        this.character = character;
    }
    
    public RouteCipherData(char character, boolean processed){
        this.character = character;
        this.processed = processed;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private char character;
    private boolean processed = false;

    /**
     * @return the character
     */
    public char getCharacter() {
        return character;
    }
    
    /**
     * @param character the character to set
     */
    public void setCharacter(char character) {
        this.character = character;
    }
    
    /**
     * @return the processed
     */
    public boolean isProcessed() {
        return processed;
    }
    
    /**
     * @param processed the processed to set
     */
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
    //</editor-fold>
}
