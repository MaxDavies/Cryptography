/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cipher;

/**
 *
 * @author kevin.lawrence
 * reference: http://en.wikipedia.org/wiki/Enigma_rotor_details
 */

//TODO: Refactor all this back into EnigmaRotorType, (and expose a factory there, or  "subset" functionality?)
public enum EnigmaRotor {
    I_C(EnigmaRotorType.COMMERCIAL), II_C(EnigmaRotorType.COMMERCIAL), III_C(EnigmaRotorType.COMMERCIAL), 
    I_R(EnigmaRotorType.ROCKET), II_R(EnigmaRotorType.ROCKET), III_R(EnigmaRotorType.ROCKET), UKW_R(EnigmaRotorType.ROCKET), ETW_R(EnigmaRotorType.ROCKET), 
    I_K(EnigmaRotorType.SWISS_K), II_K(EnigmaRotorType.SWISS_K), III_K(EnigmaRotorType.SWISS_K), UKW_K(EnigmaRotorType.SWISS_K), ETW_K(EnigmaRotorType.SWISS_K), 
    I(EnigmaRotorType.ENIGMA_1), II(EnigmaRotorType.ENIGMA_1), III(EnigmaRotorType.ENIGMA_1), IV(EnigmaRotorType.M3_ARMY), V(EnigmaRotorType.M3_ARMY), VI(EnigmaRotorType.M3_M4_NAVAL), VII(EnigmaRotorType.M3_M4_NAVAL), VIII(EnigmaRotorType.M3_M4_NAVAL), 
    BETA(EnigmaRotorType.M4_R2), GAMMA(EnigmaRotorType.M4_R2), REF_A(EnigmaRotorType.NONE), REF_B(EnigmaRotorType.NONE), REF_C(EnigmaRotorType.NONE), REF_B_THIN(EnigmaRotorType.M4_R1), REF_C_THIN(EnigmaRotorType.M4_R1), REF_ETW(EnigmaRotorType.ENIGMA_1);
 
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    private EnigmaRotor(EnigmaRotorType rotorType){
        this.rotorType = rotorType;
  }
        //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private EnigmaRotorType rotorType;

    /**
     * @return the rotorType
     */
    public EnigmaRotorType getRotorType() {
        return rotorType;
    }

    /**
     * @param rotorType the rotorType to set
     */
    public void setRotorType(EnigmaRotorType rotorType) {
        this.rotorType = rotorType;
    }
    //</editor-fold>
 
}
