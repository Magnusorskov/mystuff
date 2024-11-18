package SeriesEpisodeKomposition;

import java.util.ArrayList;

public class Series {
    private String title;
    private  ArrayList<String> cast;
    private ArrayList<Episode> episodes;

    Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
        this.episodes = new ArrayList<>();
    }

    public ArrayList<String> getCast() {
        return new ArrayList<>(cast);
    }

    public String getTitle() {
        return title;
    }

    public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        episodes.add(episode);
        return episode;
    }

    /**
     * Return the total length (in minutes) of all the
     * episodes in the series.
     */
    public int totalLength() {
        int minuteSum = 0;
        for (Episode episode: episodes) {
            minuteSum += episode.getLengthMinutes();
        }
        return minuteSum;
    }

    /**
     * Return the total list of all guest actors from all
     * episodes.
     */
    public ArrayList<String> getGuestActors() {
        ArrayList<String> allGuestActors = new ArrayList<>();
        for (Episode episode: episodes) {
            for (String guestActor: episode.getGuestActors()) {
                if (!allGuestActors.contains(guestActor)) {
                    allGuestActors.add(guestActor);
                }
            }
        }
        return allGuestActors;
    }

}
