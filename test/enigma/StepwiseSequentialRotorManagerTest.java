/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import cryptography.CipherOperation;
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
public class StepwiseSequentialRotorManagerTest {
    
    public StepwiseSequentialRotorManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setTranspositionRotors method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testSetTranspositionRotors() {
        System.out.println("setTranspositionRotors");
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(null);
        
        assertNull(instance.getTranspositionRotors());

        ArrayList<TranspositionRotor> expResult = getRotorSet();
        instance.setTranspositionRotors(expResult);
        ArrayList result = instance.getTranspositionRotors();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTranspositionRotors method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testGetTranspositionRotors() {
        System.out.println("getTranspositionRotors");
        ArrayList expResult = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(expResult);

        ArrayList result = instance.getTranspositionRotors();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCipherOperation method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testSetCipherOperation() {
        System.out.println("setCipherOperation");
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(null);

        //Check default value
        CipherOperation expResult = CipherOperation.ENCIPHER;
        CipherOperation result = instance.getCipherOperation();
        assertEquals(expResult, result);

        expResult = CipherOperation.DECIPHER;
        instance.setCipherOperation(expResult);
        result = instance.getCipherOperation();
        assertEquals(expResult, result);

        expResult = CipherOperation.ENCIPHER;
        instance.setCipherOperation(expResult);
        result = instance.getCipherOperation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCipherOperation method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testGetCipherOperation() {
        System.out.println("getCipherOperation");
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(null);

        CipherOperation expResult = CipherOperation.DECIPHER;
        instance.setCipherOperation(expResult);
        CipherOperation result = instance.getCipherOperation();
        assertEquals(expResult, result);

        expResult = CipherOperation.ENCIPHER;
        instance.setCipherOperation(expResult);
        result = instance.getCipherOperation();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentTranspositionRotor method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testGetCurrentTranspositionRotor() {
        System.out.println("getCurrentTranspositionRotor");
        ArrayList<TranspositionRotor> rotorSet = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(rotorSet);
        
        TranspositionRotor expResult = rotorSet.get(0);
        TranspositionRotor result = instance.getCurrentTranspositionRotor();
        assertEquals(expResult, result);
        
        instance.incrementCurrentRotationRotorIndex();
        expResult = rotorSet.get(1);
        result = instance.getCurrentTranspositionRotor();
        assertEquals(expResult, result);

        instance.incrementCurrentRotationRotorIndex();
        expResult = rotorSet.get(2);
        result = instance.getCurrentTranspositionRotor();
        assertEquals(expResult, result);

        instance.incrementCurrentRotationRotorIndex();
        expResult = rotorSet.get(0);
        result = instance.getCurrentTranspositionRotor();
        assertEquals(expResult, result);

        instance.setCurrentRotationRotorIndex(2);
        expResult = rotorSet.get(2);
        result = instance.getCurrentTranspositionRotor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentRotationRotorIndex method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testGetCurrentRotationRotorIndex() {
        System.out.println("getCurrentRotationRotorIndex");
        ArrayList<TranspositionRotor> rotorSet = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(rotorSet);

        //Default value = 0;
        int expResult = 0;
        int result = instance.getCurrentRotationRotorIndex();
        assertEquals(expResult, result);
        
        expResult = 2;
        instance.setCurrentRotationRotorIndex(expResult);
        result = instance.getCurrentRotationRotorIndex();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCurrentRotationRotorIndex method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testSetCurrentRotationRotorIndex() {
        System.out.println("setCurrentRotationRotorIndex");
        ArrayList<TranspositionRotor> rotorSet = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(rotorSet);

        //Default value = 0;
        int expResult = 0;
        int result = instance.getCurrentRotationRotorIndex();
        assertEquals(expResult, result);
        
        expResult = 2;
        instance.setCurrentRotationRotorIndex(expResult);
        result = instance.getCurrentRotationRotorIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of incrementCurrentRotationRotorIndex method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testIncrementCurrentRotationRotorIndex() {
        System.out.println("incrementCurrentRotationRotorIndex");
        ArrayList<TranspositionRotor> rotorSet = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(rotorSet);

        System.out.println(" Initial");
        int expResult = 0;
        int result = instance.getCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result);
        
        System.out.println(" First = 1");
        expResult = 1;
        result = instance.incrementCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result);
        result = instance.getCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result);
        
        System.out.println(" Second = 2");
        expResult = 2;
        result = instance.incrementCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result);
        System.out.printf("%d, %d\n", expResult, result);
        result = instance.getCurrentRotationRotorIndex();
        assertEquals(expResult, result);
        
        System.out.println(" Third = 0");
        expResult = 0;
        result = instance.incrementCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result);
        result = instance.getCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result);
        
        System.out.println(" Fourth = 1");
        expResult = 1;
        result = instance.incrementCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result);
        result = instance.getCurrentRotationRotorIndex();
        System.out.printf("  %d, %d\n", expResult, result);
        assertEquals(expResult, result); 
    }
    
    private ArrayList<TranspositionRotor> getRotorSet(){
        ArrayList<TranspositionRotor> rotors = new ArrayList<TranspositionRotor>();
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.I));
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.II));
        rotors.add(new EnigmaTranspositionRotor(EnigmaRotor.III));
        
        return rotors;
    }

    /**
     * Test of resetRotors method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testResetRotors() {
        System.out.println("resetRotors");
        ArrayList<TranspositionRotor> rotorSet = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(rotorSet);

        int expResult = 4;
        for(TranspositionRotor rotor : instance.getTranspositionRotors()){
            rotor.setPosition(expResult);
        }

        for(TranspositionRotor rotor : instance.getTranspositionRotors()){
            assertEquals(expResult, rotor.getPosition());
        }

        instance.resetRotors();
        expResult = 0;
        for(TranspositionRotor rotor : instance.getTranspositionRotors()){
            assertEquals(expResult, rotor.getPosition());
        }
    }

    /**
     * Test of setRotorState method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testSetRotorState_intArr() {
        System.out.println("setRotorState");
        ArrayList<TranspositionRotor> rotorSet = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(rotorSet);

        instance.resetRotors();
        int expResult = 0;
        for(TranspositionRotor rotor : instance.getTranspositionRotors()){
            assertEquals(expResult, rotor.getPosition());
        }

        int[] rotorState = {0, 1, 2};
        instance.setRotorState(rotorState);

        for (int i = 0; i < instance.getTranspositionRotors().size(); i++) {
            assertEquals(i, instance.getTranspositionRotors().get(i).getPosition());
        }
    }

    /**
     * Test of setRotorState method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testSetRotorState_CipherOperation_TextLength() {
        System.out.println("setRotorState");
//        CipherOperation operation = null;
//        int textLength = 0;
//        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager();
//        boolean expResult = false;
//        boolean result = instance.setRotorState(operation, textLength);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beforeProcessCharacter method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testBeforeProcessCharacter() {
        System.out.println("beforeProcessCharacter");
        ArrayList<TranspositionRotor> rotorSet = getRotorSet();
        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager(rotorSet);

        instance.resetRotors();
        int expResult = 0;
        int result = instance.getCurrentRotationRotorIndex();
        assertEquals(expResult, result);
        
        instance.beforeProcessCharacter();
        result = instance.getCurrentRotationRotorIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of afterProcessCharacter method, of class StepwiseSequentialRotorManager.
     */
    @Test
    public void testAfterProcessCharacter() {
        System.out.println("afterProcessCharacter");
//        StepwiseSequentialRotorManager instance = new StepwiseSequentialRotorManager();
//        instance.afterProcessCharacter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}