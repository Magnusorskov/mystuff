package Opgave3;

public class TeamApp {
    public static void main(String[] args) {
        Player p1 = new Player("Magnus",28);
        Player p2 = new Player("Kasper",22);
        Player p3 = new Player("Jonas",30);
        p1.addScore(30);
        p2.addScore(45);
        p3.addScore(100);


        Team t1 = new Team("De seje");
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);
        t1.printPlayers();
        System.out.println("Average age: " + t1.calcAverageAge());
        System.out.println("Total score: " + t1.calcTotalScore());
        System.out.println("Total score over age limit: " + t1.calcOldPlayersScore(28));
        System.out.println("Max score: " + t1.maxScore());
        System.out.println("Best player: " + t1.bestPlayer());



    }

}
