package KASprojekt.Gui;

import KASprojekt.Controller.Controller;
import KASprojekt.Model.Hotel;
import KASprojekt.Model.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HotelPane extends GridPane {
    private TextField txfNavn;

    private ListView hotelList;

    private Button btnOpretHotel;

    public HotelPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        hotelList = new ListView();
        hotelList.getItems().setAll(Controller.getHoteller());
        this.add(hotelList, 0, 0, 1, 2);

        btnOpretHotel = new Button("Opret Hotel");
        this.add(btnOpretHotel, 1, 0);

        // Add event handler to the button
        btnOpretHotel.setOnAction(event -> {
            createHotelPopup();
        });
    }

    private TextField txtHotelName, txtPrisEnkelt, txtPrisDobbelt, txtServicePris;
    private ObservableList<String> serviceObservableList;

    private void createHotelPopup() {
        // Create a new stage (popup window)
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Opret Nyt Hotel");


        // Create layout for the popup
        GridPane pane1 = new GridPane();
        pane1.setHgap(20);
        pane1.setVgap(20);
        int venstreVGap = 0;
        int højreVGap = 0;

        ArrayList<String> serviceList = new ArrayList<>();


        //tilføj navn tekstfelt og label
        Label lblHotelInfo = new Label("Hotelinfo:");
        pane1.add(lblHotelInfo, 1, venstreVGap);
        venstreVGap++;
        txtHotelName = new TextField();
        txtHotelName.setPromptText("Hotel Navn");
        pane1.add(txtHotelName, 1, venstreVGap);
        Label lblNavn = new Label("Navn:");
        pane1.add(lblNavn, 0, venstreVGap);
        venstreVGap++;

        //tilføj pris for enkeltværelse tekstfelt og label
        txtPrisEnkelt = new TextField();
        txtPrisEnkelt.setPromptText("Pris for enkeltværelse");
        pane1.add(txtPrisEnkelt, 1, venstreVGap);
        Label lblPrisEnkelt = new Label("Pris Enkelt:");
        pane1.add(lblPrisEnkelt, 0, venstreVGap);
        venstreVGap++;

        //tilføj pris for dobbeltværelse tekstfelt og label
        txtPrisDobbelt = new TextField();
        txtPrisDobbelt.setPromptText("Pris for dobbeltværelse");
        pane1.add(txtPrisDobbelt, 1, venstreVGap);
        Label lblPrisdobbelt = new Label("Pris Dobbelt:");
        pane1.add(lblPrisdobbelt, 0, venstreVGap);
        venstreVGap++;

        //tilføj service labels og tekstfelt tekstfelt og label
        Label lblOpretService = new Label("Serviceinfo:");
        pane1.add(lblOpretService, 3, højreVGap);
        højreVGap++;
        TextField txtService = new TextField();
        txtService.setPromptText("Navn/beskrivelse");
        pane1.add(txtService, 3, højreVGap);
        Label lblService = new Label("Service:");
        pane1.add(lblService, 2, højreVGap);
        højreVGap++;

        //tilføj service pris label og tekstfelt
        txtServicePris = new TextField();
        txtServicePris.setPromptText("Prisen på servicen");
        pane1.add(txtServicePris, 3, højreVGap);
        Label lblServicePris = new Label("Service Pris:");
        pane1.add(lblServicePris, 2, højreVGap);
        højreVGap++;

        //buttons
        Button btnGem = new Button("Gem Hotel");
        pane1.add(btnGem, 0, venstreVGap);
        venstreVGap++;
        Button btnCancel = new Button("Annuller");
        pane1.add(btnCancel, 0, venstreVGap);
        Button btnOpretService = new Button("Opret service");
        pane1.add(btnOpretService, 3, højreVGap);
        højreVGap++;

        serviceObservableList = FXCollections.observableArrayList();
        ListView<String> serviceListView = new ListView<>(serviceObservableList);
        serviceListView.setMaxSize(100, 200);
        pane1.add(serviceListView, 3, højreVGap, 2, 2);


        // Handle Save button click
        btnGem.setOnAction(e -> saveButtonAction(popupStage));

        // Handle Cancel button click
        btnCancel.setOnAction(e -> popupStage.close());

        // handle opret service button
        btnOpretService.setOnAction(e -> {
            String beskrivelse = txtService.getText().trim();
            String pris = txtServicePris.getText().trim();
            if (beskrivelse.contains("-")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Bindestreg er ikke tilladt");
                alert.showAndWait();
            } else if (!beskrivelse.isEmpty() && !pris.isEmpty()) {
                txtService.clear();
                txtServicePris.clear();
                serviceObservableList.add(beskrivelse + "-" + pris);
            }
        });

        // Set the scene and show the popup
        Scene scene = new Scene(pane1, 700, 500);
        popupStage.setScene(scene);
        popupStage.showAndWait();
    }

    private void saveButtonAction(Stage popupStage) {
        try {
            String hotelName = txtHotelName.getText().trim();
            String enkeltPris = txtPrisEnkelt.getText().trim();
            String dobbeltPris = txtPrisDobbelt.getText().trim();
            if (!hotelName.isEmpty() && !enkeltPris.isEmpty() && !dobbeltPris.isEmpty()) {
                Hotel hotel = Controller.createHotel(Double.parseDouble(enkeltPris), Double.parseDouble(dobbeltPris), hotelName);
                for (String s : serviceObservableList) {
                    String[] hInfo = s.split("-");
                    Controller.createService(hInfo[0], Double.parseDouble(hInfo[1]), hotel);
                }
                hotelList.getItems().setAll(Controller.getHoteller());
                popupStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Der mangler info om hotellet", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e1) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Skrive kun tal i prisfelterne");
            alert.showAndWait();
        }
    }
}

