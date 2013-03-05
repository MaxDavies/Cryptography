package routecipher;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevinlawrence
 */
public class Point {
    private int x;
    private int y;

    Point(){}
    
    Point(int x, int y){
        setLocation(x, y);
    }


    public void move(Direction direction){
        switch (direction){
            case EAST:
                this.x++;
                break;

            case WEST:
                this.x--;
                break;

            case NORTH:
                this.y--;
                break;

            case SOUTH:
                this.y++;
                break;
        }
    }

//  <editor-fold defaultstate="Collapsed" desc="Properties">
    /**
     * @param x the x to set
     * @param y the y to set
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
//  </editor-fold>
}
