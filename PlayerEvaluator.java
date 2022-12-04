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
public class PlayerEvaluator {

    /**
     * Global vars
     */
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE; 
    private int total;

    public PlayerEvaluator() {
        // run number 
        int run = 0;

        // total turns in all testing
        total = 0;

        // run loop 
        while (run < 1000) {
            // intialize game
            BattleshipPlayerComputer player = new BattleshipPlayerComputer();
            BattleshipGame game = new BattleshipGame(player);

            // turns returned after game ends
            int turns = game.play();

            // update min and max
            if (turns > max) max=turns;
            if (turns < min) min=turns;

            // update loop
            run++;

            // update total for average
            total += turns;

            // output formatting 
            if (run < 10) {
                System.out.println("Run " + run + "    ===> " + turns + " turns");    
            } else if (run >= 10 && run < 100) {
                System.out.println("Run " + run + "   ===> " + turns + " turns");
            } else if (run >= 100 && run < 1000){
                System.out.println("Run " + run + "  ===> " + turns + " turns");
            } else {
                System.out.println("Run " + run + " ===> " + turns + " turns");
            }
        }
        // constructor intialization complete 
        System.out.println("\n################# 1000 runs completed successfully #################\n");
    }

    /**
     * maxTurns() 
     * returns max number of turns in 1000 runs
     * @return int
     */
    public int maxTurns() {
        return max;
    }

    /**
     * minTurns()
     * returns min number of turns in 1000 runs
     * @return int
     */
    public int minTurns() {
        return min;
    }

    /**
     * averaegeTurns()
     * returns average turns from 1000 runs
     * @return double
     */
    public double averageTurns() {
        return (total)/1000;
    }
}