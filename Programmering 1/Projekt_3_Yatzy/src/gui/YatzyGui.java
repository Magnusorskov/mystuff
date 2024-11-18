package gui;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.YatzyDice;
import javafx.event.Event;
import model.YatzyHighscore;

import java.util.Comparator;
import java.util.Optional;

public class YatzyGui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------


    private TextField[] txfValues = new TextField[5];
    private TextField name = new TextField();
    private TextField[] txfResults = new TextField[15];
    private CheckBox[] chbHolds = new CheckBox[5];
    private String[] resultLabels = {"1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One pair", "Two pairs", "Three same", "Four same", "Full house", "Small straight", "Large straight", "Chance", "Yatzy",};
    private ListView<String> lvwHighscores = new ListView<>();
    private boolean[] holdsStatus = new boolean[5];
    private boolean[] disabledResults = new boolean[15];
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    YatzyHighscore yatzyHighscore;
    private Label lblRolled = new Label("Rolled: ");

    private Button btnRoll = new Button("Roll");
    private Button btnReset = new Button("Reset");

    private int sumSame = 0;
    private int sumOther = 0;
    private int sumTotal = 0;

    private Alert endGame;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // initialize txfValues, chbHolds, btnRoll and lblRolled
        for (int i = 0; i < 5; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(60, 60);
            txfValues[i].setAlignment(Pos.CENTER);
            txfValues[i].setFont(new Font("Arial", 30));
            txfValues[i].setEditable(false);
            dicePane.add(txfValues[i], i, 0, 1, 1);
        }


        for (int i = 0; i < 5; i++) {
            chbHolds[i] = new CheckBox();
            chbHolds[i].setText("Hold");
            chbHolds[i].setDisable(true);
            dicePane.add(chbHolds[i], i, 1, 1, 1);
            GridPane.setHalignment(chbHolds[i], HPos.CENTER);

        }

        btnRoll.setText("Roll");
        btnRoll.setPrefSize(60, 30);
        dicePane.add(btnRoll, 3, 2);

        dicePane.add(lblRolled, 4, 2);

        btnRoll.setOnAction(event -> btnRollAction());

        btnReset.setText("Reset");
        btnReset.setPrefSize(60, 30);
        btnReset.setStyle("-fx-background-color: #FFA07A; -fx-text-fill: black;"); // Set background and text color
        dicePane.add(btnReset, 0, 2);
        btnReset.setOnAction(event -> reset());


        // ---------------------------------------------------------------------
        GridPane highscore = new GridPane();
        pane.add(highscore, 1, 1);
        highscore.setGridLinesVisible(false);
        highscore.setPadding(new Insets(10));
        highscore.setVgap(5);
        highscore.setHgap(10);
        highscore.setStyle("-fx-border-color: black");

        Label lblName = new Label("Name:");
        highscore.add(lblName,0,0);
        name.setPrefWidth(100);
        name.setEditable(true);
        highscore.add(name,0,1);

        Label lblHighscore = new Label("Highscores:");
        highscore.add(lblHighscore,0,2);
        highscore.add(lvwHighscores, 0, 3, 1, 4);
        lvwHighscores.setPrefWidth(200);
        lvwHighscores.setPrefHeight(200);
        for (YatzyHighscore yatzyHighscore : yatzyHighscore.getHighscores()) {
            lvwHighscores.getItems().add(yatzyHighscore.getHighscoreValue() + "");
        }

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields

        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.

        for (int i = 0; i < 15; i++) {
            Label lblResults = new Label(resultLabels[i]);
            scorePane.add(lblResults, 0, i);
            txfResults[i] = new TextField();
            txfResults[i].setPrefWidth(w);
            txfResults[i].setEditable(false);
            txfResults[i].setDisable(true);
            final int number = i;
            txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event, number));
            scorePane.add(txfResults[i], 1, i);
        }

        Label lblSum = new Label("Sum:");
        scorePane.add(lblSum, 3, 5);
        Label lblSum1 = new Label("Sum:");
        scorePane.add(lblSum1, 3, 14);
        Label lblBonus = new Label("Bonus:");
        scorePane.add(lblBonus, 5, 5);
        Label lblTotal = new Label("Total:");
        scorePane.add(lblTotal, 5, 14);


        txfSumSame = new TextField("0");
        txfSumSame.setEditable(false);
        txfSumSame.setPrefWidth(w);
        scorePane.add(txfSumSame, 4, 5);

        txfBonus = new TextField("0");
        txfBonus.setEditable(false);
        txfBonus.setPrefWidth(w);
        scorePane.add(txfBonus, 6, 5);

        txfSumOther = new TextField("0");
        txfSumOther.setEditable(false);
        txfSumOther.setPrefWidth(w);
        scorePane.add(txfSumOther, 4, 14);

        txfTotal = new TextField("0");
        txfTotal.setEditable(false);
        txfTotal.setPrefWidth(w);
        scorePane.add(txfTotal, 6, 14);

        endGame = new Alert(Alert.AlertType.CONFIRMATION);
        endGame.setTitle("Game over");
        endGame.setHeaderText("The game is over");


    }

    // -------------------------------------------------------------------------

    private YatzyDice yatzy = new YatzyDice();

    private void btnRollAction() {
        checkChbHolds();

        endTurn();

        yatzy.throwDice(holdsStatus);

        for (int i = 0; i < 5; i++) {
            txfValues[i].setText(yatzy.getValues()[i] + "");
        }

        updateResults();
    }


    public void chooseFieldAction(Event event, int number) {
        if (!disabledResults[number]) {
            TextField txt = (TextField) event.getSource();
            txt.setStyle("-fx-font-weight:bold;-fx-text-fill: green");

            disabledResults[number] = true;
            yatzy.resetThrowCount();
            btnRoll.setDisable(false);
            lblRolled.setText("Rolled: " + yatzy.getThrowCount());

            updateStats(number);

            boolean gameIsOver = true;
            for (int i = 0; i < txfResults.length; i++) {
                if (i < 5) {
                    txfValues[i].clear();
                    chbHolds[i].setDisable(true);
                    chbHolds[i].setSelected(false);
                }
                if (!disabledResults[i]) {
//                    txfResults[i].setDisable(true);
//                    txfResults[i].setText("0");
                    gameIsOver = false;
                }
            }
            gameOver(gameIsOver);
        }
    }


    private void updateStats(int number) {
        if (number < 6) {
            sumSame += Integer.parseInt(txfResults[number].getText());
            txfSumSame.setText(String.valueOf(sumSame));
            if (sumSame >= 63) {
                txfBonus.setText("50");
                sumTotal += 50;
            }
        } else {
            sumOther += Integer.parseInt(txfResults[number].getText());
            txfSumOther.setText(String.valueOf(sumOther));
        }
        sumTotal += Integer.parseInt(txfResults[number].getText());
        txfTotal.setText(String.valueOf(sumTotal));
    }

    private void updateResults() {
        lblRolled.setText("Rolled: " + yatzy.getThrowCount());
        for (int i = 0; i < txfResults.length; i++) {
            if (!disabledResults[i]) {
                txfResults[i].setDisable(false);
                txfResults[i].setText(yatzy.getResults()[i] + "");
            }
        }
    }

    private void checkChbHolds() {
        for (int i = 0; i < 5; i++) {
            holdsStatus[i] = chbHolds[i].isSelected();
            chbHolds[i].setDisable(false);
        }
    }

    private void endTurn() {
        if (yatzy.getThrowCount() == 2) {
            btnRoll.setDisable(true);
            for (int i = 0; i < 5; i++) {
                chbHolds[i].setDisable(true);
            }
        }
    }

    private void gameOver(boolean gameIsOver) {
        if (gameIsOver) {
            endGame.setContentText("Your total was: " + sumTotal + " points." + "\nDo you wish to play again?");
            YatzyHighscore h1 = new YatzyHighscore(name.getText(),Integer.parseInt(txfTotal.getText()));
            YatzyHighscore.highscores.add(h1);
            YatzyHighscore.highscores.sort(Comparator.comparing(YatzyHighscore::getHighscoreValue).reversed());
            lvwHighscores.getItems().clear();
            for (YatzyHighscore highscore : YatzyHighscore.getHighscores()) {
                lvwHighscores.getItems().add(highscore.getName() + ": " + highscore.getHighscoreValue());
            }
            YatzyHighscore.saveHighscores();

            Optional<ButtonType> result = endGame.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                reset();
            } else {
                Platform.exit();
            }
        }
    }

    private void reset() {
        for (int i = 0; i < txfResults.length; i++) {
            if (i < 5) {
                txfValues[i].clear();
                chbHolds[i].setSelected(false);
                chbHolds[i].setDisable(true);
                holdsStatus[i] = false;
            }
            txfResults[i].clear();
            txfResults[i].setDisable(true);
            disabledResults[i] = false;
            txfResults[i].setStyle("");
        }
        sumSame = 0;
        sumOther = 0;
        sumTotal = 0;
        txfSumSame.setText("0");
        txfBonus.setText("0");
        txfSumOther.setText("0");
        txfTotal.setText("0");
        yatzy.resetThrowCount();
        lblRolled.setText("Rolled: 0");
        btnRoll.setDisable(false);
    }

}

