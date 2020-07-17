package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.collisions.CollisionRectangle;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

public class MainBullet {
    private float posX;
    private float posY;
    private Animation<TextureRegion> bulletAnim;
    private TextureRegion renderTexture;
    private float animTimer;
    private CollisionRectangle col;

    public MainBullet(float posX, float posY, Animation<TextureRegion> bulletAnim) {
        this.posX = posX;
        this.posY = posY;
        this.bulletAnim = bulletAnim;
        col = new CollisionRectangle(posX, posY, Constant.MAIN_BULLET_WIDTH, Constant.MAIN_BULLET_HEIGHT);
        animTimer = 0;
    }

    public CollisionRectangle getCollision() {
        return col;
    }

    public void render(SpriteBatch batch) {
        batch.draw(renderTexture, posX, posY, Constant.MAIN_BULLET_WIDTH, Constant.MAIN_BULLET_HEIGHT);
    }

    public void update(float delta) {
        animTimer += delta;
        posY += delta * Constant.MAIN_BULLET_SPEED;
        col.update(posX, posY);
        renderTexture = bulletAnim.getKeyFrame(animTimer, true);
        remove();
    }

    public void remove() {
        if (posY > Constant.MAIN_BULLET_MAX_POS_Y) {
            ObjectArrays.RmainBullets.add(this);
        } else {
            for (Enemy enemy : ObjectArrays.enemies) {
                if (enemy.getCollision().isCollide(col)) {
                    ObjectArrays.RmainBullets.add(this);
                }
            }
        }
    }
}
