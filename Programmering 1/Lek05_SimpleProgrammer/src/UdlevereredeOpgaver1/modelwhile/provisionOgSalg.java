package UdlevereredeOpgaver1.modelwhile;

public class provisionOgSalg {
    public static void main(String[] args) {
        double salg = 150000;
        int i = 10000;


        System.out.println("Salg  \tProvisionssats");

        while (i <= salg) {
            System.out.println(i + "\t" + provision(i));
            i += 10000;
        }
    }

    public static double provision(double salg) {
        double provisionsTal;

        if (salg <= 40000) {
            provisionsTal = salg * 0.06;
        } else if (salg <= 100000) {
            provisionsTal = (40000 * 0.06) + (salg - 40000) * 0.08;
        } else {
            provisionsTal = ((40000 * 0.06) + (60000 * 0.08) + (salg - 100000) * 0.1);
        }
        return provisionsTal;
    }
}






