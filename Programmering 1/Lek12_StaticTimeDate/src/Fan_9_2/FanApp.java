package Fan_9_2;

public class FanApp {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOnOff(true);

        fan2.setSpeed(Fan.MEDIUM);
        fan2.setColor("Blue");
        fan2.setRadius(5);
        fan2.setOnOff(false);

        System.out.println(fan1);
        System.out.println();
        System.out.println();
        System.out.println(fan2);
    }
}
