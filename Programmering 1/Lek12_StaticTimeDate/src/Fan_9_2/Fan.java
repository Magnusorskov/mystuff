package Fan_9_2;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = SLOW;
    private boolean on;
    private double radius = 5;
    public String color = "blue";

    public Fan() {
    }

    public double getRadius() {
        return radius;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public boolean getStatus() {
        return on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOnOff(boolean on) {
        this.on = on;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        if (on == true){
            return "Fan speed: " + getSpeed() + "\nFan color: " + getColor() + "\nRadius: " + getRadius();
        } else return "Fan color: " + getColor() + "\nRadius: " + getRadius() + "\nThe fan is off";
    }

}
