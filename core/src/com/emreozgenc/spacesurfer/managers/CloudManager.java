package com.emreozgenc.spacesurfer.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.emreozgenc.spacesurfer.constant.Constant;
import com.emreozgenc.spacesurfer.objectarray.ObjectArrays;
import com.emreozgenc.spacesurfer.objects.Cloud;

import java.util.Random;

public class CloudManager {
    private Texture[] cloudTextures;
    private Random rand;
    private float spawnTimer;
    private float spawnTime;
    private boolean canCreate;

    public CloudManager() {
        rand = new Random();
        spawnTimer = 0;
        canCreate = true;
        cloudTextures = new Texture[Constant.CLOUD_MANAGER_CLOUD_COUNT];
        String path = "game-sprites/cloud";
        for (int i = 0; i < Constant.CLOUD_MANAGER_CLOUD_COUNT; i++) {
            String temp = path + (i + 1) + ".png";
            cloudTextures[i] = new Texture(Gdx.files.internal(temp));
        }
    }

    public void update(float delta) {
        spawnTimer += delta;
        createSpawnTime();
        if (Math.abs(spawnTimer) > spawnTime) {
            createCloud();
            spawnTimer = 0;
            canCreate = true;
        }
    }

    private void createSpawnTime() {
        if (canCreate) {
            spawnTime = Constant.CLOUD_MANAGER_SPAWN_MIN_TIME +
                    rand.nextFloat() *
                            (Constant.CLOUD_MANAGER_SPAWN_MAX_TIME - Constant.CLOUD_MANAGER_SPAWN_MIN_TIME);

            canCreate = false;

        }
    }

    private void createCloud() {
        int index = rand.nextInt(Constant.CLOUD_MANAGER_CLOUD_COUNT);
        ObjectArrays.clouds.add(new Cloud(cloudTextures[index]));
    }
}
