/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

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
    
//        
//    //<editor-fold defaultstate="collapsed" desc="Enigma Transposition Maps">
//    public static final char[] INPUT_BASE =       {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//    public static final char[] I_C_TRANS =        {'D', 'M', 'T', 'W', 'S', 'I', 'L', 'R', 'U', 'Y', 'Q', 'N', 'K', 'F', 'E', 'J', 'C', 'A', 'Z', 'B', 'P', 'G', 'X', 'O', 'H', 'V'};
//    public static final char[] II_C_TRANS =       {'H', 'Q', 'Z', 'G', 'P', 'J', 'T', 'M', 'O', 'B', 'L', 'N', 'C', 'I', 'F', 'D', 'Y', 'A', 'W', 'V', 'E', 'U', 'S', 'R', 'K', 'X'};
//    public static final char[] III_C_TRANS =      {'U', 'Q', 'N', 'T', 'L', 'S', 'Z', 'F', 'M', 'R', 'E', 'H', 'D', 'P', 'X', 'K', 'I', 'B', 'V', 'Y', 'G', 'J', 'C', 'W', 'O', 'A'};
//    
//    public static final char[] I_R_TRANS =        {'J', 'G', 'D', 'Q', 'O', 'X', 'U', 'S', 'C', 'A', 'M', 'I', 'F', 'R', 'V', 'T', 'P', 'N', 'E', 'W', 'K', 'B', 'L', 'Z', 'Y', 'H'};
//    public static final char[] II_R_TRANS =       {'N', 'T', 'Z', 'P', 'S', 'F', 'B', 'O', 'K', 'M', 'W', 'R', 'C', 'J', 'D', 'I', 'V', 'L', 'A', 'E', 'Y', 'U', 'X', 'H', 'G', 'Q'};
//    public static final char[] III_R_TRANS =      {'J', 'V', 'I', 'U', 'B', 'H', 'T', 'C', 'D', 'Y', 'A', 'K', 'E', 'Q', 'Z', 'P', 'O', 'S', 'G', 'X', 'N', 'R', 'M', 'W', 'F', 'L'};
//    public static final char[] UKW_R_TRANS =      {'Q', 'Y', 'H', 'O', 'G', 'N', 'E', 'C', 'V', 'P', 'U', 'Z', 'T', 'F', 'D', 'J', 'A', 'X', 'W', 'M', 'K', 'I', 'S', 'R', 'B', 'L'};
//    public static final char[] ETW_R_TRANS =      {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'P', 'Y', 'X', 'C', 'V', 'B', 'N', 'M', 'L'};
//    
//    public static final char[] I_K_TRANS =        {'P', 'E', 'Z', 'U', 'O', 'H', 'X', 'S', 'C', 'V', 'F', 'M', 'T', 'B', 'G', 'L', 'R', 'I', 'N', 'Q', 'J', 'W', 'A', 'Y', 'D', 'K'};
//    public static final char[] II_K_TRANS =       {'Z', 'O', 'U', 'E', 'S', 'Y', 'D', 'K', 'F', 'W', 'P', 'C', 'I', 'Q', 'X', 'H', 'M', 'V', 'B', 'L', 'G', 'N', 'J', 'R', 'A', 'T'};
//    public static final char[] III_K_TRANS =      {'E', 'H', 'R', 'V', 'X', 'G', 'A', 'O', 'B', 'Q', 'U', 'S', 'I', 'M', 'Z', 'F', 'L', 'Y', 'N', 'W', 'K', 'T', 'P', 'D', 'J', 'C'};
//    public static final char[] UKW_K_TRANS =      {'I', 'M', 'E', 'T', 'C', 'G', 'F', 'R', 'A', 'Y', 'S', 'Q', 'B', 'Z', 'X', 'W', 'L', 'H', 'K', 'D', 'V', 'U', 'P', 'O', 'J', 'N'};
//    public static final char[] ETW_K_TRANS =      {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'P', 'Y', 'X', 'C', 'V', 'B', 'N', 'M', 'L'};
//    
//    public static final char[] I_TRANS =          {'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J'};
//    public static final char[] II_TRANS =         {'A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E'};
//    public static final char[] III_TRANS =        {'B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O'};
//    public static final char[] IV_TRANS =         {'E', 'S', 'O', 'V', 'P', 'Z', 'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T', 'G', 'K', 'D', 'C', 'M', 'W', 'B'};
//    public static final char[] V_TRANS =          {'V', 'Z', 'B', 'R', 'G', 'I', 'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M', 'J', 'Q', 'O', 'F', 'E', 'C', 'K'};
//    public static final char[] VI_TRANS =         {'J', 'P', 'G', 'V', 'O', 'U', 'M', 'F', 'Y', 'Q', 'B', 'E', 'N', 'H', 'Z', 'R', 'D', 'K', 'A', 'S', 'X', 'L', 'I', 'C', 'T', 'W'};
//    public static final char[] VII_TRANS =        {'N', 'Z', 'J', 'H', 'G', 'R', 'C', 'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U', 'F', 'A', 'I', 'V', 'L', 'P', 'E', 'K', 'Q', 'D', 'T'};
//    public static final char[] VIII_TRANS =       {'F', 'K', 'Q', 'H', 'T', 'L', 'X', 'O', 'C', 'B', 'J', 'S', 'P', 'D', 'Z', 'R', 'A', 'M', 'E', 'W', 'N', 'I', 'U', 'Y', 'G', 'V'};
//    
//    public static final char[] BETA_TRANS =       {'L', 'E', 'Y', 'J', 'V', 'C', 'N', 'I', 'X', 'W', 'P', 'B', 'Q', 'M', 'D', 'R', 'T', 'A', 'K', 'Z', 'G', 'F', 'U', 'H', 'O', 'S'};
//    public static final char[] GAMMA_TRANS =      {'F', 'S', 'O', 'K', 'A', 'N', 'U', 'E', 'R', 'H', 'M', 'B', 'T', 'I', 'Y', 'C', 'W', 'L', 'Q', 'P', 'Z', 'X', 'V', 'G', 'J', 'D'};
//    public static final char[] REF_A_TRANS =      {'E', 'J', 'M', 'Z', 'A', 'L', 'Y', 'X', 'V', 'B', 'W', 'F', 'C', 'R', 'Q', 'U', 'O', 'N', 'T', 'S', 'P', 'I', 'K', 'H', 'G', 'D'};
//    public static final char[] REF_B_TRANS =      {'Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'D', 'P', 'X', 'N', 'G', 'O', 'K', 'M', 'I', 'E', 'B', 'F', 'Z', 'C', 'W', 'V', 'J', 'A', 'T'};
//    public static final char[] REF_C_TRANS =      {'F', 'V', 'P', 'J', 'I', 'A', 'O', 'Y', 'E', 'D', 'R', 'Z', 'X', 'W', 'G', 'C', 'T', 'K', 'U', 'Q', 'S', 'B', 'N', 'M', 'H', 'L'};
//    public static final char[] REF_B_THIN_TRANS = {'E', 'N', 'K', 'Q', 'A', 'U', 'Y', 'W', 'J', 'I', 'C', 'O', 'P', 'B', 'L', 'M', 'D', 'X', 'Z', 'V', 'F', 'T', 'H', 'R', 'G', 'S'};
//    public static final char[] REF_C_THIN_TRANS = {'R', 'D', 'O', 'B', 'J', 'N', 'T', 'K', 'V', 'E', 'H', 'M', 'L', 'F', 'C', 'W', 'Z', 'A', 'X', 'G', 'Y', 'I', 'P', 'S', 'U', 'Q'};
//    public static final char[] REF_ETW_TRANS =    {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//    //</editor-fold>
// 
//    //<editor-fold defaultstate="collapsed" desc="Factory">
//    public static TranspositionRotor getTranspositionRotor(EnigmaRotor enigmaRotor){
//        TranspositionRotor rotor = new TranspositionRotor();
//        
//        rotor.setReflector(enigmaRotor.getRotorType().isReflector());
//        
//        switch (enigmaRotor){
//            case I_C:
//                rotor.setTranspositionMaps(INPUT_BASE, I_C_TRANS);
//                break;
//            case II_C:
//                rotor.setTranspositionMaps(INPUT_BASE, II_C_TRANS);
//                break;
//            case III_C:
//                rotor.setTranspositionMaps(INPUT_BASE, III_C_TRANS);
//                break;
//            case I_R:
//                rotor.setTranspositionMaps(INPUT_BASE, I_R_TRANS);
//                break;
//            case II_R:
//                rotor.setTranspositionMaps(INPUT_BASE, II_R_TRANS);
//                break;
//            case III_R:
//                rotor.setTranspositionMaps(INPUT_BASE, III_R_TRANS);
//                break;
//            case UKW_R:
//                rotor.setTranspositionMaps(INPUT_BASE, UKW_R_TRANS);
//                break;
//            case ETW_R:
//                rotor.setTranspositionMaps(INPUT_BASE, ETW_R_TRANS);
//                break;
//            case I_K:
//                rotor.setTranspositionMaps(INPUT_BASE, I_K_TRANS);
//                break;
//            case II_K:
//                rotor.setTranspositionMaps(INPUT_BASE, II_K_TRANS);
//                break;
//            case III_K:
//                rotor.setTranspositionMaps(INPUT_BASE, III_K_TRANS);
//                break;
//            case UKW_K:
//                rotor.setTranspositionMaps(INPUT_BASE, UKW_K_TRANS);
//                break;
//            case ETW_K:
//                rotor.setTranspositionMaps(INPUT_BASE, ETW_K_TRANS);
//                break;
//            case I:
//                rotor.setTranspositionMaps(INPUT_BASE, I_TRANS);
//                break;
//            case II:
//                rotor.setTranspositionMaps(INPUT_BASE, II_TRANS);
//                break;
//            case III:
//                rotor.setTranspositionMaps(INPUT_BASE, III_TRANS);
//                break;
//            case IV:
//                rotor.setTranspositionMaps(INPUT_BASE, IV_TRANS);
//                break;
//            case V:
//                rotor.setTranspositionMaps(INPUT_BASE, V_TRANS);
//                break;
//            case VI:
//                rotor.setTranspositionMaps(INPUT_BASE, VI_TRANS);
//                break;
//            case VII:
//                rotor.setTranspositionMaps(INPUT_BASE, VII_TRANS);
//                break;
//            case VIII:
//                rotor.setTranspositionMaps(INPUT_BASE, VIII_TRANS);
//                break;
//            case BETA:
//                rotor.setTranspositionMaps(INPUT_BASE, BETA_TRANS);
//                break;
//            case GAMMA:
//                rotor.setTranspositionMaps(INPUT_BASE, GAMMA_TRANS);
//                break;
//            case REF_A:
//                rotor.setTranspositionMaps(INPUT_BASE, REF_A_TRANS);
//                break;
//            case REF_B:
//                rotor.setTranspositionMaps(INPUT_BASE, REF_B_TRANS);
//                break;
//            case REF_C:
//                rotor.setTranspositionMaps(INPUT_BASE, REF_C_TRANS);
//                break;
//            case REF_B_THIN:
//                rotor.setTranspositionMaps(INPUT_BASE, REF_B_THIN_TRANS);
//                break;
//            case REF_C_THIN:
//                rotor.setTranspositionMaps(INPUT_BASE, REF_C_THIN_TRANS);
//                break;
//            case REF_ETW:
//                rotor.setTranspositionMaps(INPUT_BASE, REF_ETW_TRANS);
//                break;
//        }
//        
//        return rotor;
//    }
//    //</editor-fold>  
//    
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
