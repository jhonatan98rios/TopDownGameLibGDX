package com.teixeirarios.metalagainstdemons.infrastructure.ui;

public interface AbstractCanvas {
    public void drawImage(float sx, float sy, float sw, float sh, float dx, float dy, float dw, float dh);
    public void animate();
    public void dispose();
}
