/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/2/22
 * -----------------------------------------------------------
 * BattleshipPlayerComputer class for testing game
 * BattleshipPlayer child class
 * Used with PlayerEvaluator.java to automate testing
 * -----------------------------------------------------------
 * Creates BattleshipPlayerComputer object
 * -----------------------------------------------------------
 */

// inherits BattleshipPlayer
public class BattleshipPlayerComputer extends BattleshipPlayer {

    /**
     * private vars
     */
    private String name;
    private BattleshipGrid grid;
    // tracking if all spots are hit
    private int spots;

    /**
     * {@inheritDoc}
     */
    public BattleshipPlayerComputer() {
    }

    /**
     * {@inheritDoc}
     * CHILD CLASS DIFFERENCE::does not ask player name
     */
    public void startGame() {
        name = "AI (from AI Club)";
        this.spots = 0;
        this.grid = new BattleshipGrid();
    }

    /**
     * {@inheritDoc}
     * CHILD CLASS DIFFERENCE::does not output board
     */
    public void updatePlayer(Position pos, boolean hit, char initial) {
        updateGrid(pos, hit, initial);
    }

    /**
     * {@inheritDoc}
     */
    protected void updateGrid(Position pos, boolean hit, char initial) {
        grid.shotAt(pos, hit, initial);
    }

    /**
     * {@inheritDoc}
     */
    public String playerName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     * CHILD CLASS DIFFERENCE::randomly chooses positions until empty spot is found
     */
    public Position shoot() {
        Position pos;
        
        // repeatedly create position until empty spot is found
        spots++;
        do {
            int row = (int) (Math.random()*10 + 1);
            int column = (int) (Math.random()*10 + 1);
            pos = new Position(row, column);
        } while (!grid.empty(pos) && spots < 100);
        return pos;
    }

    /**
     * {@inheritDoc}
     */
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
        updateGrid(pos, hit, initial);
    }
}