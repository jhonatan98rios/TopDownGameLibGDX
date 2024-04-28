package com.teixeirarios.metalagainstdemons.infrastructure.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.teixeirarios.metalagainstdemons.domain.entities.AbstractInputHandler;
import com.teixeirarios.metalagainstdemons.domain.entities.InputObserver;

import java.util.ArrayList;
import java.util.List;

public class VirtualJoystick implements AbstractInputHandler {
    public Touchpad touchpad;
    private List<InputObserver> observers;

    public VirtualJoystick(Stage stage) {

        observers = new ArrayList<>();

        // Texturas para o fundo e botão do touchpad
        Texture backgroundTexture = new Texture("touchpad_background.png");
        Texture knobTexture = new Texture("touchpad_knob.png");

        // Convertendo as texturas em Drawable
        Drawable backgroundDrawable = new TextureRegionDrawable(backgroundTexture);
        Drawable knobDrawable = new TextureRegionDrawable(knobTexture);

        // Criando o touchpad manualmente
        Touchpad.TouchpadStyle style = new Touchpad.TouchpadStyle();
        style.background = backgroundDrawable;
        style.knob = knobDrawable;

        touchpad = new Touchpad(0, style);
        touchpad.setBounds(15, 15, 200, 200); // Posição e tamanho do touchpad

        setEventListeners();
        stage.addActor(touchpad);
    }

    @Override
    public void addObserver(InputObserver observer) {
        observers.add(observer);
    }

    public void setEventListeners() {
        touchpad.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setTouchDraggedNotifiers();
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                setTouchDraggedNotifiers();
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                for (InputObserver observer : observers) {
                    observer.notifyStopMoveUp();
                    observer.notifyStopMoveDown();
                    observer.notifyStopMoveRight();
                    observer.notifyStopMoveLeft();
                }
            }

            public void setTouchDraggedNotifiers() {
                if (getKnobY() >= 0.2) {
                    for (InputObserver observer : observers) {
                        observer.notifyMoveUp();
                    }
                } else {
                    for (InputObserver observer : observers) {
                        observer.notifyStopMoveUp();
                    }
                }

                if (getKnobY() <= -0.2) {
                    for (InputObserver observer : observers) {
                        observer.notifyMoveDown();
                    }
                } else {
                    for (InputObserver observer : observers) {
                        observer.notifyStopMoveDown();
                    }
                }

                if (getKnobX() >= 0.2) {
                    for (InputObserver observer : observers) {
                        observer.notifyMoveRight();
                    }
                } else {
                    for (InputObserver observer : observers) {
                        observer.notifyStopMoveRight();
                    }
                }

                if (getKnobX() <= -0.2) {
                    for (InputObserver observer : observers) {
                        observer.notifyMoveLeft();
                    }
                } else {
                    for (InputObserver observer : observers) {
                        observer.notifyStopMoveLeft();
                    }
                }
            }
        });
    }

    public float getKnobX() {
        return touchpad.getKnobPercentX();
    }
    public float getKnobY() {
        return touchpad.getKnobPercentY();
    }


}