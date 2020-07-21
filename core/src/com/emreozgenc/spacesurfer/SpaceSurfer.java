package com.emreozgenc.spacesurfer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.emreozgenc.spacesurfer.screens.MainMenuScreen;

public class SpaceSurfer extends Game {

    public static final int WIDTH = 450;
    public static final int HEIGHT = 800;

    public OrthographicCamera cam;
    public StretchViewport viewport;
    public static Preferences preferences;
    public static Preferences highScore;

    @Override
    public void create() {
        cam = new OrthographicCamera();
        cam.setToOrtho(false, WIDTH, HEIGHT);
        viewport = new StretchViewport(WIDTH, HEIGHT, cam);
        preferences = Gdx.app.getPreferences("settings");
        highScore = Gdx.app.getPreferences("score");

        if (!preferences.contains("sound_setting")) {
            preferences.putBoolean("sound_setting", true);
            preferences.flush();
        }

        if (!preferences.contains("vibrate_setting")) {
            preferences.putBoolean("vibrate_setting", true);
            preferences.flush();
        }

        if(!highScore.contains("high_score")) {
            highScore.putInteger("high_score", 0);
            highScore.flush();
        }

        this.setScreen(new MainMenuScreen(this));
    }
}
