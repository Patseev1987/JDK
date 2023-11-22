package org.example.sem2.lect;

import java.awt.*;

abstract public class Sprite {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;


    protected float getLeft() { return x -halfWidth;}
    protected void setLeft( float left){x = left+halfWidth;}
    protected float getRight() { return x +halfWidth;}
    protected void setRight( float right){x = right-halfWidth;}
    protected float getTop() { return y -halfHeight;}
    protected void setTop( float top){y = top+halfWidth;}
    protected float getBottom() { return y +halfHeight;}
    protected void setBottom( float bottom){y = bottom-halfWidth;}

    protected float getWidth(){ return 2*halfWidth;}
    protected float getHeight(){return 2*halfHeight;}

    void update(MainCanvas canvas, float delta){}
    void render(MainCanvas canvas, Graphics g){}

}
