package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;

public class MainPage implements Screen{
    MyGdxGame game ;
    Stage stage;
    Button button4;
    TextButton button,button2,button3,button5;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;

    Texture img;
    Texture bgI;
    Music BGA;
    Texture texture,texture2;
    SpriteBatch batch;
    Sprite sprite;

    public MainPage(final MyGdxGame game){
        this.game=game;

    }
    void dis(){
        batch.dispose();
        texture.dispose();
        texture2.dispose();
        stage.dispose();
    }
    @Override
    public void show() {

        batch = new SpriteBatch();
        stage = new Stage();
        float w = Gdx.graphics.getWidth();
        float h=Gdx.graphics.getHeight();
        Pixmap pixmap200 = new Pixmap(Gdx.files.internal("tank3.png"));
        Pixmap pixmap100 = new Pixmap(1060, 530, pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight()
        );
        texture = new Texture(pixmap100);
        sprite =new Sprite(texture);

/////////////////////////////////////////////////////////////////////////////////
        Pixmap pixmap20 = new Pixmap(Gdx.files.internal("setting.png"));
        Pixmap pixmap10 = new Pixmap(50, 50, pixmap200.getFormat());
        pixmap10.drawPixmap(pixmap20,
                0, 0, pixmap20.getWidth(), pixmap20.getHeight(),
                0, 0, pixmap10.getWidth(), pixmap10.getHeight()
        );
        texture2 = new Texture(pixmap10);
        sprite =new Sprite(texture2);
        sprite.setPosition(w -sprite.getWidth(),h -sprite.getHeight());
/////////////////////////////////////////////////////////////////////////////////////////////////////
        Gdx.input.setInputProcessor(stage);
        font=new BitmapFont();
        skin =new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        button=new TextButton("New Game",skin,"default");
        button.setWidth(300f);
        button.setHeight(50f);
        button.setPosition(355,450);
        button5=new TextButton("Exit",skin,"default");
        button2=new TextButton("Resume",skin,"default");
        button2.setWidth(300f);
        button2.setHeight(50f);
        button5.setWidth(200f);
        button5.setHeight(50f);
        button2.setPosition(355,380);
        button5.setPosition(855,0);
        button3=new TextButton("Upgrade",skin,"default");
        button3.setWidth(300f);
        button3.setHeight(50f);
        button3.setPosition(355,300);

        BGA=Gdx.audio.newMusic(Gdx.files.internal("bg2.mp3"));
        BGA.setLooping(true);
        BGA.play();
        Object event = null;
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                dis();
                game.screen3();
            }
        });
        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                button3.setText("You clicked the button");
            }
        });
        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                button2.setText("You clicked the button");
            }
        });
        button5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                System.exit(0);
            }
        });


        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button5);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        System.out.println("rendering");
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(texture,0,0);
        batch.draw(texture2,5,455);
        batch.end();

        stage.draw();


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

        BGA.dispose();
        batch.dispose();
        bgI.dispose();
        img.dispose();


    }
}
