package org.example.sem2.lect;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite{
    private static Random random= new Random();
    private Color color ;
    private float vX;
    private float   vY;

    public Ball() {
        halfHeight = 20+ (float) (Math.random()*50f);
        halfWidth = halfHeight;
        color = new Color(random.nextInt());
        vX = 100f+(float) (Math.random()*200f);
        vY = 100f+(float) (Math.random()*200f);
    }

    @Override
    void update(MainCanvas canvas, float delta) {
        x  += vX*delta;
        y += vY*delta;

        if(getLeft()< canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX = - vX;
        }
        if(getRight()> canvas.getRight()){
            setRight(canvas.getRight());
            vX = - vX;
        }
        if(getTop()< canvas.getTop()){
            setTop(canvas.getTop());
            vY = - vY;
        }
        if(getBottom()> canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY = - vY;
        }
    }

    @Override
    void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(),(int)getTop(),(int)getWidth(),(int)getHeight());
    }
}
