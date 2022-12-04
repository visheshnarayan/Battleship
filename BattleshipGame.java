/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 11/2/22
 * -----------------------------------------------------------
 * BattleshipGame class to simulate game
 * -----------------------------------------------------------
 * Creates BattleshipGame object
 * -----------------------------------------------------------
 */
public class BattleshipGame {
    
    /**
     * private vars
     */
    private Ocean ocean;
    private int turns;
    private BattleshipPlayer player;

    /**
     * Constructor
     * initializes game attributes and creates ocean
     * @param player
     */
    public BattleshipGame (BattleshipPlayer player) {
        this.turns = 0;
        this.ocean = new Ocean();
        this.player = player;
        this.player.startGame();
        this.ocean.placeAllBoats();
    }

    /**
     * play
     * main method of game
     * game runs and loops until max turns or all boats hit
     * @return
     */
    public int play() {
        boolean game = true;
        boolean tooMany = false;
        while (game) {
            Position pos = player.shoot();
            ocean.shootAt(pos);
            boolean hit = ocean.hit(pos); 
            if (ocean.allSunk() || turns == 100) {
                game = false;
                tooMany = true;
            }
            player.updatePlayer(pos, hit, ocean.boatInitial(pos), ocean.boatName(pos), ocean.sunk(pos), game, tooMany, turns);
            turns+=1;
        }

        return turns-1;
    }
}
