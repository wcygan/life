package io.wcygan.board;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
    private final int x, y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        Rectangle border = new Rectangle(Constants.TILE_SIZE, Constants.TILE_SIZE);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border);
    }
}