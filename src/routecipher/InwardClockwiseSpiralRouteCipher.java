package routecipher;


import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevinlawrence
 */
public class InwardClockwiseSpiralRouteCipher implements RouteCipher2D {
    /*
     *      2D array x = n, y = m [generalized start (anywhere): do this later]
     *
     *      y / x   0   1   2   ... n-1
     *      0   >   \   s   >   >   |
     *      1   ^       >   >   >   |
     *      2   |   <   <   <   <   <
     *      ...
     *      m-1
     */


    /*
     *      2D array x = n, y = m [corner start]
     *
     *      y / x   0   1   2   ... n-1
     *      0   s   >   >   >   >   |
     *      1   >   >   >   >   |   |
     *      2   |   >   >   E   |   |
     *      ... |   |   <   <   <   |
     *      m-1 |   <   <   <   <   <
     */

//    public String encode(String plainText, int gridSizeColumns, int gridSizeRows){
//         String cipherText = "";
//         return cipherText;
//    }

    private RouteCipherData[][] assignRouteCipherData(char[][] plainText) {
        RouteCipherData[][] routeCipherData = new RouteCipherData[plainText.length][plainText[0].length];

        for (int i = 0; i < plainText.length; i++) {
            for (int j = 0; j < plainText[0].length; j++) {
                routeCipherData[i][j] = new RouteCipherData(plainText[i][j]);
            }
        }
        return routeCipherData;
    }

    private void walkRouteCipher(char[][] plainText, StartPoint startPoint, RouteCipherDataProcessor processor){
        RouteCipherData[][] plainTextData = assignRouteCipherData(plainText);

        Direction direction;
        int x, y;

        switch (startPoint) {
            case NORTH_WEST:
                x = 0;
                y = 0;
                direction = Direction.EAST;
                break;

            case NORTH_EAST:
                x = plainText.length - 1;
                y = 0;
                direction = Direction.SOUTH;
                break;

            case SOUTH_EAST:
                x = plainText.length - 1;
                y = plainText[0].length - 1;
                direction = Direction.WEST;
                break;

            case SOUTH_WEST:
                x = 0;
                y = plainText[0].length - 1;
                direction = Direction.NORTH;
                break;

            default:
                x = 0;
                y = plainText[0].length - 1;
                direction = Direction.NORTH;
                break;
        }

        Point current = new Point(x, y);
        /*
         *  Start at point, exvery time change direction, subtract one from the
         *  directionLimit, procede in that direction until limit (might also
         *  want to have extra safety of array size - superfluous?), turn...
         */
//        String cipherText = "";
        boolean complete = false;

        /* if    current processed then finished
         * else  concatenate
         *      if at end of line (last cell, or next cell is processed) ... call this "can move"?
         *         move in current direction
         *      else
         *         roate direction, move if possible... if not, finished
         * else  if at end of line
         */

        while (!complete) {
            if (plainTextData[current.getX()][current.getY()].isProcessed()) {
                complete = true;
            } else {

                processor.process(plainTextData , current);

                switch (direction) {
                    case EAST:
                        if ((current.getX() == plainTextData.length - 1)
                                || (plainTextData[current.getX() + 1][current.getY()].isProcessed())) {
                            direction = Direction.SOUTH;
                        }
                        break;

                    case SOUTH:
                        if ((current.getY() == plainTextData[0].length - 1)
                                || (plainTextData[current.getX()][current.getY() + 1].isProcessed())) {
                            direction = Direction.WEST;
                        }
                        break;

                    case WEST:
                        if ((current.getX() == 0)
                                || (plainTextData[current.getX() - 1][current.getY()].isProcessed())) {
                            direction = Direction.NORTH;
                        }
                        break;

                    case NORTH:
                        if ((current.getY() == 0)
                                || (plainTextData[current.getX()][current.getY() - 1].isProcessed())) {
                            direction = Direction.EAST;
                        }
                        break;
                }
                current.move(direction); //i is this fragile for a single cell grid... would anyone do that?
            }
        }
//        return cipherText;
    }

    private interface RouteCipherDataProcessor {
        public void process(RouteCipherData[][] routeCipherData, Point currentPosition);
    }

    private class CipherTextProcessor implements RouteCipherDataProcessor {
        private String cipherText = "";

        public void process(RouteCipherData[][] plainTextData, Point currentPosition){
            this.setCipherText(this.getCipherText() + plainTextData[currentPosition.getX()][currentPosition.getY()].getCharacter());
            plainTextData[currentPosition.getX()][currentPosition.getY()].setProcessed(true);
        }

        /**
         * @return the cipherText
         */
        public String getCipherText() {
            return cipherText;
        }

        /**
         * @param cipherText the cipherText to set
         */
        public void setCipherText(String cipherText) {
            this.cipherText = cipherText;
        }
    }

    public String encode(char[][] plainText, StartPoint startPoint) {
        CipherTextProcessor cipherTextProcessor = new CipherTextProcessor();
        walkRouteCipher(plainText, startPoint, cipherTextProcessor);
        return cipherTextProcessor.getCipherText();
    }

    private class EncodePathProcessor implements RouteCipherDataProcessor{
        private ArrayList<Point> encodePath = new ArrayList<Point>();

        public void process(RouteCipherData[][] plainTextData, Point currentPosition){
            getEncodePath().add(new Point(currentPosition.getX(), currentPosition.getY()));
        }

        /**
         * @return the encodePath
         */
        public ArrayList<Point> getEncodePath() {
            return encodePath;
        }
    }

    public char[][] decode(String cipherText, StartPoint startPoint, int columns, int rows) {
        /*  1) Accept   - enciphered string
         *              - start point
         *              - grid size (cols, rows)
         *
         *  2) Use starting point and grid to compute path from the start point
         *     to the end point, will get list of vectors (Direction, MoveCount)
         *     that we will use to walk back to distribute the characters.
         */

        char[][] plainText = new char[columns][rows];
        EncodePathProcessor encodePathProcessor = new EncodePathProcessor();

        walkRouteCipher(plainText, startPoint, encodePathProcessor);
        //TODO - finish validating and implementing this logic

        for (int i = 0; ((i < encodePathProcessor.getEncodePath().size()) && (i < cipherText.length())); i++){
            plainText[encodePathProcessor.getEncodePath().get(i).getX()][encodePathProcessor.getEncodePath().get(i).getY()] = cipherText.charAt(i);
        }
        return plainText;
    }

}
