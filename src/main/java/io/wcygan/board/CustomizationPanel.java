package io.wcygan.board;

import io.wcygan.lifecycle.PhaseController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.concurrent.atomic.AtomicBoolean;

public class CustomizationPanel extends HBox {

    private final TileGrid tileGrid;
    private final Button start = new Button("Start");
    private final Button stop = new Button("Stop");
    private final Button cursorToggle = new Button("Toggle Cursor Draw!");
    private final Button clear = new Button("Erase Grid");
    AtomicBoolean paused = new AtomicBoolean(false);
    private boolean started = false;

    public CustomizationPanel(TileGrid tileGrid) {
        this.tileGrid = tileGrid;
        setBehavior();
    }

    /**
     * Sets the behavior of the {@link CustomizationPanel}
     */
    private void setBehavior() {
        this.setAlignment(Pos.CENTER);

        start.setDisable(false);
        start.setOnMouseClicked(e -> {
            start.setDisable(true);
            stop.setDisable(false);

            if (!started) {
                PhaseController phaseController = new PhaseController(tileGrid.board, paused);
                phaseController.start();
            }

            started = true;
            paused.set(false);
        });

        stop.setDisable(true);
        stop.setOnMouseClicked(e -> {
            paused.set(true);
            start.setDisable(false);
            stop.setDisable(true);
        });

        cursorToggle.setOnMouseClicked(e -> {
            Constants.SHOULD_FOLLOW_CURSOR.set(!Constants.SHOULD_FOLLOW_CURSOR.get());
            cursorToggle.setText(Constants.SHOULD_FOLLOW_CURSOR.get() ? "Disable Cursor Draw" : "Toggle Cursor Draw!");
        });

        clear.setOnMouseClicked(e -> {
            paused.set(true);
            start.setDisable(false);
            stop.setDisable(true);

            for (Tile[] row : tileGrid.board) {
                for (Tile tile : row) {
                    tile.reset();
                }
            }
        });

        getChildren().addAll(start, stop, cursorToggle, clear);
    }
}
