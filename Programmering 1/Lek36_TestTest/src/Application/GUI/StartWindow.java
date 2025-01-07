package Application.GUI;

import Application.Model.*;
import Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StartWindow extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Fraværssystem");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    ListView lvwDeltagelse = new ListView<>();
    ListView lvwLektion = new ListView<>();

    ToggleGroup group = new ToggleGroup();
    RadioButton rbTILSTEDE = new RadioButton("Tilstede");
    RadioButton rbFravær = new RadioButton("Fravær");
    RadioButton rbSyg = new RadioButton("Syg");
    RadioButton rbAfbud = new RadioButton("Afbud");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblFag = new Label("Fag");
        Label lblLektion = new Label("Lektion");
        Label lblDeltagelse = new Label("Deltagelse");
        Label lblFraværsårsager = new Label("Fraværsårsager");

        pane.add(lblFag, 0, 0);
        pane.add(lblLektion, 1, 0);
        pane.add(lblDeltagelse, 2, 0);
        pane.add(lblFraværsårsager, 3, 0);

        ListView lvwFag = new ListView();
        lvwFag.getItems().setAll(Controller.getFag());

        lvwFag.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lvwLektion.getItems().setAll(Controller.getLektioner((Fag) lvwFag.getSelectionModel().getSelectedItem()));
            }
        });


        lvwLektion.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lvwDeltagelse.getItems().setAll(Controller.getDeltagelser((Lektion) lvwLektion.getSelectionModel().getSelectedItem()));
            }
        });

        pane.add(lvwFag, 0, 1);
        pane.add(lvwLektion, 1, 1);
        pane.add(lvwDeltagelse, 2, 1);

        VBox box = new VBox();
        pane.add(box, 3, 1);



        box.getChildren().add(rbTILSTEDE);
        rbTILSTEDE.setUserData(DeltagerStatus.TILSTEDE);
        rbTILSTEDE.setToggleGroup(group);
        rbTILSTEDE.setSelected(true);


        box.getChildren().add(rbFravær);
        rbFravær.setUserData(DeltagerStatus.FRAVÆR);
        rbFravær.setToggleGroup(group);


        box.getChildren().add(rbSyg);
        rbSyg.setUserData(DeltagerStatus.SYG);
        rbSyg.setToggleGroup(group);


        box.getChildren().add(rbAfbud);
        rbAfbud.setUserData(DeltagerStatus.AFBUD);
        rbAfbud.setToggleGroup(group);

        Button btnFravær = new Button("Fravær");
        pane.add(btnFravær,3,1);
        btnFravær.setOnAction(event -> fraværAction());
    }

    private void fraværAction() {
        Controller.setFravær((Deltagelse) lvwDeltagelse.getSelectionModel().getSelectedItem(), (DeltagerStatus) group.getSelectedToggle().getUserData());
        lvwDeltagelse.getItems().setAll(Controller.getDeltagelser((Lektion) lvwLektion.getSelectionModel().getSelectedItem()));
    }
}
