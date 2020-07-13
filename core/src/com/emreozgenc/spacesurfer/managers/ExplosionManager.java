package com.emreozgenc.spacesurfer.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.Explosion;

public class ExplosionManager {
    public static Texture explosionTexture;
    public static Animation<TextureRegion> explosionAnim;

    public ExplosionManager() {
        explosionTexture = new Texture(Gdx.files.internal("game-sprites/explosion.png"));
        TextureRegion[][] tmp = TextureRegion.split(explosionTexture,
                Constant.EXPLOSION_TILE_WIDTH,
                Constant.EXPLOSION_TILE_HEIGHT);
        explosionAnim = new Animation<TextureRegion>(Constant.EXPLOSION_FRAME_TIME, tmp[0]);
    }

    public static void createExplosion(float posX, float posY) {
        ObjectArrays.explosions.add(new Explosion(posX, posY, explosionAnim));
    }
}
