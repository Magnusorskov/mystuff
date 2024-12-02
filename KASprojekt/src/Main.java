import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        LocalDate omTreDage = LocalDate.of(2024,12,5);
        System.out.println(now.compareTo(omTreDage));
    }
}