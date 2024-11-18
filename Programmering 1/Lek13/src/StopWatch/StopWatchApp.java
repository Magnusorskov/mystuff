package StopWatch;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class StopWatchApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StopWatch s1 = new StopWatch();
        System.out.println("When you are ready to start the stopwatch, write start");
        String button = scan.next();

        if (button.equalsIgnoreCase("Start")) {
            s1.start();
        }
        System.out.println("When you are ready to stop the stopwatch, write stop");
        button = scan.next();
        if (button.equalsIgnoreCase("stop")) {
            s1.stop();
        }
        System.out.println(s1.elapsedTime());
    }
}