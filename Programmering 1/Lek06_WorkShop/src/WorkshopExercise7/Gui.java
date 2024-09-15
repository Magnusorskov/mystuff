package WorkshopExercise7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------
//Exercise 5
//Text can be drawn with the method fillText().
//As an example the code below will write the text ”Datamatiker” placed with lower, left corner at
//(20,50):
//String s = ”Datamatiker”;
//gc.fillText(s, 20, 50);
//Create an application that draws this figure:

    private void drawShapes(GraphicsContext gc) {
        String word = "Datamatiker";
        int y = 10;
        for (int i = 1; i <= word.length(); i++) {
            gc.fillText(word.substring(0, i), 10, y);
            y = y + 10;
        }
    }

}
