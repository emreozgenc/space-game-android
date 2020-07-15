package com.emreozgenc.spacesurfer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.emreozgenc.spacesurfer.SpaceSurfer;


public class MainMenuScreen implements Screen {

    private SpaceSurfer game;
    private Stage stage;
    private Table table;
    private Skin skin;
    private TextButton playButton;
    private TextButton soundButton;
    private TextButton vibrateButton;
    private BitmapFont fontUI;
    private Texture background;
    private SpriteBatch batch;
    public MainMenuScreen(SpaceSurfer game) {
        this.game = game;
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("ui-sprites/ui_skin.json"));
        fontUI = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        background = new Texture(Gdx.files.internal("game-sprites/background.png"));
        stage = new Stage(game.viewport);
        table = new Table();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.align(Align.center);

        playButton = new TextButton("PLAY GAME", skin);

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SpaceSurfer game = (SpaceSurfer) Gdx.app.getApplicationListener();
                game.setScreen(new GameScreen(game));
            }
        });


        soundButton = new TextButton("SOUND SETTING", skin);
        vibrateButton = new TextButton("VIBRATE SETTING", skin);

        table.row();
        table.add(playButton).size(300, 80).padBottom(25);
        table.row();
        table.add(soundButton).size(300, 80).padBottom(25);
        table.row();
        table.add(vibrateButton).size(300, 80);
        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, SpaceSurfer.WIDTH, SpaceSurfer.HEIGHT);
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
