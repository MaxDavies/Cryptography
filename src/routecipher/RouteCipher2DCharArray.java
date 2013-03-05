package routecipher;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevinlawrence
 */
public class RouteCipher2DCharArray {
    private Data[][] data;

    public RouteCipher2DCharArray(char[][] characterArray){
        data = new Data[characterArray.length][characterArray[0].length];

        for (int i = 0; i < characterArray.length; i++) {
            for (int j = 0; j < characterArray[0].length; j++) {
                this.data[i][j].setCharacter(characterArray[i][j]);
            }
        }
    }

    public boolean allProcessed(){
        boolean isProcessed = true;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++){
                isProcessed &= data[i][j].isProcessed();

                if (!isProcessed) {
                    break;
                }
            }
        }
        return isProcessed;
    }

    private class Data{
        private char character;
        private boolean processed = false;

        /**
         * @return the character
         */
        public char getCharacter() {
            return character;
        }

        /**
         * @param character the character to set
         */
        public void setCharacter(char character) {
            this.character = character;
        }

        /**
         * @return the processed
         */
        public boolean isProcessed() {
            return processed;
        }

        /**
         * @param processed the processed to set
         */
        public void setProcessed(boolean processed) {
            this.processed = processed;
        }
    }

}
