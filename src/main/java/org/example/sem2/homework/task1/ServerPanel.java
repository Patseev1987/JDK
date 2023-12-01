package org.example.sem2.homework.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ServerPanel extends JFrame implements ServerListener {
    private JButton startBtn;
    private JButton stopBtn;
    private JPanel panelWithButtons;
    private boolean isServerWorking;

    private JTextArea textArea;


    private final int X_POS_LEFT_UPPER_CORNER = 800;
    private final int Y_POS_LEFT_UPPER_CORNER = 300;
    private final int WIDTH = 500;
    private final int HEIGHT = 300;
    private ChatServer server;

    public ServerPanel() {
        setTitle("Chat server");
        server = new ChatServer(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(X_POS_LEFT_UPPER_CORNER, Y_POS_LEFT_UPPER_CORNER);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setAlwaysOnTop(true);
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                server.stop();
            }
        });
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                server.start();
            }
        });
        panelWithButtons = new JPanel(new GridLayout());
        panelWithButtons.add(startBtn);
        panelWithButtons.add(stopBtn);
        textArea = new JTextArea("Server info");
        JPanel panelWithTextAndButtons = new JPanel(new GridLayout(2, 1));
        panelWithTextAndButtons.add(panelWithButtons);
        panelWithTextAndButtons.add(textArea);

        add(panelWithTextAndButtons);
        setVisible(true);

    }

    @Override
    public void getMessage(String msg) {
        textArea.append(msg+"\n");
    }
}
