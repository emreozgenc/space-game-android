package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

public class EnemyBullet {
    private float posX;
    private float posY;
    private Animation<TextureRegion> bulletAnim;
    private TextureRegion renderTexture;
    private float stateTimer;
    private CollisionRectangle col;

    public EnemyBullet(float posX, float posY, Animation<TextureRegion> bulletAnim) {
        this.posX = posX + Constant.ENEMY_WIDTH / 4;
        this.posY = posY;
        this.bulletAnim = bulletAnim;
        col = new CollisionRectangle(posX, posY,
                Constant.ENEMY_BULLET_WIDTH,
                Constant.ENEMY_BULLET_HEIGHT);
        stateTimer = 0;
    }

    public CollisionRectangle getCollision() {
        return col;
    }

    public void render(SpriteBatch batch) {
        batch.draw(renderTexture,
                posX, posY,
                Constant.ENEMY_BULLET_WIDTH,
                Constant.ENEMY_BULLET_WIDTH);
    }

    public void update(float delta) {
        stateTimer += delta;
        posY -= delta * Constant.ENEMY_BULLET_SPEED;
        renderTexture = bulletAnim.getKeyFrame(stateTimer, true);
        col.update(posX, posY);
        remove();
    }

    private void remove() {
        if(posY < Constant.ENEMY_BULLET_MIN_POS_Y) {
            ObjectArrays.RenemyBullets.add(this);
        }
    }
}
