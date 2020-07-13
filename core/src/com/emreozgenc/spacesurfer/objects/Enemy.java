package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

import java.util.Random;

public class Enemy {
    private Animation<TextureRegion> enemyAnim;
    private Random rand;
    private float posX;
    private float posY;
    private float stateTimer;
    private TextureRegion renderTexture;

    public Enemy(Animation<TextureRegion> enemyAnim) {
        this.enemyAnim = enemyAnim;
        rand = new Random();
        stateTimer = 0;
        posY = Constant.ENEMY_POS_Y;
        posX = rand.nextInt(Constant.ENEMY_MAX_POS_X);
    }

    public void update(float delta) {
        stateTimer += delta;
        posY -= delta * Constant.ENEMY_SPEED;
        renderTexture = enemyAnim.getKeyFrame(stateTimer, true);
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
    }
}
