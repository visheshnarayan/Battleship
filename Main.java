/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 9/9/22
 * -----------------------------------------------------------
 * Tester class for BattleShip game
 * -----------------------------------------------------------
 * Tests classes for BattleShip game
 * -----------------------------------------------------------
 */

public class Main {
    
    public static void main(String [] args) {
        /**
         * Evaluator
         * 1000 runs
         */
        PlayerEvaluator eval = new PlayerEvaluator();
        System.out.println("max::"+eval.maxTurns());
        System.out.println("min::"+eval.minTurns());
        System.out.println("average::"+eval.averageTurns());
    }
}