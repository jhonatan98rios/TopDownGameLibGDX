package com.teixeirarios.metalagainstdemons;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.teixeirarios.metalagainstdemons.domain.entities.InputHandler;
import com.teixeirarios.metalagainstdemons.domain.entities.Player;
import com.teixeirarios.metalagainstdemons.domain.entities.PlayerFactory;

public class MetalAgainstDemons extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	InputHandler inputHandler;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		inputHandler = new InputHandler();
		player = PlayerFactory.create(batch, inputHandler);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.update();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player.dispose();
	}
}
