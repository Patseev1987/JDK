package org.example.sem2.lect;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
private long lastFrameTime;
    private MainWindow controller;
    public MainCanvas(MainWindow controller) {
        this.controller = controller;
        setBackground(Color.CYAN);
        lastFrameTime = System.nanoTime();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float delta = (System.nanoTime()-lastFrameTime)*0.000000001f;
        controller.onDrawFrame(this,g,delta);
        lastFrameTime = System.nanoTime();
        repaint();
    }

    public int getLeft(){return 0;}
    public int getRight(){return getWidth()-1;}
    public int getTop(){return 0;}
    public int getBottom(){return getHeight()-1;}
}
