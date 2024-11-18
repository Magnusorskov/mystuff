package Opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------
    private final TextField txfCelsius = new TextField();
    private final TextField txfFahrenheit = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblCelsius = new Label("Celsius:");
        pane.add(lblCelsius, 0, 0);

        Label lblFahrenheit = new Label("Fahrenheit:");
        pane.add(lblFahrenheit, 0, 1);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        pane.add(txfCelsius, 1, 0, 2, 1);

        pane.add(txfFahrenheit, 1, 1, 2, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnConvertToFahrenheit = new Button("Convert to Fahrenheit");
        pane.add(btnConvertToFahrenheit, 1, 2);
        btnConvertToFahrenheit.setOnAction(event -> convertToFahrenheit());

        Button btnConvertToCelsius = new Button("Convert to Celsius");
        pane.add(btnConvertToCelsius, 2, 2);
        btnConvertToCelsius.setOnAction(event -> convertToCelsius());
    }

    private void convertToFahrenheit() {
        int celsius = Integer.parseInt(txfCelsius.getText());
        txfFahrenheit.setText(String.valueOf((celsius * 9.0 / 5) + 32));
    }

    private void convertToCelsius() {
        int fahrenheit = Integer.parseInt(txfFahrenheit.getText());
        txfCelsius.setText(String.valueOf((fahrenheit - 32) * 5.0 / 9));
    }
}
