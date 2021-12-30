package io.wcygan.board;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
    private final int x, y;
    private final Rectangle border;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.border = new Rectangle(Constants.TILE_LENGTH, Constants.TILE_LENGTH);
        this.border.setFill(null);
        setBorderColor(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border);
    }

    public void setBorderColor(Color color) {
        this.border.setStroke(color);
    }
}