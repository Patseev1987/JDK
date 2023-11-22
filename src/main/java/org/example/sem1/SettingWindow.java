package org.example.sem1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingWindow extends JFrame {
    private final int WINDOW_HEIGHT = 230;
    private final int WINDOW_WIDTH = 350;

    JLabel choiceGame = new JLabel("Choose game!");
    JRadioButton radioBtnHumanVsAi = new JRadioButton("Human vs AI");
    JRadioButton radioBtnHumanVsHuman = new JRadioButton("Human vs Human");
    JLabel size = new JLabel("Set field size");
    JLabel fieldInfo = new JLabel("3");
    JSlider fieldSlider = new JSlider(3,10);
    JLabel lineSizeForWin = new JLabel("Line size for wictory!");
    JLabel lineSize = new JLabel("3");
    JSlider lineSlider = new JSlider(3,10);
    JButton btnStart = new JButton("Start new game");

    JPanel btnPanel = new JPanel(new GridLayout(10,1));

    public SettingWindow(GameWindow gameWindow) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        add(btnPanel);
        btnPanel.add(choiceGame);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioBtnHumanVsAi);
        buttonGroup.add(radioBtnHumanVsHuman);
        btnPanel.add(radioBtnHumanVsAi);
        btnPanel.add(radioBtnHumanVsHuman);
        btnPanel.add(size);
        btnPanel.add(fieldInfo);
        fieldSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                fieldInfo.setText(String.valueOf(fieldSlider.getValue()));
            }
        });
        lineSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                lineSize.setText(String.valueOf(lineSlider.getValue()));
            }
        });
        btnPanel.add(fieldSlider);
        btnPanel.add(lineSizeForWin);
        btnPanel.add(lineSize);
        btnPanel.add(lineSlider);
        btnPanel.add(btnStart);


    }
    private int getMode (JRadioButton btn){
        if(radioBtnHumanVsAi == btn) {
            return 1;
        }else{
            return 2;
        }
    }
}
