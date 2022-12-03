/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 12/2/22
 * -----------------------------------------------------------
 * BattleshipPlayerComputer class to simulate computer 
 * -----------------------------------------------------------
 * Creates BattleshipPlayerComputer object
 * -----------------------------------------------------------
 */

// inherits BattleshipPlayer
public class BattleshipPlayerComputer extends BattleshipPlayer {

    /**
     * private vars
     */
    private String name = "AI from AI Club";
    private BattleshipGrid grid;

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
    public String playerName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     * CHILD CLASS DIFFERENCE::randomly chooses positions until empty spot is found
     */
    public Position shoot() {
        // initialize position
        Position pos;

        // repeatedly create position until empty spot is found
        do {
            int row = (int) (Math.random()*10 + 0.5);
            int column = (int) (Math.random()*10 + 0.5);
            pos = new Position(row, column);
        } while (!grid.empty(pos));
        return pos;
    }
}
