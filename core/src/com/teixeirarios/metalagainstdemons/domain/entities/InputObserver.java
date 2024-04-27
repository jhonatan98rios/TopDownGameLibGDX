package com.teixeirarios.metalagainstdemons.domain.entities;

public interface InputObserver {
    void notifyMoveLeft();
    void notifyMoveRight();
    void notifyMoveUp();
    void notifyMoveDown();
    void notifyStopMoveLeft();
    void notifyStopMoveRight();
    void notifyStopMoveUp();
    void notifyStopMoveDown();
    void notifyRoll();
}