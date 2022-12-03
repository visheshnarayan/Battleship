/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 9/19/22
 * -----------------------------------------------------------
 * Ocean class for BattleShip game
 * -----------------------------------------------------------
 * Simulates ocean for BattleShip game
 * -----------------------------------------------------------
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Ocean {

    /**
     * global variables
     */
    private Boat board[][];
    private ArrayList<Boat> boats;
    // private ArrayList<Position> hits = new ArrayList<Position>();
    private ArrayList<String> hits = new ArrayList<String>();

    /**
     * Constructor
     */
    public Ocean() {
        board = new Boat[10][10];
        boats = new ArrayList<Boat>();
    }

    /**
     * placeBoat: places boat on given spot
     * throws exception if boat is off of board
     * if boat overlaps with another boat, ends method
     * @param name Aircraft Carrier, Battleship, Cruiser, Submarine
     * @param orientation vertical, horizontal
     * @param pos Position object describing position on board
     * @throws Exception if position given is outside of board index (1 - 10 inclusive)
     */
    public void placeBoat(String name, String orientation, Position pos) throws IndexOutOfBoundsException {
        Boat boat = new Boat(name, pos, orientation);
        int row = boat.getPosition().rowIndex();
        int column = boat.getPosition().columnIndex();

        /**
         * IndexOutOfBounds exception
         * checks if top/right is out of bounds and if bottom/left is out of bounds
         */
        boolean flag;
        if ("vertical".equals(orientation)) {
            flag = (row < 0 || row > 9) || (row + boat.getSize() - 1 < 0 || row + boat.getSize() - 1> 9);
        } else {
            flag = (column < 0 || column > 9) || (column - boat.getSize() + 1 < 0 || column - boat.getSize() + 1 > 9);
        }

        if (flag) {
            throw(new IndexOutOfBoundsException());
        }

        /**
         * look at all spots where boat will be placed
         * if a spot is not null (an object is present) stop method
         * if method is not stopped, all spots are free and boat object is placed in each square to represent boat's size
         */
        if (orientation.equals("vertical")) {
            for (int i = row; i < row+boat.getSize(); i++) {
                if (board[i][column]!=null) {
                    // System.out.println(("Placing boat at " + pos + " will overlap with boat at " + board[i][column].getPosition() + ", try another spot."));
                    return;
                }
            }
            for (int i = row; i < row+boat.getSize(); i++) {
                board[i][column] = boat;
            }
        } else {
            for (int i = column; i > column-boat.getSize(); i--) {
                if (board[row][i]!=null) {
                    // System.out.println(("Placing boat at " + pos + " will overlap with boat at " + board[row][i].getPosition() + ", try another spot."));
                    return;
                }
            }
            for (int i = column; i > column-boat.getSize(); i--) {
                board[row][i] = boat;
            }
        }
        boats.add(boat);
    }

    /**
     * placeAllBoats: places 4 boats of each type at random locations
     * repeat try catch until placed = true if randomized boat is in list of boats 
     */
    public void placeAllBoats() {
        ArrayList<String> types = new ArrayList<String>(
            Arrays.asList("Aircraft Carrier", "Battleship", "Cruiser", "Submarine")
        );
        
        // repeat through each type of boat
        for (int i = 0; i < types.size(); i++) {

            // boolean to determine if boat is placed
            boolean placed = false;
            while (!placed) {
                try {
                    // randomized boat position orientation
                    int row = (int) (Math.random()*10 + 0.5);
                    int column = (int) (Math.random()*10 + 0.5);
                    String orientation;

                    if (((Math.random()+0.5)) > 1) {
                        orientation = "vertical";
                    } else {
                        orientation = "horizontal";
                    }

                    /**
                     * place boat
                     * boolean will turn true if no errors or overlaps happen in placeBoat()
                     * check if boat is in boats list
                     */
                    placeBoat(types.get(i), orientation, new Position(row, column));
                    // fix boolean
                    if (boats.size()==i+1) {
                        placed = true;
                    }
                } catch (Exception IndexOutOfBoundsException) {}
            }
        }
        // System.out.println("Board: ");
        // showBoard();
    }

    /**
     * shootAt: shoots at position and records boat hits if boat has been hit
     * @param pos
     */
    public void shootAt(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()]!=null) {
            hits.add(pos.toString());
        }
    }

    /**
     * hit: checks if position given has been hit
     * @param pos
     * @return true if position has been hit, false otherwise
     */
    public boolean hit(Position pos) {
        return Arrays.stream(hits.toArray()).anyMatch(pos.toString()::equals); 
    }

    /**
     * boatInitial: finds initial of boat hit at given position; assumes given position is a spot where a boat has been hit
     * @param pos
     * @return initial of boat (char)
     */
    public char boatInitial(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()]!=null) {
            return (board[pos.rowIndex()][pos.columnIndex()].abreviation()).charAt(0);
        }
        return ' ';
    }

    /**
     * boatName: gets boat name of boat that has been hit at given position; assumes given position is a spot where a boat has been hit
     * @param pos
     * @return name of boat (String)
     */
    public String boatName(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()]!=null) {
            return board[pos.rowIndex()][pos.columnIndex()].getType();
        }
        return "";
    }

    /**
     * sunk: checks if boat at given position is sunk
     * @param pos
     * @return true if boat is sunk, false otherwise
     */
    public boolean sunk(Position pos) {
        if (board[pos.rowIndex()][pos.columnIndex()]!=null) {
            return board[pos.rowIndex()][pos.columnIndex()].sunk();
        }
        return false;
    }

    /**
     * allSunk: checks if all boats have been sunk
     * @return true if all boats are sunk; false otherwise
     */
    public boolean allSunk() {
        for (Boat boat: boats) {
            if (!boat.sunk()) {
                return false;
            }
        }
        return true;
    }
}