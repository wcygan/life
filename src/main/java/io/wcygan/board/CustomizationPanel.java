package io.wcygan.board;

import io.wcygan.lifecycle.PhaseController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CustomizationPanel extends HBox {

    private final TileGrid tileGrid;
    private final Button start = new Button("Start");

    public CustomizationPanel(TileGrid tileGrid) {
        this.tileGrid = tileGrid;
        setBehavior();
    }

    /**
     * Sets the behavior of the {@link CustomizationPanel}
     */
    private void setBehavior() {
        this.setAlignment(Pos.CENTER);

        start.autosize();
        start.setOnMouseClicked(e -> {
            start.setDisable(true);
            PhaseController phaseController = new PhaseController(tileGrid.board);
            phaseController.start();
        });

        getChildren().addAll(start);
    }
}
