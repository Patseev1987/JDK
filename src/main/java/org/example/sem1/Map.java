package org.example.sem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    Map(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                 update(e);
            }
        });
    }

    private void update(MouseEvent e){
        repaint();
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.printf(" x = %d    y = %d",cellX,cellY);
    }

    void startNewGame(int mode, int fSx, int fSy, int wLength){
        System.out.println(mode+fSx+fSy+wLength);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g){
        panelHeight = getHeight();
        panelWidth = getWidth();
        cellHeight=panelHeight/3;
        cellWidth=panelWidth/3;

        g.setColor(Color.BLACK);
        for (int w = 0; w < 3; w++) {
            int x = w * cellWidth;
            g.drawLine(x,0,x,panelHeight);
        }
        for (int h = 0; h < 3; h++) {
            int y = h * cellHeight;
            g.drawLine(0,y,panelWidth,y);
        }

    }
}
