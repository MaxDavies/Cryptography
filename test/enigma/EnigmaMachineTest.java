/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import enigma.EnigmaMachine.TextSink;
import enigma.EnigmaMachine.TextSource;
import java.util.ArrayList;
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
public class EnigmaMachineTest {
    
//    public EnigmaMachineTest() {
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

    
    
    
    /**
     * Test of getRotors method, of class EnigmaMachine.
     */
    @Test
    public void testEnigma() {
        System.out.println("testEnigma");
        
        ArrayList<EnigmaTranspositionRotor> rotors = new ArrayList<EnigmaTranspositionRotor>();
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.I));
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.II));
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.III));
        
        EnigmaMachine instance = new EnigmaMachine(rotors);
        
        String clearText = "Two can keep a secret if one is dead";
        String encipheredText = instance.encipher(clearText);
        System.out.println("=======================================================");
        System.out.printf("Enciphered Text: '%s'\n", encipheredText);
        System.out.println("=======================================================");
        String decipheredText = instance.decipher(encipheredText);

        System.out.println("=======================================================");
        System.out.printf("Clear Text     : '%s'\n", clearText);
        System.out.printf("Enciphered Text: '%s'\n", encipheredText);
        System.out.printf("Deciphered Text: '%s'\n", decipheredText);
        System.out.println("=======================================================");

        assertEquals(true, true);
    }
    
    
    
    
//
//    /**
//     * Test of getRotors method, of class EnigmaMachine.
//     */
//    @Test
//    public void testGetRotors() {
//        System.out.println("getRotors");
//        EnigmaMachine instance = new EnigmaMachine();
//        ArrayList expResult = null;
//        ArrayList result = instance.getRotors();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

    
    //    /**
//     * Test of setRotors method, of class EnigmaMachine.
//     */
//    @Test
//    public void testSetRotors() {
//        System.out.println("setRotors");
//        ArrayList<EnigmaTranspositionRotor> rotors = null;
//        EnigmaMachine instance = new EnigmaMachine();
//        instance.setRotors(rotors);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addRotor method, of class EnigmaMachine.
//     */
//    @Test
//    public void testAddRotor() {
//        System.out.println("addRotor");
//        EnigmaTranspositionRotor rotor = null;
//        EnigmaMachine instance = new EnigmaMachine();
//        instance.addRotor(rotor);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCts method, of class EnigmaMachine.
//     */
//    @Test
//    public void testGetCts() {
//        System.out.println("getCts");
//        EnigmaMachine instance = new EnigmaMachine();
//        TextSink expResult = null;
//        TextSink result = instance.getCts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCts method, of class EnigmaMachine.
//     */
//    @Test
//    public void testSetCts() {
//        System.out.println("setCts");
//        TextSink cts = null;
//        EnigmaMachine instance = new EnigmaMachine();
//        instance.setCts(cts);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPts method, of class EnigmaMachine.
//     */
//    @Test
//    public void testGetPts() {
//        System.out.println("getPts");
//        EnigmaMachine instance = new EnigmaMachine();
//        TextSource expResult = null;
//        TextSource result = instance.getPts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPts method, of class EnigmaMachine.
//     */
//    @Test
//    public void testSetPts() {
//        System.out.println("setPts");
//        TextSource pts = null;
//        EnigmaMachine instance = new EnigmaMachine();
//        instance.setPts(pts);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
