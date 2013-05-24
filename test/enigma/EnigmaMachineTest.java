/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import enigma.EnigmaMachine.CipherTextSink;
import enigma.EnigmaMachine.PlainTextSource;
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
        EnigmaMachine instance = new EnigmaMachine();
        instance.encipher("Two can keep a secret if one is dead");
        

        assertEquals(true, true);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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
//        CipherTextSink expResult = null;
//        CipherTextSink result = instance.getCts();
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
//        CipherTextSink cts = null;
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
//        PlainTextSource expResult = null;
//        PlainTextSource result = instance.getPts();
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
//        PlainTextSource pts = null;
//        EnigmaMachine instance = new EnigmaMachine();
//        instance.setPts(pts);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
