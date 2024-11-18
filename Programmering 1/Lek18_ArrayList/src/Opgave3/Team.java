package Opgave3;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void printPlayers() {
        for (Player player : this.players) {
            System.out.println("Name: " + player.getName());
            System.out.println("Age: " + player.getAge());
            System.out.println("Score: " + player.getScore());
        }
    }

    public double calcAverageAge() {
        double ageSum = 0;
        for (Player player : this.players) {
            ageSum += player.getAge();
        }
        return ageSum / this.players.size();
    }

    public int calcTotalScore() {
        int scoreSum = 0;
        for (Player player : this.players) {
            scoreSum += player.getScore();
        }
        return scoreSum;
    }

    public int calcOldPlayersScore(int ageLimit) {
        int scoreSum = 0;
        for (Player player : this.players) {
            if (player.getAge() >= ageLimit) {
                scoreSum += player.getScore();
            }
        }
        return scoreSum;
    }

    public int maxScore() {
        int maxScore = Integer.MIN_VALUE;
        for (Player player : this.players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }
        return maxScore;
    }

    public String bestPlayer() {
        int maxScore = Integer.MIN_VALUE;
        String bestPlayer = "";
        for (Player player : this.players) {
            if (player.getScore() > maxScore) {
                bestPlayer = player.getName();
                maxScore = player.getScore();
            }
        }
        return bestPlayer;
    }
}
