package model;
//(Count single digits)
public class Opgave7_7 {
    public static void main(String[] args) {
        int[] numberCount = new int[10];

        for (int i = 0; i < 200; i++) {
            int randomInt = (int) (Math.random() * 10);
            System.out.print(randomInt + " ");
            numberCount[randomInt]++;
        }
        System.out.println();
        int sumOfNumbers = 0;
        for (int j = 0; j < numberCount.length; j++) {
            sumOfNumbers = sumOfNumbers + numberCount[j];
            System.out.println(j + " occurs " + numberCount[j] + " times");
        }
        double average = sumOfNumbers / numberCount.length;
        double averagePercent = 200 / average;
        System.out.println("The average occurrence of a number is " + average + " and the percentage is " + averagePercent + "%");
    }
}
