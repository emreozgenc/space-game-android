package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

public class Explosion {
    private float posX;
    private float posY;
    private Animation<TextureRegion> explosionAnimation;
    private TextureRegion renderTexture;
    private float stateTimer;

    public Explosion(float posX, float posY, Animation<TextureRegion> explosionAnimation) {
        this.posX = posX;
        this.posY = posY;
        this.explosionAnimation = explosionAnimation;
        stateTimer = 0;
    }

    public void render(SpriteBatch batch) {
        batch.draw(renderTexture,
                posX, posY,
                Constant.EXPLOSION_WIDTH,
                Constant.EXPLOSION_HEIGHT);
    }

    public void update(float delta) {
        stateTimer += delta;
        renderTexture = explosionAnimation.getKeyFrame(stateTimer, false);
        remove();
    }

    public void remove() {
        if (explosionAnimation.isAnimationFinished(stateTimer)) {
            ObjectArrays.Rexplosions.add(this);
        }
    }
}
