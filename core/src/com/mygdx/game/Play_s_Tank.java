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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Play_s_Tank implements Screen{
    TextButton button,button1,button2,button3;
    Stage stage;
    private MyGdxGame game ;
    private Texture bgI,tank1,tank2;
    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;

    private Texture one ,two;


    public Play_s_Tank(MyGdxGame game){
        this.game=game;

    }

    @Override
    public void show() {
        stage= new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("orange/skin/uiskin.json"));
        button=new TextButton("Select (P1)",skin,"default");
        button.setWidth(200f);
        button.setHeight(50f);
        button.setPosition(130,150);
        stage.addActor(button);
        ////////////////////////////////////////////////////////////////////////////
        button2=new TextButton("Select (P2)",skin,"default");
        button2.setWidth(200f);
        button2.setHeight(50f);
        button2.setPosition(790,150);
        stage.addActor(button2);
        //////////////////////////////////////////////////////////////
        button2=new TextButton("Select (P2)",skin,"default");
        button2.setWidth(200f);
        button2.setHeight(50f);
        button2.setPosition(800,150);
        stage.addActor(button2);
        ////////////////////////////////////////////////////////////////////////
        button3=new TextButton("Let's Play",skin,"default");
        button3.setWidth(200f);
        button3.setHeight(50f);
        button3.setPosition(420,100);
        stage.addActor(button3);
        batch = new SpriteBatch();
//        bgI = new Texture("mars.png");
        float w = Gdx.graphics.getWidth();
        float h=Gdx.graphics.getHeight();
        Pixmap pixmap200 = new Pixmap(Gdx.files.internal("logo.png"));
        Pixmap pixmap100 = new Pixmap(100, 200, pixmap200.getFormat());
        pixmap100.drawPixmap(pixmap200,
                0, 0, pixmap200.getWidth(), pixmap200.getHeight(),
                0, 0, pixmap100.getWidth(), pixmap100.getHeight()
        );
        bgI=new Texture("mars.png");

        texture = new Texture(pixmap100);
        sprite =new Sprite(texture);
        sprite.setPosition(w/2 -sprite.getWidth()/2,h/2 -sprite.getHeight()/2);
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        Pixmap pixmap20 = new Pixmap(Gdx.files.internal("Frost.png"));
        Pixmap pixmap10 = new Pixmap(230, 230, pixmap20.getFormat());
        pixmap10.drawPixmap(pixmap20,
                0, 0, pixmap20.getWidth(), pixmap20.getHeight(),
                0, 0, pixmap10.getWidth(), pixmap10.getHeight()
        );
        tank1  = new Texture(pixmap10);
        Pixmap pixmap2 = new Pixmap(Gdx.files.internal("Buratino.png"));
        Pixmap pixmap1 = new Pixmap(230, 230, pixmap2.getFormat());
        pixmap1.drawPixmap(pixmap2,
                0, 0, pixmap2.getWidth(), pixmap2.getHeight(),
                0, 0, pixmap1.getWidth(), pixmap1.getHeight()
        );
        tank2=new Texture(pixmap1);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        Pixmap pixmap_2 = new Pixmap(Gdx.files.internal("player1.png"));
        Pixmap pixmap_1= new Pixmap(100, 100, pixmap_2.getFormat());
        pixmap_1.drawPixmap(pixmap_2,
                0, 0, pixmap_2.getWidth(), pixmap_2.getHeight(),
                0, 0, pixmap_1.getWidth(), pixmap_1.getHeight()
        );
        one=new Texture(pixmap_1);
        Pixmap pixmap_20 = new Pixmap(Gdx.files.internal("player2.png"));
        Pixmap pixmap_10= new Pixmap(100, 100, pixmap_20.getFormat());
        pixmap_10.drawPixmap(pixmap_20,
                0, 0, pixmap_20.getWidth(), pixmap_20.getHeight(),
                0, 0, pixmap_10.getWidth(), pixmap_10.getHeight()
        );
        two=new Texture(pixmap_10);
        //////////////////////////////////////////////////////////////////////////////////
        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
               game.gameScreen();
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(bgI ,0,0);
        batch.draw(tank2,100,200);
        batch.draw(tank1,750,200);
        batch.draw(one,380,400);
        batch.draw(two,600,400);
        sprite.draw(batch);
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

    }


    public void dipose() {




    }
}
