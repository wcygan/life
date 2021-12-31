package io.wcygan.board;

import javafx.scene.layout.GridPane;

public class TileGrid extends GridPane {

    public final Tile[][] board = new Tile[Constants.TILES_PER_SIDE * 2][Constants.TILES_PER_SIDE];

    public TileGrid() {
        for (int row = 0; row < Constants.TILES_PER_SIDE; row++) {
            for (int col = 0; col < Constants.TILES_PER_SIDE * 2; col++) {
                Tile tile = new Tile(col, row);
                tile.setTranslateX(col * Constants.TILE_LENGTH);
                tile.setTranslateY(row * Constants.TILE_LENGTH);
                getChildren().add(tile);
                board[col][row] = tile;
            }
        }
    }
}
