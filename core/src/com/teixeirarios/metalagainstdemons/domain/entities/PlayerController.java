package com.teixeirarios.metalagainstdemons.domain.entities;

public class PlayerController implements InputObserver {

    private Boolean mvLeft = false;
    private Boolean mvUp = false;
    private Boolean mvRight = false;
    private Boolean mvDown = false;

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
