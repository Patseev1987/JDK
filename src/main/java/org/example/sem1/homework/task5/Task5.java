package org.example.sem1.homework.task5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static java.awt.event.KeyEvent.VK_ENTER;

public class Task5 extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("vasilii_pupkin");
    private final JPasswordField tfPassword = new JPasswordField("1337");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelButton = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> jList = new JList<>();
    private final DefaultListModel<String> dlm = new DefaultListModel<>();

    private Path history = Path.of("history.txt");


    private void loadHistory(Path path) {
        if (path.toFile().exists()) {
            try (Scanner scanner = new Scanner(path)) {
                while(scanner.hasNext()) {
                    log.append(scanner.nextLine()+"\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Task5() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");


        loadHistory(history);


        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        panelButton.add(tfMessage, BorderLayout.CENTER);
        panelButton.add(btnSend, BorderLayout.EAST);
        add(panelButton, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

        List<String> data = List.of("Cat", "Dog", "Horse", "Hamster",
                "Monkey", "Goat", "Rat", "Mouse", "Donkey", "Camel",
                "Lion", "Tiger", "Bear", "Owl");

        for (String str : data) {
            dlm.add(0, str);
        }
        jList.setModel(dlm);
        JScrollPane scrollForList = new JScrollPane(jList);
        add(scrollForList, BorderLayout.WEST);

        //----------HOMEWORK------------

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sendMessageInChat(getMessage());
            }
        });
        KeyListener myKeyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == VK_ENTER)
                    sendMessageInChat(getMessage());
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        };

        tfMessage.addKeyListener(myKeyListener);
        setVisible(true);
    }

    private void sendMessageInChat(String message) {
        if (!tfMessage.getText().isEmpty()) {
            log.append(message);
            saveMessageInFile(history, message);
        }
    }

    private void saveMessageInFile(Path path, String message) {

        try (FileWriter fileWriter = new FileWriter(path.toFile(),true)) {
            fileWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getMessage() {
        return tfLogin.getText() + ": "
                + tfMessage.getText() + "\n";
    }
}
