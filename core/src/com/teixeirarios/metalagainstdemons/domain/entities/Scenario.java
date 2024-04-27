package com.teixeirarios.metalagainstdemons.domain.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;

public class Scenario {

    private Texture backgroundTexture;
    private TiledDrawable tiledBackground;
    private Batch batch;

    public Scenario(Batch batch) {
        this.backgroundTexture = new Texture("pattern.png");
        this.tiledBackground = new TiledDrawable(new TextureRegion(backgroundTexture));
        this.batch = batch;
    }

    public void drawBackground() {
        tiledBackground.draw(batch, 0, 0, Gdx.graphics.getWidth() * 100, Gdx.graphics.getHeight() * 100);
    }
}
