package KASprojekt.Gui;


import KASprojekt.Controller.Controller;
import KASprojekt.Model.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class DeltagerPane extends GridPane {
    private TextField txfNavn;
    private Label lblDeltagerNavn, lblTilmeldinger, lblNavnOgTlf, lblPrisIAlt, lblLandBy, lblAdresse;
    private Button btnSøgDeltager;
    private TextArea txtaTilmeldinger;


    public DeltagerPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        btnSøgDeltager = new Button("Søg Deltager");
        this.add(btnSøgDeltager, 0, 0);

        lblDeltagerNavn = new Label("Navn på deltager");
        this.add(lblDeltagerNavn, 0, 1);

        txfNavn = new TextField();
        this.add(txfNavn, 0, 2);

        lblPrisIAlt = new Label("Pris i alt: ");
        this.add(lblPrisIAlt, 0, 3);

        lblNavnOgTlf = new Label("Navn og Telefon: ");
        this.add(lblNavnOgTlf, 1, 0);

        lblLandBy = new Label("Land/By: ");
        this.add(lblLandBy,1,1);

        lblAdresse = new Label("Adresse: ");
        this.add(lblAdresse,1,2);

        lblTilmeldinger = new Label("Tilmeldinger:");
        this.add(lblTilmeldinger, 1, 3);

        txtaTilmeldinger = new TextArea();
        this.add(txtaTilmeldinger, 1, 4, 2, 2);

        btnSøgDeltager.setOnAction(event -> hentTilmeldingsInformation());

    }

    private void hentTilmeldingsInformation() {
        Deltager deltager = Controller.findDeltager(txfNavn.getText());
        if (deltager == null) {
            txtaTilmeldinger.setText("Deltager ikke fundet!");
        } else {
            StringBuilder sb = Controller.stringBuilderDeltagerTilmeldinger(deltager);
            txtaTilmeldinger.setText(String.valueOf(sb));
            lblPrisIAlt.setText("Pris i alt: " + deltager.sumAfTilmeldinger(deltager));
            lblNavnOgTlf.setText("Navn og Telefon: " + deltager.getNavn() + "(" + deltager.getTlfNr() + ")");
            lblLandBy.setText("Land/By: " + deltager.getLandBy());
            lblAdresse.setText("Adresse: " + deltager.getAdresse());
        }
    }


}