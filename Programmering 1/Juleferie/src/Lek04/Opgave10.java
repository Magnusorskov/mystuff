package Lek04;

import java.util.Random;
import java.util.Scanner;

public class Opgave10 {
    public static void main(String[] args) {
        rockPaperScissors();
    }

    private static void rockPaperScissors() {
        System.out.println("Welcome to Rock, Paper and Scissors");
        int player = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to play easy(1) or hard(2) mode?");
        int mode = scanner.nextInt();
        double winSum = 0;
        double loseSum = 0;
        int drawCount = 0;

        if (mode == 1) {
            while (player != -1) {
                System.out.println("Choose Rock(0), Paper(1), Scissors(2) or -1 to end");


                player = scanner.nextInt();
                int computer = (int) (Math.random() * 3);

                if (player == 0) {
                    if (computer == 0) {
                        System.out.println("Computer chooses rock. DRAW!");
                        drawCount++;
                    } else if (computer == 1) {
                        System.out.println("Computer chooses Paper. You LOSE!");
                        loseSum++;
                    } else {
                        System.out.println("Computer chooses Scissors. You WIN!");
                        winSum++;
                    }
                } else if (player == 1) {
                    if (computer == 0) {
                        System.out.println("Computer chooses rock. You WIN!");
                        winSum++;
                    } else if (computer == 1) {
                        System.out.println("Computer chooses Paper. DRAW!");
                        drawCount++;
                    } else {
                        System.out.println("Computer chooses Scissors. You LOSE!");
                        loseSum++;
                    }
                } else {
                    if (computer == 0) {
                        System.out.println("Computer chooses rock. You LOSE!");
                        loseSum++;
                    } else if (computer == 1) {
                        System.out.println("Computer chooses Paper. You WIN!");
                        winSum++;
                    } else {
                        System.out.println("Computer chooses Scissors. DRAW!");
                        drawCount++;
                    }
                }
                System.out.println(winLoss(winSum,loseSum));
            }
        } else if (mode == 2) {
            int computer = (int) (Math.random() * 3);
            while (player != -1) {
                System.out.println("Choose Rock(0), Paper(1), Scissors(2) or -1 to end");
                int rockCount = 0;
                int paperCount = 0;
                int scissorCount = 0;

                player = scanner.nextInt();


                if (player == 0) {
                    if (computer == 0) {
                        System.out.println("Computer chooses rock. DRAW!");
                        drawCount++;
                    } else if (computer == 1) {
                        System.out.println("Computer chooses Paper. You LOSE!");
                        loseSum++;
                    } else {
                        System.out.println("Computer chooses Scissors. You WIN!");
                        winSum++;
                    }
                    rockCount++;
                } else if (player == 1) {
                    if (computer == 0) {
                        System.out.println("Computer chooses rock. You WIN!");
                        winSum++;
                    } else if (computer == 1) {
                        System.out.println("Computer chooses Paper. DRAW!");
                    } else {
                        System.out.println("Computer chooses Scissors. You LOSE!");
                        loseSum++;
                    }
                    paperCount++;
                } else {
                    if (computer == 0) {
                        System.out.println("Computer chooses rock. You LOSE!");
                        loseSum++;
                    } else if (computer == 1) {
                        System.out.println("Computer chooses Paper. You WIN!");
                        winSum++;
                    } else {
                        System.out.println("Computer chooses Scissors. DRAW!");
                    }
                    scissorCount++;
                }
                winLoss(winSum,loseSum);
                int randomifier = (int) (Math.random() * 3);
                switch (randomifier) {
                    case 0 : rockCount++;
                    break;
                    case 1 : paperCount++;
                    break;
                    case 2 : scissorCount++;
                }
                if (rockCount > paperCount && rockCount > scissorCount) {
                    computer = 1;
                } else if (paperCount > rockCount && paperCount > scissorCount) {
                    computer = 2;
                } else {
                    computer = 0;
                }
            }
        }
        System.out.println("Total games played: " + (winSum + loseSum + drawCount) + "\nWins: " + winSum + "\nLosses: " + loseSum
        + "\n" + winLoss(winSum,loseSum));
    }


    private static String winLoss(double winSum, double loseSum) {
        String winLoss;
        if (winSum > 0 && loseSum == 0) {
            winLoss = "100%";
        } else if (loseSum > 0 && winSum == 0 || loseSum == 0 && winSum == 0) {
            winLoss = "0%";
        } else {
            double winLossD = winSum / (loseSum + winSum) * 100;
            winLoss = winLossD + "%";
        }
        return "Win/loss ratio: " + winLoss;
    }
}
