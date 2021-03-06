package com.emreozgenc.spacesurfer.objectarray;

import com.badlogic.gdx.utils.Array;
import com.emreozgenc.spacesurfer.objects.Cloud;
import com.emreozgenc.spacesurfer.objects.Enemy;
import com.emreozgenc.spacesurfer.objects.EnemyBullet;
import com.emreozgenc.spacesurfer.objects.Explosion;
import com.emreozgenc.spacesurfer.objects.MainBullet;

public class ObjectArrays {

    // MainBullet arrays
    public static Array<MainBullet> mainBullets = new Array<>();
    public static Array<MainBullet> RmainBullets = new Array<>();

    // EnemyBullet arrays
    public static Array<EnemyBullet> enemyBullets = new Array<>();
    public static Array<EnemyBullet> RenemyBullets = new Array<>();

    // Cloud arrays
    public static Array<Cloud> clouds = new Array<>();
    public static Array<Cloud> Rclouds = new Array<>();

    // Enemy arrays
    public static Array<Enemy> enemies = new Array<>();
    public static Array<Enemy> Renemies = new Array<>();

    // Explosion arrays
    public static Array<Explosion> explosions = new Array<>();
    public static Array<Explosion> Rexplosions = new Array<>();

    public static void clearAll() {
        mainBullets.clear();
        RmainBullets.clear();
        enemyBullets.clear();
        RenemyBullets.clear();
        clouds.clear();
        Rclouds.clear();
        enemies.clear();
        Renemies.clear();
        explosions.clear();
        Rexplosions.clear();
    }
}
