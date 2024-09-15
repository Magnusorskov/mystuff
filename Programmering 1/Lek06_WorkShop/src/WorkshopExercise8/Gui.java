package WorkshopExercise8;

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
    // Create an application that draws 10 vertical lines as shown in the figure below. The first line’s
    //height is 80 and the height of the next lines is decreased by 8. The lower endpoint of the lines are at
    //(16,160), (32,148), (48,136), etc. Use a for-statement.

    private void drawShapes(GraphicsContext gc) {

        int x = 20;
        int y1 = 80;
        int y2 = 160;

        for (int i = 1; i <= 10; i++) {
            gc.strokeLine(x, y1, x, y2);
            x += 15;
            y1 -= 5;
            y2 -= 12;
        }

    }
}