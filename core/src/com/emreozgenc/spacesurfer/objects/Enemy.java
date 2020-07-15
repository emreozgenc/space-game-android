package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.managers.ExplosionManager;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.screens.GameScreen;

import java.util.Random;

public class Enemy {
    private Animation<TextureRegion> enemyAnim;
    private Animation<TextureRegion> bulletAnim;
    private Random rand;
    private CollisionRectangle col;
    private float posX;
    private float posY;
    private float stateTimer;
    private float fireTimer;
    private TextureRegion renderTexture;
    private Sound explosionSound;

    public Enemy(Animation<TextureRegion> enemyAnim, Animation<TextureRegion> bulletAnim) {
        this.enemyAnim = enemyAnim;
        this.bulletAnim = bulletAnim;
        rand = new Random();
        col = new CollisionRectangle(posX, posY, Constant.ENEMY_WIDTH, Constant.ENEMY_HEIGHT);
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));
        stateTimer = 0;
        fireTimer = 0;
        posY = Constant.ENEMY_POS_Y;
        posX = rand.nextInt(Constant.ENEMY_MAX_POS_X);
    }

    public CollisionRectangle getCollision() {
        return col;
    }

    public void update(float delta) {
        stateTimer += delta;
        fireTimer += delta;
        posY -= delta * Constant.ENEMY_SPEED;
        col.update(posX, posY);
        renderTexture = enemyAnim.getKeyFrame(stateTimer, true);
        fire();
        remove();
    }

    public void render(SpriteBatch batch) {
        batch.draw(renderTexture,
                posX, posY,
                Constant.ENEMY_WIDTH,
                Constant.ENEMY_HEIGHT);
    }

    private void remove() {
        if(posY < Constant.ENEMY_MIN_POS_Y) {
            ObjectArrays.Renemies.add(this);
        }
        else {
            for(MainBullet bullet : ObjectArrays.mainBullets) {
                if(bullet.getCollision().isCollide(col)) {
                    ObjectArrays.Renemies.add(this);
                    ExplosionManager.createExplosion(posX, posY);
                    GameScreen.score++;
                    if(SpaceSurfer.preferences.getBoolean("sound_setting")) {
                        explosionSound.play(0.3f);
                    }
                }
            }
        }
    }

    private void fire() {
        if(Math.abs(fireTimer) > Constant.ENEMY_FIRE_RATE) {
            ObjectArrays.enemyBullets.add(new EnemyBullet(posX, posY, bulletAnim));
            fireTimer = 0;
        }
    }
}
