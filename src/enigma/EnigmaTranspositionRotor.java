/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author kevin.lawrence
 */
public class EnigmaTranspositionRotor extends TranspositionRotor {
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public EnigmaTranspositionRotor(EnigmaRotor enigmaRotor){
        setEnigmaRotor(enigmaRotor);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private EnigmaRotor enigmaRotor = null;
    
    /**
     * @return the enigmaRotor
     */
    public EnigmaRotor getEnigmaRotor() {
        return enigmaRotor;
    }
    
    /**
     * @param enigmaRotor the enigmaRotor to set
     */
    public final void setEnigmaRotor(EnigmaRotor enigmaRotor) {
        this.enigmaRotor = enigmaRotor;

        this.setReflector(enigmaRotor.getRotorType().isReflector());
        setEnigmaTranspositionMaps(enigmaRotor);
    }
    //</editor-fold>
                
    //<editor-fold defaultstate="collapsed" desc="Enigma Transposition Maps">
    public static final char[] INPUT_BASE =       {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] I_C_TRANS =        {'D', 'M', 'T', 'W', 'S', 'I', 'L', 'R', 'U', 'Y', 'Q', 'N', 'K', 'F', 'E', 'J', 'C', 'A', 'Z', 'B', 'P', 'G', 'X', 'O', 'H', 'V'};
    public static final char[] II_C_TRANS =       {'H', 'Q', 'Z', 'G', 'P', 'J', 'T', 'M', 'O', 'B', 'L', 'N', 'C', 'I', 'F', 'D', 'Y', 'A', 'W', 'V', 'E', 'U', 'S', 'R', 'K', 'X'};
    public static final char[] III_C_TRANS =      {'U', 'Q', 'N', 'T', 'L', 'S', 'Z', 'F', 'M', 'R', 'E', 'H', 'D', 'P', 'X', 'K', 'I', 'B', 'V', 'Y', 'G', 'J', 'C', 'W', 'O', 'A'};
    
    public static final char[] I_R_TRANS =        {'J', 'G', 'D', 'Q', 'O', 'X', 'U', 'S', 'C', 'A', 'M', 'I', 'F', 'R', 'V', 'T', 'P', 'N', 'E', 'W', 'K', 'B', 'L', 'Z', 'Y', 'H'};
    public static final char[] II_R_TRANS =       {'N', 'T', 'Z', 'P', 'S', 'F', 'B', 'O', 'K', 'M', 'W', 'R', 'C', 'J', 'D', 'I', 'V', 'L', 'A', 'E', 'Y', 'U', 'X', 'H', 'G', 'Q'};
    public static final char[] III_R_TRANS =      {'J', 'V', 'I', 'U', 'B', 'H', 'T', 'C', 'D', 'Y', 'A', 'K', 'E', 'Q', 'Z', 'P', 'O', 'S', 'G', 'X', 'N', 'R', 'M', 'W', 'F', 'L'};
    public static final char[] UKW_R_TRANS =      {'Q', 'Y', 'H', 'O', 'G', 'N', 'E', 'C', 'V', 'P', 'U', 'Z', 'T', 'F', 'D', 'J', 'A', 'X', 'W', 'M', 'K', 'I', 'S', 'R', 'B', 'L'};
    public static final char[] ETW_R_TRANS =      {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'P', 'Y', 'X', 'C', 'V', 'B', 'N', 'M', 'L'};
    
    public static final char[] I_K_TRANS =        {'P', 'E', 'Z', 'U', 'O', 'H', 'X', 'S', 'C', 'V', 'F', 'M', 'T', 'B', 'G', 'L', 'R', 'I', 'N', 'Q', 'J', 'W', 'A', 'Y', 'D', 'K'};
    public static final char[] II_K_TRANS =       {'Z', 'O', 'U', 'E', 'S', 'Y', 'D', 'K', 'F', 'W', 'P', 'C', 'I', 'Q', 'X', 'H', 'M', 'V', 'B', 'L', 'G', 'N', 'J', 'R', 'A', 'T'};
    public static final char[] III_K_TRANS =      {'E', 'H', 'R', 'V', 'X', 'G', 'A', 'O', 'B', 'Q', 'U', 'S', 'I', 'M', 'Z', 'F', 'L', 'Y', 'N', 'W', 'K', 'T', 'P', 'D', 'J', 'C'};
    public static final char[] UKW_K_TRANS =      {'I', 'M', 'E', 'T', 'C', 'G', 'F', 'R', 'A', 'Y', 'S', 'Q', 'B', 'Z', 'X', 'W', 'L', 'H', 'K', 'D', 'V', 'U', 'P', 'O', 'J', 'N'};
    public static final char[] ETW_K_TRANS =      {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'P', 'Y', 'X', 'C', 'V', 'B', 'N', 'M', 'L'};
    
    public static final char[] I_TRANS =          {'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J'};
    public static final char[] II_TRANS =         {'A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E'};
    public static final char[] III_TRANS =        {'B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O'};
    public static final char[] IV_TRANS =         {'E', 'S', 'O', 'V', 'P', 'Z', 'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T', 'G', 'K', 'D', 'C', 'M', 'W', 'B'};
    public static final char[] V_TRANS =          {'V', 'Z', 'B', 'R', 'G', 'I', 'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M', 'J', 'Q', 'O', 'F', 'E', 'C', 'K'};
    public static final char[] VI_TRANS =         {'J', 'P', 'G', 'V', 'O', 'U', 'M', 'F', 'Y', 'Q', 'B', 'E', 'N', 'H', 'Z', 'R', 'D', 'K', 'A', 'S', 'X', 'L', 'I', 'C', 'T', 'W'};
    public static final char[] VII_TRANS =        {'N', 'Z', 'J', 'H', 'G', 'R', 'C', 'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U', 'F', 'A', 'I', 'V', 'L', 'P', 'E', 'K', 'Q', 'D', 'T'};
    public static final char[] VIII_TRANS =       {'F', 'K', 'Q', 'H', 'T', 'L', 'X', 'O', 'C', 'B', 'J', 'S', 'P', 'D', 'Z', 'R', 'A', 'M', 'E', 'W', 'N', 'I', 'U', 'Y', 'G', 'V'};
    
    public static final char[] BETA_TRANS =       {'L', 'E', 'Y', 'J', 'V', 'C', 'N', 'I', 'X', 'W', 'P', 'B', 'Q', 'M', 'D', 'R', 'T', 'A', 'K', 'Z', 'G', 'F', 'U', 'H', 'O', 'S'};
    public static final char[] GAMMA_TRANS =      {'F', 'S', 'O', 'K', 'A', 'N', 'U', 'E', 'R', 'H', 'M', 'B', 'T', 'I', 'Y', 'C', 'W', 'L', 'Q', 'P', 'Z', 'X', 'V', 'G', 'J', 'D'};
    public static final char[] REF_A_TRANS =      {'E', 'J', 'M', 'Z', 'A', 'L', 'Y', 'X', 'V', 'B', 'W', 'F', 'C', 'R', 'Q', 'U', 'O', 'N', 'T', 'S', 'P', 'I', 'K', 'H', 'G', 'D'};
    public static final char[] REF_B_TRANS =      {'Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'D', 'P', 'X', 'N', 'G', 'O', 'K', 'M', 'I', 'E', 'B', 'F', 'Z', 'C', 'W', 'V', 'J', 'A', 'T'};
    public static final char[] REF_C_TRANS =      {'F', 'V', 'P', 'J', 'I', 'A', 'O', 'Y', 'E', 'D', 'R', 'Z', 'X', 'W', 'G', 'C', 'T', 'K', 'U', 'Q', 'S', 'B', 'N', 'M', 'H', 'L'};
    public static final char[] REF_B_THIN_TRANS = {'E', 'N', 'K', 'Q', 'A', 'U', 'Y', 'W', 'J', 'I', 'C', 'O', 'P', 'B', 'L', 'M', 'D', 'X', 'Z', 'V', 'F', 'T', 'H', 'R', 'G', 'S'};
    public static final char[] REF_C_THIN_TRANS = {'R', 'D', 'O', 'B', 'J', 'N', 'T', 'K', 'V', 'E', 'H', 'M', 'L', 'F', 'C', 'W', 'Z', 'A', 'X', 'G', 'Y', 'I', 'P', 'S', 'U', 'Q'};
    public static final char[] REF_ETW_TRANS =    {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
//    public static final char[] INPUT_BASE_ALPHANUM = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    //</editor-fold>
 
    //<editor-fold defaultstate="collapsed" desc="Methods">

    private void setEnigmaTranspositionMaps(EnigmaRotor enigmaRotor){
        this.setTranspositionMaps(INPUT_BASE, getEnigmaRotorTranspositionMap(enigmaRotor));
    }
    
    public static char[] getEnigmaRotorTranspositionMap(EnigmaRotor enigmaRotor){
        switch (enigmaRotor){
            case INTERFACE:
                return INPUT_BASE;
            case I_C:
                return I_C_TRANS;
            case II_C:
                return II_C_TRANS;
            case III_C:
                return III_C_TRANS;
            case I_R:
                return I_R_TRANS;
            case II_R:
                return II_R_TRANS;
            case III_R:
                return III_R_TRANS;
            case UKW_R:
                return UKW_R_TRANS;
            case ETW_R:
                return ETW_R_TRANS;
            case I_K:
                return I_K_TRANS;
            case II_K:
                return II_K_TRANS;
            case III_K:
                return III_K_TRANS;
            case UKW_K:
                return UKW_K_TRANS;
            case ETW_K:
                return ETW_K_TRANS;
            case I:
                return I_TRANS;
            case II:
                return II_TRANS;
            case III:
                return III_TRANS;
            case IV:
                return IV_TRANS;
            case V:
                return V_TRANS;
            case VI:
                return VI_TRANS;
            case VII:
                return VII_TRANS;
            case VIII:
                return VIII_TRANS;
            case BETA:
                return BETA_TRANS;
            case GAMMA:
                return GAMMA_TRANS;
            case REF_A:
                return REF_A_TRANS;
            case REF_B:
                return REF_B_TRANS;
            case REF_C:
                return REF_C_TRANS;
            case REF_B_THIN:
                return REF_B_THIN_TRANS;
            case REF_C_THIN:
                return REF_C_THIN_TRANS;
            case REF_ETW:
                return REF_ETW_TRANS;
            default:
                //TODO : Throw exception here... don't want to have mismatched input and output arrays.
                return new char[0];
        }
    }

    //</editor-fold>   

}
