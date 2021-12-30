package io.wcygan.board;

import javafx.scene.layout.GridPane;

public class TileGrid extends GridPane {

    public final Tile[][] board = new Tile[Constants.TILES_PER_SIDE][Constants.TILES_PER_SIDE];

    public TileGrid() {
        for (int i = 0; i < Constants.TILES_PER_SIDE; i++) {
            for (int j = 0; j < Constants.TILES_PER_SIDE; j++) {
                Tile tile = new Tile(j, i);
                tile.setTranslateX(j * Constants.TILE_LENGTH);
                tile.setTranslateY(i * Constants.TILE_LENGTH);
                getChildren().add(tile);
                board[j][i] = tile;
            }
        }
    }
}
