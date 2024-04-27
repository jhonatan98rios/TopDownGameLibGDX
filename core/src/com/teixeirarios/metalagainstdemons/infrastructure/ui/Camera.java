package com.teixeirarios.metalagainstdemons.infrastructure.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teixeirarios.metalagainstdemons.domain.entities.Player;

public class Camera {

    private OrthographicCamera camera;
    private SpriteBatch batch;

    public Camera(SpriteBatch batch) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.batch = batch;
    }

    public void setCameraPosition(Player player) {
        if (player.posX < camera.position.x - camera.viewportWidth / 4) {
            camera.position.x = player.posX + camera.viewportWidth / 4;
        } else if (player.posX > camera.position.x + camera.viewportWidth / 4) {
            camera.position.x = player.posX - camera.viewportWidth / 4;
        }

        if (player.posY < camera.position.y - camera.viewportHeight / 4) {
            camera.position.y = player.posY + camera.viewportHeight / 4;
        } else if (player.posY > camera.position.y + camera.viewportHeight / 8) {
            camera.position.y = player.posY - camera.viewportHeight / 8;
        }

        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }
}
