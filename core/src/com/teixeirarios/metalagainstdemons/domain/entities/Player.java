package com.teixeirarios.metalagainstdemons.domain.entities;

import com.teixeirarios.metalagainstdemons.infrastructure.ui.AbstractCanvas;


public class Player {
    public AbstractCanvas playerView;
    public PlayerController playerController;
    public float posX;
    public float posY;
    public final float velocity;

    char posDirection;


    public Player(AbstractCanvas playerView, PlayerController playerController) {
        this.playerView = playerView;
        this.playerController = playerController;
        this.posX = 0;
        this.posY = 0;
        this.posDirection = 'L';
        this.velocity = 2.5f;
    }

    public void update() {
        move();
        playerView.animate();
        playerView.drawImage(0, getSprite(), 93, 66, posX, posY, 93, 66);
    }

    public void dispose() {
        playerView.dispose();
    }

    public float getSprite() {
        float sprite = playerController.isMoving()
                ? posDirection == 'L' ? 66 : 257
                : posDirection == 'L' ? 0 : 191;

        sprite = playerController.isRolling()
                ? posDirection == 'L' ? 132 : 330
                : sprite;

        return sprite;
    }

    public void move() {
        final Boolean isMvHorizontally = (playerController.isMvLeft() || playerController.isMvRight());
        final Boolean isMvVertically = (playerController.isMvDown() || playerController.isMvUp());
        final Boolean isDiagonal = isMvHorizontally && isMvVertically;

        final float TEMP_SPEED = playerController.isRolling() ? isDiagonal ? velocity * 1.42f : velocity * 2f
                : isDiagonal ? velocity / 1.4f : velocity;

        if (playerController.isMvLeft() && !playerController.isMvRight()) {
            posX -= TEMP_SPEED;
            posDirection = 'L';
        } else if (playerController.isMvRight() && !playerController.isMvLeft()) {
            posX += TEMP_SPEED;
            posDirection = 'R';
        }

        if (playerController.isMvUp() && !playerController.isMvDown()) {
            posY += TEMP_SPEED;
        } else if (playerController.isMvDown() && !playerController.isMvUp()) {
            posY -= TEMP_SPEED;
        }
    }
}


