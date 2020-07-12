package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

public class MainBullet {
    private float posX;
    private float posY;
    private Animation<TextureRegion> bulletAnim;
    private TextureRegion renderTexture;
    private float animTimer;

    public MainBullet(float posX, float posY, Animation<TextureRegion> bulletAnim) {
        this.posX = posX;
        this.posY = posY;
        this.bulletAnim = bulletAnim;
        animTimer = 0;
    }

    public void render(SpriteBatch batch) {
        batch.draw(renderTexture, posX, posY, Constant.MAIN_BULLET_WIDTH, Constant.MAIN_BULLET_HEIGHT);
    }

    public void update(float delta) {
        animTimer += delta;
        posY += delta * Constant.MAIN_BULLET_SPEED;
        renderTexture = bulletAnim.getKeyFrame(animTimer, true);
        remove();
    }

    public void remove() {
        if(posY > Constant.MAIN_BULLET_MAX_POS_Y) {
            ObjectArrays.RmainBullets.add(this);
        }
    }
}
