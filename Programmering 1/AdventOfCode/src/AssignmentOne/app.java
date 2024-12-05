package AssignmentOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
//        try {
//            System.out.println(distance());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            System.out.println(similarityScore());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int distance() throws FileNotFoundException {
        int distanceSum = 0;
        File filein = new File("adventOfCode1.txt");
        Scanner scan = new Scanner(filein);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        while(scan.hasNext()) {
            left.add(scan.nextInt());
            right.add(scan.nextInt());
        }
        left.sort(Comparator.naturalOrder());
        right.sort(Comparator.naturalOrder());

        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) > right.get(i)) {
                distanceSum += left.get(i) - right.get(i);
            } else {
                distanceSum += right.get(i) - left.get(i);
            }
        }

        return distanceSum;
    }

    private static int similarityScore() throws FileNotFoundException {
        int score = 0;
        File filein = new File("adventOfCode1.txt");
        Scanner scan = new Scanner(filein);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        while (scan.hasNext()) {
            left.add(scan.nextInt());
            right.add(scan.nextInt());
        }
        int[] similarity = new int[left.size()];

        left.sort(Comparator.naturalOrder());
        right.sort(Comparator.naturalOrder());

        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                if (Objects.equals(left.get(i), right.get(j))) {
                    similarity[i]++;
                }
            }
            if (similarity[i] > 0) {
                score += left.get(i) * similarity[i];
            }
        }

        return score;
    }
}
