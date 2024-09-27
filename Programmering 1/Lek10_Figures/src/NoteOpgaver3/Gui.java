package NoteOpgaver3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
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
        double x = 120;
        Rectangle hus = new Rectangle(50, 150, x, x);
        pane.getChildren().add(hus);
        hus.setFill(Color.YELLOW);

        Rectangle sokkel = new Rectangle(50, 250, 120, 20);
        pane.getChildren().add(sokkel);
        sokkel.setFill(Color.GREY);

        double brickHeight = 5.4;
        double brickLength = 22.8;
        double hojdemodul = 6.66666666;

        for (double j = 250; j >= 150; j -= hojdemodul * 2) {
            for (double i = 51; i < x + 50; i += 24) {
                Rectangle brick = new Rectangle(i, j, brickLength, brickHeight);
                brick.setFill(Color.RED);
                brick.setStroke(Color.BLACK);
                pane.getChildren().add(brick);
            }
        }

        for (double j = 243.33333; j >= 140; j -= hojdemodul * 2) {
            for (double i = 61.8; i < x + 30; i += 24) {
                Rectangle brick = new Rectangle(i, j, brickLength, brickHeight);
                brick.setFill(Color.RED);
                brick.setStroke(Color.BLACK);
                pane.getChildren().add(brick);
            }
        }

        for (double j = 243.33333; j >= 140; j -= hojdemodul * 2) {
            for (double i = 51; i < x + 50; i += 106.8) {
                Rectangle brick = new Rectangle(i, j, 12, brickHeight);
                brick.setFill(Color.RED);
                brick.setStroke(Color.BLACK);
                pane.getChildren().add(brick);
            }
        }

            Rectangle window = new Rectangle(70, 180, 40, 40);
            pane.getChildren().add(window);
            window.setFill(Color.LIGHTBLUE);
                                                   

            Line windowPane1 = new Line(90, 180, 90,220);
            pane.getChildren().add(windowPane1);

            Line windowPane2 = new Line(70,200,110,200);
            pane.getChildren().add(windowPane2);

            Line Grass = new Line(10, 270, 390, 270);
            Grass.setStroke(Color.FORESTGREEN);
            Grass.setStrokeWidth(2);
            pane.getChildren().add(Grass);

            Polygon Roof = new Polygon(30, 150, 110, 70, 190, 150);
            pane.getChildren().add(Roof);
            Roof.setFill(Color.GREEN);

            Circle Sun = new Circle(230, 50, 30);
            pane.getChildren().add(Sun);
            Sun.setFill(Color.YELLOW);
            Sun.setStroke(Color.BLACK);


        for (int i = 10; i <= 390; i += (int) (Math.random() * 5)) {
            Line GrassStrand = new Line(i, 270, i, 270-(int) (Math.random() * 11));
            GrassStrand.setStroke(Color.FORESTGREEN);
            GrassStrand.setStrokeWidth(2);
            pane.getChildren().add(GrassStrand);
        }

        }
    }
