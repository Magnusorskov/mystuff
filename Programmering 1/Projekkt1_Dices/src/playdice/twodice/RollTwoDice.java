package playdice.twodice;

import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {
    private static int sum = 0;
    private static int dupes = 0;
    private static int maxEyes = 0;
    private static int[] eyeCount = new int[7];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollTwoDices");
        printRules();
        System.out.println();

        playTwoDices();

        System.out.println();
        System.out.println("Thank you for playing RollTwoDices");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDie:");
        System.out.println("The player throws two dices as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playTwoDices() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scan.nextLine();
        while (!answer.equals("no")) {
            int[] faces = rollDice();
            updateStatistics(faces);

            System.out.println("Eyes: " + Arrays.toString(faces));
            System.out.println();

            System.out.print("Roll? ('no' stops) ");
            answer = scan.nextLine();

        }
        printStatistics();
        scan.close();
    }

    public static int[] rollDice() {
        int[] faces = new int[2];
        faces[0] = (int) (Math.random() * 6 + 1);
        faces[1] = (int) (Math.random() * 6 + 1);
        return faces;
    }

    private static void updateStatistics(int[] faces) {
        int localSum = faces[0] + faces[1];
        sum = sum + localSum;
        if (faces[0] == faces[1]) {
            dupes++;
        }
        if (localSum > maxEyes) {
            maxEyes = localSum;
        }
        eyeCount[faces[0]]++;
        eyeCount[faces[1]]++;

    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Sum: ", sum);
        System.out.printf("%17s %4d\n", "Duplicates: ", dupes);
        System.out.printf("%17s %4d\n", "Max eye value: ", maxEyes);
        for(int i = 1; i<=6; i++) {
            System.out.printf("%17s %4d\n", "Eye count of " + i + ": ", + eyeCount[i]);
        }
    }
}

