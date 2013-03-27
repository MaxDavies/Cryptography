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
public class TranspositionRotorTest {
    
    public static final char[] OUTPUT_TEST_01 = {'D', 'M', 'T', 'W', 'S', 'I', 'L', 'R', 'U', 'Y', 'Q', 'N', 'K', 'F', 'E', 'J', 'C', 'A', 'Z', 'B', 'P', 'G', 'X', 'O', 'H', 'V'};

    
    public TranspositionRotorTest() {
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

    private TranspositionRotor getTestRotor(){
        TranspositionRotor rotor = new TranspositionRotor();
        rotor.setTranspositionMaps(TranspositionRotor.INPUT_BASE_ALPHA, OUTPUT_TEST_01);
        return rotor;
    }
    
    /**
     * Test of rotate method, of class TranspositionRotor.
     */
    @Test
    public void testRotate_no_args() {
        System.out.println("rotate");
        TranspositionRotor rotor = getTestRotor();
        
        rotor.setPosition(0);
        rotor.setDirection(RotationDirection.FORWARD);

        int expResult = 1;
        int result = rotor.rotate();
        assertEquals(expResult, result);
        
        expResult = 2;
        result = rotor.rotate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of rotate method, of class TranspositionRotor.
     */
    @Test
    public void testRotate_args() {
        System.out.println("rotate");
        RotationDirection direction = null;
        int steps = 0;
        TranspositionRotor instance = new TranspositionRotor();
        int expResult = 0;
        int result = instance.rotate(direction, steps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transposeConnection method, of class TranspositionRotor.
     */
    @Test
    public void testTransposeConnection() {
        System.out.println("transposeConnection");
        int connection = 0;
        TranspositionDirection direction = null;
        TranspositionRotor instance = new TranspositionRotor();
        TranspositionData expResult = null;
        TranspositionData result = instance.transposeConnection(connection, direction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transposeCharacter method, of class TranspositionRotor.
     */
    @Test
    public void testTransposeCharacter() {
        System.out.println("transposeCharacter");
        Character value = null;
        TranspositionDirection direction = null;
        TranspositionRotor instance = new TranspositionRotor();
        TranspositionData expResult = null;
        TranspositionData result = instance.transposeCharacter(value, direction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOutput method, of class TranspositionRotor.
     */
    @Test
    public void testGetOutput() {
        System.out.println("getOutput");
        char input = ' ';
        TranspositionRotor instance = new TranspositionRotor();
        char expResult = ' ';
        char result = instance.getOutput(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInput method, of class TranspositionRotor.
     */
    @Test
    public void testGetInput() {
        System.out.println("getInput");
        char output = ' ';
        TranspositionRotor instance = new TranspositionRotor();
        char expResult = ' ';
        char result = instance.getInput(output);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTranspositionMaps method, of class TranspositionRotor.
     */
    @Test
    public void testSetTranspositionMaps() {
        System.out.println("setTranspositionMaps");

        TranspositionRotor instance = new TranspositionRotor();

        char[] inputs = {};
        char[] outputs = {};
        instance.setTranspositionMaps(inputs, outputs);
        assertEquals(0, instance.getSize());

        char[] inputs1 = {'A', 'B', 'C'};
        char[] outputs1 = {'D', 'E', 'F'};
        instance.setTranspositionMaps(inputs1, outputs1);
        assertEquals(3, instance.getSize());
    
    }

    /**
     * Test of getDirection method, of class TranspositionRotor.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        TranspositionRotor instance = getTestRotor();

//        RotationDirection direction = RotationDirection.FORWARD;
        RotationDirection result = instance.getDirection();
        assertEquals(RotationDirection.FORWARD, result);
        
        RotationDirection direction = RotationDirection.BACKWARD;
        instance.setDirection(direction);
        result = instance.getDirection();
        assertEquals(direction, result);
    }

    /**
     * Test of setDirection method, of class TranspositionRotor.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        TranspositionRotor instance = getTestRotor();

        RotationDirection result = instance.getDirection();
        assertEquals(RotationDirection.FORWARD, result);
        
        RotationDirection direction = RotationDirection.BACKWARD;
        instance.setDirection(direction);
        result = instance.getDirection();
        assertEquals(direction, result);
    }

    /**
     * Test of getSteps method, of class TranspositionRotor.
     */
    @Test
    public void testGetSteps() {
        System.out.println("getSteps");
        TranspositionRotor instance = getTestRotor();

        int steps = 0;
        instance.setSteps(steps);
        int result = instance.getSteps();
        assertEquals(steps, result);
        
        steps = 1;
        instance.setSteps(steps);
        result = instance.getSteps();
        assertEquals(steps, result);
    }

    /**
     * Test of setSteps method, of class TranspositionRotor.
     */
    @Test
    public void testSetSteps() {
        System.out.println("setSteps");
        TranspositionRotor instance = getTestRotor();

        int steps = 0;
        instance.setSteps(steps);
        int result = instance.getSteps();
        assertEquals(steps, result);
        
        steps = 1;
        instance.setSteps(steps);
        result = instance.getSteps();
        assertEquals(steps, result);
    }

    /**
     * Test of isReflector method, of class TranspositionRotor.
     */
    @Test
    public void testIsReflector() {
        System.out.println("isReflector");
        TranspositionRotor instance = getTestRotor();

        boolean expResult = false;
        boolean result = instance.isReflector();
        
        assertEquals(expResult, result);

        expResult = true;
        instance.setReflector(expResult);
        result = instance.isReflector();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setReflector method, of class TranspositionRotor.
     */
    @Test
    public void testSetReflector() {
        System.out.println("setReflector");
        TranspositionRotor instance = getTestRotor();

        boolean reflector = false;
        instance.setReflector(reflector);
        
        boolean result = instance.isReflector();
        
        assertEquals(reflector, result);

        reflector = true;
        instance.setReflector(reflector);
        
        result = instance.isReflector();
        
        assertEquals(reflector, result);
    }

    /**
     * Test of getPosition method, of class TranspositionRotor.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        TranspositionRotor instance = getTestRotor();

        int expResult = 0;
        int result = instance.getPosition();
        assertEquals(expResult, result);

        expResult = 1;
        instance.setPosition(expResult);
        result = instance.getPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPosition method, of class TranspositionRotor.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        TranspositionRotor rotor = getTestRotor();

        int expResult = 0;
        rotor.setPosition(expResult);
        int position = rotor.getPosition();
        assertEquals(expResult, position);

        expResult = 1;
        rotor.setPosition(expResult);
        position = rotor.getPosition();
        assertEquals(expResult, position);
        
        expResult = 5;
        
        rotor.setPosition(rotor.getSize() + 5);
        position = rotor.getPosition();
        assertEquals(expResult, position);
    }
}
