/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 9/9/22
 * -----------------------------------------------------------
 * Position class for BattleShip game
 * -----------------------------------------------------------
 * Simulates position on BattleShip board
 * -----------------------------------------------------------
 */

public class Position {

    private char row;
    private int column;

    /**
     * Constructor for (char, int) arguments
     * @param row (char)
     * @param column (int)
     */
    public Position(char row, int column) {
        this.row = Character.toUpperCase(row);
        this.column = column;
    }

    /**
     * Constructor for (char, int) arguments
     * 
     * ROW: A = 1, B = 2, C = 3... J = 10
     * @param row (int)
     * @param column (int)
     */
    public Position(int row, int column) {
        this.row = (char) (64 + row);
        this.column = column;
    }

    /**
     * Returns row
     * @return (char)
     */
    public char row() {
        return this.row;
    }

    /**
     * Returns column
     * @return (int)
     */
    public int column() {
        return this.column;
    }

    /**
     * Returns row index 
     * @return (int)
     */
    public int rowIndex() {
        int index = row() - 65;
        return index;
    }

    /**
     * Returns column index
     * @return (int)
     */
    public int columnIndex() {
        return (column() - 1);
    }

    /**
     * toString()
     * outputted String when attempting to print object
     * @return String
     */
    public String toString() {
        String pos = this.row + "-" + this.column;
        return pos;
    }
}