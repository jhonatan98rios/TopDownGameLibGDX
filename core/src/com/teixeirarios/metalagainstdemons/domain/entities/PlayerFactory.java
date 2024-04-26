package com.teixeirarios.metalagainstdemons.domain.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teixeirarios.metalagainstdemons.infrastructure.ui.AbstractCanvas;
import com.teixeirarios.metalagainstdemons.infrastructure.ui.LibGDXFacade;

public class PlayerFactory {

    public static Player create (SpriteBatch batch, InputHandler inputHandler) {
        AbstractCanvas playerView = new LibGDXFacade(batch, "spritesheet.png", 4, 0.10F, 50);
        PlayerController playerController = new PlayerController(inputHandler);
        Player player = new Player(playerView, playerController);
        return player;
    }
}
