package com.teixeirarios.metalagainstdemons;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.teixeirarios.metalagainstdemons.domain.entities.InputHandler;
import com.teixeirarios.metalagainstdemons.domain.entities.Player;
import com.teixeirarios.metalagainstdemons.domain.entities.PlayerFactory;
import com.teixeirarios.metalagainstdemons.domain.entities.Scenario;
import com.teixeirarios.metalagainstdemons.infrastructure.device.DeviceDetails;
import com.teixeirarios.metalagainstdemons.infrastructure.ui.Camera;
import com.teixeirarios.metalagainstdemons.infrastructure.ui.VirtualJoystick;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MetalAgainstDemons extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	InputHandler inputHandler;
	Scenario scenario;
	Camera camera;
	FitViewport viewport;
	Stage stage;
	VirtualJoystick joystick;

	@Override
	public void create () {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		viewport = new FitViewport(
				800, //(float)size.getWidth(),
				480 //(float)size.getHeight()
		);

		batch = new SpriteBatch();
		stage = new Stage(viewport, batch);

		joystick = new VirtualJoystick(stage);
		inputHandler = new InputHandler();

		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputHandler);
		multiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(multiplexer);

		player = PlayerFactory.create(batch, inputHandler, joystick);
		scenario = new Scenario(batch);
		camera = new Camera(batch);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		scenario.drawBackground();
		player.update();
		camera.setCameraPosition(player);
		batch.end();

		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
	}
}
