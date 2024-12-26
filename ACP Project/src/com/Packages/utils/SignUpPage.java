package com.Packages.utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUpPage {

    public JFrame signupPage(JFrame frontFrame) {

        DefaultStyle style = new DefaultStyle();
        JFrame signupFrame = new JFrame("Islamic Airlines");
        signupFrame.setLayout(null);
        signupFrame.setBounds(395,140,500,500);
        signupFrame.setResizable(false);
        signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel pnl_navbar = new JPanel();
        JLabel lbl_navbar = new JLabel();

        pnl_navbar.setLayout(null);
        pnl_navbar.setBounds(0,0,600,75);
        pnl_navbar.setBackground(new java.awt.Color(30,144,255));
        signupFrame.add(pnl_navbar);

        lbl_navbar.setText("SignUp Form");
        lbl_navbar.setForeground(Color.WHITE);
        lbl_navbar.setFont(new Font("Serif",Font.BOLD , 23));
        lbl_navbar.setBounds(200,25,200,28);
        pnl_navbar.add(lbl_navbar);

        JPanel pnl_signupForm = new JPanel();
        pnl_signupForm.setLayout(null);
        pnl_signupForm.setBackground(Color.WHITE);
        pnl_signupForm.setBounds(0,75,600,600);
        JLabel lbl_arrow=new JLabel();
        lbl_arrow.setText("←");
        lbl_arrow.setFont(new Font("serif",Font.BOLD,50));
        lbl_arrow.setBounds(20,20,50,30);
        pnl_navbar.add(lbl_arrow);
        lbl_arrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lbl_arrow.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                signupFrame.setVisible(false);
                LoginPage loginPage=new LoginPage();
                loginPage.loginPage(frontFrame);
            }
        });
        JLabel name = new JLabel();
        JTextField nameField = new JTextField();

        name.setText("Name");
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Serif",Font.PLAIN , 18));
        name.setBounds(30,30,80,30);
        pnl_signupForm.add(name);

        nameField.setBounds(190,30,225,30);
        pnl_signupForm.add(nameField);

        JLabel password = new JLabel();


        password.setText("Password");
        password.setForeground(Color.BLACK);
        password.setFont(new Font("Serif",Font.PLAIN , 18));
        password.setBounds(30,100,80,30);
        pnl_signupForm.add(password);

        JPanel passwordPanel = new JPanel(null);
        passwordPanel.setBackground(null);
        passwordPanel.setBounds(190, 100, 250, 30);
        pnl_signupForm.add(passwordPanel);
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

        JLabel confirmPass = new JLabel();


        confirmPass.setText("Confirm Password");
        confirmPass.setForeground(Color.BLACK);
        confirmPass.setFont(new Font("Serif",Font.PLAIN , 18));
        confirmPass.setBounds(30,170,160,30);
        pnl_signupForm.add(confirmPass);

        JPanel confirmPassPanel = new JPanel(null);
        confirmPassPanel.setBackground(null);
        confirmPassPanel.setBounds(190, 170, 250, 30);
        pnl_signupForm.add(confirmPassPanel);
        JPasswordField confirmPassField = new JPasswordField();
        confirmPassField.setBounds(0, 0, 225, 30);
        confirmPassPanel.add(confirmPassField);

        JLabel conPassShowLabel = new JLabel("\uD83D\uDE11\n");
        conPassShowLabel.setFont(new Font(Font.SERIF,Font.BOLD,18));
        conPassShowLabel.setBounds(226, 5, 50, 20); // Positioned inside the password field
        conPassShowLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confirmPassPanel.add(conPassShowLabel);


        conPassShowLabel.addMouseListener(new MouseAdapter() {
            private boolean isPasswordVisible = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPasswordVisible) {
                    confirmPassField.setEchoChar('*');
                    conPassShowLabel.setText("\uD83D\uDE11\n");
                } else {
                    confirmPassField.setEchoChar((char) 0); // Show password
                    conPassShowLabel.setText("\uD83D\uDE10\n");
                }
                isPasswordVisible = !isPasswordVisible;
            }
        });

        JButton btn_signup = new JButton("Register");
        style.ButtonStyle(btn_signup);
        btn_signup.setBackground(new java.awt.Color(30,144,255));
        btn_signup.addMouseListener(new java.awt.event.MouseAdapter()

        {
            @Override
            public void mouseEntered (MouseEvent e){
                btn_signup.setBackground(Color.WHITE);
                btn_signup.setForeground(new java.awt.Color(30,144,255));
            }

            @Override
            public void mouseExited (MouseEvent e){
                btn_signup.setBackground(new java.awt.Color(30,144,255));
                btn_signup.setForeground(Color.WHITE);
            }

        });
        btn_signup.setBounds(200,255,120,35);
        pnl_signupForm.add(btn_signup);
        btn_signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass=new String(passwordField.getPassword()).trim();
                String conPass=new String(confirmPassField.getPassword()).trim();
                if(nameField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(signupFrame,"Enter user name");
                }
                else if(pass.isEmpty())
                {
                    JOptionPane.showMessageDialog(signupFrame,"Enter Password");
                } else if (pass.length()<5||pass.length()>20){
                    JOptionPane.showMessageDialog(null,"Password must contain at least 5 characters \nPassword must have at most 20 characters");

                } else if(!pass.matches("[a-zA-Z0-9]+"))
                {
                    JOptionPane.showMessageDialog(null,"Password can not contain special characters");
                }

                else if(conPass.isEmpty())
                {
                    JOptionPane.showMessageDialog(signupFrame, "Confirm Password!");
                }

                else if (!pass.equals(conPass))
                {
                    JOptionPane.showMessageDialog(signupFrame,"Password does not match");
                }

                else
                {
                    try (Connection connection = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/islamicairlines", "root", ""
                        );
                         PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)"))
                        {
                        preparedStatement.setString(1,nameField.getText());
                        preparedStatement.setString(2,pass);
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Registered Successfully");

                            signupFrame.setVisible(false);
                            LoginPage loginPage=new LoginPage();
                            loginPage.loginPage(frontFrame);

                    } catch (SQLIntegrityConstraintViolationException ex)
                    {
                        JOptionPane.showMessageDialog(null,"Username already registered !\nEnter Unique Name");
                    }
                    catch (SQLException e1)
                    {
                        JOptionPane.showMessageDialog(null,"Error connecting to Database");
                    }

                }
            }
        });
        signupFrame.add(pnl_signupForm);
        signupFrame.setVisible(true);
        return signupFrame;
    }
}

