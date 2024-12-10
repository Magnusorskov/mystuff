package KASprojekt.Gui;
import KASprojekt.Controller.Controller;
import KASprojekt.Model.Konference;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class OversigtPane extends GridPane{
    private Label lblKonferencer;
    private static  ListView lvwKonferencer;
    private Button btnDeltagerOversigt, btnHotelOversigt, btnUdflugtOversigt;
    private int number = 0;

    public OversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        lblKonferencer = new Label("Liste over konferencer");
        this.add(lblKonferencer, 0,0);

        lvwKonferencer = new ListView();
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
        this.add(lvwKonferencer,0,1);

        VBox vBoxButtons = new VBox(40);
        this.add(vBoxButtons, 1, 1, 1, 1);
        vBoxButtons.setPadding(new Insets(10, 0, 0, 0));
        vBoxButtons.setAlignment(Pos.TOP_LEFT);

        btnDeltagerOversigt = new Button("Se deltager oversigt");
        vBoxButtons.getChildren().add(btnDeltagerOversigt);
        btnDeltagerOversigt.setOnAction(event -> seDeltagerOversigt());

        btnHotelOversigt = new Button("Se hotel oversigt");
        vBoxButtons.getChildren().add(btnHotelOversigt);
        btnHotelOversigt.setOnAction(event -> seHotelOversigt());

        btnUdflugtOversigt = new Button("Se udflugts oversigt");
        vBoxButtons.getChildren().add(btnUdflugtOversigt);
        btnUdflugtOversigt.setOnAction(event -> seUdflugtOversigt());
    }

    private void seUdflugtOversigt() {
        UdflugtOversigtWindow udflugtOversigtWindow = new UdflugtOversigtWindow((Konference) lvwKonferencer.getSelectionModel().getSelectedItem());
        udflugtOversigtWindow.showAndWait();
    }

    private void seHotelOversigt() {
        HotelOversigtWindow hotelOversigtWindow = new HotelOversigtWindow();
        hotelOversigtWindow.showAndWait();
    }

    private void seDeltagerOversigt() {
        DeltagerOversigtWindow deltagerOversigtWindow = new DeltagerOversigtWindow((Konference) lvwKonferencer.getSelectionModel().getSelectedItem());
        deltagerOversigtWindow.showAndWait();
    }

    public static void updatePane() {
        lvwKonferencer.getItems().setAll(Controller.getKonferencer());
    }
}
