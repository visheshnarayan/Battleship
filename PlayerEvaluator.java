public class PlayerEvaluator {

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE; 
    private int total;

    public PlayerEvaluator() {
        int run = 0;
        total = 0;
        while (run < 100) {
            BattleshipPlayerComputer player = new BattleshipPlayerComputer();
            BattleshipGame game = new BattleshipGame(player);
            int turns = game.play();

            if (turns > max) max=turns;
            if (turns < min) min=turns;

            run++;
            total += turns;
            if (run < 10) {
                System.out.println("Run " + run + "   ===> " + turns + " turns");    
            } else if (run >= 10 && run != 100) {
                System.out.println("Run " + run + "  ===> " + turns + " turns");
            } else {
                System.out.println("Run " + run + " ===> " + turns + " turns");
            }
        }
        System.out.println("\n################# 100 runs completed successfully #################\n");
    }

    public int maxTurns() {
        return max;
    }

    public int minTurns() {
        return min;
    }

    public double averageTurns() {
        return (total)/100;
    }
}