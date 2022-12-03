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
        // evaluator 
        PlayerEvaluator eval = new PlayerEvaluator();

        for (int i = 0; i < 5; i++) {
            System.out.println("max::"+eval.maxTurns());
            System.out.println("min::"+eval.minTurns());
            System.out.println("max::"+eval.averageTurns());
        }

    }
}