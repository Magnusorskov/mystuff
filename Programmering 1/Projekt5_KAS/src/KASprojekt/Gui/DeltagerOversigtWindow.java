package KASprojekt.Gui;

import KASprojekt.Controller.Controller;
import KASprojekt.Model.Deltager;
import KASprojekt.Model.Konference;
import KASprojekt.Model.Tilmelding;
import KASprojekt.Model.Udflugt;
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

import java.util.ArrayList;

public class DeltagerOversigtWindow extends Stage {

    private Konference konference;

    public DeltagerOversigtWindow(Konference konference) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);

        this.konference = konference;

        this.setTitle("Deltager Oversigt");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

        Tilmelding[] tilmeldinger = Controller.sorterDeltagere(konference);
        StringBuilder sb = Controller.stringBuilderDeltagerOversigt((tilmeldinger));
        txtaOversigt.setText(String.valueOf(sb));
    }


    private TextArea txtaOversigt;
    private Label lblKonference;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        lblKonference = new Label(konference.getNavn());

        pane.add(lblKonference, 0, 0);
        txtaOversigt = new TextArea();
        pane.add(txtaOversigt, 0, 1);
        txtaOversigt.setPrefRowCount(30);

    }




}

