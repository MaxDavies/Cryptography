/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import cryptography.Utility;
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
        
        rotors.add(new TranspositionRotor(RotationDirection.FORWARD, 1, TranspositionRotor.INPUT_BASE_ALL, Utility.randomize(TranspositionRotor.INPUT_BASE_ALL)));
        rotors.add(new TranspositionRotor(RotationDirection.FORWARD, 1, Utility.randomize(TranspositionRotor.INPUT_BASE_ALL), Utility.randomize(TranspositionRotor.INPUT_BASE_ALL)));
        rotors.add(new TranspositionRotor(RotationDirection.FORWARD, 1, Utility.randomize(TranspositionRotor.INPUT_BASE_ALL), Utility.randomize(TranspositionRotor.INPUT_BASE_ALL)));
        
        TranspositionRotorManager rotorManager = new StepwiseSequentialRotorManager(rotors);

        TranspositionCipherMachine instance = new TranspositionCipherMachine(rotorManager, new InterfaceRotor(TranspositionRotor.INPUT_BASE_ALL), rotors);

        instance.setVerbose(false);
        String plainText = "Two can keep a secret if one is dead. Two can keep a secret if one is dead.";
        plainText = "Goto Dengo, a lieutenant in the Imperial Japanese Army and a mining engineer involved in an Axis project to bury looted gold in the Philippines. In the present-day storyline, he is a semi-retired chief executive of a large Japanese construction company. Enoch Root, a mysterious, seemingly ageless former Catholic priest and physician, serving as a coast-watcher with the ANZACs during World War II, later a chaplain in the top-secret British-American 'Unit 2702,' and an important figure in the equally mysterious Societas Eruditorum. In the present-day storyline, Root is portrayed as having a passionate belief that cryptography is important for maintaining freedom. Root spent the 1950s working at the National Security Agency and has since been based mostly in the Philippines as a Catholic lay-worker while lately 'gadding about trying to bring Internet stuff to China, but to Randy this just sounds like a cover story for something else.' Root also appears in Stephenson's The Baroque Cycle, which is set between 1666 and 1714. Mr. Wing, a wartime northern Chinese slave of the Japanese in the Philippines, who went on to become a general in the Chinese army and later a senior official in theState Grid Corporation of China. Described by Enoch Root as a 'wily survivor of many purges,' Wing is the only other survivor besides Goto Dengo of the Japanese gold burial project, and he competes with Goto and Epiphyte(2) to recover the buried treasure. Although Root and Wing do not meet during the action of the novel, Randy reflects that 'it is hard not to get the idea that Enoch Root and General Wing may have other reasons to be pissed off at each other.' Douglas MacArthur Shaftoe (named after General Douglas MacArthur), Robert Shaftoe's and Glory Altamira's half-Filipino, half-American son. He is introduced near the end of the World War II storyline as a toddler, when he meets his father, who tries to explain Shaftoe family heritage during the Liberation of Manila. In the modern-day storyline, Douglas is a retired U.S. Navy SEAL officer and U.S. Naval Academy graduate, who lives in the Philippines and operates Semper Marine, an underwater survey business with his daughter, Amy, conducting treasure hunts as a sideline. Dr. Günter Enoch Bobby 'G.E.B.' Kivistik is introduced in the modern storyline as a smug, Oxford-educated liberal-arts professor from Yale who recruits, and later seduces, Randy Waterhouse's girlfriend, Charlene. In the World War II storyline he is the unborn son of Julieta Kivistik and one of three possible fathers (hence his unusual name). His is a minor character in Cryptonomicon, but both his [impending] birth and his participation in Charlene's 'War as Text' conference catalyze major plot developments. Mary cCmndhd Waterhouse, Randy's Australian-born, Qwlghmian grandmother and Lawrence's wife.";

        String encipheredText = instance.encipher(plainText);        
        String decipheredText = instance.decipher(encipheredText);
//
        System.out.printf("Plain Text     : '%s'\n", plainText);
        System.out.printf("Cipher Text    : '%s'\n", encipheredText);
        System.out.printf("Deciphered Text: '%s'\n", decipheredText);
        System.out.printf("Plain Text     : '%s'\n", plainText);

        assertEquals(plainText, decipheredText);
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