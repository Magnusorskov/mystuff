package opgave9_2_stock;

public class StockApp {
    public static void main(String[] args) {
        Stock test = new Stock("Test","blap",10);

        test.setPrice(9);

        System.out.println(test.getChangePercent());

        Stock orcl = new Stock("ORCL","Oracle",34.5);
        orcl.setPrice(34.35);

        System.out.println(orcl.getChangePercent());

        System.out.println("---------");
        System.out.println(orcl);
        }
    }



