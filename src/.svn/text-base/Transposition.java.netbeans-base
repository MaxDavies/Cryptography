/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevinlawrence
 */
public class Transposition {

        // "two can keep a secret if one is dead"
        // encode
        // =======================================
        // "t     n  e     s  r        e  s  e  "
        // " w  c     e  a  e  e  i  o        a "
        // "  o  a  k  p     c  t  f  n  i  d  d"

        // "t ne sr  ese"
        // "wc eaeeio  a"
        // "oakp ctfnidd"

        // "t ne sr  ese"
        //             "wc eaeeio  a"
        //                         "oakp ctfnidd"
        // "t ne sr  esewc eaeeio  aoakp ctfnidd"

    public static String encode(int rails, String plainText){
        String cipherText = "";
        int position;

        for (int rail = 0; rail < rails; rail++){
            position = rail;

            while (position < plainText.length()){
                cipherText += plainText.charAt(position);
                position += rails;
            }
        }
        return cipherText;
    }

    /**
     * @return the decoded PLAINTEXT string, given the CIPHERTEXT and the
     * number of rails.
     */
        // "two can keep a secret if one is dead"
        // decode
        // =======================================
        //  012345678901234567890123456789012345
        // "T ne sr  eseWc eaeeio  aOakp ctfnidd"
        //  t
        //   123456789012
        //              w
        //               123456789012
        //                          o
        //                           12345678901
        //  2
        // "t ne sr  esewC eaeeio  aoAkp ctfnidd"
        //  >*
        //    123456789012
        //               c
        //                123456789012
        //                           a
        //                            1234567890
        //  12
        // "t Ne sr  esewc eaeeio  aoaKp ctfnidd"
        //   >n
        //     123456789012
        //                *
        //                 123456789012
        //                            k
        //                             123456789
        //  012
        // "t ne sr  esewc eaeeio  aoakp ctfnidd"

        //  012345678901234567890123456789012345
        //   123456789012
        //               123456789012
        //                           12345678901
        //  2>
        //    123456789012
        //  0369        1470        2581
        // "t ne sr  ese"
        //             "wc eaeeio  a"
        //                         "oakp ctfnidd"
        // "t ne sr  esewc eaeeio  aoakp ctfnidd"
    public static String decode(int rails, String cipherText){
        int skipLength = cipherText.length() / rails;
        int longSkips = (cipherText.length() % rails);

        String plainText = "";
        int position = 0;
        int skips = 0;

        for (int i = 0; i < cipherText.length(); i++) {
            plainText += cipherText.charAt(position);

            // Increment the position by skiplength, but remember to add one for
            // those skips that must account for an "odd" number of characters
            // due to the uneven allocation of letters to the rails
            position += skipLength + ((skips % rails) < longSkips ? 1 : 0);

            // If we have passed the end of the array, this will wrap us back
            // around to the start; remember to add one to the position so that
            // we offset the start position of the next round through the cipher
            if (position >= cipherText.length()){
                position = (position % cipherText.length()) + 1;
            }

            skips++;
        }
        return plainText;
    }




    /**
     * @return the decoded PLAINTEXT string, given the CIPHERTEXT and the
     * number of rails.
     * This function only exists to check an alternate algorithm that I thought
     * might be logically clearer than that used in the decode method...
     * really should performance test both.
     */
        // "two can keep a secret if one is dead"
        // decode
        // =======================================
        //  012345678901234567890123456789012345
        // "T ne sr  eseWc eaeeio  aOakp ctfnidd"
        //  t
        //   123456789012
        //              w
        //               123456789012
        //                          o
        //                           12345678901
        //  2
        // "t ne sr  esewC eaeeio  aoAkp ctfnidd"
        //  >*
        //    123456789012
        //               c
        //                123456789012
        //                           a
        //                            1234567890
        //  12
        // "t Ne sr  esewc eaeeio  aoaKp ctfnidd"
        //   >n
        //     123456789012
        //                *
        //                 123456789012
        //                            k
        //                             123456789
        //  012
        // "t ne sr  esewc eaeeio  aoakp ctfnidd"

        //  012345678901234567890123456789012345
        //   123456789012
        //               123456789012
        //                           12345678901
        //  2>
        //    123456789012
        //  0369        1470        2581
        // "t ne sr  ese"
        //             "wc eaeeio  a"
        //                         "oakp ctfnidd"
        // "t ne sr  esewc eaeeio  aoakp ctfnidd"
    public static String decodeRailJump(int rails, String cipherText){
        int railLength = cipherText.length() / rails;
        int longRails = cipherText.length() % rails;

        String plainText = "";
        int position = 0;
        int rounds = 0;

        while (plainText.length() < cipherText.length()){

            for (int rail = 0; rail < rails; rail++){
                if (plainText.length() >= cipherText.length())
                    break;

                plainText += cipherText.charAt(position);
                position += railLength + ((rail < longRails) ? 1 : 0);
                position = (position % cipherText.length()) + ((position >= cipherText.length()) ? 1 : 0);
            }
        }
        return plainText;
    }

}
