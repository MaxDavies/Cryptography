/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import static enigma.TranspositionRotor.INPUT_BASE_CASE_ALPHANUMERIC;
import static enigma.TranspositionRotor.INPUT_BASE_NUMERIC;
import static enigma.TranspositionRotor.INPUT_BASE_SYMBOL;
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
public class UtilityTest {
    
//    public UtilityTest() {
//    }
//    
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
//
//    /**
//     * Test of array2DToString method, of class Utility.
//     */
//    @Test
//    public void testArray2DToString() {
//        System.out.println("array2DToString");
//        char[][] array = null;
//        String expResult = "";
//        String result = Utility.array2DToString(array);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of stringTo2DArray method, of class Utility.
//     */
//    @Test
//    public void testStringTo2DArray() {
//        System.out.println("stringTo2DArray");
//        String str = "";
//        int rows = 0;
//        int columns = 0;
//        char[][] expResult = null;
//        char[][] result = Utility.stringTo2DArray(str, rows, columns);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of printArray2D method, of class Utility.
//     */
//    @Test
//    public void testPrintArray2D() {
//        System.out.println("printArray2D");
//        char[][] array = null;
//        Utility.printArray2D(array);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of combineCharArrays method, of class Utility.
     */
    @Test
    public void testCombineCharArrays() {
        System.out.println("combineCharArrays");
        char[][] charArrays = null;
        char[] expResult = null;
        
        char[][] all = {INPUT_BASE_CASE_ALPHANUMERIC, INPUT_BASE_NUMERIC, INPUT_BASE_SYMBOL};
        char[] result =  Utility.combineCharArrays(all);
    
        Utility.printArray("ALL", result);
        
//        assertArrayEquals(expResult, result);
    }

//    /**
//     * Test of getRandomCharacter method, of class Utility.
//     */
//    @Test
//    public void testGetRandomCharacter() {
//        System.out.println("getRandomCharacter");
//        int rangeBase = 0;
//        int range = 0;
//        char expResult = ' ';
//        char result = Utility.getRandomCharacter(rangeBase, range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRandomLetter method, of class Utility.
//     */
//    @Test
//    public void testGetRandomLetter() {
//        System.out.println("getRandomLetter");
//        char expResult = ' ';
//        char result = Utility.getRandomLetter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRandomLowerCaseLetter method, of class Utility.
//     */
//    @Test
//    public void testGetRandomLowerCaseLetter() {
//        System.out.println("getRandomLowerCaseLetter");
//        char expResult = ' ';
//        char result = Utility.getRandomLowerCaseLetter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRandomUpperCaseLetter method, of class Utility.
//     */
//    @Test
//    public void testGetRandomUpperCaseLetter() {
//        System.out.println("getRandomUpperCaseLetter");
//        char expResult = ' ';
//        char result = Utility.getRandomUpperCaseLetter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRandomIntegerDigit method, of class Utility.
//     */
//    @Test
//    public void testGetRandomIntegerDigit() {
//        System.out.println("getRandomIntegerDigit");
//        int expResult = 0;
//        int result = Utility.getRandomIntegerDigit();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRandomInteger method, of class Utility.
//     */
//    @Test
//    public void testGetRandomInteger() {
//        System.out.println("getRandomInteger");
//        int minimum = 0;
//        int maximum = 0;
//        int expResult = 0;
//        int result = Utility.getRandomInteger(minimum, maximum);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}