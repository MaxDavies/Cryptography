/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kevin.lawrence
 */
public class EnigmaRotorTest {
    
    public EnigmaRotorTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of values method, of class EnigmaRotor.
     */
    @Test
    public void testValues() {
        System.out.println("EnigmaRotorType: 'values' Tests");
        System.out.println("===============================");

        EnigmaRotor[] expResult = {EnigmaRotor.I_C, EnigmaRotor.II_C, EnigmaRotor.III_C, 
                                   EnigmaRotor.I_R, EnigmaRotor.II_R, EnigmaRotor.III_R, EnigmaRotor.UKW_R, EnigmaRotor.ETW_R, 
                                   EnigmaRotor.I_K, EnigmaRotor.II_K, EnigmaRotor.III_K, EnigmaRotor.UKW_K, EnigmaRotor.ETW_K, 
                                   EnigmaRotor.I, EnigmaRotor.II, EnigmaRotor.III, EnigmaRotor.IV, EnigmaRotor.V, EnigmaRotor.VI, EnigmaRotor.VII, EnigmaRotor.VIII, 
                                   EnigmaRotor.BETA, EnigmaRotor.GAMMA, EnigmaRotor.REF_A, EnigmaRotor.REF_B, EnigmaRotor.REF_C, EnigmaRotor.REF_B_THIN, EnigmaRotor.REF_C_THIN, EnigmaRotor.REF_ETW};

        EnigmaRotor[] result = EnigmaRotor.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class EnigmaRotor.
     */
    @Test
    public void testValueOf() {
        System.out.println("EnigmaRotor: 'valueOf' Tests");
        System.out.println("================================");
        
        String name = "";
        int failCount = 0;
        
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.I_C, "I_C")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.II_C, "II_C")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.III_C, "III_C")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.I_R, "I_R")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.II_R, "II_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.III_R, "III_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.UKW_R, "UKW_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.ETW_R, "ETW_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.I_K, "I_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.II_K, "II_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.III_K, "III_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.UKW_K, "UKW_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.ETW_K, "ETW_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.I, "I")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.II, "II")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.III, "III")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.IV, "IV")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.V, "V")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.VI, "VI")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.VII, "VII")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.VIII, "VIII")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.BETA, "BETA")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.GAMMA, "GAMMA")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.REF_A, "REF_A")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.REF_B, "REF_B")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.REF_C, "REF_C")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.REF_B_THIN, "REF_B_THIN")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.REF_C_THIN, "REF_C_THIN")){
            failCount++;
        }
        if ( ! testEnigmaRotorValueOf(EnigmaRotor.REF_ETW, "REF_ETW")){
            failCount++;
        }

        assertEquals(0, failCount);
    }

    private boolean testEnigmaRotorValueOf(EnigmaRotor expected, String value){
        System.out.printf(" - ValueOf Test : EnigmanRotor = %s\n", expected.name());
        EnigmaRotor actual = EnigmaRotor.valueOf(value);
        
        if (expected == actual){
            return true;
        } else {
            System.out.printf("   FAILED: Expected = %s Actual =%s \n", expected.name(), actual.name());
            return false;
        }
    }

    
    /**
     * Test of getRotorType method, of class EnigmaRotor.
     */
    @Test
    public void testGetRotorType() {
//        System.out.println("getRotorType");
//        EnigmaRotor instance = EnigmaRotor.I;
//        EnigmaRotorType expResult = null;
//        EnigmaRotorType result = instance.getRotorType();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        
        System.out.println("EnigmaRotor: 'getRotorType' Tests");
        System.out.println("=============================+===");
        
        String name = "";
        int failCount = 0;
        
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.I_C, "I_C")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.II_C, "II_C")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.III_C, "III_C")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.I_R, "I_R")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.II_R, "II_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.III_R, "III_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.UKW_R, "UKW_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.ETW_R, "ETW_R")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.I_K, "I_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.II_K, "II_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.III_K, "III_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.UKW_K, "UKW_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.ETW_K, "ETW_K")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.I, "I")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.II, "II")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.III, "III")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.IV, "IV")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.V, "V")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.VI, "VI")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.VII, "VII")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.VIII, "VIII")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.BETA, "BETA")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.GAMMA, "GAMMA")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.REF_A, "REF_A")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.REF_B, "REF_B")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.REF_C, "REF_C")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.REF_B_THIN, "REF_B_THIN")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.REF_C_THIN, "REF_C_THIN")){
            failCount++;
        }
        if ( ! testEnigmaRotorRotorType(EnigmaRotor.REF_ETW, "REF_ETW")){
            failCount++;
        }

        assertEquals(0, failCount);
        
        
    }
    
    private boolean testEnigmaRotorRotorType(EnigmaRotor rotor, EnigmaRotorType expected){
        System.out.printf(" - ValueOf Test : EnigmanRotor = %s\n", rotor.name());
        EnigmaRotorType actual = rotor.getRotorType();
        
        if (expected == actual){
            return true;
        } else {
            System.out.printf("   FAILED: Expected = %s Actual =%s \n", expected.name(), actual.name());
            return false;
        }
    }
    

    /**
     * Test of setRotorType method, of class EnigmaRotor.
     */
    @Test
    public void testSetRotorType() {
        System.out.println("setRotorType");
        EnigmaRotorType rotorType = null;
        EnigmaRotor instance = null;
        instance.setRotorType(rotorType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
