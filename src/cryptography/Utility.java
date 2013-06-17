/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author kevin.lawrence
 */
public class Utility {

    //<editor-fold defaultstate="collapsed" desc="Array Methods">
    public static String array2DToString(char[][] array) {
        String text = "";
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                text += array[row][column];
            }
        }
        return text;
    }

    public static char[][] stringTo2DArray(String str, int rows, int columns) {
        char[][] array = new char[rows][columns];
        int index = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (index < str.length()) {
                    array[row][column] = str.charAt(index);
                    index++;
                }
            }
        }
        return array;
    }

    public void printArray2D(char[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.printf("[%d, %d] = %s \n", row, column, array[row][column]);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods">
    public static int CHAR_RANGE = 26;
    public static int CHAR_BASE = 97;
    public static int LOWER_CHAR_BASE = 97;
    public static int UPPER_CHAR_BASE = 65;

    /**
     * Generate random char between the ordinal integer value rangeBase
     * and the ordinal integer value rangeBase + range
     * @param rangeBase the base value of the ordinal set
     * @param range 
     * @return
     */
    public static char getRandomCharacter(int rangeBase, int range) {
        return (char) ((int) ((Math.random() * range) + rangeBase));
    }

    /**
     * Generate random char between a and z
     *
     * @return
     */
    public static char getRandomLetter() {
        return getRandomCharacter(CHAR_BASE, CHAR_RANGE);
    }

    /**
     * Generate random char between lowercase 'a' and a lowercase 'z'
     *
     * @return
     */
    public static char getRandomLowerCaseLetter() {
        return getRandomCharacter(LOWER_CHAR_BASE, CHAR_RANGE);
    }

    /**
     * Generate random uppercase char between 'A' and 'Z'
     *
     * @return
     */
    public static char getRandomUpperCaseLetter() {
        return getRandomCharacter(UPPER_CHAR_BASE, CHAR_RANGE);
    }

    /**
     * Generate random integer between 0 and 9
     *
     * @return
     */
    public static int getRandomIntegerDigit() {
        return (int) getRandomInteger(0, 9);
    }

    /**
     * Generate random integer between minimum and maximum
     *
     * @param minimum the minimum value in the range of numbers to be returned
     * @param maximum the maximum value in the range of numbers to be returned
     * @return
     */
    public static int getRandomInteger(int minimum, int maximum) {
        return (int) ((Math.random() * (maximum - minimum)) + minimum);
    }
    //</editor-fold>    
}
