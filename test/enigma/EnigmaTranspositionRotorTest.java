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
public class EnigmaTranspositionRotorTest {
    
    public EnigmaTranspositionRotorTest() {
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
     * Test of getEnigmaRotor method, of class EnigmaTranspositionRotor.
     */
    @Test
    public void testGetEnigmaRotor() {
        System.out.println("getEnigmaRotor");

        EnigmaRotor expResult = EnigmaRotor.I_C;
        EnigmaTranspositionRotor instance = new EnigmaTranspositionRotor(expResult);

        EnigmaRotor result = instance.getEnigmaRotor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEnigmaRotor method, of class EnigmaTranspositionRotor.
     */
    @Test
    public void testSetEnigmaRotor() {
        System.out.println("getEnigmaRotor");

        EnigmaRotor expResult = EnigmaRotor.I_C;
        EnigmaTranspositionRotor instance = new EnigmaTranspositionRotor(expResult);

        EnigmaRotor result = instance.getEnigmaRotor();
        assertEquals(expResult, result);

        expResult = EnigmaRotor.I_K;
        instance.setEnigmaRotor(expResult);

        result = instance.getEnigmaRotor();
        assertEquals(expResult, result);

    }

    /**
     * Test of EnigmaTranspositionRotor constructor method, of class EnigmaTranspositionRotor.
     */
    @Test
    public void testConstructor() {
        System.out.println("Constructor");

        EnigmaRotor expResult = EnigmaRotor.I_C;
        EnigmaTranspositionRotor instance = new EnigmaTranspositionRotor(expResult);

        EnigmaRotor result = instance.getEnigmaRotor();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of transpose method, of class EnigmaTranspositionRotor.
     */
    @Test
    public void testTranposeCharacter() {
        System.out.println("transposeCharacter");

        EnigmaTranspositionRotor instance = new EnigmaTranspositionRotor(EnigmaRotor.I_C);

        char[] resultArray = EnigmaTranspositionRotor.I_C_TRANS;
        
        Character input, expectedResult, actualResult;
        int failCount = 0;
        
        for (int i = 0; i < EnigmaTranspositionRotor.INPUT_BASE.length; i++) {
            input = EnigmaTranspositionRotor.INPUT_BASE[i];
            expectedResult = resultArray[i];
            actualResult = instance.transposeCharacter(input, TranspositionDirection.INPUT).getValue();
            
            if (expectedResult != actualResult){
                failCount++;
                System.out.printf("   FAILED Transposition Input = %s Expected = %s Actual = %s \n", input, expectedResult, actualResult);
            }
        }
        
        assertEquals(0, failCount); 
    }
    
        /**
     * Test of transpose method, of class EnigmaTranspositionRotor.
     */
    @Test
    public void testEnigmaTranpostionMaps() {
        System.out.println("Transposition Map Tests");
        System.out.println("=======================");
        
        int failCount, failTotal = 0;
        EnigmaRotor[] rotors = EnigmaRotor.values();
        
        for (int i = 0; i < rotors.length; i++) {
            failCount = testEnigmaTranpostionMap(new EnigmaTranspositionRotor(rotors[i]));

            if (failCount > 0){
                failTotal++;
            }
        }
        
        assertEquals(0, failTotal); 
    }
    
    public int testEnigmaTranpostionMap(EnigmaTranspositionRotor rotor) {
        System.out.printf("   Transposition Map - %s\n", rotor.getEnigmaRotor().name());

        char[] resultArray = EnigmaTranspositionRotor.getEnigmaRotorTranspositionMap(rotor.getEnigmaRotor());
        
        Character input, expectedResult, actualResult;
        int failCount = 0;
        
        for (int i = 0; i < EnigmaTranspositionRotor.INPUT_BASE.length; i++) {
            input = EnigmaTranspositionRotor.INPUT_BASE[i];
            expectedResult = resultArray[i];
            actualResult = rotor.transposeCharacter(input, TranspositionDirection.INPUT).getValue();
            
            if (expectedResult != actualResult){
                failCount++;
                System.out.printf("   FAILED Transposition Input = %s Expected = %s Actual = %s \n", input, expectedResult, actualResult);
            }
        }
        
        return failCount;
    }

    
    
    
    
}
