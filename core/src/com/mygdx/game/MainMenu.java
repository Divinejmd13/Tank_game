package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen{
   private MyGdxGame game ;
    private Texture img;
    private Texture bgI;
    private Music BGA;
    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;
    private Pixmap pixmap200;
    private  Pixmap pixmap100;

    public MyGdxGame getGame() {
        return game;
    }

    public void setGame(MyGdxGame game) {
        this.game = game;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public Texture getBgI() {
        return bgI;
    }

    public void setBgI(Texture bgI) {
        this.bgI = bgI;
    }

    public Music getBGA() {
        return BGA;
    }

    public void setBGA(Music BGA) {
        this.BGA = BGA;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

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

    public Pixmap getPixmap200() {
        return pixmap200;
    }

    public void setPixmap200(Pixmap pixmap200) {
        this.pixmap200 = pixmap200;
    }

    public Pixmap getPixmap100() {
        return pixmap100;
    }

    public void setPixmap100(Pixmap pixmap100) {
        this.pixmap100 = pixmap100;
    }

    public MainMenu(MyGdxGame game){
        this.game=game;

    }

    @Override
    public void show() {

        batch = new SpriteBatch();
        img = new Texture("tanks-games_jpg_820.jpg");
        float w = Gdx.graphics.getWidth();
        float h=Gdx.graphics.getHeight();
        pixmap200 = new Pixmap(Gdx.files.internal("data_0001.png"));
        pixmap100 = new Pixmap(200, 200, pixmap200.getFormat());
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

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        sprite.draw(batch);
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isButtonPressed(Input.Buttons.LEFT) || Gdx.input.isButtonPressed(Input.Buttons.RIGHT) ){
            BGA.pause();
            game.screen2();

             }
        batch.end();
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

        img.dispose();
        this.pixmap200.dispose();
        texture.dispose();
        batch.dispose();
    }


    public void dipose() {
 }
}
