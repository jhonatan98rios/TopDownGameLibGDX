package com.teixeirarios.metalagainstdemons.domain.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements InputProcessor {

    private List<InputObserver> observers;

    public InputHandler () {
        Gdx.input.setInputProcessor(this);
        observers = new ArrayList<>();
    }

    public void addObserver(InputObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(InputObserver observer) {
        observers.remove(observer);
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