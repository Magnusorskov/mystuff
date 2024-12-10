package KASprojekt.Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartWindow extends Application {


	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS Projekt");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabTilmelding = new Tab("Tilmed Konference");
		tabPane.getTabs().add(tabTilmelding);

		TilmeldingPane tilmeldingPane = new TilmeldingPane();
		tabTilmelding.setContent(tilmeldingPane);


		Tab tabDeltager = new Tab("Find Deltager");
		tabPane.getTabs().add(tabDeltager);

		DeltagerPane deltagerPane = new DeltagerPane();
		tabDeltager.setContent(deltagerPane);

		Tab tabHotel = new Tab("Opret Hotel");
		tabPane.getTabs().add(tabHotel);

		HotelPane hotelPane = new HotelPane();
		tabHotel.setContent(hotelPane);

		Tab tabTKonference = new Tab("Opret Konference");
		tabPane.getTabs().add(tabTKonference);

		KonferencePane konferencePane = new KonferencePane();
		tabTKonference.setContent(konferencePane);

		Tab tabOversigt = new Tab("Oversigter");
		tabPane.getTabs().add(tabOversigt);

		OversigtPane oversigtPane = new OversigtPane();
		tabOversigt.setContent(oversigtPane);

	}


}
