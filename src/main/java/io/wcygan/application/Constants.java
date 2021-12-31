package io.wcygan.application;

import java.util.concurrent.atomic.AtomicBoolean;

public class Constants {
    public static final AtomicBoolean SHOULD_FOLLOW_CURSOR = new AtomicBoolean(false);
    public static final Integer BOARD_SIDE_LENGTH = 2 << 8;
    public static final Integer TILES_PER_SIDE = 2 << 5;
    public static final Integer TILE_LENGTH = BOARD_SIDE_LENGTH / TILES_PER_SIDE;
    public static final Integer CUSTOMIZATION_PANEL_LENGTH = 35;
    public static final Long MILLISECONDS_TO_SLEEP = 80L;
}
