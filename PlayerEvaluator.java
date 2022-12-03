public class PlayerEvaluator {

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE; 
    private double average = (maxTurns()+minTurns())/2;

    public PlayerEvaluator() {
        int run = 0;
        while (run < 1000) {
            BattleshipPlayerComputer player = new BattleshipPlayerComputer();
            BattleshipGame game = new BattleshipGame(player);
            int turns = game.play();

            if (turns > max) max=turns;
            if (turns < min) max=turns;
        }
    }

    public int maxTurns() {
        return max;
    }

    public int minTurns() {
        return min;
    }

    public double averageTurns() {
        return average;
    }
}