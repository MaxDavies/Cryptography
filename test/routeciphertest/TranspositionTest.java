package routeciphertest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import routecipher.Transposition;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author kevinlawrence
 */
public class TranspositionTest {

//    public TranspositionTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
    //http://www.samsimpson.com/static/cquotes
    //        "Furem fur cognoscit et lupum lupus. " -> "A thief recognises a thief and a wolf a wolf." - Anon
    //        "I think there's a world market for about five computers." - Watson, Thomas (Founder of IBM)
    //        "I apprehend no danger to our country from a foreign foe... Our destruction, should it come at all, will be from another quarter. From the inattention of the people to the concerns of their government, from their carelessness and negligence, I must confess that I do apprehend some danger." - Daniel Webster, June 1, 1837

    //        "There's no way to rule innocent men. The only power an y government has is the power to crack down on criminals. Well, when there aren' t enough criminals, one makes them. One declares so many things to be a crime that it becomes impossible to live without breaking laws." - Ayn Rand, "Atlas Shrugged"

    //        "Necessity is the plea for every infringement of human freedom. It is the argument of tyrants; it is the creed of slaves." - William Pitt, British Prime Minister, November 18, 1783

    //        "Individual rights are not subject to a public vote; a majority has no right to vote away the rights of a minority; the political funct ion of rights is precisely to protect minorities from oppression by majorities ( and the smallest minority on earth is the individual)" -Ayn Rand
    //        "Civilization is the progress toward a society of priva cy. The savage's whole existence is public, ruled by the laws of his tribe. Civilization is the process of setting man free from men" - Ayn Rand, The Fountainhead (1943)
    //        "Whoever would overthrow the liberty of a nation must b egin by subduing the freeness of speech." - Benjamin Franklin
    //        "They that give up essential liberty to obtain a little temporary safety deserve neither liberty nor safety." - Benjamin Franklin
    //        "The greatest calamity which could befall us would be s ubmission to a government of unlimited powers." -Thomas Jefferson, 1825
    //        "The best system is to use a simple, well understood al gorithm which relies on the security of a key rather than the algorithm itself. This means if anybody steals a key, you could just roll another and they have to start all over." - Andrew Carol. Amen!
    //        "Quis Custodiet Ipsos Custodes." -> "Who will watch the watchmen." - Juvenal, circa 128 AD
    //        "I would rather be exposed to the inconveniences attend ing too much liberty than those attending too small a degree of it." - Thomas Jefferson
    //        "Nearly all men can stand adversity, but if you want to test a man's character, give him power." - Abraham Lincoln
    //        "Few false ideas have more firmly gripped the minds of so many intelligent men than the one that, if they just tried, they could invent a cipher that no one could break." - David Kahn
    //        As soon as men decide that all means are permitted to fight an evil, then their good becomes indistinguishable from the evil that they set out to destroy Christopher Dawson, The Judgment of Nations, 1942
    //        "Within Europe, all email, telephone, and fax communications are routinely intercepted by the United States National Security Agency" - European Parliament report "Assessing the Technologies of Political Control"

    /**
     * Test of encode method, of class Transposition.
     */
    @Test
    public void testEncode() {
        System.out.println("encode");

        String plainText = "two can keep a secret if one is dead";
        String expResult = "t ne sr  esewc eaeeio  aoakp ctfnidd";
        int rails = 3;

        String cipherText = Transposition.encode(rails, plainText);
        assertEquals(expResult, cipherText);
    }

    /**
     * Test of decode method, of class Transposition.
     */
    @Test
    public void testDecode() {
        System.out.println("decode");

        String cipherText = "t ne sr  esewc eaeeio  aoakp ctfnidd";
        String expectedPlainText = "two can keep a secret if one is dead";
        int rails = 3;

        String plainText = Transposition.decode(rails, cipherText);
        assertEquals(expectedPlainText, plainText);
    }

    /**
     * Test of encode and decode methods, of class Transposition.
     */
    @Test
    public void testEncodeDecode() {
        System.out.println("encode/decode");
        String plainText = "two can keep a secret if one is dead";
        int rails = 3;

        String decodedPlainText = Transposition.decode(rails, Transposition.encode(rails, plainText));
        assertEquals(decodedPlainText, plainText);
    }

    /**
     * Test of encode and decode methods, of class Transposition.
     */
    @Test
    public void testRails() {
        System.out.println("rails");
        String plainText = "I apprehend no danger to our country from a foreign foe... Our destruction, should it come at all, will be from another quarter. From the inattention of the people to the concerns of their government, from their carelessness and negligence, I must confess that I do apprehend some danger. - Daniel Webster, June 1, 1837";

        for (int rails = 1; rails <= 100; rails++) {
            String decodedPlainText = Transposition.decode(rails, Transposition.encode(rails, plainText));
            assertEquals(decodedPlainText, plainText);
        }
    }

    /**
     * Test of encode and decode methods for different number of rails, of class Transposition.
     */
    @Test
    public void testEncodeDecodeRailJump() {
        System.out.println("encode/decode rail jump");
        String plainText = "two can keep a secret if one is dead";

        String encodedPlainText = Transposition.encode(3, plainText);
        String decodedPlainText = Transposition.decodeRailJump(3, encodedPlainText);
        assertEquals(decodedPlainText, plainText);
    }
    
//    /**
//     * Test of getRails method, of class Transposition.
//     */
//    @Test
//    public void testGetRails() {
//        System.out.println("getRails");
//        Transposition instance = new Transposition();
//        int expResult = 0;
//        int result = instance.getRails();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setRails method, of class Transposition.
//     */
//    @Test
//    public void testSetRails() {
//        System.out.println("setRails");
//        int rails = 0;
//        Transposition instance = new Transposition();
//        instance.setRails(rails);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
