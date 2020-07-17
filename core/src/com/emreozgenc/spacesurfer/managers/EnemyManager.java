package com.emreozgenc.spacesurfer.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.Enemy;

import java.util.Random;

public class EnemyManager {
    private Random rand;
    private float spawnTime;
    private float spawnTimer;
    private boolean canCreate;
    private Texture enemyTexture;
    private Texture bulletTexture;
    private Animation<TextureRegion> enemyAnim;
    private Animation<TextureRegion> bulletAnim;

    public EnemyManager() {
        rand = new Random();
        spawnTimer = 0;
        canCreate = true;
        enemyTexture = new Texture(Gdx.files.internal("game-sprites/enemy.png"));
        bulletTexture = new Texture(Gdx.files.internal("game-sprites/bullets.png"));

        TextureRegion[][] tmp = TextureRegion.split(enemyTexture,
                Constant.ENEMY_TILE_WIDTH,
                Constant.ENEMY_TILE_HEIGHT);
        enemyAnim = new Animation<TextureRegion>(Constant.ENEMY_FRAME_TIME, tmp[0]);

        TextureRegion[][] tmp2 = TextureRegion.split(bulletTexture,
                Constant.ENEMY_BULLET_TILE_WIDTH,
                Constant.ENEMY_BULLET_TILE_HEIGHT);
        bulletAnim = new Animation<TextureRegion>(Constant.ENEMY_BULLET_FRAME_TIME, tmp2[0]);
    }

    public void update(float delta) {
        spawnTimer += delta;
        createSpawnTime();

        if (Math.abs(spawnTimer) > spawnTime) {
            ObjectArrays.enemies.add(new Enemy(enemyAnim, bulletAnim));
            spawnTimer = 0;
            canCreate = true;
        }
    }

    private void createSpawnTime() {
        if (canCreate) {
            spawnTime = Constant.ENEMY_MANAGER_SPAWN_MIN_TIME +
                    rand.nextFloat() *
                            (Constant.ENEMY_MANAGER_SPAWN_MAX_TIME - Constant.ENEMY_MANAGER_SPAWN_MIN_TIME);
            canCreate = false;
        }
    }
}
