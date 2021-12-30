package io.wcygan.board;

import javafx.scene.layout.StackPane;

public class Board extends StackPane {
    public Board() {
        getChildren().addAll(new Tile(0, 0));
    }
}
