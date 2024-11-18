package SeriesEpisodeKomposition;

import java.util.ArrayList;
import java.util.Arrays;

public class SeriesTest {

    public static void main(String[] args) {
        // Series 1 data
        ArrayList<String> cast1 = new ArrayList<>(Arrays.asList("Actor A", "Actor B", "Actor C"));
        Series series1 = new Series("Mystery Chronicles", cast1);

        // Series 2 data
        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("Actor X", "Actor Y", "Actor Z"));
        Series series2 = new Series("Space Adventures", cast2);

        // Generate 10 episodes for Series 1
        for (int i = 1; i <= 10; i++) {
            ArrayList<String> guestActors1 = new ArrayList<>(Arrays.asList("Guest " + i, "Guest " + (i + 10)));
            int lengthMinutes1 = 30 + (i * 2);  // Increment length slightly for variety
            series1.createEpisode(i, guestActors1, lengthMinutes1);
        }

        // Generate 10 episodes for Series 2
        for (int i = 1; i <= 10; i++) {
            ArrayList<String> guestActors2 = new ArrayList<>(Arrays.asList("Visitor " + i, "Alien " + (i + 10)));
            int lengthMinutes2 = 40 + (i * 3);  // Increment length slightly for variety
            series2.createEpisode(i, guestActors2, lengthMinutes2);
        }

        // Display series information
        displaySeriesInfo(series1);
        displaySeriesInfo(series2);
    }

    private static void displaySeriesInfo(Series series) {
        System.out.println("Series Title: " + series.getTitle());
        System.out.println("Cast: " + series.getCast());
        System.out.println("Total Length: " + series.totalLength() + " minutes");
        System.out.println("Guest Actors from all episodes: " + series.getGuestActors());
        System.out.println("-------------------------------------------------");
    }
}
