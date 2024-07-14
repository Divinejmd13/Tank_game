package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {
    private Vector2 moment=new Vector2();
    private float speed=20f;
    private float gravity=9.8f;
    public Player(Sprite sprite){
        super(sprite);
    }
    public void draw(SpriteBatch spritebatch){
        update(Gdx.graphics.getDeltaTime());
        super.draw(spritebatch);
    }
    public void update(float delta){
        moment.y-=gravity*delta;
        moment.x=10;
        if(moment.y>speed){moment.y=speed;
            }else if(moment.y<speed){moment.y= -speed; }
//        setX(getX()+moment.x * delta*10);
//        setY(getY() + moment.y * delta*10);
    }
}
