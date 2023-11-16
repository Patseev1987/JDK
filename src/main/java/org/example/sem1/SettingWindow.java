package org.example.sem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingWindow extends JFrame {
   private final int WINDOW_HEIGHT = 230;
   private final int WINDOW_WIDTH = 350;

   JButton btnStart = new  JButton("Start new game");
    public SettingWindow(GameWindow gameWindow)  {
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        add(btnStart);
        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameWindow.map.startNewGame(1,3,3,3);
            }
        });
    }
}
