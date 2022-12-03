/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 9/13/22
 * -----------------------------------------------------------
 * Boat class for BattleShip game
 * -----------------------------------------------------------
 * Simulates Boat on BattleShip board
 * -----------------------------------------------------------
 */
import java.util.ArrayList;

public class Boat {

    /**
     * private attributes
     */
    private String type;
    private int size;
    private Position pos;
    private boolean orientation;
    private ArrayList<Position> hits = new ArrayList<Position>();

    /**
     * Constructor
     * @param type
     * @param pos
     * @param orientation
     */
    public Boat(String type, Position pos, String orientation) {
        this.type = type;
        this.pos = pos;

        /**
         * boolean orientation
         * true = vertical
         * false = horizontal
         */
        if (orientation.equals("vertical")) {
            this.orientation = true;
        } else {
            this.orientation = false;
        }

        /**
         * int size
         * size derived from calculating boat size based on type of boat
         */
        this.size = calcSize(this.type);
    }

    /**
     * getType: gets type of boat
     * @return type of boat
     */
    public String getType() {
        return type;
    }

    /**
     * abreviation: gets first letter of boat type
     * @return first letter of boat type in uppercase
     */
    public String abreviation() {
        return type.substring(0, 1).toUpperCase();
    }

    /**
     * calcSize: calculates size of boat based on type
     * @param type
     * @return size of boat (int)
     */
    public int calcSize(String type) {
        /**
         * checking if type is equal to specific boat types
         * return size based on type
         */
        if (type.equals("Aircraft Carrier")) {
            return 5;
        } else if (type.equals("Battleship")) {
            return 4;
        } else if (type.equals("Cruiser") || type.equals("Submarine")) {
            return 3;
        } else {
            return 2;
        }
    }
    
    /**
     * getSize: gets size of boat
     * @return size of boat (int)
     */
    public int getSize() {
        return size;
    }

    /**
     * hit: checks if passed position will hit boat
     * @param pos
     * @return true --> boat was hit, false --> boat was not hit (boolean)
     */
    public boolean hit(Position pos) {
        if (onBoat(pos)) {
            /**
             * adding position to hits list to keep track of hits
             */
            addPos(pos);
            return true;
        }
        return false;
    }
    
    /**
     * isHit: checks if boat has been hit in given place already
     * @param pos
     * @return true --> boat has been hit in given place, false --> boat has not been hit in given place (boolean)
     */
    public boolean isHit(Position pos) {
        /**
         * iterating through each hit
         */
        for (Position position: hits) {
            if (position.equals(pos)) {
                return true;
            }
        }
        return false;
    }

    /**
     * sunk: checks if boat has sunk by checking number of hits (hits only registered if onBoat() = true)
     * @return true --> boat has sunk, false --> boat has not sunk
     */
    public boolean sunk() {
        return (size==hits.size());
    }

    /**
     * getPosition: gets position of boat
     * @return position object representing boat position (Position)
     */
    public Position getPosition() {
        return pos;
    }

    /**
     * getDirection: gets direction of boat
     * @return true --> boat vertical, false --> boat horizontal (Boolean)
     */
    public boolean getDirection() {
        return orientation;
    }

    /**
     * equals: overriden Java method to check if boats are the same
     * @param pos
     * @return
     */
    public boolean equals(Boat boat) {
        return this == boat;
    }

    /**
     * onBoat: checks if boat overlaps with given position
     * @param pos
     * @return
     */
    private boolean onBoat(Position pos) {
        boolean overlap;
        /**
         * if boat vertical; else horizontal
         */
        if (orientation) {
            /**
             * check if given position overlaps anywhere in vertical range
             */
            overlap = verticalCalc(pos);
            if (overlap) {
                return true;
            }
            return false;
        } else {
            /**
             * check if given position overlaps anywhere in horizontal range
             */
            overlap = horizontalCalc(pos);
            if (overlap) {
                return true;
            }
            return false;
        }
    }

    /**
     * verticalCalc: checks if position given overlaps with vertical boat 
     * @param pos
     * @return true --> given position overlaps with vertical boat, false --> given position does not overlap with vertical boat
     */
    private boolean verticalCalc(Position pos) {
        /**
         * check if given position is within same column
         */
        if (pos.columnIndex()!=this.pos.columnIndex()) {
            return false;
        } else {
            /**
             * check if given position is in range bottom to top of boat
             */
            int top = this.pos.rowIndex();
            int bottom = top + size;
            if (top <= pos.rowIndex() && bottom > pos.rowIndex()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * horizontalCalc: checks if position given overlaps with horizontal boat 
     * @param pos
     * @return true --> given position overlaps with horizontal boat, false --> given position does not overlap with horizontal boat
     */
    private boolean horizontalCalc(Position pos) {
        /**
         * check if given position is within same row
         */
        if (pos.rowIndex()!=this.pos.rowIndex()) {
            return false;
        } else {
            /**
             * check if given position is in range left to right of boat
             */
            int right = this.pos.columnIndex();
            int left = right - size;
            if (right >= pos.rowIndex() && left < pos.rowIndex()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * addPos: adds given position to list of hits
     * @param pos
     */
    private void addPos(Position pos) {
        hits.add(pos);
    }
}