package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenu implements Screen {
    final MyGdxGame game1;
    private Texture bgimg;
    private TextureRegion bgt;
    OrthographicCamera camera;
    public MainMenu(final MyGdxGame game) {

        this.game1 = game;
        bgimg = new Texture(Gdx.files.internal("tanks-games_jpg_820.jpg"));
        bgt = new TextureRegion(bgt, 0, 0, 1920, 1229);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
     //   ScreenUtils.clear(0,0,0,0);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
