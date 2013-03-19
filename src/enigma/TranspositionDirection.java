/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author kevin.lawrence
 */
public enum TranspositionDirection {
    INPUT("right to left"), OUTPUT("left to right");

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    private TranspositionDirection(String description) {
        this.description = description;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String description;
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    //</editor-fold>
}
