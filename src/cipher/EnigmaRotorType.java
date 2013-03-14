/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 *
 * @author kevin.lawrence
 */
public enum EnigmaRotorType {
    COMMERCIAL("Commercial Enigma A, B"), ROCKET("German Railway [Rocket]"), SWISS_K("Swiss K"), ENIGMA_1("Enigma 1"), M3_ARMY("M3 Army"), M3_M4_NAVAL("M3 & M4 Naval"), M4_R2("M4 R2"), M4_R1("M4 R1"), NONE("");
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    private EnigmaRotorType(String model, boolean reflector) {
        this.model = model;
        this.reflector = reflector;
    }
    
    private EnigmaRotorType(String model) {
        this.model = model;
        this.reflector = false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String model = "";
    private boolean reflector;
    
    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }
    
    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
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
    //</editor-fold>
    
}
