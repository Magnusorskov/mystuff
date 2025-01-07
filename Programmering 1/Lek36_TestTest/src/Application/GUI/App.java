package Application.GUI;

import Controller.Controller;
import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        Application.launch(StartWindow.class);

    }
}
