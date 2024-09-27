package NoteOpgaver1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
        Circle circle = new Circle(100, 100, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.GREEN);
        circle.setStroke(Color.RED);

        Rectangle r1 = new Rectangle(200, 50, 60, 30);
        r1.setStroke(Color.AZURE);
        r1.setFill(Color.GRAY);
        pane.getChildren().add(r1);

        Line line1 = new Line(10, 10, 190, 190);
        line1.setStrokeWidth(5);
        line1.setStroke(Color.YELLOW);
        pane.getChildren().add(line1);


    }
}
