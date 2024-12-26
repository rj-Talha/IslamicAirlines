package com.Packages.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class LoginPage
{
    public JFrame loginPage(JFrame frontFrame)
    {


        DefaultStyle Style =new DefaultStyle();
        JFrame loginFrame=new JFrame("Islamic Airlines");
        loginFrame.setLayout(null);
        loginFrame.setBounds(395,140,500,500);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Panel for navigation bar
        JPanel pnl_navBar =new JPanel();
        JLabel lbl_navBar=new JLabel();

        pnl_navBar.setLayout(null);
        pnl_navBar.setBackground(new java.awt.Color(30,144,255));
        pnl_navBar.setBounds(0,0,600,75);
        lbl_navBar.setText("Login Form");

        lbl_navBar.setFont(new Font("Serif", Font.BOLD, 23));
        lbl_navBar.setForeground(Color.WHITE);
        lbl_navBar.setBounds(200,25,200,28);
        pnl_navBar.add(lbl_navBar);

        // Main Heading Panel

        JPanel pnl_loginForm =new JPanel();
        JLabel name =new JLabel();
        JTextField nameField =new JTextField();

        JLabel password=new JLabel();



        pnl_loginForm.setLayout(null);
        pnl_loginForm.setBounds(0,75,600,600);
        pnl_loginForm.setBackground(Color.WHITE);
        // Labels + Text fields
        name.setText("Name");
        name.setFont(new Font("Serif", Font.PLAIN,18));
        name.setForeground(Color.BLACK);

        name.setBounds(60,30,80,30);
        pnl_loginForm.add(name);
        nameField.setBounds(190,30,225,30);
        pnl_loginForm.add(nameField);
        // Password label and Field
        pnl_loginForm.add(password);
        password.setText("Password");
        password.setBounds(60,100,80,30);
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Serif",Font.PLAIN,18));
        pnl_loginForm.add(password);
        //
        JPanel passwordPanel = new JPanel(null);
        passwordPanel.setBackground(null);
        passwordPanel.setBounds(190, 100, 250, 30);
        pnl_loginForm.add(passwordPanel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(0, 0, 225, 30);
        passwordPanel.add(passwordField);

        JLabel showLabel = new JLabel("\uD83D\uDE11\n");
        showLabel.setFont(new Font(Font.SERIF,Font.BOLD,18));
        showLabel.setBounds(226, 5, 50, 20); // Positioned inside the password field
        showLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        passwordPanel.add(showLabel);

        // Add mouse listener to the "Show" label
        showLabel.addMouseListener(new MouseAdapter() {
            private boolean isPasswordVisible = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPasswordVisible) {
                    passwordField.setEchoChar('*');
                    showLabel.setText("\uD83D\uDE11\n");
                } else {
                    passwordField.setEchoChar((char) 0); // Show password
                    showLabel.setText("\uD83D\uDE10\n");
                }
                isPasswordVisible = !isPasswordVisible;
            }
        });



        // Buttons
        JButton btn_logIn=new JButton();
        btn_logIn.setText("LogIn");
        Style.ButtonStyle(btn_logIn);
        btn_logIn.setBackground(new java.awt.Color(30,144,255));
        btn_logIn.addMouseListener(new java.awt.event.MouseAdapter()

        {
            @Override
            public void mouseEntered (MouseEvent e){
                btn_logIn.setBackground(Color.WHITE);
                btn_logIn.setForeground(new java.awt.Color(30,144,255));
            }

            @Override
            public void mouseExited (MouseEvent e){
                btn_logIn.setBackground(new java.awt.Color(30,144,255));
                btn_logIn.setForeground(Color.WHITE);
            }

        });


             btn_logIn.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     String pass = new String(passwordField.getPassword()).trim();

                     WelcomePage welcomePage = new WelcomePage();
                     if (nameField.getText().isEmpty())
                     {
                         JOptionPane.showMessageDialog(loginFrame, "Enter user Name");

                     } else if (pass.isEmpty())
                     {
                         JOptionPane.showMessageDialog(loginFrame, "Enter Password");

                     }
                     else
                     {
                         try (Connection connection = DriverManager.getConnection(
                                 "jdbc:mysql://localhost:3306/islamicairlines", "root", ""
                         );
                              PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?"))
                         {
                             preparedStatement.setString(1,nameField.getText());
                             preparedStatement.setString(2,pass);
                             ResultSet resultSet = preparedStatement.executeQuery();
                             if(resultSet.next()) {
                                 loginFrame.setVisible(false);

                                 frontFrame.setVisible(false);

                                 welcomePage.welcomePage();
                             }
                             else
                             {
                                 JOptionPane.showMessageDialog(null,"Invalid credentials. Please register first");
                             }


                         } catch (SQLException e1)
                         {
                             JOptionPane.showMessageDialog(null,"Error connecting to Database");
                         }

                     }


                 }
             });


        btn_logIn.setBounds(200,180,150,35);
        pnl_loginForm.add(btn_logIn);

        // Label SignUp

        JLabel lbl_Register = new JLabel();
        JLabel lbl_SignUp =new JLabel();
        lbl_Register.setText("Create new account");
        lbl_Register.setFont(new Font("Sherif",Font.PLAIN,18));
        lbl_Register.setBounds(50,285,200,30);
        lbl_SignUp.setText("Sign Up");
        lbl_SignUp.setFont(new Font("Sherif",Font.PLAIN,18));
        lbl_SignUp.setForeground(new java.awt.Color(30,144,255));
        lbl_SignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_SignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginFrame.setVisible(false);
                SignUpPage signupPage = new SignUpPage();
                signupPage.signupPage(frontFrame);
            }
        });

        lbl_SignUp.setBounds(390,285,160,30);
        pnl_loginForm.add(lbl_Register);
        pnl_loginForm.add(lbl_SignUp);


        loginFrame.add(pnl_navBar);
        loginFrame.add(pnl_loginForm);
        loginFrame.setVisible(true);
        return loginFrame;

    }
}
