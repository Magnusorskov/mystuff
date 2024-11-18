package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class StartWindow extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Arcitecture Demo");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    ListView<Forestilling> lvwForestillinger = new ListView<>();
    ListView<Kunde> lvwKunder = new ListView<>();
    ListView<Plads> lvwPladser = new ListView<>();
    TextField txfNavn, txfStartDato, txfSlutDato, txfKundeNavn, txfKundeMobil, txfDato;

    private void initContent(GridPane pane) {
        GridPane gridPane = new GridPane();
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lbForestillinger = new Label("Forestillinger");
        Label lbKunder = new Label("Kunder");
        Label lblPladser = new Label("Pladser");
        pane.add(lblPladser, 4, 0);
        pane.add(lbForestillinger, 0, 0);
        pane.add(lbKunder, 2, 0);

        pane.add(lvwForestillinger, 0, 1, 2, 1);
        lvwForestillinger.setPrefSize(150, 150);
        lvwForestillinger.getItems().setAll(Controller.getForestillinger());

        pane.add(lvwKunder, 2, 1, 2, 1);
        lvwKunder.setPrefSize(150, 150);
        lvwKunder.getItems().setAll(Controller.getKunder());

        pane.add(lvwPladser, 4, 1, 2, 1);
        lvwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwPladser.getItems().setAll(Controller.getPladser());

        Label lbNavn = new Label("Navn");
        pane.add(lbNavn, 0, 2);
        txfNavn = new TextField();
        pane.add(txfNavn, 1, 2);

        Label lbKundeNavn = new Label("Kunde navn");
        pane.add(lbKundeNavn, 2, 2);
        txfKundeNavn = new TextField();
        pane.add(txfKundeNavn, 3, 2);


        Label lbStartDato = new Label("Start Dato");
        pane.add(lbStartDato, 0, 3);
        txfStartDato = new TextField();
        pane.add(txfStartDato, 1, 3);

        Label lbKundeMobil = new Label("Kunde Mobil");
        pane.add(lbKundeMobil, 2, 3);
        txfKundeMobil = new TextField();
        pane.add(txfKundeMobil, 3, 3);

        Label lbSlutDato = new Label("Slut Dato");
        pane.add(lbSlutDato, 0, 4);
        txfSlutDato = new TextField();
        pane.add(txfSlutDato, 1, 4);

        Label lblDato = new Label("Dato");
        pane.add(lblDato, 4, 2);

        txfDato = new TextField();
        pane.add(txfDato, 5, 2);

        Button btnOpretForestilling = new Button("Opret Forestilling");
        pane.add(btnOpretForestilling, 1, 5);
        btnOpretForestilling.setOnAction(event -> opretForestillingAction());

        Button btnOpretKunde = new Button("Opret Kunde");
        pane.add(btnOpretKunde, 3, 4);
        btnOpretKunde.setOnAction(event -> btnOpretKundeAction());

        Button btnOpretBestilling = new Button("Opret Bestilling");
        pane.add(btnOpretBestilling, 5, 3);
        btnOpretBestilling.setOnAction(event -> btnOpretBestillingAction());

        Label lblStatistisk = new Label("Statistik");
        pane.add(lblStatistisk, 0, 7);

        Button btnAntalBestiltePladserPåDag = new Button("Antal bestilte pladser");
        pane.add(btnAntalBestiltePladserPåDag, 0, 8);
        btnAntalBestiltePladserPåDag.setOnAction(event -> btnAntalBestiltePladserPåDagAction());

        Button btnSuccessDato = new Button("Succes dato");
        pane.add(btnSuccessDato, 0, 9);
        btnSuccessDato.setOnAction(event -> btnSuccesDatoAction());

        Button btnBestiltePladserTilForestilling = new Button("Bestilte Pladser Til Forestilling");
        pane.add(btnBestiltePladserTilForestilling, 0, 10);
        btnBestiltePladserTilForestilling.setOnAction(event -> btnbestiltePladserTilForestillingPådagAction());

    }

    private void opretForestillingAction() {
        String name = txfNavn.getText();
        LocalDate startDato = LocalDate.parse(txfStartDato.getText());
        LocalDate slutDato = LocalDate.parse(txfSlutDato.getText());

        if (name.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("Not all fields filled out");
            alert.setContentText("Please fill out both Name and Title");
            alert.show();
        } else {
            Controller.createForestilling(name, startDato, slutDato);
            lvwForestillinger.getItems().setAll(Controller.getForestillinger());
            txfNavn.clear();
            txfStartDato.clear();
            txfSlutDato.clear();
        }

    }

    private void btnOpretKundeAction() {
        Controller.createKunde(txfKundeNavn.getText(), txfKundeMobil.getText());
        lvwKunder.getItems().setAll(Controller.getKunder());
        txfKundeNavn.clear();
        txfKundeMobil.clear();
    }

    private void btnOpretBestillingAction() {
        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.parse(txfDato.getText());
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();

        ObservableList<Plads> selectedItems = lvwPladser.getSelectionModel().getSelectedItems();
        ArrayList<Plads> pladser = new ArrayList<>(selectedItems);

        Bestilling bestilling = Controller.opretBestillingMedPladser(forestilling, kunde, dato, pladser);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (bestilling == null) {
            alert.setHeaderText("Bestilling blev ikke oprettet");
        } else {
            alert.setHeaderText("Bestilling blev oprettet!");
            alert.setContentText("Du har bestilt " + bestilling.getPladser().size() + " pladser til " + forestilling + " den " + dato + "\nSamlet pris: " + bestilling.samletPris());
        }
        alert.show();
    }

    private void btnAntalBestiltePladserPåDagAction() {
        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.parse(txfDato.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Antal bestilte pladser for " + forestilling.getNavn() + " på datoen " + dato);
        alert.setContentText("" + forestilling.antalBestiltePladserPåDag(dato));
        alert.show();

    }

    private void btnSuccesDatoAction() {
        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Den mest succesfulde dag for " + forestilling.getNavn());
        alert.setContentText("" + forestilling.succesDato());
        alert.show();
    }

    private void btnbestiltePladserTilForestillingPådagAction() {
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        LocalDate dato = LocalDate.parse(txfDato.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(kunde + "'s bestilte pladser til " + forestilling.getNavn() + " på dagen: " + dato);

        StringBuilder pladser = new StringBuilder();
        for (Plads plads : kunde.bestiltePladserTilForestilling(forestilling, dato)) {
            pladser.append(plads + "\n");
        }
        alert.setContentText(pladser.toString());
        alert.show();
    }
}
