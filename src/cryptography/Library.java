/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author kevin.lawrence
 */
public class Library {

    //<editor-fold defaultstate="collapsed" desc="Arrays">
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
    /**
     * Generate random char between a and z
     *
     * @return
     */
    public static char getRandomLetter() {
        int CHAR_BASE = 97;
        int CHAR_RANGE = 26;

        return (char) ((int) ((Math.random() * CHAR_RANGE) + CHAR_BASE));
    }

    /**
     * Generate random integer between 0 and 10
     *
     * @return
     */
    public static int getRandomInteger() {
        return (int) getRandomInteger(0, 1);
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