package Opgave_4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class    Gui extends Application {

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
        int x = 200;
        int y = 200;
        int radius = 10;

        Circle circle1 = new Circle(x, y, radius);
        pane.getChildren().add(circle1);

        Circle circle2 = new Circle(x,y,20);
        circle2.setFill(null);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(5);
        pane.getChildren().add(circle2);

        Circle circle3 = new Circle(x,y,30);
        circle3.setFill(null);
        circle3.setStroke(Color.BLACK);
        circle3.setStrokeWidth(5);
        pane.getChildren().add(circle3);
    }
}
