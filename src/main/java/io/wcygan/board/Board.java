package io.wcygan.board;

import javafx.scene.layout.BorderPane;

public class Board extends BorderPane {
    public Board() {
        TileGrid grid = new TileGrid();
        CustomizationPanel panel = new CustomizationPanel(grid);
        this.setCenter(grid);
        this.setBottom(panel);
    }
}
