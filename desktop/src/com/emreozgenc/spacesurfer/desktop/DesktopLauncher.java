package com.emreozgenc.spacesurfer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.emreozgenc.spacesurfer.SpaceSurfer;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SpaceSurfer.WIDTH;
		config.height = SpaceSurfer.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new SpaceSurfer(), config);
	}
}
