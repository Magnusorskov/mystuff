package Opgave4og5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> boys = new ArrayList<>();
    private final ArrayList<Person> girls = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final ToggleGroup group = new ToggleGroup();
    private RadioButton rbGirl = new RadioButton();
    private RadioButton rbBoy = new RadioButton();

    private void initContent(GridPane pane) {
        this.initPersons();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);

        HBox box = new HBox();
        pane.add(box, 0, 0);


        box.getChildren().add(rbBoy);
        rbBoy.setText("Boy");
        rbBoy.setToggleGroup(group);
        rbBoy.setUserData(lvwPersons.getItems().setAll(boys));
        rbBoy.setOnAction(event -> lvwPersons.getItems().setAll(boys));


        box.getChildren().add(rbGirl);
        rbGirl.setText("Girl");
        rbGirl.setToggleGroup(group);
        rbGirl.setUserData(lvwPersons.getItems().setAll(girls));
        rbGirl.setOnAction(event -> lvwPersons.getItems().setAll(girls));

        rbBoy.setSelected(true);
        lvwPersons.getItems().setAll(boys);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 1, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(boys);

        pane.add(txfName, 1, 6, 2, 1);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 0);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 6, 3);

        // connect a method to the button
        btnDelete.setOnAction(event -> this.deleteAction());



    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();

        if (name.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information");
            alert.setHeaderText("Not all fields filled out");
            alert.setContentText("Please fill out both Name and Title");
            alert.show();
        }
        else if (rbBoy.isSelected()) {
            Person p = new Person(name,true);
            boys.add(p);
            lvwPersons.getItems().setAll(boys);
            txfName.clear();
        }
        else {
            Person p = new Person(name,false);
            girls.add(p);
            lvwPersons.getItems().setAll(girls);
            txfName.clear();
        }
    }

    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        if (index >= 0 && rbBoy.isSelected()) {
            boys.remove(index);
            txfName.clear();
            lvwPersons.getItems().setAll(boys);
        }
        else if (index >= 0) {
            girls.remove(index);
            txfName.clear();
            lvwPersons.getItems().setAll(girls);
        }
    }

    private void initPersons() {
        // Example data for boys and girls lists
        boys.add(new Person("John", true));
        boys.add(new Person("Mike", true));
        girls.add(new Person("Anna", false));
        girls.add(new Person("Emma", false));
    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
    }
}


}
