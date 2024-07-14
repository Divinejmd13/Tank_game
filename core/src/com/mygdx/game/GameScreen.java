package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen extends ApplicationAdapter implements InputProcessor , Screen {
    private Texture img;
    private TiledMap tiledMap;
    private  OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;
    private SpriteBatch batch;
    private Sprite sprite;
    private  Texture bg;
    private Texture Tarn,tank;
    private TiledMap map;
    private OrthoCachedTiledMapRenderer rand;
    private OrthographicCamera cam;
    private Stage stage;
    private ShapeRenderer sr;
    Animation animation;
    private Player tank1;

    @Override
    public void create () {
    }

    @Override
    public void render () {}

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.A && camera.position.x>434)
            camera.translate(-32,0);
        System.out.println();
        if(keycode == Input.Keys.D && camera.position.x<626)
            camera.translate(32,0);
//        if(keycode == Input.Keys.W)
//            camera.zoom-=0.1;
//        if(keycode == Input.Keys.S)
//            camera.zoom+=0.1;

        return false;

    }



    @Override
    public void show() {
        stage=new Stage(new ScreenViewport());
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        Pixmap pixmap200 = new Pixmap(Gdx.files.internal("Frost.png"));
        Pixmap pixmap100 = new Pixmap(100, 100, pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight()
        );
        tank  = new Texture(pixmap100);
        tank1= new Player(new Sprite(tank));

        camera = new OrthographicCamera();
        camera.setToOrtho(false,w,h);
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/1.6f,0);
        camera.zoom=0.8f;
        camera.update();
        tiledMap = new TmxMapLoader().load("E:\\Assi2\\project2\\assets\\Terren_Final\\Terren_Final\\Export\\export1.tmx");

        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        sr=new ShapeRenderer();
        Gdx.input.setInputProcessor(this);
//
        Pixmap pixmap_20 = new Pixmap(Gdx.files.internal("mars.png"));
        Pixmap pixmap_10= new Pixmap(1060, 600, pixmap_20.getFormat());
        pixmap_10.drawPixmap(pixmap_20,
                0, 0, pixmap_20.getWidth(), pixmap_20.getHeight(),
                0, 0, pixmap_10.getWidth(), pixmap_10.getHeight()
        );

        bg=new Texture(pixmap_10);
        batch = new SpriteBatch();
        animation = gif.loadGIFAnimation(Animation.PlayMode.LOOP,Gdx.files.internal("loading.gif").read());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(bg,0,0);
        batch.draw(tank,50,260);

        tank1.draw(batch);
        batch.end();
        camera.update();

        tiledMapRenderer.setView(camera);

        tiledMapRenderer.render();

    }

    @Override
    public void hide() {

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



