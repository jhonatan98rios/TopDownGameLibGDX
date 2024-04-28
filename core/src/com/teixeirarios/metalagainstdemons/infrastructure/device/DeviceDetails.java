package com.teixeirarios.metalagainstdemons.infrastructure.device;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class DeviceDetails {

    static public String getPlatform() {
        if (Gdx.app.getType() == Application.ApplicationType.Android ||
                Gdx.app.getType() == Application.ApplicationType.iOS) {
            return "Mobile";
        } else {
            return "Desktop";
        }
    }

    static public Boolean isMobile() {
        return DeviceDetails.getPlatform() == "Mobile";
    }
}
