/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 9/19/22
 * -----------------------------------------------------------
 * BattleshipGrid class for BattleShip game
 * -----------------------------------------------------------
 * Simulates grid for BattleShip game
 * -----------------------------------------------------------
 */
public class BattleshipGrid {

    /**
     * implemented 3D array to similate board and store information about spot state
     * similar to using paired values (python dict or java HashMap) as third dimension
     * used integer to represent different states due to data type conflict in java
     * 
     * grid[row][column][0] = if spot has been shot at --> 1, 0 otherwise
     * grid[row][column][1] = if spot has been shot at and boat was hit--> 1, 0 otherwise
     * grid[row][column][2] = initial of boat --> stored as char ascii
     */
    private int grid[][][];

    /**
     * Constructor
     */
    public BattleshipGrid() {
        grid = new int[10][10][3];
    }

    /**
     * shotAt: updates grid spot state
     * updates third dimension of grid representing various states of board
     * @param pos Position representing spot on board
     * @param hit true or false
     * @param initial first letter of boat name (char)
     */
    public void shotAt(Position pos, boolean hit, char initial) {
        int row = pos.rowIndex();
        int column = pos.columnIndex();
        grid[row][column][0] = 1;
        if (hit) {
            grid[row][column][1] = 1;
            grid[row][column][2] = initial;
        }
    }

    /**
     * hit: returns true if spot has been shot at and hit, false otherwise
     * @param pos Position representing spot on board
     * @return true if spot was shot at and hit, false otherwise
     */
    public boolean hit(Position pos) {
        // no need to check spot hit state, if a boat was hit --> shot at state will be 1
        if (grid[pos.rowIndex()][pos.columnIndex()][1]==1) {
            return true;
        }
        return false;
    }

    /**
     * miss: returns true if spot has been shot at and was a miss, false otherwise
     * @param pos Position representing spot on board
     * @return true if spot was shot at and was missed, false otherwise
     */
    public boolean miss(Position pos) {
        // checking if spot is shot at and if boat was hit
        if(grid[pos.rowIndex()][pos.columnIndex()][0]==1&&grid[pos.rowIndex()][pos.columnIndex()][1]==0) {
            return true;
        }
        return false;
    }

    /**
     * empty: returns true if spot has not been shot at
     * @param pos Position representing spot on board
     * @return true if spot has not been shot at, false otherwise
     */
    public boolean empty(Position pos) {
        if(grid[pos.rowIndex()][pos.columnIndex()][0]==0) {
            return true;
        }
        return false;
    }

    /**
     * boatInitial: gets initial of boat that has been hit at pos
     * method is only called if boat has been hit there
     * @param pos Position representing spot on board
     * @return boat initial (char)
     */
    public char boatInitial(Position pos) {
        return (char) grid[pos.rowIndex()][pos.columnIndex()][2];
    }
}