package Opg3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	private final TextField txfName = new TextField();
	private final TextField txfName1Split = new TextField();
	private final TextField txfName2Split = new TextField();

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);


		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		pane.add(txfName, 1, 0,2,1);

		pane.add(txfName1Split,1,1,1,1);

		pane.add(txfName2Split,2,1,1,1);

		// add a button to the pane (at col=1, row=1)
		Button btnSplit = new Button("Split");
		pane.add(btnSplit, 1, 2);
		GridPane.setMargin(btnSplit, new Insets(10, 10, 0, 10));

		btnSplit.setOnAction(event -> splitNames());

	}

	private void splitNames() {
		String name = txfName.getText();
		int spaceIndex = name.indexOf(" ");
		String firstName = name.substring(0,spaceIndex);
		String lastName = name.substring(spaceIndex);
		txfName1Split.setText(firstName);
		txfName2Split.setText(lastName);
	}
}
