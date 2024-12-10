package KASprojekt.Gui;

import KASprojekt.Controller.Controller;
import KASprojekt.Model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class TilmeldingPane extends GridPane {


    private static ListView<Konference> lstKonference = new ListView<>();


    public TilmeldingPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(20);
        this.setGridLinesVisible(false);
        this.add(lstKonference, 0, 0, 1, 2);
        lstKonference.getItems().setAll(Controller.getKonferencer());
        lstKonference.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Button btnOpretTilmelding = new Button("Opret tilmelding");
        this.add(btnOpretTilmelding, 1, 0);
        btnOpretTilmelding.setOnAction(event -> showPopupForSelectedItem(lstKonference.getSelectionModel().getSelectedItem()));


    }

    private TextField txtLedsagerNavn;
    private CheckBox foredragsholderCheckBox;
    private TextField txtDatoFra;
    private TextField txtDatoTil;
    private ListView<Udflugt> udflugtListView;
    private ListView<Hotel> hotelListView;
    private ListView<Service> serviceListView;
    private ListView<Deltager> deltagerListView;
    private Button btnGem;
    private Button btnOpretDeltager;

    private void showPopupForSelectedItem(Konference konference) {
        try {
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Indtast tilmeldingsinfo");

            GridPane pane = new GridPane();
            pane.setPadding(new Insets(10));
            pane.setVgap(10);
            pane.setHgap(30);

            int Row1VGap = 0;
            int Row2VGap = 0;
            int Row3VGap = 0;
            int Row4VGap = 3;


            //diverse informationer om konferencen
            Label lblKonferenceNavn = new Label(konference.toString());
            pane.add(lblKonferenceNavn, 0, Row1VGap);
            Row1VGap++;

            Label lblDetails = new Label("Dato: " + konference.getStart() + "/" + konference.getSlut());
            pane.add(lblDetails, 0, Row1VGap);
            Row1VGap++;

            Label lblKonferenceSted = new Label("Adresse: " + konference.getSted());
            pane.add(lblKonferenceSted, 0, Row1VGap);
            Row1VGap++;

            Label lblKonferenceAfgift = new Label("Afgift: " + (int) konference.getAfgift() + ",-");
            pane.add(lblKonferenceAfgift, 0, Row1VGap);
            Row1VGap++;

            //deltager liste at vælge imellem
            Row1VGap++;
            Label lblDeltager = new Label("Deltager:");
            pane.add(lblDeltager, 0, Row1VGap);
            Row1VGap++;
            deltagerListView = new ListView<>();
            deltagerListView.getItems().setAll(Controller.getDeltagere());
            deltagerListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            deltagerListView.setMaxSize(150, 300);
            pane.add(deltagerListView, 0, Row1VGap);
            Row1VGap++;



            btnOpretDeltager = new Button("Opret Deltager");
            pane.add(btnOpretDeltager, 0, 7);
            btnOpretDeltager.setOnAction(event -> opretDeltager());

            //felter om tilmeldingen
            Label lblLedsagerNavn = new Label("Navn på ledsager:");
            pane.add(lblLedsagerNavn, 1, Row2VGap);
            Row2VGap++;
            txtLedsagerNavn = new TextField();
            pane.add(txtLedsagerNavn, 2, Row3VGap);
            Row3VGap++;

            //foredragsholdlerstatusinfo
            Label lblForedragsholder = new Label("Er du foredragsholder?");
            pane.add(lblForedragsholder, 1, Row2VGap);
            Row2VGap++;
            foredragsholderCheckBox = new CheckBox("Ja");
            pane.add(foredragsholderCheckBox, 2, Row3VGap);
            Row3VGap++;

            //valg a dato
            Label lblDatoFra = new Label("Fra:");
            pane.add(lblDatoFra, 1, Row2VGap);
            Row2VGap++;
            txtDatoFra = new TextField(konference.getStart().toString());
            txtDatoFra.setPromptText("ÅÅÅÅ-MM-DD");
            pane.add(txtDatoFra, 1, Row2VGap);
            Row2VGap++;

            Label lblDatoTil = new Label("Til:");
            pane.add(lblDatoTil, 2, Row3VGap);
            Row3VGap++;
            txtDatoTil = new TextField(konference.getSlut().toString());
            txtDatoTil.setPromptText("ÅÅÅÅ-MM-DD");
            pane.add(txtDatoTil, 2, Row3VGap);
            Row3VGap++;

            //udflugtsliste
            Label lblUdflugter = new Label("Vælg udflugter:");
            pane.add(lblUdflugter, 1, Row2VGap + 1);
            Row2VGap++;
            udflugtListView = new ListView<>();
            udflugtListView.getItems().setAll(konference.getUdflugter());
            udflugtListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            udflugtListView.setMaxSize(150, 300);
            pane.add(udflugtListView, 1, Row2VGap + 1, 2, 1);

            //hotellsite at vælge imellem
            Label lblHoteller = new Label("Vælg hotel:");
            pane.add(lblHoteller, 2, Row3VGap + 1);
            Row3VGap++;

            hotelListView = new ListView<>();
            hotelListView.getItems().setAll(Controller.getHoteller());
            hotelListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            hotelListView.setMaxSize(150, 300);

            pane.add(hotelListView, 2, Row3VGap + 1, 1, 1);
            Row3VGap += 1;

            //serviceListe
            Row4VGap += 2;
            Label lblServices = new Label("Services:");
            pane.add(lblServices, 3, Row4VGap);
            Row4VGap++;
            serviceListView = new ListView<>();
            serviceListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            serviceListView.setMaxSize(150, 300);
            pane.add(serviceListView, 3, Row4VGap);
            Row4VGap++;

            ListView<Service> finalServiceListView1 = serviceListView;
            hotelListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    finalServiceListView1.getItems().setAll(hotelListView.getSelectionModel().getSelectedItem().getServices());
                }
            });
            //gemknap
            btnGem = new Button("Opret Tilmelding");
            pane.add(btnGem, 3, Row4VGap);
            btnGem.setOnAction(event -> handleSaveAction(popupStage));
            Row4VGap++;

            //knap der lukker vinduet og aflyser konferencen
            Button btnClose = new Button("Annullér");
            pane.add(btnClose, 3, Row4VGap);


            btnClose.setOnAction(event -> popupStage.close());


            Scene scene = new Scene(pane, 800, 600);
            popupStage.setScene(scene);
            popupStage.showAndWait();

        } catch (NullPointerException e) {
            Alert alert = new Alert(AlertType.WARNING, "Vælg en konference");
            alert.showAndWait();
        }

    }

    private void handleSaveAction(Stage popupStage) {
        Deltager deltager = deltagerListView.getSelectionModel().getSelectedItem();
        String ledsagerNavn = txtLedsagerNavn.getText().trim();
        if (ledsagerNavn.isEmpty()) {
            ledsagerNavn = null;
        }
        Boolean isForedragsholder = foredragsholderCheckBox.isSelected();
        LocalDate fraDato = LocalDate.parse(txtDatoFra.getText().trim());
        LocalDate tilDato = LocalDate.parse(txtDatoTil.getText().trim());
        Hotel hotel = hotelListView.getSelectionModel().getSelectedItem();
        ArrayList<Udflugt> udflugter = new ArrayList<>(udflugtListView.getSelectionModel().getSelectedItems());
        if (ledsagerNavn == null) {
            udflugter.clear();
        }
        ArrayList<Service> services = new ArrayList<>(serviceListView.getSelectionModel().getSelectedItems());
        Konference konference = lstKonference.getSelectionModel().getSelectedItem();

        Tilmelding tilmelding = Controller.createTilmelding(fraDato, tilDato, isForedragsholder, ledsagerNavn, deltager, hotel, udflugter, services, konference);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Tilmelding oprettet");
        alert.setContentText(String.valueOf(Controller.stringBuilderTilmeldingsOversigt(tilmelding)));
        alert.showAndWait();
        popupStage.close();
        updateKonferencer();

    }

    private void updateKonferencer() {
        lstKonference.getItems().setAll(Controller.getKonferencer());
    }

    private void opretDeltager() {
        OpretDeltagerWindow opretDeltagerWindow = new OpretDeltagerWindow();
        opretDeltagerWindow.showAndWait();
        updateDeltagere();
    }

    private void updateDeltagere() {
        deltagerListView.getItems().setAll(Controller.getDeltagere());
    }

    public static void updatePane() {
        lstKonference.getItems().setAll(Controller.getKonferencer());
    }


}