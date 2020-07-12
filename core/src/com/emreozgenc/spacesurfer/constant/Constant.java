package com.emreozgenc.spacesurfer.constant;

import com.emreozgenc.spacesurfer.SpaceSurfer;

public final class Constant {
    // Main ship constants
    public static final int MAIN_SHIP_WIDTH = 64;
    public static final int MAIN_SHIP_HEIGHT = 96;
    public static final float MAIN_SHIP_FRAME_TIME = 0.1f;
    public static final int MAIN_SHIP_TILE_WIDTH = 16;
    public static final int MAIN_SHIP_TILE_HEIGHT = 24;
    public static final int MAIN_SHIP_SPEED = 400;
    public static final float MAIN_SHIP_CHANGE_TIME = 0.1f;
    public static final float MAIN_SHIP_FIRE_RATE = 0.75f;

    // Main bullet constants
    public static final int MAIN_BULLET_TILE_WIDTH = 16;
    public static final int MAIN_BULLET_TILE_HEIGTH = 16;
    public static final float MAIN_BULLET_FRAME_TIME = 0.25f;
    public static final int MAIN_BULLET_MAX_POS_Y = SpaceSurfer.HEIGHT + 20;
    public static final int MAIN_BULLET_WIDTH = 32;
    public static final int MAIN_BULLET_HEIGHT = 32;
    public static final int MAIN_BULLET_SPEED = 750;
}
