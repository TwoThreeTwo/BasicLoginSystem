package main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MainPage implements ActionListener{

    JFrame frame = new JFrame();
    JButton registerButton = new JButton("Register");
    JButton loginButton = new JButton("Login");
    JLabel usernameLabel = new JLabel("Username");
    JTextField usernameText = new JTextField("Username");
    JLabel passwordLabel = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField("Password");

    MainPage(){
        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(usernameLabel);
        frame.add(usernameText);
        frame.add(passwordLabel);
        frame.add(passwordField);

        frame.getContentPane().setBackground(Color.darkGray);
        frame.setTitle("Main 1.0");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,300);
        frame.setLayout(null);
        frame.setVisible(true);

        usernameLabel.setBounds(0, 20, 100, 20);
        usernameLabel.setFont(new Font(null, Font.PLAIN, 10));
        usernameText.setBounds(48, 20, 100, 20);
        usernameLabel.setForeground(Color.WHITE);

        passwordLabel.setBounds(0, 40, 100, 20);
        passwordLabel.setFont(new Font(null, Font.PLAIN, 10));
        passwordField.setBounds(48, 40, 100, 20);
        passwordLabel.setForeground(Color.WHITE);

        registerButton.setBounds(0, 220, 100, 20);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        loginButton.setBounds(0,240,700,20);
        loginButton.setFont(new Font(null, Font.PLAIN, 10));
        loginButton.addActionListener(onClick -> {
            String user = usernameText.getText();
            String password = passwordField.getText();
            creatUserFile(user, password);

        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton) {
            RegisterWindow myWindow = new RegisterWindow();
        }
    }
    private void creatUserFile(String username, String password) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Auth-Info" + ".json"))) {
            bufferedWriter.write(username + ", " + password);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}