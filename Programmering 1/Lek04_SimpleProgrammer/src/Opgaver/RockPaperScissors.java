package Opgaver;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int computerNumber = (int)(Math.random() * 2);
        String computerChoice;


        if (computerNumber == 0) {
            computerChoice = "scissor";
        }
        else if (computerNumber == 1) {
            computerChoice = "rock";
        }
        else {
            computerChoice = "paper";
        }

        System.out.println("Choose scissor (0), rock (1) or paper (2)");
        int playerNumber = scan.nextInt();
        String playerChoice;

        if (playerNumber == 0) {
            playerChoice = "scissor";
        }
        else if (playerNumber == 1) {
            playerChoice = "rock";
        }
        else {
            playerChoice = "paper";
        }

        boolean draw = (playerNumber == computerNumber);

        if (draw) {
            System.out.println("The computer chose " + computerChoice + " and you chose " + playerChoice +
                    "! It's a draw!");
        }
        else if  (playerNumber == 0 && computerNumber == 2
                || playerNumber == 1 && computerNumber == 0
                || playerNumber == 2 && computerNumber == 1) {
            System.out.print("The computer is " + computerChoice + " and you are " + playerChoice + ". You won!");
        }
        else {
            System.out.println("The computer is " + computerChoice + " and you are " + playerChoice + ". You lost!");

        }
    }
}
