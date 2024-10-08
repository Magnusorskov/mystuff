package WorkshopExercise3;

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
        int x = 20;
        int y = 5;
        int y2 = 195;

        while (x <= 180) {
            gc.strokeLine(x, y, x, y2);
            x = x + 40;
        }
//    private void drawShapes(GraphicsContext gc) {
//        int x = 10;
//        int y = 20;
//        int x2 = 190;
//
//        while (y <= 180) {
//            gc.strokeLine(x, y, x2, y);
//            y = y + 40;
//
//        }
//    private void drawShapes(GraphicsContext gc) {
//        int x = 90;
//        int y = 20;
//        int x2 = 110;
//
//        while (y <= 180) {
//            gc.strokeLine(x, y, x2, y);
//            y = y + 40;
//            x = x - 20;
//            x2 = x2 + 20;
//
//        }
    }
}
