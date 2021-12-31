package io.wcygan.board;

public class Constants {
    public static final Integer BOARD_SIDE_LENGTH = 2 << 9;
    public static final Integer TILES_PER_SIDE = 2 << 5;
    public static final Integer TILE_LENGTH = BOARD_SIDE_LENGTH / TILES_PER_SIDE;
    public static final Integer CUSTOMIZATION_PANEL_LENGTH = 150;
    public static final Integer MAXIMUM_ITERATIONS = 10000;
    public static final Long MILLISECONDS_TO_SLEEP = 80L;
}
