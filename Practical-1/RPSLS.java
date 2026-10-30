import java.util.Random;
import java.util.Scanner;

public class RPSLS {
    private static final int ROUNDS = 5;
    private static final int WIN = 1;
    private static final int LOSS = -1;
    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }

    static int winner(Move player, Move computer) {
        if (player == computer) return 0;
        return switch (player) {
            case ROCK -> computer == Move.SCISSORS || computer == Move.LIZARD ? WIN : LOSS;
            case PAPER -> computer == Move.ROCK || computer == Move.SPOCK ? WIN : LOSS;
            case SCISSORS -> computer == Move.PAPER || computer == Move.LIZARD ? WIN : LOSS;
            case LIZARD -> computer == Move.SPOCK || computer == Move.PAPER ? WIN : LOSS;
            case SPOCK -> computer == Move.SCISSORS || computer == Move.ROCK ? WIN : LOSS;
        };
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Random random = new Random();
            Move[] moves = Move.values();
            int playerScore = 0;
            int computerScore = 0;
            for (int round = 1; round <= ROUNDS; round++) {
                System.out.println("Round " + round + " - " + java.util.Arrays.toString(moves));
                System.out.print("Your move: ");
                Move player;
                try { player = Move.valueOf(input.nextLine().trim().toUpperCase()); }
                catch (IllegalArgumentException ex) { System.out.println("Invalid move; round skipped."); continue; }
                Move computer = moves[random.nextInt(moves.length)];
                int result = winner(player, computer);
                System.out.println("You: " + player + " | Computer: " + computer);
                if (result == WIN) playerScore++;
                else if (result == LOSS) computerScore++;
                else System.out.println("Tie!");
            }
            System.out.println("Final score - You: " + playerScore + ", Computer: " + computerScore);
            System.out.println(playerScore == computerScore ? "Overall tie" : playerScore > computerScore ? "You win!" : "Computer wins!");
        }
    }
}
