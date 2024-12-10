package KASprojekt.Gui;

import KASprojekt.Controller.Controller;
import KASprojekt.Model.*;
import KASprojekt.Storage.Storage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.PrintWriter;
import java.util.ArrayList;

public class HotelOversigtWindow extends Stage {


    public HotelOversigtWindow() {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);


        this.setTitle("Hotel Oversigt");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


        StringBuilder sb = Controller.stringBuilderHotelOversigt();
        txtaOversigt.setText(String.valueOf(sb));
    }

    private TextArea txtaOversigt;
    private Label lblhotelOversigt;
    private Button btnEksporter;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        lblhotelOversigt = new Label("Hotel Oversigt");

        pane.add(lblhotelOversigt,0,0);
        txtaOversigt = new TextArea();
        pane.add(txtaOversigt,0,1);
        txtaOversigt.setPrefRowCount(30);
        txtaOversigt.setPrefColumnCount(70);
        btnEksporter = new Button("Eksporter data");
        pane.add(btnEksporter,1,0);
        btnEksporter.setOnAction(event -> eksporterUdflugter());
    }

    private void eksporterUdflugter() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Controller.eksporterHoteller();
        alert.setHeaderText("Fil oprettet");
        alert.show();
    }
}
