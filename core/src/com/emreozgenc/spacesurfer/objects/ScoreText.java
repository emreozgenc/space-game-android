package com.emreozgenc.spacesurfer.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.emreozgenc.spacesurfer.SpaceSurfer;
import com.emreozgenc.spacesurfer.screens.GameScreen;

public class ScoreText {
    private BitmapFont font;
    private GlyphLayout layout;
    private String score;
    private float posX;

    public ScoreText() {
        font = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        score = "Score : " + GameScreen.score;
        layout = new GlyphLayout();
    }

    public void update() {
        score = "Score : " + GameScreen.score;
        layout.setText(font, score);
        float w = layout.width;
        posX = SpaceSurfer.WIDTH / 2 - (w / 2);
    }

    public void render(SpriteBatch batch) {
        font.draw(batch, layout, posX, 700);
    }
}
