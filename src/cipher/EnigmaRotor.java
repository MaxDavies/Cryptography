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
public enum EnigmaRotor {
    I_C, II_C, III_C, 
    I_R, II_R, III_R, UKW_R, ETW_R, 
    I_K, II_K, III_K, UKW_K, ETW_K, 
    I, II, III, IV, V, VI, VII, VIII, 
    BETA, GAMMA, REF_A, REF_B, REF_C, REF_B_THIN, REF_C_THIN, REF_ETW;
 
    private boolean reflector;
    private String type;
    
}
