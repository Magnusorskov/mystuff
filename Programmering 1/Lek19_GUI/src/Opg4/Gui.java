package Opg4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Gui Demo 1");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------
	private final TextField txfNumber = new TextField("50");
	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblNumber = new Label("Number:");
		pane.add(lblNumber, 0, 1);

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		pane.add(txfNumber, 1, 1,2,1);

		Button btnPlus = new Button("+");
		pane.add(btnPlus,3,0);

		Button btnMinus = new Button(" -");
		pane.add(btnMinus,3,2);

		btnPlus.setOnAction(event -> plusNumber());
		btnMinus.setOnAction(event -> minusNumber());

	}

	private void plusNumber() {
		int number = Integer.parseInt(txfNumber.getText()) + 1;
		txfNumber.setText(String.valueOf(number));
	}

	private void minusNumber() {
		int number = Integer.parseInt(txfNumber.getText()) - 1;
		txfNumber.setText(String.valueOf(number));
	}
}
