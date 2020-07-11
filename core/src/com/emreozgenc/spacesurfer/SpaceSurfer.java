package com.emreozgenc.spacesurfer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.emreozgenc.spacesurfer.screens.GameScreen;

public class SpaceSurfer extends Game {

	public static final int WIDTH = 450;
	public static final int HEIGHT = 800;

	public OrthographicCamera cam;
	public StretchViewport viewport;
	
	@Override
	public void create () {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH, HEIGHT);
		viewport = new StretchViewport(WIDTH, HEIGHT, cam);

		this.setScreen(new GameScreen(this));
	}
}
