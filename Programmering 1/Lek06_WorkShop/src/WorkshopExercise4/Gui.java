package WorkshopExercise4;

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

    //    private void drawShapes(GraphicsContext gc) {
//        int x = 100;
//        int y = 100;
//        int r = 20;
//
//
//        while (r <= 100) {
//            gc.strokeOval(x-r, y-r, r*2, r*2);
//            r = r + 20;
//        }
//    }
//private void drawShapes(GraphicsContext gc) {
//    int x = 20;
//    int y = 100;
//    int r = 10;
//
//    while (r <= 80) {
//        gc.strokeOval(x-r, y-r, r*2, r*2);
//        r = r + 10;
//        x = x + 10;
//    }
    private void drawShapes(GraphicsContext gc) {
        int x = 80;
        int y = 30;
        int l = 40;
        int height = 140;
        while (l <= 190) {
            gc.strokeOval(x, y, l, height);
            l = l + 20;
            x = x - 10;



        }
    }
}

//}