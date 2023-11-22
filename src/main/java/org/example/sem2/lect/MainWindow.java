package org.example.sem2.lect;

import org.example.sem1.Main;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int X_POS = 200;
    private static final int Y_POS = 400;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private final Sprite[] sprites = new Sprite[10];

    private MainWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(X_POS,Y_POS,WINDOW_WIDTH,WINDOW_HEIGHT);

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

        setVisible(true);
    }


    public void onDrawFrame(MainCanvas canvas, Graphics g,float delta){
        update(canvas,delta);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float delta){
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas,delta);
        }
    }

    private void render(MainCanvas canvas, Graphics g){
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas,g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}

