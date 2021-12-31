package io.wcygan.board;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
    private static final Background DEAD_COLOR = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
    private static final Background ALIVE_COLOR = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));

    public final int x, y;
    private final Rectangle border;
    private boolean alive = false;
    private boolean aliveNextIteration = false;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.border = new Rectangle(Constants.TILE_LENGTH, Constants.TILE_LENGTH);
        this.border.setFill(null);
        setBehaviors();
    }

    private void setBehaviors() {
        setBorderColor(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border);
        setOnMouseClicked(e -> userClicked());
        setOnMouseEntered(e -> {
            if (Constants.SHOULD_FOLLOW_CURSOR.get()) {
                userClicked();
            }
        });
    }

    public void checkNeighbors(Tile[][] board) {
        int aliveNeighbors = numNeighborsAlive(board);

        if (alive) {
            if (aliveNeighbors < 2) {
                aliveNextIteration = false;
            } else aliveNextIteration = aliveNeighbors <= 3;
        } else {
            aliveNextIteration = aliveNeighbors == 3;
        }
    }

    private int numNeighborsAlive(Tile[][] board) {
        int aliveNeighbors = 0;

        int low = -1;
        int high = 2;

        for (int xIncrement = low; xIncrement < high; xIncrement++) {
            for (int yIncrement = low; yIncrement < high; yIncrement++) {
                if (yIncrement == 0 && xIncrement == 0) continue;

                int xCheck = x + xIncrement;
                int yCheck = y + yIncrement;

                if (xCheck >= board.length || xCheck < 0) continue;
                if (yCheck >= board.length || yCheck < 0) continue;

                if (board[xCheck][yCheck].alive) {
                    aliveNeighbors += 1;
                }
            }
        }

        return aliveNeighbors;
    }

    public void tryToRevive() {
        alive = aliveNextIteration;
        adjustBackground(alive ? ALIVE_COLOR : DEAD_COLOR);
    }

    public void setBorderColor(Color color) {
        this.border.setStroke(color);
    }

    public void adjustBackground(Background background) {
        this.setBackground(background);
    }

    private void userClicked() {
        alive = !alive;
        adjustBackground(alive ? ALIVE_COLOR : DEAD_COLOR);
    }

    public void reset() {
        alive = false;
        adjustBackground(DEAD_COLOR);
    }
}