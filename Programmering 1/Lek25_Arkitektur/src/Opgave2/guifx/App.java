package Opgave2.guifx;

import Opgave2.application.controller.Controller;
import Opgave2.application.model.Company;
import Opgave2.application.model.Customer;
import javafx.application.Application;

public class App {

	public static void main(String[] args) {
		initStorage();
		Application.launch(StartWindow.class);
	}
	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		Company c1 = Controller.createCompany("IBM", 37);
		Company c2 = Controller.createCompany("AMD", 40);
		Controller.createCompany("SLED", 45);
		Controller.createCompany("Vector", 32);

		Controller.createEmployee("Bob Dole", 210, c2,2024);
		Controller.createEmployee("Alice Schmidt", 250, c1,2024);
		Controller.createEmployee("George Down", 150, c2,2024);

		Controller.createEmployee("Rita Uphill", 300);

		Customer customer1 = Controller.createCustomer("Magnus");
		Customer customer2 = Controller.createCustomer("Mikkel");
		Customer customer3 = Controller.createCustomer("Peter");
		Customer customer4 = Controller.createCustomer("Sophia");
		Customer customer5 = Controller.createCustomer("Lucas");
		Customer customer6 = Controller.createCustomer("Emma");
		Customer customer7 = Controller.createCustomer("Oliver");
		Customer customer8 = Controller.createCustomer("Isabella");
		Customer customer9 = Controller.createCustomer("Liam");
		Customer customer10 = Controller.createCustomer("Mia");
		Customer customer11 = Controller.createCustomer("Noah");
		c1.addCustomer(customer2);
		c2.addCustomer(customer2);
		c2.addCustomer(customer1);
	}


}
