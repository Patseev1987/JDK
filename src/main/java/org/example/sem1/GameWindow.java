package org.example.sem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {
    private static  final int WINDOW_HEIGHT =555;
    private static  final int WINDOW_WIDTH =507;
    private static  final int WINDOW_POSX =800;
    private static  final int WINDOW_POSY =300;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    Map map = new Map();
    SettingWindow settingWindow;
    public GameWindow()  {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setResizable(false);
        JPanel panButton = new JPanel(new GridLayout(1,2));

        panButton.add(btnStart);
        panButton.add(btnExit);
        add(panButton,BorderLayout.SOUTH);
        add(map);
        settingWindow = new SettingWindow(this);
        btnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                settingWindow.setVisible(true);
            }
        });
        setVisible(true );

    }
}
