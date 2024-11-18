package opgave9_1;

import java.sql.SQLOutput;

public class Rectangle {
    private double width = 1;
    private double height = 1;

    public Rectangle() {
    }

    public Rectangle(double inputWidth, double inputHeight) {
        width = inputWidth;
        height = inputHeight;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return height * 2 + width * 2;
    }

    public String toString() {
        return "Width: " + width + "\nHeight: " + height + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();

    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


}
