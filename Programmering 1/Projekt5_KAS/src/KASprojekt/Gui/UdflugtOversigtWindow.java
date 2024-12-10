package KASprojekt.Gui;


import KASprojekt.Controller.Controller;
import KASprojekt.Model.Konference;
import KASprojekt.Model.Tilmelding;
import KASprojekt.Model.Udflugt;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.*;
import java.util.ArrayList;

public class UdflugtOversigtWindow extends Stage {
    private Konference konference;

    public UdflugtOversigtWindow(Konference konference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);

        this.konference = konference;

        this.setTitle("Udflugts Oversigt");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        StringBuilder udflugtsOversigt = Controller.stringBuilderUdflugtsOversigt(konference);

        txtaOversigt.setText(String.valueOf(udflugtsOversigt));
    }

    private TextArea txtaOversigt;
    private Label lblKonference;
    private Button btnEksporter;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        lblKonference = new Label(konference.getNavn());

        pane.add(lblKonference,0,0);
        txtaOversigt = new TextArea();
        pane.add(txtaOversigt,0,1);
        txtaOversigt.setPrefRowCount(30);

        btnEksporter = new Button("Eksporter data");
        pane.add(btnEksporter,1,0);
        btnEksporter.setOnAction(event -> eksporterUdflugter());
    }

    private void eksporterUdflugter() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Controller.eksporterUdflugter(konference);
        alert.setHeaderText("Fil oprettet");
        alert.show();
    }


}
