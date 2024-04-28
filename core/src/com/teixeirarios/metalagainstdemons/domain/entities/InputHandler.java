package com.teixeirarios.metalagainstdemons.domain.entities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputProcessor, AbstractInputHandler {

    private List<InputObserver> observers;

    private static final long DOUBLE_CLICK_TIME_DELTA = 500;
    private long lastClickTime = 0;

    public InputHandler () {
        observers = new ArrayList<>();
    }

    public void addObserver(InputObserver observer) {
        observers.add(observer);
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.A) {
            for (InputObserver observer : observers) {
                observer.notifyMoveLeft();
            }
        }

        else if (keycode == Input.Keys.D) {
            for (InputObserver observer : observers) {
                observer.notifyMoveRight();
            }
        }

        else if (keycode == Input.Keys.W) {
            for (InputObserver observer : observers) {
                observer.notifyMoveUp();
            }
        }

        else if (keycode == Input.Keys.S) {
            for (InputObserver observer : observers) {
                observer.notifyMoveDown();
            }
        }

        else if (keycode == Input.Keys.SPACE) {
            for (InputObserver observer : observers) {
                observer.notifyRoll();
            }
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            for (InputObserver observer : observers) {
                observer.notifyStopMoveLeft();
            }
        }

        else if (keycode == Input.Keys.D) {
            for (InputObserver observer : observers) {
                observer.notifyStopMoveRight();
            }
        }

        else if (keycode == Input.Keys.W) {
            for (InputObserver observer : observers) {
                observer.notifyStopMoveUp();
            }
        }

        else if (keycode == Input.Keys.S) {
            for (InputObserver observer : observers) {
                observer.notifyStopMoveDown();
            }
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        long clickTime = System.currentTimeMillis();
        if ((clickTime - lastClickTime) < DOUBLE_CLICK_TIME_DELTA) {
            for (InputObserver observer : observers) {
                observer.notifyRoll();
            }
        }
        lastClickTime = clickTime;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}