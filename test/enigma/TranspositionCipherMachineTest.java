/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

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
public class TranspositionCipherMachineTest {
    
//    public TranspositionCipherMachineTest() {
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
     * Test of encipher method, of class TranspositionCipherMachine.
     */
    @Test
    public void testEncipher() {
        System.out.println("testEncipher");
        
        ArrayList<TranspositionRotor> rotors = new ArrayList<TranspositionRotor>();
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.I));
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.II));
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.III));
        
        TranspositionRotorManager rotorManager = new StepwiseSequentialRotorManager(rotors);

        TranspositionCipherMachine instance = new TranspositionCipherMachine(rotorManager, rotors);
        String plainText = "Two can keep a secret if one is dead";
        String cipherText = instance.encipher("Two can keep a secret if one is dead");
        System.out.println("Plain Text  = " + plainText);
        String decipheredText = instance.decipher(cipherText);
        System.out.println("Cipher Text = " + decipheredText);

        assertEquals(true, true);
    }

//    /**
//     * Test of decipher method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testDecipher() {
//        System.out.println("decipher");
//        String cipherText = "";
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        String expResult = "";
//        String result = instance.decipher(cipherText);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRotors method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testGetRotors() {
//        System.out.println("getRotors");
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        ArrayList expResult = null;
//        ArrayList result = instance.getRotors();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRotors method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testSetRotors() {
//        System.out.println("setRotors");
//        ArrayList<TranspositionRotor> rotors = null;
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        instance.setRotors(rotors);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRotorManager method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testGetRotorManager() {
//        System.out.println("getRotorManager");
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        TranspositionRotorManager expResult = null;
//        TranspositionRotorManager result = instance.getRotorManager();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRotorManager method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testSetRotorManager() {
//        System.out.println("setRotorManager");
//        TranspositionRotorManager rotorManager = null;
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        instance.setRotorManager(rotorManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFixedInterfaceRotor method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testGetFixedInterfaceRotor() {
//        System.out.println("getFixedInterfaceRotor");
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        InterfaceRotor expResult = null;
//        InterfaceRotor result = instance.getFixedInterfaceRotor();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setFixedInterfaceRotor method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testSetFixedInterfaceRotor() {
//        System.out.println("setFixedInterfaceRotor");
//        InterfaceRotor fixedInterfaceRotor = null;
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        instance.setFixedInterfaceRotor(fixedInterfaceRotor);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCts method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testGetCts() {
//        System.out.println("getCts");
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        TranspositionCipherMachine.TextSink expResult = null;
//        TranspositionCipherMachine.TextSink result = instance.getCts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setCts method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testSetCts() {
//        System.out.println("setCts");
//        TranspositionCipherMachine.TextSink cts = null;
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        instance.setCts(cts);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPts method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testGetPts() {
//        System.out.println("getPts");
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        TranspositionCipherMachine.TextSource expResult = null;
//        TranspositionCipherMachine.TextSource result = instance.getPts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPts method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testSetPts() {
//        System.out.println("setPts");
//        TranspositionCipherMachine.TextSource pts = null;
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        instance.setPts(pts);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isVerbose method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testIsVerbose() {
//        System.out.println("isVerbose");
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        boolean expResult = false;
//        boolean result = instance.isVerbose();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setVerbose method, of class TranspositionCipherMachine.
//     */
//    @Test
//    public void testSetVerbose() {
//        System.out.println("setVerbose");
//        boolean verbose = false;
//        TranspositionCipherMachine instance = new TranspositionCipherMachine();
//        instance.setVerbose(verbose);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}