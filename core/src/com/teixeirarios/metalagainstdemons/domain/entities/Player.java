package com.teixeirarios.metalagainstdemons.domain.entities;

import com.teixeirarios.metalagainstdemons.infrastructure.ui.AbstractCanvas;


public class Player {
    public AbstractCanvas playerView;
    public PlayerController playerController;

    public float posX;
    public float posY;
    public float velocity;


    public Player(AbstractCanvas playerView, PlayerController playerController) {
        this.playerView = playerView;
        this.playerController = playerController;
        this.posX = 0;
        this.posY = 0;
        this.velocity = 2;
    }

    public void update() {
        move();
        playerView.animate();
        playerView.drawImage(0, getDirection(), 50, 100, posX, posY, 50, 100);
    }

    public void dispose() {
        playerView.dispose();
    }

    public float getDirection() {
        return playerController.isMvRight() ? 300f
                : playerController.isMoving() ? 100f
                : 0f;
    }

    public void move() {

        final Boolean isMvHorizontally = (playerController.isMvLeft() || playerController.isMvRight());
        final Boolean isMvVertically = (playerController.isMvDown() || playerController.isMvUp());

        final float TEMP_SPEED = (isMvHorizontally && isMvVertically)
                ? velocity / 1.4f
                : velocity;

        if (playerController.isMvLeft() && !playerController.isMvRight()) {
            posX -= TEMP_SPEED;
        } else if (playerController.isMvRight() && !playerController.isMvLeft()) {
            posX += TEMP_SPEED;
        }

        if (playerController.isMvUp() && !playerController.isMvDown()) {
            posY += TEMP_SPEED;
        } else if (playerController.isMvDown() && !playerController.isMvUp()) {
            posY -= TEMP_SPEED;
        }
    }
}


