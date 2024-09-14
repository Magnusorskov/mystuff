package WorkshopExercise6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc) {
        int x1 = 10;
        int x2 = 156;
        int x3 = 150;
        int y = 180;

        gc.strokeLine(x1, y, x2, y);
        gc.strokeLine(x2, y, x3, y - 5);
        gc.strokeLine(x2, y, x3, y + 5);

        int y2 = y - 3;
        int y3 = y + 3;
        int x4 = 22;
        int i = 0;
        String tal = "" + i;

        for (i = 0; i <= 10; i++) {
            if (i % 5 == 0) {
                gc.strokeLine(x4, y2 - 3, x4, y3 + 3);
                tal = "" + i;
                gc.fillText(tal, x4 - 3, y3 + 12);
                x4 = x4 + 12;
            } else {
                gc.strokeLine(x4, y2, x4, y3);
                x4 = x4 + 12;
            }

        }

    }
}
