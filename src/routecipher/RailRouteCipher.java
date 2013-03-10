/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package routecipher;

/**
 *
 * @author kevin.lawrence
 */
public class RailRouteCipher implements RouteCipher2D {
    
    /**
     *
     * @param rows
     * @param columns
     */
    public RailRouteCipher(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    

    /*
     *   two can keep a secret if one is dead
     * 
     *   12345657890123456578901234565789
     *   twocankeepasecretifoneisdead
     *      
     *   columns = 7, rows = 4
     * 
     *     0 1 2 3 4 5 6
     *  0  t w o c a n k
     *  1  e e p a s e c 
     *  2  r e t i f o n
     *  3  e i s d e a d
     * 
     *   output
     *   tereweeioptscaidasfeneoakcnd 
     * 
     *   columns = 4, rows = 7
     *     0 1 2 3
     *  0  t w o c
     *  1  a n k e
     *  2  e p a s
     *  3  e c r e
     *  4  t i f o
     *  5  n e i s
     *  6  d e a d
     * 
     *   output
     *   taeetndwnpcieeokarfiaceseosd
     */
    //<editor-fold defaultstate="collapsed" desc="Olde encode">
    
    public String encode2(String plainText) {
        String cipherText = "";
        // 1) create two dimesional array of size(columns, rows)
        char[][] cipher = new char[rows][columns];
        
        // 2) write the plainText string into the array
        //    across the columns, and down the rows
        int row = 0;
        int column = 0;
        for (int i = 0; i < plainText.length(); i++) {
            // get char at position"i"
            // put char in array at position row, column
            // if column is equal to columns (width of array),
            // then go the the start of the next row i.e.
            // set column = 0 , and row = row + 1
            if (this.isRemoveSpaces() && (plainText.charAt(i) != ' ')) { // do NOT  include spaces
                cipher[row][column] = plainText.charAt(i);
                column++;
            }
            
            if (column >= columns) {
                row++;
                column = 0;
            }
        }
        
        // TEST - print out the array
        for (int iRow = 0; iRow < cipher.length; iRow++) {
            for (int iColumn = 0; iColumn < cipher[iRow].length; iColumn++) {
                System.out.printf("[%d, %d] = %s \n", iRow, iColumn, cipher[iRow][iColumn]);
            }
        }
        
        // 3) read the cipherText down the rows, and across the columns
        for (int iColumn = 0; iColumn < cipher[0].length; iColumn++) {
            for (int iRow = 0; iRow < cipher.length; iRow++) {
                //add each char onto cipherText
                cipherText += cipher[iRow][iColumn];
                System.out.println("Partial = " + cipherText);
            }
        }
        
        // 4) return the cipherText!
        return cipherText;
    }
    //</editor-fold>

    public String encode(char[][] plainText, StartPoint startPoint) {
        return encode(Library.array2DToString(plainText));
    }

    
    public String encode(String plainText) {
        String cipherText = "";
        
        if (isRemoveSpaces()) {
            plainText = plainText.replaceAll(" ", "");
        }

        char[][] cipher = new char[rows][columns];
        int index = 0;

        while (index <= plainText.length()) {
            // write the plainText string into the array
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    cipher[row][column] = (index >= plainText.length()) ? Library.getRandomLetter() : plainText.charAt(index);
                    index++;
                }
            }

            // read the cipherText down the rows, and across the columns
            for (int column = 0; column < cipher[0].length; column++) {
                for (int row = 0; row < cipher.length; row++) {
                    cipherText += cipher[row][column];
                }
            }
        }
        return cipherText;
    }

    public char[][] decode(String cipherText, StartPoint startPoint, int columns, int rows) {
        String plainText = decode(cipherText);
        
        return Library.stringTo2DArray(plainText, rows, columns);
    }

    public String decode(String cipherText) {
        String plainText= "";
        char[][] array = new char[rows][columns];
        int index = 0;
        
        while (index < cipherText.length()){
            //write the string into the decode array vertically
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    array[row][column] = cipherText.charAt(index);
                }
            }
            
            //read the data out of the decode array horizontally
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    plainText += array[row][column];
                }
            }
        }
        return plainText;
    }

//  <editor-fold defaultstate="Collapsed" desc="Properties">
    private int rows, columns;
    private boolean removeSpaces = true;

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * @return the removeSpaces
     */
    public boolean isRemoveSpaces() {
        return removeSpaces;
    }

    /**
     * @param removeSpaces the removeSpaces to set
     */
    public void setRemoveSpaces(boolean removeSpaces) {
        this.removeSpaces = removeSpaces;
    }
//  </editor-fold>  
}
