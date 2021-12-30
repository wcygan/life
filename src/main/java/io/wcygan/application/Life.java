package io.wcygan.application;

import io.wcygan.board.Board;
import io.wcygan.board.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Life extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Board(), Constants.BOARD_SIDE_LENGTH, Constants.BOARD_SIDE_LENGTH + Constants.CUSTOMIZATION_PANEL_LENGTH);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}