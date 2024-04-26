package com.teixeirarios.metalagainstdemons.infrastructure.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class LibGDXFacade implements AbstractCanvas {

    private final SpriteBatch batch;
    private float posX;
    private Texture sprite;
    private int numFramesX;
    private float frameDuration;
    private float timeSinceLastFrame;
    private int currentFrame;
    private float frameWidth;

    public LibGDXFacade(SpriteBatch batch, String spritesheet, int numFramesX, float frameDuration, float frameWidth) {
        this.batch = batch;
        this.sprite = new Texture(spritesheet);
        this.numFramesX = numFramesX;
        this.frameDuration = frameDuration;
        this.frameWidth = frameWidth;
    }

    public void drawImage(float sx, float sy, float sw, float sh, float dx, float dy, float dw, float dh) {
        TextureRegion region = new TextureRegion(sprite, (int) posX, (int) sy, (int) sw, (int) sh);
        batch.draw(region, dx, dy, dw, dh);
    }

    public void animate() {
        // Atualiza o tempo decorrido desde o último frame
        timeSinceLastFrame += Gdx.graphics.getDeltaTime();

        // Calcula o índice do próximo frame com base no tempo decorrido
        if (timeSinceLastFrame >= frameDuration) {
            currentFrame = (currentFrame + 1) % numFramesX; // Avança para o próximo frame
            timeSinceLastFrame = 0; // Reseta o tempo decorrido
        }

        // Atualiza a posição x do recorte do sprite
        posX = currentFrame * frameWidth;
    }

    public void dispose() {
        sprite.dispose();
    }
}
