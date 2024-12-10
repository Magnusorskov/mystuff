package KASprojekt.Gui;

import KASprojekt.Controller.Controller;
import KASprojekt.Model.Hotel;
import KASprojekt.Model.Konference;
import KASprojekt.Model.Udflugt;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class KonferencePane extends GridPane {
    private TextField txfNavn;
    private ListView konferenceListView = new ListView();
    private Button btnOpretKonference = new Button("Opret Konference");

    public KonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        konferenceListView.getItems().setAll(Controller.getKonferencer());
        this.add(konferenceListView, 0, 0);
        this.add(btnOpretKonference, 1, 0);
        btnOpretKonference.setOnAction(event -> showPopupKonference());
    }

    private TextField txtNavn;
    private TextField txtFraDato;
    private TextField txtTilDato;
    private TextField txtSted;
    private TextField txtAfgift;
    private TextField txtArrangør;
    private ListView lvwUdflugter;
    private ListView lvwHoteller;
    private TextField txtUdflugtNavn;
    private TextField txtUdflugtDato;
    private TextField txtUdflugtPris;
    private ArrayList<String> udflugter = new ArrayList<>();

    private void showPopupKonference() {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Indtast konferenceinfo");

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(30);

        //øverste label
        Label lblTitel = new Label("Konference:");
        pane.add(lblTitel, 0, 0);
        //konference navn label og tekstfelt
        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 1);
        txtNavn = new TextField();
        pane.add(txtNavn, 1, 1);
        //konference fra dato
        Label lblFraDato = new Label("Fra:");
        pane.add(lblFraDato, 0, 2);
        txtFraDato = new TextField();
        txtFraDato.setPromptText("YYYY-MM-DD");
        pane.add(txtFraDato, 1, 2);
        //konference til dato
        Label lblTilDato = new Label("Til:");
        pane.add(lblTilDato, 0, 3);
        txtTilDato = new TextField();
        txtTilDato.setPromptText("YYYY-MM-DD");
        pane.add(txtTilDato, 1, 3);

        //konference arrangør
        Label lblArrangør = new Label("Arrangør:");
        pane.add(lblArrangør, 0, 4);
        txtArrangør = new TextField();
        pane.add(txtArrangør, 1, 4);
        //konference sted
        Label lblSted = new Label("Sted:");
        pane.add(lblSted, 0, 5);
        txtSted = new TextField();
        pane.add(txtSted, 1, 5);
        //konference afgift
        Label lblAfgift = new Label("Pris:");
        pane.add(lblAfgift, 0, 6);
        txtAfgift = new TextField();
        pane.add(txtAfgift, 1, 6);

        //udflugt navn
        Label lblUdflugtNavn = new Label("Udflugt navn:");
        pane.add(lblUdflugtNavn, 2, 1);
        txtUdflugtNavn = new TextField();
        pane.add(txtUdflugtNavn, 3, 1);
        //udflugt dato
        Label lblUdflugtDato = new Label("Udflugt dato:");
        pane.add(lblUdflugtDato, 2, 2);
        txtUdflugtDato = new TextField();
        txtUdflugtDato.setPromptText("YYYY-MM-DD");
        pane.add(txtUdflugtDato, 3, 2);
        //udflugt pris
        Label lblUdflugtPris = new Label("Udflugt pris:");
        pane.add(lblUdflugtPris, 2, 3);
        txtUdflugtPris = new TextField();
        pane.add(txtUdflugtPris, 3, 3);
        //opret udflugt button
        Button btnOpretUdflugt = new Button("Opret udflugt");
        btnOpretUdflugt.setOnAction(event -> opretUdflugtHandler());
        pane.add(btnOpretUdflugt, 2, 4, 2, 1);

        //listview for udflugter
        Label lblUdflugter = new Label("Udflugter:");
        pane.add(lblUdflugter, 4, 0);
        lvwUdflugter = new ListView();
        pane.add(lvwUdflugter, 4, 1, 1, 7);

        //listview for udflugter
        Label lblHoteller = new Label("Hoteller:");
        pane.add(lblHoteller, 5, 0);
        lvwHoteller = new ListView();
        lvwHoteller.getItems().setAll(Controller.getHoteller());
        lvwHoteller.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        pane.add(lvwHoteller, 5, 1, 1, 7);

        //gemknap
        Button btnGem = new Button("Gem");
        btnGem.setOnAction(event -> gemHandler(popupStage));
        pane.add(btnGem, 0, 7);
        //annullérknap
        Button btnSlut = new Button("Annullér");
        btnSlut.setOnAction(event -> {
            popupStage.close();
        });
        pane.add(btnSlut, 1, 7);


        Scene scene = new Scene(pane, 1150, 600);
        popupStage.setScene(scene);
        popupStage.showAndWait();
    }

    private void opretUdflugtHandler() {
        String navn = txtUdflugtNavn.getText().trim();
        txtUdflugtNavn.clear();
        String dato = txtUdflugtDato.getText().trim();
        txtUdflugtDato.clear();
        String pris = txtUdflugtPris.getText().trim();
        txtUdflugtPris.clear();
        udflugter.add(navn + "--" + dato + "--" + pris);
        lvwUdflugter.getItems().setAll(udflugter);
    }

    private void gemHandler(Stage popupStage) {
        String konferenceArrangør = txtArrangør.getText().trim();
        String navn = txtNavn.getText().trim();
        String tilDato = txtTilDato.getText().trim();
        String fraDato = txtFraDato.getText().trim();
        String sted = txtSted.getText().trim();
        String pris = txtAfgift.getText().trim();
        ArrayList<Udflugt> udflugterList = new ArrayList<>();
        ArrayList<Hotel> hotelArrayList = new ArrayList<>(lvwHoteller.getSelectionModel().getSelectedItems());
        Konference k1 = Controller.createKonference(Integer.parseInt(pris), LocalDate.parse(fraDato), LocalDate.parse(tilDato), sted, navn, konferenceArrangør);

        for (String s : udflugter) {
            String[] array = s.split("--");
            udflugterList.add(Controller.createUdflugt(array[0], Double.parseDouble(array[2]), LocalDate.parse(array[1]), k1));
        }
        for (Hotel h : hotelArrayList) {
            k1.addHotel(h);
        }
        konferenceListView.getItems().setAll(Controller.getKonferencer());
        TilmeldingPane.updatePane();
        OversigtPane.updatePane();

        popupStage.close();

    }
}