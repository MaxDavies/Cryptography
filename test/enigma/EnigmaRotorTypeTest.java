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
public class EnigmaRotorTypeTest {
    
    public EnigmaRotorTypeTest() {
    }

    /**
     * Test of values method, of class EnigmaRotorType.
     */
    @Test
    public void testValues() {
        System.out.println("EnigmaRotorType: 'values' Tests");
        System.out.println("===============================");

        EnigmaRotorType[] expResult = {EnigmaRotorType.COMMERCIAL, EnigmaRotorType.ROCKET, EnigmaRotorType.SWISS_K, 
                                       EnigmaRotorType.ENIGMA_1, EnigmaRotorType.M3_ARMY, EnigmaRotorType.M3_M4_NAVAL, 
                                       EnigmaRotorType.M4_R2, EnigmaRotorType.M4_R1, EnigmaRotorType.NONE};
        EnigmaRotorType[] result = EnigmaRotorType.values();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of valueOf method, of class EnigmaRotorType.
     */
    @Test
    public void testValueOf() {
        System.out.println("EnigmaRotorType: 'valueOf' Tests");
        System.out.println("================================");
        
        String name = "";
        int failCount = 0;

        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.COMMERCIAL, "COMMERCIAL")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.ROCKET, "ROCKET")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.SWISS_K, "SWISS_K")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.ENIGMA_1, "ENIGMA_1")){
            failCount++;
        }

        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.M3_ARMY, "M3_ARMY")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.M3_M4_NAVAL, "M3_M4_NAVAL")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.M4_R2, "M4_R2")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.M4_R1, "M4_R1")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeValueOf(EnigmaRotorType.NONE, "NONE")){
            failCount++;
        }
        
        assertEquals(0, failCount);
    }
    
    private boolean testEnigmaRotorTypeValueOf(EnigmaRotorType expected, String value){
        System.out.printf(" - ValueOf Test : EnigmanRotorType = %s [%s]\n", expected.name(), expected.getModel());
        EnigmaRotorType actual = EnigmaRotorType.valueOf(value);
        
        if (expected == actual){
            return true;
        } else {
            System.out.printf("   FAILED: Expected = %s Actual =%s \n", expected.name(), actual.name());
            return false;
        }
    }
    
    

    /**
     * Test of getModel method, of class EnigmaRotorType.
     */
    @Test
    public void testModels() {
        System.out.println("EnigmaRotorType 'Model Values' Test");
//        TODO - Check All model values?
        
        System.out.println("EnigmaRotorType: 'valueOf' Tests");
        System.out.println("================================");
        
        String name = "";
        int failCount = 0;

        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.COMMERCIAL, "Commercial Enigma A, B")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.ROCKET, "German Railway [Rocket]")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.SWISS_K, "Swiss K")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.ENIGMA_1, "Enigma 1")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.M3_ARMY, "M3 Army")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.M3_M4_NAVAL, "M3 & M4 Naval")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.M4_R2, "M4 R2")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.M4_R1, "M4 R1")){
            failCount++;
        }
        
        if ( ! testEnigmaRotorTypeModelValue(EnigmaRotorType.NONE, "")){
            failCount++;
        }
        
        assertEquals(0, failCount);
    }

   private boolean testEnigmaRotorTypeModelValue(EnigmaRotorType actual, String expected){
        System.out.printf(" - ValueOf Test : EnigmanRotorTypeModel = %s [%s]\n", actual.name(), actual.getModel());
        String model = actual.getModel();
        
        if (expected.equals(model)){
            return true;
        } else {
            System.out.printf("   FAILED: Expected = %s Actual =%s \n", expected, actual);
            return false;
        }
    }


    /**
     * Test of getModel method, of class EnigmaRotorType.
     */
    @Test
    public void testGetModel() {
        System.out.println("EnigmaRotorType 'setModel' Test");
        System.out.println("===============================");
        
        EnigmaRotorType instance = EnigmaRotorType.COMMERCIAL;
        String expResult = "Commercial Enigma A, B";
        String result = instance.getModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModel method, of class EnigmaRotorType.
     */
    @Test
    public void testSetModel() {
        System.out.println("EnigmaRotorType 'setModel' Test");

        EnigmaRotorType instance = EnigmaRotorType.COMMERCIAL;
        assertEquals("Commercial Enigma A, B", instance.getModel());
        
        String model = "Changed Model Value";
        instance.setModel(model);
        assertEquals(model, instance.getModel());

        model = "Commercial Enigma A, B";
        instance.setModel(model);
        assertEquals(model, instance.getModel());
    }

    /**
     * Test of isReflector method, of class EnigmaRotorType.
     */
    @Test
    public void testIsReflector() {
        System.out.println("EnigmaRotorType 'isReflector' Tests");
        System.out.println("===================================");

        int failCount = 0;

        if (!testIsReflectorRotorType(EnigmaRotorType.COMMERCIAL, false)) {
            failCount++;
        }

        if (!testIsReflectorRotorType(EnigmaRotorType.ROCKET, false)) {
            failCount++;
        }

        if (!testIsReflectorRotorType(EnigmaRotorType.SWISS_K, false)) {
            failCount++;
        }

        if (!testIsReflectorRotorType(EnigmaRotorType.ENIGMA_1, false)) {
            failCount++;
        }

        if (!testIsReflectorRotorType(EnigmaRotorType.M3_ARMY, false)) {
            failCount++;
        }

        if (!testIsReflectorRotorType(EnigmaRotorType.M3_M4_NAVAL, false)) {
            failCount++;
        }
        
        if (!testIsReflectorRotorType(EnigmaRotorType.M4_R1, false)) {
            failCount++;
        }
        
        if (!testIsReflectorRotorType(EnigmaRotorType.M4_R2, false)) {
            failCount++;
        }
        
        if (!testIsReflectorRotorType(EnigmaRotorType.NONE, true)) {
            failCount++;
        }
        
        assertEquals(failCount, 0);
//        fail(String.format("   FAILED %d isReflector tests.", failCount));
    }

    public boolean testIsReflectorRotorType(EnigmaRotorType rotorType, boolean isReflector ) {
        System.out.printf(" - IsReflector Test : EnigmanRotorType = %s [%s]\n", rotorType.name(), rotorType.getModel());
        if (isReflector == rotorType.isReflector()){
            return true;
        } else {
            System.out.printf("   FAILED: Expected = %s Actual =%s \n", isReflector, rotorType.isReflector());
            return false;
        }
    }
    
    
    
    /**
     * Test of setReflector method, of class EnigmaRotorType.
     */
    @Test
    public void testSetReflector() {
        System.out.println("EnigmaRotorType 'setReflector' Test");
        EnigmaRotorType instance = EnigmaRotorType.COMMERCIAL;
        
        boolean reflector = false;
        instance.setReflector(reflector);
        assertEquals(instance.isReflector(), reflector);
        
        reflector = true;
        instance.setReflector(reflector);
        assertEquals(instance.isReflector(), reflector);
    }
}
