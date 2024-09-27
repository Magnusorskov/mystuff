package Opgave_5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        int x = 100;
        int y = 100;
        int r = 35;

        Circle circle1 = new Circle(x, y, r);
        circle1.setFill(null);
        circle1.setStroke(Color.BLUE);
        circle1.setStrokeWidth(4);
        pane.getChildren().add(circle1);

        Circle circle2 = new Circle(x+r*2, y, r);
        circle2.setFill(null);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(4);
        pane.getChildren().add(circle2);

        Circle circle3 = new Circle(x+r*4, y, r);
        circle3.setFill(null);
        circle3.setStroke(Color.RED);
        circle3.setStrokeWidth(4);
        pane.getChildren().add(circle3);

        Circle circle4 = new Circle(x+r, y+r, r);
        circle4.setFill(null);
        circle4.setStroke(Color.YELLOW);
        circle4.setStrokeWidth(4);
        pane.getChildren().add(circle4);

        Circle circle5 = new Circle(x+r*3, y+r, r);
        circle5.setFill(null);
        circle5.setStroke(Color.GREEN);
        circle5.setStrokeWidth(4);
        pane.getChildren().add(circle5);
    }
}
