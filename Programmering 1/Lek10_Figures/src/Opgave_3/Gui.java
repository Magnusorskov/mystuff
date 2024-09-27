package Opgave_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {
        int x = 70;
        int y = 70;
        int radius = 50;

        Circle head = new Circle(x, y, 50);
        pane.getChildren().add(head);
        head.setFill(null);
        head.setStroke(Color.BLACK);

        Circle leftEye = new Circle(x-15, y-5, radius/10);
        pane.getChildren().add(leftEye);
        leftEye.setFill(null);
        leftEye.setStroke(Color.BLACK);

        Circle rightEye = new Circle(x+15, y-5, radius/10);
        pane.getChildren().add(rightEye);
        rightEye.setFill(null);
        rightEye.setStroke(Color.BLACK);

        Line line = new Line(x-20, y+20, x+20   , y+20);
        pane.getChildren().add(line);
    }
}
