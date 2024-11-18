package Opgave2.guifx;

import Opgave2.application.controller.Controller;
import Opgave2.application.model.Company;
import Opgave2.application.model.Customer;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class CustomersWindow extends Stage {
    private Company company;

    public CustomersWindow(String title, Company company) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.company = company;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }


    private ListView<Customer> lvwCustomers;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblCustomers = new Label("Customers");
        pane.add(lblCustomers, 0, 0);

        lvwCustomers = new ListView<>();
        lvwCustomers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        pane.add(lvwCustomers, 0, 1);
        for (Customer customer : Controller.getCustomers()) {
            if (company.getCustomers().contains(customer)) {
                lvwCustomers.getItems().add(customer);
            }
        }


        Button btnAdd = new Button("Add Customers");
        pane.add(btnAdd, 1, 1);
        btnAdd.setOnAction(event -> addAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK,1,2);
        btnOK.setOnAction(event -> hide());

    }

    private void addAction() {
        ObservableList<Customer> selectedItems = lvwCustomers.getSelectionModel().getSelectedItems();
        ArrayList<Customer> tempCustomerList = new ArrayList<>(selectedItems);

        for (Customer customer : tempCustomerList) {
            if (customer != null) {
                company.addCustomer(customer);
                lvwCustomers.getItems().remove(customer);
            }
        }
    }


}
