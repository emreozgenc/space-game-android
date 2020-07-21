package com.emreozgenc.spacesurfer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.emreozgenc.spacesurfer.SpaceSurfer;


public class MainMenuScreen implements Screen {

    private SpaceSurfer game;
    private Stage stage;
    private Table table;
    private Skin skin;
    private TextButton playButton;
    private TextButton exitButton;
    private Texture logo;
    private Texture background;
    private SpriteBatch batch;
    private CheckBox soundCheck;
    private CheckBox vibrateCheck;
    private BitmapFont highScoreFont;
    private GlyphLayout layout;

    public MainMenuScreen(SpaceSurfer game) {
        this.game = game;
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("ui-sprites/ui_skin.json"));
        logo = new Texture(Gdx.files.internal("ui-sprites/logo.png"));
        background = new Texture(Gdx.files.internal("game-sprites/background.png"));
        highScoreFont = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        stage = new Stage(game.viewport);
        table = new Table();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.defaults().pad(10);

        playButton = new TextButton("PLAY GAME", skin);

        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SpaceSurfer game = (SpaceSurfer) Gdx.app.getApplicationListener();
                game.setScreen(new GameScreen(game));
            }
        });

        exitButton = new TextButton("EXIT", skin);

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });


        soundCheck = new CheckBox("Sound ON", skin);
        soundCheck.setChecked(SpaceSurfer.preferences.getBoolean("sound_setting"));

        soundCheck.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                SpaceSurfer.preferences.putBoolean("sound_setting", soundCheck.isChecked());
                SpaceSurfer.preferences.flush();
            }
        });

        vibrateCheck = new CheckBox("Vibration ON", skin);
        vibrateCheck.setChecked(SpaceSurfer.preferences.getBoolean("vibrate_setting"));

        vibrateCheck.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                SpaceSurfer.preferences.putBoolean("vibrate_setting", vibrateCheck.isChecked());
                SpaceSurfer.preferences.flush();
            }
        });
        table.add(playButton).size(300, 50).padBottom(25).colspan(2);
        table.row();
        table.add(exitButton).size(300, 50).padBottom(25).colspan(2);
        table.row();
        table.add(soundCheck).align(Align.left).colspan(1);
        table.add(vibrateCheck).align(Align.right).colspan(1);
        table.row();
        stage.addActor(table);

        String str = "Best Score : " + SpaceSurfer.highScore.getInteger("high_score");
        layout = new GlyphLayout();
        layout.setText(highScoreFont, str);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(game.cam.combined);
        batch.begin();
        batch.draw(background, 0, 0, SpaceSurfer.WIDTH, SpaceSurfer.HEIGHT);
        batch.draw(logo,
                SpaceSurfer.WIDTH / 2 - logo.getWidth() / 2,
                SpaceSurfer.HEIGHT - 200);
        highScoreFont.draw(batch, layout,
                SpaceSurfer.WIDTH / 2 - layout.width / 2,
                100);
        batch.end();

        stage.act(delta);
        stage.draw();
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
