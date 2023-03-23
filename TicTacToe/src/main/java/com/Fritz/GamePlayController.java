package com.Fritz;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class GamePlayController {

    private boolean firstPlayerTurn = true;
    private int winsX;
    private int wins0;
    private int buttonPressed = 0;

    @FXML
    private Label infoLabel, scoreX, score0;

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    @FXML
    public Button gamePlayBackToMainButton;

    @FXML
    public Button gamePlayPlayAgainButton;

    @FXML
    public Button gamePlayExitButton;

    public void switchToMainMenu (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleExitButton(ActionEvent event) {
        if (event.getSource().equals(gamePlayExitButton)) {
            Platform.exit();
        }
    }

    public void handleRestartGame(ActionEvent event) {
        if (event.getSource().equals(gamePlayPlayAgainButton)) {
            buttonPressed = 0;
            firstPlayerTurn = randomFirstPlayer();
            setInfoLabel();
            enableButtons();
        }
    }

    public void handleButton(ActionEvent event) {

        if(event.getSource().equals(button1)) {
            gamePlay(button1);
        } else if (event.getSource().equals(button2)) {
            gamePlay(button2);
        } else if (event.getSource().equals(button3)) {
            gamePlay(button3);
        } else if (event.getSource().equals(button4)) {
            gamePlay(button4);
        } else if (event.getSource().equals(button5)) {
            gamePlay(button5);
        } else if (event.getSource().equals(button6)) {
            gamePlay(button6);
        } else if (event.getSource().equals(button7)) {
            gamePlay(button7);
        } else if (event.getSource().equals(button8)) {
            gamePlay(button8);
        } else if (event.getSource().equals(button9)) {
            gamePlay(button9);
        }
    }

    public void gamePlay(Button button) {
        buttonPressed++;
        infoLabel.setStyle("-fx-font-size: 42px; -fx-font-weight:bold");
        if(firstPlayerTurn) {
            button.setText("X");
            button.setDisable(true);
            button.setOpacity(1);
            button.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #793c3c; -fx-background-color: transparent");
            if (checkWin("X")) {
                winsX++;
                infoLabel.setText("Player X wins!");
                gameScore();
                disableButtons();
            } else {
                infoLabel.setText("Player 0's turn");
            }
            firstPlayerTurn = false;

        } else {
            button.setText("0");
            button.setDisable(true);
            button.setOpacity(1);
            button.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #f2ebd3; -fx-background-color: transparent");
            if (checkWin("0")) {
                wins0++;
                infoLabel.setText("Player 0 wins!");
                gameScore();
                disableButtons();
            } else {
                infoLabel.setText("Player X's turn");
            }
            firstPlayerTurn = true;
        }
        if(buttonPressed == 9) {
            if(checkWin("X")) {
                infoLabel.setText("Player X wins!");
            } else if (checkWin("0")) {
                infoLabel.setText("Player 0 wins!");
            } else {
                infoLabel.setText("Draw");
            }
        }
    }

    public boolean checkWin(String player) {
        if (button1.getText().equals(player) && button2.getText().equals(player) && button3.getText().equals(player)) {
            return true;
        }
        if (button4.getText().equals(player) && button5.getText().equals(player) && button6.getText().equals(player)) {
            return true;
        }
        if (button7.getText().equals(player) && button8.getText().equals(player) && button9.getText().equals(player)) {
            return true;
        }
        if (button1.getText().equals(player) && button4.getText().equals(player) && button7.getText().equals(player)) {
            return true;
        }
        if (button2.getText().equals(player) && button5.getText().equals(player) && button8.getText().equals(player)) {
            return true;
        }
        if (button3.getText().equals(player) && button6.getText().equals(player) && button9.getText().equals(player)) {
            return true;
        }
        if (button1.getText().equals(player) && button5.getText().equals(player) && button9.getText().equals(player)) {
            return true;
        }
        if (button3.getText().equals(player) && button5.getText().equals(player) && button7.getText().equals(player)) {
            return true;
        }
        return false;
    }

    public void gameScore() {
        score0.setText(wins0 + "");
        scoreX.setText(winsX + "");
    }

    public void disableButtons() {
        if(button1.getText().equals("")) {
            button1.setDisable(true);
            button1.setOpacity(1);
        }
        if(button2.getText().equals("")) {
            button2.setDisable(true);
            button2.setOpacity(1);
        }
        if(button3.getText().equals("")) {
            button3.setDisable(true);
            button3.setOpacity(1);
        }
        if(button4.getText().equals("")) {
            button4.setDisable(true);
            button4.setOpacity(1);
        }
        if(button5.getText().equals("")) {
            button5.setDisable(true);
            button5.setOpacity(1);
        }
        if(button6.getText().equals("")) {
            button6.setDisable(true);
            button6.setOpacity(1);
        }
        if(button7.getText().equals("")) {
            button7.setDisable(true);
            button7.setOpacity(1);
        }
        if(button8.getText().equals("")) {
            button8.setDisable(true);
            button8.setOpacity(1);
        }
        if(button9.getText().equals("")) {
            button9.setDisable(true);
            button9.setOpacity(1);
        }
    }
    public void enableButtons() {
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);

        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
    }

    public boolean randomFirstPlayer() {

        Random random = new Random();
        return random.nextInt(1, 3) == 1;
    }

    public void setInfoLabel(){
        if (firstPlayerTurn) {
            infoLabel.setText("Player X's turn");
        } else {
            infoLabel.setText("Player 0's turn");
        }
    }
}
