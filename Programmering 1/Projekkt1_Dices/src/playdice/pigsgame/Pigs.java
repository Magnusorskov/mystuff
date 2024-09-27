package playdice.pigsgame;

import java.util.Scanner;

public class Pigs {
    private static int turnCount = 1;
    private static int[] playerScore = new int[2];
    private static int[] rollCountPlayers = new int[2];
    private static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        printRules();
        System.out.println();

        System.out.println("What score do you want to play to?");
        int score = scan.nextInt();
        playPig(score);

        printStatistics();
        System.out.println();
        System.out.println("Thank you for playing Pigs");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Pigs:");
        System.out.println("The first player rolls a die until they roll a 1 or decide to stop.\n" +
                "Rolling a 1 means no points for that round.\n" +
                "If they stop before rolling a 1, the sum of their rolls is added to their total score.\n" +
                "The turn then passes to the next player. The first player to reach chosen points wins.\n");
        System.out.println("=====================================================");
    }

    public static void playPig(int score) {
        int currentPlayer;
        int tempSum = 0;
        boolean keepRolling = true;
        String answer;

        while (playerScore[0] + tempSum < score && playerScore[1] + tempSum < score) {
            turnCount++;
            currentPlayer = turnCount % 2;
            System.out.println("Player " + (currentPlayer + 1) + ", do you want to roll? y/n");
            answer = scan.next();
            if (answer.equals("y")) {
                keepRolling = true;
            }
            while (keepRolling) {
                int[] faces = rollDice();
                if (faces[0] == 1 && faces[1] == 1) {
                    System.out.println("You rolled " + faces[0] + " and " + faces[1]);
                    System.out.println("Player " + (currentPlayer + 1) + "'s score is reduced to 0");
                    playerScore[currentPlayer] = 0;
                    tempSum = 0;
                    keepRolling = false;
                    rollCountPlayers[currentPlayer]++;
                } else if (faces[0] == 1 || faces[1] == 1) {
                    System.out.println("You rolled " + faces[0] + " and " + faces[1]);
                    System.out.println("This rounds points are reduced to 0");
                    System.out.println("Player " + (currentPlayer + 1) + "'s score is: " + playerScore[currentPlayer]);
                    tempSum = 0;
                    keepRolling = false;
                    rollCountPlayers[currentPlayer]++;
                } else {
                    System.out.println("You rolled " + faces[0] + " and " + faces[1]);
                    tempSum += faces[0] + faces[1];
                    System.out.println("This rounds points sum is: " + tempSum);
                    rollCountPlayers[currentPlayer]++;
                    if (playerScore[currentPlayer] + tempSum >= score) {
                        playerScore[currentPlayer] += tempSum;
                        keepRolling = false;
                    } else {
                        System.out.println("Do you want to roll again? y/n");
                        answer = scan.next();
                        if (answer.equals("n")) {
                            keepRolling = false;
                            playerScore[currentPlayer] += tempSum;
                            System.out.println("Player " + (currentPlayer + 1) + "'s score is: " + playerScore[currentPlayer]);
                            tempSum = 0;
                        }
                    }
                }


            }
        }
        if (playerScore[0] > playerScore[1]) {
            System.out.println("Player 1's score is " + playerScore[0] + " and player 2's score is " + playerScore[1]);
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 1's score is " + playerScore[0] + " and player 2's score is " + playerScore[1]);
            System.out.println("Player 1 wins!");
        }
    }

    public static int[] rollDice() {
        int[] faces = new int[2];
        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);
        return faces;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        double averageRollsPerTurnP1 = rollCountPlayers[0] / (turnCount / 2.0);
        double averageRollsPerTurnP2;
        if (turnCount % 2 == 1) {
            averageRollsPerTurnP2 = rollCountPlayers[1] / ((turnCount - 1) / 2.0);
        } else {
            averageRollsPerTurnP2 = rollCountPlayers[1] / (turnCount / 2.0);
        }
        System.out.println("Roll average player1:" + averageRollsPerTurnP1);
        System.out.println("Roll average player2:" + averageRollsPerTurnP2);
    }
}