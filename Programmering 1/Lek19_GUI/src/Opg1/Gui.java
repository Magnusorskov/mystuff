package Opg1;

import javafx.application.Application;
import javafx.event.Event;
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
	private final TextField txfName1 = new TextField();
	private final TextField txfName2 = new TextField();
	private final TextField txfCombinedName = new TextField();



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
		pane.add(txfName1, 1, 0,1,1);

		pane.add(txfName2, 2,0,1,1);

		pane.add(txfCombinedName,1,1,2,1);

		// add a button to the pane (at col=1, row=1)
		Button kombiner = new Button("Kombiner");
		pane.add(kombiner, 1, 2,1,1);
		GridPane.setMargin(kombiner, new Insets(10, 10, 0, 10));

		kombiner.setOnAction(Event -> this.kombinerNavne());
	}

	private void kombinerNavne() {
		String name = txfName1.getText().trim() + " " + txfName2.getText().trim();
		txfCombinedName.setText(name);
	}
}
