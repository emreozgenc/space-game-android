package com.emreozgenc.spacesurfer.objectarray;

import com.badlogic.gdx.utils.Array;
import com.emreozgenc.spacesurfer.objects.Cloud;
import com.emreozgenc.spacesurfer.objects.Enemy;
import com.emreozgenc.spacesurfer.objects.MainBullet;

public class ObjectArrays {

    // MainBullet arrays
    public static Array<MainBullet> mainBullets = new Array<>();
    public static Array<MainBullet> RmainBullets = new Array<>();

    // Cloud arrays
    public static Array<Cloud> clouds = new Array<>();
    public static Array<Cloud> Rclouds = new Array<>();

    // Enemy arrays
    public static Array<Enemy> enemies = new Array<>();
    public static Array<Enemy> Renemies = new Array<>();
}
