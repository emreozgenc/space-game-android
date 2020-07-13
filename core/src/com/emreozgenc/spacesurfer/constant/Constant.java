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
    public static final int MAIN_BULLET_TILE_HEIGHT = 16;
    public static final float MAIN_BULLET_FRAME_TIME = 0.25f;
    public static final int MAIN_BULLET_MAX_POS_Y = SpaceSurfer.HEIGHT + 20;
    public static final int MAIN_BULLET_WIDTH = 32;
    public static final int MAIN_BULLET_HEIGHT = 32;
    public static final int MAIN_BULLET_SPEED = 750;

    // Cloud manager constants
    public static final float CLOUD_MANAGER_SPAWN_MAX_TIME = 15f;
    public static final float CLOUD_MANAGER_SPAWN_MIN_TIME = 7.5f;
    public static final int CLOUD_MANAGER_CLOUD_COUNT = 2;

    // Cloud constants
    public static final int CLOUD_SPEED_MAX = 200;
    public static final int CLOUD_SPEED_MIN = 100;
    public static final int CLOUD_WIDTH = 450;
    public static final int CLOUD_HEIGHT = 220;
    public static final int CLOUD_POS_Y = SpaceSurfer.HEIGHT + CLOUD_HEIGHT + 20;
    public static final int CLOUD_POS_X = 0;
    public static final int CLOUD_MIN_POS_Y = -300;

    // Enemy manager constants
    public static final float ENEMY_MANAGER_SPAWN_MAX_TIME = 5f;
    public static final float ENEMY_MANAGER_SPAWN_MIN_TIME = 3f;

    // Enemy constants
    public static final int ENEMY_TILE_WIDTH = 32;
    public static final int ENEMY_TILE_HEIGHT = 32;
    public static final int ENEMY_SPEED = 150;
    public static final float ENEMY_FIRE_RATE = 1.5f;
    public static final int ENEMY_WIDTH = 64;
    public static final int ENEMY_HEIGHT = 64;
    public static final float ENEMY_FRAME_TIME = 0.1f;
    public static final int ENEMY_POS_Y = SpaceSurfer.HEIGHT + ENEMY_HEIGHT + 20;
    public static final int ENEMY_MAX_POS_X = SpaceSurfer.WIDTH - ENEMY_WIDTH;
    public static final int ENEMY_MIN_POS_Y = -300;

    // Enemy bullet constants
    public static final int ENEMY_BULLET_SPEED = 750;
    public static final int ENEMY_BULLET_MIN_POS_Y = -300;
    public static final int ENEMY_BULLET_WIDTH = 32;
    public static final int ENEMY_BULLET_HEIGHT = 32;
    public static final int ENEMY_BULLET_TILE_WIDTH = 16;
    public static final int ENEMY_BULLET_TILE_HEIGHT = 16;
    public static final float ENEMY_BULLET_FRAME_TIME = 0.1f;

    //Explosion constants
    public static final int EXPLOSION_TILE_WIDTH = 16;
    public static final int EXPLOSION_TILE_HEIGHT = 16;
    public static final int EXPLOSION_HEIGHT = 64;
    public static final int EXPLOSION_WIDTH = 64;
    public static final float EXPLOSION_FRAME_TIME = 0.1f;

}
