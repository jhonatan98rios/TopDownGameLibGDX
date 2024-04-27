package com.teixeirarios.metalagainstdemons.domain.entities;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerController implements InputObserver {

    private Boolean mvLeft = false;
    private Boolean mvUp = false;
    private Boolean mvRight = false;
    private Boolean mvDown = false;
    private Boolean roll = false;

    public PlayerController (InputHandler inputHandler) {
        inputHandler.addObserver(this);
    }

    public Boolean isMoving() {
        return mvLeft || mvRight || mvUp || mvDown;
    }

    public boolean isMvLeft() {
        return mvLeft;
    }

    public boolean isMvRight() {
        return mvRight;
    }

    public boolean isMvUp() {
        return mvUp;
    }

    public boolean isMvDown() {
        return mvDown;
    }

    public boolean isRolling() {
        return roll;
    }

    @Override
    public void notifyMoveLeft() {
        mvLeft = true;
    }

    @Override
    public void notifyMoveRight() {
        mvRight = true;
    }

    @Override
    public void notifyMoveUp() {
        mvUp = true;
    }

    @Override
    public void notifyMoveDown() {
        mvDown = true;
    }

    @Override
    public void notifyRoll() {
        if (roll == false && isMoving()) {
            roll = true;

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    roll = false;
                }
            }, 500L);
        }
    }

    @Override
    public void notifyStopMoveLeft() {
        mvLeft = false;
    }

    @Override
    public void notifyStopMoveRight() {
        mvRight = false;
    }

    @Override
    public void notifyStopMoveUp() {
        mvUp = false;
    }

    @Override
    public void notifyStopMoveDown() {
        mvDown = false;
    }

}
