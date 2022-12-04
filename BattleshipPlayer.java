/**
 * -----------------------------------------------------------
 * @author Vishesh Narayan
 * @version 11/2/22
 * -----------------------------------------------------------
 * BattleshipPlayer class to simulate player
 * -----------------------------------------------------------
 * Creates BattleshipPlayer object
 * -----------------------------------------------------------
 */
import java.util.Scanner;

public class BattleshipPlayer {
    
    /**
     * private vars
     */
    private String name = "";
    private BattleshipGrid grid;
    private Scanner input = new Scanner(System.in);

    /**
     * Constructor
     */
    public BattleshipPlayer() {
    }

    /**
     * startGame
     * starts game and initializes grid
     */
    public void startGame() {
        // name
        if (this.name.isEmpty()) {
            System.out.print("Please enter a name: ");
            this.name = input.nextLine();
        }

        // grid
        this.grid = new BattleshipGrid();
    }

    /**
     * playerName()
     * returns player name
     * @return String
     */
    public String playerName() {
        return this.name;
    }

    /**
     * shoot()
     * shoots at player inputted position
     * returns position player entered
     * @return Position
     */
    public Position shoot() {
        /**
         * valid input verification
         */
        boolean valR = true;
        boolean valC = true;
        /**
         * player input
         */
        System.out.print("Enter a letter A-J: ");
        char r = input.nextLine().toUpperCase().charAt(0);
        System.out.print("Enter a letter 1-10: ");
        int c = Integer.parseInt(input.nextLine());

        /**
         * valid check
         */
        if (r < 65 || r > 74) {
            valR = false;
        }
        if (c < 1 || c > 10) {
            valC = false;
        }

        /**
         * if not valid
         * loop until valid response
         */
        while (!valR) {
            System.out.print("Invalid row, Enter a letter A-J: ");
            r = input.nextLine().toUpperCase().charAt(0);
            if (r >= 65 && r <= 74) {
                valR = true;
            }
        }

        while (!valC) {
            System.out.print("Invalid column, Enter a letter 1-10: ");
            c = Integer.parseInt(input.nextLine());
            if (c >= 1 && c <= 10) {
                valC = true;
            }
        }

        return new Position(r, c);
    }

    /**
     * updateGrid
     * updates grid
     * outputs grid for player
     * @param pos
     * @param hit
     * @param initial
     */
    protected void updateGrid(Position pos, boolean hit, char initial) {
        grid.shotAt(pos, hit, initial);
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        int letter = 65;
        for (int r = 0; r < 10; r++) {
            System.out.print(((char) letter) + " ");
            letter+=1;
            for (int c = 0; c < 10; c++) {
                Position p = new Position(r+1, c+1);
                if (grid.hit(p)) {
                    System.out.print(grid.boatInitial(p)+" ");
                } else if (grid.miss(p)) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * updatePlayer
     * updates player stats
     * outputs player stats
     * @param pos
     * @param hit
     * @param initial
     * @param boatName
     * @param sunk
     * @param gameOver
     * @param tooManyTurns
     * @param turns
     */
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns) {
        System.out.println("Turn #" + (turns+1) + "\n");
        if (hit) {
            System.out.println("Boat was hit! You hit a " + boatName + ".");
        } else {
            System.out.println("Boat was not hit...");
        }

        if (sunk) {
            System.out.println("The " + name + " sunk!");
        } 

        if (tooManyTurns) {
            System.out.println("Game has gone on for too long...");
        }

        if (!gameOver) {
            System.out.println("Game over!");
        }

        updateGrid(pos, hit, initial);
    }
}