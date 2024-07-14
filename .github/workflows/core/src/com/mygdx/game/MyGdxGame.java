package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game implements ApplicationListener {
	SpriteBatch batch;
	Texture img;
	private Texture texture;
	private Sprite sprite;
	Music BGA;
	@Override
	public void create () {

		batch = new SpriteBatch();
		img = new Texture("tanks-games_jpg_820.jpg");
		float w = Gdx.graphics.getWidth();
		float h=Gdx.graphics.getHeight();
		Pixmap pixmap200 = new Pixmap(Gdx.files.internal("data_0001.png"));
		Pixmap pixmap100 = new Pixmap(200, 200, pixmap200.getFormat());
		pixmap100.drawPixmap(pixmap200,
				0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
				0, 0, pixmap100.getWidth(), pixmap100.getHeight()
		);
		texture = new Texture(pixmap100);
		sprite =new Sprite(texture);
		sprite.setPosition(w/2 -sprite.getWidth()/2,h/6 -sprite.getHeight()/6);

		BGA=Gdx.audio.newMusic(Gdx.files.internal("bgAudio.mp3"));
		BGA.setLooping(true);
		BGA.play();
		//this.setScreen(new MainMenu(this));
	}



	@Override
	public void render () {
	Gdx.gl.glClearColor(1,1,1,1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isButtonPressed(Input.Buttons.LEFT) || Gdx.input.isButtonPressed(Input.Buttons.RIGHT) ){
					this.setScreen(new MainMenu(this));
			}

		batch.begin();
		batch.draw(img, 0, 0);
		sprite.draw(batch);
		batch.end();
	}
	


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		texture.dispose();
	}
}
