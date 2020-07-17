package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;

import java.util.Random;

public class Cloud {
    private float speed;
    private float posX;
    private float posY;
    private Random rand;
    private Texture cloudTexture;

    public Cloud(Texture cloudTexture) {
        rand = new Random();
        speed = (Constant.CLOUD_SPEED_MIN +
                rand.nextFloat() *
                        (Constant.CLOUD_SPEED_MAX - Constant.CLOUD_SPEED_MIN));
        posX = Constant.CLOUD_POS_X;
        posY = Constant.CLOUD_POS_Y;
        this.cloudTexture = cloudTexture;
    }

    public void update(float delta) {
        posY -= delta * speed;
        remove();
    }

    public void render(SpriteBatch batch) {
        batch.draw(cloudTexture,
                posX, posY,
                Constant.CLOUD_WIDTH,
                Constant.CLOUD_HEIGHT);
    }

    private void remove() {
        if (posY < Constant.CLOUD_MIN_POS_Y) {
            ObjectArrays.Rclouds.add(this);
        }
    }
}
