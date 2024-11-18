package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class YatzyHighscore {
    private int highscoreValue;
    private String name;
    public static ArrayList<YatzyHighscore> highscores = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getHighscoreValue() {
        return highscoreValue;
    }

    public YatzyHighscore(String name, int highscoreValue) {
        this.name = name;
        this.highscoreValue = highscoreValue;
    }

    @Override
    public String toString() {
        return name + ": " + highscoreValue;
    }

    public static ArrayList<YatzyHighscore> getHighscores() {
        return new ArrayList<>(highscores);
    }

    public static void saveHighscores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("highscores.txt"))) {
            for (YatzyHighscore highscore : highscores) {
                writer.write(highscore.getName() + "," + highscore.getHighscoreValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
