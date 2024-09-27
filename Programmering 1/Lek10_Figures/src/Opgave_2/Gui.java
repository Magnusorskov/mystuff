package Opgave_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        int x = 25;
        int y = 10;
        int length = 60;
        int height = 30;
        int textX = x+length/6;
        int textY = y+height/2;

        Rectangle r1 = new Rectangle(x, y, length, height);
        pane.getChildren().add(r1);
        r1.setFill(Color.BLUE);

        Text name = new Text(textX, textY, "Magnus");
        name.setFill(Color.RED);
        pane.getChildren().add(name);
    }
}
