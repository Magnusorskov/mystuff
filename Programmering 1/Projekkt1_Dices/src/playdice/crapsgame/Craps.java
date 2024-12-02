package src.playdice.crapsgame;

import java.util.Scanner;

public class Craps {
    private static int winsSum = 0;
    private static int lossSum = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the game of Craps!");
        printRules();
        System.out.println();
        String answer = "yes";

        while (!answer.equals("no")) {
            playCraps();

            System.out.println();
            System.out.println("Thank you for playing RollTwoDices");
            System.out.println("Do you want to play again?");
            answer = scan.nextLine();
        }
        printStatistics();
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println("The game involves rolling two dice. The result is the sum of the dice.\n" +
                "The first roll is called the ‘come out roll’.\n" +
                "The player wins if the first roll is 7 or 11, and loses if it’s 2, 3, or 12.\n" +
                "If the first roll is 4, 5, 6, 8, 9, or 10, that number becomes the player’s ‘point’.\n" +
                "The player keeps rolling until they either roll their ‘point’ again (win) or roll a 7 (lose).");
        System.out.println("=====================================================");
    }

    private static void playCraps() {
        int[] comeOutRoll = rollDice();
        System.out.println("You rolled: " + comeOutRoll[0] + " and " + comeOutRoll[1]);
        int sumOfRoll = comeOutRoll[0] + comeOutRoll[1];
        if (sumOfRoll == 7 || sumOfRoll == 11) {
            System.out.println("You win!");
            winsSum++;

        } else if (sumOfRoll == 2 || sumOfRoll == 3 || sumOfRoll == 12) {
            System.out.println("You lose!");
            lossSum++;
        } else {
            System.out.println("The game is on!");
            if (rollForPoints(sumOfRoll)) {
                System.out.println("You won!");
                winsSum++;
            } else {
                System.out.println("You lost!");
                lossSum++;
            }

        }

    }

    private static boolean rollForPoints(int point) {
        Scanner scan = new Scanner(System.in);
        boolean result = false;
        boolean keepRolling = true;
        int[] dice;
        int sumOfRoll = 0;

        String answer;


        while (keepRolling) {
            System.out.println("Keep rolling?");
            answer = scan.nextLine();
            if (answer.equals("no")) {
                keepRolling = false;
            }

            if (keepRolling) {
                dice = rollDice();
                System.out.println("You rolled: " + dice[0] + " + " + dice[1]);
                sumOfRoll = dice[0] + dice[1];
            }
            if (sumOfRoll == point) {
                result = true;
                keepRolling = false;
            }
            else if (sumOfRoll == 7) {
                keepRolling = false;
            }

        }
        return result;
    }


    private static int[] rollDice() {
        int[] faces = new int[2];
        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);
        return faces;
    }


    private static void printStatistics() {
        System.out.println("You won " + winsSum + " times!");
        System.out.println("You lost " + lossSum + " times!");
    }
}