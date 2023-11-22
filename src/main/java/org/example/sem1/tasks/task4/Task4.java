package org.example.sem1.tasks.task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task4 extends JFrame {
    private JButton startBtn;
    private JButton stopBtn;
    private JPanel panelWithButtons;
    private boolean isServerWorking;

    private JTextArea textArea;


    private final int X_POS_LEFT_UPPER_CORNER = 800;
    private final int Y_POS_LEFT_UPPER_CORNER = 300;
    private final int WIDTH = 500;
    private final int HEIGHT = 300;


    public Task4()  {
        setTitle("Chat server");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(X_POS_LEFT_UPPER_CORNER, Y_POS_LEFT_UPPER_CORNER);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setAlwaysOnTop(true);
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText("Server is stopped! "+ LocalDateTime.now());
                if(isServerWorking)
                isServerWorking = false;
                textArea.append("\nisServerWorking = "+isServerWorking);
            }
        });
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText("Server is started! "+ LocalDateTime.now());
                if(!isServerWorking)
                isServerWorking = true;
                textArea.append("\nisServerWorking = "+isServerWorking);
            }
        });
        panelWithButtons = new JPanel(new GridLayout());
        panelWithButtons.add(startBtn);
        panelWithButtons.add(stopBtn);
        textArea = new JTextArea("Server info");
        JPanel panelWithTextAndButtons = new JPanel(new GridLayout(2,1));
        panelWithTextAndButtons.add(panelWithButtons);
        panelWithTextAndButtons.add(textArea);

        add(panelWithTextAndButtons);
        setVisible(true);

    }
}
