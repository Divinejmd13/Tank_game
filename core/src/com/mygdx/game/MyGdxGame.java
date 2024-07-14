package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	private SpriteBatch batch;
	private Sprite sprite;

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}


	@Override
	public void create () {
// 		batch=	new SpriteBatch();

		setScreen(new MainMenu(this));



//		this.setScreen(new MainMenu(this));
	}
	public void screen2(){
		this.setScreen(new MainPage(this));

	}
	public void screen3(){
		this.setScreen(new Play_s_Tank(this));
	}
	public void gameScreen(){
		this.setScreen((Screen) new GameScreen());
	}






	@Override
	public void dispose () {

	}
}
