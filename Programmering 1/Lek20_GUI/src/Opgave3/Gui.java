package Opgave3;

import demoopenwindow.Movie;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
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

        personWindow = new PersonInputWindow("Add a person",stage);
    }

    // -------------------------------------------------------------------------
    private PersonInputWindow personWindow;
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblPersons = new Label("Persons:");
        pane.add(lblPersons, 0, 0);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 1, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 0);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addPersonAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 6, 3);

        // connect a method to the button
        btnDelete.setOnAction(event -> this.deleteAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addPersonAction() {
        personWindow.showAndWait();

        // wait for the dialog to close ...

        if (personWindow.getActualPerson()!= null) {
            Person person = personWindow.getActualPerson();
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
        }
    }

    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            persons.remove(index);
            txfName.clear();
            lvwPersons.getItems().setAll(persons);
        }
    }

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
            txfTitle.setText(newPerson.getTitle());
        } else {
            txfName.clear();
            txfTitle.clear();
        }
    }
}
