package com.emreozgenc.spacesurfer.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.managers.CloudManager;
import com.emreozgenc.spacesurfer.managers.EnemyManager;
import com.emreozgenc.spacesurfer.managers.ExplosionManager;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.Cloud;
import com.emreozgenc.spacesurfer.objects.Enemy;
import com.emreozgenc.spacesurfer.objects.EnemyBullet;
import com.emreozgenc.spacesurfer.objects.Explosion;
import com.emreozgenc.spacesurfer.objects.MainBullet;
import com.emreozgenc.spacesurfer.objects.MainShip;
import com.emreozgenc.spacesurfer.objects.ScoreText;


public class GameScreen implements Screen {
    // Access main game class
    private SpaceSurfer game;

    // Sprite batch for drawing
    private SpriteBatch batch;

    // Background texture
    private Texture background;

    // Main ship
    private MainShip mainShip;

    // Cloud manager
    private CloudManager cloudManager;

    // Enemy manager
    private EnemyManager enemyManager;

    // Explosion manager
    private ExplosionManager explosionManager;

    // Player score
    public static int score;
    private ScoreText scoreText;

    // Screen constructor
    public GameScreen(SpaceSurfer game) {
        this.game = game;
        batch = new SpriteBatch();
        Gdx.graphics.setVSync(true);
        background = new Texture(Gdx.files.internal("game-sprites/background.png"));
        mainShip = new MainShip((float)(SpaceSurfer.WIDTH / 2 - Constant.MAIN_SHIP_WIDTH /2),
                20);
        cloudManager = new CloudManager();
        enemyManager = new EnemyManager();
        explosionManager = new ExplosionManager();
        scoreText = new ScoreText();
        score = 0;
    }

    @Override
    public void show() {

    }

    private void update(float delta) {

        mainShip.update(delta);
        cloudManager.update(delta);
        enemyManager.update(delta);
        scoreText.update();

        // Main bullets update
        for(MainBullet bullet : ObjectArrays.mainBullets) {
            bullet.update(delta);
        }

        // Clouds update
        for(Cloud cloud : ObjectArrays.clouds) {
            cloud.update(delta);
        }

        // Enemies update
        for(Enemy enemy : ObjectArrays.enemies) {
            enemy.update(delta);
        }

        // Enemy bullets update
        for(EnemyBullet bullet : ObjectArrays.enemyBullets) {
            bullet.update(delta);
        }

        // Explosions update
        for(Explosion explosion : ObjectArrays.explosions) {
            explosion.update(delta);
        }
    }

    private void render2(SpriteBatch batch) {
        batch.draw(background, 0, 0, SpaceSurfer.WIDTH, SpaceSurfer.HEIGHT);

        for(Cloud cloud : ObjectArrays.clouds) {
            cloud.render(batch);
        }

        for(EnemyBullet bullet : ObjectArrays.enemyBullets) {
            bullet.render(batch);
        }

        for(MainBullet bullet : ObjectArrays.mainBullets) {
            bullet.render(batch);
        }

        for(Enemy enemy : ObjectArrays.enemies) {
            enemy.render(batch);
        }

        for(Explosion explosion : ObjectArrays.explosions) {
            explosion.render(batch);
        }
        mainShip.render(batch);
        scoreText.render(batch);
    }

    private void remove(float delta) {

        for(MainBullet bullet : ObjectArrays.RmainBullets) {
            ObjectArrays.mainBullets.removeValue(bullet, true);
        }
        ObjectArrays.RmainBullets.clear();

        for(Cloud cloud : ObjectArrays.Rclouds) {
            ObjectArrays.clouds.removeValue(cloud, true);
        }
        ObjectArrays.Rclouds.clear();

        for(Enemy enemy : ObjectArrays.Renemies) {
            ObjectArrays.enemies.removeValue(enemy, true);
        }
        ObjectArrays.Renemies.clear();

        for(EnemyBullet bullet : ObjectArrays.RenemyBullets) {
            ObjectArrays.enemyBullets.removeValue(bullet, true);
        }
        ObjectArrays.RenemyBullets.clear();

        for(Explosion explosion : ObjectArrays.Rexplosions) {
            ObjectArrays.explosions.removeValue(explosion, true);
        }
        ObjectArrays.Rexplosions.clear();
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
        render2(batch);
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
