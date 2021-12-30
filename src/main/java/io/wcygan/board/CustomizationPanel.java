package io.wcygan.board;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CustomizationPanel extends StackPane {
    private final Rectangle border;

    public CustomizationPanel() {
        this.setTranslateY(Constants.BOARD_SIDE_LENGTH / 2.0);
        this.border = new Rectangle(Constants.BOARD_SIDE_LENGTH, Constants.CUSTOMIZATION_PANEL_LENGTH);
        this.border.setFill(null);
        this.border.setStroke(Color.BLUE);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border, new Label("Hello, World!"));
    }
}
