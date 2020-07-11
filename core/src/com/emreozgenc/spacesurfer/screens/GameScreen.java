package com.emreozgenc.spacesurfer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objects.MainShip;

public class GameScreen implements Screen {
    // Access main game class
    private SpaceSurfer game;

    // Sprite batch for drawing
    private SpriteBatch batch;

    // Background texture
    private Texture background;

    // Main ship
    private MainShip mainShip;

    // Screen constructor
    public GameScreen(SpaceSurfer game) {
        this.game = game;
        batch = new SpriteBatch();

        background = new Texture(Gdx.files.internal("game-sprites/background.png"));
        mainShip = new MainShip((float)(SpaceSurfer.WIDTH / 2 - Constant.MAIN_SHIP_WIDTH /2),
                20);
    }

    @Override
    public void show() {

    }

    private void update(float delta) {
        mainShip.update(delta);
    }

    private void remove(float delta) {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Before drawing we need update our objects
        update(delta);

        //Sprite batch settings
        batch.setProjectionMatrix(game.cam.combined);
        game.cam.update();

        batch.begin();
        batch.draw(background, 0, 0, SpaceSurfer.WIDTH, SpaceSurfer.HEIGHT);
        mainShip.render(batch);
        batch.end();

        //After draw if we need remove something in scene
        remove(delta);
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
