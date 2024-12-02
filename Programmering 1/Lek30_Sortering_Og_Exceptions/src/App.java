import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String s = "1       magnus   213        margrethe     dfads";
        Scanner scan = new Scanner(s);
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
    }
}
