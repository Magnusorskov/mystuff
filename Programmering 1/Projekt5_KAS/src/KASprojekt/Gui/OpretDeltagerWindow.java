package KASprojekt.Gui;

import KASprojekt.Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;


public class OpretDeltagerWindow extends Stage {

    public OpretDeltagerWindow() {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);


        this.setTitle("Opret Deltager");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    private Label lblNavn, lblAdresse, lblLandBy, lblFirmaNr, lblFirmaNavn, lblTlfNr;
    private TextField txfNavn, txfAdresse, txfLandBy, txfFirmaNr, txfFirmaNavn, txfTlfNr;
    private Button btnOpret, btnAnnuller;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblNavn = new Label("Navn:");
        pane.add(lblNavn,0,0);

        txfNavn = new TextField();
        pane.add(txfNavn,0,1);

        lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse,0,2);

        txfAdresse = new TextField();
        pane.add(txfAdresse,0,3);

        lblLandBy = new Label("Land/By");
        pane.add(lblLandBy,0,4);

        txfLandBy = new TextField();
        pane.add(txfLandBy,0,5);

        lblFirmaNavn = new Label("Firma Navn");
        pane.add(lblFirmaNavn,1,0);

        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn,1,1);

        lblFirmaNr = new Label("Firma nummer");
        pane.add(lblFirmaNr,1,2);

        txfFirmaNr = new TextField();
        pane.add(txfFirmaNr,1,3);

        lblTlfNr = new Label("Telefon nr");
        pane.add(lblTlfNr,1,4);

        txfTlfNr = new TextField();
        pane.add(txfTlfNr,1,5);

        btnAnnuller = new Button("Annuller");
        pane.add(btnAnnuller,1,6);
        btnAnnuller.setOnAction(event -> this.close());

        btnOpret = new Button("Opret Deltager");
        pane.add(btnOpret,1,7);
        btnOpret.setOnAction(event -> opretAction());


    }

    private void opretAction() {
        String navn = txfNavn.getText();
        String adresse = txfAdresse.getText();
        String landBy = txfLandBy.getText();
        String firmaNr = txfFirmaNr.getText();
        String firmaNavn = txfFirmaNavn.getText();
        String tlfNr = txfTlfNr.getText();

        Controller.createDeltager(navn,adresse,landBy,firmaNr,firmaNavn,tlfNr);
        this.close();
    }


}
